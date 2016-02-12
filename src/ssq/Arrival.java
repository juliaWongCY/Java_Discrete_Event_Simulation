package ssq;

import simulation.Event;
import simulation.Simulation;




public class Arrival implements Event {



    @Override
    public void invoke(Simulation simulation) {
        SingleServerQueue ssq = (SingleServerQueue) simulation;

        if (ssq.isQueueEmpty()) {
            ssq.scheduleNewArrival();
            ssq.scheduleNewDeparture();

        } else {
          ssq.scheduleNewArrival();


        }
        double currentTime = simulation.getCurrentTime();
        //System.out.println("An arrival has happened.");
        System.out.println("Arrival at " + currentTime + ", new population = " + ssq.increaseQueueNum());


    }
}





