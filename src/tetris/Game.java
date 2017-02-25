package tetris;

import java.awt.Color;
import java.util.Random;

import tetris.pieces.I;
import tetris.pieces.J;
import tetris.pieces.L;
import tetris.pieces.O;
import tetris.pieces.S;
import tetris.pieces.T;
import utilities.Couple;
import utilities.Timer;

public class Game {
	private Piece pieceSuivante;
	//private int level; a utiliser pour accelerer la vitesse de jeu
	private Tetris tetris;


	public Game(int nbRow, int nbCol){
		this.tetris = new Tetris(new Grid(nbRow+3, nbCol)); //ajout de 3 lignes supplementaires pour gerer le game over
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

	public int supprTetris(){
		int nbTetris = 0;
		int nbRow = this.tetris.getGrid().getNbRow();
		for (int i=0; i<nbRow-3;i++){
			nbTetris = supprTetris(i)? (nbTetris+1) : nbTetris;
		}
		return nbTetris;
	}

	private Piece tiragePiece(){

		Random rand = new Random();
		int nbAlea = rand.nextInt(100);
		int numColoration = (rand.nextInt(100))%7;
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
		case 5:
			color = Color.orange;
			break;
		default:
			color = Color.pink;
			break;
		}
		switch (nbAlea%7) {
		case 0:
			numRot = nbAlea%2;
			if(numRot==0){
				p = new I(numRot,color,new Couple(nbRow-7, nbCol/2));
			}else{
				p = new I(numRot, color, new Couple(nbRow-4, (nbCol/2)-2));
			}
			break;
		case 1:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new J(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			case 1:
				p = new J(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			case 2:
				p = new J(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			default:
				p = new J(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			}
			break;
		case 2:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new L(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			case 1:
				p = new L(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			case 2:
				p = new L(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			default:
				p = new L(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			}
			break;
		case 3:
			p = new O(0, color, new Couple(nbRow-5, (nbCol/2)-1));
			break;
		case 4:
			numRot = nbAlea%2;
			if(numRot==0){
				p = new S(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
			}else{
				p = new S(numRot, color, new Couple(nbRow-5, (nbCol/2)-1));
			}
			break;
		case 5:
			numRot = nbAlea%4;
			switch (numRot) {
			case 0:
				p = new T(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			case 1:
				p = new T(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			case 2:
				p = new T(numRot,color,new Couple(nbRow-5, (nbCol/2)-1));
				break;
			default:
				p = new T(numRot,color,new Couple(nbRow-6, (nbCol/2)-1));
				break;
			}
			break;	
		default:
			//TODO Faire les modifs pour la piece Z
			//p = new Z();
			p = new S(0,color,new Couple(nbRow-6, (nbCol/2)-1)); //a remplacer par z lorsque ca sera bon
			break;
		}
		return p;
	}


	public void suivante(){
		this.tetris.addPiece(pieceSuivante);
		this.pieceSuivante = tiragePiece();
	}

	public boolean isGameOver(){
		boolean occupied=false;
		int nbRow = this.tetris.getGrid().getNbRow();
		int nbCol = this.tetris.getGrid().getNbCol();

		for(int j=0;j<nbCol;j++){
			occupied = occupied || (this.tetris.getGrid().getCase(nbRow-3,j).getState()== CaseState.FULL);
		}
		return occupied;	
	}

	public void jouer(){
		boolean poser;
		boolean gameOver=false;
		Timer coolDown = new Timer(2000);

		while(! gameOver){
			suivante();
			poser = true;
			while( poser){
				poser = this.tetris.down();
				Thread wait = new Thread(coolDown);
				wait.start();
				while (coolDown.getActivate());
			}
			this.supprTetris();
			gameOver = isGameOver();
		}
	}

	public Tetris getTetris(){
		return this.tetris;
	}




}
