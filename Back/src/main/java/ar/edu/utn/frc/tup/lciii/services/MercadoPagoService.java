package ar.edu.utn.frc.tup.lciii.services;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface MercadoPagoService {
    Preference createPreference(String title, BigDecimal unitPrice, int quantity) throws MPException, MPApiException;
}
