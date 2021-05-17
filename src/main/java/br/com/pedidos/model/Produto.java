package br.com.pedidos.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	private BigDecimal valor_unitario;
	
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

}
