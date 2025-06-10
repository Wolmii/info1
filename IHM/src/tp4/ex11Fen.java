package tp4;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.beans.binding.Bindings;

public class ex11Fen extends Application {
	
	ex11 emp = new ex11(7369,"LECLERC","SECRETAIRE", 20);
	
	// les composants de la fenetre
	private GridPane	racine			= new GridPane();
	private HBox		zoneBoutons		= new HBox();
	private Label 		lblMatricule	= new Label("Matricule :");
	private Label 		lblNom			= new Label("Nom employé :");
	private Label 		lblPoste		= new Label("Poste :");
	private Label 		lblDepartement	= new Label("Département :");
	private TextField	txtMatricule	= new TextField();
	private TextField	txtNom			= new TextField();
	private TextField	txtPoste		= new TextField();
	private TextField	txtDepartement	= new TextField();
	private Button		bnChangerNom	= new Button("changer Nom");
	private Button		bnChangerPoste	= new Button("changer Poste");
	
	// constructeur : initialisation de la fenetre
	public void start(Stage f){
		f.setTitle("Détail d'un employé");
		f.setResizable(true);
		f.sizeToScene();
		f.setResizable(false);
		f.setScene(new Scene(creerSceneGraph()));	
		f.show();
	}
	
	private Pane creerSceneGraph() {
		
		// A FAIRE : lier les TextFields aux propriétés de l'objet Employe
		StringConverter <Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(txtMatricule.textProperty(), emp.matriculeProperty(), converter);
		txtNom.textProperty().bind(emp.nomProperty());
		txtPoste.textProperty().bind(emp.posteProperty());
		Bindings.bindBidirectional(txtDepartement.textProperty(), emp.deptProperty(), converter);
		
		
		
		
		
		
		
		bnChangerNom.setPrefWidth(100);
		bnChangerNom.setOnAction(e -> {
			emp.setNom("BIRAUD");
		});
		
		bnChangerPoste.setPrefWidth(100);
		bnChangerPoste.setOnAction(e -> {
			emp.setPoste("INGENIEUR");
		});

		racine.addRow(0, lblMatricule, txtMatricule);
		racine.addRow(1, lblNom, txtNom);
		racine.addRow(2, lblPoste, txtPoste);
		racine.addRow(3, lblDepartement, txtDepartement);
		zoneBoutons.getChildren().addAll(bnChangerNom, bnChangerPoste);
		racine.add(zoneBoutons, 1, 4);
		racine.setHgap(10);
		racine.setVgap(10);
		racine.setPadding(new Insets(10));
		return racine;
	}
	
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}
