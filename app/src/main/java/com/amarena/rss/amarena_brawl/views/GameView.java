package com.amarena.rss.amarena_brawl.views;

import android.app.Activity;
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

    private boolean gameFinish = false;
    private boolean playerWon = false;

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
        if (!gameFinish) { // Tant que la partie n'est pas fini
            drawBackground(canvas);
            drawBars(canvas);
        } else { // Quand la partie est finie
            ((Activity) getContext()).findViewById(R.id.fragmentAction).setVisibility(View.GONE);
            if (playerWon)
                drawWin(canvas);
            else
                drawLose(canvas);
        }
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
        float startWidthBarPlayer = 0.6f;
        float endWidthBarPlayer = 0.9f;
        float startHeightBarPlayerLife = 0.84f;
        float endHeightBarPlayerLife = 0.86f;
        float startHeightBarPlayerMana = 0.87f;
        float endHeightBarPlayerMana = 0.89f;

        float startWidthBarEnemy = 0.1f;
        float endWidthBarEnemy = 0.4f;
        float startHeightBarEnemyLife = 0.14f;
        float endHeightBarEnemyLife = 0.16f;
        float startHeightBarEnemyMana = 0.17f;
        float endHeightBarEnemyMana = 0.19f;

        Character player = gameController.getPlayer();
        float playerLifeMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((player.getMaxLife() - player.getLife()) / (float) player.getMaxLife());
        float playerManaMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((player.getMaxMana() - player.getMana()) / (float) player.getMaxMana());
        float playerPhysicalShieldMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((player.getMaxPhysicalShield() - player.getPhysicalShield()) / (float) player.getMaxPhysicalShield());
        float playerMagicalShieldMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((player.getMaxMagicalShield() - player.getMagicalShield()) / (float) player.getMaxMagicalShield());

        Character enemy = gameController.getEnemy();
        float enemyLifeMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((enemy.getMaxLife() - enemy.getLife()) / (float) enemy.getMaxLife());
        float enemyManaMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((enemy.getMaxMana() - enemy.getMana()) / (float) enemy.getMaxMana());
        float enemyPhysicalShieldMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((enemy.getMaxPhysicalShield() - enemy.getPhysicalShield()) / (float) enemy.getMaxPhysicalShield());
        float enemyMagicalShieldMultiplicator = this.getWidth() * (endWidthBarPlayer - startWidthBarPlayer) * ((enemy.getMaxMagicalShield() - enemy.getMagicalShield()) / (float) enemy.getMaxMagicalShield());

        // Cadre vie
        paint.reset();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerLife, this.getWidth() * endWidthBarPlayer, this.getHeight() * endHeightBarPlayerLife, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyLife, this.getWidth() * endWidthBarEnemy, this.getHeight() * endHeightBarEnemyLife, paint); // Ennemie
        // Cadre mana
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerMana, this.getWidth() * endWidthBarPlayer, this.getHeight() * endHeightBarPlayerMana, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyMana, this.getWidth() * endWidthBarEnemy, this.getHeight() * endHeightBarEnemyMana, paint); // Ennemie

        // vie
        paint.reset();
        paint.setColor(Color.RED);
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerLife, this.getWidth() * endWidthBarPlayer - playerLifeMultiplicator, this.getHeight() * endHeightBarPlayerLife, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyLife, this.getWidth() * endWidthBarEnemy - enemyLifeMultiplicator, this.getHeight() * endHeightBarEnemyLife, paint);// Ennemie

        // mana
        paint.setColor(Color.BLUE);
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerMana, this.getWidth() * endWidthBarPlayer - playerManaMultiplicator, this.getHeight() * endHeightBarPlayerMana, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyMana, this.getWidth() * endWidthBarEnemy - enemyManaMultiplicator, this.getHeight() * endHeightBarEnemyMana, paint);// Ennemie

        // bouclier physique
        paint.setColor(Color.GRAY);
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerLife, this.getWidth() * endWidthBarPlayer - playerPhysicalShieldMultiplicator, this.getHeight() * 0.85f, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyLife, this.getWidth() * endWidthBarEnemy - enemyPhysicalShieldMultiplicator, this.getHeight() * 0.15f, paint);// Ennemie

        // bouclier magique
        paint.setColor(Color.CYAN);
        canvas.drawRect(this.getWidth() * startWidthBarPlayer, this.getHeight() * startHeightBarPlayerLife, this.getWidth() * endWidthBarPlayer - playerMagicalShieldMultiplicator, this.getHeight() * 0.85f, paint); // Joueur
        canvas.drawRect(this.getWidth() * startWidthBarEnemy, this.getHeight() * startHeightBarEnemyLife, this.getWidth() * endWidthBarEnemy - enemyMagicalShieldMultiplicator, this.getHeight() * 0.15f, paint);// Ennemie
    }

    private void drawWin(Canvas canvas) {
        paint.reset();
        paint.setColor(Color.GREEN);
        paint.setTextSize(200f);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getResources().getText(R.string.cGWin).toString(), this.getWidth() / 2, this.getHeight() / 2, paint);
    }

    private void drawLose(Canvas canvas) {
        paint.reset();
        paint.setColor(Color.RED);
        paint.setTextSize(200f);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getResources().getText(R.string.cGLose).toString(), this.getWidth() / 2, this.getHeight() / 2, paint);
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

    public boolean isGameFinish() {
        return gameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        this.gameFinish = gameFinish;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }
}