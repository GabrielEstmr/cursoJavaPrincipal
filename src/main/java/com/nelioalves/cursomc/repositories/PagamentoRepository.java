package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Pagamento;

//JpaRepository<Categoria, Integer> > tipo do objeto que retorna e tipo do objeto identificador (id)

// NAO PRECISA CRIAR O REPOSITORY DAS SUB CLASSES

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
