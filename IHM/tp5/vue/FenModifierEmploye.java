package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Employe;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenModifierEmploye extends Stage {
	
	private CtrlModifierEmploye ctrl;
	
	public FenModifierEmploye() {
		this.setTitle("Détail d'un employé");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/modifierEmploye.fxml"));
        Pane root = new Pane();
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ctrl = loader.getController();
     	return root;
	}
	
	public void afficherEmploye(Employe e) {
		ctrl.afficherEmploye(e);
	}
	
	

}

