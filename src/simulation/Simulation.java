package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation {

  private double currentTime;
  Queue<ScheduledEvent> diary = new PriorityQueue<>();


  public Simulation(double currentTime){

    this.currentTime = currentTime;
    //this.diary = diary;
  }

  protected abstract boolean stop();

  public double getCurrentTime(){
    return currentTime;
  }

  protected void schedule(Event e, double offset){
    double scheduledTime = currentTime + offset;
    ScheduledEvent event = new ScheduledEvent(e, scheduledTime);
    diary.add(event);

  }

  protected void simulate(){
    //todo : check again
    while(!stop() && ! diary.isEmpty()){
      ScheduledEvent nextEvent = diary.poll();
      currentTime = nextEvent.getTime();
      Event currentEvent = nextEvent.getEvent();
      currentEvent.invoke(this);
    }
  }



}
