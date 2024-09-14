package oop.stop_watch;

import java.time.LocalTime;

public class stopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

   public stopWatch(){

   }
   public stopWatch(LocalTime startTime){
       this.startTime = startTime;
   }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    public LocalTime getStartTime(){
        return this.startTime;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }
    public LocalTime start(){
       this.startTime = LocalTime.now();
       return startTime;
    }
     public LocalTime stop(){
       this.endTime = LocalTime.now();
       return this.endTime;
     }


}
