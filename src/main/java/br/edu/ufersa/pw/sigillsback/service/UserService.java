package br.edu.ufersa.pw.sigillsback.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.sigillsback.DTO.CreatedUserDto;
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

    public Optional<UserDto> findByUuid(String uuid){
        Optional<User> user = repository.findByUuid(UUID.fromString(uuid));
        if (user.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(user.get(),UserDto.class));
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UserDto save(User users){
        User user = new User();
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        user.setName(users.getName());

        return mapper.map(repository.save(user),UserDto.class);
    }

    public Optional<UserDto> update(String uuid, CreatedUserDto dto) {
        Optional<User> user = repository.findByUuid(UUID.fromString(uuid));
        if (user.isEmpty()) {
          return Optional.empty();
        }
    
        user.get().setName(dto.getName());
        user.get().setPassword(dto.getPassword());
    
        return Optional.of(mapper.map(repository.save(user.get()), UserDto.class));
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteByEmail(UserDto user){
        repository.deleteByEmail(user.getEmail());
    }

}
