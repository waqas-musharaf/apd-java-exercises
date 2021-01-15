package counter;

import java.util.HashSet;

@SuppressWarnings("serial")
public class ThreadHashSet<T extends Thread> extends HashSet<T> implements ThreadSet<T>{

	@Override
	public void runSet() throws InterruptedException {
		for (T counter : this) {
			counter.start();
		}
		for (T counter : this) {
			try {
				counter.join();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

