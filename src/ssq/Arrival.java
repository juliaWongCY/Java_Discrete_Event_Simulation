package ssq;


import simulation.Event;
import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Arrival implements Event {

  Queue<ScheduledEvent> queue = new PriorityQueue<>();
  int arrivalNum = 0;
  int queueNum = 0;
  double serviceTime = 0.25;
  double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);

  private Event arrivalE;

  public Arrival(){
    //this.arrivalE = arrivalE;

  }

  @Override
  public void invoke(Simulation simulation) {
    double currentTime = simulation.getCurrentTime();
    ScheduledEvent scheduledEvent = new ScheduledEvent(arrivalE, currentTime);
    /*arrivalNum ++;
    queueNum ++;
    queue.add(scheduledEvent);
    System.out.println("An arrival has happened.");
    */

    if(queue.isEmpty()){
        arrivalNum ++;
        queueNum ++;
        queue.add(scheduledEvent);
        System.out.println("An arrival has happened.");

        simulation.schedule(arrivalE, serviceTime);
      System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);
    } else {
        arrivalNum ++;
        queueNum ++;
        queue.add(scheduledEvent);
        System.out.println("An arrival has happened.");

        simulation.schedule(arrivalE, interArrivalTime);
      System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);

    }

  }
}
