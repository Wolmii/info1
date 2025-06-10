/**
 * 
 */
/**
 * 
 */
module PremierProjet {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	opens ex1 to javafx.base, javafx.controls, javafx.graphics;
	opens ex2 to javafx.base, javafx.controls, javafx.graphics;
	opens td2_1 to javafx.base, javafx.controls, javafx.graphics;
	opens td3_1 to javafx.base, javafx.controls, javafx.graphics;
	opens td3_2 to javafx.base, javafx.controls, javafx.graphics;
	opens td3_e1 to javafx.base, javafx.controls, javafx.graphics;
	opens tp2 to javafx.base, javafx.controls, javafx.graphics;
	opens tp2_2 to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens tp2_plus to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens tp3 to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens tp4 to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens vue to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens modele to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
	opens controler to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
}