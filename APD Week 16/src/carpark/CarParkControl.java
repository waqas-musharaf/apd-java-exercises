package carpark;

public class CarParkControl {
	protected int spaces;
	protected int capacity;
	
	public CarParkControl(int n) {
		capacity = spaces = n;
		System.out.println(this);
	}
	
	public synchronized void arrive() throws InterruptedException {
		if (spaces == 0) {
			wait();
		}
		--spaces;
		System.out.println(this);
		notify();
	}

	public synchronized void depart() throws InterruptedException {
		if (spaces == capacity) {
			wait();
		}
		++spaces;
		System.out.println(this);
		notify();
	}
	
	public String toString() {
		int cars = capacity - spaces;
		return "Carpark: " 
			       + cars + (cars == 1 ? " car," : " cars,")
			       + spaces + (spaces == 1 ? " space." : " spaces.");
	}

}
