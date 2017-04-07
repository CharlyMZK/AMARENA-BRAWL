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
        Action rapidShot = new Action(Profession.WARRIOR, 1, ActionType.PHYSICALDAMAGE, "Rapid shot", 20, 25, 50, 10, 1, 0, 0, 0);
        Action fireShot = new Action(Profession.WARRIOR, 2, ActionType.MAGICALDAMAGE, "Fire shot", 25, 15, 100, 5, 1, 0, 0, 0);
        Action glacialShot = new Action(Profession.WARRIOR, 3, ActionType.MAGICALDAMAGE, "Glacial shot", 40, 5, 150, 25, 2, 0, 0, 0);
        Action punitiveShot = new Action(Profession.WARRIOR, 4, ActionType.PHYSICALDAMAGE, "Punitive shot", 50, 10, 175, 40, 2, 0, 0, 0);
        Action recover = new Action(Profession.WARRIOR, 5, ActionType.HEAL, "Recover", 30, 5, 50, 5, 3, 0, 0, 0);

        SugarRecord.save(rapidShot);
        SugarRecord.save(fireShot);
        SugarRecord.save(glacialShot);
        SugarRecord.save(punitiveShot);
        SugarRecord.save(recover);
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initWarriorsAttacks() {
        Action slash = new Action(Profession.WARRIOR, 1, ActionType.PHYSICALDAMAGE, "Slash", 25, 10, 50, 5, 1, 0, 0, 0);
        Action charge = new Action(Profession.WARRIOR, 2, ActionType.PHYSICALDAMAGE, "Charge", 15, 50, 100, 10, 1, 0, 0, 0);
        Action giantStrike = new Action(Profession.WARRIOR, 3, ActionType.PHYSICALDAMAGE, "Giant strike", 70, 10, 50, 50, 3, 0, 0, 0);
        Action raiseShield = new Action(Profession.WARRIOR, 4, ActionType.PHYSICALSHIELD, "Raise shield", 10, 0, 0, 0, 2, 0, 0, 0);
        Action bandage = new Action(Profession.WARRIOR, 5, ActionType.HEAL, "Bandage", 35, 5, 50, 5, 3, 0, 0, 0);

        SugarRecord.save(slash);
        SugarRecord.save(charge);
        SugarRecord.save(giantStrike);
        SugarRecord.save(raiseShield);
        SugarRecord.save(bandage);
    }

    /**
     * Crée les classes dans la base de données
     */
    private static void initWizardsAttacks() {
        Action fireOrb = new Action(Profession.WIZARD, 1, ActionType.MAGICALDAMAGE, "Fire orb", 30, 0, 0, 10, 1, 0, 0, 0);
        Action GlacialShard = new Action(Profession.WIZARD, 2, ActionType.MAGICALDAMAGE, "Glacial Shard", 20, 20, 50, 5, 1, 0, 0, 0);
        Action lightningStrike = new Action(Profession.WIZARD, 3, ActionType.MAGICALDAMAGE, "Lightning strike", 25, 10, 125, 5, 1, 0, 0, 0);
        Action magicalShield = new Action(Profession.WIZARD, 4, ActionType.MAGICALSHIELD, "Magical shield", 15, 0, 0, 10, 2, 0, 0, 0);
        Action rain = new Action(Profession.WIZARD, 5, ActionType.HEAL, "Rain", 30, 5, 50, 5, 3, 0, 0, 0);

        SugarRecord.save(fireOrb);
        SugarRecord.save(GlacialShard);
        SugarRecord.save(lightningStrike);
        SugarRecord.save(magicalShield);
        SugarRecord.save(rain);
    }
}

		
		