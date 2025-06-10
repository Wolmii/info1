package modele;

import javafx.beans.property.*;

public class Employe {
	private final IntegerProperty matricule;
	private final StringProperty nom;
	private final StringProperty poste;
	private final IntegerProperty superieur;
	private final StringProperty embauche;
	private final FloatProperty salaire;
	private final FloatProperty prime;
	private final IntegerProperty dept;

	public Employe() {
		this.matricule = new SimpleIntegerProperty();
		this.nom = new SimpleStringProperty();
		this.poste = new SimpleStringProperty();
		this.superieur = new SimpleIntegerProperty();
		this.embauche = new SimpleStringProperty();
		this.salaire = new SimpleFloatProperty();
		this.prime = new SimpleFloatProperty();
		this.dept = new SimpleIntegerProperty();
	}
	public Employe(int mat, String nom, String poste, int sup, String dateEmb, float sal, float prime,int dept) {
		this.matricule = new SimpleIntegerProperty(mat);
		this.nom = new SimpleStringProperty(nom);
		this.poste = new SimpleStringProperty(poste);
		this.superieur = new SimpleIntegerProperty(sup);
		this.embauche = new SimpleStringProperty(dateEmb);
		this.salaire = new SimpleFloatProperty(sal);
		this.prime = new SimpleFloatProperty(prime);
		this.dept = new SimpleIntegerProperty(dept);
	}

	public int getMatricule() {
		return matricule.get();
	}
	public void setMatricule(int matricule) {
		this.matricule.set(matricule);
	}
	public IntegerProperty matriculeProperty() {
		return this.matricule;
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
	
	public String getPoste() {
		return poste.get();
	}
	public void setPoste(String poste) {
		this.poste.set(poste);
	}
	public StringProperty posteProperty() {
		return this.poste;
	}
	public int getSuperieur() {
		return superieur.get();
	}
	public void setSuperieur(int superieur) {
		this.superieur.set(superieur);
	}
	public IntegerProperty superieurProperty() {
		return this.superieur;
		
	}public String getEmbauche() {
		return embauche.get();
	}
	public void setEmbauche(String embauche) {
		this.embauche.set(embauche);
	}
	public StringProperty embaucheProperty() {
		return this.embauche;
		
		
	}public float getSalaire() {
		return salaire.get();
	}
	public void setSalaire(float salaire) {
		this.salaire.set(salaire);
	}
	public FloatProperty salaireProperty() {
		return this.salaire;
		
	}public float getPrime() {
		return prime.get();
	}
	public void setPrime(float prime) {
		this.prime.set(prime);
	}
	public FloatProperty primeProperty() {
		return this.prime;
	}
	public int getDept() {
		return dept.get();
	}
	public void setDept(int dept) {
		this.dept.set(dept);
	}
	public IntegerProperty deptProperty() {
		return this.dept;
	}
	
	public void affiche() {
		System.out.println("Matricule : " + this.getMatricule());
		System.out.println("Nom : " + this.getNom());
		System.out.println("Poste : " + this.getPoste());
		System.out.println("Supéieur : " + this.getSuperieur());
		System.out.println("Embauche : " + this.getEmbauche());
		System.out.println("Salaire : " + this.getSalaire());
		System.out.println("Prime : " + this.getPrime());
		System.out.println("Département : " + this.getDept());
	}
	
}
