import java.util.*; 

class Voiture{
    private String immatriculation;
    private String modele;
    private int kilomtrage;
    private float prixklmt;

    Voiture(){
        Scanner entree=new Scanner(System.in);
        System.out.println("Entrez plaque :");
        this.immatriculation = entree.next();
        System.out.println("Entrez modèle :");
        this.modele = entree.next();
        System.out.println("Entrez killometrage :");
        this.kilomtrage = entree.nextInt();
        System.out.println("Entrez prix :");
        this.prixklmt = entree.nextFloat();
    }

    public String getImma(){
        return this.immatriculation;
    }

    public String getModele(){
        return this.modele;
    }

    public int getKilo(){
        return this.kilomtrage;
    }

    public float getPrix(){
        return this.prixklmt;
    }

    public void afficher(){
        System.out.println("Immatriculation : "+immatriculation);
        System.out.println("Modele : "+modele);
        System.out.println("Killometrage : "+kilomtrage);
        System.out.println("Prix : "+prixklmt);
    }
}

class Client{
    static private int num;
    private int numero;
    private String nom;
    private String domicile;

    Client(String n, String dom){
        this.nom=n;
        this.domicile=dom;
        this.numero=num;
        num++;
    }

    public String getNom(){
        return this.nom;
    }

    public int getNum(){
        return this.numero;
    }

    public float getDom(){
        return this.domicile;
    }

    public void afficher(){
        System.out.println("Numéro : "+numero);
        System.out.println("Nom : "+nom);
        System.out.println("Domicile : "+domicile);
    }
}

class Date{
    private int jour;
    private int mois;
    private int annee;

    Date(){
        Scanner entree=new Scanner(System.in);
        System.out.println("Entrez jour :");
        this.jour = entree.nextInt();
        System.out.println("Entrez mois :");
        this.mois = entree.nextInt();
        System.out.println("Entrez année :");
        this.annee = entree.nextInt(); 
    }

    public void afficher(){
        System.out.println(jour+"/"+mois+"/"+annee);
    }

    public void setJour(int j){
        this.jour=j;
    } 

    public void setMois(int m){
        this.mois=m;
    }

    public void setAnnee(int a){
        this.annee=a;
    }
}


class Location{
    static private int num;
    private int numero;
    private Voiture voit;
    private Client cli;
    private Date debut;
    private Date fin;
    private Float nbKilo;

    Location(Voiture v, Client c, Date d){
        this.numero=num;
        num++;
        this.voit=v;
        this.cli=c;
        this.debut=d;
        this.fin=NULL;
        this.nbKilo=this.voit.getKilo;
    }

    public setRetour(Date f, Voiture v){
        this.fin=f;
        this.voit=v;
        this.nbKilo=this.voit.getKilo;
    }

    public void afficher(){
        System.out.println("Numéro : "+numero);
        System.out.println("Voiture : ");
        voit.afficher();
        System.out.println("Client : ");
        cli.afficher();
        System.out.println("Date début : ");
        debut.afficher();
        System.out.println("Date fin : ");
        fin.afficher();
        System.out.println("Nombre de kilomètres : "+nbKilo);
    }
}

class Agence{
    private ArrayList <Voiture> voit;
    voit = new ArrayList <Voiture> (100);
    private ArrayList <Voiture> voit;
    voit = new ArrayList <Voiture> (100);
    private ArrayList <Voiture> voit;
    voit = new ArrayList <Voiture> (100);
}

public class P2{    
    public static void main(String[] args){
        /*
        ArrayList <Voiture> ma;
        ma = new ArrayList <Voiture> (10);
        Voiture v1, v2, v3;
        v1=new Voiture();
        v2=new Voiture();
        v3=new Voiture();
        ma.add(v1);
        ma.add(v2);
        ma.add(v3);
        for(int i=0; i<ma.size(); i++){
            v1=ma.get(i);
            v1.afficher();
        }
        ma.remove(v2);
        for(int i=0; i<ma.size(); i++){
            v1=ma.get(i);
            v1.afficher();
        }
        
       Client c1, c2;
       c1=new Client("Regnier", "25 rue ici");
       c2=new Client("Roques", "94 rue la bas");
       c1.afficher();
       c2.afficher();
       
        Date d1, d2, d3;
        d1=new Date();
        d2=new Date();
        d3=new Date();
        d1.afficher();
        d2.afficher();
        d3.afficher();
        d2.setMois(12);
        d2.afficher();
        */
    }
}
