import java.util.*; 

class Personne{
    private String nom;
    private String prenom;
    private String adresse;

    Personne(String n, String p, String a){
        this.nom=n;
        this.prenom=p;
        this.adresse=a;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public void toString(){
        return nom+" "+prenom+" "+adresse;
    }
}

class Entrainer extends Personne{
    private int license

    Entrainer(String n, String p, String a, int l){
        super(n, p, a);
        this.license=l;
    }

    public void getLicense(){
        return this.license;
    }

    public void toString(){
        return super.toString+" "+license;
    }
}

class Jockey extends Personne{
    private int poids;
    private int salaire;

    Jockey(String n, String p, String a, int po, int s){
        super(n, p, a);
        this.poids=po;
        this.salaire=s;
    }

    public void getPoids(){
        return this.poids;
    }

    public void getSalaire(){
        return this.salaire;
    }

    public void toString(){
        return super.toString+" "+poids+" "+salaire;
    }
}

class Cheval{
    private int numero;
    private String nom;
    private char sexe;
    private String race;
    private static int num=0;

    Cheval(String n, char s, String r){
        num++;
        this.numero=num;
        this.nom=n;
        this.sexe=s;
        this.race=r;
    }

    public void getNumero(){
        return this.numero;
    }

    public void getNom(){
        return this.nom;
    }

    public void getRace(){
        return this.race;
    }

    public void getSexe(){
        return this.sexe;
    }

    public void toString(){
        return numero+" "+nom+" "+sexe+" "+race;
    }
}

class ChevalCourse extends Cheval{
    private int gains;
    private Entrainer ent;
    private Jockey jo;

    public ChevalCourse(String n, char s, String r, int g, Entrainer e){
        super(n, s, r);
        this.gains=g;
        this.ent=e;
        this.jo=null;
    }

    public void affiche(){
        System.out.println(super.toString()+" entrainé par "+this.ent.toString());
        System.out.println("gains : "+this.gains);
        if(this.jo=null){
            System.out.println(" monté par "+this.jo.getIdentite());
        } else {
            System.out.println("monté par X");
        }
    } 

    public void attribue_jockey(jockey j){
        this.jo=j;
    }

    public Jockey getJo(){
        return this.jo;
    }

    public Int getGains(){
        return this.gains;
    }
}

class Course{
    private static final int max=10;
    private String nom;
    private int dotation;
    private ArrayList <ChevalCourse> che;

    public Course(String n, int d){
        this.nom=n;
        this.dotation=d;
        che = new ArrayList <ChevalCourse> (max);
    }

    public void affiche(){
        int np=this.che.size();
        System.out.println("\n prix de "+this.nom+" doté de "+this.dotation);
        System.out.println("liste des "+np+" chevaux : ");
        for(int i; i<np; i++){
            this.che.get(i).affiche();
        }
    }

    public void enregistre(ChevalCourse ch){
        if(this.che.size()==max){
            System.out.println("plus de place")
        } else {
            this.che.add(ch);
        }
    }

    public void recherche(int num){
        int np=
    }
}

class public tp32{
    public static void main(String[] arg){

    }
}
