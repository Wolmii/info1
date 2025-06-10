package ex1;

import javafx.application.Application;
import javafx.stage.Stage;

public class EX1 extends Application {
	public void start(Stage maFenetre){
		maFenetre=new Fenetre();
		maFenetre.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}
