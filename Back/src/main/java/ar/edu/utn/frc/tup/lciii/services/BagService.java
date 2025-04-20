package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Bag;
import ar.edu.utn.frc.tup.lciii.models.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BagService {
    List<Bag> getAllBags();
    Sale sellBag(Integer numberToSell);
}
