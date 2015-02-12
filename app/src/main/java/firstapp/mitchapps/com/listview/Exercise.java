package firstapp.mitchapps.com.listview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user1 on 2/11/2015.
 */
public class Exercise implements Serializable {

    public ArrayList<Workout> Exercises;

    public Date dateOfExercise;

    public Exercise(ArrayList<Workout> exercises) {
        Exercises = exercises;
    }

    public ArrayList<Workout> getExercises() {
        return Exercises;
    }

    public void setExercises(ArrayList<Workout> exercises) {
        Exercises = exercises;
    }

    public Date getDateOfExercise() {
        return dateOfExercise;
    }

    public void setDateOfExercise(Date dateOfExercise) {
        this.dateOfExercise = dateOfExercise;
    }
}
