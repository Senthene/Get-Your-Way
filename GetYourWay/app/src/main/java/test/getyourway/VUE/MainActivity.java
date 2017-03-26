package test.getyourway.VUE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Iterator;

import test.getyourway.BASE_DE_DONNEES.BDD;
import test.getyourway.MODELE.Bloc;
import test.getyourway.MODELE.Carte;
import test.getyourway.MODELE.Ligne;
import test.getyourway.MODELE.Position;
import test.getyourway.R;

// test

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button scanButton;
    private BDD MA_BD;
    private float positionX;
    private float positionY;
    private String message;
    private int Id_Carte_Choisie;
    private Position positionActuelle;
    private ArrayList<Bloc> listeBloc;
    private ArrayList<Ligne> listeLigne;
    public ArrayList<Carte> mesCartes = new ArrayList<>();
    public ArrayList<String> nomsCartes = new ArrayList<>();
    String boutonChoisir = "Choisir un bâtiment";
    String boutonChanger = "Changer de bâtiment";
    Button bouton_Test;
    ListView carteAchoisir =  null;
    private Carte carteSelectionne;
    AlertDialog ad;
    String [] nomsCartesString;

    //private String recherche;



    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MA_BD = new BDD (this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        float temp = (float) 1.00;

        scanButton = (Button) findViewById(R.id.scan);
        mesCartes.add(new Carte(1,1,temp,temp, "IBGBI", "EVRY", 91000, "seycha.sth@live.fr", 5,"null",5));
        mesCartes.add(new Carte(2,2,temp,temp, "AGORA", "EVRY", 91000, "seycha.sth@live.fr", 2,"null",2));
        mesCartes.add(new Carte(3,3,temp,temp,"MAISON", "Villeneuve-Saint-Gorges", 94190, "seycha.sth@live.fr", 3,"null",3));
        nomsCartes = conversion(mesCartes);
        carteAchoisir = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ligne_batiment_a_charger, R.id.nom, nomsCartes);
        carteAchoisir.setAdapter(adapter);



        /*carteAchoisir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg = (ViewGroup) view;
                TextView text = (TextView) vg.findViewById(R.id.nom);
                Intent telechargerCarte = new Intent(MainActivity.this, RechercheCarteActivity.class);
                // positionActuelle.setPosition(positionX,positionY);
                //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
                //afficherCarte.putExtra("positionX", positionX);
                startActivity(telechargerCarte);
                Toast.makeText(MainActivity.this, text.getText().toString(), Toast.LENGTH_LONG).show();
            }
        }); */



        // TEST
        bouton_Test = (Button) findViewById(R.id.test);
       if (carteSelectionne == null){
           bouton_Test.setText(boutonChoisir);
       }

        else bouton_Test.setText(boutonChanger);
       bouton_Test.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                    // POPUP DE CONFIRMATION
                    public void onClick(View v) {

                        nomsCartesString = conversionChar(mesCartes);

                        if (mesCartes.size()==0){
                            AlertDialog.Builder popupSuppression = new AlertDialog.Builder(MainActivity.this);
                            popupSuppression.setMessage("Vous n'avez pas de bâtiment dans votre liste. Voulez-vous en télécharger ?");
                            popupSuppression.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "Carte supprimé", Toast.LENGTH_SHORT).show();
                                    Intent afficherCarte = new Intent(MainActivity.this, RechercheCarteActivity.class);
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
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Choisissez un bâtiment");
                            builder.setItems(nomsCartesString, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Toast.makeText(MainActivity.this, "Bâtiment sélectionné "+nomsCartesString[which], Toast.LENGTH_SHORT).show();
                                    Intent afficherCarte = new Intent(MainActivity.this, RechercheCarteActivity.class);
                                    // positionActuelle.setPosition(positionX,positionY);
                                    //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
                                    //afficherCarte.putExtra("positionX", positionX);
                                    startActivity(afficherCarte);

                                }
                            });
                            builder.setNegativeButton("Annuler", null);
                            ad= builder.create();
                            ad.show();
                        }
                        /*AlertDialog.Builder popupSuppression = new AlertDialog.Builder(MainActivity.this);
                        int i = 45;
                        popupSuppression.setMessage("Etes-vous sûr de vouloir supprimer la carte du batîment "+mesCartes.size());
                        popupSuppression.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Carte supprimé", Toast.LENGTH_SHORT).show();
                               // Intent afficherCarte = new Intent(MainActivity.this, RechercheCarteActivity.class);
                                // positionActuelle.setPosition(positionX,positionY);
                                //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
                                //afficherCarte.putExtra("positionX", positionX);
                                //startActivity(afficherCarte);
                            }
                        });
                        popupSuppression.setNegativeButton("Non",null);

                        AlertDialog alert = popupSuppression.create();
                        alert.show(); */




                    }
                }


        );
        // FIN TEST
        final Activity activity = this;



        scanButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan de votre position actuelle");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }

        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  if (position == null){
                // Snackbar.make(view, "Scannez votre position", Snackbar.LENGTH_LONG).setAction("Action", null).show();} else ...
                Intent afficherCarte = new Intent(MainActivity.this, CarteActivity.class);
               // positionActuelle.setPosition(positionX,positionY);
                //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
                //afficherCarte.putExtra("positionX", positionX);
                startActivity(afficherCarte);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public String[] conversionChar(ArrayList<Carte> c){
        int arraySize = c.size();
        String temp [] = new String[arraySize];
        Iterator <Carte> res = c.iterator();
        int i = 0;
        while (i <= temp.length && res.hasNext()){

                Carte a  = res.next();

                temp[i]= a.getNom();
                i++;
        }
            return temp ;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Vous avez annulé le scan", Toast.LENGTH_LONG).show();
            } else {
               message = result.getContents().substring(0,9);
                positionX = Float.parseFloat(message);
                message = result.getContents().substring(9,18);
                positionY = Float.parseFloat(message);
                //positionX = message.substring(0, 8);
                // affichage d'un toat
                Toast.makeText(this, " X = "+ positionX +" Y=  "+positionY, Toast.LENGTH_LONG).show();

                // passage à l'écran d'affichage de la carte avec la localisation


                // ERREUR pour transférer
              /*  Intent afficherCarte = new Intent(MainActivity.this, CarteActivity.class);
                // positionActuelle.setPosition(positionX,positionY);
                //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
                afficherCarte.putExtra("positionX", positionX);
                startActivity(afficherCarte);*/
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.telechargerCarte) {
            //  if (position == null){
            // Snackbar.make(view, "Scannez votre position", Snackbar.LENGTH_LONG).setAction("Action", null).show();} else ...
            Intent telechargerCarte = new Intent(MainActivity.this, RechercheCarteActivity.class);
            // positionActuelle.setPosition(positionX,positionY);
            //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
            //afficherCarte.putExtra("positionX", positionX);
            startActivity(telechargerCarte);

        }

        if (id == R.id.afficheMesCartes) {
            //  if (position == null){
            // Snackbar.make(view, "Scannez votre position", Snackbar.LENGTH_LONG).setAction("Action", null).show();} else ...
            Intent mesCartes = new Intent(MainActivity.this, MesCartesActivity.class);
            // positionActuelle.setPosition(positionX,positionY);
            //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
            //afficherCarte.putExtra("positionX", positionX);
            startActivity(mesCartes);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_reception) {
            // Handle the camera action
            Intent afficherCarte = new Intent(MainActivity.this, SettingsActivity.class);
            positionActuelle.setPosition(positionX,positionY);
            //afficherCarte.putExtra("positionActuelle", (Parcelable) positionActuelle);
            //afficherCarte.putExtra("positionX", positionX);
            startActivity(afficherCarte);
        } else if (id == R.id.nav_toilettes) {

        } else if (id == R.id.nav_exit) {

        } else if (id == R.id.nav_changerEtage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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

    public ArrayList<String> conversion (ArrayList<Carte> c){
        ArrayList<String> noms = new ArrayList<>();
        Iterator <Carte> res = c.iterator();
        while (res.hasNext()) {
            Carte a  = res.next();
            noms.add(a.getNom());
        }
        return noms ;
    }
}
