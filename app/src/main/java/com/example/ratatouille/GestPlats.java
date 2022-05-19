package com.example.ratatouille;

import static android.system.Os.remove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class GestPlats extends AppCompatActivity {

    private LinearLayout ll_listeCheckbox;
    private Button btn_suppr, btn_ajouter;
    private EditText et_nouveau;
    private ArrayList<CheckBox> listeCheck;
    private Spinner s_plats;
    private EditText et_platAModif;
    private Button btn_modif;

    public void afficherCheck() {
        ll_listeCheckbox.clearFocus();
        listeCheck.clear();
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            CheckBox check = new CheckBox(getApplicationContext());
            check.setText(Modele.lesPlats.get(i));
            listeCheck.add(check);
            ll_listeCheckbox.addView(check);
        }
    }

    public void remplirSpinPlats() {
        ArrayAdapter<String> listePlats = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            listePlats.add(Modele.lesPlats.get(i));
        }
        s_plats.setAdapter(listePlats);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest_plats);

        ll_listeCheckbox = findViewById(R.id.ll_listeCheckbox);
        btn_suppr = findViewById(R.id.btn_suppr);
        btn_ajouter = findViewById(R.id.btn_ajouter);
        et_nouveau = findViewById(R.id.et_nouveau);
        s_plats = findViewById(R.id.s_plats);
        et_platAModif = findViewById(R.id.et_platAModif);
        btn_modif = findViewById(R.id.btn_modif);

        Modele.initPlats();
        afficherCheck();
        remplirSpinPlats();

        btn_suppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = listeCheck.size(); i >=0; i--)
                {
                    /*if ()
                    {
                        try {
                            remove (Modele.lesPlats.get(i));
                        } catch (ErrnoException e) {
                            e.printStackTrace();
                        }
                    }*/
                }
                afficherCheck();
            }
        });

        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modele.lesPlats.add(et_platAModif.toString());
                et_platAModif.setText("");
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
