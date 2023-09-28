package br.com.marcos.manutencao.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.manutencao.models.Laboratorio;
import br.com.marcos.manutencao.services.LaboratorioService;

@RestController
@RequestMapping("/lab")
public class LaboratorioController {

	@Autowired
	LaboratorioService service;

	@PostMapping("/add")
	public List<Laboratorio> addLab(@RequestBody Laboratorio laboratorio) {
		service.addLab(laboratorio);
		laboratorio.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
		return findAllLabs();
	}

	@GetMapping("/all")
	public List<Laboratorio> findAllLabs() {
		return service.findAllLabs();
	}

	@PutMapping("/update/{id}")
	public Laboratorio updateLab(@PathVariable Long id, @RequestBody Laboratorio labAtualizado) {
		service.updateLab(id, labAtualizado.getSigla(), labAtualizado.getDescricao(), labAtualizado.getEquipamento(),
				labAtualizado.isAtivo(), labAtualizado.getDataCadastro());
		return labAtualizado;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteLab(@PathVariable Long id) {
		service.deleteLab(id);

	}

}
