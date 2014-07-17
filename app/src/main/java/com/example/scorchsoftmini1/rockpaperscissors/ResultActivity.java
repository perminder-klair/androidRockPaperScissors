package com.example.scorchsoftmini1.rockpaperscissors;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button playAgainBtn;
        TextView resutltv;
        String userChoice = "";
        String androidChoice = "";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        playAgainBtn = (Button)findViewById(R.id.playAgainButton);
        playAgainBtn.setOnClickListener(this);
        resutltv = (TextView)findViewById(R.id.resultTextView);
        userChoice = this.getIntent().getExtras().getString("userChoice");
        androidChoice = this.getIntent().getExtras().getString("androidChoice");

        resutltv.setText("User chose " + userChoice + ", Android chose " + androidChoice +
        "\n" + getWinner(userChoice, androidChoice) + " won!");
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private String getWinner(String userChoice, String androidChoice) {
        if (userChoice.equals(androidChoice)) {
            return "nobody";
        } else if (userChoice.equals("rock") && androidChoice.equals("paper")) {
            return "Android";
        } else if (userChoice.equals("paper") && androidChoice.equals("scissors")) {
            return "Android";
        } else if (userChoice.equals("scissors") && androidChoice.equals("rock")) {
            return "Android";
        } else if (androidChoice.equals("rock") && userChoice.equals("paper")) {
            return "You";
        } else if (androidChoice.equals("paper") && userChoice.equals("scissors")) {
            return "You";
        } else if (androidChoice.equals("scissors") && userChoice.equals("rock")) {
            return "You";
        }

        return null;
    }

}
