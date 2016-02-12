package ticks;

import simulation.Event;

class TicksPrint implements Event<Ticks> {

  @Override
  public void invoke(Ticks simulation) {
    for (double result = 1; result < simulation.getCurrentTime(); result++) {
      System.out.println("Tick at: " + result );
    }
  }

}
