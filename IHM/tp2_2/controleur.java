package tp2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class controleur {
	private String c="Bleu";
	private Color c2=Color.BLUE;
	
    @FXML
    private Button btOk;

    @FXML
    private RadioButton btBleu;

    @FXML
    private Button btAnn;

    @FXML
    private RadioButton btVert;

    @FXML
    private RadioButton btJaune;

    @FXML
    private Rectangle carre;

    @FXML
    private RadioButton btOrange;

    @FXML
    void fermer(ActionEvent event) {
    	//((Stage)btAnn.getScene().getWindow()).close();
    	System.exit(0);
    }

    @FXML
    void dacc(ActionEvent event) {
    	System.out.println("Couleur choisie : "+c);
    }

    @FXML
    void mettrebl(ActionEvent event) {
    	if (event.getSource()==btVert) {
			carre.setFill(Color.GREEN);
			c="Vert";
			c2=Color.GREEN;
		}
		else if (event.getSource()==btJaune) {
			carre.setFill(Color.YELLOW);
			c="Jaune";
			c2=Color.YELLOW;
		}
		else if (event.getSource()==btOrange) {
			carre.setFill(Color.ORANGE);
			c="Orange";
			c2=Color.ORANGE;
		}
		else if (event.getSource()==btBleu) {
			carre.setFill(Color.BLUE);
			c="Bleu";
			c2=Color.BLUE;
		}
    }

    @FXML
    void apercu(MouseEvent event) {
    	if (event.getSource()==btVert) {
			carre.setFill(Color.GREEN);
		}
		else if (event.getSource()==btJaune) {
			carre.setFill(Color.YELLOW);
		}
		else if (event.getSource()==btOrange) {
			carre.setFill(Color.ORANGE);
		}
		else if (event.getSource()==btBleu) {
			carre.setFill(Color.BLUE);
		}
    }

    @FXML
    void finapercu(MouseEvent event) {
    	carre.setFill(c2);
    }
    
    public void initialize() {
    	btBleu.setSelected(true);
    }

}
