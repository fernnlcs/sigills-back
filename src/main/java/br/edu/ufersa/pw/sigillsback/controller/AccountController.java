package br.edu.ufersa.pw.sigillsback.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.pw.sigillsback.DTO.AccountDto;
import br.edu.ufersa.pw.sigillsback.entity.Account;
import br.edu.ufersa.pw.sigillsback.repository.AccountRepository;
import br.edu.ufersa.pw.sigillsback.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountRepository repository;
    @Autowired
    AccountService service;

    @GetMapping("search/byName")
    public AccountDto getByName(@Param("name") String name){
        return service.findByName(name);
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@Valid @RequestBody Account account){
        AccountDto dto = service.save(account);

        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name){
        AccountDto dto = new AccountDto();
        dto.setName(name);

        try {
            service.deleteByEmail(dto);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
