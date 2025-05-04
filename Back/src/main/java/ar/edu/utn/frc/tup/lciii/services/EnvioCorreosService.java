package ar.edu.utn.frc.tup.lciii.services;

import org.springframework.stereotype.Service;

@Service
public interface EnvioCorreosService {
    void enviarCorreo(String para, String asunto, String cuerpo);
}
