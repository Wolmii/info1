package tp4;

import javafx.beans.binding.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.geometry.Insets;
import javafx.application.Application;

public class ex14 extends Application {
	// les données
	ObservableList<ex11> liste = FXCollections.observableArrayList();
	
	// les composants de la fenêtre
	private VBox				racine			= new VBox();
	private GridPane			zoneDetail		= new GridPane();
	private AnchorPane  		zoneTable		= new AnchorPane();
	private TableView<ex11> 	tableEmployes	= new TableView<ex11>();
	private Button 				bnAjouter 		= new Button("Ajouter");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	private Label 				lblMatricule	= new Label("Matricule (*) :");
	private Label 				lblNom			= new Label("Nom employé (*) :");
	private Label 				lblPoste		= new Label("Poste :");
	private Label 				lblDepartement	= new Label("Département (*) :");
	private TextField			txtMatricule	= new TextField();
	private TextField			txtNom			= new TextField();
	private TextField			txtPoste		= new TextField();
	private TextField			txtDepartement	= new TextField();
	
	// constructeur : initialisation de la fenetre et des donn�es
	public void start(Stage f){
		liste.add(new ex11(7369,"LECLERC","SECRETAIRE", 20) );
		liste.add(new ex11(7499,"BIRAUD","COMMERCIAL", 30) );
		liste.add(new ex11(7521,"BERGER","COMMERCIAL", 30) );
		liste.add(new ex11(7566,"MERCIER","DIRECTEUR", 20) );
		liste.add(new ex11(7654,"MARTIN","COMMERCIAL", 30) );
		liste.add(new ex11(7698,"NOIRET","DIRECTEUR", 30) );
		liste.add(new ex11(7782,"LESAGE","DIRECTEUR", 10) );
		
		f.setTitle("Liste des employés");
		f.sizeToScene();
		f.setResizable(true);
		f.setScene(new Scene(creerSceneGraph()));
		f.show();
	}
	
	private Pane creerSceneGraph() {
		tableEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
							
		// A FAIRE : associer la liste au TableView
		//lier ex13 a ex11
		tableEmployes.setItems(liste);
		
		// creation du TableView : 4 colonnes
		TableColumn<ex11,Integer> colonne1 = new TableColumn<ex11,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<ex11,Integer>("matricule"));
		tableEmployes.getColumns().add(colonne1);		
		TableColumn<ex11, String> colonne2 = new TableColumn<ex11,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<ex11, String>("nom"));
		tableEmployes.getColumns().add(colonne2);
		TableColumn<ex11, String> colonne3 = new TableColumn<ex11,String>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<ex11, String>("poste"));
		tableEmployes.getColumns().add(colonne3);
		TableColumn<ex11,Integer> colonne4 = new TableColumn<ex11,Integer>("Dépt");
		tableEmployes.getColumns().add(colonne4);
		
		// A FAIRE : en cas de changement d'élément sélectionné dans la table (clic sur le
		// TableView) actualiser les 4 champs de la zone "Detail"
		tableEmployes.setOnMouseClicked(e -> {
			StringConverter <Number> converter = new NumberStringConverter();
			Bindings.bindBidirectional(txtMatricule.textProperty(), tableEmployes.getSelectionModel().getSelectedItem().matriculeProperty(), converter);
			txtNom.textProperty().bindBidirectional(tableEmployes.getSelectionModel().getSelectedItem().nomProperty());
			txtPoste.textProperty().bindBidirectional(tableEmployes.getSelectionModel().getSelectedItem().posteProperty());
			Bindings.bindBidirectional(txtDepartement.textProperty(), tableEmployes.getSelectionModel().getSelectedItem().deptProperty(), converter);
		});
		
		bnAjouter.setPrefWidth(100);
		
		// clic sur le bouton Ajouter
		bnAjouter.setOnAction(e -> liste.add(new ex11(
				Integer.parseInt(txtMatricule.getText()), 
				txtNom.getText(), 
				txtPoste.getText(), 
				Integer.parseInt(txtDepartement.getText())) )
		);
		
		// A FAIRE : griser le bouton Ajouter s'il manque une donnée obligatoire
		bnAjouter.disableProperty().bind(
				txtMatricule.textProperty().isEmpty().or(txtNom.textProperty().isEmpty()).or(txtDepartement.textProperty().isEmpty()));
		
		
		
		
		bnSupprimer.setPrefWidth(100);
		// A FAIRE : programmer le clic sur le bouton Supprimer
		bnSupprimer.setOnAction(e -> liste.remove(tableEmployes.getSelectionModel().getSelectedIndex()));
		txtNom.setText(" ");
		txtMatricule.setText(" ");
		txtDepartement.setText(" ");
		txtPoste.setText(" ");
		
		
		
		
		
		// A FAIRE : griser le bouton Supprimer si aucune sélection
		bnSupprimer.disableProperty().bind(
				Bindings.equal(tableEmployes.getSelectionModel().selectedIndexProperty(), -1));
		
		
		
		// clic sur le bouton Fermer
		bnFermer.setPrefWidth(100);
		bnFermer.setOnAction(e -> System.exit(0)); 
		
		// creation du Scene graph
		AnchorPane.setTopAnchor(tableEmployes, 10.0);
		AnchorPane.setLeftAnchor(tableEmployes, 10.0);
		AnchorPane.setRightAnchor(tableEmployes, 40.0);
		AnchorPane.setBottomAnchor(tableEmployes, 10.0);
		zoneTable.getChildren().add(tableEmployes);
		zoneDetail.addRow(0,  lblMatricule, txtMatricule, bnAjouter);
		zoneDetail.addRow(1,  lblNom, txtNom, bnSupprimer);
		zoneDetail.addRow(2,  lblPoste, txtPoste);
		zoneDetail.addRow(3,  lblDepartement, txtDepartement, bnFermer);
		zoneDetail.setHgap(10);
		zoneDetail.setVgap(10);
		zoneDetail.setPadding(new Insets(10));
		racine.getChildren().addAll(zoneTable, zoneDetail);
		return racine;
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}

