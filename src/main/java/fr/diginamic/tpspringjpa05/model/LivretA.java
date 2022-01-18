package fr.diginamic.tpspringjpa05.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Compte de type Livret A
 * 
 * @author A Purdey
 *
 */
@Entity
@Table(name = "LIVRETA")
public class LivretA extends Compte {
	private double taux;

	/**
	 * Constructeur
	 */
	public LivretA() {
		super();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero String
	 * @param solde  double
	 * @param taux   double
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA - Numéro : " + getNumero() + ", Solde=" + getSolde() + solde + " €, Taux : "  + taux + " %";
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String getType() {

		return "Livret A";
	}

}
