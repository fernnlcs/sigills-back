package br.edu.ufersa.pw.sigillsback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.edu.ufersa.pw.sigillsback.entity.CreditCard;

@RepositoryRestResource
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    public Optional<CreditCard> findById(Long id);
    public void deleteById(Long id);

    
}
