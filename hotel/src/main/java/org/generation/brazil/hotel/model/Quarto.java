package org.generation.brazil.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_quarto")
public class Quarto {
	// atributors
	@Column(name = "cd_quarto")
	@Id
	private Integer numeroQuarto;
	
	@Column(name = "qt_cama", nullable = false)
	private Integer qtdCama;

	// getters - setters
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Integer getQtdCama() {
		return qtdCama;
	}

	public void setQtdCama(Integer qtdCama) {
		this.qtdCama = qtdCama;
	}

	
}
