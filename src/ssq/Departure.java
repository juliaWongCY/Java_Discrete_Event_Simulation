package ssq;


import simulation.Event;
import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Departure implements Event{

  Queue<ScheduledEvent> queue = new PriorityQueue<>();
  int departureNum = 0;
  int queueNum = 0;
  double serviceTime = 0.25;
  double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);

  private Event departE;

  public Departure(){
    //this.departE = departE;
  }

  @Override
  public void invoke(Simulation simulation) {
    ScheduledEvent scheduledEvent
      = new ScheduledEvent(departE, simulation.getCurrentTime());


      if(queue.isEmpty()){
          departureNum ++;
          queueNum --;
          queue.add(scheduledEvent);
          System.out.println("An arrival has happened.");

          simulation.schedule(departE, serviceTime);
          System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);
      } else {
          departureNum ++;
          queueNum --;
          queue.add(scheduledEvent);
          System.out.println("An arrival has happened.");

          simulation.schedule(departE, interArrivalTime);
          System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);

      }

  }

}
