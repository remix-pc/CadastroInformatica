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
import classes.Processador;
import classes.Produto;

public class PainelCadastroProcessador extends JPanel {

	private JLabel jlTitulo, jlProduto, jlMarca, jlModelo, jlFabricante, jlCodigo, jlNucleo, jlPreco, jlCPU, jlImagem; //Adicionar um texto na tela
	private JTextField jtfProduto, jtfMarca, jtfFabricante, jtfCodigo, jtfPreco, jtfCPU; //Caixa de texto
	private JRadioButton jrbDual, jrbQuad, jrbOcta, jrbIntel, jrbAmd; // Botão de selecionar
	private ButtonGroup bgNucleo; //Grupo de botão
	private ButtonGroup bgModelo;
	private Processador processador;
	private JButton jbCadastrar, jbAlterar; //Botão 
	private ImageIcon imagem;
	private List<Produto> produtos;
	
	public PainelCadastroProcessador(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos;
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		
		
		/*********** Objetos do ImageIcon e jlImagem ************/
		
		imagem = new ImageIcon(getClass().getResource("/img/processador2.png"));
		jlImagem = new JLabel(imagem);
		
		
/*************** OBJETOS PARA OS CAMPOS DE TEXTO E DIGITAÇÃO *****************/
		
		jlTitulo = new JLabel("Processador"); // Título
		jlTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitulo.setForeground(new Color(44, 0, 201));
		
		//Primeira linha do Painel
		
				jlProduto = new JLabel("Produto");
				jtfProduto = new JTextField();
				jlMarca = new JLabel("Marca");
				jtfMarca = new JTextField();
				
				//Segunda linha com botões
				
				jlModelo = new JLabel("Modelo");
				jrbAmd = new JRadioButton("AMD");
				jrbAmd.setOpaque(false);
				jrbIntel = new JRadioButton("Intel", true);
				jrbIntel.setOpaque(false);
				jlFabricante = new JLabel("Fabricante");
				bgModelo = new ButtonGroup();
				bgModelo.add(jrbIntel);
				bgModelo.add(jrbAmd);
				jtfFabricante = new JTextField();
				
				//Terceira linha
				
				jlCodigo = new JLabel("Código");
				jtfCodigo = new JTextField();
				jlPreco = new JLabel("Preço");
				jtfPreco = new JTextField();
				jlCPU = new JLabel("Velocidade CPU");
				jtfCPU = new JTextField();
				
				// Ultima linha com os botões
				
				jlNucleo = new JLabel("Núcleo");
				jrbDual = new JRadioButton("DualCore", true);
				jrbDual.setOpaque(false);
				jrbQuad = new JRadioButton("QuadCore");
				jrbQuad.setOpaque(false);
				jrbOcta = new JRadioButton("OctaCore");
				jrbOcta.setOpaque(false);
				jbCadastrar = new JButton("Cadastrar");
				jbCadastrar.setBackground(new Color(44, 0, 201));
				jbCadastrar.setForeground(new Color(255,255,255));
				jbAlterar = new JButton("Alterar");
				jbAlterar.setBackground(new Color(44, 0, 201));
				jbAlterar.setForeground(new Color(255,255,255));
				bgNucleo = new ButtonGroup();
				bgNucleo.add(jrbDual);
				bgNucleo.add(jrbQuad);
				bgNucleo.add(jrbOcta);
				
				
				/************** ADICIONANDO OS COMPONENTES NA TELA **********/
				
				add(jlTitulo);
				add(jlProduto);
				add(jtfProduto);
				add(jlMarca);
				add(jtfMarca);
				add(jlModelo);
				add(jrbAmd);
				add(jrbIntel);
				add(jlFabricante);
				add(jtfFabricante);
				add(jlCodigo);
				add(jtfCodigo);
				add(jlPreco);
				add(jtfPreco);
				add(jlNucleo);
				add(jlCPU);
				add(jtfCPU);
				
				add(jbCadastrar);
				add(jbAlterar);
				add(jrbDual);
				add(jrbQuad);
				add(jrbOcta);
				add(jlImagem);
				
				/****** DIMENSIONANDO OS COMPONENTES ***************/
				
				jlTitulo.setBounds(120,10,200,20); // Coluna, linha, largura, altura
				jlProduto.setBounds(20,40,100,20);
				jtfProduto.setBounds(20,60,100,20);
				jlMarca.setBounds(180,40,100,20);
				jtfMarca.setBounds(180,60,100,20);
				jlModelo.setBounds(20,100,100,20);
				jrbIntel.setBounds(20,120,100,20);
				jrbAmd.setBounds(20,140,100,20);
				jlFabricante.setBounds(180,100,100,20);
				jtfFabricante.setBounds(180,120,100,20);
				jlCodigo.setBounds(20,180,100,20);
				jtfCodigo.setBounds(20,200,100,20);
				jlCPU.setBounds(20,240,100,20);
				jtfCPU.setBounds(20,260,100,20);
				
				jlPreco.setBounds(180,180,100,20);
				jtfPreco.setBounds(180,200,50,20);
				
				jlNucleo.setBounds(260,160,100,20);
				jrbDual.setBounds(260,180,120,20);
				jrbQuad.setBounds(260,200,120,20);
				jrbOcta.setBounds(260,220,120,20);
				
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
								!jtfCPU.getText().isEmpty() &&
								!jtfFabricante.getText().isEmpty() &&
								!jtfPreco.getText().isEmpty()) {
							
							//Declaração das variáveis
							
							String marca, preco, produto, fabricante, modelo = null, codigo, nucleo = null, velocidadeCPU;
							
							
							//Entradas
							
							produto = jtfProduto.getText();
							marca = jtfMarca.getText();
							fabricante = jtfFabricante.getText();
							codigo = jtfCodigo.getText();
							preco = jtfPreco.getText();
							velocidadeCPU = jtfCPU.getText();
							
							//Tipo de modelo
							
							if(jrbIntel.isSelected()) modelo = "Intel";
							if(jrbAmd.isSelected()) modelo = "AMD";
							
							
							//Quantidade de Núcleo
							
							if (jrbDual.isSelected()) nucleo = "DualCore";
							if (jrbQuad.isSelected()) nucleo = "QuadCore";
							if (jrbOcta.isSelected()) nucleo = "OctaCore";
							
							produtos.add(new Processador(marca, preco, produto, fabricante, modelo, codigo, velocidadeCPU, nucleo));
							
							
							jtfProduto.setText("");
							jtfMarca.setText("");
							jtfFabricante.setText("");
							jtfCodigo.setText("");
							jtfPreco.setText("");
							jtfCPU.setText("");
						
							JOptionPane.showMessageDialog(null, "Produto cadastrado", "Cadastro de Processador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/processador.png")));
							
						} else {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro de Placa de Processador", JOptionPane.ERROR_MESSAGE);
						}
						
					}
		});
				
				//Evento do botão Alterar
				
				jbAlterar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						processador.setProduto(jtfProduto.getText()); //Usando os setters
						processador.setMarca(jtfMarca.getText());
						processador.setFabricante(jtfFabricante.getText());
						processador.setCodigo(jtfCodigo.getText());
						processador.setVelocidadeCPU(jtfCPU.getText());
						
						
						//Tipo de Modelo
						
						String modelo = null;
						
						if(jrbIntel.isSelected()) modelo = "Intel";
						if(jrbAmd.isSelected()) modelo = "AMD";
						
						processador.setModelo(modelo);
						
						//Núcleos
						
						String nucleo = null;
						
						if (jrbDual.isSelected()) nucleo = "DualCore";
						if (jrbQuad.isSelected()) nucleo = "QuadCore";
						if (jrbOcta.isSelected()) nucleo = "OctaCore";
						
						processador.setNucleo(nucleo);
						
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
			
			processador = (Processador) produtos.get(indice - 1);
			
			jtfCPU.setText(processador.getVelocidadeCPU()); //Velocidade da CPU
			//Setando o Núcleo
			
			if(processador.getNucleo().equals("DualCore"))
				jrbDual.setSelected(true);
			if(processador.getNucleo().equals("QuadCore"))
				jrbQuad.setSelected(true);
			if(processador.getNucleo().equals("OctaCore"))
				jrbOcta.setSelected(true);
			
			//Setando o modelo
			
			if(produtos.get(indice - 1).getModelo().equals("AMD"))
				jrbAmd.setSelected(true);
			if(produtos.get(indice - 1).getModelo().equals("Intel"))
				jrbIntel.setSelected(true);
	
			
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Campo vazio ou preenchido incorretamente.", "Alterar", JOptionPane.WARNING_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Índice inexistente!", "Alterar", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	
	
	
	
	
}
