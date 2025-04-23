import java.util.*; 

class Sport{
    private int code;
    private String libele;
    
    Sport(int c, String l){
        this.code=c;
        this.libele=l;
    }

    public String toString(){
        return code+" "+libele;
    }

    public void afficher(){
        System.out.println("Code : "+code);
        System.out.println("libele : "+libele);
    }
}

class SportCo extends Sport{
    private int nbJ;

    SportCo(int c, String l, int n){
        super(c, l);
        this.nbJ=n;
    }

    public String toString(){
        return super.toString()+" "+nbJ;
    }

    public void afficher(){
        System.out.println("Sport : ");
        super.afficher();
        System.out.println("Nb Joueurs : "+nbJ);
    }
}

class LesSports{
    private ArrayList <Sport> spo;

    LesSports(){
        spo = new ArrayList <Sport> (100);
    }

    public void ajouter(Sport s){
        spo.add(s);
    }

    public void afficher(){
        for (int i=0;i<spo.size();i++){
            spo.get(i).afficher();
        }
    }
}

public class tp3{
    public static void main(String[] arg){
        LesSports spor;
        spor= new LesSports();
        Sport s1, s4;
        SportCo s2, s3, s5;
        s1=new Sport(1, "tennis");
        s2=new SportCo(2, "basket", 5);
        s3=new SportCo(3, "football", 11);
        s4=new Sport(4, "patin");
        s5=new SportCo(5, "hadball", 6);
        spor.ajouter(s1);
        spor.ajouter(s2);
        spor.ajouter(s3);
        spor.ajouter(s4);
        spor.ajouter(s5);
        spor.afficher();
    }
}
