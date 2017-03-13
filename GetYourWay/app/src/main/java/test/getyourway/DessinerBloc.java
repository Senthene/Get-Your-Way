package test.getyourway;

import android.content.Context;
import android.view.View;
import android.graphics.*;

/**
 * Created by Sénthène on 13/03/2017.
 */

public class DessinerBloc extends View {

    Bloc z;

    int a = 10;
    int b = 10;
    int c = 10;
    int d = 10;

    public DessinerBloc(Context context, int a, int b, int c, int d) {
        super(context);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;


    }

    protected void onDraw(Canvas canvas, int a, int b, int c, int d) {
        super.onDraw(canvas);
        Rect rectangle = new Rect();
        rectangle.set(a, b, c, d);
        Paint rect = new Paint();
        rect.setColor(Color.BLACK);
        rect.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectangle, rect);

    }

}
