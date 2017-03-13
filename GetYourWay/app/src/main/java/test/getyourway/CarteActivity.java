package test.getyourway;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class CarteActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Bitmap moi;
    OurView v;
    float pX = 0;
    float pY = 0;
    Position positionActuelle  = new Position(pX, pY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        v = new OurView(this);
        setContentView(v);
        //v.setOntouchListener(this);
        ArrayList<Ligne> listeLignes = null;

        DrawView drawView;


        moi = BitmapFactory.decodeResource(getResources(), R.drawable.smiley);


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();



  /*  protected void onDraw (int a, int b, int c, int d){

        Rect rectangle = new Rect();
        rectangle.set(a, b, c, d);
        Paint rect = new Paint();
        rect.setColor(Color.BLACK);
        rect.setStyle(Paint.Style.FILL);
        v.drawRect (rectangle, rect);

    }*/


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





    public class OurView extends SurfaceView implements Runnable {

    Thread t = null;
    SurfaceHolder holder;
    boolean isItOk = false;

    public OurView (Context context) {
        super (context);
        holder = getHolder();


    }

    public void run() {
        while (isItOk == true) {
            if (!holder.getSurface().isValid()){
                continue;
            }

            Canvas c = holder.lockCanvas();
            c.drawARGB(255,150,150,10);

            c.drawBitmap(moi,positionActuelle.getX(), positionActuelle.getY(),null);
            holder.unlockCanvasAndPost(c);
        }


    }

    public void pause(){
        isItOk = false;
        while(true){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }

    public void resume(){
        isItOk = true;
        t = new Thread(this);
        t.start();
    }


    }

}
