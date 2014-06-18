package traitements;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import meserreurs.*;
import model.*;

@Remote
public interface GestionCerisaie {

	/**
	 * Ajouter un client dans la base
	 * @param c Client
	 * @throws MonException qui confirme la règle
	 */
	public void ajouter(Client c) throws MonException;
	
	/**
	 * Modifier un client
	 * @param c Client
	 * @throws MonException qui confirme la règle
	 */
	public void modifier(Client c) throws MonException;
	
	/**
	 * Supprimer un client
	 * @param c Client
	 * @throws MonException qui confirme la règle
	 */
	public void supprimer(Client c) throws MonException;
	
	/**
	 * Ajouter un séjour
	 * @param s Séjour
	 * @throws MonException qui confirme la règle
	 */
	public void ajouter(Sejour s) throws MonException;
	
	/**
	 * Modifier un séjour
	 * @param s Séjour
	 * @throws MonException qui confirme la règle
	 */
	public void modifier(Sejour s) throws MonException;
	
	/**
	 * Supprimer un séjour
	 * @param s Séjour
	 * @throws MonException qui confirme la règle
	 */
	public void supprimer(Sejour s) throws MonException;
	
	/**
	 * Rechercher un client
	 * @param id ID du client
	 * @return Client
	 * @throws MonException qui confirme la règle
	 */
	public Client rechercherClient(int id) throws MonException;
	
	/**
	 * Rechercher un séjour
	 * @param id ID du séjour
	 * @return Sejour
	 * @throws MonException qui confirme la règle
	 */
	public Sejour rechercherSejour(int id) throws MonException;
	
	/**
	 * Lister tous les clients
	 * @return List<Client>
	 * @throws MonException qui confirme la règle
	 */
	public List<Client> listerClients() throws MonException;
	
	/**
	 * Lister les séjours
	 * @return List<Sejour>
	 * @throws MonException qui confirme la règle
	 */
	public List<Sejour> listerSejours() throws MonException;
	
	/**
	 * Lister les activités sportives
	 * @return List<Activite
	 * @throws MonException qui confirme la règle
	 */
	public List<Activite> listerActivitesSportives() throws MonException;
	
	/**
	 * Rechercher les séjours
	 * @param dateDeb date de début
	 * @param dateFin date de fin
	 * @return List<Sejour>
	 * @throws MonException qui confirme la règle
	 */
	public List<Sejour> listerSejours(Date dateDeb, Date dateFin) throws MonException;
}
