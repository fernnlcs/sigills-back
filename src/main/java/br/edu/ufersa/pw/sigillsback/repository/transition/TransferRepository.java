package br.edu.ufersa.pw.sigillsback.repository.transition;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.transition.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    
}
