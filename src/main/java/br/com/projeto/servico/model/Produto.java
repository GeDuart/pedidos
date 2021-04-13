package br.com.projeto.servico.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private Integer status;
	
	@JsonIgnore
	@Column(nullable = false)
	private Date data_criacao;
	
	@JsonIgnore
	@Column(nullable = false)
	private Date data_att;

}
