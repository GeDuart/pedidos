package br.com.pedidos.domain.service;

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
	
	public Cliente salvar(Cliente cliente) { 
		return clienteRepository.save(cliente);
	}
	
	public void remover(Long cozinhaId) {
		Optional<Cliente> cliente = clienteRepository.findById(cozinhaId);
		
		if (cliente.get().getId() == null) {
			throw new EmptyResultDataAccessException(1);
		}
			
		clienteRepository.deleteById(cozinhaId);
	}

}
