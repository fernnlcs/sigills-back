package br.edu.ufersa.pw.sigillsback.repository.transition;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.sigillsback.entity.transition.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    
}
