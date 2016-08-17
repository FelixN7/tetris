package tetrisGUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tetris.Tetris;
import utilities.Timer;

public class TetrisControler implements KeyListener{

	private TetrisView tView;
	private Tetris tetris;
	private Timer coolDownRotL;
	private Timer coolDownRotR;

	public TetrisControler(Tetris tetris, TetrisView tetrisView) {
		this.tetris = tetris;
		this.tView = tetrisView;
		this.coolDownRotL = new Timer(200);
		this.coolDownRotR = new Timer(200);
	}

	public Tetris getTetris() {
		return this.tetris;
	}

	public void keyPressed(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			tetris.moveR();
			break;
		case KeyEvent.VK_LEFT:
			tetris.moveL();
			break;
		case KeyEvent.VK_UP:
			if (!coolDownRotL.getActivate()){
				tetris.rotationL();
				Thread waitRotL = new Thread(coolDownRotL);
				waitRotL.start();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (!coolDownRotR.getActivate()){
				tetris.rotationR();
				Thread waitRotR = new Thread(coolDownRotR);
				waitRotR.start();
			}
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
