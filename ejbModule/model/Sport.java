package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sport database table.
 * 
 */
@Entity
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codeSport;

	private String libelleSport;

	private float tarifUnite;

	private String uniteTpsSport;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="sport")
	private List<Activite> activites;

	public Sport() {
	}

	public int getCodeSport() {
		return this.codeSport;
	}

	public void setCodeSport(int codeSport) {
		this.codeSport = codeSport;
	}

	public String getLibelleSport() {
		return this.libelleSport;
	}

	public void setLibelleSport(String libelleSport) {
		this.libelleSport = libelleSport;
	}

	public float getTarifUnite() {
		return this.tarifUnite;
	}

	public void setTarifUnite(float tarifUnite) {
		this.tarifUnite = tarifUnite;
	}

	public String getUniteTpsSport() {
		return this.uniteTpsSport;
	}

	public void setUniteTpsSport(String uniteTpsSport) {
		this.uniteTpsSport = uniteTpsSport;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Activite addActivite(Activite activite) {
		getActivites().add(activite);
		activite.setSport(this);

		return activite;
	}

	public Activite removeActivite(Activite activite) {
		getActivites().remove(activite);
		activite.setSport(null);

		return activite;
	}

}