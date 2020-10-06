package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    // 0 - X
    // 1 - O
    int active_player = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    // State meaning
    // 0 - X
    // 1 - O
    // 2 - Blank
    int[][] wining_pos = {{0,1,2} , {3,4,5} , {6 , 7,8} ,
            {0,3,6} , {1,4,7} , {2,5,8} ,
            {0,4,8} , {2,4 , 8}};
    public void playertap(View view){
        ImageView image = (ImageView) view;
        int tappedimage = Integer.parseInt(image.getTag().toString());
        if(!gameactive){
            MainActivity m = new MainActivity();
            m.gamereset(view);
        }
        if(gamestate[tappedimage] == 2){
            gamestate[tappedimage] = active_player;
            image.setTranslationY(-1000f);
            if(active_player==0){
                image.setImageResource(R.drawable.x);
                active_player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn tap to play");
            }
            else {
                image.setImageResource(R.drawable.o);
                active_player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn tap to play");
            }
            image.animate().translationYBy(1000f).setDuration(300);
        }
//        Check for the winning
        for(int []wins:wining_pos){
            if(gamestate[wins[0]]==gamestate[wins[1]] && gamestate[wins[1]] == gamestate[wins[2]] &&gamestate[wins[0]]!=2){
                //Some wins
                String winStr ;
                if(gamestate[wins[0]] == 0){
                    winStr = "X has won";
                }
                else{
                    winStr = "Y has won";
                }
                // Update the status
                gameactive = false;
                TextView status = findViewById(R.id.status);
                status.setText(winStr);
            }

        }

    }
    public void gamereset(View view){
        gameactive = true;
        active_player = 0;
        for(int i=0 ; i<9 ; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageview0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageview8)).setImageResource(0);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}