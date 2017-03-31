package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	// liste des composants de ma fenetre
	private JLabel jl1 = new JLabel("Nom : ");
	private JLabel jl2 = new JLabel("Prenom : ");
	private JLabel jl3 = new JLabel("Yeux : ");
	private JTextField jtf1 = new JTextField(12);
	private JTextField jtf2 = new JTextField(12);
	private JTextField jtf3 = new JTextField(12);
	private JButton jb1 = new JButton("ajouter");

	Fenetre(String nom) {

		super(nom);
		setSize(800, 600);

		// disposition de la fenetre principale
		this.setLayout(new BorderLayout()); // ligne par ligne

		// ajout de la premiere ligne
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout()); // un à la suite des autres
		jp1.add(jl1);
		jp1.add(jtf1);
		//jp1.setBackground(Color.CYAN);

		JPanel jp2 = new JPanel();
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.setLayout(new FlowLayout());
		//jp2.setBackground(Color.GRAY);

		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		jp3.add(jl3);
		jp3.add(jtf3);
		//jp3.setBackground(Color.RED);

		JPanel jp4 = new JPanel();
		jp4.setLayout(new FlowLayout());
		jp4.add(jb1);
		//jp4.setBackground(Color.BLUE);

		JPanel jp5 = new JPanel();
		jp5.setLayout(new BoxLayout(jp5, BoxLayout.Y_AXIS));
		jp5.add(jp1);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);

		this.add(jp5, BorderLayout.NORTH);

	}
}
