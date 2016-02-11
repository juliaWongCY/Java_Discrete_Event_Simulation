package ssq;

import simulation.Event;
import simulation.ScheduledEvent;
import simulation.Simulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;


public class Arrival implements Event {
    private final double serviceTime = 0.25;



    @Override
    public void invoke(Simulation simulation) {
        double currentTime = simulation.getCurrentTime();
        //ScheduledEvent scheduledEvent = new ScheduledEvent(arrivalE, currentTime);
        SingleServerQueue ssq = (SingleServerQueue) simulation;
        Arrival arrival = new Arrival();

        if (ssq.isQueueEmpty()) {
            ssq.increaseQueueNum();
            System.out.println("An arrival has happened.");
            ssq.schedule(arrival, ssq.getInterArrivalTime());
            ssq.scheduleNewDeparture();
            ssq.scheduleNewArrival();
        } else {
            ssq.schedule(arrival, ssq.getInterArrivalTime());
            Departure departure = new Departure();

            ssq.schedule(departure, serviceTime);

            System.out.println("An arrival has happened.");
            ssq.scheduleNewArrival();
        }

        System.out.println("Arrival at " + currentTime + ", new population = " + ssq.getNumOfQueue());




            //simulation.schedule(arrivalE, interArrivalTime);
   /* } else {
        queue.add(scheduledEvent);
        System.out.println("An arrival has happened.");
        simulation.schedule(arrivalE, interArrivalTime);
        //System.out.println("Arrival at " + interArrivalTime + ", new population = " + queueNum);

    }*/

        }
    }





/*arrivalNum ++;
    queueNum ++;
    queue.add(scheduledEvent);
    System.out.println("An arrival has happened.");
    */

//((SingleServerQueue simulation).add(scheduledEvent);
