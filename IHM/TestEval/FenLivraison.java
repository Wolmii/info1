
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class FenLivraison extends Stage {

	public FenLivraison() throws IOException {
		Scene laScene = new Scene(creerSceneGraph());
		this.setTitle("Nouvelle livraison");
		this.setResizable(false);
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("nouvelleLivraison.fxml"));
        Pane root = loader.load();
     	return root;
	}
}









































