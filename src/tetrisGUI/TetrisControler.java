package tetrisGUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tetris.Tetris;

public class TetrisControler implements KeyListener{

	private TetrisView tView;
	private Tetris tetris;

	public TetrisControler(Tetris tetris, TetrisView tetrisView) {
		this.tetris = tetris;
		this.tView = tetrisView;
	}

	public Tetris getTetris() {
		return this.tetris;
	}

	public void keyPressed(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {
		//TODO Reprendre les touches de rotation pour eviter quelles ne s effectuent
		// plusieurs fois si on reste appuyer sur la touche
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			tetris.moveR();
			break;
		case KeyEvent.VK_LEFT:
			tetris.moveL();
			break;
		case KeyEvent.VK_UP:
			tetris.rotationL();
			break;
		case KeyEvent.VK_DOWN:
			tetris.rotationR();
			break;
		case KeyEvent.VK_ALT: //TODO supprimer ce cas la
			tetris.down();
			break;
		default:
			break;
		}
		tView.refresh();
	}

	public void keyTyped(KeyEvent arg0) {
		switch (arg0.getKeyChar()) {
		
		}
		tView.refresh();
	}
}
