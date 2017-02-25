package tetrisGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tetris.Case;
import tetris.CaseState;
import tetris.Game;
import tetris.Grid;
import tetris.Piece;
import tetris.Tetris;
import tetris.pieces.T;
import utilities.Couple;

public class TetrisView {

	private static final HashMap<Color, ImageIcon> images = new HashMap<Color, ImageIcon>();
	static{
		images.put(Color.white, new ImageIcon("ressources/white.png"));
		images.put(Color.blue, new ImageIcon("ressources/blue.png"));
		images.put(Color.red, new ImageIcon("ressources/red.png"));
		images.put(Color.green, new ImageIcon("ressources/green.png"));
		images.put(Color.cyan, new ImageIcon("ressources/cyan.png"));
		images.put(Color.yellow, new ImageIcon("ressources/yellow.png"));
		images.put(Color.pink, new ImageIcon("ressources/pink.png"));
		images.put(Color.orange, new ImageIcon("ressources/orange.png"));
	}


	private JLabel[][] cells;
	private Container container;
	private int tailleLigne;
	private int tailleColonne;
	private TetrisControler tControl;

	public TetrisView(Tetris tetris, Container container){
		tailleLigne = tetris.getGrid().getNbRow()-3; //-3 correspond aux 3 lignes invisbles au dessus de la grille
		tailleColonne = tetris.getGrid().getNbCol();
		this.container = container;
		cells = new JLabel[tailleLigne][tailleColonne];
		tControl = new TetrisControler(tetris, this);
		this.container.setLayout(new GridLayout(tailleLigne, tailleColonne));
		
		this.container.addKeyListener(tControl);
		this.container.setFocusable(true);

		for(int i=tailleLigne-1 ; i>=0 ; i--){
			for(int j=0 ; j<tailleColonne ; j++){
				cells[i][j] = new JLabel();
				this.container.add(cells[i][j]);
				Case cell = tetris.getGrid().getCase(i,j);
				if(cell.getState() == CaseState.EMPTY){
					cells[i][j].setIcon(images.get(Color.white));
				}else{
					cells[i][j].setIcon(images.get(cell.getColorCase()));
				}
			}
		}
	}
	
	public TetrisControler getTControl() {
		return this.tControl;
	}

	public void refreshCell(int r, int c){
		final Case cell = tControl.getTetris().getGrid().getCase(r,c);
		final JLabel current = cells[r][c];
		SwingUtilities.invokeLater(new Runnable() {	
			public void run() {
				if(cell.getState() == CaseState.EMPTY){
					current.setIcon(images.get(Color.white));
				}else{
					current.setIcon(images.get(cell.getColorCase()));
				}
			}
		});
	}



	public void refresh(){
		for(int i=0 ; i<tailleLigne ; i++){
			for(int j=0 ; j<tailleColonne ; j++){
				refreshCell(i, j);
			}
		}
	}


	@SuppressWarnings("unused")
	private static void affGrid(Grid grid){
		for(int i=0; i<grid.getNbRow();i++){
			for (int j=0;j<grid.getNbCol();j++){
				System.out.println("("+ i + "," + 
						j + ") = " + grid.getCase(i, j).getState());
			}
		}
		System.out.println("\n");
	}

	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame("Tetris");
				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fenetre.setVisible(true);
				fenetre.setSize(new Dimension(200, 200));
				Container contenu = fenetre.getContentPane();
				contenu.removeAll();
				Game game = new Game(20, 10);
				final TetrisView tView = new TetrisView (game.getTetris(), contenu);
				tView.refresh();
				fenetre.pack();
				//game.jouer();
			}

		});
	}

}
