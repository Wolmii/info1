package tp2_plus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controleur {
	@FXML
    private HBox annonce2;

    @FXML
    private ComboBox<String> cbType;

    @FXML
    private HBox annonce3;

    @FXML
    private ComboBox<String> cbMarque;

    @FXML
    private Button bnChercher;

    @FXML
    private HBox annonce1;

    @FXML
    private VBox zone3;

    @FXML
    private VBox zone2;

    @FXML
    private VBox zone1;

    @FXML
    void clicChercher(ActionEvent event) {
    	annonce1.setVisible(true);
		annonce2.setVisible(true);
		annonce3.setVisible(true);
    }
    
	public void initialize() {
		annonce1.setVisible(false);
		annonce2.setVisible(false);
		annonce3.setVisible(false);
		cbType.getItems().addAll("Citadine", "SUV", "Berline", "Autre");
		cbMarque.getItems().addAll("Citroën", "Peugeot", "Renault", "Volkswagen", "Toyota");
    }
	
}
