package com.amarena.rss.amarena_brawl.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.amarena.rss.amarena_brawl.R;
/*import com.amarena.rss.amarena_brawl.controlers.GameControler;*/
import com.amarena.rss.amarena_brawl.models.Character;

public class GameView extends View {

   // private GameControler gameControler = GameControler.getInstance();
    private Paint paint;

    /**
     * Constructeur
     *
     * @param context Contexte de la GameView
     */
    public GameView(Context context) {
        super(context);
        init();
    }

    /**
     * Constructeur
     *
     * @param context      Contexte de la GameView
     * @param attributeSet Set d'attributs
     */
    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /**
     * Permet d'initialiser le paint
     */
    private void init() {
        paint = new Paint();
    }

    /**
     * Permet de dessiner les éléments voulus à l'écran
     *
     * @param canvas Canvas avec tous les éléments dessus
     */
    @Override
    public void onDraw(Canvas canvas) {
        drawBackground(canvas);
        //drawBars(canvas, gameControler.getPlayer(), true);
        //drawBars(canvas, gameControler.getEnnemy(), false);
    }

    /**
     * Permet de dessiner le fond
     *
     * @param canvas Le canvas a utiliser
     */
    private void drawBackground(Canvas canvas) {
        Bitmap background = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.background);
        canvas.drawBitmap(reziseBitmap(background, this.getWidth(), this.getHeight()), 0, 0, null);
    }


    /**
     * Permet de dessiner la vie d'une personnage, avec son bouclier et sa mana
     *
     * @param canvas    Le canvas a utiliser
     * @param character Le personnage a actualiser
     * @param player    true si c'est le personnage du joueur
     */
    private void drawBars(Canvas canvas, Character character, boolean player) {
        float characterLifeMultiplicator = (this.getWidth() * 0.9f - this.getWidth() * 0.6f) * (((float)character.getMaxLifePoints() - (float)character.getCurrentLifePoints()) / (float)character.getMaxLifePoints());
        paint.reset();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        if (player)
            canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f, this.getHeight() * 0.86f, paint);
        else
            canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f, this.getHeight() * 0.16f, paint);
        // vie
        paint.reset();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        if (player)
            canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f - characterLifeMultiplicator, this.getHeight() * 0.86f, paint);
        else
            canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f - characterLifeMultiplicator, this.getHeight() * 0.16f, paint);
        // mana

        // bouclier Magique

        // bouclier physique
    }

    /**
     * Permet de redimensionner une image plus facilement
     *
     * @param bitmap La bitmap a redimensionner
     * @param width  La largeur
     * @param height La hauter
     * @return La bitmap redimensionne
     */
    private Bitmap reziseBitmap(Bitmap bitmap, int width, int height) {
        return Bitmap.createScaledBitmap(bitmap, this.getWidth(), this.getHeight(), true);
    }

}
