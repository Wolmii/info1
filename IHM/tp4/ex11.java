package tp4;

import javafx.beans.property.*;

public class ex11 {
	private final IntegerProperty matricule;
	private final StringProperty nom;
	private final StringProperty poste;
	private final IntegerProperty dept;

	public ex11() {
		this.matricule = new SimpleIntegerProperty();
		this.nom = new SimpleStringProperty();
		this.poste = new SimpleStringProperty();
		this.dept = new SimpleIntegerProperty();
	}
	public ex11(int matricule, String nom, String poste, int dept) {
		this.matricule = new SimpleIntegerProperty(matricule);
		this.nom = new SimpleStringProperty(nom);
		this.poste = new SimpleStringProperty(poste);
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
	
	public int getDept() {
		return dept.get();
	}
	public void setDept(int dept) {
		this.dept.set(dept);
	}
	public IntegerProperty deptProperty() {
		return this.dept;
	}
}

