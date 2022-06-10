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

import br.edu.ufersa.pw.sigillsback.DTO.CreditCardDto;
import br.edu.ufersa.pw.sigillsback.entity.CreditCard;
import br.edu.ufersa.pw.sigillsback.service.CreditCardService;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {

    @Autowired
    CreditCardService service;

    @GetMapping
    public List<CreditCardDto> findAll(){
        return service.findAll();
    }

    @GetMapping("search/byId")
    public ResponseEntity<CreditCardDto> getById(@Param("id") String id){
        Optional<CreditCardDto> creditCard = service.findById(id);
        
        if (creditCard.isPresent()){
            return ResponseEntity.ok(creditCard.get());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CreditCardDto> add(@Valid @RequestBody CreditCard creditCard){
        CreditCardDto dto = service.save(creditCard);

        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id){
        CreditCardDto dto = new CreditCardDto();
        dto.setId(id);

        try {
            service.deleteByName(dto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
