package br.com.marcos.manutencao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.manutencao.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
