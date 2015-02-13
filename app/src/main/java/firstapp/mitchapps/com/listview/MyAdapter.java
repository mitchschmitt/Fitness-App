package firstapp.mitchapps.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user1 on 2/11/2015.
 */


// We can create custom adapters
class MyAdapter extends ArrayAdapter<Exercise> {
    public Context context;
    public ArrayList<Exercise> exercises;

    public MyAdapter(Context context, int textViewResourceID, ArrayList<Exercise> exercises){
        super(context, R.layout.row_layout_2, exercises);
        this.context=context;
        this.exercises=exercises;
    }

    // Override getView which is responsible for creating the rows for our list
    // position represents the index we are in for the array.

    // convertView is a reference to the previous view that is available for reuse. As
    // the user scrolls the information is populated as needed to conserve memory.

    // A ViewGroup are invisible containers that hold a bunch of views and
    // define their layout properties.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // The LayoutInflator puts a layout into the right View
       LayoutInflater theInflater = LayoutInflater.from(getContext());

       // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // inflate takes the resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);

        TextView textView1 = (TextView) theView.findViewById(R.id.title_of_exercise);

        // We retrieve the text from the array
        /*String tvShow = getItem(position);

        // Get the TextView we want to edit
        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        // Put the next TV Show into the TextView
        theTextView.setText(tvShow);

        // Get the ImageView in the layout
        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);

        // We can set a ImageView like this
        theImageView.setImageResource(R.drawable.dot);*/

        return theView;

    }
}