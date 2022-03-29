package classes;

public class MemoriaRam extends Produto {

	//Atributos
	
	private String qtdMemoria;

	//Construtor
	public MemoriaRam(String marca, String preco, String produto, String fabricante, String modelo, String codigo,
			String qtdMemoria) {
		super(marca, preco, produto, fabricante, modelo, codigo);
		this.qtdMemoria = qtdMemoria;
	}
	
	//Método
	
	public String mostrarDados() {
		return "Produto: " + this.produto + 
				"\nMarca: " + this.marca + 
				"\nModelo: " + this.modelo +
				"\nFabricante: " + this.fabricante +
				"\nCódigo: " + this.codigo +
				"\nQuantidade de Memória: " + this.qtdMemoria +
				"\nPreço: R$" + this.preco +
				"\n***********************************************************" + "\n";
	}

	
	//Getter e Setter
	public String getQtdMemoria() {
		return qtdMemoria;
	}

	public void setQtdMemoria(String qtdMemoria) {
		this.qtdMemoria = qtdMemoria;
	}
	
	
	
	
	
}
