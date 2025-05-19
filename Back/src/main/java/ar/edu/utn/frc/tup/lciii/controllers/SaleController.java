package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.SaleDto;
import ar.edu.utn.frc.tup.lciii.models.Sale;
import ar.edu.utn.frc.tup.lciii.services.MercadoPagoService;
import ar.edu.utn.frc.tup.lciii.services.SaleService;
import ar.edu.utn.frc.tup.lciii.services.impl.EnvioCorreosServiceImpl;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("Sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private EnvioCorreosServiceImpl emailService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MercadoPagoService mercadoPagoService;


    public ResponseEntity<SaleDto> registerSale(@RequestBody SaleDto saleDto) {
        Sale sale = saleService.registerSale(saleDto);
        return ResponseEntity.ok(modelMapper.map(sale, SaleDto.class));
    }


    @PostMapping("/enviar")
    public String enviarCorreo(
            @RequestParam String destinatario,
            @RequestParam String asunto,
            @RequestParam String mensaje) {
        emailService.enviarCorreo(destinatario, asunto, mensaje);
        return "Correo enviado con éxito";
    }
    @PostMapping("/crear-preferencia")
    public Preference createPreference(@RequestParam String title,
                                       @RequestParam BigDecimal unitPrice,
                                       @RequestParam Integer quantity) throws MPException, MPApiException {
        return mercadoPagoService.createPreference(title, unitPrice, quantity);
    }
    @GetMapping("/historial-ventas")
    public ResponseEntity<List<SaleDto>> getSalesById(@RequestParam Long id) {
        List<Sale> sales = saleService.findByGenerator(id);
        List<SaleDto> saleDtos = new ArrayList<>();
        for (Sale sale : sales) {
            saleDtos.add(modelMapper.map(sale, SaleDto.class));
        }
        return ResponseEntity.ok(saleDtos);
    }
}
