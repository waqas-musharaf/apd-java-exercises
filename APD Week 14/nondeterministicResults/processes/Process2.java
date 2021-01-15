package processes;
/**
 * One version of the process --- assign x+1 to y.
 */
public class Process2 extends Process {
  public void run() {
    y = x + 1;
  }
}
