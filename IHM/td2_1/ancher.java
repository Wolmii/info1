package td2_1;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ancher extends Stage{
	private AnchorPane racine = new AnchorPane();
	private Button bnAjouter = new Button ("Ajouter ... ");
	private Button bnSupprimer = new Button ("Supprimer");
	private Button bnModifier = new Button ("Modifier ...");
	private Button bnFermer = new Button ("Fermer");
	String valeurs[] = {"Charles Baudelaire", "Albert Camus"};
	ListView<String> list = new ListView<String>();
	
	public ancher() {
		Scene laScene = new Scene(creerScene());
		this.setTitle("boutons");
		this.setScene(laScene);
		this.setResizable(true);
	}
	
	private Parent creerScene() {
		list.getItems().addAll(valeurs);
		racine.setTopAnchor(bnAjouter, 10.0);
		racine.setRightAnchor(bnAjouter, 10.0);
		racine.setTopAnchor(bnModifier, 40.0);
		racine.setRightAnchor(bnModifier, 10.0);
		racine.setTopAnchor(bnSupprimer, 70.0);
		racine.setRightAnchor(bnSupprimer, 10.0);
		racine.setBottomAnchor(bnFermer, 10.0);
		racine.setRightAnchor(bnFermer, 10.0);
		racine.setTopAnchor(list, 10.0);
		racine.setLeftAnchor(list, 10.0);
		racine.setRightAnchor(list, 100.0);
		racine.setBottomAnchor(list, 10.0);
		racine.getChildren().addAll(bnAjouter, bnModifier, bnSupprimer, bnFermer, list);
		return racine;
	}
}
