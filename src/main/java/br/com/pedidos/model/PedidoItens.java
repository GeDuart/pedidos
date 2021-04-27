package br.com.pedidos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class PedidoItens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@Column(nullable = false)
	private Double quantidade;
	
	@OneToMany
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@Column(nullable = false)
	private BigDecimal valor_unitario; 
	
}
