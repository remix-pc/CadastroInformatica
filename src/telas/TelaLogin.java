package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import telas.TelaPrincipal;

public class TelaLogin extends JFrame {

	private Container contentPane;
	private JLabel jlTitulo, jlLogin, jlSenha, jlErro, jlAviso;
	private JPasswordField jpfSenha;
	private JTextField jtfLogin;
	private JButton jbEntrar, jbDica;
	private ImageIcon imagem;
	private JLabel jlImagem;
	
	//Construtor
		public TelaLogin(String title) throws HeadlessException {
			super(title);
			setSize(400,400);
			setLayout(null);
			setLocationRelativeTo(null);
			iniciarComponentes();
			criarEventos();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		} 

	private void iniciarComponentes() {
		/******************* OBJETOS ********************/
		
		imagem = new ImageIcon(getClass().getResource("/img/tela-login2.png"));
		jlImagem = new JLabel(imagem);
		
		
		/**** JLabels e JButton ******/
		
		jlTitulo = new JLabel("Login");
		jlTitulo.setFont(new Font("Sans-Serif", Font.BOLD, 30)); // Colocando uma fonte, tipo da fonte e seu tamanho
		jlTitulo.setForeground(new Color(121, 14, 153)); //Adicionando uma cor para a fonte
		jlErro = new JLabel("Login errado");
		jlErro.setFont(new Font("Sans-Serif", Font.ITALIC, 12));
		jlErro.setForeground(new Color(255,0,0));
		jlAviso = new JLabel("Preencher todos os campos");
		jlAviso.setFont(new Font("Sans-Serif", Font.ITALIC, 12));
		jlAviso.setForeground(new Color(255,0,0));
		jlLogin = new JLabel("Digite seu nome");
		jlLogin.setFont(new Font("Sans-Serif", Font.BOLD, 16));
		jlLogin.setForeground(new Color(121, 14, 153));
		jlSenha = new JLabel("Digite sua senha");
		jlSenha.setForeground(new Color(121, 14, 153));
		jlSenha.setFont(new Font("Sans-Serif", Font.BOLD, 16));
		jbEntrar = new JButton("Logar");
		jbEntrar.setBackground(new Color(121, 14, 153));
		jbEntrar.setForeground(new Color(255, 255, 255));
		jbDica = new JButton("Dica");
		jbDica.setBackground(new Color(121,14,153));
		jbDica.setForeground(new Color(255,255,255));
		
		/******* JTextField e JPasswordField ********/
		
		jtfLogin = new JTextField();
		jpfSenha = new JPasswordField();
		
		
		
		
		
		/************** ADICIONAR OS COMPONENTES NA TELA ********/
		
		add(jlLogin);
		add(jlTitulo);
		add(jlSenha);
		add(jtfLogin);
		add(jpfSenha);
		add(jbEntrar);
		add(jlErro);
		add(jlAviso);
		add(jbDica);
		add(jlImagem);
		
		/**************** REDIMENSIONAR OS COMPONENTES **********/
		//Colunha, linha, largura, altura  
		
		jlTitulo.setBounds(150, 10, 150,60);
		jlLogin.setBounds(120,120,150,20);
		jtfLogin.setBounds(120,140,150,20);
		jlSenha.setBounds(120,180,150,20);
		jpfSenha.setBounds(120,200,150,20);
		jbEntrar.setBounds(140,250,110,30);
		jbDica.setBounds(260,315,110,30);
		jlErro.setBounds(145,220,100,20);
		jlAviso.setBounds(120,220,200,20);
		jlImagem.setBounds(0,0,400,400);
		jlAviso.setVisible(false);
		jlErro.setVisible(false);
		}

	private void criarEventos() {
	//Evendo do botão Entrar
		
		jbEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!jtfLogin.getText().isEmpty() && !jpfSenha.getText().isEmpty()) {
					
					if (jtfLogin.getText().equals("Admin") && jpfSenha.getText().equals("senha")) {
						
						TelaPrincipal principal = new TelaPrincipal("Loja de Informática");
						
						
							principal.setVisible(true);
						
						JOptionPane.showMessageDialog(null, "Seja Bem-Vindo Administrador!");
						setVisible(false);
						
						
						
						
					} else {
						jlErro.setVisible(true);
						jlAviso.setVisible(false);
					}
					
				} else {
					jlErro.setVisible(false);
					jlAviso.setVisible(true);
				}
				
			}
		});
		
		
		//Evento do botão Dica
		
		jbDica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Nome: Admin" + "\nSenha: senha", "Dica Login", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/dica.png")));;
				
				
			}
		});
		
	}
		
		
}
