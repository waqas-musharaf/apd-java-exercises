package carpark;

public class CarPark {
	
	public CarPark(int n) {
		CarParkControl control = new CarParkControl(n);
		Arrivals arrivals = new Arrivals(control);
		Departures departures = new Departures(control);
		arrivals.start();
		departures.start();
		try {
			arrivals.join();
			departures.join();
		} catch (InterruptedException e) {}
	}

	public static void main(String[] args) {
		new CarPark(25);
	}
}
