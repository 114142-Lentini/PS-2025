package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.services.MercadoPagoService;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class MercadoPagoServiceImpl implements MercadoPagoService {
    public Preference createPreference(String title, BigDecimal unitPrice, int quantity) throws MPException, MPApiException {
        PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                .title(title)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .currencyId("ARS") // O la moneda que uses
                .build();

        // Configurar las URLs de retorno
        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("http://localhost:4200/pago-exitoso")
                .pending("http://localhost:4200/pago-pendiente")
                .failure("http://localhost:4200/pago-fallido")
                .build();

        // Armar la preferencia
        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(List.of(itemRequest))
                .backUrls(backUrls)
                .build();

        PreferenceClient client = new PreferenceClient();
        return client.create(preferenceRequest);
    }
}
