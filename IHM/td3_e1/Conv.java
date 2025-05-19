package td3_e1;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Conv extends Stage {
	
	private final float 		TAUX_DE_CHANGE	= 1.13f;
	private ArrayList<KeyCode> 	carAutorises 	= new ArrayList<KeyCode>();
	
	private VBox 		racine 		= new VBox();
	private HBox 		haut 		= new HBox();
	private TextField 	txtEuros 	= new TextField();
	private TextField 	txtDollar	= new TextField();
	private Label 		lblEuro 	= new Label("euros");
	private Label 		lblDollar	= new Label("dollars");
	private Label 		message		= new Label();
	private Button 		bnConvertir = new Button("Convertir >");
	private float calc=0;
	
	public Conv(){ 
		// liste des caractères autorisés
		carAutorises.add(KeyCode.DIGIT0);
		carAutorises.add(KeyCode.DIGIT1);
		carAutorises.add(KeyCode.DIGIT2);
		carAutorises.add(KeyCode.DIGIT3);
		carAutorises.add(KeyCode.DIGIT4);
		carAutorises.add(KeyCode.DIGIT5);
		carAutorises.add(KeyCode.DIGIT6);
		carAutorises.add(KeyCode.DIGIT7);
		carAutorises.add(KeyCode.DIGIT8);
		carAutorises.add(KeyCode.DIGIT9);
		carAutorises.add(KeyCode.NUMPAD0);
		carAutorises.add(KeyCode.NUMPAD1);
		carAutorises.add(KeyCode.NUMPAD2);
		carAutorises.add(KeyCode.NUMPAD3);
		carAutorises.add(KeyCode.NUMPAD4);
		carAutorises.add(KeyCode.NUMPAD5);
		carAutorises.add(KeyCode.NUMPAD6);
		carAutorises.add(KeyCode.NUMPAD7);
		carAutorises.add(KeyCode.NUMPAD8);
		carAutorises.add(KeyCode.NUMPAD9);
		carAutorises.add(KeyCode.PERIOD);
		carAutorises.add(KeyCode.BACK_SPACE);
		carAutorises.add(KeyCode.SHIFT);
		carAutorises.add(KeyCode.DELETE);
		
		this.setTitle("Convertisseur"); 
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private VBox creerSceneGraph(){
		txtDollar.setEditable(false);
		message.setTextFill(Color.RED);
			
		haut.setSpacing(10);
		haut.setPadding(new Insets(10));
		haut.setAlignment(Pos.CENTER);
		haut.getChildren().addAll(txtEuros, lblEuro, bnConvertir, txtDollar, lblDollar);
		
		racine.setPadding(new Insets(10));
		racine.getChildren().addAll(haut, message);
		racine.setAlignment(Pos.CENTER);
		
		txtEuros.setOnKeyReleased(f -> bon(f));
		
		bnConvertir.setOnAction(e ->  res(e));

		return racine;
	}
	
	private void res(ActionEvent e) {
		if(txtEuros.getText().isEmpty()) {
			message.setText("La zone Euros est vide");
		}
		else if (!this.isNumeric(txtEuros.getText())) {
			message.setText("Impossible de convertir");
		}
		else {
			calc=Float.parseFloat(txtEuros.getText())*1.14f;
			txtDollar.setText(calc+"");
		}
	}
	
	private void bon(KeyEvent f) {
		if (carAutorises.contains(f.getCode())) {
			message.setText("") ;
		}
		else {
			message.setText("non autorisé");
		}
	}
	
	private boolean isNumeric(String str) {
		// renvoie true si la chaine str correspond à un nombre, éventuellement à virgule

		return str.matches("\\d+(\\.\\d+)?");  //match a number with optional decimal.
	}
}

























