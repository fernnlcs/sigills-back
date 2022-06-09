package br.edu.ufersa.pw.sigillsback.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.sigillsback.DTO.UserDto;
import br.edu.ufersa.pw.sigillsback.entity.User;
import br.edu.ufersa.pw.sigillsback.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    public UserDto findByEmail(String email){
        User user = repository.findByEmail(email);
        return mapper.map(user,UserDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UserDto save(User users){
        User user = new User();
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        user.setName(users.getName());

        return mapper.map(repository.save(user),UserDto.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteByEmail(UserDto user){
        repository.deleteByEmail(user.getEmail());
    }
    
}
