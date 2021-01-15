package Semaphore;


/**
 * Write a description of interface SemaphoreI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface SemaphoreInterface
{
    public void poll() throws InterruptedException;
    public void vote() throws InterruptedException, SemaphoreLimitError;
    public String getName();
}
