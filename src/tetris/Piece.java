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
		//TODO remplir
	}
	
	public void moveL(Grid grid){
		//TODO remplir
	}
	
	/**
	 * 
	 * @param grid grille
	 * @return boolean true si la pièce est descendue et false sinon : alors elle a été posée.
	 * 
	 */
	//vérif que la grille est vide en dessous du masque à chaque endroits où il y a une case pleine.
	//si ok, parcours des lignes puis des colonnes pour déplacer l'état de la case au dessus,
	//uniquement si elle est USED.!! Modif de la couleur de la case.
	//Sinon, Poser la piece et la fixer sur la grille.
	public boolean down(Grid grid){
		boolean isDown = true;
		//On vérifie si la piece n'est pas en bas de la grille.
		if(coord.first()>0){
			//On vérifie s'il n'y a pas de cases FULL sous chaque case USED de la piece.
			for(int r=0 ; r<nbRow ; r++){
				for(int c=0 ; c<nbCol ; c++){
					if(grid.getCaseState(coord.first()+r-1,coord.second()+c) == CaseState.FULL) isDown = false;
				}
			}
		}
		else isDown = false;
		//S'il y a de la place sous la piece, on la déplace
		if(isDown){
				for(int r=0 ; r<nbRow ; r++){
					for(int c=0 ; c<nbCol ; c++){
						if(grid.getCaseState(coord.first()+r, coord.second()+c)==CaseState.USED){
							//TODO tout changer
							//grid.getCaseState(
							//Besoin de changer Grid pour pouvoir modifier (et accéder) les Cases 
							//(changer couleur et état)
						}
					}
				}
				coord.setFirst(coord.first()-1);
			}
		//Sinon, on la fixe à la grille.
		else{
			//TODO remplir
		}
		return isDown;
	}
	
	
	//R = Right = rotation horaire
	public abstract void rotationR(Grid grid);
	
	//L = Left = rotation anti-horaire
	public abstract void rotationL(Grid grid);
	
}
