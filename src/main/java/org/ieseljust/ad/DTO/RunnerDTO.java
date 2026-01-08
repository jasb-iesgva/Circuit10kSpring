package org.ieseljust.ad.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

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

	private LocalDateTime data_creacio;

	private LocalDateTime data_modif;

	public static RunnerDTO convertToDTO(Runner runner) {

		RunnerDTO runnerDTO = new RunnerDTO();

		runnerDTO.setId(runner.getId());
		runnerDTO.setNom(runner.getNom());
		runnerDTO.setCognoms(runner.getCognoms());
		runnerDTO.setEdat(runner.getEdat());
		runnerDTO.setDni(runner.getDni());
		runnerDTO.setLocalitat(runner.getLocalitat());
		runnerDTO.setEmail(runner.getEmail());
		//runnerDTO.setData_creacio(runner.getData_creacio());
		//runnerDTO.setData_modif(runner.getData_modif());

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
		//runner.setData_creacio(runnerDTO.getData_creacio());
		//runner.setData_modif(runnerDTO.getData_modif());

		return runner;

	}

}
