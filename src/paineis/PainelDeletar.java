package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Produto;

public class PainelDeletar extends JPanel {

	private JLabel jlIndice, jlTitulo;
	private JTextField jtfIndice;
	private JButton jbDeletar;
	private List<Produto> produtos;
	
	//Construtor
	public PainelDeletar(List<Produto> produtos) {
		super();
		setSize(400,400);
		setLayout(null);
		this.produtos = produtos; //Pegando a variável "produtos" e colocando no atributo "produtos"
		iniciarComponentes();
		criarEventos();
		setBackground(new Color(60, 169, 171));
	}

	private void iniciarComponentes() {
		// Objetos
		jlTitulo = new JLabel("Deletar");
		jlTitulo.setForeground(new Color(255,255,255));
		jlTitulo.setFont(new Font("Dubai", Font.BOLD, 25));
		jlIndice = new JLabel("Digite o Índice: ");
		jlIndice.setForeground(new Color(255,255,255));
		jtfIndice = new JTextField();
		jbDeletar = new JButton("Deletar");
		jbDeletar.setBackground(new Color(18, 51, 110));
		jbDeletar.setForeground(new Color(255,255,255));
		
		//Adicionando os componentes
		
		add(jlTitulo);
		add(jlIndice);
		add(jtfIndice);
		add(jbDeletar);
		
		//Redimensionando os componentes na tela
		
		jlTitulo.setBounds(140,10,150,20);
		jlIndice.setBounds(140,100,150,20); //Coluna, linha, largura, altura
		jtfIndice.setBounds(140,140,40,20);
		jbDeletar.setBounds(140,180,100,20);
		
	}

	private void criarEventos() {
		
		
		//Evento do botão deletar
		
		jbDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int indice = Integer.parseInt(jtfIndice.getText());
					int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo deletar esse produto?", "Deletar", JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						produtos.remove(indice-1);
						JOptionPane.showMessageDialog(null, "Produto deletao com sucesso!");
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Preencha o campo com números", "Deletar", JOptionPane.ERROR_MESSAGE);
				
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Código Inválido", "Deletar", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
	}
	
	
	
}
