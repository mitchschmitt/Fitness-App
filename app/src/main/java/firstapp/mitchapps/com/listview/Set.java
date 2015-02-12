package firstapp.mitchapps.com.listview;

import java.util.Timer;

/**
 * Created by user1 on 2/11/2015.
 */
public class Set {

    public int weight;
    public boolean timed;
    public Timer timer;
    
    public Set(int reps, int weight, boolean timed, Timer timer) {
        this.reps = reps;
        this.weight = weight;
        this.timed = timed;
        this.timer = timer;
    }

    public int reps;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isTimed() {
        return timed;
    }

    public void setTimed(boolean timed) {
        this.timed = timed;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

}
