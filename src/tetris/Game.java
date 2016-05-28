package tetris;

public class Game {
	private int nbRow;
	private int nbCol;
	private Case [][] grid;
	
	
	public Game(int nbRow, int nbCol){
		
		
		
	}
	
	public boolean supprTetris(int numRow){
		//verifie si la ligne numRow n'a que des cases remplies
		boolean tetris=this.grid[numRow][0].getState()==CaseState.FULL;
		for(int j=1; j<nbCol; j++){
			tetris = tetris && this.grid[numRow][j].getState()==CaseState.FULL;
		}
	
		if(tetris){
			//décalage des lignes au dessus
			for(int i=numRow;i<nbRow-1;i++){
				for(int j=0;j<nbCol;j++){
					grid[i][j] = grid[i+1][j];
				}
			}
			//met la ligne du haut a vide
			for(int j=0;j<nbCol;j++){
				grid[nbRow-1][j].setState(CaseState.EMPTY);
			}
		}
		return tetris;
	}
	
	/*public boolean isGameOver(){
		//ajout d'une ligne en haut de la grille ?
	}*/
}
