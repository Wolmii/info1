package tp3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;

public class CtrlFormulaire {
	@FXML
	private RadioButton aA;

	@FXML
	private RadioButton bB;
	
	@FXML
	private RadioButton bA;

	@FXML
	private ToggleGroup a;

	@FXML
	private RadioButton aB;

	@FXML
	private ToggleGroup b;
    
	@FXML
    private TextField z;

    @FXML
    private TextField y;

    @FXML
    private TextField c;

    @FXML
    private TextField d;

    @FXML
    private TextField e;

    @FXML
    private TextField f;

    @FXML
    private TextField g;

    @FXML
    private TextField h;
    
    @FXML
    private Button bnOk;
    
    @FXML
    private Button bnAnn;
    
    @FXML
    private Label telFaux;
    
    @FXML
    private CheckBox accept;
    
    private boolean estValide(String str) {
    	return str.matches("\\d*");
    }
    
    @FXML
    void tailleMax(KeyEvent event) {
    	if (y.getText().length() >= 16){
			y.deletePreviousChar();
		}
    	if (z.getText().length() >= 16){
			z.deletePreviousChar();
		}
    	if (f.getText().length()>= 32) {
        	event.consume();
        	Alert erreur = new Alert(AlertType.ERROR, "Ville de 32 caractères max.", ButtonType.OK);
        	erreur.setTitle("Code postal : format incorrect");
        	erreur.showAndWait();
        }
    	if (c.getText().length()>= 38) {
        	event.consume();
        	Alert erreur = new Alert(AlertType.ERROR, "Votre maison de 38 caractères max", ButtonType.OK);
        	erreur.setTitle("Code postal : format incorrect");
        	erreur.showAndWait();
        }
    	if (d.getText().length()>= 38) {
        	event.consume();
        	Alert erreur = new Alert(AlertType.ERROR, "Votre maison suite de 38 caractères max", ButtonType.OK);
        	erreur.setTitle("Code postal : format incorrect");
        	erreur.showAndWait();
        }
    	
    	if (estValide(g.getText()) ) {
    		telFaux.setVisible(false);
    	} else {
    		telFaux.setVisible(true);
    	}
    }
    
    @FXML
    void ferme(ActionEvent event) {
    	Main.fermer();
    	}
    
    @FXML
    void verif(ActionEvent event) {
    	if(h.getText().contains("@")) {
    		String aS, bS;
    		if (a.getSelectedToggle()==aA) {
    			aS=("Formule DUO (81.40 euros)");
    		}
    		else {
    			aS=("Formule NUMERIQUE (76.40 euros)");
    		}
    		if (b.getSelectedToggle()==bA) {
    			bS=("Prélèvement");
    		}
    		else {
    			bS=("Chèque");
    		}
    		boolean acc=false;
    		if (accept.isSelected()) {
    			acc=true;
    		}
    		Abonnement abo;
    		abo = new Abonnement(z.getText(), y.getText(), c.getText(), d.getText(), e.getText(), f.getText(), g.getText(), h.getText(), aS, bS, acc);
    		abo.afficher();
    		Main.fermer();
    	}
    	else {
    		event.consume();
        	Alert erreur = new Alert(AlertType.ERROR, "Pas une adresse mail :(", ButtonType.OK);
        	erreur.setTitle("E mail : format incorrect");
        	erreur.showAndWait();
    	}
    }
   
	public void initialize() {
		y.setTooltip(new Tooltip("Maximum 15 caractères"));
		z.setTooltip(new Tooltip("Maximum 15 caractères"));
		c.setTooltip(new Tooltip("Votre maison"));
		d.setTooltip(new Tooltip("suite maison"));
		e.setTooltip(new Tooltip("5 chiffres"));
		f.setTooltip(new Tooltip("32 max"));
		g.setTooltip(new Tooltip("votre 06 ;)"));
		h.setTooltip(new Tooltip("nom@blabla.hus"));
		telFaux.setVisible(false);
	}
	
}
