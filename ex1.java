import java.util.*; 

class cours{
    private String intitul;

    public Cours(String i){
        this.intitul=i;
    }

    public void toString(){
        return "cours "+intitul
    }
}

class etudiant{
    private int matricule;
    private String nom, prenom;
    private HashMap<Cours, float> notes

    public Etudiant(int m, String n, String p){
        this.matricule=m;
        this.nom=n;
        this.prenom=p;
        note=new HashMap<Cours, float>();
    }

    public void toString(){
        return matricule+" "+nom+" "+prenom
    }

    public void ajouteN(Cours i, float n){
        notes.put(i, n);
    }

    public void modifN(Cours i, float n){
        notes.put(i, n);
    }

    public void afficheN(){
        for (Cours i : notes.keySet()) {
            System.out.println("Cours: " + i + " Note: " + notes.get(i));
        }
    }

    public void suppN(Cours i){
        notes.remove(i);
    }

    public moy(){
        float moy=0;
        for (float i : notes.values()){
            moy=moy+i;
        }
        System.out.println("Moyenne de l'élève : "+moy);
    }

    public void delivreN(Cours c){
        float n=notes.get(c);
        System.out.println("Cours : "+c+" Note : "+n);
    }

    public float maxN(){
        float max=0;
        for (float i : notes.values()){
            if(max<i){
                max=i;
            }
        }
        return max;
    }

    public float minN(){
        float min=20;
        for (float i : notes.values()){
            if(max>i){
                max=i;
            }
        }
        return min;
    }
}

class groupe{
    private String nom;
    HashSet<Etudiant> group

    public Groupe(String n){
        this.nom=n;
        group=new HashSet<Etudiant>();
    }

    public void ajouter(Etudiant e){
        group.add(e);
    }

    public void supp(Etudiant e){
        group.remove(e);
    }

    public void aff(){
        for(Etudiant i : group){
            System.out.println("Etudiant : "+i);
        }
    }

    public void nombre(){
        int i=group.size();
        System.out.println("le groupe a "+i+" élèves");
    }
}
