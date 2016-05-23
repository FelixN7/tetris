package tetris;

import java.awt.Color;

public abstract class Piece {
	private Color color;
	private int nbRow;
	private int nbCol;
	private int rotation;
	private CaseState [][] piecesCases;
	private Couple coord;
	
}
