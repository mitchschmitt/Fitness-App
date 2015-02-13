package firstapp.mitchapps.com.listview;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class MainActivity extends ActionBarActivity {

    public static ArrayList<String> exercises; //TODO make this work with ArrayList<Exercise> with MyAdapter
    public static Button addButton;
    public static EditText exerciseEntered;
    public static ListAdapter theAdapter;
    public Button browserButton;
    public ArrayList<Exercise> exerciseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browserButton = (Button) findViewById(R.id.browser_button);
        addButton = (Button)findViewById(R.id.add_exercise_button);

        /*exercises = new ArrayList<>(Arrays.asList("Bench Press", "Dips",
                 "Shoulder Press", "Bicep Curl", "Hammer Curl", "Tricep Extension",
                 "Cable Row", "Lat Pulldown", "Bent Over Row", "Dumbbell Squat"));*/

        //Collections.sort(exercises);

        exerciseArray = new ArrayList<Exercise>();//TODO

        MyAdapter mAdapter = new MyAdapter(this, R.layout.row_layout_2, exerciseArray);//TODO

        theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,exercises);

        ListView theList = (ListView)findViewById(R.id.the_list);


        theList.setAdapter(mAdapter);
        //theList.setAdapter(theAdapter);

        theList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String exercisePicked = "You picked " + String.valueOf(theAdapter.getItem(position));
                Toast.makeText(MainActivity.this,exercisePicked,Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        onPause();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            DialogFragment myFragment = new MyDialogFragment();
            myFragment.show(getFragmentManager(), "theDialog");
            return true;

            // If exit was clicked close the app
        } else if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void reloadData(){
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null) {//OMFG wtf this was such an annoying bug. CHECK DATA TO SEE IF ITS NULL OR BACK BUTTON DUN NOT WORX
            // check if the request code is same as what is passed  here it is 2
            if (requestCode == 2) {
                String message = data.getStringExtra("exercise added");
                exercises.add(message);
                Collections.sort(exercises);
            }
        }
    }

    public void addExerciseButtonClicked(View view) {
        Intent intent = new Intent(this, ExerciseAddedActivity.class);
       /*ditText editText = (EditText) findViewById(R.id.enter_exercise_edit_text);
        Button enterExercise = (Button) findViewById(R.id.add_exercise_button);*/
        startActivityForResult(intent, 2);
    }

    public void showWorkout(View view) {
        //TODO when a user clicks on list item, bring them to workout page.
    }

    /*
    just wanted to see how to open a browser using intents. heh.
     */
    public void openBrowser(View view) {
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}