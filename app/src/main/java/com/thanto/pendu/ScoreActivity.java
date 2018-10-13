package com.thanto.pendu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Spinner listeDeroulantetext = findViewById(R.id.listeDeroulanteScore);
        Button retour = findViewById(R.id.buttonRetour);
        TextView record = findViewById(R.id.textRecordScore);
        TextView record10 = findViewById(R.id.button_l10);

        record.setText("Votre record est: " + String.valueOf(Save.getScore("record")));
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)

        List<String> liste = new ArrayList<>();
        liste.add("Assinie");
        liste.add("Bassam");
        liste.add("Abidjan");

		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                liste
        );


        /* On definit une présentation du listeDeroulantetext quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        listeDeroulantetext.setAdapter(adapter);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
