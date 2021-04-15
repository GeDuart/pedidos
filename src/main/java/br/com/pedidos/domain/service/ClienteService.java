package br.com.pedidos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.exception.EntidadeEmUsoException;
import br.com.pedidos.domain.exception.EntidadeNaoEncontradaException;
import br.com.pedidos.domain.repository.ClienteRepository;
import br.com.pedidos.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarCliente(Long cliente_id) {
		Optional<Cliente> clientes = clienteRepository.findById(cliente_id);
		if (clientes.isPresent()) {
			return clientes.get();			
		}
		throw new EmptyResultDataAccessException(1);
	}
	
	public Cliente salvar(Cliente cliente) { 
		return clienteRepository.save(cliente);
	}
	
	public void remover(Long cliente_id) {
		try {
			buscarCliente(cliente_id);
			clienteRepository.deleteById(cliente_id);		
			
		}catch(DataIntegrityViolationException e ) {
			throw new EntidadeEmUsoException(
					String.format("Cliente de codigo %d não pode ser removido, pois tem vinculo com outras tabelas", cliente_id));
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Cliente não existe com o código %d",cliente_id));
		}
	}
	

}
