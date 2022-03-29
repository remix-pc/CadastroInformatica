package paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classes.Produto;

public class PainelPesquisa extends JPanel {

	private JLabel jlPesquisa, jlCodigo;
	private JTextField jtfCodigo;
	private JButton jbPesquisa;
	private JTextArea jtaMostrar;
	private JScrollPane jsMostrar;
	private List<Produto> produtos;
	
	//Construtor
	public PainelPesquisa(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos; //Pegando a variável "Produtos" e colocando no atributo "produtos"
		setBackground(new Color(173,216,230));
		iniciarComponentes();
		criarEventos();	
	}

	private void iniciarComponentes() {
		
		//Objeto
		jlPesquisa = new JLabel("Pesquisa");
		jlPesquisa.setFont(new Font("Dubai", Font.BOLD, 20));
		jlCodigo = new JLabel("Código");
		jtfCodigo = new JTextField();
		jbPesquisa = new JButton("Pesquisa");
		jbPesquisa.setBackground(new Color(152,251,152));
		jbPesquisa.setForeground(new Color(3,144,144));
		jtaMostrar = new JTextArea();
		jsMostrar = new JScrollPane(jtaMostrar);	
		
		//Adicionar
		
		add(jlPesquisa);
		add(jlCodigo);
		add(jtfCodigo);
		add(jbPesquisa);
		add(jsMostrar);
		
		//Redimensionar os componentes
		
		jlPesquisa.setBounds(150,10,140,60); //Linha, coluna, largura, altura
		jlCodigo.setBounds(40,60,80,20);
		jtfCodigo.setBounds(40,80,100,20);
		jbPesquisa.setBounds(40,120,100,20);
		jsMostrar.setBounds(30,160,330,160);
		
		
	}

	private void criarEventos() {
		
		jbPesquisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean achou = false;
				
				for (Produto produto : produtos) {
					if (produto.getCodigo().equals(jtfCodigo.getText())) {
						jtaMostrar.append((produtos.indexOf(produto)+1)+"-\n" + produto.mostrarDados());
						achou = true;
						break;
					}
				}
				
				if(!achou) {
					JOptionPane.showMessageDialog(null, "Produto não Encontrado", "Pesquisa de Produtos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	
}
