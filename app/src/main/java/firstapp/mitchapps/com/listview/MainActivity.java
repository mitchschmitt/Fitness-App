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

    public static ArrayList<String> exercises; //TODO if i want this to work with MyAdapter, it has to be a String[]
    public static Button addButton;
    public static EditText exerciseEntered;
    public static ListAdapter theAdapter;
    public Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Drawable FAB = getResources().getDrawable(R.drawable.fab);
        FloatingActionButton fabButton = new FloatingActionButton.Builder(this)
                .withDrawable(R.id.fab)
                .withButtonColor(Color.WHITE)
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 16, 16)
                .create();*/

        browserButton = (Button) findViewById(R.id.browser_button);
        addButton = (Button)findViewById(R.id.add_exercise_button);

        //exerciseEntered = (EditText)findViewById(R.id.enter_exercise);

        exercises = new ArrayList<>(Arrays.asList("Bench Press", "Dips",
                 "Shoulder Press", "Bicep Curl", "Hammer Curl", "Tricep Extension",
                 "Cable Row", "Lat Pulldown", "Bent Over Row", "Dumbbell Squat"));

        Collections.sort(exercises);

        theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,exercises);

        ListView theList = (ListView)findViewById(R.id.the_list);

        theList.setAdapter(theAdapter);

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

    public void addExerciseButtonClicked(View view) {


        final int result = 1;
        Intent intent = new Intent(this, ExerciseAddedActivity.class);
        EditText editText = (EditText) findViewById(R.id.enter_exercise_edit_text);
        Button enterExercise = (Button) findViewById(R.id.add_exercise_button);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, result);
        /*exercises.add(String.valueOf(exerciseEntered.getText()));
        String whatWasAdded = String.valueOf(exerciseEntered.getText());
        String exerciseAdded = "Added Exercise " + whatWasAdded + " " + exercises.size();
        Toast.makeText(this,exerciseAdded,Toast.LENGTH_SHORT).show();*/
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
