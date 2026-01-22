package org.ieseljust.ad.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.ieseljust.ad.Model.Categoria;
import org.ieseljust.ad.Model.Runner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class RunnerDTO implements Serializable {

	static final long serialVersionUID = 17L;

	private Long id;

	private String dni;

	private String nom;

	private String cognoms;

	private int edat;

	private String localitat;

	private String email;

	@JsonBackReference
	private CategoriaDTO categoriaDTO;

	public static RunnerDTO convertToDTO(Runner runner) {

		RunnerDTO runnerDTO = new RunnerDTO();

		runnerDTO.setId(runner.getId());
		runnerDTO.setNom(runner.getNom());
		runnerDTO.setCognoms(runner.getCognoms());
		runnerDTO.setEdat(runner.getEdat());
		runnerDTO.setDni(runner.getDni());
		runnerDTO.setLocalitat(runner.getLocalitat());
		runnerDTO.setEmail(runner.getEmail());

		if (runner.getCategoria() != null)
		{
			runnerDTO.setCategoriaDTO(CategoriaDTO.convertToDTO(runner.getCategoria()));
		}

		return runnerDTO;

	}

	public static RunnerDTO convertToDTO_WCat(Runner runner, CategoriaDTO categoriadto) {

		RunnerDTO runnerDTO = new RunnerDTO();

		runnerDTO.setId(runner.getId());
		runnerDTO.setNom(runner.getNom());
		runnerDTO.setCognoms(runner.getCognoms());
		runnerDTO.setEdat(runner.getEdat());
		runnerDTO.setDni(runner.getDni());
		runnerDTO.setLocalitat(runner.getLocalitat());
		runnerDTO.setEmail(runner.getEmail());

		runnerDTO.setCategoriaDTO(categoriadto);


		return runnerDTO;

	}

	public static Runner convertToEntity(RunnerDTO runnerDTO) {

		Runner runner = new Runner();

		runner.setId(runnerDTO.getId());
		runner.setNom(runnerDTO.getNom());
		runner.setCognoms(runnerDTO.getCognoms());
		runner.setEdat(runnerDTO.getEdat());
		runner.setDni(runnerDTO.getDni());
		runner.setLocalitat(runnerDTO.getLocalitat());
		runner.setEmail(runnerDTO.getEmail());

		return runner;

	}

}
