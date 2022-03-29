package classes;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	//Atributos
	protected String marca, preco, produto, fabricante, modelo, codigo;

	
	// Construtor
	
	public Produto(String marca, String preco, String produto, String fabricante, String modelo, String codigo) {
		super();
		this.marca = marca;
		this.preco = preco;
		this.produto = produto;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigo = codigo;
	}
	
	// Método

	public String mostrarDados() {
		
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nPreço: R$" + this.preco;
	}
	
	// Getters e Setters

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

	
	
}
