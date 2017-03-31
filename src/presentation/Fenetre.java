package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6204475601161762834L;

	// liste des composants de l'onglet Lister
	private JLabel jlChercherMC = new JLabel("Mot clé : ");
	private JTextField jtfChercherMC = new JTextField(12);
	private JButton jbChercher = new JButton("Valider");
	private JScrollPane jsp;
	private JTable jTableClients;
	private JPanel jpChercher = new JPanel();
	private ClientModele model;
	
	// liste des composants de l'onglet Ajouter
	private JLabel jlAjouterNom = new JLabel("Nom : ");
	private JLabel jlAjouterPrenom = new JLabel("Prenom : ");
	private JLabel jlAjouterYeux = new JLabel("Yeux : ");
	private JTextField jtfAjouterNom = new JTextField(12);
	private JTextField jtfAjouterPrenom = new JTextField(12);
	private JTextField jtfAjouterYeux = new JTextField(12);
	private JButton jbAjouter = new JButton("Ajouter");
	
	// liste des composants de l'onglet Supprimer
	private JLabel jlSupprimerID = new JLabel("ID : ");
	private JTextField jtfSupprimerID = new JTextField(5);
	private JButton jbSupprimer = new JButton("Supprimer");

	// liste des composants de l'onglet MAJ
	private JLabel jlMAJID = new JLabel("ID : ");
	private JLabel jlMAJNom = new JLabel("Nom : ");
	private JLabel jlMAJPrenom = new JLabel("Prenom : ");
	private JTextField jtfMAJID = new JTextField(5);
	private JTextField jtfMAJNom = new JTextField(12);
	private JTextField jtfMAJPrenom = new JTextField(12);
	private JButton jbMAJ = new JButton("MAJ");


	private IClientService service = new ClientService();
	private Client c = new Client();

	Fenetre(String nom) {

		super(nom);
		setSize(800, 600);

		// disposition de la fenetre principale
		this.setLayout(new BorderLayout()); // ligne par ligne
		// tableau d'onglet
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		// LISTER
		JPanel onglet1 = new JPanel();
		onglet1.setLayout(new BoxLayout(onglet1, BoxLayout.Y_AXIS));
		
		jpChercher.setLayout(new FlowLayout()); // un à la suite des autres
		jpChercher.add(jlChercherMC);
		jpChercher.add(jtfChercherMC);
		jpChercher.add(jbChercher);	
		onglet1.add(jpChercher, BorderLayout.NORTH);
		
		// ajout du tableau
		model = new ClientModele();
		jTableClients = new JTable(model);
		jsp = new JScrollPane(jTableClients);
		onglet1.add(jsp, BorderLayout.CENTER);
		
		onglets.addTab("LISTER", onglet1);
		
		jbChercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// recuperation du mot clé saisi par l'utilisateur
				String mc = jtfChercherMC.getText();

				// appel de la couche service
				model.setData((List<Client>) service.chercherParMC(mc));
				
				// vider les champs après ajout en base
				jtfChercherMC.setText("");
			}
		});
		

		// AJOUTER
		// ajout de la premiere ligne
		JPanel jpAjouterNom = new JPanel();
		jpAjouterNom.setLayout(new FlowLayout()); // un à la suite des autres
		jpAjouterNom.add(jlAjouterNom);
		jpAjouterNom.add(jtfAjouterNom);

		JPanel jpAjouterPrenom = new JPanel();
		jpAjouterPrenom.add(jlAjouterPrenom);
		jpAjouterPrenom.add(jtfAjouterPrenom);
		jpAjouterPrenom.setLayout(new FlowLayout());

		JPanel jpAjouterYeux = new JPanel();
		jpAjouterYeux.setLayout(new FlowLayout());
		jpAjouterYeux.add(jlAjouterYeux);
		jpAjouterYeux.add(jtfAjouterYeux);

		JPanel jpAjouterBouton = new JPanel();
		jpAjouterBouton.setLayout(new FlowLayout());
		jpAjouterBouton.add(jbAjouter);

		// onglet ajouter
		JPanel jpAjouter = new JPanel();
		jpAjouter.setLayout(new BoxLayout(jpAjouter, BoxLayout.Y_AXIS));
		jpAjouter.add(jpAjouterNom);
		jpAjouter.add(jpAjouterPrenom);
		jpAjouter.add(jpAjouterYeux);
		jpAjouter.add(jpAjouterBouton);

		JPanel onglet2 = new JPanel();
		onglet2.setBackground(Color.CYAN);
		onglet2.add(jpAjouter);

		onglets.addTab("AJOUTER", onglet2);

		// rendre le bouton actif en lui donnant une action à réaliser
		jbAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// recuperation des paramètres saisis par l'utilisateur
				String nom = jtfAjouterNom.getText();
				String prenom = jtfAjouterPrenom.getText();
				String couleurYeux = jtfAjouterYeux.getText();

				// appel de la couche service
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setCouleurYeux(couleurYeux);

				service.ajouterClient(c);

				// vider les champs après ajout en base
				jtfAjouterNom.setText("");
				jtfAjouterPrenom.setText("");
				jtfAjouterYeux.setText("");
			}
		});

		// SUPPRIMER
		JPanel onglet3 = new JPanel();
		
		JPanel jpSupprimer = new JPanel();
		jpSupprimer.setLayout(new FlowLayout()); // un à la suite des autres
		jpSupprimer.add(jlSupprimerID);
		jpSupprimer.add(jtfSupprimerID);
		jpSupprimer.add(jbSupprimer);
		
		onglet3.add(jpSupprimer);
		onglet3.setBackground(Color.GREEN);
		onglets.addTab("SUPPRIMER", onglet3);
		
		jbSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// recuperation des paramètres saisis par l'utilisateur
				int id = Integer.parseInt(jtfSupprimerID.getText());

				// appel de la couche service
				service.supprimerClient(id);

				// vider les champs après ajout en base
				jtfSupprimerID.setText("");
			}
		});
		
		// MAJ
		JPanel onglet4 = new JPanel();
		
		JPanel jpMAJ = new JPanel();
		jpMAJ.setLayout(new FlowLayout()); // un à la suite des autres
		jpMAJ.add(jlMAJID);
		jpMAJ.add(jtfMAJID);
		jpMAJ.add(jlMAJNom);
		jpMAJ.add(jtfMAJNom);
		jpMAJ.add(jlMAJPrenom);
		jpMAJ.add(jtfMAJPrenom);
		jpMAJ.add(jbMAJ);
		
		onglet4.add(jpMAJ);
		onglet4.setBackground(Color.MAGENTA);
		
		onglets.addTab("MAJ", onglet4);
		
		jbMAJ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// recuperation des paramètres saisis par l'utilisateur
				int id = Integer.parseInt(jtfMAJID.getText());
				String nom = jtfMAJNom.getText();
				String prenom = jtfMAJPrenom.getText();

				// appel de la couche service
				service.modifierClient(id, nom, prenom);

				// vider les champs après ajout en base
				jtfMAJID.setText("");
				jtfMAJNom.setText("");
				jtfMAJPrenom.setText("");				
			}
		});

		// Ajouter les onglets à la fenetre
		this.add(onglets);

	}

	public static void main(String[] args) {

		// Fenetre swing
		Fenetre f = new Fenetre("MA FENETRE");
		f.setVisible(true);
		// f.setResizable(false);
	}
}
