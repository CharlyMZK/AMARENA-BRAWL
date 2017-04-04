package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.enums.Profession;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;
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
        this.player = new Character(Profession.ARCHER);
        this.ennemy = new Character(Profession.WARRIOR);
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
     * Permet d'utiliser l'action en fonction de l'id
     *
     * @param id id de l'action
     */
    public void doAction(int id) {
        player.doAction(ennemy, new Action(id));
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
