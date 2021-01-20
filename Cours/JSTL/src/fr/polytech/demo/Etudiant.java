package fr.polytech.demo;

import java.io.Serializable;

public class Etudiant implements Serializable {
	private int indentifiant;
	private String nom;
	private String prenom;
	public int getIndentifiant() {
		return indentifiant;
	}
	public void setIndentifiant(int indentifiant) {
		this.indentifiant = indentifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Etudiant [indentifiant=" + indentifiant + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	public Etudiant(int indentifiant, String nom, String prenom) {
		super();
		this.indentifiant = indentifiant;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Etudiant() {
		super();
	}
	
	
	
}

