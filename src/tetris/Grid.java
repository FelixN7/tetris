package tetris;

import tetris.Case;
import tetris.CaseState;

public class Grid {
	private Case [][] grid;
	private int nbRow;
	private int nbCol;

	public Grid(int nbRow, int nbCol) {
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.grid = new Case [nbRow] [nbCol];
		for(int i=0; i<nbRow;i++){
			for(int j=0; j<nbCol;j++){
				this.grid[i][j].setState(CaseState.EMPTY);
			}
		}
	}
	
	public CaseState getCaseState(int rowNumber, int ColNumber){
		return this.grid[rowNumber][ColNumber].getState();
	}
	
	public CaseState getCaseState(Couple couple){
		return this.grid[couple.first()][couple.second()].getState();
	}
	
	public int getNbRow(){
		return nbRow;
	}
	
	public int getNbCol(){
		return nbCol;
	}
	
}
