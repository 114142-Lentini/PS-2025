package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.services.withdrawalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class withdrawalServiceImpl implements withdrawalService {
    @Autowired
    private ModelMapper modelMapper;
}
