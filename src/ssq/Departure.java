package ssq;

import simulation.Event;

public class Departure implements Event<SingleServerQueue> {

  @Override
  public void invoke(SingleServerQueue simulation) {
    int newPopulation = simulation.decreaseQueueNum();

    if (!simulation.isQueueEmpty()) {
      simulation.scheduleNewDeparture();
    }
    double currentTime = simulation.getCurrentTime();
    System.out.println("Departure at " + currentTime +
                       ", new population = " + newPopulation);
    simulation.meanLength();
  }
}


