package org.ieseljust.ad.DTO;

import lombok.Data;
import org.ieseljust.ad.Model.Carrera;

@Data
public class CarreraDTO {

    private Long id;
    
    private String nom;
    
    private String localitat;
    
    private int distancia;

    private int num_participants;

    public static CarreraDTO convertToDTO(Carrera Carrera) {

        CarreraDTO CarreraDTO = new CarreraDTO();

        CarreraDTO.setId(Carrera.getId());
        CarreraDTO.setNom(Carrera.getNom());
        CarreraDTO.setLocalitat(Carrera.getLocalitat());
        CarreraDTO.setDistancia(Carrera.getDistancia());
        CarreraDTO.setNum_participants(Carrera.getNum_participants());

        return CarreraDTO;
    }
}
