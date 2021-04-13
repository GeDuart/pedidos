package br.com.projeto.servico.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.projeto.servico.domain.repository.ClienteRepository;
import br.com.projeto.servico.model.Cliente;

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
