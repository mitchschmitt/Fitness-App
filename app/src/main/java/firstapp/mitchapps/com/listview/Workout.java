package firstapp.mitchapps.com.listview;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user1 on 2/11/2015.
 */
public class Workout implements Serializable {

    public String name;
    public ArrayList<Set> sets;

    public Workout(String name, ArrayList<Set> sets) {
        this.name = name;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }

}
