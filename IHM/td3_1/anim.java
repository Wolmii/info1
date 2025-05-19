package td3_1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class anim extends Stage{
	private final String text = "Nombre de clicks : ";
	private int nbClics = 0;
	private HBox racine = new HBox();
	private Button bouton = new Button("OK");
	private Label message = new Label(text + nbClics);
	
	public anim() {
		this.setTitle("Exemple");
		this.setResizable(true);
		this.setScene(new Scene(creerSceneGraph() ) );
		this.sizeToScene();
		this.racine.getChildren().add(bouton);
		this.racine.getChildren().add(message);
	}
	
	private HBox creerSceneGraph() {
		// A COMPLETER : construire le Scene Graph
		// A COMPLETER : pose d'un écouteur et programmation du
		// traitement de l'événement par une expression lambda
		bouton.setOnAction(nbClics -> incrementerNbClics());
		
		return racine;
	}
	
	private void incrementerNbClics(){
		nbClics++;
		message.setText("Nombre de clics = "+ nbClics);
	}
}
