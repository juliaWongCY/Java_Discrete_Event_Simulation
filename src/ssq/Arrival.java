package ssq;

import simulation.Event;




public class Arrival implements Event<SingleServerQueue> {



    @Override
    public void invoke(SingleServerQueue simulation) {
        //SingleServerQueue ssq = simulation;

        if (simulation.isQueueEmpty()) {
            simulation.scheduleNewArrival();
            simulation.scheduleNewDeparture();

        } else {
          simulation.scheduleNewArrival();


        }
        double currentTime = simulation.getCurrentTime();
        //System.out.println("An arrival has happened.");
        System.out.println("Arrival at " + currentTime + ", new population = " + simulation.increaseQueueNum());


    }
}





