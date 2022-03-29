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
import classes.Produto;

public class PainelCadastroAcessorios extends JPanel {

	private JLabel jlTitulo, jlProduto, jlMarca, jlModelo, jlFabricante, jlCodigo, jlTipoEntrada, jlPreco, jlImagem; //Adicionar um texto na tela
	private JTextField jtfProduto, jtfMarca, jtfModelo, jtfFabricante, jtfCodigo, jtfPreco; //Caixa de texto
	private Acessorios acessorios;
	private JRadioButton jrbP2, jrbUsb, jrbUSBc; // Botão de selecionar
	private ButtonGroup bgEntrada; //Grupo de botão
	private JButton jbCadastrar, jbAlterar; //Botão 
	private ImageIcon imagem; //Imagem
	
	private List<Produto> produtos;
	
	
	// Construtor
	public PainelCadastroAcessorios(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}
	
	private void iniciarComponentes() {
		
		/***** Objeto imagem e jlimagem   ***/
		
		imagem = new ImageIcon(getClass().getResource("/img/acessorio.png"));
		jlImagem = new JLabel(imagem);
		
		
		/*************** OBJETOS PARA OS CAMPOS DE TEXTO E DIGITAÇÃO *****************/

		
		jlTitulo = new JLabel("Acessórios"); // Título
		jlTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitulo.setForeground(new Color(220,20,60));
		
		//Primeira linha do Painel
		
		jlProduto = new JLabel("Produto");
		jlProduto.setForeground(new Color(255,255,255));
		jtfProduto = new JTextField();
		jlMarca = new JLabel("Marca");
		jlMarca.setForeground(new Color(255,255,255));
		jtfMarca = new JTextField();
		
		//Segunda linha
		
		jlModelo = new JLabel("Modelo");
		jlModelo.setForeground(new Color(255,255,255));
		jtfModelo = new JTextField();
		jlFabricante = new JLabel("Fabricante");
		jlFabricante.setForeground(new Color(255,255,255));
		jtfFabricante = new JTextField();
		
		//Terceira linha
		
		jlCodigo = new JLabel("Código");
		jlCodigo.setForeground(new Color(255,255,255));
		jtfCodigo = new JTextField();
		jlPreco = new JLabel("Preço");
		jlPreco.setForeground(new Color(255,255,255));
		jtfPreco = new JTextField();
		
		// Ultima linha com os botões
		
		jlTipoEntrada = new JLabel("Tipo de Entrada");
		jlTipoEntrada.setForeground(new Color(255,255,255));
		jrbP2 = new JRadioButton("P2", true);
		jrbP2.setForeground(new Color(255,255,255));
		jrbP2.setOpaque(false);
		jrbUsb = new JRadioButton("USB");
		jrbUsb.setForeground(new Color(255,255,255));
		jrbUsb.setOpaque(false);
		jrbUSBc = new JRadioButton("USB-C");
		jrbUSBc.setForeground(new Color(255,255,255));
		jrbUSBc.setOpaque(false);
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setBackground(new Color(220,20,60));
		jbCadastrar.setForeground(new Color(255,255,255));
		jbAlterar = new JButton("Alterar");
		jbAlterar.setBackground(new Color(220,20,60));
		jbAlterar.setForeground(new Color(255,255,255));
		bgEntrada = new ButtonGroup();
		bgEntrada.add(jrbP2);
		bgEntrada.add(jrbUsb);
		bgEntrada.add(jrbUSBc);
		
		
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
		add(jlTipoEntrada);
		
		add(jbCadastrar);
		add(jbAlterar);
		add(jrbP2);
		add(jrbUsb);
		add(jrbUSBc);
		add(jlImagem);
		
		/****** DIMENSIONANDO OS COMPONENTES ***************/
		
		jlTitulo.setBounds(140,10,120,20); // Coluna, linha, largura, altura
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
		
		jlTipoEntrada.setBounds(260,160,100,20);
		jrbP2.setBounds(260,180,80,20);
		jrbUsb.setBounds(260,200,80,20);
		jrbUSBc.setBounds(260,220,80,20);
		
		jbCadastrar.setBounds(140,280,100,30);
		jbAlterar.setBounds(140,300,100,30);
		jlImagem.setBounds(0,0,400,400);
		
		
		
		jbAlterar.setVisible(false); //Deixando o botão alterar invisível
		
		
		
		
	}
	
	private void criarEventos() {
		
		//Evento botão cadastrar
		
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
					
					String marca, preco, produto, fabricante, modelo, codigo, tipoEntrada = null;
					
					
					//Entradas
					
					produto = jtfProduto.getText();
					marca = jtfMarca.getText();
					modelo = jtfModelo.getText();
					fabricante = jtfFabricante.getText();
					codigo = jtfCodigo.getText();
					preco = jtfPreco.getText();
					
					//Tipo de entrada
					
					if (jrbP2.isSelected()) tipoEntrada = "P2";
					if (jrbUsb.isSelected()) tipoEntrada = "USB";
					if (jrbUSBc.isSelected()) tipoEntrada = "USB-C";
					
				produtos.add(new Acessorios(marca, preco, produto, fabricante, modelo, codigo, tipoEntrada));
					
					jtfProduto.setText("");
					jtfMarca.setText("");
					jtfModelo.setText("");
					jtfFabricante.setText("");
					jtfCodigo.setText("");
					jtfPreco.setText("");
				
					JOptionPane.showMessageDialog(null, "Produto cadastrado", "Cadastro de Acessórios", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/mouse.png")));
					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro de Acessórios", JOptionPane.ERROR_MESSAGE);
				}
				
			}
});
		
		
		//Evento do botão "Alterar"
		
		jbAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			acessorios.setProduto(jtfProduto.getText()); //Usando os setters
			acessorios.setMarca(jtfMarca.getText());
			acessorios.setModelo(jtfModelo.getText());
			acessorios.setFabricante(jtfFabricante.getText());
			acessorios.setCodigo(jtfCodigo.getText());
			acessorios.setPreco(jtfPreco.getText());
			
			String tipoEntrada = null;
			
			if(jrbP2.isSelected()) tipoEntrada = "P2";
			if(jrbUsb.isSelected()) tipoEntrada = "USB";
			if(jrbUSBc.isSelected()) tipoEntrada = "USB-C";
			
			acessorios.setTipoEntrada(tipoEntrada);
			
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
			jtfModelo.setText(produtos.get(indice - 1).getModelo());
			jtfFabricante.setText(produtos.get(indice - 1).getFabricante());
			jtfCodigo.setText(produtos.get(indice - 1).getCodigo());
			jtfPreco.setText(produtos.get(indice - 1).getPreco());
			
			// Setando o tipo de entrada
			
			acessorios = (Acessorios) produtos.get(indice - 1);
			
			if(acessorios.getTipoEntrada().equals("P2"))
				jrbP2.setSelected(true);
			if(acessorios.getTipoEntrada().equals("USB"))
				jrbUsb.setSelected(true);
			if(acessorios.getTipoEntrada().equals("USB-C"))
				jrbUSBc.setSelected(true);
			
			
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	
	
}
