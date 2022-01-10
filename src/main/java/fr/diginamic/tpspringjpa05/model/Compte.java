package fr.diginamic.tpspringjpa05.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Compte abstrait : Livret A ou Assurance Vie
 * 
 * @author A Purdey
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Compte")
public abstract class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected String numero;

	protected double solde;

	/**
	 * Constructeur par défaut
	 */
	public Compte() {

	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero String
	 * @param solde  double
	 */
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}
