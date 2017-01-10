package test.getyourway;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Position {

    double x;
    double y;

    public Position (double x, double y){

        this.x = x;
        this.y = y;
    }

    public void setPosition (double x, double y){

        this.x = x;
        this.y = y;
    }

    public Object getPosition (Position p){

        return p;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}





