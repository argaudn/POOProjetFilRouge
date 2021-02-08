package model;

import java.util.HashMap;

/**
 * @author francoiseperrin
 *
 * Coordonn�es des PieceModel
 */
public class Coord implements Comparable<Coord>{
	
	private char colonne; 	// ['a'..'j']
	private int ligne;		// [10..1]
	static final int MAX = ModelConfig.LENGTH;	// 10

	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public char getColonne() {
		return colonne;
	}


	public int getLigne() {
		return ligne;
	}


	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}
	
	public boolean equals(Coord coord){
		return this.colonne == coord.colonne && this.ligne == coord.ligne;
	}


	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		boolean ret = false;
		if (('a'<= coord.getColonne() && coord.getColonne()<'a'+MAX)&&(1 < coord.getLigne() && coord.getLigne() <= MAX)){
			ret = true;
		}
		return ret;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * La m�thode compareTo() indique comment comparer un objet � l'objet courant
	 * selon l'ordre dit naturel
	 * Dans cet application, nous d�cidons que l'ordre naturel est celui 
	 * correspondant au N� de la case d'un tableau 2D repr�sent� par la Coord
	 * ainsi le N� 1 correspond � la Coord ['a', 10], le N� 100 correspond � la Coord ['j', 1]  
	 */
	@Override
	public int compareTo(Coord o) {
		HashMap<String,Integer> colonnes = new HashMap<String,Integer>();
		colonnes.put("a", 1);
		colonnes.put("b", 2);
		colonnes.put("c", 3);
		colonnes.put("d", 4);
		colonnes.put("e", 5);
		colonnes.put("f", 6);
		colonnes.put("g", 7);
		colonnes.put("h", 8);
		colonnes.put("i", 9);
		colonnes.put("j", 10);
		HashMap<Integer,Integer> lignes = new HashMap<Integer,Integer>();
		lignes.put(1, 9);
		lignes.put(2, 8);
		lignes.put(3, 7);
		lignes.put(4, 6);
		lignes.put(5, 5);
		lignes.put(6, 4);
		lignes.put(7, 3);
		lignes.put(8, 2);
		lignes.put(9, 1);
		lignes.put(10, 0);
		int ordreA = lignes.get(this.ligne) *10 + (colonnes.get(""+this.colonne));
		int ordreB =lignes.get(o.getLigne()) *10 + (colonnes.get(""+o.getColonne()));
		return ordreA-ordreB;
	}
	

}
