package test.getyourway.VUE;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.*;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import test.getyourway.MODELE.Position;
import test.getyourway.R;


/**
 * Created by Sénthène on 10/01/2017.
 */

public class DrawMap extends SurfaceView implements Runnable {



    Thread t = null;
    SurfaceHolder holder;
    boolean isItOk = false;
    Bitmap moi;
    float pX = 0;
    float pY = 0;
    Position positionActuelle  = new Position(pX, pY);




    public DrawMap (Context context) {
        super (context);
        holder = getHolder();


    }

    public void run() {
        moi = BitmapFactory.decodeResource(getResources(), R.drawable.smiley);
        while (isItOk == true) {
            if (!holder.getSurface().isValid()){
                continue;
            }



            Canvas c = holder.lockCanvas();

            c.drawARGB(255,150,150,10);

            c.drawBitmap(moi,positionActuelle.getX(), positionActuelle.getY(),null);

            ///////////////

            Rect rectangle = new Rect();
            rectangle.set(100, 200, 250, 150);
            Paint rect = new Paint();
            rect.setTextSize(40);
            rect.setColor(Color.BLACK);
            rect.setStyle(Paint.Style.FILL);
            c.drawText("Ma premiere salle", 20,30,rect);
            c.drawRect(rectangle, rect);
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

    public void resume() {
        isItOk = true;
        t = new Thread(this);
        t.start();
    }
}