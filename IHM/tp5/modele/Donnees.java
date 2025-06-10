package modele;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnees {
	static private ObservableList<Departement> 	lesDepartements = FXCollections.observableArrayList();
	static private ObservableList<Employe> 		lesEmployes 	= FXCollections.observableArrayList();

	static public void chargementDonnees() { 
		lesDepartements.add(new Departement(10,"FINANCES","PARIS"));
		lesDepartements.add(new Departement(20,"RECHERCHE","GRENOBLE"));
		lesDepartements.add(new Departement(30,"VENTES","LYON"));
		lesDepartements.add(new Departement(40,"FABRICATION","ROUEN"));
		
		lesEmployes.add(new Employe(7369,"LECLERC","SECRETAIRE",7902,"1980/12/02",6400.00f,-1,20));
		lesEmployes.add(new Employe(7499,"BIRAUD","COMMERCIAL",7698,"1981/02/20",12800.00f,2400.00f,30));
		lesEmployes.add(new Employe(7521,"BERGER","COMMERCIAL",7698,"1981/10/22",10000.00f,4000.00f,30));
		lesEmployes.add(new Employe(7566,"MERCIER","DIRECTEUR",7839,"1981/03/02",23000.00f,-1,20));
		lesEmployes.add(new Employe(7654,"MARTIN","COMMERCIAL",7698,"1981/05/28",10000.00f,11200.00f,30));
		lesEmployes.add(new Employe(7698,"NOIRET","DIRECTEUR",7839,"1981/05/01",22800.00f,-1,30));
		lesEmployes.add(new Employe(7782,"LESAGE","DIRECTEUR",7839,"1981/06/09",19600.00f,-1,10));
		lesEmployes.add(new Employe(7788,"DUBOIS","INGENIEUR",7566,"1985/04/14",24000.00f,-1,20));
		lesEmployes.add(new Employe(7839,"LEROY","PRESIDENT",-1,"1981/11/07",40000.00f,-1,10));
		lesEmployes.add(new Employe(7844,"BENAIN","COMMERCIAL",7698,"1981/05/08",12000.00f,0.00f,30));
		lesEmployes.add(new Employe(7876,"CLEMENT","SECRETAIRE",7788,"1985/05/10",8800.00f,-1,20));
		lesEmployes.add(new Employe(7900,"FREMONT","SECRETAIRE",7698,"1981/12/03",7600.00f,-1,30));
		lesEmployes.add(new Employe(7902,"CHATEL","INGENIEUR",7566,"1981/12/17",24000.00f,-1,20));
		lesEmployes.add(new Employe(7934,"VILLARD","SECRETAIRE",7782,"1982/08/23",10400.00f,-1,10));
	}

	
	/////////////////////////////////////////////////////////////////////
	// méthodes (ou "requêtes") de consultation : elles fournissent des listes de données
	/////////////////////////////////////////////////////////////////////
	static public ObservableList<Employe> getLesEmployes() {
		return lesEmployes;
	}
	
	static public ArrayList<Integer> getLesDepartements() {
		// fournit la liste des numéros de départements
		ArrayList<Integer> lesDepPossibles = new ArrayList<Integer>();
		for(int i=0 ; i<lesDepartements.size() ; i++) {
			lesDepPossibles.add(lesDepartements.get(i).getNumero());
		}
		return lesDepPossibles;
	}
	
	static public ArrayList<Integer> getLesSuperieurs() {
		// fournit la liste des matricules
		ArrayList<Integer> lesSuperieurs = new ArrayList<Integer>();;
		for(int i=0 ; i<lesEmployes.size() ; i++) {
			lesSuperieurs.add(lesEmployes.get(i).getMatricule());
		}
		return lesSuperieurs;
	}
	
	
	//////////////////////////
	// méthodes (ou "requêtes") de mise à jour
	//////////////////////////
	static public void ajouterEmploye(Employe e) {
		lesEmployes.add(e);
	}
	
	static public void supprimerEmploye(Employe e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesEmployes.size()) {
			if ( lesEmployes.get(i).getMatricule() == e.getMatricule() ){
				for(int z=0;z<lesEmployes.size();z++) {
					if(lesEmployes.get(i).getMatricule()==lesEmployes.get(z).getSuperieur()) {
						System.out.println("Pas de suppression de supérieur");
						trouve = true;
					}
				}
				lesEmployes.remove(i);
				trouve = true;
			}
			i++;
		}
	}
	
	static public void modifierEmploye(Employe e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesEmployes.size()) {
			if ( lesEmployes.get(i).getMatricule() == e.getMatricule() ){
				lesEmployes.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
}
