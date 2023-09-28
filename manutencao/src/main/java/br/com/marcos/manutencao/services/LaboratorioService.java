package br.com.marcos.manutencao.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.manutencao.models.Laboratorio;
import br.com.marcos.manutencao.repositories.LaboratorioRepository;
import jakarta.transaction.Transactional;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository repository;

	public void addLab(Laboratorio laboratorio) {
		repository.save(laboratorio);
	}
	
	@Transactional
	public void updateLab(long id, String sigla, String descricao, 
			List<String> equipamento, boolean ativo, LocalDateTime dataCadastro) {
		repository.update(id, sigla, descricao, equipamento, ativo, dataCadastro);
	}

	public void deleteLab(Long id) {
		repository.deleteById(id);

	}

	public List<Laboratorio> findAllLabs() {
		return repository.findAll();
	}

}
