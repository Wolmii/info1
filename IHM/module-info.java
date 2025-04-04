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
	
	opens ex1 to javafx.base, javafx.controls, javafx.graphics;
	opens ex2 to javafx.base, javafx.controls, javafx.graphics;
	opens td2_1 to javafx.base, javafx.controls, javafx.graphics;
}
