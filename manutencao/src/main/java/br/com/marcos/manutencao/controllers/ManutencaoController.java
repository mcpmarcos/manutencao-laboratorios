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

import br.com.marcos.manutencao.models.Manutencao;
import br.com.marcos.manutencao.services.ManutencaoService;
import jakarta.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

	@Autowired
	private ManutencaoService service;

	@GetMapping("/start")
	public String home() {
		return "index";
	}

	@GetMapping("/all")
	public List<Manutencao> findAll() {
		return service.findAll();
	}

	@PostMapping("/add")
	public List<Manutencao> add(@RequestBody Manutencao manutencao) {
		manutencao.setDataLancamento(LocalDateTime.now(ZoneId.of("UTC")));
		manutencao.setDataSolicitacao(LocalDateTime.now(ZoneId.of("UTC")));
		service.add(manutencao);
		return findAll();

	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteManutencao(@PathVariable Long id) {
		service.deleteManutencao(id);
		
	}

	@GetMapping("/find/{id}")
	public Manutencao findByIdProfessor(Long id) {
		return service.findManutencaoByProfessor(id);
	}
	
}