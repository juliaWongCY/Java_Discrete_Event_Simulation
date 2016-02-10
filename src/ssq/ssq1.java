package ssq;

import simulation.Event;
import simulation.Simulation;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ssq1 implements Event {

  Random randomNum = new Random();
  double serviceTime = 0.25;
  double interArrivalTime = ThreadLocalRandom.current().nextDouble(0, 1);


  public Ssq1(){

  }

  @Override
  public void invoke(Simulation simulation) {
  }




}
