package atelier2.model;


import atelier2.nutsAndBolts.PieceSquareColor;

public class PawnModel extends AbstractPieceModel implements Promotable{

	private int direction;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
	}

	
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		
		// Cas d'un d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			
			// sans prise
			if (!isPieceToCapture) {
				if (deltaLig == this.direction && Math.abs(colDistance) == 1) {
					ret = true;
				}
			}
			// avec prise
			else {
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
		return ret;
	}
	
	public boolean isPromotable(){
		boolean promotable = false;
		if ((this.getPieceColor() == PieceSquareColor.WHITE && this.getLigne()==10) || (this.getPieceColor() == PieceSquareColor.BLACK && this.getLigne()==1))
			promotable=true;
		return promotable;
	}
	
	public void promote() {
		throw new UnsupportedOperationException();
	}


}

