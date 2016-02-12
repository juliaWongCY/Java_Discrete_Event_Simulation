package ssq;

import simulation.Event;


public class Arrival implements Event<SingleServerQueue> {


  @Override
  public void invoke(SingleServerQueue simulation) {
    if (simulation.isQueueEmpty()) {
      simulation.scheduleNewArrival();
      simulation.scheduleNewDeparture();
    } else {
      simulation.scheduleNewArrival();
    }
    int newPopulation = simulation.increaseQueueNum();
    double currentTime = simulation.getCurrentTime();
    System.out.println("Arrival at " + currentTime + ", new population = " + newPopulation);
    simulation.meanLength();
  }
}





