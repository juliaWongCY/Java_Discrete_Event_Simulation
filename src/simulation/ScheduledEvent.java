package simulation;


public class ScheduledEvent<S> implements Comparable<ScheduledEvent> {

  private Event<S> event;
  private double time;


  public ScheduledEvent(Event<S> event, double time) {
    this.event = event;
    this.time = time;

  }

  @Override
  public int compareTo(ScheduledEvent secondSchedule) {
    double secScheduleTime = secondSchedule.getTime();
    return Double.compare(time, secScheduleTime);
  }

  public double getTime() {
    return time;
  }

  public Event<S> getEvent() {
    return event;
  }


}
