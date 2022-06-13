package br.edu.ufersa.pw.sigillsback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<AccountDto> findAll() {
        List<AccountDto> list = new ArrayList<AccountDto>();
        
        for (Account account : repository.findAll()) {
            list.add(mapper.map(account,AccountDto.class));
        }
    
        return list;
      }

    public Optional<AccountDto> findById(String id){
        Optional<Account> account = repository.findById(Long.valueOf(id));
        if (account.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(account.get(),AccountDto.class));
    }

    public AccountDto add(Account account){
        Account accoun = new Account();
        accoun.setName(account.getName());
        accoun.setType(account.getType());
        accoun.setUser(account.getUser());
        
        return mapper.map(repository.save(accoun),AccountDto.class);
    }

    public Optional<AccountDto> update(String id, Account accountReceived){
        Optional<Account> account = repository.findById(Long.valueOf(id));
        if (account.isEmpty()) {
          return Optional.empty();
        }
    
        account.get().setName(accountReceived.getName());
        account.get().setType(accountReceived.getType());
    
        return Optional.of(mapper.map(repository.save(account.get()), AccountDto.class));

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(AccountDto account){
        repository.deleteById(account.getId());
    }
    
}
