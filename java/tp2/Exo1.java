import java.util.*;

class Voiture{
    static private int ida;
    private int id;
    private String marque;
    private float vitesse;
    private float kilometres;
    public Voiture(String marq ,float vit, float kilo){
        marque=marq;
        vitesse=vit;
        kilometres=kilo;
        id=ida;
        ida++;
    }
    public Voiture(){
        marque="pas";
        vitesse=0;
        kilometres=0;
        id=ida;
        ida++;
    }
    public int getId(){
        return this.id;
    }
    public String getMarque(){
        return this.marque;
    }
    public float getVitesse(){
        return this.vitesse;
    }
    public float getKilometres(){
        return this.kilometres;
    }
    public void setId(int ide){
        this.id=ide;
    }
    public void setMarque(String mar){
        this.marque=mar;
    }
    public void setVitesse(float vites){
        this.vitesse=vites;
    }
    public void setKilometres(float kilos){
        this.kilometres=kilos;
    }
    public String toString(){
        return "id : "+ id+ "\nmarque : "+ marque+ "\nvitesse : "+ vitesse+ "\nkilometres : "+ kilometres+ "\n";
    }
}

public class Exo1{
    public static void main(String [] args){
        Voiture voit, vroum;
        voit=new Voiture("peugeot", 140, 135000);
        System.out.println(voit);
        vroum=new Voiture();
        System.out.println(vroum);
        voit.setMarque("reno");
        System.out.println(voit);
    }
}
