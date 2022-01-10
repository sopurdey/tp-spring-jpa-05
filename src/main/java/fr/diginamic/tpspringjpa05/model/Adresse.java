package fr.diginamic.tpspringjpa05.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Adresse intégrée dans Client (embedded)
 * 
 * @author A Purdey
 *
 */
@Embeddable
public class Adresse {
	@NotNull
	private int numero;

	@NotNull
	private String rue;

	@NotNull
	private int codePostal;

	@NotNull
	private String ville;

	/**
	 * Constructeur
	 */
	public Adresse() {

	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero     int
	 * @param rue        String
	 * @param codePostal int
	 * @param ville      String
	 */
	public Adresse(int numero, String rue, int codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse : " + numero + " " + rue + " " + codePostal + " " + ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
