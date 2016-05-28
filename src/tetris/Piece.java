package tetris;

import java.awt.Color;

public abstract class Piece {
	protected Color color;
	protected int nbRow;
	protected int nbCol;
	protected int rotation;
	protected Case [][] piecesCases;
	protected Couple coord;
	
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
