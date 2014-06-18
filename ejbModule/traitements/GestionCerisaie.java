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
	 * @throws MonException qui confirme la r�gle
	 */
	public void ajouter(Client c) throws MonException;
	
	/**
	 * Modifier un client
	 * @param c Client
	 * @throws MonException qui confirme la r�gle
	 */
	public void modifier(Client c) throws MonException;
	
	/**
	 * Supprimer un client
	 * @param c Client
	 * @throws MonException qui confirme la r�gle
	 */
	public void supprimer(Client c) throws MonException;
	
	/**
	 * Ajouter un s�jour
	 * @param s S�jour
	 * @throws MonException qui confirme la r�gle
	 */
	public void ajouter(Sejour s) throws MonException;
	
	/**
	 * Modifier un s�jour
	 * @param s S�jour
	 * @throws MonException qui confirme la r�gle
	 */
	public void modifier(Sejour s) throws MonException;
	
	/**
	 * Supprimer un s�jour
	 * @param s S�jour
	 * @throws MonException qui confirme la r�gle
	 */
	public void supprimer(Sejour s) throws MonException;
	
	/**
	 * Rechercher un client
	 * @param id ID du client
	 * @return Client
	 * @throws MonException qui confirme la r�gle
	 */
	public Client rechercherClient(int id) throws MonException;
	
	/**
	 * Rechercher un s�jour
	 * @param id ID du s�jour
	 * @return Sejour
	 * @throws MonException qui confirme la r�gle
	 */
	public Sejour rechercherSejour(int id) throws MonException;
	
	/**
	 * Lister tous les clients
	 * @return List<Client>
	 * @throws MonException qui confirme la r�gle
	 */
	public List<Client> listerClients() throws MonException;
	
	/**
	 * Lister les s�jours
	 * @return List<Sejour>
	 * @throws MonException qui confirme la r�gle
	 */
	public List<Sejour> listerSejours() throws MonException;
	
	/**
	 * Lister les activit�s sportives
	 * @return List<Activite
	 * @throws MonException qui confirme la r�gle
	 */
	public List<Activite> listerActivitesSportives() throws MonException;
	
	/**
	 * Rechercher les s�jours
	 * @param dateDeb date de d�but
	 * @param dateFin date de fin
	 * @return List<Sejour>
	 * @throws MonException qui confirme la r�gle
	 */
	public List<Sejour> listerSejours(Date dateDeb, Date dateFin) throws MonException;
}
