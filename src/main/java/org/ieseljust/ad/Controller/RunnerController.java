package org.ieseljust.ad.Controller;

import java.util.List;

import org.ieseljust.ad.DTO.RunnerDTO;
import org.ieseljust.ad.Service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class RunnerController {
	
	@Autowired
	RunnerService runnerService;
	
	@GetMapping("/")
    public String helloWorld() {
        return "Benvinguts al Circuit 10k de La Safor";
    }
	
	@GetMapping("/corredors")
    public ResponseEntity<List<RunnerDTO>> getTotsCorredors() {

        List<RunnerDTO> corredors = runnerService.listAllRunners();

        if (corredors != null)
            return new ResponseEntity<>(corredors, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/corredors/menors/{edat}")
    public ResponseEntity<List<RunnerDTO>> getMenors(@PathVariable int edat) {

        List<RunnerDTO> corredors = runnerService.listAllRunnersMenorsEdat(edat);

        if (corredors.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(corredors, HttpStatus.OK);
    }

	@GetMapping("/corredor/id/{idRunner}")
    public ResponseEntity<RunnerDTO> getCorredor(@PathVariable Long idRunner) {
        RunnerDTO rdto = runnerService.getRunnerById(idRunner);

        if (rdto != null)
            return new ResponseEntity<>(rdto, HttpStatus.OK);
		else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
    }

    @GetMapping("/corredor/nom/{name}/cognoms/{cognoms}")
    public ResponseEntity<RunnerDTO> getCorredor(@PathVariable String name,
                                                 @PathVariable String cognoms) {
        RunnerDTO rdto = runnerService.getRunnerByNomYCognoms(name, cognoms);

        if (rdto != null)
            return new ResponseEntity<>(rdto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
	
	@PostMapping("/newcorredor")
    public void getCorredor(@RequestBody RunnerDTO runnerDTO ) {         

        runnerService.saveRunner(runnerDTO);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleError(MethodArgumentTypeMismatchException e) {
        //myLog.warn("Method Argument Type Mismatch", e);
        String message = String.format("El format de l'argument no és correcte: %s", e.getName());
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
