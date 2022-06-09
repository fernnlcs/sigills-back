package br.edu.ufersa.pw.sigillsback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.ufersa.pw.sigillsback.entity.User;
import br.edu.ufersa.pw.sigillsback.repository.UserRepository;

@SpringBootApplication
public class SigillsBackApplication {

	// private static final Logger logger = LoggerFactory.getLogger(SigillsBackApplication.class);

	@Autowired
	UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SigillsBackApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			User user = new User();
			user.setName("Example");
			user.setEmail("user@example.com");
			user.setPassword("password");
			this.userRepo.save(user);

			List<User> users = this.userRepo.findAll();

			users.forEach(currentUser -> System.out.println(currentUser.getEmail()));
		};
	}

}
