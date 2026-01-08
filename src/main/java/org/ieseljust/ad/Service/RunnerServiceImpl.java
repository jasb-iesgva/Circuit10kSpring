package org.ieseljust.ad.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ieseljust.ad.DTO.RunnerDTO;
import org.ieseljust.ad.Model.Runner;
import org.ieseljust.ad.Repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnerServiceImpl implements RunnerService{
	
	@Autowired
	RunnerRepository runnerRepository;

	@Override
	public List<RunnerDTO> listAllRunners() {
		
		List<Runner> runners = runnerRepository.findAll();
		
		List<RunnerDTO> elsCorredors = new ArrayList<>();
		
		//Conversio de Runner a RunnerDTO
		for (Runner r : runners)
		{
			elsCorredors.add(RunnerDTO.convertToDTO(r));
		}
		
		return elsCorredors;
	}
	
	
	
	
	
	@Override
	public void saveRunner(RunnerDTO runnerDTO) {
		runnerRepository.save(RunnerDTO.convertToEntity(runnerDTO));	
	}

	@Override
	public RunnerDTO getRunnerById(Long id) {
		
		RunnerDTO elCorredor = new RunnerDTO();
		
		Optional<Runner> r = runnerRepository.findById(id);
		
		if (r.isPresent()) {
			return RunnerDTO.convertToDTO(r.get());	
		}
		
		
		return null;
	}

	

	@Override
	public void deleteRunner(Long id) {
		// TODO Auto-generated method stub
		
	}

}
