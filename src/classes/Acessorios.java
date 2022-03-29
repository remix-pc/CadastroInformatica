package classes;

public class Acessorios extends Produto {
	
	//Atributos
	
	private String tipoEntrada;

	public Acessorios(String marca, String preco, String produto, String fabricante, String modelo, String codigo,
			String tipoEntrada) {
		super(marca, preco, produto, fabricante, modelo, codigo);
		this.tipoEntrada = tipoEntrada;
	}
	
	
	public String mostrarDados() {
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nTipo de Entrada: " + this.tipoEntrada +
				"\nPreço: R$" + this.preco +
				"\n***********************************************************" + "\n";
	}


	//Getters e Setters
	
	public String getTipoEntrada() {
		return tipoEntrada;
	}


	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	
	
}
