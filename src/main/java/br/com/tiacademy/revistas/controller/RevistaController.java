package br.com.tiacademy.revistas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.revistas.domain.Revista;
import br.com.tiacademy.revistas.service.RevistaService;

@RestController
@RequestMapping("/revista")
public class RevistaController {
	
	@Autowired
	private RevistaService revistaService;
	
	@GetMapping
	public ResponseEntity<List<Revista>> listar(){
		var revistas = revistaService.listar();
		return ResponseEntity.ok(revistas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Revista> especifico(@PathVariable("id") Long id){
		var resultado = revistaService.porId(id);
		
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Revista> criar(@RequestBody Revista revista){
		var salvo = revistaService.criar(revista);
		return ResponseEntity.ok(salvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Revista> editar(@RequestBody Revista revista, @PathVariable("id") Long id){
		return ResponseEntity.ok(revistaService.editar(id, revista));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		revistaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
