package br.edu.ufersa.pw.sigillsback.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.sigillsback.DTO.AccountDto;
import br.edu.ufersa.pw.sigillsback.entity.Account;
import br.edu.ufersa.pw.sigillsback.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper mapper;

    public AccountDto findByName(String name){
        Account account = repository.findByName(name);
        return mapper.map(account,AccountDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AccountDto save(Account account){
        Account accoun = new Account();
        accoun.setName(account.getName());
        accoun.setType(account.getType());
        accoun.setUser(account.getUser());
        
        return mapper.map(repository.save(accoun),AccountDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteByEmail(AccountDto account){
        repository.deleteByName(account.getName());
    }
    
}
