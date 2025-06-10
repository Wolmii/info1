package ex2;

import javafx.application.Application;
import javafx.stage.Stage;

public class EX2 extends Application {
	public void start(Stage maFenetre){
		maFenetre=new Fenetre();
		maFenetre.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}