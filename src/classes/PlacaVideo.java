package classes;

public class PlacaVideo extends Produto {

	//Atributos
	private String vRam;

	//Construtor
	public PlacaVideo(String marca, String preco, String produto, String fabricante, String modelo, String codigo,
			String vRam) {
		super(marca, preco, produto, fabricante, modelo, codigo);
		this.vRam = vRam;
	}
	
	//Método
	
	public String mostrarDados() {
		
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nTipo de Memória: " + this.vRam +
				"\nPreço: R$" + this.preco +
				"\n***********************************************************" + "\n";
	}
	
	//Getters e Setters
	

	public String getvRam() {
		return vRam;
	}

	public void setvRam(String vRam) {
		this.vRam = vRam;
	}
 	
}
