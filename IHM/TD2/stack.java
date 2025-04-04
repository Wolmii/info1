package td2_1;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*setAlignment(Node child, Pos value) permet d'aligner le
composant child dans le panneau.
- La méthode de classe setMargin(Node child, Insets value) permet de
créer un espace autour du composant child.*/

public class stack extends Stage {
	StackPane stack = new StackPane();
	
	public stack() {
		Scene laScene = new Scene(creerScene());
		this.setTitle("boutons");
		this.setScene(laScene);
		this.setResizable(true);
	}
	
	private Parent creerScene() {
		stack.getChildren().addAll(new Rectangle(100,100,Color.BLUE), new Rectangle(80,80,Color.RED), new Label("Légende"));
		return stack;
	}
}
