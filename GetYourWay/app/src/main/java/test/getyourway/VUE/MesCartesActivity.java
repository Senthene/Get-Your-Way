package test.getyourway.VUE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import test.getyourway.MODELE.Carte;
import test.getyourway.Adaptateur.MesCartesListAdaptater;
import test.getyourway.R;

public class MesCartesActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mes_cartes);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ArrayList<Carte> mesCartes;
    MesCartesListAdaptater adaptater;
    float temp = (float) 1.00;

    ListView viewListeCarte = (ListView) findViewById(R.id.MesCartes);
//        SearchView rechercherCarte = (SearchView) findViewById(R.id.recherche);
    // Button telecharger = (Button) findViewById(R.id.telecharger);


    mesCartes = new ArrayList<>();
    // Pour ajouter
    // TEST

    ArrayList<Carte> test = new ArrayList<>();
    test.add(new Carte(2,2,temp,temp, "AGORA", "EVRY", 91000, "seycha.sth@live.fr", 2,"null",2));
    test.add(new Carte(2,2,temp,temp, "IBGBI", "EVRY", 91000, "seycha.sth@live.fr", 10,"null",10));
    test.add(new Carte(2,2,temp,temp, "MAISON", "Villeneuve-Saint-Gorges", 91000, "seycha.sth@live.fr", 3,"null",3));
    test.add(new Carte(2,2,temp,temp, "Carré sénart-Saint-Gorges", "Moissy-Cramayel", 91000, "seycha.sth@live.fr", 6,"null",6));
    test.add(new Carte(2,2,temp,temp, "Bel épine", "Thiais", 91000, "seycha.sth@live.fr", 1,"null",1));
    test.add(new Carte(2,2,temp,temp, "Aeroville", "Saint-denis", 91000, "seycha.sth@live.fr", 0,"null",0));
    test.add(new Carte(2,2,temp,temp, "Créteil Soleil", "Créteil", 91000, "seycha.sth@live.fr", 2,"null",2));
    test.add(new Carte(2,2,temp,temp, "Disneyland Paris", "Paris", 91000, "seycha.sth@live.fr", 4,"null",4));
    test.add(new Carte(2,2,temp,temp, "Parc Astérix", "Paris", 91000, "seycha.sth@live.fr", 3,"null",3));

    if (test.size()==0){
      AlertDialog.Builder popupSuppression = new AlertDialog.Builder(MesCartesActivity.this);
      popupSuppression.setMessage("Vous n'avez pas de bâtiment dans votre liste. Voulez-vous en télécharger ?");
      popupSuppression.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

        public void onClick(DialogInterface dialog, int which) {
          Toast.makeText(MesCartesActivity.this, "Carte supprimé", Toast.LENGTH_SHORT).show();
          Intent afficherCarte = new Intent(MesCartesActivity.this, RechercheCarteActivity.class);
          // positionActuelle.setPosition(positionX,positionY);
          //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
          //afficherCarte.putExtra("positionX", positionX);
          startActivity(afficherCarte);
        }
      });
      popupSuppression.setNegativeButton("Non",null);

      AlertDialog alert = popupSuppression.create();
      alert.show();
    }

    adaptater = new MesCartesListAdaptater(getApplicationContext(), test);
    viewListeCarte.setAdapter(adaptater);

    viewListeCarte.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Carte sélectionnée dont l'id est " + view.getTag(), Toast.LENGTH_SHORT).show();

      }

    });

        /*Button telecharger = (Button) findViewById(R.id.telecharger);
        telecharger.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(), "Carte sélectionnée dont l'id est " + v.getTag(), Toast.LENGTH_SHORT).show();

                    }
                }
        );*/


    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.


  }


}
