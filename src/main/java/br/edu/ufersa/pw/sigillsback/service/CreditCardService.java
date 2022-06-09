package br.edu.ufersa.pw.sigillsback.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.sigillsback.DTO.CreditCardDto;
import br.edu.ufersa.pw.sigillsback.entity.CreditCard;
import br.edu.ufersa.pw.sigillsback.repository.CreditCardRepository;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private ModelMapper mapper;

    public CreditCardDto findByName(String name){
        CreditCard creditCard = repository.findByName(name);
        return mapper.map(creditCard,CreditCardDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CreditCardDto save(CreditCard creditCard){
        CreditCard card = new CreditCard();
        card.setName(creditCard.getName());
        card.setUser(creditCard.getUser());
        card.setDueDate(creditCard.getDueDate());
        card.setClosingDate(creditCard.getClosingDate());
        return mapper.map(repository.save(card),CreditCardDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteByName(CreditCardDto creditCard){
        repository.deleteByName(creditCard.getName());
    }
    
}
