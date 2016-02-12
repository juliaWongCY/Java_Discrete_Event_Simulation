package ticks;

import simulation.Event;
import simulation.Simulation;

class TicksPrint implements Event<Ticks> {

  public TicksPrint(){

  }

  @Override
  public void invoke(Ticks simulation) {
    for (double result = 1; result < simulation.getCurrentTime(); result++) {
      System.out.println("Tick at: " + result );

    }
  }

}
