package traitements;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import meserreurs.MonException;
import model.Client;

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
	public List<Client> liste_clients() throws MonException {
		List<Client> retour = null;
		try {
			mesc = em.createQuery("SELECT c FROM Clientel c ORDER BY c.nomCl")
					.getResultList();
		} catch (Exception ex) {
			throw new MonException(ex.getMessage(), "recherche des clients");
		}
		return mesc;
	}

}
