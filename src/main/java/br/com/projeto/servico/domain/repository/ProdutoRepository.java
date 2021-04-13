package br.com.projeto.servico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.servico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
