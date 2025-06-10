package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenListeEmployes extends Stage {
	
	public FenListeEmployes() {
		this.setTitle("Liste des employés");
		this.setResizable(true);
		Scene laScene = new Scene(creerSceneGraph());
		this.setMinWidth(520);
		this.setMaxHeight(500);
		this.setScene(laScene);
	}

	private Pane creerSceneGraph()  {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/listeEmployes.fxml"));
        Pane root = new Pane();
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loader.getController();
     	return root;
	}
}

