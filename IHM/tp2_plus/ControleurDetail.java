package tp2_plus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControleurDetail {
    @FXML
    private TextArea infoEquipements;

    @FXML
    private Button bnImprimer;

    @FXML
    private Button bnFermer;

    @FXML
    private TextArea infoTechniques;

    @FXML
    private TextArea infoCommentaires;

    @FXML
    void imprimer(ActionEvent event) {
    	System.out.println("Impression en cour");
    }

    @FXML
    void fermer(ActionEvent event) {

    }
    
    public void initialize() {
    	infoTechniques.setText("essence 1.5 litres" +"\n" +"boite de vitesse manuelle");
    	infoEquipements.setText("ABS"+"\n" + "régulateur de vitesse"+"\n" + "climatisation"+"\n" + "volant en option");
    }
}
