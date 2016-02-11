package ssq;

import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SingleServerQueue extends Simulation {
    //long seed = new Random().nextLong();
    //Random randomNum = new Random();

  /*double serviceTime = 0.25;
  int queueNum = 0;
  Queue<ScheduledEvent> queue = new PriorityQueue<>();
  */
  public SingleServerQueue(double currentTime){
    super(currentTime);
  }

  @Override
  protected boolean stop() {
        return false;
    }

  public static void main(String[] args) {
    assert (args.length == 2):"We only accept 2 arguments";
    long seed = Long.parseLong(args[0]);
    double time = Double.parseDouble(args[1]);
    double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);


    while(interArrivalTime < time){
      Random randomNum = new Random(seed);

      SingleServerQueue ssq = new SingleServerQueue(0);
        if()
      ssq.schedule(new Arrival(), time);
      ssq.schedule(new Departure(), time);
      ssq.simulate();

      interArrivalTime = randomNum.nextDouble() + ssq.getCurrentTime();


    }
  }

}
