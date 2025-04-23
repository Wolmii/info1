import java.util.*;

class Produit{
    private String reference;
    private int entree;
    public String toString(){
        return "\nréférence : "+reference +"\ndate : "+entree +"\n";
    }
    public Produit(int date){
        entree=date;
        Scanner entree=new Scanner(System.in);
        System.out.println("entrez référence :");
        reference=entree.next();
    } 
}

class Pile{
    private int indice, tmax;
    private Produit tab [] = new Produit[tmax];
    public Pile(int max){
        tmax=max;
        indice=0;
    }
    boolean pileVide(){
        boolean bool;
        if(indice==0){
            bool=Vrai;
        }
        else{
            bool=Faux;
        }
        return bool;
    }
    boolean pilePleine(){
        boolean bool;
        if(indice==tmax){
            bool=Vrai;
        }
        else{
            bool=Faux;
        }
        return bool;
    }
    void empiler(Produit p){
        if(this.pilePleine()==Faux){
            tab[indice]=p;
            indice++;
        }
        else{
            System.out.println("Plein");
        }
    }
    void depiler(){
        if(this.pileVide()==Faux){
            indice--;
        }
        else{
            System.out.println("Vide");
        }
    }
    Produit sommet(){
        return tab[indice-1];
    }
    void afficherStock(){
        int i;
        for(i=0; i<=indice-1; i++){
            System.out.println(tab[i]);
        }
    }
}

public class Exo2{
    public static void main(String [] args){
        Produit p1;
        p1=new Produit(35);
        System.out.println(p1);
    }
}
