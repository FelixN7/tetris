package tetris.pieces;

import java.awt.Color;
import java.awt.ContainerOrderFocusTraversalPolicy;

import tetris.Case;
import tetris.CaseState;
import tetris.Couple;
import tetris.Grid;
import tetris.Piece;
 
public class L extends Piece {

	public L(int i, Color color, Couple coord) {
		switch (i){
		case 0: 
		}
		this.color = color;
		this.coord = coord;
	}

	@Override
	public void rotationR(Grid grid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotationL(Grid grid) {
		// TODO Auto-generated method stub

	}
	
	private static Case [][] rot0(Color color) {
		int rows = 3;
		int columns = 2;
		Case [][] mask = new Case [rows][columns];
		
		mask[0][0]= new Case(CaseState.FULL, color);
		mask[0][1]= new Case(CaseState.FULL, color);
		
		mask[1][0]= new Case(CaseState.FULL, color);
		mask[1][1]= new Case(CaseState.EMPTY, color);
		
		mask[2][0]= new Case(CaseState.FULL, color);
		mask[2][1]= new Case(CaseState.EMPTY, color);
		
		return mask;
		
	}
	
	private static Case [][] rot1(Color color) {
		int rows = 2;
		int columns = 3;
		Case [][] mask = new Case [rows][columns];
		
		mask[0][0]= new Case(CaseState.FULL, color);
		mask[0][1]= new Case(CaseState.EMPTY, color);
		mask[0][2]= new Case(CaseState.EMPTY, color);
		
		mask[1][0]= new Case(CaseState.FULL, color);
		mask[1][1]= new Case(CaseState.FULL, color);
		mask[1][2]= new Case(CaseState.FULL, color);
		
		return mask;
		
	}
	
	private static Case [][] rot2(Color color) {
		int rows = 3;
		int columns = 2;
		Case [][] mask = new Case [rows][columns];
		
		mask[0][0]= new Case(CaseState.EMPTY, color);
		mask[0][1]= new Case(CaseState.FULL, color);
		
		mask[1][0]= new Case(CaseState.EMPTY, color);		
		mask[2][0]= new Case(CaseState.FULL, color);
		mask[2][1]= new Case(CaseState.FULL, color);
		
		return mask;
		
	}
	
	private static Case [][] rot3(Color color) {
		int rows = 2;
		int columns = 3;
		Case [][] mask = new Case [rows][columns];
		
		mask[0][0]= new Case(CaseState.FULL, color);
		mask[0][1]= new Case(CaseState.FULL, color);
		mask[0][2]= new Case(CaseState.FULL, color);
		
		mask[1][0]= new Case(CaseState.EMPTY, color);
		mask[1][1]= new Case(CaseState.EMPTY, color);
		mask[1][2]= new Case(CaseState.FULL, color);
		
		return mask;
		
	}

}
