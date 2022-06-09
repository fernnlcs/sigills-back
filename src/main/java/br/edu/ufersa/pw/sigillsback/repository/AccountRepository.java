package br.edu.ufersa.pw.sigillsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByName(String name);
    public void deleteByName(String name);
    
}
