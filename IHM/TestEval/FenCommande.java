
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class FenCommande extends Stage {
	CtrlCommande ctrl;
	public FenCommande() throws IOException {
		this.setTitle("Bon de commande");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bonDeCommande.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
}









































