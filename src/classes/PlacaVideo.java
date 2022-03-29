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
	
	//M�todo
	
	public String mostrarDados() {
		
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nC�digo: " + this.codigo +
				"\nTipo de Mem�ria: " + this.vRam +
				"\nPre�o: R$" + this.preco +
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
