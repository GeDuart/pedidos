package br.com.pedidos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.repository.ProdutoRepository;
import br.com.pedidos.model.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return produto.get();			
		}
		throw new EmptyResultDataAccessException(1);
	}

}
