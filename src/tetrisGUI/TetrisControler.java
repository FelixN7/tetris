package tetrisGUI;

import tetris.Tetris;

public class TetrisControler {

	private TetrisView tView;
	private Tetris tetris;
	
	public TetrisControler(Tetris tetris, TetrisView tetrisView) {
		this.tetris = tetris;
		this.tView = tetrisView;
	}

	public Tetris getTetris() {
		return this.tetris;
	}
}
