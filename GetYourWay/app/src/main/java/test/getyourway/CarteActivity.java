package test.getyourway;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CarteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // ERREUR pour récupérer

       final float positionX= getIntent().getExtras().getParcelable("positionX");
        //final double positionY= getIntent().getExtras().getParcelable("positionY");
        //final Position positionActuelle = getIntent().getExtras().getParcelable("positionActuelle");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, positionX +" "+positionY, Snackbar.LENGTH_LONG)
                Snackbar.make(view, (int) positionX, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
