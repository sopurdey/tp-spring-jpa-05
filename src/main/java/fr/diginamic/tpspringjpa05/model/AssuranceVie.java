package fr.diginamic.tpspringjpa05.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Compte de type Assurance Vie
 * 
 * @author A Purdey
 *
 */
@Entity
@Table(name="ASSURANCEVIE")
public class AssuranceVie extends Compte {
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateFin;
	private double taux;

	/**
	 * Constructeur
	 */
	public AssuranceVie() {
		super();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero  String
	 * @param solde   double
	 * @param dateFin Date
	 * @param taux    double
	 */
	public AssuranceVie(String numero, double solde, Date dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "AssuranceVie - Numéro : " + getNumero() + ", Solde : " + getSolde() + " €, Date de fin : " + dateFin + ", Taux : " + taux + " %";
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String getType() {

		return "Assurance Vie";
	}

}
