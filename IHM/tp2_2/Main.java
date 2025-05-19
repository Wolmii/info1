package tp2_2;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public void start(Stage maFenetre) throws IOException{
		maFenetre=new Coul();
		maFenetre.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
