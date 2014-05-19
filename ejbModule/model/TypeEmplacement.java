package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_emplacement database table.
 * 
 */
@Entity
@Table(name="type_emplacement")
public class TypeEmplacement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codeTypeE;

	private String libtypepl;

	private float tariftypepl;

	//bi-directional many-to-one association to Emplacement
	@OneToMany(mappedBy="typeEmplacement")
	private List<Emplacement> emplacements;

	public TypeEmplacement() {
	}

	public int getCodeTypeE() {
		return this.codeTypeE;
	}

	public void setCodeTypeE(int codeTypeE) {
		this.codeTypeE = codeTypeE;
	}

	public String getLibtypepl() {
		return this.libtypepl;
	}

	public void setLibtypepl(String libtypepl) {
		this.libtypepl = libtypepl;
	}

	public float getTariftypepl() {
		return this.tariftypepl;
	}

	public void setTariftypepl(float tariftypepl) {
		this.tariftypepl = tariftypepl;
	}

	public List<Emplacement> getEmplacements() {
		return this.emplacements;
	}

	public void setEmplacements(List<Emplacement> emplacements) {
		this.emplacements = emplacements;
	}

	public Emplacement addEmplacement(Emplacement emplacement) {
		getEmplacements().add(emplacement);
		emplacement.setTypeEmplacement(this);

		return emplacement;
	}

	public Emplacement removeEmplacement(Emplacement emplacement) {
		getEmplacements().remove(emplacement);
		emplacement.setTypeEmplacement(null);

		return emplacement;
	}

}