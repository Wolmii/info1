package modele;

import javafx.beans.property.*;

public class Departement {
	private final IntegerProperty numero;
	private final StringProperty nom;
	private final StringProperty lieu;

	public Departement() {
		this.numero = new SimpleIntegerProperty();
		this.nom = new SimpleStringProperty();
		this.lieu = new SimpleStringProperty();
	}
	public Departement(int num, String nom, String lieu) {
		this.numero = new SimpleIntegerProperty(num);
		this.nom = new SimpleStringProperty(nom);
		this.lieu = new SimpleStringProperty(lieu);
	}

	public int getNumero() {
		return numero.get();
	}
	public void setNumero(int num) {
		this.numero.set(num);
	}
	public IntegerProperty numeroProperty() {
		return numero;
	}

	public String getNom() {
		return nom.get();
	}
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public StringProperty nomProperty() {
		return this.nom;
	}
	
	public String getLieu() {
		return lieu.get();
	}
	public void setLieu(String lieu) {
		this.lieu.set(lieu);
	}
	public StringProperty lieuProperty() {
		return this.lieu;
	}
	
	@Override
	public String toString() {
		return ""+this.getNumero();
	}
}
