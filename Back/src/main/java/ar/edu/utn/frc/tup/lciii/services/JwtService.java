package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String generateToken(Authentication auth);
    String extractUsername(String token);
    boolean validateToken(String token, UserDetails userDetails);
}
