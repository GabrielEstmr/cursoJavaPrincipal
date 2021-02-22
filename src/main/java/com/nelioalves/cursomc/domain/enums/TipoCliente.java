package com.nelioalves.cursomc.domain.enums;

public enum TipoCliente {
//	//Assim: o java cria numeros inteiros automaticamente 
//	//> mas nao é bom pois se colocar alguma opção antes ele começa com esse numero ai quebra os outros dados!!!!
//	PESSOAFISICA,
//	PESSOAJURIDICA;
	
	

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod=cod;
		this.descricao = descricao;
	}
	
	
	//Construtores: apenas metodo GET (pois nao podemos permitir mudar cod e descricao nesse caso!!!
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	//Static: metodo que pode rodar ele mesmo sem ter o objeto instanciado
	public static TipoCliente toEnum(Integer cod) {
		//Aqui: inteiro nulo > corresponde a TipoCliente Nulo tbm
		if(cod==null) {
			return null;
		}
		
		//Percorrendo todos os tipos clientes
		//Vendo se código de imput do método é igual a alguns código que temos como objeto(TipoCliente)
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
