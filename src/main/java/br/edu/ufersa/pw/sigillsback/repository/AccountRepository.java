package br.edu.ufersa.pw.sigillsback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.ufersa.pw.sigillsback.entity.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findById(Long id);
    public void deleteById(Long id);
    
}
