package tp2;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ListeClients extends Stage{
	
	public ListeClients() throws IOException {
		this.setTitle("Gestion de client");
		this.setResizable(true);
		this.setHeight(350);
		this.setWidth(300);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}
	
	private Pane creerSceneGraph() throws IOException {
		File fichier = new File("/home/etuinfo/maregnier/Documents/ihm/listeClients.fxml");
		FXMLLoader loader;
		loader = new FXMLLoader(fichier.toURI().toURL());
		Pane racine = loader.load();
		return racine;
	}
}
