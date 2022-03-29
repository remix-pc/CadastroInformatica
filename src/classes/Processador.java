package classes;

public class Processador extends Produto {

	// Atributos
	
	private String velocidadeCPU, nucleo;

	// Construtor
	public Processador(String marca, String preco, String produto, String fabricante, String modelo, String codigo,
			String velocidadeCPU, String nucleo) {
		super(marca, preco, produto, fabricante, modelo, codigo);
		this.velocidadeCPU = velocidadeCPU;
		this.nucleo = nucleo;
	}
	
	//Método
	
	public String mostrarDados() {
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nVelocidade da CPU: " + this.velocidadeCPU +
				"\n Núcleos: " + this.nucleo +
				"\nPreço: R$" + this.preco +
				"\n***********************************************************" + "\n";
	}

	
	//Getters e Setters
	
	public String getVelocidadeCPU() {
		return velocidadeCPU;
	}

	public void setVelocidadeCPU(String velocidadeCPU) {
		this.velocidadeCPU = velocidadeCPU;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}
	
	
	
	
}
