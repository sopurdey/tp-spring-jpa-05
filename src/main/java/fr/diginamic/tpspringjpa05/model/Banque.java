package fr.diginamic.tpspringjpa05.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entité de Banque
 * 
 * @author A Purdey
 *
 */
@Entity
@Table(name = "Banque")
public class Banque implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM")
	private String nom;

	/**
	 * Constructeur
	 */
	public Banque() {
		
	}

	/**
	 * Constucteur avec params
	 * 
	 * @param nom String
	 */
	public Banque(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
