package carpark;

public class Arrivals extends Thread {
	
	CarParkControl control;
	
	public Arrivals(CarParkControl control) {
		this.control = control;
	}

	public void run() {
		try {
			while (true) {
				control.arrive();
			}
		} catch (InterruptedException e) {}
	}
}
