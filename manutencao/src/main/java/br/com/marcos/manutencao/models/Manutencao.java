package br.com.marcos.manutencao.models;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "professor_id")
	private Professor solicitante;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "laboratorio")
	private Laboratorio laboratorio;
	
	private LocalDateTime dataSolicitacao;
	@NonNull
	private boolean status;

	private LocalDateTime dataLancamento;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Professor getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Professor solicitante) {
		this.solicitante = solicitante;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSoliocitacao) {
		this.dataSolicitacao = dataSoliocitacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Long getId() {
		return id;
	}
}
