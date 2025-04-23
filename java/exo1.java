abstract class Employe{
    private String nom;
    private int age, nbA;
    private static nb=0;

    public Employe(String n, int a, int b){
        this.nom=n;
        this.age=a;
        this.nbA=b;
        nb++;
    }

    public void getNbA(){
        return this.nbA;
    }
    public void getnom(){
        return this.nom;
    }
    public void getage(){
        return this.age;
    }

    public void toString(){
        return nom+" "+age+" "+nbA
    }
}

class Ouvrier extends Employe{
    private int nbH=35;

    public Ouvrier(String n, int a, int b){
        super(n, a, b);
    }

    abstract void Calcul(){
        int c=4*nbH*(10*this.nbA/2);
    }

    public void affiche(){
        System.out.println("Ouvrier "+ super.toString());
        System.out.println("salaire : "+this.Calcul());
    }
}

class Gerant extends Employe{
    private int nbH=30;

    public Ouvrier(String n, int a, int b){
        super(n, a, b);
    }

    abstract void Calcul(){
        int c=5*nbH*(20*this.nbA/2)
    }

    public void affiche(){
        System.out.println("Gerand "+ super.toString())
        System.out.println("salaire : "+this.Calcul());
    }
}

class ListeEmploye{
    private static final int max=50;
    private ArrayList <Employe> li;

    public ListeEmploye(){
        li=new ArrayList <Employe> (50);
    }

    public void Ajouter(String n, int a, int b, int nb){
        Employe di;
        if(nb==30){
            di = new Gerand(n, a, b);
        } else if (nb==35){
            di = new Ouvrier(n, a, b);
        }
        li.add(di);
    }

    public void tri(){
        int s=this.li.size();
        Employe em, em2, em3;
        for(int i=0; i<s; i++){
            em=this.li.get(i);
            em2=this.li.get(i+1);
            if(em.salaire<em2.salaire){
                em3=em;
                em=em2;
                em2=em3;
            }
        }
    }

    public void affiche(){
        int s=this.li.size();
        for(int i; i<s; i++){
            this.li.get(i).affiche();
        }
    }

    public Employe selectionner(int min, int max){
        int s=this.li.size();

        for(int i=0; i<s; i++){
            if (this.get(i).age>min and this.get(i).age<max){
                A=A+this.get(i);
            }
        }
        return A
    }
}