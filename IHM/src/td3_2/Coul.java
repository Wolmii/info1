package td3_2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Coul extends Stage{
	
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
	
	
	public Coul() {
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
		
		return racine;
	}
	
	private void changerCoul(ActionEvent e) {
		if (e.getSource()==rbVert) {
			carre.setFill(Color.GREEN);
			c="Vert";
		}
		else if (e.getSource()==rbJaune) {
			carre.setFill(Color.YELLOW);
			c="Jaune";
		}
		else if (e.getSource()==rbOrange) {
			carre.setFill(Color.ORANGE);
			c="Orange";
		}
		else if (e.getSource()==rbBleu) {
			carre.setFill(Color.BLUE);
			c="Bleu";
		}
	}

}

