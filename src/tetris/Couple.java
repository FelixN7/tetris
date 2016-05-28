package tetris;

public class Couple {
	private int a;
	private int b;
	
	public Couple(int fst, int snd){
		a=fst;
		b=snd;
	}
	
	public int first(){
		return a;
	}
	
	public int second(){
		return b;
	}
	
	public boolean inf(int x,int y){
		return a<x && b<y;
	}
	
	public boolean sup(int x, int y){
		return a>=x && b>=y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couple other = (Couple) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	
	
}
