package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sejour database table.
 * 
 */
@Entity
public class Sejour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numSej;

	@Temporal(TemporalType.DATE)
	private Date datedebSej;

	@Temporal(TemporalType.DATE)
	private Date dateFinSej;

	private int nbPersonnes;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="sejour")
	private List<Activite> activites;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="NumCli")
	private Client client;

	//bi-directional many-to-one association to Emplacement
	@ManyToOne
	@JoinColumn(name="NumEmpl")
	private Emplacement emplacement;

	public Sejour() {
	}

	public int getNumSej() {
		return this.numSej;
	}

	public void setNumSej(int numSej) {
		this.numSej = numSej;
	}

	public Date getDatedebSej() {
		return this.datedebSej;
	}

	public void setDatedebSej(Date datedebSej) {
		this.datedebSej = datedebSej;
	}

	public Date getDateFinSej() {
		return this.dateFinSej;
	}

	public void setDateFinSej(Date dateFinSej) {
		this.dateFinSej = dateFinSej;
	}

	public int getNbPersonnes() {
		return this.nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Activite addActivite(Activite activite) {
		getActivites().add(activite);
		activite.setSejour(this);

		return activite;
	}

	public Activite removeActivite(Activite activite) {
		getActivites().remove(activite);
		activite.setSejour(null);

		return activite;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Emplacement getEmplacement() {
		return this.emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}

}