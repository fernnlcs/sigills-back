package br.edu.ufersa.pw.sigillsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.ufersa.pw.sigillsback.entity.User;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    public void deleteByEmail(String email);
}
