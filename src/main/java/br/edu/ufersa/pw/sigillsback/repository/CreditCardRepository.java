package br.edu.ufersa.pw.sigillsback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.ufersa.pw.sigillsback.entity.CreditCard;

@RepositoryRestResource
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    CreditCard findByName(String name);
    public void deleteByName(String name);
    
}
