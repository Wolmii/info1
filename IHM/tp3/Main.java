package tp3;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	static private Formulaire fenetre;
	public void start(Stage maFenetre) throws IOException{ 
		fenetre=new Formulaire();
		fenetre.show();
	}
	
	static public void fermer() {
		fenetre.close();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}
