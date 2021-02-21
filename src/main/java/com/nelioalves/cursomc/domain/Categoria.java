package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Serializable - para objetos da classe possa ser convertido em sequencia de bites > para trafegar em rede, ser salvos etc
@Entity
public class Categoria implements Serializable {
	//Quando classe implementa o Serializable precisa de numero de versão padrão
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//Contrutor da classe (instancia o objeto sem jogar nada para os atributos
	public Categoria() {
		
	}

	//para ja atribuir valores as variavei da classe de acordo com o construtor
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	//Getters and Setter > como default nao deica variaveis da classe disponiveis (id,nome)
	//Mas aqui a gente cria variaveis de acesso a esses tributos
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//Generate Hashcode e Equals - comparação dos objetos por valor e nao por ponteiro de memória
	//só id pois é o que usa pra identificar os objetos da classe
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
