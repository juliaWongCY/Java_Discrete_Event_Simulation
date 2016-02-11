package ssq;

import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class SingleServerQueue extends Simulation {

 Queue<ScheduledEvent> queue = new PriorityQueue<>();
 private Random randomNum;
 private double execTime;
 private int queueNum = 0;
 private final double serviceTime = 0.25;

  public SingleServerQueue(long seed, double execTime){
    super(execTime);
    randomNum = new Random(seed);
    this.execTime = execTime;

  }

  @Override
  protected boolean stop() {
    return (getCurrentTime() > execTime);
  }

  public void scheduleNewArrival(){
    schedule(new Arrival(), getInterArrivalTime());
  }

  public void scheduleNewDeparture(){
      schedule(new Departure(), serviceTime);
  }

  public int increaseQueueNum() {
    queueNum++;
      return  queueNum;
  }

  public int decreaseQueueNum() {
      queueNum--;
      return queueNum;
  }

  public int getNumOfQueue(){
    return queueNum;
  }

  public double getInterArrivalTime(){
    return randomNum.nextDouble();
  }

  public boolean isQueueEmpty(){
    if(queue.isEmpty()){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    assert (args.length == 2): "We only accept 2 arguments";
    long seed = Long.parseLong(args[0]);
    double execTime = Double.parseDouble(args[1]);
    SingleServerQueue ssq = new SingleServerQueue(seed,execTime);
    //double currentTime = ssq.getCurrentTime();
    double interArrivalTime = ssq.getInterArrivalTime();


    ssq.schedule(new Arrival(), interArrivalTime);
    ssq.simulate();
    System.out.println("SIMULATION COMPLETE");



  }

}



//double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);
//Departure departure = new Departure();


//System.out.println("Arrival at " + currentTime + ", new population = " );
//ssq.schedule(new Departure(), execTime);

//interArrivalTime = randomNum.nextDouble() + ssq.getCurrentTime();

