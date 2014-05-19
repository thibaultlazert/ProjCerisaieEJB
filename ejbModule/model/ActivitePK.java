package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the activite database table.
 * 
 */
@Embeddable
public class ActivitePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int codeSport;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateJour;

	private int numSej;

	public ActivitePK() {
	}
	public int getCodeSport() {
		return this.codeSport;
	}
	public void setCodeSport(int codeSport) {
		this.codeSport = codeSport;
	}
	public java.util.Date getDateJour() {
		return this.dateJour;
	}
	public void setDateJour(java.util.Date dateJour) {
		this.dateJour = dateJour;
	}
	public int getNumSej() {
		return this.numSej;
	}
	public void setNumSej(int numSej) {
		this.numSej = numSej;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivitePK)) {
			return false;
		}
		ActivitePK castOther = (ActivitePK)other;
		return 
			(this.codeSport == castOther.codeSport)
			&& this.dateJour.equals(castOther.dateJour)
			&& (this.numSej == castOther.numSej);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codeSport;
		hash = hash * prime + this.dateJour.hashCode();
		hash = hash * prime + this.numSej;
		
		return hash;
	}
}