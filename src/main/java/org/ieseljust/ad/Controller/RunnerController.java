package org.ieseljust.ad.Controller;

import java.util.List;

import org.ieseljust.ad.DTO.RunnerDTO;
import org.ieseljust.ad.Service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunnerController {
	
	@Autowired
	RunnerService runnerService;
	
	@GetMapping("/")
    public String helloWorld() {
        return "Benvinguts al Circuit 10k de La Safor";
    }
	
	@GetMapping("/corredors")
    public List<RunnerDTO> getTotsCorredors() {
             
		return runnerService.listAllRunners(); 
		
    }

	@GetMapping("/corredor/{idRunner}")
    public RunnerDTO getCorredor(@PathVariable Long idRunner) {
             
		return runnerService.getRunnerById(idRunner);
		
    }
	
	@PostMapping("/newcorredor")
    public void getCorredor(@RequestBody RunnerDTO runnerDTO ) {         
		runnerService.saveRunner(runnerDTO);		
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
