package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class BotController {
    private Character character;
    private static BotController instance;

    private BotController() {
        generateCharacter();
        generateCharacterActions();
    }

    /**
     * Choisi aléatoirement parmi les classes
     */
    public void generateCharacter() {
        List<Character> characters = Character.getAllCharacters();
        this.character = characters.get(ThreadLocalRandom.current().nextInt(0, characters.size()));
        this.character.setLife(this.character.getMaxLife());
        this.character.setMana(this.character.getMaxMana());
    }

    /**
     * Choisi aléatoirement 5 actions parmi celles du métier
     */
    public void generateCharacterActions() {
        List<Action> actions = Action.getAllActions();
        while (actions.size() > 5) { // On enleve les actions pour ne pas avoir de doublons
            actions.remove(ThreadLocalRandom.current().nextInt(0, actions.size()));
        }
        this.character.setActions(actions);
    }

    /**
     * Permet d'effectuer une action aléatoirement
     *
     * @param player le personnage du joueur
     */
    public void doAction(Character player) {
        character.doAction(player, character.getActions().get(ThreadLocalRandom.current().nextInt(0, character.getActions().size())));
    }

    /**
     * M�thode getInstance du singleton
     *
     * @return L'instance du BotController
     */
    public static BotController getInstance() {
        if (instance == null) {
            instance = new BotController();
        }
        return instance;
    }

    /**
     * Permet de detruire l'instance du BotController
     */
    public static void destroyInstance() {
        instance = null;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}