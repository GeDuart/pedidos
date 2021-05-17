package br.com.pedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Embedded
	private Endereco endereco;
		
	@Column(nullable = false)
	private String email_principal;
	
	@Column(nullable = false)
	private Integer status;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false,columnDefinition = "datetime")
	private Date data_criacao;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(nullable = false,columnDefinition = "datetime")
	private Date data_atualizacao;
	
	@OneToMany(mappedBy = "telefone")
	private List<Telefone> telefones = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;

}
