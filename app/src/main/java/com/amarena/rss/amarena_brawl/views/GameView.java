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
import com.amarena.rss.amarena_brawl.controllers.GameController;
import com.amarena.rss.amarena_brawl.models.Character;

public class GameView extends View {

    private GameController gameController = GameController.getInstance();
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
        drawBars(canvas);
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
     * @param canvas Le canvas a utiliser
     */
    private void drawBars(Canvas canvas) {
        Character player = gameController.getPlayer();
        float playerLifeMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((player.getMaxLife() - player.getLife()) / (float) player.getMaxLife());
        float playerManaMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((player.getMaxMana() - player.getMana()) / (float) player.getMaxMana());
        float playerPhysicalShieldMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((player.getMaxPhysicalShield() - player.getPhysicalShield()) / (float) player.getMaxPhysicalShield());
        float playerMagicalShieldMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((player.getMaxMagicalShield() - player.getMagicalShield()) / (float) player.getMaxMagicalShield());

        Character ennemy = gameController.getEnnemy();
        float ennemyLifeMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((ennemy.getMaxLife() - ennemy.getLife()) / (float) ennemy.getMaxLife());
        float ennemyManaMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((ennemy.getMaxMana() - ennemy.getMana()) / (float) ennemy.getMaxMana());
        float ennemyPhysicalShieldMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((ennemy.getMaxPhysicalShield() - ennemy.getPhysicalShield()) / (float) ennemy.getMaxPhysicalShield());
        float ennemyMagicalShieldMultiplicator = this.getWidth() * (0.9f - 0.6f) * ((ennemy.getMaxMagicalShield() - ennemy.getMagicalShield()) / (float) ennemy.getMaxMagicalShield());

        // Cadre vie
        paint.reset();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f, this.getHeight() * 0.86f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f, this.getHeight() * 0.16f, paint); // Ennemie
        // Cadre mana
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.87f, this.getWidth() * 0.9f, this.getHeight() * 0.89f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.17f, this.getWidth() * 0.4f, this.getHeight() * 0.19f, paint); // Ennemie

        // vie
        paint.reset();
        paint.setColor(Color.RED);
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f - playerLifeMultiplicator, this.getHeight() * 0.86f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f - ennemyLifeMultiplicator, this.getHeight() * 0.16f, paint);// Ennemie

        // mana
        paint.setColor(Color.BLUE);
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.87f, this.getWidth() * 0.9f - playerManaMultiplicator, this.getHeight() * 0.89f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.17f, this.getWidth() * 0.4f - ennemyManaMultiplicator, this.getHeight() * 0.19f, paint);// Ennemie

        // bouclier physique
        paint.setColor(Color.GRAY);
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f - playerPhysicalShieldMultiplicator, this.getHeight() * 0.85f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f - ennemyPhysicalShieldMultiplicator, this.getHeight() * 0.15f, paint);// Ennemie

        // bouclier magique
        paint.setColor(Color.CYAN);
        canvas.drawRect(this.getWidth() * 0.6f, this.getHeight() * 0.84f, this.getWidth() * 0.9f - playerMagicalShieldMultiplicator, this.getHeight() * 0.85f, paint); // Joueur
        canvas.drawRect(this.getWidth() * 0.1f, this.getHeight() * 0.14f, this.getWidth() * 0.4f - ennemyMagicalShieldMultiplicator, this.getHeight() * 0.15f, paint);// Ennemie
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
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

}