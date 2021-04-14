package br.com.pedidos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable("clienteId") Long id) {
		try {
			Cliente cliente = clienteService.buscarCliente(id);
			return ResponseEntity.ok(cliente);
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Cliente cliente) {
		clienteService.salvar(cliente);
	}
	
	@PutMapping("/clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("clienteId") Long id,
			                                 @RequestBody Cliente cliente) {
		return null;
	}
	
	@DeleteMapping("/clienteId")
	public ResponseEntity<Cliente> remover(@PathVariable Long clienteId){
		return null;
	}
	
}
