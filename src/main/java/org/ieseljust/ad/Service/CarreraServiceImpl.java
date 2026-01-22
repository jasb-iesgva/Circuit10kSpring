package org.ieseljust.ad.Service;

import org.ieseljust.ad.DTO.CarreraDTO;
import org.ieseljust.ad.DTO.CategoriaDTO;
import org.ieseljust.ad.Model.Carrera;
import org.ieseljust.ad.Repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    CarreraRepository carreraRepository;
    

    @Override
    public CarreraDTO getCarreraById(Long id) {

        Optional<Carrera> c = carreraRepository.findById(id);

        if (c.isPresent()) {
            return CarreraDTO.convertToDTO(c.get());
        }

        return null;
    }

    @Override
    public List<CarreraDTO> getCarreraByLocalitat(String n) {

        List<Carrera> carreres = carreraRepository.findByLocalitatContainsIgnoreCase(n);

        List<CarreraDTO> lescarreresDTO = new ArrayList<>();

        //Conversio de Carrera a CarreraDTO
        for (Carrera c : carreres)
        {
            lescarreresDTO.add(CarreraDTO.convertToDTO(c));
        }

        return lescarreresDTO;
    }

    @Override
    public List<CarreraDTO> listAllCarreras() {
        List<Carrera> carreres = carreraRepository.findAll();

        List<CarreraDTO> lescarreresDTO = new ArrayList<>();

        //Conversio de Carrera a CarreraDTO
        for (Carrera c : carreres)
        {
            lescarreresDTO.add(CarreraDTO.convertToDTO(c));
        }

        return lescarreresDTO;
    }

}
