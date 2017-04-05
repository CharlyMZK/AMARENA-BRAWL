package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.enums.GameMode;
import com.amarena.rss.amarena_brawl.enums.Profession;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;
import com.amarena.rss.amarena_brawl.views.GameView;

public class GameController {

    private static GameController gameController;
    private BotController botController = BotController.getInstance();
    private GameView gameView;

    private GameMode gameMode;
    private Character player;
    private Character enemy;
    private boolean playerTurn;

    /**
     * Constructeur privé
     */
    private GameController() {
        this.player = new Character(Profession.ARCHER); // Mettre le metier du joueur
    }

    /**
     * Initialisation du GameMode du GameController
     *
     * @param gameMode le mode de jeu
     */
    public void initGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        if (this.gameMode == GameMode.PVB)
            this.enemy = botController.getCharacter();
    }

    /**
     * Initialisation de la GameView du GameController
     *
     * @param gameView GameView utilisé pour le jeu
     */
    public void initGameView(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Permet d'utiliser l'action en fonction de l'id
     *
     * @param id id de l'action
     */
    public void doAction(int id) {
        player.doAction(enemy, new Action(id));
        if (gameMode == GameMode.PVB) // TODO A ENLEVER ET REMPLACER PAR LE MECANISME DE TOUR
            botController.doAction(player);
        checkGame();
        gameView.invalidate();
    }

    /**
     * Regarde quand la partie se termine
     */
    public void checkGame() {
        if (player.getLife() == 0) {
            gameView.setGameFinish(true);
            gameView.setPlayerWon(false);
        } else if (enemy.getLife() == 0) {
            gameView.setGameFinish(true);
            gameView.setPlayerWon(true);
        }
    }

    /**
     * Permet de passer au tour suivant
     */
    public void nextTurn() {
        playerTurn = !playerTurn;
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
    public static void destroyInstance() {
        gameController = null;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getEnemy() {
        return enemy;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }
}