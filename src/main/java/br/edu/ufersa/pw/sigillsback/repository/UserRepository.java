package br.edu.ufersa.pw.sigillsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
