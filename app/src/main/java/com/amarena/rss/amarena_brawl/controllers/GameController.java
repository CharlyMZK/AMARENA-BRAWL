package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.models.Character;
import com.amarena.rss.amarena_brawl.models.Warrior;
import com.amarena.rss.amarena_brawl.models.Wizard;
import com.amarena.rss.amarena_brawl.views.GameView;

public class GameController {

    private static GameController gameController;
    private GameView gameView;

    private Character player;
    private Character ennemy;

    /**
     * Constructeur privé
     */
    private GameController() {
        this.player = new Warrior(100, 100, 20);
        this.ennemy = new Wizard(100, 100, 10);
    }

    /**
     * Initialisation du gameController
     *
     * @param gameView GameView utilisé pour le jeu
     */
    public void initGameControler(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Permet d'attaquer
     */
    public void Attack() {
        ennemy.setCurrentLifePoints(ennemy.getCurrentLifePoints() - 10);
        gameView.invalidate();
    }

    /**
     * Méthode getInstace du singleton
     *
     * @return L'instance du GameController
     */
    public static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getEnnemy() {
        return ennemy;
    }
}
