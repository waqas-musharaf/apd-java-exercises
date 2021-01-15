package carpark;

public class Departures extends Thread {
	
	CarParkControl control;
	
	public Departures(CarParkControl control) {
		this.control = control;
	}

	public void run() {
		try {
			while (true) {
				control.depart();
			}
		} catch (InterruptedException e) {}
	}
}
