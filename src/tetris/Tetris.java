package tetris;

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
				grid.setCase(coord.first()+i, coord.second()+j, mask[i][j]);
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
	
	public void down(){
		this.pieceCourante.down(this.grid);
	}
	
	public void rotationR(){
		this.pieceCourante.rotationR(this.grid);
	}
	
	public void rotationL(){
		this.pieceCourante.rotationL(this.grid);
	}
}
