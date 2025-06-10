package vue;

import java.util.Optional;

import controler.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import modele.Employe;


public class CtrlListeEmployes {

    @FXML private Button bnAjouter;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Employe> tvListeEmployes;
    private MenuItem optionAjouter = new MenuItem("Ajouter...");
    private MenuItem optionModifier = new MenuItem("Modifier...");
    private MenuItem optionSupprimer = new MenuItem("Supprimer");
    private ContextMenu menu = new ContextMenu( optionAjouter,
    		new SeparatorMenuItem(),
    		optionModifier,
    		new SeparatorMenuItem(),
    		optionSupprimer
    		);
    
    // clic sur bouton Ajouter
    @FXML void clicAjouter(ActionEvent event) {
    	Main.ouvrirNouvelEmploye();
    }
    
    // clic sur bouton Modifier
    @FXML void clicModifier(ActionEvent event) {
    	Main.ouvrirModifierEmploye(tvListeEmployes.getSelectionModel().getSelectedItem());
    }
    
    // clic sur bouton Supprimer
    @FXML void clicSupprimer(ActionEvent event) {
    	Alert alert = new Alert(
    			AlertType.CONFIRMATION,
    			"Voulez-vous vraiment supprimer cet employé ?",
    			ButtonType.YES,
    			ButtonType.NO
    	);
    	alert.setTitle("Confirmation de suppression");
    	alert.showAndWait();
    	if(alert.getResult()==ButtonType.YES) {
    		Main.supprimerEmploye(tvListeEmployes.getSelectionModel().getSelectedItem());
    		System.out.println("employé supprimé !!");
    	}
    }
     
    // clic sur bouton Fermer
    @FXML void clicFermer(ActionEvent event) {
    	Main.fermerAppli();
    }
    
    @FXML void doubleClic(MouseEvent e) {
    	
    }
    
    @FXML void initialize() {
    	TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));	
		tvListeEmployes.getColumns().set(0, colonne1);
		TableColumn<Employe, String> colonne2 = new TableColumn<Employe,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
		tvListeEmployes.getColumns().set(1, colonne2);
		TableColumn<Employe, String> colonne3 = new TableColumn<Employe,String>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
		tvListeEmployes.getColumns().set(2, colonne3);
		TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("Département");
		colonne4.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("dept"));
		tvListeEmployes.getColumns().set(3, colonne4);
		tvListeEmployes.setItems(Main.getLesEmployes());
		tvListeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		BooleanBinding rien = Bindings.equal(tvListeEmployes.getSelectionModel().selectedIndexProperty(), -1);
		bnSupprimer.disableProperty().bind(rien);
		bnModifier.disableProperty().bind(rien);
		
		//A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection


    }
    
}
