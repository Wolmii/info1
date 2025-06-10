package controler;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.*;
import vue.*;

public class Main extends Application{
	static private FenNouvelEmploye fNouvEmp;
	static private FenModifierEmploye fModifierEmp;
	static private FenListeEmployes fListeEmp;
	
	public void start(Stage f) throws Exception {
		
		Donnees.chargementDonnees();
		//initialisation des fenêtres
		fNouvEmp = new FenNouvelEmploye();
		fNouvEmp.initModality(Modality.APPLICATION_MODAL);
		fModifierEmp = new FenModifierEmploye();
		fModifierEmp.initModality(Modality.APPLICATION_MODAL);
		fListeEmp = new FenListeEmployes();
		fListeEmp.show();
	} 
	
	static public void main(String args[]) { 
		Application.launch(args); 
	}
	
	static public void fermerAppli() {
		System.exit(0);
	}
	
	
	///////////////////////
	// gestion des fenêtres
	///////////////////////
	static public void ouvrirNouvelEmploye() {
		fNouvEmp.effacer();
		fNouvEmp.show();
	}
	
	static public void fermerNouvelEmploye() {
		fNouvEmp.close();
	}
	
	static public void ouvrirModifierEmploye(Employe e) {
		fModifierEmp.afficherEmploye(e);
		fModifierEmp.show();
	}
	
	static public void fermerModifierEmploye() {
		fModifierEmp.close();
	}
	
	
	
	//////////////////////////////////////////
	// gestion des données : les modifications
	//////////////////////////////////////////
	static public void ajouterEmploye(int mat, String nom, String poste, int sup, int jour, int mois, int annee, float sal, float pri, int dpt) { 
		// créer le nouvel employé
		Employe e = new Employe(mat, nom, poste, sup, jour+"/"+mois+"/"+annee, sal, pri, dpt);
		// enregistrer l'ajout
		Donnees.ajouterEmploye(e);
		fNouvEmp.close();
	}
	
	static public void modifierEmploye(int mat, String nom, String poste, int sup, int jour, int mois, int annee, float sal, float pri, int dpt) { 
		// créer le nouvel employé
		Employe e = new Employe(mat, nom, poste, sup, jour+"/"+mois+"/"+annee, sal, pri, dpt);
		// enregistrer la modif ; en fait remplacer l'ancien par le nouveau
		Donnees.modifierEmploye(e);
		fModifierEmp.close();
	}
	
	static public void supprimerEmploye(Employe e) {
		Donnees.supprimerEmploye(e);
	}

	
	//////////////////////////////////////////
	// gestion des données : les consultations
	//////////////////////////////////////////
	static public ObservableList<Employe> getLesEmployes(){
		return Donnees.getLesEmployes();
	}
	
	static public ArrayList<Integer> getLesSuperieurs(){
		return Donnees.getLesSuperieurs();
	}
	
	static public ArrayList<Integer> getLesDepartements(){
		return Donnees.getLesDepartements();
	}
}
