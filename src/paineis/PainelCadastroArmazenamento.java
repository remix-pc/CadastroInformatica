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

import classes.Armazenamento;
import classes.Produto;

public class PainelCadastroArmazenamento extends JPanel {

	private JLabel jlTitulo, jlProduto, jlMarca, jlModelo, jlFabricante, jlCodigo, jlMemoria, jlPreco, jlImagem; //Adicionar um texto na tela
	private JTextField jtfProduto, jtfMarca, jtfFabricante, jtfCodigo, jtfPreco; //Caixa de texto
	private JRadioButton jrb250GB, jrb500GB, jrb1TB, jrbHD, jrbSSD; // Botão de selecionar
	private ButtonGroup bgMemoria; //Grupo de botão
	private ButtonGroup bgModelo;
	private Armazenamento armazenamento;
	private JButton jbCadastrar, jbAlterar; //Botão 
	private ImageIcon imagem;
	private List<Produto> produtos;
	
	//Construtor
	
	public PainelCadastroArmazenamento(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		
		/**** Objetos do ImageIcon e jlImagem *****/
		
		imagem = new ImageIcon(getClass().getResource("/img/ssd.png"));
		jlImagem = new JLabel(imagem);
		
		
		
		
/*************** OBJETOS PARA OS CAMPOS DE TEXTO E DIGITAÇÃO *****************/
		
		jlTitulo = new JLabel("Armazenamento"); // Título
		jlTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitulo.setForeground(new Color(82, 82, 82));
		
		//Primeira linha do Painel
		
				jlProduto = new JLabel("Produto");
				jtfProduto = new JTextField();
				jlMarca = new JLabel("Marca");
				jtfMarca = new JTextField();
				
				//Segunda linha com botões
				
				jlModelo = new JLabel("Modelo");
				jrbSSD = new JRadioButton("SSD");
				jrbSSD.setOpaque(false);
				jrbHD = new JRadioButton("HD", true);
				jrbHD.setOpaque(false);
				jlFabricante = new JLabel("Fabricante");
				bgModelo = new ButtonGroup();
				bgModelo.add(jrbHD);
				bgModelo.add(jrbSSD);
				jtfFabricante = new JTextField();
				
				//Terceira linha
				
				jlCodigo = new JLabel("Código");
				jtfCodigo = new JTextField();
				jlPreco = new JLabel("Preço");
				jtfPreco = new JTextField();
				
				// Ultima linha com os botões
				
				jlMemoria = new JLabel("Capacidade de Memória");
				jrb250GB = new JRadioButton("250GB", true);
				jrb250GB.setOpaque(false);
				jrb500GB = new JRadioButton("500GB");
				jrb500GB.setOpaque(false);
				jrb1TB = new JRadioButton("1TB");
				jrb1TB.setOpaque(false);
				jbCadastrar = new JButton("Cadastrar");
				jbCadastrar.setBackground(new Color(82, 82, 82));
				jbCadastrar.setForeground(new Color(255,255,255));
				jbAlterar = new JButton("Alterar");
				jbAlterar.setBackground(new Color(82, 82, 82));
				jbAlterar.setForeground(new Color(255,255,255));
				bgMemoria = new ButtonGroup();
				bgMemoria.add(jrb250GB);
				bgMemoria.add(jrb500GB);
				bgMemoria.add(jrb1TB);
				
				
				/************** ADICIONANDO OS COMPONENTES NA TELA **********/
				
				add(jlTitulo);
				add(jlProduto);
				add(jtfProduto);
				add(jlMarca);
				add(jtfMarca);
				add(jlModelo);
				add(jrbSSD);
				add(jrbHD);
				add(jlFabricante);
				add(jtfFabricante);
				add(jlCodigo);
				add(jtfCodigo);
				add(jlPreco);
				add(jtfPreco);
				add(jlMemoria);
				
				add(jbCadastrar);
				add(jbAlterar);
				add(jrb250GB);
				add(jrb500GB);
				add(jrb1TB);
				add(jlImagem);
				
				/****** DIMENSIONANDO OS COMPONENTES ***************/
				
				jlTitulo.setBounds(120,10,200,20); // Coluna, linha, largura, altura
				jlProduto.setBounds(20,40,100,20);
				jtfProduto.setBounds(20,60,100,20);
				jlMarca.setBounds(180,40,100,20);
				jtfMarca.setBounds(180,60,100,20);
				jlModelo.setBounds(20,100,100,20);
				jrbHD.setBounds(20,120,100,20);
				jrbSSD.setBounds(20,140,100,20);
				jlFabricante.setBounds(180,100,100,20);
				jtfFabricante.setBounds(180,120,100,20);
				jlCodigo.setBounds(20,180,100,20);
				jtfCodigo.setBounds(20,200,100,20);
				
				jlPreco.setBounds(180,180,100,20);
				jtfPreco.setBounds(180,200,50,20);
				
				jlMemoria.setBounds(220,160,150,20);
				jrb250GB.setBounds(260,180,80,20);
				jrb500GB.setBounds(260,200,80,20);
				jrb1TB.setBounds(260,220,80,20);
				
				jbCadastrar.setBounds(140,280,100,30);
				jbAlterar.setBounds(140,280,100,30);
				jlImagem.setBounds(0,0,400,400);
				
				jbAlterar.setVisible(false);
		
	}

	private void criarEventos() {
		
		//Evento do botão cadastrar
		
				jbCadastrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) { 
						
						if (!jtfProduto.getText().isEmpty() &&
								!jtfCodigo.getText().isEmpty() &&
								!jtfMarca.getText().isEmpty() &&
								!jtfFabricante.getText().isEmpty() &&
								!jtfPreco.getText().isEmpty()) {
							
							//Declaração das variáveis
							
							String marca, preco, produto, fabricante, modelo = null, codigo, capMemoria = null;
							
							
							//Entradas
							
							produto = jtfProduto.getText();
							marca = jtfMarca.getText();
							fabricante = jtfFabricante.getText();
							codigo = jtfCodigo.getText();
							preco = jtfPreco.getText();
							
							//Tipo de modelo
							
							if(jrbHD.isSelected()) modelo = "HD";
							if(jrbSSD.isSelected()) modelo = "SSD";
							
							
							//Tipo de memória
							
							if (jrb250GB.isSelected()) capMemoria = "250GB";
							if (jrb500GB.isSelected()) capMemoria = "500GB";
							if (jrb1TB.isSelected()) capMemoria = "1TB";
							
							
							produtos.add(new Armazenamento(marca, preco, produto, fabricante, modelo, codigo, capMemoria));
							
							jtfProduto.setText("");
							jtfMarca.setText("");
							jtfFabricante.setText("");
							jtfCodigo.setText("");
							jtfPreco.setText("");
						
							JOptionPane.showMessageDialog(null, "Produto cadastrado", "Cadastro de Armazenamento", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/cartao-de-memoria.png")));
							
						} else {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro de Armazenamento", JOptionPane.ERROR_MESSAGE);
						}
						
					}
		});
				
				//Evento do botão alterar
				
				jbAlterar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						armazenamento.setProduto(jtfProduto.getText()); //Usando os setters
						armazenamento.setMarca(jtfMarca.getText());
						armazenamento.setFabricante(jtfFabricante.getText());
						armazenamento.setCodigo(jtfCodigo.getText());
						armazenamento.setPreco(jtfPreco.getText());
						//Tipo de memória
						
						String capMemoria = null;
						
						
						if (jrb250GB.isSelected()) capMemoria = "250GB";
						if (jrb500GB.isSelected()) capMemoria = "500GB";
						if (jrb1TB.isSelected()) capMemoria = "1TB";
						armazenamento.setCapMemoria(capMemoria);
						
						
						//Tipo de Modelo
						
						String modelo = null;
						
						if(jrbHD.isSelected()) modelo = "HD";
						if(jrbSSD.isSelected()) modelo = "SSD";
						
						armazenamento.setModelo(modelo);
						
						
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
			jtfFabricante.setText(produtos.get(indice - 1).getFabricante());
			jtfCodigo.setText(produtos.get(indice - 1).getCodigo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			
			
			//Setando o tipo de memória
			
			armazenamento = (Armazenamento) produtos.get(indice - 1);
			
			if(armazenamento.getCapMemoria().equals("250GB"))
			jrb250GB.setSelected(true);
			if(armazenamento.getCapMemoria().equals("500GB"))
				jrb500GB.setSelected(true);
			if(armazenamento.getCapMemoria().equals("1TB"))
				jrb1TB.setSelected(true);
			
			//Setando o modelo
			
			if(produtos.get(indice - 1).getModelo().equals("HD"))
				jrbHD.setSelected(true);
			if(produtos.get(indice - 1).getModelo().equals("SSD"))
				jrbSSD.setSelected(true);
			
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
}
