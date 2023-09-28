package br.com.marcos.manutencao.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.marcos.manutencao.models.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long>{
	
	

	
	
	@Modifying
	@Query(value = "UPDATE Laboratorio l SET l.sigla = :sigla, l.descricao = :descricao, l.equipamento = :equipamento, l.ativo = :ativo, l.dataCadastro = :dataCadastro WHERE l.id = :id")
	void update(long id, String sigla, String descricao, List<String> equipamento, boolean ativo, LocalDateTime dataCadastro);

}
