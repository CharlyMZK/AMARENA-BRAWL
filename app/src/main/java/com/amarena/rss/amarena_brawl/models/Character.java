package com.amarena.rss.amarena_brawl.models;

import com.amarena.rss.amarena_brawl.enums.Profession;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

import java.util.ArrayList;
import java.util.List;

@Table
public class Character {

    private Long id;
    private Profession profession;
    private int maxLife;
    private int maxMana;
    private int dodgeChance;
    private int physicalShield;
    private int maxPhysicalShield;
    private int magicalShield;
    private int maxMagicalShield;

    @Ignore
    private int life;
    private int mana;
    private List<Action> actions; // Les attaques du personnages
    private List<Action> effects; // Liste des buffs et debuffs

    public Character() {
    }

    /**
     * Constructeur qui cherche un personnage dans la base de données en fonction du métier
     *
     * @param profession le métier voulu
     */
    public Character(Profession profession) {
        Character character = SugarRecord.find(Character.class, "profession = ?", profession.toString()).get(0);
        this.profession = character.getProfession();
        this.maxLife = character.getMaxLife();
        this.maxMana = character.getMaxMana();
        this.dodgeChance = character.getDodgeChance();
        this.physicalShield = character.getPhysicalShield();
        this.maxPhysicalShield = character.getMaxPhysicalShield();
        this.magicalShield = character.getMagicalShield();
        this.maxMagicalShield = character.getMaxMagicalShield();
        this.life = this.maxLife;
        this.mana = this.maxMana;
        this.actions = SugarRecord.find(Action.class, "profession = ? and chosen_id  > 0", this.profession.toString()); // On cherche les attacques définies dnas la bases
        this.effects = new ArrayList<>(); // pas de buff ni de debuff au debut
    }

    public Character(Profession profession, int maxLife, int maxMana, int dodgeChance, int physicalShield, int maxPhysicalShield, int magicalShield, int maxMagicalShield) {
        this.profession = profession;
        this.maxLife = maxLife;
        this.maxMana = maxMana;
        this.dodgeChance = dodgeChance;
        this.physicalShield = physicalShield;
        this.maxPhysicalShield = maxPhysicalShield;
        this.magicalShield = magicalShield;
        this.maxMagicalShield = maxMagicalShield;
    }

    /**
     * Permet de réaliser l'action
     *
     * @param character le personnage potentiellement attaqué
     * @param action    l'action utilisé
     */
    public void doAction(Character character, Action action) {
        int number = action.generateAttack();

        switch (action.getActionType()) {
            case PHYSICALDAMAGE:
                if (character.getPhysicalShield() - number >= 0) // On retire du bouclier
                    character.setPhysicalShield(character.getPhysicalShield() - number);
                else {
                    character.setPhysicalShield(0);
                    number = number - character.getPhysicalShield();
                    loseLife(character, number);
                }
                break;
            case MAGICALDAMAGE:
                if (character.getMagicalShield() - number >= 0) // On retire le bouclier
                    character.setMagicalShield(character.getMagicalShield() - number);
                else {
                    character.setMagicalShield(0);
                    number = number - character.getMagicalShield();
                    loseLife(character, number);
                }
                break;
            case HEAL:
                if (this.life + number < this.maxLife)
                    this.life += number;
                else
                    this.life = this.maxLife;
                break;
            case PHYSICALSHIELD:
                if (this.physicalShield + number < this.maxPhysicalShield)
                    this.physicalShield += number;
                else
                    this.physicalShield = this.maxPhysicalShield;
                break;
            case MAGICALSHIELD:
                if (this.magicalShield + number < this.maxMagicalShield)
                    this.magicalShield += number;
                else
                    this.magicalShield = this.maxMagicalShield;
                break;
        }
    }

    /**
     * Permet d'enlever le nombre de point de vie à un personnage
     *
     * @param character Le personnage qui perds de la vie
     * @param number    le nombre de point de vie à retirer
     */
    private void loseLife(Character character, int number) {
        if (character.getLife() - number > 0)
            character.setLife(character.getLife() - number);
        else
            character.setLife(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public int getPhysicalShield() {
        return physicalShield;
    }

    public void setPhysicalShield(int physicalShield) {
        this.physicalShield = physicalShield;
    }

    public int getMaxPhysicalShield() {
        return maxPhysicalShield;
    }

    public void setMaxPhysicalShield(int maxPhysicalShield) {
        this.maxPhysicalShield = maxPhysicalShield;
    }

    public int getMagicalShield() {
        return magicalShield;
    }

    public void setMagicalShield(int magicalShield) {
        this.magicalShield = magicalShield;
    }

    public int getMaxMagicalShield() {
        return maxMagicalShield;
    }

    public void setMaxMagicalShield(int maxMagicalShield) {
        this.maxMagicalShield = maxMagicalShield;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Action> getEffects() {
        return effects;
    }

    public void setEffects(List<Action> effects) {
        this.effects = effects;
    }
}