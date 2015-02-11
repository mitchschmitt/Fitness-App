package firstapp.mitchapps.com.listview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;


public class ExerciseAddedActivity extends ActionBarActivity {

    Button addExercise;
    EditText enterExercise;
    String whatWasAdded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_added);

        addExercise = (Button)findViewById(R.id.exercise_added_button);
        enterExercise = (EditText)findViewById(R.id.enter_exercise_edit_text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercise_added, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addExercise(View view) {
        whatWasAdded = ExerciseAddedActivity.this.enterExercise.getText().toString();
        if(whatWasAdded.equals("")){
            Toast.makeText(ExerciseAddedActivity.this, "Enter an Exercise", Toast.LENGTH_SHORT).show();
        }
        else {
            /*
            TODO need to change this to used the adapter, not the exercise arraylist itself. Also fix the intents//intents are fixxxed
             */
            finish();
        }
    }

    @Override
    public void finish(){
        String exerciseAdded = "Added Exercise " + whatWasAdded;
        Toast.makeText(ExerciseAddedActivity.this, exerciseAdded, Toast.LENGTH_SHORT).show();
        Intent sendBackData = new Intent();
        sendBackData.putExtra("exercise added", whatWasAdded);
        setResult(2, sendBackData);
        finish();
    }

    public void sendToArrayList(String exercise){
        MainActivity.exercises.add(exercise);
    }


}
