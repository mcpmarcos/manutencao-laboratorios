package br.com.marcos.manutencao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.manutencao.models.Professor;
import br.com.marcos.manutencao.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;

	
	public void addProfessor(List<Professor> professores) {
		for (Professor professor : professores) {
			repository.save(professor);
		}
	}
	
	public List<Professor> findAll() {
		return repository.findAll();
	}
	
	public void deleteProfessor(Long id) {
		repository.deleteById(id);

	}
}
