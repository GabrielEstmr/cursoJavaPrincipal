package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Estado;

//JpaRepository<Categoria, Integer> > tipo do objeto que retorna e tipo do objeto identificador (id)

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
