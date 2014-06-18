package traitements;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import meserreurs.MonException;
import model.Activite;
import model.Client;
import model.Sejour;

/**
 * Session Bean implementation class GestionCerisaieBean
 */
@Stateless(name = "BeanCerisaie", mappedName = "BeanCerisaie")
public class GestionCerisaieBean implements GestionCerisaie {

	@PersistenceContext(unitName="ProjCerisaieEJB")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GestionCerisaieBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouter(Client c) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(Client c) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Client c) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(Sejour s) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(Sejour s) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Sejour s) throws MonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client rechercherClient(int id) throws MonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sejour rechercherSejour(int id) throws MonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> listerClients() throws MonException {
		List<Client> retour = null;
		try {
			String query = "SELECT c FROM Clientel c ORDER BY c.nomCl";
			retour = em.createQuery(query).getResultList();
		} catch (Exception ex) {
			throw new MonException(ex.getMessage(), "listerClients()");
		}
		return retour;
	}

	@Override
	public List<Sejour> listerSejours() throws MonException {
		List<Sejour> retour = null;
		try {
			String query = "SELECT s FROM Sejour s ORDER BY s.numSej";
			retour = em.createQuery(query).getResultList();
		} catch (Exception ex) {
			throw new MonException(ex.getMessage(), "listerSejours()");
		}
		return retour;
	}

	@Override
	public List<Activite> listerActivitesSportives() throws MonException {
		List<Activite> retour = null;
		try {
			String query = "SELECT a FROM Activite a ORDER BY s.numSej";
			retour = em.createQuery(query).getResultList();
		} catch (Exception ex) {
			throw new MonException(ex.getMessage(), "listerSejours()");
		}
		return retour;
	}

	@Override
	public List<Sejour> listerSejours(Date dateDeb, Date dateFin) throws MonException {
		List<Sejour> retour = null;
		SimpleDateFormat formater = null;
		try {
			formater = new SimpleDateFormat("yyyy-MM-dd");
			String query = "SELECT s FROM Sejour s WHERE s.datedebSej BETWEEN (" + 
						formater.format(dateDeb)
						+ " AND " +
						formater.format(dateFin)
						+ ") AND s.dateFinSej BETWEEN (" + 
						formater.format(dateDeb)
						+ " AND " +
						formater.format(dateFin)
						+ ") ORDER BY s.numSej";
			retour = em.createQuery(query).getResultList();
		} catch (Exception ex) {
			throw new MonException(ex.getMessage(), "listerSejours()");
		}
		return retour;
	}

}
