package org.ieseljust.ad.Service;

import java.util.List;

import org.ieseljust.ad.DTO.RunnerDTO;

public interface RunnerService {
	
	void saveRunner(RunnerDTO runnerDTO);
	
	RunnerDTO getRunnerById(Long id);
	
    List<RunnerDTO> listAllRunners();
    
    void deleteRunner(Long id);

}
