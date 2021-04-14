package br.com.pedidos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.domain.service.PedidoService;
import br.com.pedidos.model.Pedido;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired 
	private PedidoService pedidoService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("")
	public List<Pedido> listar() {
		return pedidoService.listarPedidos();
	}
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<Pedido> buscar(@PathVariable("pedidoId") Long id) {
		try {
			Pedido pedido = pedidoService.buscarPedido(id);
			return ResponseEntity.ok(pedido);
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}	
	}
	
}
