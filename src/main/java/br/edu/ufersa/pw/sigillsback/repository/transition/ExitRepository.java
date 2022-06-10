package br.edu.ufersa.pw.sigillsback.repository.transition;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.transition.Exit;

public interface ExitRepository extends JpaRepository<Exit, Long> {
    
    public Optional<Exit> findById(Long id);
    public void deleteById(Long id);

}
