package tetris;

import utilities.Couple;

public class Tetris {
	private Grid grid;
	private Piece pieceCourante;

	public Tetris(Grid grid){
		this.grid = grid;
	}

	public Grid getGrid(){
		return this.grid;
	}

	public void addPiece(Piece piece){
		this.pieceCourante = piece;
		Case[][] mask = piece.getPiecesCases();
		Couple coord = piece.getCoord();
		for(int i=0 ; i<piece.getNbRow() ; i++){
			for(int j=0 ; j<piece.getNbCol() ; j++){
				Case caseCourante = grid.getCase(coord.first()+i, coord.second()+j);
				if (caseCourante.getState()!=CaseState.FULL){
					caseCourante.setColorCase(mask[i][j].getColorCase());
					caseCourante.setState(mask[i][j].getState());
				}
			}
		}
	}

	public Piece getPieceCourante() {
		return pieceCourante;
	}

	public void moveR(){
		this.pieceCourante.moveR(this.grid);
	}

	public void moveL(){
		this.pieceCourante.moveL(this.grid);
	}

	public boolean down(){
		return this.pieceCourante.down(this.grid);
	}

	public void rotationR(){
		this.pieceCourante.rotationR(this.grid);
	}

	public void rotationL(){
		this.pieceCourante.rotationL(this.grid);
	}
}
