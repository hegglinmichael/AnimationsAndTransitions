package com.example.mike.animationsandtransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //creates an object
    ViewGroup myLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link to the xml
        myLayout = (ViewGroup) findViewById(R.id.mainView);

        //creates an onTouch listener
        myLayout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                moveButton();
                //returns true to say the event was handled
                return true;
            }
        });
    }

    //does the action when touching screen
    public void moveButton(){

        //gives a default transition animation
        TransitionManager.beginDelayedTransition(myLayout);

        //links button to xml
        View myButton = (Button)findViewById(R.id.button);

        //change the position of the button
        //how we want to position items in that layout
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //adding rule to what i want to happen(putting it on the bottom right)
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        //sets the rules to the specific layout
        myLayout.setLayoutParams(positionRules);

        //change the size of the button
        ViewGroup.LayoutParams sizeRules = myButton.getLayoutParams();
        //made more rules
        sizeRules.width = 450;
        sizeRules.height=300;
        //added the rules to the button
        myButton.setLayoutParams(sizeRules);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
