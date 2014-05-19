package traitements;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
