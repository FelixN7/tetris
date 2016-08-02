package tetris;

import java.awt.Color;
import java.util.Vector;

public class Grid {
	private Case [][] grid;
	private int nbRow;
	private int nbCol;

	public Grid(int nbRow, int nbCol) {
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.grid = new Case[nbRow][nbCol];
		for(int i=0; i<nbRow;i++){
			for(int j=0; j<nbCol;j++){
				this.grid[i][j] = new Case(CaseState.EMPTY, Color.white);
			}
		}
	}

	public Case getCase(int rowNumber, int ColNumber){
		return this.grid[rowNumber][ColNumber];
	}

	public Case getCase(Couple couple){
		return this.grid[couple.first()][couple.second()];
	}

	public void setCase(int rowNumber, int ColNumber, Case c){
		this.grid[rowNumber][ColNumber] = c;
	}

	public void setCase(Couple couple, Case c){
		this.grid[couple.first()][couple.second()] = c;
	}

	public int getNbRow(){
		return nbRow;
	}

	public int getNbCol(){
		return nbCol;
	}

	public boolean caseFree(Vector<Couple> cases){
		boolean b = true;
		for(Couple couple : cases){
			if(couple.inf(nbRow, nbCol) && couple.sup(0, 0)){
				b=b && getCase(couple).getState()==CaseState.EMPTY;
			}else{
				b=false;
			}
		}
		return b;
	}

}
