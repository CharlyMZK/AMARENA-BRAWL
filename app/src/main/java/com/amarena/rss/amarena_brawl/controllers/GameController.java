package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.enums.Profession;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;
import com.amarena.rss.amarena_brawl.views.GameView;

public class GameController {

    private static GameController gameController;
    private GameView gameView;

    private Character player;
    private Character enemy;

    /**
     * Constructeur privé
     */
    private GameController() {
        this.player = new Character(Profession.ARCHER);
        this.enemy = new Character(Profession.WARRIOR);
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
        player.doAction(enemy, new Action(id));
        checkGame();
        gameView.invalidate();
    }

    /**
     * Regarde quand la partie se termine
     */
    public void checkGame(){
        if(player.getLife() == 0){
            gameView.setGameFinish(true);
            gameView.setPlayerWon(false);
        }else if(enemy.getLife() == 0){
            gameView.setGameFinish(true);
            gameView.setPlayerWon(true);
        }
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

    /**
     * Permet de detruire l'instance du GameControlleur
     */
    public static void destroyInstance(){
        gameController = null;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getEnemy() {
        return enemy;
    }
}
