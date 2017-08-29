package com.example.matthew.connectthree;

import android.media.Image;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int currentPlayer = 0; // 0 = yellow, 1 = red

    //2 is not played
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // set to 2 so users can't override occupied areas
    int[][] winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6}, {1,4,7},{2,5,8} ,{0,4,8} ,{2,4,6}}; //winning areas

    public void dropIn (View view){

        ImageView counter = (ImageView) view;

        int tapped = Integer.parseInt( counter.getTag().toString());

        if (gameState[tapped] == 2) {
            gameState[tapped] = currentPlayer;

            counter.setTranslationY(-1000f); //keeps images offscreen at -1000dp
            if (currentPlayer == 0) { //yellow's turn
                counter.setImageResource(R.drawable.yellow); //set image to yellow coin
                currentPlayer = 1;
            } else { //red's turn
                counter.setImageResource(R.drawable.red); //set image to red coin
                currentPlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300); //animate coins 1000dp onscreen and rotate

            for (int[] winnings : winning){
                if (gameState[winnings[0]] == gameState[winnings[1]] &&
                        gameState[winnings[1]] == gameState[winnings[2]] &&
                        gameState[winnings[0]] != 2){
                    System.out.println(gameState[winnings[0]]);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
