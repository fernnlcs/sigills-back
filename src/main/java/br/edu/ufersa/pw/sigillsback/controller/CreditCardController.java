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

import br.edu.ufersa.pw.sigillsback.DTO.CreditCardDto;
import br.edu.ufersa.pw.sigillsback.entity.CreditCard;
import br.edu.ufersa.pw.sigillsback.repository.CreditCardRepository;
import br.edu.ufersa.pw.sigillsback.service.CreditCardService;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {

    CreditCardRepository repository;
    @Autowired
    CreditCardService service;

    @GetMapping("search/byName")
    public CreditCardDto getByName(@Param("name") String name){
        return service.findByName(name);
    }

    @PostMapping
    public ResponseEntity<CreditCardDto> save(@Valid @RequestBody CreditCard creditCard){
        CreditCardDto dto = service.save(creditCard);

        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name){
        CreditCardDto dto = new CreditCardDto();
        dto.setName(name);

        try {
            service.deleteByName(dto);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
