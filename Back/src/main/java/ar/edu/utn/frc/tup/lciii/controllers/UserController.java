package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.UserDTO;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userService.registerUser(userDTO);
        return ResponseEntity.ok(userDTO1);
    }
    @GetMapping("/redirect-rol")
    public String redirectByRole(Authentication authentication) {
        if (authentication == null || authentication.getAuthorities() == null) {
            return "redirect:/login?error";
        }

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        boolean isCliente = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_CLIENTE"));

        if (isAdmin) {
            return "redirect:/admin/dashboard"; // Cambialo según tu ruta
        } else if (isCliente) {
            return "redirect:/cliente/home"; // Cambialo según tu ruta
        }

        return "redirect:/login?error";
    }
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String email = authentication.getName(); // Este es el username/email extraído del token
        UserDTO user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
