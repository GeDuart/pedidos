package br.com.pedidos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.repository.ClienteRepository;
import br.com.pedidos.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarCliente(Long id) {
		Optional<Cliente> clientes = clienteRepository.findById(id);
		if (clientes.isPresent()) {
			return clientes.get();			
		}
		throw new EmptyResultDataAccessException(1);
	}
	
	public Cliente salvar(Cliente cliente) { 
		return clienteRepository.save(cliente);
	}
	
	public void remover(Long cozinhaId) {
		Cliente cliente = buscarCliente(cozinhaId);
		clienteRepository.deleteById(cliente.getId());
	}

}
