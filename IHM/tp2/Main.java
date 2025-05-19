package tp2;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import td3_e1.Conv;

public class Main extends Application{
	public void start(Stage maFenetre) throws IOException{
		maFenetre=new ListeClients();
		maFenetre.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
