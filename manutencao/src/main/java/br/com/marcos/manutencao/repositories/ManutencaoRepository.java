package br.com.marcos.manutencao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.marcos.manutencao.models.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

	@Query(value = "SELECT * FROM manutencao WHERE professor_id = :id", nativeQuery = true)
	Manutencao findManutencaoByProfessor(@Param("id") Long id);

}
