package tetris;

import java.awt.Color;
import java.util.Random;

import tetris.pieces.*;
import utilities.Couple;

public class Game {
	private Piece pieceSuivante;
	//private int level; a utiliser pour accelerer la vitesse de jeu
	private Tetris tetris;
	
	
	public Game(int nbRow, int nbCol){
		this.tetris = new Tetris(new Grid(nbRow, nbCol));
		tetris.addPiece(tiragePiece());
		pieceSuivante = tiragePiece();
	}
	
	public boolean supprTetris(int numRow){
		Grid grid = this.tetris.getGrid();
		int nbCol = this.tetris.getGrid().getNbCol();
		int nbRow = this.tetris.getGrid().getNbRow();
		//verifie si la ligne numRow n'a que des cases remplies
		boolean tetris= grid.getCase(numRow, 0).getState()==CaseState.FULL;	
		for(int j=1; j<nbCol; j++){
			tetris = tetris && grid.getCase(numRow, j).getState()==CaseState.FULL;
		}
	
		if(tetris){
			//décalage des lignes au dessus
			for(int i=numRow;i<nbRow-1;i++){
				for(int j=0;j<nbCol;j++){
					grid.setCase(i, j, grid.getCase(i+1, j));
				}
			}
			//met la ligne du haut a vide
			for(int j=0;j<nbCol;j++){
				grid.getCase(nbRow-1, j).setState(CaseState.EMPTY);
			}
		}
		return tetris;
	}
	
	private Piece tiragePiece(){
		
		Random rand = new Random();
		int nbAlea = rand.nextInt(100);
		int numColoration = nbAlea%6;
		int numRot;
		int nbRow = this.tetris.getGrid().getNbRow();
		int nbCol = this.tetris.getGrid().getNbCol();
		Color color;
		Piece p;
		switch (numColoration) {
		case 0:
			color = Color.blue;
			break;
		case 1:
			color = Color.red;
			break;
		case 2:
			color = Color.green;
			break;
		case 3:
			color = Color.cyan;
			break;
		case 4:
			color = Color.yellow;
			break;
		default:
			color = Color.pink;
			break;
		}
		switch (nbAlea%7) {
		case 0:
			numRot = nbAlea%2;
			if(numRot==0){
				p = new I(numRot,color,new Couple(nbRow-4, nbCol/2));
			}else{
				p = new I(numRot, color, new Couple(nbRow-1, (nbCol/2)-2));
			}
			break;
		case 1:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new J(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			case 1:
				p = new J(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			case 2:
				p = new J(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			default:
				p = new J(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			}
			break;
		case 2:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new L(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			case 1:
				p = new L(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			case 2:
				p = new L(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			default:
				p = new L(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			}
			break;
		case 3:
			p = new O(0, color, new Couple(nbRow-2, (nbCol/2)-1));
			break;
		case 4:
			numRot = nbAlea%2;
			if(numRot==0){
				p = new S(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
			}else{
				p = new S(numRot, color, new Couple(nbRow-3, (nbCol/2)-1));
			}
			break;
		case 5:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new T(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			case 1:
				p = new T(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			case 2:
				p = new T(numRot,color,new Couple(nbRow-2, (nbCol/2)-1));
				break;
			default:
				p = new T(numRot,color,new Couple(nbRow-3, (nbCol/2)-1));
				break;
			}
			break;	
		default:
			//TODO Faire les modifs pour la piece Z
			p = new Z();
			break;
		}
		return p;
	}
	
	/*public boolean isGameOver(){
		//ajout d'une ligne en haut de la grille ?
	}*/
}
