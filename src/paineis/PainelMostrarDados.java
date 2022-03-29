package paineis;

import java.awt.Color;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import classes.Acessorios;
import classes.Armazenamento;
import classes.MemoriaRam;
import classes.PlacaVideo;
import classes.Processador;
import classes.Produto;

public class PainelMostrarDados extends JPanel {

	private JButton jbAcessorios, jbArmazenamento, jbRam,jbPlacaVideo, jbProcessador;
	private JTextArea  jtaMostrar; //Área de texto
	private JScrollPane jsMostrar; //Barra de Rolagem
	private List<Produto> produtos; //Atributo para guardar o endereço do objeto da lista de Produtos
	
	//Construtor
	public PainelMostrarDados(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		setBackground(new Color(231, 253, 184));
		this.produtos = produtos; //Pegando a variável
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		
		//Objetos
		
		jbProcessador = new JButton("Processador");
		jbProcessador.setBackground(new Color(44, 0, 201));
		jbProcessador.setForeground(new Color(255,255,255));
		jbPlacaVideo = new JButton("Placa de Vídeo");
		jbPlacaVideo.setBackground(new Color(31, 145, 61));
		jbPlacaVideo.setForeground(new Color(255,255,255));
		jbAcessorios = new JButton("Acessórios");
		jbAcessorios.setBackground(new Color(220,20,60));
		jbAcessorios.setForeground(new Color(255,255,255));
		jbRam = new JButton("Memória Ram");
		jbRam.setBackground(new Color(85,0,98));
		jbRam.setForeground(new Color(255,255,255));
		jbArmazenamento = new JButton("Armazenamento");
		jbArmazenamento.setBackground(new Color(82, 82, 82));
		jbArmazenamento.setForeground(new Color(255,255,255));
		jtaMostrar = new JTextArea();
		jsMostrar = new JScrollPane(jtaMostrar);
		
		//Adicionando os componentes
		
		add(jbProcessador);
		add(jbPlacaVideo);
		add(jbAcessorios);
		add(jbRam);
		add(jbArmazenamento);
		add(jsMostrar);
		
		//Dimensionar os componentes 
		
		jbPlacaVideo.setBounds(20,20,120,20); //coluna, linha, largura, altura
		jbProcessador.setBounds(200,20,120,20);
		jbAcessorios.setBounds(20,50,120,20);
		jbRam.setBounds(200,50,120,20);
		jbArmazenamento.setBounds(100,80,150,20);
		jsMostrar.setBounds(30,110,330,220);
		
		
	}

	private void criarEventos() {
		
		//Evento do botão Placa de Vídeo
		
		jbPlacaVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				
				jtaMostrar.setText("");
				jtaMostrar.setText("************************Placa de Vídeo*************************" + "\n");
				if (!(produtos.size() == 0)) {
					for (Produto produto : produtos) {
						if (produto instanceof PlacaVideo) {
							jtaMostrar.append(produto.mostrarDados());
							
						}
					}
				} else {
					jtaMostrar.setText("Nenhum produto tipo Placa de vídeo cadastrado no momento");
				}
				
				
				
				
			}
		});
		
		//Evento do botão Processador
		
		jbProcessador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jtaMostrar.setText("");
				
				jtaMostrar.setText("***********************Processador*************************" + "\n");
				
				if (!(produtos.size() == 0)) {
					for (Produto produto : produtos) {
						if (produto instanceof Processador) {
							jtaMostrar.append(produto.mostrarDados());
							
						}
					}
				} else {
					jtaMostrar.setText("Nenhum produto tipo Processador registrado no momento.");
				}
				
				
				
			}
		});
		
		
		//Evento do botão Acessórios
		
		jbAcessorios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				jtaMostrar.setText("");
				
				jtaMostrar.setText("***********************Acessórios*************************" + "\n");
				if (!(produtos.size() == 0)) {
					for (Produto produto : produtos) {
						if (produto instanceof Acessorios) {
							jtaMostrar.append(produto.mostrarDados());
							
							
						}
					}
				} else {
					jtaMostrar.setText("Nenhum Acessório registrado no momento.");
				}
				
				
				
			}
		});
		
		//Evento do botão Armazenamento
		
		jbArmazenamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jtaMostrar.setText("");
				
				jtaMostrar.setText("***********************Armazenamento*************************" + "\n");
				
				if (!(produtos.size() == 0)) {
					for (Produto produto : produtos) {
						if (produto instanceof Armazenamento) {
							jtaMostrar.append(produto.mostrarDados());
							
						}
					}
				} else {
					jtaMostrar.setText("Nenhum produto tipo Armazenamento registrado no momento.");
				}
				
				
				
				
			}
		});
		
		//Evento do botão Memória Ram
		
		jbRam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				jtaMostrar.setText("");
				
				jtaMostrar.setText("***********************Memória Ram*************************" + "\n");
			
				if (!(produtos.size() == 0)) {
					for (Produto produto : produtos) {
						if (produto instanceof MemoriaRam) {
							jtaMostrar.append(produto.mostrarDados());
							
						}
					}
				} else {
					jtaMostrar.setText("Nenhum produto tipo Memória Ram registrado no momento.");
				}
				
				
				
				
			}
		});
		
	}
	
	
	
	
}
