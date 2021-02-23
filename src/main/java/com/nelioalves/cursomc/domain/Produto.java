package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//Relacionamentos de tabelas > definição tabela de-para e chaves extrangeiras
//	@JsonBackReference // do outro lado já foi a lista de objetos > ai evita de buscar > omite a lista de cat pra cada produto
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="PRODUTO_CATEGORIA",
			joinColumns=@JoinColumn(name="produto_id"),
			inverseJoinColumns=@JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();//Set para nao ter Item repetido no mesmo pedido
	
	//Construtores
	//1 - Construtores (tem que ter o vazio
	public Produto() {
	}

	//2 - Nao entra nesse construtor pois já foi iniciada acima (pois tem new que chama a classe dela)
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	//Fazendo get Pedidos já trazendo ItemsPedidos
	//Ignorar tbm pois vai ser rerializado os pedidos relacionados a produtos (vira referencia ciclica dos obnjetos)
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x:itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	
	
	//Getters e Setters (pra todo mundo sempre > tem que adicionar se tiver um novo relacionamento)
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	//Gerando HashCode e Equals
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
}
