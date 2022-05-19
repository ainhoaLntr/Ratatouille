package com.example.ratatouille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Spinner s_entrees, s_plats, s_desserts, s_quantite;
    private EditText et_quantite, et_remarques;
    private TextView tv_recap;
    private Button btn_ajouter, btn_enregistrer, btn_annuler, btn_gestPlats;
    private Modele monModele;
    private int ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_entrees = findViewById(R.id.s_entrees);
        s_plats = findViewById(R.id.s_plats);
        s_desserts = findViewById(R.id.s_desserts);
        s_quantite = findViewById(R.id.s_quantite);
        et_quantite = findViewById(R.id.et_quantite);
        et_remarques = findViewById(R.id.et_remarques);
        tv_recap = findViewById(R.id.tv_recap);
        btn_ajouter = findViewById(R.id.btn_ajouter);
        btn_enregistrer = findViewById(R.id.btn_enregistrer);
        btn_annuler = findViewById(R.id.btn_annuler);
        btn_gestPlats = findViewById(R.id.btn_gestPlats);

        s_quantite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et_quantite.setText(((TextView)view).getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        et_quantite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s_quantite.setEnabled(false);
                s_quantite.setClickable(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("")) {
                    s_quantite.setEnabled(true);
                    s_quantite.setClickable(true);
                }
            }
        });

        // méthode d'affichage de la liste d'entrées
        Modele.initEntrees();
        ArrayAdapter<String> listeEntrees = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < Modele.lesEntrees.size(); i++) {
            listeEntrees.add(Modele.lesEntrees.get(i));
        }
        s_entrees.setAdapter(listeEntrees);

        // méthode d'affichage de la liste des plats
        Modele.initPlats();
        ArrayAdapter<String> listePlats = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < Modele.lesPlats.size(); i++) {
            listePlats.add(Modele.lesPlats.get(i));
        }
        s_plats.setAdapter(listePlats);

        // méthode d'affichage de la liste des desserts
        Modele.initDesserts();
        ArrayAdapter<String> listeDesserts = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < Modele.lesDesserts.size(); i++) {
            listeDesserts.add(Modele.lesDesserts.get(i));
        }
        s_desserts.setAdapter(listeDesserts);

        btn_gestPlats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGP = new Intent(getApplicationContext(), GestPlats.class);
                startActivity(intentGP);
            }
        });
        // récupération indice dernière commande créée
        //ind = monModele.newCommande();

        // bouton ajouter
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Modele.lesCommandes.get(ind).getLesEntrees().containsKey(s_entrees.getSelectedItem().toString()))
                {
                    int quantiteEntree = Modele.lesCommandes.get(ind).getLesEntrees().get(s_entrees.getSelectedItem().toString()) + Integer.parseInt(et_quantite.getText().toString());
                    Modele.lesCommandes.get(ind).getLesEntrees().remove(s_entrees.getSelectedItem().toString());
                    Modele.lesCommandes.get(ind).getLesEntrees().put(s_entrees.getSelectedItem().toString(),quantiteEntree);
                }
                else
                {
                    Modele.lesCommandes.get(ind).getLesEntrees().put(s_entrees.getSelectedItem().toString(), Integer.valueOf(et_quantite.getText().toString()));
                }

                if(Modele.lesCommandes.get(ind).getLesPlats().containsKey(s_plats.getSelectedItem().toString()))
                {
                    int quantitePlat = Modele.lesCommandes.get(ind).getLesPlats().get(s_plats.getSelectedItem().toString()) + Integer.parseInt(et_quantite.getText().toString());
                    Modele.lesCommandes.get(ind).getLesPlats().remove(s_plats.getSelectedItem().toString());
                    Modele.lesCommandes.get(ind).getLesPlats().put(s_plats.getSelectedItem().toString(), quantitePlat);
                }
                else
                {
                    Modele.lesCommandes.get(ind).getLesPlats().put(s_plats.getSelectedItem().toString(), Integer.parseInt(et_quantite.getText().toString()));
                }

                if(Modele.lesCommandes.get(ind).getLesDesserts().containsKey(s_desserts.getSelectedItem().toString()))
                {
                    int quantiteDessert = Modele.lesCommandes.get(ind).getLesDesserts().get(s_desserts.getSelectedItem().toString()) + Integer.parseInt(et_quantite.getText().toString());
                    Modele.lesCommandes.get(ind).getLesDesserts().remove(s_desserts.getSelectedItem().toString());
                    Modele.lesCommandes.get(ind).getLesDesserts().put(s_desserts.getSelectedItem().toString(),quantiteDessert);
                }
                else
                {
                    Modele.lesCommandes.get(ind).getLesDesserts().put(s_desserts.getSelectedItem().toString(), Integer.parseInt(et_quantite.getText().toString()));
                }

                //Modele.lesCommandes.get(ind).initRemarques();
                tv_recap.setText(Modele.lesCommandes.get(ind).getRemarques());
            }

            /*public boolean onCreateOptionsMenu(Menu menu)
            {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return super.onCreateOptionsMenu(menu);
            }

            public boolean onOptionsItemSelected(@NonNull MenuItem item)
            {
                Intent intent;
                switch (item.getItemId())
                {
                    case R.id.entrees:
                        intent = new Intent(getApplicationContext(), GestEntrees.class);
                        startActivity(intent);
                        break;
                    case R.id.plats:
                        intent = new Intent(getApplicationContext(), GestPlats.class);
                        startActivity(intent);
                        break;
                    case R.id.desserts:
                        intent = new Intent(getApplicationContext(), GestDesserts.class);
                        startActivity(intent);
                        break;
                }
                return super.onOptionsItemSelected(item);
            }*/

            public void afficherCommande() {
                //Commande laCommande = monModele.getLesCommandes().get(ind);

                //Set clesEntrees = laCommande.getLesEntrees().keySet();
                //Iterator itrEntrees = clesEntrees.iterator();
                //String cleEntree="";
                //while (itrEntrees.hasNext()) {
                //    cleEntree = (String)itrEntrees.next();
                //    System.out.println("cle :" + cleEntree + " & valeur : " + laCommande.getLesEntrees().get(cleEntree));
                //}

                //Set clesPlats = laCommande.getLesPlats().keySet();
                //Iterator itrPlats = clesPlats.iterator();
                //String clePlat="";
                //while (itrPlats.hasNext()) {
                //    clePlat = (String)itrPlats.next();
                //    System.out.println("cle :" + clePlat + " & valeur : " + laCommande.getLesPlats().get(clePlat));
                //}

                //Set clesDesserts = laCommande.getLesDesserts().keySet();
                //Iterator itrDesserts = clesDesserts.iterator();
                //String cleDessert="";
                //while (itrDesserts.hasNext()) {
                //    cleDessert = (String)itrDesserts.next();
                //    System.out.println("cle :" + cleDessert + " & valeur : " + laCommande.getLesDesserts().get(cleDessert));
                //}
            }
        });
    }
}