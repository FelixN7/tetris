package tetris;

import java.awt.Color;

public abstract class Piece {
	private Color color;
	private int nbRow;
	private int nbCol;
	private int rotation;
	private CaseState [][] piecesCases;
	private Couple coord;
	
	public void moveR(Grid grid){
		
	}
	
	public void moveL(Grid grid){
		
	}
	
	/**
	 * 
	 * @param grid grille
	 * @return boolean true si la pièce est descendue et false sinon : alors elle a été posée.
	 * 
	 */
	public boolean down(Grid grid){
		return true;
	}
	
	//R = Right = rotation horaire
	public abstract void rotationR(Grid grid);
	
	//L = Left = rotation anti-horaire
	public abstract void rotationL(Grid grid);
	
}
