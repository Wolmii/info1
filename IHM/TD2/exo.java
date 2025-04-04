package td2_1;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class exo extends Stage{
	private Button num1 = new Button ("Bouton 1");
	private Button num2 = new Button ("Bn 2");
	private Button num3 = new Button ("Je suis le bouton 3");
	private Button num4 = new Button ("Bouton 4");
	private Button num5 = new Button ("Moi c'est le bouton numero 5");
	//private TilePane racine =new TilePane(); pour taille du plus grand a la suite
	//private Flowpane racine =new FlowPane(); pour a la suite, taille de chacun
	//private HBox racine =new HBox(); //pour reste sur la ligne et ... si trop grand
	//private VBox racine =new VBox(); //pour reste sur la ligne et ... si trop grand vertical
	//private BorderPane racine =new BorderPane(); met dans zone attribué
	private GridPane racine= new GridPane(); //met dans zone qudrillage x et z (0.0  1.0  2.0)
	
	//flow et tile
	//racine.setPadding(new Insets(10)); pour espace autour panneau
	//setAlignment(BOTTOM_RIGHT); pour aligner en haut, bas, droite...
	//racine.setHgap(double) setVgap(double) espace verti ou horizon entre boutons
	
	//HBox et VBox
	//setAlignement aussi, setSpacing comme setHgat
	//racine.setMargin(num4, new Insets (10)); pour mettre une marge a 1 boutton
	//num2.setMaxWidth(Double.MAX_VALUE); mettre taille max, et avec en bas :
	//racine.setHgrow(num2, Priority.ALWAYS); Pour adapter la taille du bouton 2 Pour HBox
	//racine.setVgrow(num2, Priority.ALWAYS); Pour adapter la taille du bouton 2 Pour VBox
	
	//GridPAne
	//racine.setGridLinesVisible(true) pour afficher la grille
	//setHgap(double value) et setVgap(double value) pour espacer ligne ou colonne
	//racine.setHalignment(num2, 10) pour alignement horozontal, et V pour vertical
	//setHalignment(Node child, HPos value) et setValignment(Node child, VPos value) 
	//permettent de gérer l'alignement horizontal et vertical d'un composant à l'intérieur de sa cellule.
	
	public exo() {
		Scene laScene = new Scene(creerScene());
		this.setTitle("boutons");
		this.setScene(laScene);
		this.setResizable(true);
	}
	
	private Parent creerScene() {
		//racine.getChildren().addAll(num1, num2, num3, num4, num5);
		//racine.setHgap(10); pour flow et tile
		//racine.setAlignment(Pos.BOTTOM_RIGHT);
		//racine.setMargin(num4, new Insets (10));
		//num2.setMaxWidth(Double.MAX_VALUE);
		//racine.setHgrow(num2, Priority.ALWAYS); pour HBox
		//racine.setVgrow(num2, Priority.ALWAYS);
		
		//Pour BorderPlane, ajouter les enfants comme ça :
		//racine.setTop(num1);num1.setMaxWidth(Double.MAX_VALUE); 
		//racine.setHgrow(num2, Priority.ALWAYS);
		//racine.setLeft(num2);
		//racine.setRight(num3);
		//racine.setCenter(num4);
		//racine.setBottom(num5);
		
		//Pour GridPane
		/*racine.add(num1, 0, 0);
		racine.add(num2, 1, 1);
		racine.add(num3, 2, 2);
		racine.add(num5, 1, 0, 3, 1);
		racine.add(num4, 3, 3);
		racine.setGridLinesVisible(true);
		num1.setMaxWidth(Double.MAX_VALUE); 
		racine.setVgrow(num1, Priority.ALWAYS);
		num1.setMaxHeight(Double.MAX_VALUE); 
		racine.setHgrow(num1, Priority.ALWAYS);
		racine.setHalignment(num2, HPos.CENTER);
		racine.setValignment(num2, VPos.CENTER);
		racine.setVgrow(num2, Priority.ALWAYS);
		racine.setHalignment(num3, HPos.CENTER);
		racine.setValignment(num3, VPos.CENTER);
		racine.setVgrow(num3, Priority.ALWAYS);
		racine.setHalignment(num4, HPos.CENTER);
		racine.setValignment(num4, VPos.CENTER);
		racine.setVgrow(num4, Priority.ALWAYS);
		racine.setHalignment(num5, HPos.CENTER);
		racine.setValignment(num5, VPos.CENTER);
		racine.setVgrow(num5, Priority.ALWAYS);
		*/
		
		return racine;
	}
}
