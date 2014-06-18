ProjCerisaieEJB
===============

EJB pour le projet Cerisaie

Gère les accès avec la base de données.
Contient les objets du modèle et une classe pour les traitements.

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

