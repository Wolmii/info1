package td3_1;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
	public void start(Stage maFenetre){
		maFenetre=new anim();
		maFenetre.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
