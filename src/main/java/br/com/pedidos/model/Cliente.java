package br.com.pedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefones = new ArrayList<>();

}
