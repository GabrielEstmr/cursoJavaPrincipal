package com.nelioalves.cursomc.resources;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//@Autowired > instanciar automaticamento o objeto
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	//@PathVariable > liga id do endpoint ao id do metodo find no código
	//ResponseEntity > tipo do Spring que ja da como response varios parametros para a resposta do metodo
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		//Retorno em caso de sucesso
		return ResponseEntity.ok().body(obj);
		
		
//		
//		Categoria cat1 = new Categoria(1,"Informática");
//		Categoria cat2 = new Categoria(2,"Escritório");
//		
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		//Ja retorna no formato JSON!!!
//		return lista;
	}
}


//Resouces: controladoresRest