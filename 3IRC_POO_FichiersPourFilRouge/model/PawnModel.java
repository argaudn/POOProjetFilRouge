package model;


import java.util.ArrayList;
import java.util.Arrays;
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
		List<Character> tab = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j');
		char colonne = this.getColonne();
		int ligne = this.getLigne();
		Coord prochaineCase = this.coord;
		
		boolean destinationFinale = false;
		int index = 0;
		while (!destinationFinale && index < 5) {
			//ligne
			if (ligne < targetCoord.getLigne()) {
				ligne = ligne +1;
			}
			else {
				ligne = ligne -1; 
			}
			
			int indexColonne = tab.get(tab.indexOf(prochaineCase.getColonne()));
			
			if (indexColonne < tab.get(tab.indexOf(targetCoord.getColonne()) {
				colonne = tab.get(indexColonne + 1);
			}
			else {
				colonne = tab.get(indexColonne - 1);
			}
			prochaineCase = new Coord(colonne,ligne);
			coordsOnItinery.add(prochaineCase);
		
			if (targetCoord.compareTo(prochaineCase)==0){
				destinationFinale = true;
			}
			index +=1;
		}
		return coordsOnItinery;
	}

	
}

