package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation<S> {
  protected double currentTime;
  Queue<ScheduledEvent<S>> diary = new PriorityQueue<>();


  public Simulation(double currentTime) {

    this.currentTime = currentTime;
  }

  protected abstract boolean stop();

  protected abstract S getState();

  public double getCurrentTime() {
    return currentTime;
  }

  public void schedule(Event<S> e, double offset) {
    double scheduledTime = currentTime + offset;
    ScheduledEvent<S> event = new ScheduledEvent<>(e, scheduledTime);
    diary.add(event);
  }

  public void simulate() {
    while ((!stop()) && !diary.isEmpty()) {
      ScheduledEvent<S> nextEvent = diary.poll();
      currentTime = nextEvent.getTime();
      if (stop()) {
        break;
      } else {
        nextEvent.getEvent().invoke(getState());
      }
    }
  }

}
