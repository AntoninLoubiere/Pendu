package com.thanto.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    public static int nbCoup = 10;
    private TextView text;
    private String motMystere = null;
    private Button[] listButton = new Button[26];
    private TextView coupRestant;

    private String toShow;
    char[] motTrouvee;
    int nbCoupRestant;
    int nbLettreRestante;
    private ArrayList<Character> listCharClick = new ArrayList<>();

    private boolean chronoIsStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text = findViewById(R.id.MotSecret);
        coupRestant = findViewById(R.id.coupRestant);


        // méthode des boutons

        listButton[0] = findViewById(R.id.button_l1);
        listButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre1), 0);
            }
        });

        listButton[1] = findViewById(R.id.button_l2);
        listButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre2), 1);
            }
        });

        listButton[2] = findViewById(R.id.button_l3);
        listButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre3), 2);
            }
        });

        listButton[3] = findViewById(R.id.button_l4);
        listButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre4), 3);
            }
        });

        listButton[4] = findViewById(R.id.button_l5);
        listButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre5), 4);
            }
        });

        listButton[5] = findViewById(R.id.button_l6);
        listButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre6), 5);
            }
        });

        listButton[6] = findViewById(R.id.button_l7);
        listButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre7), 6);
            }
        });

        listButton[7] = findViewById(R.id.button_l8);
        listButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre8), 7);
            }
        });

        listButton[8] = findViewById(R.id.button_l9);
        listButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre9), 8);
            }
        });

        listButton[9] = findViewById(R.id.button_l10);
        listButton[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre10), 9);
            }
        });

        listButton[10] = findViewById(R.id.button_l11);
        listButton[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre11), 10);
            }
        });

        listButton[11] = findViewById(R.id.button_l12);
        listButton[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre12), 11);
            }
        });

        listButton[12] = findViewById(R.id.button_l13);
        listButton[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre13), 12);
            }
        });

        listButton[13] = findViewById(R.id.button_l14);
        listButton[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre14), 13);
            }
        });

        listButton[14] = findViewById(R.id.button_l15);
        listButton[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre15), 14);
            }
        });

        listButton[15] = findViewById(R.id.button_l16);
        listButton[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre16), 15);
            }
        });

        listButton[16] = findViewById(R.id.button_l17);
        listButton[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre17), 16);
            }
        });

        listButton[17] = findViewById(R.id.button_l18);
        listButton[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre18), 17);
            }
        });

        listButton[18] = findViewById(R.id.button_l19);
        listButton[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre19), 18);
            }
        });

        listButton[19] = findViewById(R.id.button_l20);
        listButton[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre20), 19);
            }
        });

        listButton[20] = findViewById(R.id.button_l21);
        listButton[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre21), 20);
            }
        });

        listButton[21] = findViewById(R.id.button_l22);
        listButton[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre22), 21);
            }
        });

        listButton[22] = findViewById(R.id.button_l23);
        listButton[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre23), 22);
            }
        });

        listButton[23] = findViewById(R.id.button_l24);
        listButton[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre24), 23);
            }
        });

        listButton[24] = findViewById(R.id.button_l25);
        listButton[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre25), 24);
            }
        });

        listButton[25] = findViewById(R.id.button_l26);
        listButton[25].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCharactere(getString(R.string.lettre26), 25);
            }
        });

        play();


    }

    public void play() {
        if (motMystere == null) {
            String motChoisis;
            InputStreamReader ISR = new InputStreamReader(getResources().openRawResource(R.raw.french));
            LineNumberReader LNR = new LineNumberReader(ISR);
            String line;
            nbLettreRestante = 0;
            nbCoupRestant = nbCoup;
            try {
                // choix de l'index aleatoire
                Random randomGenerator = new Random();
                int nombreChoisis = randomGenerator.nextInt(19846);

                // lecture du mot           @SuppressWarnings()

                for (int skipLine = 0; skipLine < nombreChoisis; skipLine++)
                    LNR.readLine();
                line = LNR.readLine();
                /*
                for(int index = 0; index < 19651; index++) {
                    line = LNR.readLine();
                    Log.i("Ligne reader", String.valueOf(index+1) + " -> " + line);
                }*/

                Log.d("Play", "La valeur de line est: " + line + " et la valeur du nombre choisis est: " + String.valueOf(nombreChoisis));

                motChoisis = line;


                this.motMystere = motChoisis;

                this.motTrouvee = new char[this.motMystere.length()];

                for (int y = 0; y < this.motMystere.length(); y++) {
                    if (motMystere.toCharArray()[y] == '-') {
                        this.motTrouvee[y] = '-';
                    } else {
                        nbLettreRestante++;
                        this.motTrouvee[y] = '\u2022';
                    }
                }
                LNR.close();
                ISR.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        this.text.setText(new String(motTrouvee));
        toShow = String.valueOf(nbCoupRestant) + " erreurs restantes";
        this.coupRestant.setText(toShow);
    }

    private void getCharactere(String string, int id) {
        char chara = string.toCharArray()[0];
        boolean findChar = false;
        if (!listCharClick.contains(chara)) {
            listCharClick.add(chara);
            for (int i = 0; i < motMystere.length(); i++) {
                if (chara == motMystere.toCharArray()[i]) {
                    motTrouvee[i] = chara;
                    findChar = true;
                    nbLettreRestante--;
                }
            }
            if (findChar) {
                listButton[id].setBackgroundColor(getResources().getColor(R.color.letterTrue));
            } else {
                listButton[id].setBackgroundColor(getResources().getColor(R.color.letterWrong));
                nbCoupRestant--;
            }

        }
        text.setText(new String(motTrouvee));
        toShow = String.valueOf(nbCoupRestant) + " erreurs restantes";
        this.coupRestant.setText(toShow);
        if (nbLettreRestante == 0) {
            win();
        } else if (nbCoupRestant == 0) {
            lose();
        }

        if (!chronoIsStart) {
            chronoIsStart = true;
        }

    }

    private void win() {
        WinActivity.setVar(motMystere, true, nbCoupRestant);
        Intent otherActivity = new Intent(getApplicationContext(), WinActivity.class);
        startActivity(otherActivity);
        finish();
    }

    private void lose() {
        WinActivity.setVar(motMystere, false, nbCoupRestant);
        Intent otherActivity = new Intent(getApplicationContext(), WinActivity.class);
        startActivity(otherActivity);
        finish();
    }

}

