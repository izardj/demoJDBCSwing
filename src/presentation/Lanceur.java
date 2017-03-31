package presentation;

import java.util.ArrayList;
import java.util.Collection;

import exceptions.ClientExistePasException;
import metier.Client;
import service.ClientService;
import service.IClientService;
import service.IClientServiceVip;

public class Lanceur {

	public static void main(String[] args) {
		
		// Fenetre swing
		Fenetre f = new Fenetre("MA FENETRE");
		f.setVisible(true);
		//f.setResizable(false);


		// déclaration de l'interface
		IClientService s = new ClientService();
		IClientServiceVip sv = new ClientService();
		Collection<Client> clients = new ArrayList<Client>();
		Client c = new Client();
		c.setNom("Smith");
		c.setPrenom("Robert");
		
		//declaration de la classe;
		//ClientService cs = new ClientService();
		System.out.println("--------------CLIENT NORMAL-------------------------------");		
		// utilisation de l'interface
		s.direAurevoir();
		s.direBonjour();
		//s.jesuisVip();
		System.out.println("--------------CLIENT VIP---------------------------------");
		sv.direBonjour();
		sv.direAurevoir();
		sv.jesuisVip();
		
		//utilisation de la classe
		/*cs.direAurevoir();
		cs.direBonjour();
		cs.jesuisVip();*/
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		//s.ajouterClient(c);
		System.out.println("--------------LISTER TOUS LES CLIENTS---------------------------------");
		
		clients = s.listerClients();
		
		for (Client client : clients) {
			System.out.println(client);
		}
		System.out.println("--------------MODIFIER CLIENT 2---------------------------------");
		s.modifierClient(2, "Doe", "John");
		
		System.out.println("--------------CHERCHER CLIENT 2---------------------------------");
		try {
			System.out.println(s.chercherClient(2));
		} catch (ClientExistePasException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--------------CHERCHER CLIENT 250 (EXISTE PAS)---------------------------------");
		try {
			System.out.println(s.chercherClient(250));
		} catch (ClientExistePasException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--------------SUPPRIMER CLIENT 1---------------------------------");
		s.supprimerClient(1);
		
		String keyword = "dOe";
		System.out.println("--------------CHERCHER CLIENT '"+ keyword +"'---------------------------------");
		
		clients = s.chercherParMC(keyword);
		
		for (Client client : clients) {
			System.out.println(client);
		}
		
		/*
		System.out.println("--------------AJOUTER UN CLIENT---------------------------------");
		Client c1 = new Client();
		c1.setNom("Redford");
		c1.setPrenom("Robert");
		c1.setCouleurYeux("vert");
		s.ajouterClient(c1);
		*/

		
	}

}
