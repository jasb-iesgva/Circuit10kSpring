package org.ieseljust.ad.Controller;

import org.ieseljust.ad.DTO.CarreraDTO;
import org.ieseljust.ad.Service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
public class CarreraController {
	
	@Autowired
	CarreraService carreraService;
    
	@GetMapping("/carreras")
    public ResponseEntity<List<CarreraDTO>> getTotsCategories() {

        List<CarreraDTO> lesCarreres = carreraService.listAllCarreras();

        if (lesCarreres != null)
            return new ResponseEntity<>(lesCarreres, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@GetMapping("/carrera/id/{idCarrera}")
    public ResponseEntity<CarreraDTO> getCarrera(@PathVariable Long idCarrera) {
        CarreraDTO cdto = carreraService.getCarreraById(idCarrera);

        if (cdto != null)
            return new ResponseEntity<>(cdto, HttpStatus.OK);
		else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/carreras/localitat/{name}")
    public ResponseEntity<List<CarreraDTO>> getCarrera(@PathVariable String name) {
        List<CarreraDTO> lesCarreres = carreraService.getCarreraByLocalitat(name);

        if (lesCarreres != null)
            return new ResponseEntity<>(lesCarreres, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleError(MethodArgumentTypeMismatchException e) {
        //myLog.warn("Method Argument Type Mismatch", e);
        String message = String.format("El format de l'argument no és correcte: %s", e.getName());
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
