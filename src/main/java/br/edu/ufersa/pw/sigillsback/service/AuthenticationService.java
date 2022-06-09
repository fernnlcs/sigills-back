package br.edu.ufersa.pw.sigillsback.service;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
    static final long EXPIRATION_TIME = 86_400_000;
    static final String SIGNIN_KEY = "SecretKey";
    static final String PREFIX = "Bearer";

    static public void addToken(HttpServletResponse response, String email) {
        String token = Jwts.builder().setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SIGNIN_KEY)
                .compact();

        response.addHeader("Authorization", PREFIX + " " + token);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            String email = Jwts.parser()
            .setSigningKey(SIGNIN_KEY)
            .parseClaimsJws(token.replace(PREFIX, ""))
            .getBody()
            .getSubject();

            if (email != null) {
                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
            }
        }

        return null;
    }
}
