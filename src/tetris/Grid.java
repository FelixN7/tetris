package tetris;

import tetris.CaseState;

public class Grid {
	private CaseState [][] grid;
	private int nbRow;
	private int nbCol;

	public Grid(int nbRow, int nbCol) {
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.grid = new CaseState [nbRow] [nbCol];
		for(int i=0; i<nbRow;i++){
			for(int j=0; j<nbCol;j++){
				this.grid[i][j] = CaseState.EMPTY;
			}
		}
	}
	
	public CaseState getCase(int rowNumber, int ColNumber){
		return this.grid[rowNumber][ColNumber];
	}
	
	public CaseState getCase(Couple couple){
		return this.grid[couple.first()][couple.second()];
	}
	
	public int getNbRow(){
		return nbRow;
	}
	
	public int getNbCol(){
		return nbCol;
	}
	
	public boolean suprTetris(int numRow){
		//verifie si la ligne numRow n'a que des cases remplis
		boolean tetris=this.grid[numRow][0]==CaseState.FULL;
		for(int j=1; j<nbCol; j++){
			tetris = tetris && this.grid[numRow][j]==CaseState.FULL;
		}
	
		if(tetris){
			//décalage des lignes au dessus
			for(int i=numRow;i<nbRow-1;i++){
				for(int j=0;j<nbCol;j++){
					grid[i][j]= grid[i+1][j];
				}
			}
			//met la ligne du haut a vide
			for(int j=0;j<nbCol;j++){
				grid[nbRow][j]= CaseState.EMPTY;
			}
		}
		return tetris;
	}
	
}
