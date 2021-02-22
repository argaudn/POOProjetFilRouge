package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nutsAndBolts.PieceSquareColor;


/**
 * @author francoise.perrin
 * 
 * Cette classe permet de donner une image aux pi�ces
 *
 */

public class PieceGui extends ImageView implements CheckersPieceGui {
	private int col;
	private int ligne;
	
	public PieceGui(Integer col, Integer ligne) {
		this.col = col;
		this.ligne=ligne;
	}
	
	public ImageView createPiece() {

		ImageView pieceGui = null;
		Image image = null;
		PieceSquareColor pieceColor = null;

		if  ( !((this.col % 2 == 0 && this.ligne % 2 == 0) || (this.col % 2 != 0 && this.ligne % 2 != 0)) ) {
			if (ligne < 4)
				pieceColor = PieceSquareColor.BLACK;
			if (ligne > 5)
				pieceColor = PieceSquareColor.WHITE;
		}
		if (pieceColor != null) {
			image = PieceGui.createImage(pieceColor, true);
			pieceGui = new ImageView();
			pieceGui.setImage(image);
		}

		return pieceGui;
	}
	
	/**
	 * @param pieceColor
	 * @param ispawn
	 * @return une image cr��e � partir d'un fichier png
	 */
	private static Image createImage(PieceSquareColor pieceColor, boolean ispawn) {

		Image image = null;
		String pieceImageFile = null, nomImageFile = null;
		File g = new File("");

		if (ispawn) {
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "PionNoir.png" : "PionBlanc.png";
		}
		else {	
			nomImageFile = pieceColor == PieceSquareColor.BLACK ? "DameNoire.png" : "DameBlanche.png";
		}

		pieceImageFile = g.getAbsolutePath()+"/images/" + nomImageFile;	// TODO - attention au chemin
		try {
			image = new Image(new FileInputStream(pieceImageFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	@Override
	public void promote(Image image) {
		
		//todo
		
	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {
		boolean retour = false;
		//todo
		return retour;
	}
	
}