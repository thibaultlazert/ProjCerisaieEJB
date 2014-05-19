package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emplacement database table.
 * 
 */
@Entity
public class Emplacement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numEmpl;

	private int nbPersMaxEmpl;

	private float surfaceEmpl;

	//bi-directional many-to-one association to TypeEmplacement
	@ManyToOne
	@JoinColumn(name="CodeTypeE")
	private TypeEmplacement typeEmplacement;

	//bi-directional many-to-one association to Sejour
	@OneToMany(mappedBy="emplacement")
	private List<Sejour> sejours;

	public Emplacement() {
	}

	public int getNumEmpl() {
		return this.numEmpl;
	}

	public void setNumEmpl(int numEmpl) {
		this.numEmpl = numEmpl;
	}

	public int getNbPersMaxEmpl() {
		return this.nbPersMaxEmpl;
	}

	public void setNbPersMaxEmpl(int nbPersMaxEmpl) {
		this.nbPersMaxEmpl = nbPersMaxEmpl;
	}

	public float getSurfaceEmpl() {
		return this.surfaceEmpl;
	}

	public void setSurfaceEmpl(float surfaceEmpl) {
		this.surfaceEmpl = surfaceEmpl;
	}

	public TypeEmplacement getTypeEmplacement() {
		return this.typeEmplacement;
	}

	public void setTypeEmplacement(TypeEmplacement typeEmplacement) {
		this.typeEmplacement = typeEmplacement;
	}

	public List<Sejour> getSejours() {
		return this.sejours;
	}

	public void setSejours(List<Sejour> sejours) {
		this.sejours = sejours;
	}

	public Sejour addSejour(Sejour sejour) {
		getSejours().add(sejour);
		sejour.setEmplacement(this);

		return sejour;
	}

	public Sejour removeSejour(Sejour sejour) {
		getSejours().remove(sejour);
		sejour.setEmplacement(null);

		return sejour;
	}

}