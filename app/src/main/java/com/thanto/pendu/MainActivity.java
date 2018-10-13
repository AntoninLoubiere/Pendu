package com.thanto.pendu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static Context context;
    public static Resources resources;
    public static int version = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        resources = getResources();
        Save.init();


        Button play = findViewById(R.id.play);
        Button stat = findViewById(R.id.buttonStat);
        TextView recordText = findViewById(R.id.RecordTextView);

        recordText.setText(String.valueOf("Record: " + Save.getScore("record")));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        // création d'un dialog

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialogDeveloppementTitre)
                .setMessage(R.string.dialogDeveloppementText)
                .setCancelable(false)
                .setPositiveButton("OK", null);

        final Dialog alert = builder.create();

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
                //Intent otherActivity = new Intent(getApplicationContext(), ScoreActivity.class);
                //startActivity(otherActivity);
            }
        });
    }
}
