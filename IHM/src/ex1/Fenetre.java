package ex1;

import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;

public class Fenetre extends Stage{
	private Circle rond = new Circle(150,60,40); 
	private Rectangle carre = new Rectangle (0, 0, 1000, 300);
	private Group horizon = new Group();
	private Rectangle mer = new Rectangle (0, 300, 1000, 150);
	private Rectangle sable = new Rectangle (0, 450, 1000, 450);
	private Rectangle serviette = new Rectangle (650, 650, 100, 200);
	private Group plage = new Group();
	private Group racine= new Group();
	
	public Fenetre() {
		Scene laScene = new Scene(creerScene());
		this.setTitle("Miaou Miaou :)");
		this.setX(10);
		this.setY(1500);
		this.setWidth(900);
		this.setHeight(900);
		this.setMinWidth(300);
		this.setMinHeight(100);
		this.setScene(laScene);
	}
	
	private Parent creerScene() {
		this.rond.setFill(Color.ORANGE);
		this.carre.setFill(Color.LIGHTBLUE);
		this.horizon.getChildren().add(carre);
		this.horizon.getChildren().add(rond);
		this.mer.setFill(Color.BLUE);
		this.sable.setFill(Color.YELLOW);
		this.serviette.setFill(Color.PINK);
		this.plage.getChildren().add(sable);
		this.plage.getChildren().add(serviette);
		this.racine.getChildren().add(plage);
		this.racine.getChildren().add(mer);
		this.racine.getChildren().add(horizon);
		return racine;
	}
}
