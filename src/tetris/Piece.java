package tetris;

import java.awt.Color;

public abstract class Piece {
	protected Color color;
	protected int nbRow;
	protected int nbCol;
	protected int rotation;
	protected Case [][] piecesCases;
	protected Couple coord;
	
	
	public int getNbRow() {
		return nbRow;
	}

	public int getNbCol() {
		return nbCol;
	}

	public Case[][] getPiecesCases() {
		return piecesCases;
	}

	public Couple getCoord() {
		return coord;
	}
	
	//TODO Vérifier si "Case [][] piecesCases" peut servir (ou si ça DOIT servir)
	public void moveR(Grid grid){
		//Vérification si la piece n'est pas sur le bord droit
		if((coord.second()+nbCol)< grid.getNbCol()){
			//Vérification si des cases sont FULL à droite de USED
			boolean allowed = nbRow>0 && nbCol>0;
			for(int r=0 ; r<nbRow ; r++){
				for(int c=0 ; c<nbCol ; c++){
					Case actual = grid.getCase(coord.first()+r, coord.second()+c);
					Case right = grid.getCase(coord.first()+r, coord.second()+c+1);
					if((actual.getState()==CaseState.USED) && (right.getState()==CaseState.FULL)) {
						allowed = false;
					}
				}
			}
			System.out.println(allowed);
			if(allowed){
				for(int r=0 ; r<nbRow ; r++){
					for(int c=nbCol-1 ; c>=0 ; c--){
						Case actual = grid.getCase(coord.first()+r, coord.second()+c);
						if(actual.getState()==CaseState.USED){
							grid.setCase(coord.first()+r, coord.second()+c+1, actual);
							actual.setState(CaseState.EMPTY);
						}
					}
				}
				coord.setSecond(coord.second()+1);
			}
		}
	}

	public void moveL(Grid grid){
		//Vérification si la piece n'est pas sur le bord gauche
		if(coord.second() > 0){
			//Vérification si des cases sont FULL à gauche de USED
			boolean allowed = nbRow>0 && nbCol>0;
			for(int r=0 ; r<nbRow ; r++){
				for(int c=0 ; c<nbCol ; c++){
					Case actual = grid.getCase(coord.first()+r, coord.second()+c);
					Case left = grid.getCase(coord.first()+r, coord.second()+c-1);
					if((actual.getState()==CaseState.USED) && (left.getState()==CaseState.FULL)) {
						allowed = false;
					}
				}
			}
			System.out.println(allowed);
			if(allowed){
				for(int r=0 ; r<nbRow ; r++){
					for(int c=0 ; c<nbCol ; c++){
						Case actual = grid.getCase(coord.first()+r, coord.second()+c);
						if(actual.getState()==CaseState.USED){
							grid.setCase(coord.first()+r, coord.second()+c-1, actual);
							actual.setState(CaseState.EMPTY);
						}
					}
				}
				coord.setSecond(coord.second()-1);
			}
		}
	}
	
	/**
	 * 
	 * @param grid grille
	 * @return boolean true si la pièce est descendue et false sinon : alors elle a été posée.
	 * 
	 */
	//vérif que la grille est vide en dessous du masque à chaque endroits où il y a une case pleine.
	//si ok, parcours des lignes puis des colonnes pour déplacer l'état de la case au dessus,
	//uniquement si elle est USED.
	//Sinon, Poser la piece et la fixer sur la grille.
	public boolean down(Grid grid){
		boolean isDown = true;
		//On vérifie si la piece n'est pas en bas de la grille.
		if(coord.first()>0){
			//On vérifie s'il n'y a pas de cases FULL sous chaque case USED de la piece.
			for(int r=0 ; r<nbRow ; r++){
				for(int c=0 ; c<nbCol ; c++){
					Case actual = grid.getCase(coord.first()+r, coord.second()+c);
					Case under = grid.getCase(coord.first()+r-1, coord.second()+c);
					if((actual.getState()==CaseState.USED) && (under.getState()==CaseState.FULL)) isDown = false;
				}
			}
		}
		else isDown = false;
		//S'il y a de la place sous la piece, on la déplace
		if(isDown){
				for(int r=0 ; r<nbRow ; r++){
					for(int c=0 ; c<nbCol ; c++){
						Case actual = grid.getCase(coord.first()+r, coord.second()+c);
						if(actual.getState()==CaseState.USED){
							grid.setCase(coord.first()+r-1, coord.second()+c, actual);
							actual.setState(CaseState.EMPTY);
						}
					}
				}
				coord.setFirst(coord.first()-1);
			}
		//Sinon, on la fixe à la grille.
		else{
			for(int r=0 ; r<nbRow ; r++){
				for(int c=0 ; c<nbCol ; c++){
					Case actual = grid.getCase(coord.first()+r, coord.second()+c);
					if(actual.getState()==CaseState.USED){
						actual.setState(CaseState.FULL);
					}
				}
			}
		}
		return isDown;
	}
	
	
	//R = Right = rotation horaire
	public abstract void rotationR(Grid grid);
	
	//L = Left = rotation anti-horaire
	public abstract void rotationL(Grid grid);
	
}
