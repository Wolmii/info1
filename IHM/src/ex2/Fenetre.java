package ex2;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Fenetre extends Stage {
	private RadioButton rbBleu = new RadioButton("Bleu");
	private RadioButton rbVert = new RadioButton("Vert");
	private RadioButton rbRouge = new RadioButton("Rouge");
	private RadioButton rbJaune = new RadioButton("Jaune");
	private Group racine=new Group();
	
	public Fenetre() {
		Scene laScene = new Scene(creerScene());
		this.setTitle("Couleurs !!");
		this.setScene(laScene);
	}
	
	private Parent creerScene() {
		this.rbBleu.setLayoutX(10);
		this.rbBleu.setLayoutY(40);
		this.rbVert.setLayoutX(10);
		this.rbVert.setLayoutY(80);
		this.rbRouge.setLayoutX(10);
		this.rbRouge.setLayoutY(120);
		this.rbJaune.setLayoutX(10);
		this.rbJaune.setLayoutY(160);
		this.racine.getChildren().add(rbBleu);
		this.racine.getChildren().add(rbVert);
		this.racine.getChildren().add(rbRouge);
		this.racine.getChildren().add(rbJaune);
		return racine;
	}
}
