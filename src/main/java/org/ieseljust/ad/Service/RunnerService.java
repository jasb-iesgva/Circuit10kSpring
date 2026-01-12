package org.ieseljust.ad.Service;

import java.util.List;

import org.ieseljust.ad.DTO.RunnerDTO;

public interface RunnerService {
	
	void saveRunner(RunnerDTO runnerDTO);
	
	RunnerDTO getRunnerById(Long id);

    RunnerDTO getRunnerByNomYCognoms(String n, String c);
	
    List<RunnerDTO> listAllRunners();

    List<RunnerDTO> listAllRunnersMenorsEdat(int e);
    
    void deleteRunner(Long id);

}
