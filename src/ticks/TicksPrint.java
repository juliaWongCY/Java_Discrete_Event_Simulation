package ticks;

import simulation.Event;
import simulation.Simulation;

class TicksPrint implements Event {

  public TicksPrint(){

  }

  @Override
  public void invoke(Simulation simulation) {
    for (double result = 1; result < simulation.getCurrentTime(); result++) {
      System.out.println("Tick at: " + result );

    }
  }

}
