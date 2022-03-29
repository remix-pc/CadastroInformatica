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

import classes.PlacaVideo;
import classes.Produto;

public class PainelCadastroPlacaVideo extends JPanel {

	private JLabel jlTitulo, jlProduto, jlMarca, jlModelo, jlFabricante, jlCodigo, jlVram, jlPreco, jlImagem; //Adicionar um texto na tela
	private JTextField jtfProduto, jtfMarca, jtfFabricante, jtfCodigo, jtfPreco; //Caixa de texto
	private JRadioButton jrb2GB, jrb4GB, jrb8GB, jrbNvidea, jrbAmd; // Botão de selecionar
	private ButtonGroup bgVram; //Grupo de botão
	private ButtonGroup bgModelo;
	private PlacaVideo placaVideo;
	private JButton jbCadastrar, jbAlterar; //Botão 
	private ImageIcon imagem;
	private List<Produto> produtos;
	
	//Construtor
	public PainelCadastroPlacaVideo(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		
		
		/******* Objetos do ImageIcon e JlImagem *****/
		
		imagem = new ImageIcon(getClass().getResource("/img/placavideo.png"));
		jlImagem = new JLabel(imagem);
		
		
		
		/*************** OBJETOS PARA OS CAMPOS DE TEXTO E DIGITAÇÃO *****************/
		
		jlTitulo = new JLabel("Placa de Vídeo"); // Título
		jlTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitulo.setForeground(new Color(0,255,0));
		
		//Primeira linha do Painel
		
				jlProduto = new JLabel("Produto");
				jtfProduto = new JTextField();
				jlMarca = new JLabel("Marca");
				jtfMarca = new JTextField();
				
				//Segunda linha com botões
				
				jlModelo = new JLabel("Modelo");
				jrbAmd = new JRadioButton("AMD");
				jrbAmd.setOpaque(false);
				jrbNvidea = new JRadioButton("NVidea", true);
				jrbNvidea.setOpaque(false);
				jlFabricante = new JLabel("Fabricante");
				bgModelo = new ButtonGroup();
				bgModelo.add(jrbNvidea);
				bgModelo.add(jrbAmd);
				jtfFabricante = new JTextField();
				
				//Terceira linha
				
				jlCodigo = new JLabel("Código");
				jtfCodigo = new JTextField();
				jlPreco = new JLabel("Preço");
				jtfPreco = new JTextField();
				
				// Ultima linha com os botões
				
				jlVram = new JLabel("Tipo de Memória");
				jrb2GB = new JRadioButton("2GB", true);
				jrb2GB.setOpaque(false);
				jrb4GB = new JRadioButton("4GB");
				jrb4GB.setOpaque(false);
				jrb8GB = new JRadioButton("8GB");
				jrb8GB.setOpaque(false);
				jbCadastrar = new JButton("Cadastrar");
				jbCadastrar.setBackground(new Color(0,255,0));
				jbCadastrar.setForeground(new Color(255,255,255));
				jbAlterar = new JButton("Alterar");
				jbAlterar.setBackground(new Color(0,255,0));
				jbAlterar.setForeground(new Color(255,255,255));
				bgVram = new ButtonGroup();
				bgVram.add(jrb2GB);
				bgVram.add(jrb4GB);
				bgVram.add(jrb8GB);
				
				
				/************** ADICIONANDO OS COMPONENTES NA TELA **********/
				
				add(jlTitulo);
				add(jlProduto);
				add(jtfProduto);
				add(jlMarca);
				add(jtfMarca);
				add(jlModelo);
				add(jrbAmd);
				add(jrbNvidea);
				add(jlFabricante);
				add(jtfFabricante);
				add(jlCodigo);
				add(jtfCodigo);
				add(jlPreco);
				add(jtfPreco);
				add(jlVram);
				
				add(jbCadastrar);
				add(jbAlterar);
				add(jrb2GB);
				add(jrb4GB);
				add(jrb8GB);
				add(jlImagem);
				
				/****** DIMENSIONANDO OS COMPONENTES ***************/
				
				jlTitulo.setBounds(110,10,200,20); // Coluna, linha, largura, altura
				jlProduto.setBounds(20,40,100,20);
				jtfProduto.setBounds(20,60,100,20);
				jlMarca.setBounds(180,40,100,20);
				jtfMarca.setBounds(180,60,100,20);
				jlModelo.setBounds(20,100,100,20);
				jrbNvidea.setBounds(20,120,100,20);
				jrbAmd.setBounds(20,140,100,20);
				jlFabricante.setBounds(180,100,100,20);
				jtfFabricante.setBounds(180,120,100,20);
				jlCodigo.setBounds(20,180,100,20);
				jtfCodigo.setBounds(20,200,100,20);
				
				jlPreco.setBounds(180,180,100,20);
				jtfPreco.setBounds(180,200,50,20);
				
				jlVram.setBounds(260,160,100,20);
				jrb2GB.setBounds(260,180,80,20);
				jrb4GB.setBounds(260,200,80,20);
				jrb8GB.setBounds(260,220,80,20);
				
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
					
					String marca, preco, produto, fabricante, modelo = null, codigo, vRam = null;
					
					
					//Entradas
					
					produto = jtfProduto.getText();
					marca = jtfMarca.getText();
					fabricante = jtfFabricante.getText();
					codigo = jtfCodigo.getText();
					preco = jtfPreco.getText();
					
					//Tipo de modelo
					
					if(jrbNvidea.isSelected()) modelo = "NVidea";
					if(jrbAmd.isSelected()) modelo = "AMD";
					
					
					//Tipo de entrada
					
					if (jrb2GB.isSelected()) vRam = "2GB";
					if (jrb4GB.isSelected()) vRam = "4GB";
					if (jrb8GB.isSelected()) vRam = "8GB";
					
					
					produtos.add(new PlacaVideo(marca, preco, produto, fabricante, modelo, codigo, vRam));
					
					jtfProduto.setText("");
					jtfMarca.setText("");
					jtfFabricante.setText("");
					jtfCodigo.setText("");
					jtfPreco.setText("");
				
					JOptionPane.showInternalMessageDialog(null, "Produto cadastrado", "Cadastro de Placa de Vídeo", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/placa-de-video.png")));
					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro de Placa de Vídeo", JOptionPane.ERROR_MESSAGE);
				}
				
			}
});
		

		//Evento do botão "Alterar"
		
		jbAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			placaVideo.setProduto(jtfProduto.getText()); //Usando os setters
			placaVideo.setMarca(jtfMarca.getText());
			placaVideo.setFabricante(jtfFabricante.getText());
			placaVideo.setCodigo(jtfCodigo.getText());
			placaVideo.setPreco(jtfPreco.getText());
			
			String vRam = null;
			
			if(jrb2GB.isSelected()) vRam = "2GB";
			if(jrb4GB.isSelected()) vRam = "4GB";
			if(jrb8GB.isSelected()) vRam = "8GB";
		
			placaVideo.setvRam(vRam);
			
			String modelo = null;
			
			if(jrbNvidea.isSelected()) modelo = "NVidea";
			if(jrbAmd.isSelected()) modelo = "AMD";
			
			placaVideo.setModelo(modelo);
			
			
			
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
			
				
			}
		});
		
		
	}

	public void preencherDados() {
		
		
		jbAlterar.setVisible(true);
		jbCadastrar.setVisible(false);
		try {
			
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Entre com índice do produto a ser alterado"));
			
			jtfProduto.setText(produtos.get(indice - 1).getProduto());
			jtfMarca.setText(produtos.get(indice - 1).getMarca());
			jtfFabricante.setText(produtos.get(indice - 1).getFabricante());
			jtfCodigo.setText(produtos.get(indice - 1).getCodigo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			
			// Setando a vRam
			
			placaVideo = (PlacaVideo) produtos.get(indice - 1);
			
			if(placaVideo.getvRam().equals("2GB"))
				jrb2GB.setSelected(true);
			if(placaVideo.getvRam().equals("4GB"))
				jrb4GB.setSelected(true);
			if(placaVideo.getvRam().equals("8GB"))
				jrb8GB.setSelected(true);
			
			//Setando o modelo
			
			if(produtos.get(indice - 1).getModelo().equals("AMD"))
				jrbAmd.setSelected(true);
			if(produtos.get(indice - 1).getModelo().equals("NVidea"))
				jrbNvidea.setSelected(true);
			
			
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	
}
