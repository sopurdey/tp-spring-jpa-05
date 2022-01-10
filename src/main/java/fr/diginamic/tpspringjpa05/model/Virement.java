package fr.diginamic.tpspringjpa05.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Opération de type Virement
 * 
 * @author A Purdey
 *
 */
@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {
	@Column
	private String beneficiaire;

	/**
	 * Constructeur
	 */
	public Virement() {
		super();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param date         Date
	 * @param montant      double
	 * @param motif        String
	 * @param compte       Compte
	 * @param beneficiaire String
	 */
	public Virement(Date date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + ", id=" + id + ", date=" + date + ", montant=" + montant
				+ ", motif=" + motif + ", compte=" + compte + "]";
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
