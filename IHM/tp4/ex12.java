package tp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.binding.Bindings;

public class ex12 extends Application {
	// les donn�es
	ObservableList<String> liste = FXCollections.observableArrayList();
	
	// les composants de la fenetre
	private AnchorPane  		racine	= new AnchorPane();
	private ListView<String> 	listeEmployes= new ListView<String>();
	private Button 				bnAjouter 	= new Button("Ajouter");
	private Button 				bnSupprimer = new Button("Supprimer");

	// constructeur : initialisation de la fenetre
	public void start(Stage f){
		liste.add("LECLERC");
		liste.add("BIRAUD");
		liste.add("BERGER");
		liste.add("MERCIER");
		f.setTitle("Liste des employ�s");
		f.setMinWidth(300);
		f.setMinHeight(300);
		f.setResizable(true);
		f.setScene(new Scene(creerSceneGraph()));	
		f.show();
	}
	
	
	private Pane creerSceneGraph() {
		listeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// A FAIRE : lier le ListView a la liste observable "liste"
		listeEmployes.setItems(liste);
		
		
		
		
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> liste.add("Clint Eastwood"));
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> {
			if (listeEmployes.getSelectionModel().getSelectedIndex()!=-1) {
				liste.remove(listeEmployes.getSelectionModel().getSelectedIndex() );
			}
		});
		bnSupprimer.disableProperty().bind(
				Bindings.equal(listeEmployes.getSelectionModel().selectedIndexProperty(), -1));
			
		// creation du Scene graph
		AnchorPane.setTopAnchor(bnAjouter, 10.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 50.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setTopAnchor(listeEmployes, 10.0);
		AnchorPane.setLeftAnchor(listeEmployes, 10.0);
		AnchorPane.setRightAnchor(listeEmployes, 150.0);
		AnchorPane.setBottomAnchor(listeEmployes, 10.0);	
		racine.getChildren().addAll(listeEmployes, bnAjouter, bnSupprimer);
		return racine;
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}

