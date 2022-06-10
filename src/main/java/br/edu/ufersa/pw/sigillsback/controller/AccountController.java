package br.edu.ufersa.pw.sigillsback.controller;

import java.util.List;
import java.util.Optional;

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
import br.edu.ufersa.pw.sigillsback.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;
    
    @GetMapping
    public List<AccountDto> listar() {
    return service.listarTodos();
  }


    @GetMapping("search/byId")
    public ResponseEntity<AccountDto> getById(@Param("id") String id) {
    Optional<AccountDto> account = service.findById(id);
    
    if (account.isPresent()){
        return ResponseEntity.ok(account.get());
    }else{
        return ResponseEntity.badRequest().build();
    }
      
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteByName(@PathVariable Long id){
        AccountDto dto = new AccountDto();
        dto.setId(id);

        try {
            service.deleteById(dto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
