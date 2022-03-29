package classes;

public class Armazenamento extends Produto {

	//Atributos
	
	private String capMemoria; //Vari�vel para a capacidade de mem�ria

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
				"\nC�digo: " + this.codigo +
				"\nCapacidade: " + this.capMemoria +
				"\nPre�o: R$" + this.preco +
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
