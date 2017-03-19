package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Position {

    float x;
    float y;

    public Position (float x, float y){

        this.x = x;
        this.y = y;
    }

    public void setPosition (float x, float y){

        this.x = x;
        this.y = y;
    }

    public Object getPosition (Position p){

        return p;
    }
    public float getX(){
        return x;
    }
    public float getY(){

        return y;
    }
}





