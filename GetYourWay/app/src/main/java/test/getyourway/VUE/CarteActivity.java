package test.getyourway.VUE;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import test.getyourway.MODELE.Ligne;
import test.getyourway.R;

public class CarteActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    DrawMap v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        v = new DrawMap(this);
        setContentView(v);
        //v.setOntouchListener(this);
        ArrayList<Ligne> listeLignes = null;

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //  public void setOntouchListener(CarteActivity; Object ontouchListener;

        //ontouchListener) {

        //// this.ontouchListener = ontouchListener;

        //}

        dessine(listeLignes);


    }




    public void dessine(ArrayList<Ligne> l) {

        ImageView img = (ImageView) findViewById(R.id.carte);
        //img.setImageBitmap(bmp);
    }

    // ERREUR pour récupérer

   /*final float positionX = getIntent().getExtras().getParcelable("positionX");
    //final double positionY= getIntent().getExtras().getParcelable("positionY");
    //final Position positionActuelle = getIntent().getExtras().getParcelable("positionActuelle");
    //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    //fab.setOnClickListener(new View.OnClickListener()

    {
    */

      /*  public void onClick (View view){
          Snackbar.make(view, positionX +" "+positionY, Snackbar.LENGTH_LONG)
        Snackbar.make(view, (int) positionX, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
    }
*/
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Carte Page") // TODO: Define a title for the content shown.
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

    public void onPause(){
        super.onPause();
        v.pause();
    }

    public void onResume(){
        super.onResume();
        v.resume();
        }


}
