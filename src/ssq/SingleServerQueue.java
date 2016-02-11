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

  public SingleServerQueue(double currentTime){
    super(currentTime);
  }

  @Override
  protected boolean stop() {
        return false;
    }

  public static void main(String[] args) {
    SingleServerQueue ssq = new SingleServerQueue(0);
    assert (args.length == 2):"We only accept 2 arguments";
    long seed = Long.parseLong(args[0]);
    double time = Double.parseDouble(args[1]);
    double currentTime = ssq.getCurrentTime();


    while(currentTime < time + currentTime){
      double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);
      Arrival arrival = new Arrival();
      Departure departure = new Departure();
      Random randomNum = new Random(seed);

      //arrival.invoke(ssq);
      //departure.invoke(ssq);
      ssq.schedule(new Arrival(), time);
      ssq.schedule(new Departure(), time);
      ssq.simulate();

      interArrivalTime = randomNum.nextDouble() + ssq.getCurrentTime();


    }
  }

}
