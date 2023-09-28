package br.com.marcos.manutencao.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.manutencao.models.Professor;
import br.com.marcos.manutencao.services.ProfessorService;

@RestController
@RequestMapping("/prof")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	@PostMapping("/add")
	public void addProfessor(@RequestBody List<Professor> professores) {
		for (Professor professor : professores) {
			professor.setDataLancamento(LocalDateTime.now(ZoneId.of("UTC")));
		}
		service.addProfessor(professores);
	}
	
	@GetMapping("/all")
	public List<Professor> findAllProfessor(){		
		return service.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProfessor(@PathVariable Long id) {
		service.deleteProfessor(id);
		
	}
	
}
