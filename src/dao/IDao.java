package dao;

import java.util.Collection;

import exceptions.ClientExistePasException;
import metier.Client;

public interface IDao {
	
	public void ajouterClient(Client c);
	public void modifierClient(int id, String nom, String prenom);
	public void supprimerClient(Client c);
	public Collection<Client> listerClients();
	public Collection<Client> chercherParMC(String mc);
	public Client chercherClient(int id) throws ClientExistePasException;
}
