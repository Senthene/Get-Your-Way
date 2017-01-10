package test.getyourway;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
import java.util.Iterator;

public class CarteActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<Ligne> listeLignes = null;
        float pX = (float)2000.0000;
        float pY = (float) 2000.0000;
        DrawView drawView;
        Position positionActuelle  = new Position(pX, pY);

        Ligne a = new Ligne(1861.7032f, 2242.0091f, 1926.8037f, 2242.0091f);
        listeLignes.add(a);

        Ligne b = new Ligne(1861.7032f, 2297.7476f, 1861.7032f, 2242.0091f);
        listeLignes.add(b);

        Ligne c = new Ligne(1549.9740f, 2348.9019f, 1615.0745f, 2348.9019f);
        listeLignes.add(c);

        Ligne d = new Ligne(1615.0745f, 2348.9019f, 1615.0745f, 2404.6404f);
        listeLignes.add(d);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        

        dessine(listeLignes);


    }


    
    public void dessine(ArrayList<Ligne> l) {
        Paint paint = new Paint();
        Paint p = new Paint();
        float pX = (float)2000.0000;
        float pY = (float) 2000.0000;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL_AND_STROKE);

        Bitmap bmp = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas (bmp);

        Iterator it = l.iterator();

//récupération de l'itérateur

        while (it.hasNext()) {

            Ligne courant;
            courant = (Ligne) it.next();
            canvas.drawLine(courant.getDepartX(), courant.getDepartY(), courant.getFinX(), courant.getFinY(), paint);

// itération de la liste

            //récupération de l'objet se trouvant à l'index courant de la liste
        }
        float x;
        float y;
        x = (float)pX;
        y = (float)pY;
        canvas.drawPoint(x,y,paint);
        ImageView img = (ImageView) findViewById(R.id.carte);
        img.setImageBitmap(bmp);
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
}
