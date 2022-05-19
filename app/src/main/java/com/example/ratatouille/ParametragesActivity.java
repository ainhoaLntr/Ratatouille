package com.example.ratatouille;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class ParametragesActivity extends AppCompatActivity {

    private Button btn_ajouterNew, btn_supprEntree, btn_supprPlat, btn_supprDessert, btn_enregistrerModif;
    private EditText et_new, et_modif;
    private RadioButton btnr_entree, btnr_plat, btnr_dessert;
    private Spinner s_entrees, s_plats, s_desserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrages);

        btn_ajouterNew = findViewById(R.id.btn_ajouterNew);
        et_new = findViewById(R.id.et_new);
        btnr_entree = findViewById(R.id.btnr_entree);
        btnr_plat = findViewById(R.id.btnr_plat);
        btnr_dessert = findViewById(R.id.btnr_dessert);
        btn_supprEntree = findViewById(R.id.btn_supprEntree);
        btn_supprPlat = findViewById(R.id.btn_supprPlat);
        btn_supprDessert = findViewById(R.id.btn_supprDessert);
        s_entrees = findViewById(R.id.s_entrees);
        s_plats = findViewById(R.id.s_plats);
        s_desserts = findViewById(R.id.s_desserts);
        et_modif = findViewById(R.id.et_modif);
        btn_enregistrerModif = findViewById(R.id.btn_enregistrerModif);

        btn_ajouterNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nouveau = et_new.getText().toString();
                Log.d("nomAjout", nouveau);
                if(btnr_entree.isChecked()) {
                    Log.d("typeAjout", btnr_entree.getText().toString());
                }
                if(btnr_plat.isChecked()) {
                    Log.d("typeAjout", btnr_plat.getText().toString());
                }
                if(btnr_dessert.isChecked()) {
                    Log.d("typeAjout", btnr_dessert.getText().toString());
                }
            }
        });

        btn_supprEntree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valeur = s_entrees.getSelectedItem().toString();
                Integer position = s_entrees.getSelectedItemPosition();
                Log.d("positionSpinner", position.toString());
                Log.d("nomSpinner", "entree");
                Log.d("valeurSpinner", valeur);
            }
        });

        btn_supprPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valeur = s_plats.getSelectedItem().toString();
                Integer position = s_plats.getSelectedItemPosition();
                Log.d("positionSpinner", position.toString());
                Log.d("nomSpinner", "plat");
                Log.d("valeurSpinner", valeur);
            }
        });

        btn_supprDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valeur = s_desserts.getSelectedItem().toString();
                Integer position = s_desserts.getSelectedItemPosition();
                Log.d("positionSpinner", position.toString());
                Log.d("nomSpinner", "dessert");
                Log.d("valeurSpinner", valeur);
            }
        });

        PlatDAO EntreePlatDAO = new PlatDAO(this);
        ArrayList<Plat> lstEntrees = EntreePlatDAO.getPlats();
        ArrayAdapter<String> adapteurEntree = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < 5; i++) {
            adapteurEntree.add(lstEntrees.get(i).getLibelleP());
        }
        s_entrees.setAdapter(adapteurEntree);

        s_entrees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(s_entrees.getSelectedItemPosition() != 0) {
                    s_plats.setSelection(0);
                    s_desserts.setSelection(0);
                    et_modif.setText(s_entrees.getSelectedItem().toString());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        PlatDAO PlatPlatDAO = new PlatDAO(this);
        ArrayList<Plat> lstPlats = PlatPlatDAO.getPlats();
        ArrayAdapter<String> adapteurPlat = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 5; i < 10; i++) {
            adapteurPlat.add(lstPlats.get(i).getLibelleP());
        }
        s_plats.setAdapter(adapteurPlat);

        s_plats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(s_plats.getSelectedItemPosition() != 0){
                    s_entrees.setSelection(0);
                    s_desserts.setSelection(0);
                    et_modif.setText(s_plats.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        PlatDAO DessertPlatDAO = new PlatDAO(this);
        ArrayList<Plat> lstDesserts = PlatPlatDAO.getPlats();
        ArrayAdapter<String> adapteurDesserts = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 10; i < 15; i++) {
            adapteurDesserts.add(lstDesserts.get(i).getLibelleP());
        }
        s_desserts.setAdapter(adapteurDesserts);

        s_desserts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(s_desserts.getSelectedItemPosition() != 0){
                    s_entrees.setSelection(0);
                    s_plats.setSelection(0);
                    et_modif.setText(s_desserts.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_enregistrerModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s_entrees.getSelectedItem().toString().equals(et_modif.getText().toString())) {
                    Log.d("res", "identique");
                }
                else {
                    Log.d("res", "modifie");
                }
                if(s_plats.getSelectedItem().toString().equals(et_modif.getText().toString())) {
                    Log.d("res", "identique");
                }
                else {
                    Log.d("res", "modifie");
                }
                if(s_desserts.getSelectedItem().toString().equals(et_modif.getText().toString())) {
                    Log.d("res", "identique");
                }
                else {
                    Log.d("res", "modifie");
                }

            }
        });
    }
}