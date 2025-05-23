package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.UserDTO;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole()); // Cliente o Empleado
        UserEntity userSaved = repository.save(user);
        return modelMapper.map(userSaved, UserDTO.class);
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findByEmail(String email) {
        return modelMapper.map(repository.findByEmail(email), UserDTO.class);
    }
    @Override
    public UserDTO downUser(String email) {
        Optional<UserEntity> user = repository.findByEmail(email);
        if(user.isPresent()) {
            user.get().setState("Inactivo");
            UserEntity userSaved = repository.save(user.get());
            return modelMapper.map(userSaved, UserDTO.class);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario");
        }
    }
    @Override
    public UserDTO changePassword (String password, String email) {
        Optional<UserEntity> user = repository.findByEmail(email);
        if(user.isPresent()) {
            user.get().setPassword(password);
            UserEntity userSaved = repository.save(user.get());
            return modelMapper.map(userSaved, UserDTO.class);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario");
        }
    }
}
