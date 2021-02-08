package gui;

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
			image = super.createImage(pieceColor, true);
			pieceGui = new ImageView();
			pieceGui.setImage(image);
		}

		return pieceGui;
	}
	
	@Override
	public void promote(Image image) {
		
		//todo
		
	}

	@Override
	public boolean hasSameColorAsGamer(PieceSquareColor gamerColor) {
		
		//todo
	}
	
}