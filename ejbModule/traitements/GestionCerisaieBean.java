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
		try {
			em.persist(c);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "ajouter(Client)");
		}
	}

	@Override
	public void modifier(Client c) throws MonException {
		Client cn = this.rechercherClient(c.getNumCli());
		cn.setAdrRueCli(c.getAdrRueCli());
		cn.setCpCli(c.getCpCli());
		cn.setNomCli(c.getNomCli());
		cn.setNumPieceCli(c.getNumPieceCli());
		cn.setPieceCli(c.getPieceCli());
		cn.setVilleCli(c.getVilleCli());
		try {
			em.persist(cn);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "modifier(Client)");
		}
	}

	@Override
	public void supprimer(Client c) throws MonException {
		Client cn = null;
		try {
			cn = this.rechercherClient(c.getNumCli());
			em.remove(c);
			em.flush();
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "supprimer(Client)");
		}
	}

	@Override
	public void ajouter(Sejour s) throws MonException {
		try {
			em.persist(s);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "ajouter(Sejour)");
		}
	}

	@Override
	public void modifier(Sejour s) throws MonException {
		Sejour sn = this.rechercherSejour(s.getNumSej());
		sn.setDatedebSej(s.getDatedebSej());
		sn.setDateFinSej(s.getDateFinSej());
		sn.setEmplacement(s.getEmplacement());
		sn.setNbPersonnes(s.getNbPersonnes());
		try {
			em.persist(sn);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "modifier(Client)");
		}
	}

	@Override
	public void supprimer(Sejour s) throws MonException {
		Sejour sn = null;
		try {
			sn = this.rechercherSejour(sn.getNumSej());
			em.remove(sn);
			em.flush();
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "supprimer(Sejour)");
		}
	}

	@Override
	public Client rechercherClient(int id) throws MonException {
		Client c = null;
		try {
			c = em.find(Client.class, id);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "rechercherClient(int)");
		}
		return c;
	}

	@Override
	public Sejour rechercherSejour(int id) throws MonException {
		Sejour s = null;
		try {
			s = em.find(Sejour.class, id);
		} catch (Exception ex) {
			new MonException(ex.getMessage(), "rechercherSejour(int)");
		}
		return s;
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
