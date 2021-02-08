package model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;

	}

	@Override
	public char getColonne() {
		char colonne = ' ';
		colonne = this.coord.getColonne();
		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = -1;
		ligne = this.coord.getLigne();
		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;
		hasThisCoord = this.coord.equals(coord);
		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = null;
		color = this.pieceColor;
		return color;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = null;
		st = "["+this.pieceColor.toString().substring(0,1)+"["+this.getLigne()+ "," + this.getColonne() + "]]";
		return st;
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		if(isPieceToCapture){
			return Math.abs(targetCoord.getLigne() - this.getLigne()) == 2 && Math.abs(targetCoord.getColonne() - this.getColonne()) == 2;
		}
		else {
			return Math.abs(targetCoord.getLigne() - this.getLigne()) == 1 && Math.abs(targetCoord.getColonne() - this.getColonne()) == 1;
		}
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 

		// TODO Atelier 2

		return coordsOnItinery;
	}

	
}

