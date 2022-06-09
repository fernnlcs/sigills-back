package br.edu.ufersa.pw.sigillsback.repository.transition;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.transition.Exit;

public interface ExitRepository extends JpaRepository<Exit, Long> {
    
}
