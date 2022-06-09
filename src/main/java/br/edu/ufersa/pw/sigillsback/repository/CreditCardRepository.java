package br.edu.ufersa.pw.sigillsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    CreditCard findByName(String name);
    public void deleteByName(String name);
    
}
