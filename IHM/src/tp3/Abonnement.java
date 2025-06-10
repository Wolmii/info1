package tp3;

public class Abonnement {
	private int numero;				// attribué automatiquement
	private String nom;
	private String prenom;
	private String adresse1;
	private String adresse2;
	private String codePostal;
	private String ville;
	private String telephone;
	private String adresseMail;
	private String formule;			// "DUO 1 an" ou "NUMERIQUE 1 an"
	private String modeReglement;	// "Chèque" ou "Prélèvement"
	private boolean acceptation;
	
	static private int nbAbonnements = 0;

	////////////////////////////////////////////
	// constructeur de la classe
	////////////////////////////////////////////
	public Abonnement(String nom, String prenom, String adresse1, String adresse2, String codePostal,
			String ville, String telephone, String adresseMail, String formule, String modeReglement,
			boolean acceptation) {
		
		Abonnement.nbAbonnements++;
		this.numero = Abonnement.nbAbonnements;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.adresseMail = adresseMail;
		this.formule = formule;
		this.modeReglement = modeReglement;
		this.acceptation = acceptation;
	}

	////////////////////////////////////////////
	// getters et setters
	////////////////////////////////////////////
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
	public String getAdresse1() {
		return adresse1;
	}
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	public String getAdresse2() {
		return adresse2;
	}
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getFormule() {
		return formule;
	}
	public void setFormule(String formule) {
		this.formule = formule;
	}
	public String getModeReglement() {
		return modeReglement;
	}
	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}
	public boolean isAcceptation() {
		return acceptation;
	}
	public void setAcceptation(boolean acceptation) {
		this.acceptation = acceptation;
	}
	public int getNumero() {
		return numero;
	}
	public static int getNbAbonnements() {
		return nbAbonnements;
	}

	public void afficher() {
		System.out.println("\t\tABONNEMENT N° " + this.numero);
		System.out.println("\t\t----------------");
		System.out.println(this.nom.toUpperCase()+" "+this.prenom);
		System.out.println("ADRESSE :\t" + this.adresse1);
		System.out.println("\t\t" + this.adresse2);
		System.out.println("\t\t" + this.codePostal + " " + this.ville);
		if (telephone==null) {
			System.out.println("(non renseigné)");
		} else {
			System.out.println("TEL : " + this.telephone);
		}
		System.out.println("MAIL : " + this.adresseMail);
		System.out.println("FORMULE : " + this.formule);
		System.out.println("PAIEMENT PAR : " + this.modeReglement);
		if (this.acceptation) System.out.println("(accepte de recevoir les infos du journal)");
		else System.out.println("(N'ACCEPTE PAS de recevoir les infos du journal)");
		System.out.println("\n");
	}

}
