package classes;

public class Armazenamento extends Produto {

	//Atributos
	
	private String capMemoria; //Variável para a capacidade de memória

	//Construtor
	public Armazenamento(String marca, String preco, String produto, String fabricante, String modelo, String codigo, String capMemoria) {
		super(marca, preco, produto, fabricante, modelo, codigo);
		this.capMemoria = capMemoria;
	}
	
	public String mostrarDados() {
		
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nCapacidade: " + this.capMemoria +
				"\nPreço: R$" + this.preco +
				"\n***********************************************************" + "\n";
		
	}

	//Getters e Setters
	
	public String getCapMemoria() {
		return capMemoria;
	}

	public void setCapMemoria(String capMemoria) {
		this.capMemoria = capMemoria;
	}
	
	
	
}
