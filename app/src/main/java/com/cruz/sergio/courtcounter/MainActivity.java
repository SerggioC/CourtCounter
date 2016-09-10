package com.cruz.sergio.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Integer> score = new HashMap<String, Integer>();

    public void mapa() {
        score.put("A", 0);
        score.put("B", 0);
    }

    @SuppressWarnings("unchecked")          // **** general                       ****
    public <T extends View> T $(int id) {   // ****         function              ****
        return (T) findViewById(id);        // ****                  findViewById ****
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapa();
    }


    public void countScore(View view) {

        String btnIdString = String.valueOf(getResources().getResourceEntryName(view.getId())); // get the ID name of the clicked button in string, A1, A2, A3, B1, B2, B3
        int val = Integer.parseInt(btnIdString.substring(1)); // => 1, 2, 3..
        int scoreId = getResources().getIdentifier("contagem" + btnIdString.substring(0, 1), "id", getPackageName());
        TextView contagemX = $(scoreId);
        score.put(btnIdString.substring(0, 1), score.get(btnIdString.substring(0, 1)) + val);
        contagemX.setText(score.get(btnIdString.substring(0, 1)) + "");

//        TextView gameText = (TextView) findViewById(R.id.game); //***debug lines
//        gameText.setText("btnIdString = " + btnIdString + "val = " + val + "scoreId (A/B) = " + scoreId); //***debug lines

    }

    public void resetAll(View view) {
        TextView contagemA = $(R.id.contagemA);
        contagemA.setText("0");
        score.put("A", 0);
        TextView contagemB = $(R.id.contagemB);
        contagemB.setText("0");
        score.put("B", 0);
    }

}
