package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.enums.ActionType;
import com.amarena.rss.amarena_brawl.enums.Profession;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;
import com.orm.SugarRecord;

public class DataBaseLoader {

    /**
     * Permet de générer toute la base de données
     */
    public static void LoadDataBase() {
        if (SugarRecord.listAll(Character.class).size() == 0) {
            initCharacters();
            initAttacks();
        }
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initCharacters() {
        Character archer = new Character(Profession.ARCHER, 115, 7, 15, 0, 0, 0, 0);
        Character warrior = new Character(Profession.WARRIOR, 120, 6, 0, 20, 80, 0, 0);
        Character wizard = new Character(Profession.WIZARD, 105, 10, 0, 0, 0, 15, 50);

        SugarRecord.save(archer);
        SugarRecord.save(warrior);
        SugarRecord.save(wizard);
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initAttacks() {
        initArchersAttacks();
        initWarriorsAttacks();
        initWizardsAttacks();
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initArchersAttacks() {
        Action shot1 = new Action(Profession.ARCHER, 1, ActionType.PHYSICALDAMAGE, "shot", 15, 15, 15, 5, 1, 0, 0, 0); // Enum pour les types
        Action shot2 = new Action(Profession.ARCHER, 2, ActionType.PHYSICALDAMAGE, "shot1", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot3 = new Action(Profession.ARCHER, 3, ActionType.PHYSICALDAMAGE, "shot2", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot4 = new Action(Profession.ARCHER, 4, ActionType.MAGICALDAMAGE, "shot3", 30, 15, 15, 5, 1, 0, 0, 0);
        Action shot5 = new Action(Profession.ARCHER, 5, ActionType.MAGICALDAMAGE, "shot4", 300, 15, 15, 5, 1, 0, 0, 0);

        SugarRecord.save(shot1);
        SugarRecord.save(shot2);
        SugarRecord.save(shot3);
        SugarRecord.save(shot4);
        SugarRecord.save(shot5);
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initWarriorsAttacks() {
        Action shot1 = new Action(Profession.WARRIOR, 1, ActionType.PHYSICALDAMAGE, "shot5", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot2 = new Action(Profession.WARRIOR, 2, ActionType.PHYSICALDAMAGE, "shot6", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot3 = new Action(Profession.WARRIOR, 3, ActionType.PHYSICALDAMAGE, "shot7", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot4 = new Action(Profession.WARRIOR, 4, ActionType.PHYSICALDAMAGE, "shot8", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot5 = new Action(Profession.WARRIOR, 5, ActionType.PHYSICALDAMAGE, "shot9", 15, 15, 15, 5, 1, 0, 0, 0);

        SugarRecord.save(shot1);
        SugarRecord.save(shot2);
        SugarRecord.save(shot3);
        SugarRecord.save(shot4);
        SugarRecord.save(shot5);
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initWizardsAttacks() {
        Action shot1 = new Action(Profession.WIZARD, 1, ActionType.PHYSICALDAMAGE, "shot10", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot2 = new Action(Profession.WIZARD, 2, ActionType.PHYSICALDAMAGE, "shot11", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot3 = new Action(Profession.WIZARD, 3, ActionType.PHYSICALDAMAGE, "shot12", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot4 = new Action(Profession.WIZARD, 4, ActionType.PHYSICALDAMAGE, "shot13", 15, 15, 15, 5, 1, 0, 0, 0);
        Action shot5 = new Action(Profession.WIZARD, 5, ActionType.PHYSICALDAMAGE, "shot14", 15, 15, 15, 5, 1, 0, 0, 0);

        SugarRecord.save(shot1);
        SugarRecord.save(shot2);
        SugarRecord.save(shot3);
        SugarRecord.save(shot4);
        SugarRecord.save(shot5);
    }
}

		
		