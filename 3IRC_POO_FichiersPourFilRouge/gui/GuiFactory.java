package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import nutsAndBolts.PieceSquareColor;


/**
 * @author francoise.perrin
 * 
 * Cette classe est responsable de :
 * 		cr�er les cases noires et blanches et les positionner au bon endroit sur le damier
 * 		cr�er les pions noirs et blancs en leur affectant une image et les positionner sur leur case initiale
 *		promouvoir les pions en dame en changeant leur image
 */
public class GuiFactory {

	
	/**
	 * @param col
	 * @param ligne
	 * @return Une case noire ou blanche en alternance
	 * la case en bas � gauche est noire
	 */
	public static BorderPane createSquare(int col, int ligne) {

		return new SquareGui(col,ligne).createSquare();
		
	}

	/**
	 * @param col
	 * @param ligne
	 * @return une PieceGui si col/ligne correspond � cases noires
	 * des 4 lignes du haut (piece noire) et du bas du damier (piece blanche)
	 */
	public static ImageView createPiece(int col, int ligne) {

		return new PieceGui(col,ligne).createPiece();
	}

	/**
	 * @param piece
	 * @param promotedPieceColor
	 * la promotion consiste � changer l'image de la PieceGui
	 */
	public static void PromotePiece(ImageView piece, PieceSquareColor promotedPieceColor) {

		// ToDo Atelier 3
		
	}
	
	


}


