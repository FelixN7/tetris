package tetris.pieces;

import java.awt.Color;
import java.util.Vector;

import tetris.Case;
import tetris.CaseState;
import tetris.Grid;
import tetris.Piece;
import utilities.Couple;

public class Z extends Piece {

	public Z(int rotation, Color color, Couple coord) {
		switch (rotation){
		case 0:
			rot0(color);
			break;
		case 1:
			rot1(color);
			break;
		default:
		}
		this.color = color;
		this.coord = coord;
		this.rotation=rotation;
	}
	
	@Override
	public void rotationR(Grid grid) {
		switch (rotation){
		case 0:
			rot0_1(grid);
			break;
		case 1:
			rot1_0(grid);
			break;
		default:
		}
	}

	@Override
	public void rotationL(Grid grid) {
		rotationR(grid);
	}

	private void rot0(Color color) {
		nbRow = 3;
		nbCol = 2;
		Case [][] mask = new Case [nbRow][nbCol];
		
		mask[0][0]= new Case(CaseState.USED, color);
		mask[0][1]= new Case(CaseState.EMPTY, color);
		
		mask[1][0]= new Case(CaseState.USED, color);
		mask[1][1]= new Case(CaseState.USED, color);
		
		mask[2][0]= new Case(CaseState.EMPTY, color);
		mask[2][1]= new Case(CaseState.USED, color);
		
		piecesCases = mask;
	}
	
	private void rot1(Color color) {
		nbRow = 2;
		nbCol = 3;
		Case [][] mask = new Case [nbRow][nbCol];
		
		mask[0][0]= new Case(CaseState.EMPTY, color);
		mask[0][1]= new Case(CaseState.USED, color);
		mask[0][2]= new Case(CaseState.USED, color);
		
		mask[1][0]= new Case(CaseState.USED, color);
		mask[1][1]= new Case(CaseState.USED, color);
		mask[1][2]= new Case(CaseState.EMPTY, color);
		
		piecesCases = mask;
	}
	
	private void rot0_1 (Grid grid){
		int x = coord.first();
		int y = coord.second();
		Vector<Couple> cases = new Vector<Couple>();
		cases.add(new Couple(x, y+1));
		cases.add(new Couple(x, y+2));
		cases.add(new Couple(x+1, y+2));
		cases.add(new Couple(x+2, y+2));
		if(grid.caseFree(cases)){
			//on peut tourner la piece
			rotation=1;
			rot1(color);
			//maj de la grille de jeu
			grid.setCase(x,y+1, new Case(CaseState.USED, color));
			grid.setCase(x,y+2, new Case(CaseState.USED, color));
			grid.setCase(x,y, new Case(CaseState.EMPTY, color));
			grid.setCase(x+2,y+1, new Case(CaseState.EMPTY, color));
		}
	}

	private void rot1_0 (Grid grid){
		int x = coord.first();
		int y = coord.second();
		Vector<Couple> cases = new Vector<Couple>();
		cases.add(new Couple(x, y));
		cases.add(new Couple(x+1, y+2));
		cases.add(new Couple(x+2, y+1));
		cases.add(new Couple(x+2, y+2));
		if(grid.caseFree(cases)){
			//on peut tourner la piece
			rotation=0;
			rot0(color);
			//maj de la grille de jeu
			grid.setCase(x,y+1, new Case(CaseState.EMPTY, color));
			grid.setCase(x,y+2, new Case(CaseState.EMPTY, color));
			grid.setCase(x,y, new Case(CaseState.USED, color));
			grid.setCase(x+2,y+1, new Case(CaseState.USED, color));
		}
	}
}