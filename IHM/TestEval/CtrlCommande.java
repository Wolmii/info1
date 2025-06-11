package src;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleFloatProperty;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CtrlCommande {
	private final float PRIX_FRAISES = 11.98f;
	private final float PRIX_FRAMBOISES = 22.40f;
	private final float PRIX_GROSEILLES = 32.40f;
	
	@FXML private Button bnAbandonner;
    @FXML private Button bnPrecedent;
    @FXML private CheckBox cbFraises;
    @FXML private CheckBox cbFramboises;
    @FXML private CheckBox cbGroseilles;
    @FXML private TextField montantFraises;
    @FXML private TextField montantFramboises;
    @FXML private TextField montantGroseilles;
    @FXML private TextField montantTotal;
    @FXML private TextField txtDate;
    @FXML private TextField txtIdentite;
    @FXML private TextField txtPoidsFraises;
    @FXML private TextField txtPoidsFramboises;
    @FXML private TextField txtPoidsGroseilles;
    
    @FXML public void clicPrecedent() {
 
    }
    
    @FXML public void clicAbandonner() {
    	Main.fermerLivr();
    }
    
    on action {
    	if(cbFraises.getSelected()==true)
    	txtPoidsFraises.setDisable(false);
    	else {
    		txtPoidsFraises.setText("0");
        	montantFraises.clear();
        	txtPoidsFraises.setDisable(true);
    	}
    }

    public void initialize() {
    	// initialement les cases sont toutes d�coch�es
    	cbFraises.setSelected(false);
    	txtPoidsFraises.setText("0");
    	montantFraises.clear();
    	txtPoidsFraises.setDisable(true);
    	montantFraises.setDisable(true);
    	montantFraises.setEditable(false);
    	
    	cbFramboises.setSelected(false);
    	txtPoidsFramboises.setText("0");
    	montantFramboises.clear();
    	txtPoidsFramboises.setDisable(true);
    	montantFramboises.setDisable(true);
    	montantFramboises.setEditable(false);
    	
    	cbGroseilles.setSelected(false);
    	txtPoidsGroseilles.setText("0");
    	montantGroseilles.clear();
    	txtPoidsGroseilles.setDisable(true);
    	montantGroseilles.setDisable(true);
    	montantGroseilles.setEditable(false);
    	
    	
    	   	
    	// liaison entre le poids et le montant des fraises (A FAIRE)
    	SimpleFloatProperty poidsFraises = new SimpleFloatProperty();
    	SimpleFloatProperty mttFraises = new SimpleFloatProperty(); 	
    	
    	mttFraises.bind(poidsFraises.multiply(PRIX_FRAISE));
        
    	poidsFraises.bind(Bindings.createDoubleBinding( ()->
    	Double.parseDouble(txtPoidsFraises.getText()),txtPoidsFraises.textProperty())
    	);
    	
    	montantFraises.textProperty().bind(Bindings.createStringBinding( () ->
    	String.valueOf(mttFraises.get()), mttFraises));
    	
       	// liaison entre le poids et le montant des framboises (A FAIRE)
       	
       	
    	
    	
       	// liaison entre le poids et le montant des groseilles (A FAIRE)
       	
    	
    	
       	
       	// liaison entre le montant total de la commande et les montants partiels (A FAIRE)
    	montantTotal=add(prixF,prixFr,prixG);

    	
    	
    	while(total.getText=="0") {
    		bnPrecedent.setDisable(true);
    	}
       	
    }

}
