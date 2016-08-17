package utilities;


public class Timer implements Runnable {

	private boolean activate;
	private int time;

	public Timer(int time){
		this.activate = false;
		this.time = time;
	}
	
	public boolean getActivate(){
		return activate;
	}
	
	public void run() {
		this.activate = true;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.activate = false;
		
	}
	
	

}
