package br.com.pedidos.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.domain.exception.EntidadeEmUsoException;
import br.com.pedidos.domain.exception.EntidadeNaoEncontradaException;
import br.com.pedidos.domain.service.ClienteService;
import br.com.pedidos.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("")
	public List<Cliente> listar() {
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{cliente_id}")
	public ResponseEntity<Cliente> buscar(@PathVariable("cliente_id") Long cliente_id) {
		try {
			Cliente cliente = clienteService.buscarCliente(cliente_id);
			return ResponseEntity.ok(cliente);
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/{cliente_id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("cliente_id") Long cliente_id,
			                                 @RequestBody Cliente cliente) {
		try {
			Cliente clienteAtual = clienteService.buscarCliente(cliente_id);
			BeanUtils.copyProperties(cliente, clienteAtual, "id");
			clienteAtual = clienteService.salvar(clienteAtual);
			return ResponseEntity.ok(clienteAtual);
			
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@DeleteMapping("/{cliente_id}")
	public ResponseEntity<?> remover(@PathVariable("cliente_id") Long cliente_id){
		try {
			clienteService.remover(cliente_id);
			return ResponseEntity.noContent().build();
			
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	
	}
	
}
