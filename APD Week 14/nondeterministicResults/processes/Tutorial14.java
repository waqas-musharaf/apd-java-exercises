package processes;
/**
 * Run both processes in parallel
 */
public class Tutorial14 {
  public static void main(String[] args) {
    Process1 process1 = new Process1();
    Process2 process2 = new Process2();
    System.out.println("x is " + Process.getX() + ", y is " + Process.getY());
    process1.start(); process2.start();
    try {
      process1.join(); process2.join();
    } catch (InterruptedException ie) {}
    System.out.println("x is " + Process.getX() + ", y is " + Process.getY());
  }
}
