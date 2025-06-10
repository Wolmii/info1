package tp4;

import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class exo9 extends Application{
	static private final double TAUX_DE_CHANGE = 1.09;
	
	public void start(Stage f){
		// les composants du formulaire
		Label 		labelEuro 	= new Label("Euros :");
		TextField 	txtEuros 	= new TextField("0.0");
		Label 		labelDollar = new Label("Dollars :");
		TextField 	txtDollar 	= new TextField("0.0");
		Button 		bnFermer 	= new Button("Fermer");

		// les propriétés
		final SimpleDoubleProperty valEuros = new SimpleDoubleProperty();
		final SimpleDoubleProperty valDollars = new SimpleDoubleProperty();
		
		//A FAIRE établir toutes les liaisons entre données
		valDollars.bind(valEuros.multiply(TAUX_DE_CHANGE));
		
		valEuros.bind(Bindings.createDoubleBinding( ()->
		Double.parseDouble(txtEuros.getText()),txtEuros.textProperty())
		);
		
		txtDollar.textProperty().bind(Bindings.createStringBinding( () ->
		String.valueOf(valDollars.get()), valDollars));

		bnFermer.setOnAction(e -> f.close());
		GridPane grid = new GridPane();
		grid.addRow(0, labelEuro, txtEuros);
		grid.addRow(1, labelDollar, txtDollar);
		grid.add(bnFermer, 3, 2);
		grid.setPadding(new Insets(10));
		grid.setVgap(10);
		Scene scene = new Scene(grid);
		f.setTitle("Convertisseur");
		f.setScene(scene);
		f.setResizable(false);
		f.show();
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}

