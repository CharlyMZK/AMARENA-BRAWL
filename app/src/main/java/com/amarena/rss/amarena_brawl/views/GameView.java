package com.amarena.rss.amarena_brawl.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.amarena.rss.amarena_brawl.R;


/**
 * Created by Quentin on 04/12/2015.
 */
public class GameView extends View {
    Paint p;
    /**
     * Constructeur de la GameView
     *
     * @param context Contexte de la GameView
     */
    public GameView(Context context) {
        super(context);
        initPaints();
    }

    /**
     * Deuxième constructeur de la GameView
     *
     * @param context      Contexte de la GameView
     * @param attributeSet Set d'attributs
     */
    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaints();
    }

    /**
     * Permet de dessiner les éléments voulus à l'écran
     *
     * @param canvas Canvas avec tous les éléments dessus
     */
    @Override
    public void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        canvas.drawText("Some Text", 10, 25, paint);

        p=new Paint();
        Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.fond);
        b.setWidth(this.getWidth());
        b.setHeight(this.getHeight());
        p.setColor(Color.RED);


        canvas.drawBitmap(b, 0, 0, p);

    }

    /**
     * Permet de capter lorsque l'accéléromètre bouge
     */
    public SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    /**
     * Permet de détecter lorsque l'écran et appuyé
     *
     * @param event Evenement
     * @return Vrai si le traitement est bien réalisé
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }

    /**
     * Permet d'initialiser tous les paints
     */
    private void initPaints() {

    }

    /**
     * Permet d'avoir un paint blanc
     *
     * @return Paint de couleur blanche
     */
    private Paint getPaintColor() {
        Paint paint = new Paint();
        paint.setARGB(255, 255, 255, 255);
        return paint;
    }

    /**
     * Permet d'avoir un paint d'une couleur différente
     *
     * @return Paint de couleur plus foncé
     */
    private Paint changePaintColor() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0f); //enelve la couleur

        colorMatrix.set(new float[]{0, 1f, 0, 0, 0,
                0, 0, 1f, 0, 0,
                0, 0, 0, 0f, 0,
                0, 0, 0, 1f, 0});
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);
        return paint;
    }

    private Bitmap flipBitmap(Bitmap d) {
        Matrix m = new Matrix();
        m.preScale(-1, 1);
        Bitmap src = d;
        Bitmap dst = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), m, false);
        dst.setDensity(DisplayMetrics.DENSITY_DEFAULT);
        return dst;
    }
}
