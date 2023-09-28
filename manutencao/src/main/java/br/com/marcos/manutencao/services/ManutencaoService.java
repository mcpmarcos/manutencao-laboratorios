package br.com.marcos.manutencao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.manutencao.models.Manutencao;
import br.com.marcos.manutencao.repositories.LaboratorioRepository;
import br.com.marcos.manutencao.repositories.ManutencaoRepository;
import br.com.marcos.manutencao.repositories.ProfessorRepository;

@Service
public class ManutencaoService {
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public List<Manutencao> findAll() {
		return manutencaoRepository.findAll();
	}

	public List<Manutencao> add(Manutencao manutencao) {
		manutencao.setSolicitante(professorRepository.findById(manutencao.getSolicitante().getId()).get());
		manutencao.setLaboratorio(laboratorioRepository.findById(manutencao.getLaboratorio().getId()).get());
		manutencaoRepository.save(manutencao);
		return findAll();
	}
	
	public void deleteManutencao(Long id) {
		manutencaoRepository.deleteById(id);

	}

	public Manutencao findManutencaoByProfessor(Long id) {
		return manutencaoRepository.findManutencaoByProfessor(id);
	}	
	
	
}
