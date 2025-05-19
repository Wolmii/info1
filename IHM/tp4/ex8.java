package tp4;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ex8 extends Application{
	
	public void start(Stage f) {
		Label lblTexte1 = new Label("Texte :");
		TextField tfChamp1 = new TextField();
		Button bnFermer = new Button("Fermer");
		bnFermer.setOnAction(e -> f.close() );
		
		//A FAIRE programmer la lisison entre données
		f.titleProperty().bind(tfChamp1.textProperty());

		
		GridPane grid = new GridPane();
		grid.addRow(0, lblTexte1, tfChamp1);
		grid.add(bnFermer, 1, 1);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		Scene scene = new Scene(grid);
		f.setScene(scene);
		f.show();
	}
	
	
	
	static public void main(String args[]) {
		Application.launch();
	}
	
}


