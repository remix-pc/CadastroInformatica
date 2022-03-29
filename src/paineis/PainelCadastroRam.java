package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Acessorios;
import classes.MemoriaRam;
import classes.Produto;

public class PainelCadastroRam extends JPanel {

	private JLabel jlTitulo, jlProduto, jlMarca, jlModelo, jlFabricante, jlCodigo, jlqtdMemoria, jlPreco, jlImagem; //Adicionar um texto na tela
	private JTextField jtfProduto, jtfMarca, jtfModelo, jtfFabricante, jtfCodigo, jtfPreco; //Caixa de texto
	private JRadioButton jrb8GB, jrb16GB, jrb32GB; // Botão de selecionar
	private ButtonGroup bgEntrada; //Grupo de botão
	private MemoriaRam memoriaRam;
	private JButton jbCadastrar, jbAlterar; //Botão 
	private ImageIcon imagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelCadastroRam(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		
		
		/************** Objetos do ImageIcon e jlImagem *************/
		
		imagem = new ImageIcon(getClass().getResource("/img/memoriaram.png"));
		jlImagem = new JLabel(imagem);
		
		
		
	/*************** OBJETOS PARA OS CAMPOS DE TEXTO E DIGITAÇÃO *****************/
		
		jlTitulo = new JLabel("Memória Ram"); // Título
		jlTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitulo.setForeground(new Color(85,0,98));
		
		//Primeira linha do Painel
		
		jlProduto = new JLabel("Produto");
		jtfProduto = new JTextField();
		jlMarca = new JLabel("Marca");
		jtfMarca = new JTextField();
		
		//Segunda linha
		
		jlModelo = new JLabel("Modelo");
		jtfModelo = new JTextField();
		jlFabricante = new JLabel("Fabricante");
		jtfFabricante = new JTextField();
		
		//Terceira linha
		
		jlCodigo = new JLabel("Código");
		jtfCodigo = new JTextField();
		jlPreco = new JLabel("Preço");
		jtfPreco = new JTextField();
		
		// Ultima linha com os botões
		
		jlqtdMemoria = new JLabel("Quantidade de Memória");
		jrb8GB = new JRadioButton("8GB", true);
		jrb8GB.setOpaque(false);
		jrb16GB = new JRadioButton("16GB");
		jrb16GB.setOpaque(false);
		jrb32GB = new JRadioButton("32GB");
		jrb32GB.setOpaque(false);
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setBackground(new Color(85,0,98));
		jbCadastrar.setForeground(new Color(255,255,255));
		jbAlterar = new JButton("Alterar");
		jbAlterar.setBackground(new Color(85,0,98));
		jbAlterar.setForeground(new Color(255,255,255));
		bgEntrada = new ButtonGroup();
		bgEntrada.add(jrb8GB);
		bgEntrada.add(jrb16GB);
		bgEntrada.add(jrb32GB);
		
		
		/************** ADICIONANDO OS COMPONENTES NA TELA **********/
		
		add(jlTitulo);
		add(jlProduto);
		add(jtfProduto);
		add(jlMarca);
		add(jtfMarca);
		add(jlModelo);
		add(jtfModelo);
		add(jlFabricante);
		add(jtfFabricante);
		add(jlCodigo);
		add(jtfCodigo);
		add(jlPreco);
		add(jtfPreco);
		add(jlqtdMemoria);
		
		add(jbCadastrar);
		add(jbAlterar);
		add(jrb8GB);
		add(jrb16GB);
		add(jrb32GB);
		add(jlImagem);
		
		/****** DIMENSIONANDO OS COMPONENTES ***************/
		
		jlTitulo.setBounds(120,10,150,20); // Coluna, linha, largura, altura
		jlProduto.setBounds(20,40,100,20);
		jtfProduto.setBounds(20,60,100,20);
		jlMarca.setBounds(180,40,100,20);
		jtfMarca.setBounds(180,60,100,20);
		jlModelo.setBounds(20,100,100,20);
		jtfModelo.setBounds(20,120,100,20);
		jlFabricante.setBounds(180,100,100,20);
		jtfFabricante.setBounds(180,120,100,20);
		jlCodigo.setBounds(20,160,100,20);
		jtfCodigo.setBounds(20,180,100,20);
		
		jlPreco.setBounds(180,160,100,20);
		jtfPreco.setBounds(180,180,50,20);
		
		jlqtdMemoria.setBounds(20,220,150,20);
		jrb8GB.setBounds(40,240,80,20);
		jrb16GB.setBounds(40,260,80,20);
		jrb32GB.setBounds(40,280,80,20);
		
		jbCadastrar.setBounds(140,280,100,30);
		jbAlterar.setBounds(140,280,100,30);
		jlImagem.setBounds(0,0,400,400);

		jbAlterar.setVisible(false);
		
	}

	private void criarEventos() {
		
jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				if (!jtfProduto.getText().isEmpty() &&
						!jtfCodigo.getText().isEmpty() &&
						!jtfModelo.getText().isEmpty() &&
						!jtfMarca.getText().isEmpty() &&
						!jtfFabricante.getText().isEmpty() &&
						!jtfPreco.getText().isEmpty()) {
					
					//Declaração das variáveis
					
					String marca, preco, produto, fabricante, modelo, codigo, qtdMemoria = null;
					
					
					//Entradas
					
					produto = jtfProduto.getText();
					marca = jtfMarca.getText();
					modelo = jtfModelo.getText();
					fabricante = jtfFabricante.getText();
					codigo = jtfCodigo.getText();
					preco = jtfPreco.getText();
					
					//Quantidade de Memória
					
					if (jrb8GB.isSelected()) qtdMemoria = "8GB";
					if (jrb16GB.isSelected()) qtdMemoria = "16GB";
					if (jrb32GB.isSelected()) qtdMemoria = "32GB";
					
				produtos.add(new MemoriaRam(marca, preco, produto, fabricante, modelo, codigo, qtdMemoria));
					
					jtfProduto.setText("");
					jtfMarca.setText("");
					jtfModelo.setText("");
					jtfFabricante.setText("");
					jtfCodigo.setText("");
					jtfPreco.setText("");
				
					JOptionPane.showMessageDialog(null, "Produto cadastrado", "Cadastro de Memória Ram", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/memoria-ram.png")));
					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro de Memória Ram", JOptionPane.ERROR_MESSAGE);
				}
				
			}
});


		//Evento do botão Alterar

	jbAlterar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			memoriaRam.setProduto(jtfProduto.getText());
			memoriaRam.setMarca(jtfMarca.getText());
			memoriaRam.setFabricante(jtfFabricante.getText());
			memoriaRam.setCodigo(jtfCodigo.getText());
			memoriaRam.setPreco(jtfPreco.getText());
			memoriaRam.setModelo(jtfModelo.getText());
			
			
			//Quantidade de Memória
			
			String qtdMemoria = null;
			
			if (jrb8GB.isSelected()) qtdMemoria = "8GB";
			if (jrb16GB.isSelected()) qtdMemoria = "16GB";
			if (jrb32GB.isSelected()) qtdMemoria = "32GB";
			
			memoriaRam.setQtdMemoria(qtdMemoria);
			
		
			
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
			
		}
	});

		
		
	}

	public void preencherDados() {
	
		
		jbAlterar.setVisible(true);
		jbCadastrar.setVisible(false);
		
		try {
			
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Entre com a índice do produto a ser alterado"));
			
			jtfProduto.setText(produtos.get(indice - 1).getProduto());
			jtfMarca.setText(produtos.get(indice - 1).getMarca());
			jtfModelo.setText(produtos.get(indice -1).getModelo());
			jtfFabricante.setText(produtos.get(indice -1).getFabricante());
			jtfCodigo.setText(produtos.get(indice - 1).getCodigo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			
			//Setando a quantidade de memória
			
			memoriaRam = (MemoriaRam) produtos.get(indice - 1);
			
			if(memoriaRam.getQtdMemoria().equals("8GB"))
				jrb8GB.setSelected(true);
			if(memoriaRam.getQtdMemoria().equals("16GB"))
				jrb16GB.setSelected(true);
			if(memoriaRam.getQtdMemoria().equals("32GB"))
				jrb32GB.setSelected(true);
			
			
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		
	}
	
	
	
	
}
