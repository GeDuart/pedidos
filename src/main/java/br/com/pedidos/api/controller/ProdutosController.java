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

import br.com.pedidos.domain.service.ProdutoService;
import br.com.pedidos.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired 
	private ProdutoService produtoService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("")
	public List<Produto> listar() {
		return produtoService.listarProdutos();
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable("produtoId") Long id) {
		try {
			Produto produto = produtoService.buscarProduto(id);
			return ResponseEntity.ok(produto);
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}	
	}
	
}
