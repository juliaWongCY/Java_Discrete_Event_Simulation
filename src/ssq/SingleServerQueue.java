package ssq;

import simulation.Simulation;
import java.util.Random;

public class SingleServerQueue extends Simulation<SingleServerQueue> {

  private Random randomNum;
  private double execTime;
  private int queueNum = 0;
  private final double serviceTime = 0.25;
  private double prevTime;
  private double meanLength;
  private int prevQNum;


  public SingleServerQueue(long seed, double execTime, long currentTime) {
    super(currentTime);
    randomNum = new Random(seed);
    this.execTime = execTime;
  }

  @Override
  protected boolean stop() {
    return (currentTime > execTime);
  }

  @Override
  protected SingleServerQueue getState() {
    return this;
  }

  public void scheduleNewArrival() {
    schedule(new Arrival(), getInterArrivalTime());
  }

  public void scheduleNewDeparture() {
    schedule(new Departure(), serviceTime);
  }

  public int increaseQueueNum() {
    queueNum++;
    return queueNum;
  }

  public int decreaseQueueNum() {
    queueNum--;
    return queueNum;
  }


  public void meanLength() {
    meanLength += (getCurrentTime() - prevTime) * prevQNum;
    prevTime = getCurrentTime();
    prevQNum = queueNum;
  }

  public double getMeanQueueLength() {
    meanLength += (execTime - prevTime) * prevQNum;
    return (meanLength / execTime);
  }


  public double getInterArrivalTime() {
    return randomNum.nextDouble();
  }

  public boolean isQueueEmpty() {
    return (queueNum == 0);
  }

  public static void main(String[] args) {
    assert (args.length == 2) : "We only accept 2 arguments";
    long seed = Long.parseLong(args[0]);
    double execTime = Double.parseDouble(args[1]);

    SingleServerQueue ssq = new SingleServerQueue(seed, execTime, 0);
    double interArrivalTime = ssq.getInterArrivalTime();

    ssq.schedule(new Arrival(), interArrivalTime);
    ssq.simulate();
    System.out.print("SIMULATION COMPLETE - " +
                     "the mean queue length was ");
    System.out.print(ssq.getMeanQueueLength());
  }

}





