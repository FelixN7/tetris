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

import tetris.Case;
import tetris.CaseState;
import tetris.Couple;
import tetris.Grid;
import tetris.Piece;
import tetris.Tetris;
import tetris.pieces.I;

public class TetrisView {

	private static final HashMap<Color, ImageIcon> images = new HashMap<Color, ImageIcon>();
	static{
		images.put(Color.white, new ImageIcon("ressources/white.png"));
		images.put(Color.blue, new ImageIcon("ressources/blue.png"));
		images.put(Color.red, new ImageIcon("ressources/red.png"));
		images.put(Color.green, new ImageIcon("ressources/green.png"));
		images.put(Color.cyan, new ImageIcon("ressources/cyan.png"));
		images.put(Color.yellow, new ImageIcon("ressources/yellow.png"));
		images.put(Color.pink, new ImageIcon("ressources/purple.png"));
	}


	private JLabel[][] cells;
	private Container container;
	private int tailleLigne;
	private int tailleColonne;
	private TetrisControler tControl;

	public TetrisView(Tetris tetris, Container container){
		tailleLigne = tetris.getGrid().getNbRow();
		tailleColonne = tetris.getGrid().getNbCol();
		this.container = container;
		cells = new JLabel[tailleLigne][tailleColonne];
		tControl = new TetrisControler(tetris, this);
		this.container.setLayout(new GridLayout(tailleLigne, tailleColonne));

		for(int i=tailleLigne-1 ; i>=0 ; i--){
			for(int j=0 ; j<tailleColonne ; j++){
				cells[i][j] = new JLabel();
				this.container.add(cells[i][j]);
				cells[i][j].setIcon(images.get(Color.white));
			}
		}
	}

	public void refreshCell(int r, int c){
		Case cell = tControl.getTetris().getGrid().getCase(r,c);
		if(cell.getState() == CaseState.EMPTY){
			cells[r][c].setIcon(images.get(Color.white));
		}else{
			cells[r][c].setIcon(images.get(cell.getColorCase()));
		}
	}

	public void refresh(){
		for(int i=0 ; i<tailleLigne ; i++){
			for(int j=0 ; j<tailleColonne ; j++){
				refreshCell(i, j);
			}
		}
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
				Tetris tetris = new Tetris(new Grid(5, 5));
				TetrisView tView = new TetrisView(tetris, contenu);
				Piece p = new I(1, Color.blue, new Couple(4,0));
				tetris.addPiece(p);
				System.out.println(tetris.getPieceCourante().getCoord());
				System.out.println(tetris.getGrid().getCase(4, 1).getState());
				tView.refresh();


				//try {
					//Thread.sleep(5000);
					tetris.moveR();
					System.out.println(tetris.getPieceCourante().getCoord());
					System.out.println(tetris.getGrid().getCase(4, 4).getState());
					tView.refresh();
					//Thread.sleep(2000);
					/*tetris.down();
					System.out.println(tetris.getPieceCourante().getCoord());
					System.out.println(tetris.getGrid().getCase(3, 2).getState());
					tView.refresh();
					//Thread.sleep(2000);
					tetris.moveL();
					System.out.println(tetris.getPieceCourante().getCoord());
					System.out.println(tetris.getGrid().getCase(3, 1).getState());
					tView.refresh();
					//Thread.sleep(2000);
					tetris.down();
					System.out.println(tetris.getPieceCourante().getCoord());
					System.out.println(tetris.getGrid().getCase(2, 1).getState());
					tView.refresh();
					//Thread.sleep(2000);
					tetris.moveR();
					System.out.println(tetris.getPieceCourante().getCoord());
					System.out.println(tetris.getGrid().getCase(2, 2).getState());
					tView.refresh();

				/*} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

			}
		});
	}

}
