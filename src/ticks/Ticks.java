package ticks;

import simulation.Simulation;

public class Ticks extends Simulation{

  public Ticks(double currentTime){

    super(currentTime);
  }

  @Override
  //todo : check this
  protected boolean stop() {
    return false;
  }

  public static void main(String[] args) {
    assert(args.length == 1):"We only accept 1 argument";
    double n = Double.parseDouble(args[0]);
    //int n = Integer.parseInt(args[0]);
    System.out.println("This is the tick simulation: ");


    Ticks ticks = new Ticks(0);
    ticks.schedule(new TicksPrint(), n);
    ticks.simulate();

  }

}
