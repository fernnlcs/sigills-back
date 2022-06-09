package br.edu.ufersa.pw.sigillsback;

import org.modelmapper.ModelMapper;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SigillsBackApplication {

	// private static final Logger logger = LoggerFactory.getLogger(SigillsBackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SigillsBackApplication.class, args);
	}

	@Bean
	public ModelMapper mepper (){
		return new ModelMapper();
	}

}
