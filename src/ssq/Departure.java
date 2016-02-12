package ssq;


import simulation.Event;
import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Departure implements Event{

  //Queue<ScheduledEvent> queue = new PriorityQueue<>();
  //double serviceTime = 0.25;
  //double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);

  //private Event departE;


  @Override
  public void invoke(Simulation simulation) {
      SingleServerQueue ssq = (SingleServerQueue) simulation;
      int newPopulation = ssq.decreaseQueueNum();

      if(!ssq.isQueueEmpty()){
        //System.out.println("An departure has happened.");
        ssq.scheduleNewDeparture();
      }
      double currentTime = simulation.getCurrentTime();
      //System.out.println("A departure has happened.");
      System.out.println("Departure at " + currentTime + ", new population = " + newPopulation);





      /*else {
        System.out.println("An departure has happened.");
        simulation.schedule(departE, interArrivalTime);
        */


         // simulation.schedule(departE, interArrivalTime + serviceTime);
         // System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);

      }

  }


// System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);


//int departureNum = 0;
//int queueNum = 0;


/*departureNum ++;
          queueNum --;
          queue.add(scheduledEvent);
          System.out.println("An arrival has happened.");
          */


//ScheduledEvent scheduledEvent = new ScheduledEvent(departE, simulation.getCurrentTime());
