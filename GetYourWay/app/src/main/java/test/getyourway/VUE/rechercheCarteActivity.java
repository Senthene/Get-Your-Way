package test.getyourway.VUE;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import test.getyourway.MODELE.Carte;
import test.getyourway.MODELE.CarteListAdaptater;
import test.getyourway.R;

public class RechercheCarteActivity extends AppCompatActivity {



      private ArrayList<Carte> listeCarte;
      CarteListAdaptater adaptater;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView viewListeCarte = (ListView) findViewById(R.id.liste_carte);
//        SearchView rechercherCarte = (SearchView) findViewById(R.id.recherche);
       // Button telecharger = (Button) findViewById(R.id.telecharger);


       listeCarte = new ArrayList<>();
        // Pour ajouter
        // TEST

        ArrayList<Carte> test = new ArrayList<>();
        test.add(new Carte(1, "IBGBI", "EVRY", 91000, "seycha.sth@live.fr", 5));
        test.add(new Carte(2, "AGORA", "EVRY", 91000, "seycha.sth@live.fr", 2));
        test.add(new Carte(3, "MAISON", "Villeneuve-Saint-Gorges", 94190, "seycha.sth@live.fr", 3));

        adaptater = new CarteListAdaptater(getApplicationContext(), test);
        viewListeCarte.setAdapter(adaptater);

        viewListeCarte.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Carte sélectionnée dont l'id est " + view.getTag(), Toast.LENGTH_SHORT).show();
                Log.e("test","Test");
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


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("RechercheCarte Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
