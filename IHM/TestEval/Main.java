import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	static private FenLivraison fLivraison;
	static private FenCommande fCommande;


	@Override
	public void start(Stage primaryStage) throws Exception {
		fLivraison = new FenLivraison();
		fLivraison.initModality(Modality.APPLICATION_MODAL);
		fCommande = new FenCommande();
		fCommande.initModality(Modality.APPLICATION_MODAL);
		
		fLivraison.show();
	}
		
	
	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public void fermerLivr() {
		System.exit(0);
	}
}









































