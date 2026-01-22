package org.ieseljust.ad.Service;

import org.ieseljust.ad.DTO.CarreraDTO;
import org.ieseljust.ad.DTO.CategoriaDTO;

import java.util.List;

public interface CarreraService {

    CarreraDTO getCarreraById(Long id);

    List<CarreraDTO> getCarreraByLocalitat(String n);
	
    List<CarreraDTO> listAllCarreras();

}
