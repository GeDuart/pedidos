package br.com.pedidos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;


@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private String cep;
	private String endereco;
	
	@Column(nullable = false)
	private String email_principal;
	
	@Column(nullable = false)
	private Integer status;
	
	@JsonIgnore
	@Column(nullable = false)
	private Date data_criacao;
	
	@JsonIgnore
	@Column(nullable = false)
	private Date data_att;

}
