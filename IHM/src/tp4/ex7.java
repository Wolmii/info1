package tp4;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.effect.*;

public class ex7 extends Application{
	private Label 		lblTexte1 	= new Label("Texte :");
	private TextField 	saisie 		= new TextField();
	private Label 		lblTexte2 	= new Label("Aperçu :");
	private TextField 	apercu		= new TextField();
	private Button 		bnFermer 	= new Button("Fermer");
	
	public void start(Stage f) {
		bnFermer.setOnAction(e -> f.close() );
		apercu.setStyle("-fx-text-fill:red;-fx-font-weight:bold;-fx-font-size:36");
		
		//A FAIRE programmer la lisison entre données
		apercu.textProperty().bindBidirectional(saisie.textProperty());
		
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblTexte1, saisie);
		grid.addRow(1, lblTexte2, apercu);
		grid.add(bnFermer, 2, 2);
		grid.setVgap(30);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		Scene scene = new Scene(grid);
		f.setScene(scene);
		f.setTitle("Aperçu");
		f.show();	
	}
	
	static public void main(String args[]) {
		Application.launch();
	}
}
