package traitements;

import java.util.List;

import javax.ejb.Remote;

import meserreurs.*;
import model.*;

@Remote
public interface GestionCerisaie {

	public List<Client> liste_clients() throws MonException;
}
