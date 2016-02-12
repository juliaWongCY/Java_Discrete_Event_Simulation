package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

  public Ticks(double currentTime) {
    super(currentTime);
  }

  @Override
  protected boolean stop() {
    return false;
  }

  @Override
  protected Ticks getState() {
    return this;
  }

  public static void main(String[] args) {
    assert (args.length == 1) : "We only accept 1 argument";
    double n = Double.parseDouble(args[0]);
    Ticks ticks = new Ticks(0);
    ticks.schedule(new TicksPrint(), n);
    ticks.simulate();
  }
}
