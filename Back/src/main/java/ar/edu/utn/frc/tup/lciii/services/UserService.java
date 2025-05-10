package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.UserDTO;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);
    UserDTO findByEmail(String email);
}
