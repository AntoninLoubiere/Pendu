package com.thanto.pendu;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class Save {
    /*
    Une class static pour gere les sauveguarde des meilleur score.
     */
    private static HashMap<String, Integer> listScore;
    private static int scoreCurrent = 0;

    public static void init() {
        importScore();
        Log.i("Save", listScore.toString());
        if (!listScore.containsKey("version") || listScore.get("version") != MainActivity.version) {
            listScore.put("record", 0);
            for(int i = 0; i<10; i++)
                listScore.put("scoreSur10_" + String.valueOf(i + 1), 0);
            listScore.put("version", MainActivity.version);
            exportScore();
        }

    }

    public static  int getScore(String id) {
        return listScore.get(id);
    }

    private static void saveScore(int score) {
        listScore.put("record", score);
        exportScore();
    }

    public static int createScore(int nbCoupRestant, boolean isWin) {
        if (isWin) {
            int toAdd = 0;
            switch (GameActivity.nbCoup - nbCoupRestant) {
                case 0: // 0 error
                    toAdd = 200;
                    break;

                case 1: // 1 error
                    toAdd = 100;
                    break;

                case 2: // ...
                    toAdd = 65;
                    break;

                case 3:
                    toAdd = 50;
                    break;

                case 4:
                    toAdd = 35;
                    break;

                case 5:
                    toAdd = 25;
                    break;

                case 6:
                    toAdd = 20;
                    break;

                case 7:
                    toAdd = 15;
                    break;

                case 8:
                    toAdd = 10;
                    break;

                case 9:
                    toAdd = 5;
                    break;

                default:
                    break;
            }
            scoreCurrent += toAdd;
            exportScoreIfRecored();
            return toAdd;
        } else {
            int score = scoreCurrent;
            exportScoreIfRecored();
            scoreCurrent = 0; // reset score
            return score;
        }
    }

    private static void importScore() {
        try {
            Context context = MainActivity.context;
            SharedPreferences sharedPref = context.getSharedPreferences(
                    MainActivity.resources.getString(R.string.prefKeySave), Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String jsonListScore = sharedPref.getString("listScore", "{record:0," +
                    "version:1,scoreSur10_1:0,scoreSur10_2:0,scoreSur10_3:0," +
                    "scoreSur10_4:0,scoreSur10_5:0,scoreSur10_6:0,scoreSur10_7:0,scoreSur10_8:0," +
                    "scoreSur10_9:0,scoreSur10_10:0}");
            Log.i("Json", jsonListScore);
            java.lang.reflect.Type type = new TypeToken<HashMap<String, Integer>>(){}.getType();
            listScore = gson.fromJson(jsonListScore, type);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("/!\\ ERROR /!\\", "Impossible de charger les scores");
        }

    }

    private static void exportScore() {
        Context context = MainActivity.context;
        SharedPreferences sharedPref = context.getSharedPreferences(
                MainActivity.resources.getString(R.string.prefKeySave), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String jsonListScore = gson.toJson(listScore);
        Log.i("listScore", jsonListScore);
        editor.putString("listScore", jsonListScore);
        editor.apply();
    }

    private static void exportScoreIfRecored() {
        if (scoreCurrent > getScore("record")) {
            saveScore(scoreCurrent);
            Toast.makeText(MainActivity.context, "Record battu", Toast.LENGTH_LONG).show();
        }
    }

    public static void resetScoreCurrent() {
        scoreCurrent = 0;
    }

    public static int getScoreCurrent() {
        return scoreCurrent;
    }
}
