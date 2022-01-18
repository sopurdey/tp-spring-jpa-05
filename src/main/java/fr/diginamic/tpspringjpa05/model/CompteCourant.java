package fr.diginamic.tpspringjpa05.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="comptecourant")
public class CompteCourant extends Compte {

	public CompteCourant() {
		
	}
	
	@Override
	public String toString() {
		return "Compte Courant - Numéro : " + numero + ", Solde : " + solde + " €";
	}

	@Override
	public String getType() {

		return "Compte Courant";
	}

}