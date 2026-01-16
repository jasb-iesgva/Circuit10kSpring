package org.ieseljust.ad.Controller;

import org.ieseljust.ad.DTO.CategoriaDTO;
import org.ieseljust.ad.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
    
	@GetMapping("/categories")
    public List<CategoriaDTO> getTotsCategories() {
             
		return categoriaService.listAllCategorias();
		
    }

	@GetMapping("/categoria/id/{idCategoria}")
    public ResponseEntity<CategoriaDTO> getcategoria(@PathVariable Long idCategoria) {
        CategoriaDTO cdto = categoriaService.getCategoriaById(idCategoria);

        if (cdto != null)
            return new ResponseEntity<>(cdto, HttpStatus.OK);
		else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
    }

    @GetMapping("/categoria/nom/{name}")
    public ResponseEntity<CategoriaDTO> getcategoria(@PathVariable String name) {
        CategoriaDTO cdto = categoriaService.getCategoriaByNom(name);

        if (cdto != null)
            return new ResponseEntity<>(cdto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
	
	@PostMapping("/newcategoria")
    public void getcategoria(@RequestBody CategoriaDTO CategoriaDTO ) {

        categoriaService.saveCategoria(CategoriaDTO);
    }



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleError(MethodArgumentTypeMismatchException e) {
        //myLog.warn("Method Argument Type Mismatch", e);
        String message = String.format("El format de l'argument no és correcte: %s", e.getName());
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
