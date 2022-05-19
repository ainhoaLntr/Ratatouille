package com.example.ratatouille;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class GestEntrees extends AppCompatActivity {

    private LinearLayout ll_listeCheckbox;
    private Button btn_suppr, btn_ajouter;
    private EditText et_nouveau;
    private ArrayList<CheckBox> listeCheck;
    private Spinner s_entrees;
    private EditText et_entreeAModif;
    private Button btn_modif;

    public void afficherCheck() {
        ll_listeCheckbox.clearFocus();
        listeCheck.clear();
        for (int i = 0; i < Modele.lesEntrees.size(); i++) {
            CheckBox check = new CheckBox(getApplicationContext());
            check.setText(Modele.lesEntrees.get(i));
            listeCheck.add(check);
            ll_listeCheckbox.addView(check);
        }
    }

    public void remplirSpinEntrees() {
        ArrayAdapter<String> listeDesserts = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < Modele.lesEntrees.size(); i++) {
            listeDesserts.add(Modele.lesEntrees.get(i));
        }
        s_entrees.setAdapter(listeDesserts);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest_entrees);

        ll_listeCheckbox = findViewById(R.id.ll_listeCheckbox);
        btn_suppr = findViewById(R.id.btn_suppr);
        btn_ajouter = findViewById(R.id.btn_ajouter);
        et_nouveau = findViewById(R.id.et_nouveau);
        s_entrees = findViewById(R.id.s_entrees);
        et_entreeAModif = findViewById(R.id.et_entreeAModif);
        btn_modif = findViewById(R.id.btn_modif);

        Modele.initEntrees();
        afficherCheck();
        remplirSpinEntrees();

        btn_suppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = listeCheck.size(); i >= 0; i--) {
                    /*if (listeCheck.indexOf(i))
                    {
                        remove (Modele.lesPlats.get(i));
                    }*/
                }
                afficherCheck();
            }
        });

        btn_modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mettre à jour le plat modifié dans le modèle
            }
        });
    }
}