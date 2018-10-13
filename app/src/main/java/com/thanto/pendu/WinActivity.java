package com.thanto.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    private static String motMystere;
    private static boolean win;
    private static int numberCoupRestant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        String mot = motMystere;
        boolean isWin = win;
        int nbCoupRestant = numberCoupRestant;
        int scoreAdd = Save.createScore(nbCoupRestant, isWin);
        int score = Save.getScoreCurrent();

        TextView winOrLose = findViewById(R.id.winOrLose);
        TextView textSolution = findViewById(R.id.textSolution);
        TextView reponse = findViewById(R.id.Reponse);
        TextView textScore = findViewById(R.id.textScore);
        TextView textViewscore = findViewById(R.id.score);
        TextView textRecord = findViewById(R.id.textRecord);
        TextView record = findViewById(R.id.record);

        Button menuPrincipale = findViewById(R.id.menuPrincipale);
        Button rejouer = findViewById(R.id.rejouer);

        if (win) {
            textViewscore.setText(String.format(getResources().getString(R.string.scoreFormat), score, scoreAdd));
        } else {
            rejouer.setText(R.string.rejouer);
            winOrLose.setText(R.string.lose);
            textSolution.setText(R.string.loseTextSolutionWord);
            winOrLose.setTextColor(getResources().getColor(R.color.letterWrong));
            textSolution.setTextColor(getResources().getColor(R.color.letterWrong));
            textScore.setTextColor(getResources().getColor(R.color.letterWrong));
            textRecord.setTextColor(getResources().getColor(R.color.letterWrong));

            textViewscore.setText(String.valueOf(scoreAdd)); // score add return scoreCurrent
        }
        reponse.setText(mot);

        record.setText(String.valueOf(Save.getScore("record")));

        menuPrincipale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save.resetScoreCurrent();
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(gameActivity);
                finish();
            }
        });
    }

    public static void setVar(String motSecret, boolean tempWin, int nbCoupRestant) {
        motMystere = motSecret;
        win = tempWin;
        numberCoupRestant = nbCoupRestant;
    }
}
