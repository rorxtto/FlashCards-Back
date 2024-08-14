package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Materia;
import app.service.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Materia materia){
		
		try {
			
			String mensagem =  this.materiaService.save(materia);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Materia> findById (@PathVariable Long id){
		try {
			
			Materia materia = this.materiaService.findById(id);
			return new ResponseEntity<>(materia, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
