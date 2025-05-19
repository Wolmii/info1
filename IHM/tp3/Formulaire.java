package tp3;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Formulaire extends Stage{
	public Formulaire() throws IOException {
		this.setTitle("Bulletin d’abonnement");
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}
	
	private Pane creerSceneGraph() throws IOException {
		File fichier = new File("/home/etuinfo/maregnier/Documents/ihm/formulaire.fxml");
		FXMLLoader loader;
		loader = new FXMLLoader(fichier.toURI().toURL());
		Pane racine = loader.load();
		return racine;
	}
}
