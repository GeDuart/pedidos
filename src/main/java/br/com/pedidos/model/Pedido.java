package br.com.pedidos.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(nullable = false)
	private BigDecimal valor_total;

	@JsonIgnore
	@Column(nullable = false)
	private Date data_criacao;
	
	
	@JsonIgnore
	@Column(nullable = false)
	private Date data_att;
	
}
