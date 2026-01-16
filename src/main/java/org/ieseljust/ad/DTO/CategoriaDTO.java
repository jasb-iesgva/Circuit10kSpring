package org.ieseljust.ad.DTO;

import lombok.Data;
import org.ieseljust.ad.Model.Categoria;
import org.ieseljust.ad.Model.Runner;

@Data
public class CategoriaDTO {

    private Long id;

    private String nom;

    private String descripcio;

    //private List<RunnerDTO> listaRunnersDTO = new ArrayList<>();

    public static CategoriaDTO convertToDTO(Categoria categoria) {

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNom(categoria.getNom());
        categoriaDTO.setDescripcio(categoria.getDescripcio());

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
