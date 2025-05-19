package td3_2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Coul2 extends Stage{
	
	private	BorderPane 	racine 		= new BorderPane();
	private	VBox 		zoneGauche	= new VBox();
	private	HBox 		zoneBoutons = new HBox();
	private Label 		titre 		= new Label("Choisissez une couleur puis validez :");
	private RadioButton rbBleu 		= new RadioButton("Bleu");
	private RadioButton rbVert 		= new RadioButton("Vert");
	private RadioButton rbJaune 	= new RadioButton("Jaune");
	private RadioButton rbOrange 	= new RadioButton("Orange");
	private Rectangle 	carre		= new Rectangle();
	private Button 		bnAnnuler 	= new Button("Annuler");
	private Button 		bnOK 		= new Button("OK");
	private String c="Bleu";
	private Color c2=Color.BLUE;
	
	
	public Coul2() {
		this.setTitle("Couleur");
		this.setResizable(false);
		this.setWidth(250);
		this.setHeight(250);
		this.setScene(new Scene(creerSceneGraph() ) );
	}

	private Pane creerSceneGraph() {		
		racine.setPadding(new Insets(10));
		racine.setTop(titre);
		
		zoneGauche.setPadding(new Insets(10));
		zoneGauche.setSpacing(20);
		zoneGauche.getChildren().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		racine.setLeft(zoneGauche);
		
		ToggleGroup groupe = new ToggleGroup();
		groupe.getToggles().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		rbBleu.setSelected(true);
		
		carre.setWidth(120);
		carre.setHeight(120);
		carre.setFill(Color.BLUE);
		racine.setCenter(carre);
		
		zoneBoutons.setSpacing(10);
		zoneBoutons.setAlignment(Pos.CENTER_RIGHT);
		bnAnnuler.setPrefWidth(80);
		bnOK.setPrefWidth(80);
		zoneBoutons.getChildren().addAll(bnAnnuler, bnOK);
		
		racine.setBottom(zoneBoutons);
		
		// Partie à compléter : pose des écouteurs et programmation des événements
		
		rbBleu.setOnAction(e -> changerCoul(e));
		rbVert.setOnAction(e -> changerCoul(e));
		rbJaune.setOnAction(e -> changerCoul(e));
		rbOrange.setOnAction(e -> changerCoul(e));
		bnOK.setOnAction(g -> System.out.println("Couleur choisie : "+c));
		bnAnnuler.setOnAction(f -> close());
		
		rbVert.setOnMouseEntered(i -> survol(i));
		rbVert.setOnMouseExited(k -> enlever(k));
		rbJaune.setOnMouseEntered(i -> survol(i));
		rbJaune.setOnMouseExited(k -> enlever(k));
		rbOrange.setOnMouseEntered(i -> survol(i));
		rbOrange.setOnMouseExited(k -> enlever(k));
		rbBleu.setOnMouseEntered(i -> survol(i));
		rbBleu.setOnMouseExited(k -> enlever(k));
		
		
		return racine;
	}
	
	private void changerCoul(ActionEvent e) {
		if (e.getSource()==rbVert) {
			carre.setFill(Color.GREEN);
			c="Vert";
			c2=Color.GREEN;
		}
		else if (e.getSource()==rbJaune) {
			carre.setFill(Color.YELLOW);
			c="Jaune";
			c2=Color.YELLOW;
		}
		else if (e.getSource()==rbOrange) {
			carre.setFill(Color.ORANGE);
			c="Orange";
			c2=Color.ORANGE;
		}
		else if (e.getSource()==rbBleu) {
			carre.setFill(Color.BLUE);
			c="Bleu";
			c2=Color.BLUE;
		}
	}
	
	private void survol(MouseEvent i) {
		if (i.getSource()==rbVert) {
			carre.setFill(Color.GREEN);
		}
		else if (i.getSource()==rbJaune) {
			carre.setFill(Color.YELLOW);
		}
		else if (i.getSource()==rbOrange) {
			carre.setFill(Color.ORANGE);
		}
		else if (i.getSource()==rbBleu) {
			carre.setFill(Color.BLUE);
		}
	}
	
	private void enlever(MouseEvent k) {
		carre.setFill(c2);
	}

}

