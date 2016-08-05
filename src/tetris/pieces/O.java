package tetris.pieces;

import java.awt.Color;

import tetris.Case;
import tetris.CaseState;
import tetris.Couple;
import tetris.Grid;
import tetris.Piece;

public class O extends Piece {

	public O(int rotation, Color color, Couple coord){
		this.color = color;
		this.coord = coord;
		this.rotation=0;
		rot0(color);
	}

	@Override
	public void rotationR(Grid grid) {
		//TODO commenter la ligne en dessous
		System.out.println("true");
	}

	@Override
	public void rotationL(Grid grid) {
		//TODO commenter la ligne en dessous
		System.out.println("true");
	}

	private void rot0(Color color) {
		nbRow = 2;
		nbCol = 2;
		Case [][] mask = new Case [nbRow][nbCol];

		mask[0][0]= new Case(CaseState.USED, color);
		mask[0][1]= new Case(CaseState.USED, color);

		mask[1][0]= new Case(CaseState.USED, color);
		mask[1][1]= new Case(CaseState.USED, color);

		piecesCases = mask;
	}
}
