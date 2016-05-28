package tetris;

import java.awt.Color;

public class Case {
	private CaseState state;
	private Color colorCase;
	
	public Case(CaseState state, Color colorCase) {
		this.state = state;
		this.colorCase = colorCase;
	}
	
	public CaseState getState(){
		return this.state;
	}
	
	public void setState(CaseState state){
		this.state = state;
	}

	public Color getColorCase() {
		return colorCase;
	}

	public void setColorCase(Color colorCase) {
		this.colorCase = colorCase;
	}
	
	
	
}
