package simulation;


public class ScheduledEvent implements Comparable<ScheduledEvent> {

  private Event event;
  private double time;


  public ScheduledEvent(Event event, double time){
    this.event = event;
    this.time = time;

  }

  @Override
  public int compareTo(ScheduledEvent secondSchedule){

    double secScheduleTime = secondSchedule.getTime();
    return Double.compare(time, secScheduleTime);

  }

  public double getTime() {
    return time;
  }

  public Event getEvent(){
    return event;
  }



}
