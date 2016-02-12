package ssq;


import simulation.Event;
import simulation.Simulation;



public class Departure implements Event{

  @Override
  public void invoke(Simulation simulation) {
      SingleServerQueue ssq = (SingleServerQueue) simulation;
      int newPopulation = ssq.decreaseQueueNum();

      if(!ssq.isQueueEmpty()){
        ssq.scheduleNewDeparture();
      }
      double currentTime = simulation.getCurrentTime();
      //System.out.println("A departure has happened.");
      System.out.println("Departure at " + currentTime + ", new population = " + newPopulation);



      }

  }


