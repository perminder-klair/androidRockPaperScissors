package com.example.scorchsoftmini1.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends Activity implements View.OnClickListener {

    Button mRockBtn, mPaperBtn, mScissorsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRockBtn = (Button)findViewById(R.id.rockButton);
        mPaperBtn = (Button)findViewById(R.id.paperButton);
        mScissorsBtn = (Button)findViewById(R.id.scissorsButton);

        mRockBtn.setOnClickListener(this);
        mPaperBtn.setOnClickListener(this);
        mScissorsBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View buttonChosen) {
        Intent i = new Intent(this, ResultActivity.class);
        Random r = new Random();
        int androidChoice = r.nextInt(3); //returns value between 0 and 2

        if (buttonChosen == mRockBtn) {
            i.putExtra("userChoice", "rock");
        }
        if (buttonChosen == mPaperBtn) {
            i.putExtra("userChoice", "paper");
        }
        if (buttonChosen == mScissorsBtn) {
            i.putExtra("userChoice", "scissors");
        }

        if (androidChoice == 0) {
            i.putExtra("androidChoice", "rock");
        }
        if (androidChoice == 1) {
            i.putExtra("androidChoice", "paper");
        }
        if (androidChoice == 2) {
            i.putExtra("androidChoice", "scissors");
        }
        else {
            i.putExtra("Invalid choice");  
        }
        this.startActivity(i);
    }
}
