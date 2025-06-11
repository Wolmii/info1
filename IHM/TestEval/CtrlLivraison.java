import javafx.fxml.*;
import javafx.scene.control.*;

public class CtrlLivraison {
	@FXML private Button bnAbandonner;
    @FXML private Button bnSuivant;
    @FXML private DatePicker dpDateLivraison;
    @FXML private TextField txtAdresse1;
    @FXML private TextField txtAdresse2;
    @FXML private TextField txtCodePostal;
    @FXML private TextField txtCommune;
    @FXML private TextField txtIdentite;

    @FXML void clicAbandonner() {
    	Main.fermerLivr();
    }

    @FXML void clicSuivant() {
    	
    }
    
    public void initialize() {
    	dpDateLivraison.set(LocalDate.now());
    	bnSuivant.disableProperty().bind(
    				txtIdentite.textProperty().isEmpty();
    }

}
