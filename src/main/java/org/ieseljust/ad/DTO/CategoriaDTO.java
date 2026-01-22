package org.ieseljust.ad.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.ieseljust.ad.Model.Categoria;
import org.ieseljust.ad.Model.Runner;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriaDTO {

    private Long id;

    private String nom;

    private String descripcio;

    @JsonManagedReference
    private List<RunnerDTO> listaRunnersDTO = new ArrayList<>();

    public static CategoriaDTO convertToDTO(Categoria categoria) {

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNom(categoria.getNom());
        categoriaDTO.setDescripcio(categoria.getDescripcio());

        if (categoria.getListaRunners() != null)
        {

            for (int i = 0; i < categoria.getListaRunners().size() - 1; i++)
            {
                RunnerDTO rdto = new RunnerDTO();
                rdto = RunnerDTO.convertToDTO_WCat(categoria.getListaRunners().get(i),categoriaDTO);

                categoriaDTO.listaRunnersDTO.add(rdto);
            }
        }

        return categoriaDTO;

    }

    public static Categoria convertToEntity(CategoriaDTO categoriaDTO) {

        Categoria categoria = new Categoria();

        categoria.setId(categoriaDTO.getId());
        categoria.setNom(categoriaDTO.getNom());
        categoria.setDescripcio(categoriaDTO.getDescripcio());

        return categoria;

    }

}
