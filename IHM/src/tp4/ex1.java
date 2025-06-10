package tp4;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ex1 {
	public static void main(String[] args) {
		SimpleIntegerProperty rayon = new SimpleIntegerProperty(50);
		SimpleIntegerProperty p1 = new SimpleIntegerProperty(20);
		SimpleIntegerProperty p2 = new SimpleIntegerProperty(30); //pour 1 et 2 : (rien) si bind()
		SimpleIntegerProperty nb = new SimpleIntegerProperty(11);
		SimpleStringProperty texte = new SimpleStringProperty("28");
		//1. p2.bind(p1); p2 est liée à p1, p2 seul ne peut pas être mofdifié
		//2. p2.bindBidirectional(p1); les deux lié : mofier l'un modifie l'autre auto
		//3. p1.add(p2), rayon.multiply(…), substract(…) et divide(…)
		//3. DoubleBinding perimetre = rayon.multiply(2*Math.PI);
		//   NumberBinding total = p1.add(p2); 
		//4. Bindings.bindBidirectional(p2, p1);
		//   NumberBinding res = add(multiply(a,b),multiply(c,d));//res = a*b + c*d
		//   création du "converter" nombre <-> chaine
		//   NumberStringConverter converter = new NumberStringConverter();
		//   liaison bidirectionnelle qui utilise le "converter"
		//   Bindings.bindBidirectional(texte, nb, converter);
		//   texte.setValue("25");
		//4.2
		//StringBinding convert =
		//		Bindings.createStringBinding( () -> String.valueOf(nb.get()), nb);
		//texte.bind(convert);
		//4.3 when() , then() et otherwise()
		SimpleDoubleProperty somme = new SimpleDoubleProperty(100);
		SimpleDoubleProperty nb2 = new SimpleDoubleProperty(0);
		SimpleDoubleProperty moyenne = new SimpleDoubleProperty();
		BooleanBinding casErreur = Bindings.equal(nb2, 0);
		moyenne.bind(Bindings.when(casErreur).then
		(-1.0).otherwise(Bindings.divide(somme, nb2)));
		
		System.out.println(moyenne.get());
		//System.out.println(total.getValue()); //3. pour numberBinding
	}
}