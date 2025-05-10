package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.services.EnvioCorreosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioCorreosServiceImpl implements EnvioCorreosService {

    @Autowired
    private JavaMailSender mailSender;

    private final String emailFrom = "enviocorreos12345@gmail.com";

    @Override
    public void enviarCorreo(String para, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(para);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mensaje.setFrom(emailFrom);

        mailSender.send(mensaje);
    }
}
