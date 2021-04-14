package br.com.pedidos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.repository.PedidoRepository;
import br.com.pedidos.model.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarPedido(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return pedido.get();			
		}
		throw new EmptyResultDataAccessException(1);
	}

}
