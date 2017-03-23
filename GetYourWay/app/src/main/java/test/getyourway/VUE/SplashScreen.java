package test.getyourway.VUE;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import test.getyourway.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
       // ActionBar actionBar = getActionBar();
        //actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ecranAccueil = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ecranAccueil);
                overridePendingTransition(R.xml.fade_in, R.xml.fade_out);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
