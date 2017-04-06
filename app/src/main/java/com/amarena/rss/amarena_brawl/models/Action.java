package com.amarena.rss.amarena_brawl.models;

import com.amarena.rss.amarena_brawl.enums.ActionType;
import com.amarena.rss.amarena_brawl.enums.Profession;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Table
public class Action {

    private Long id;
    private Profession profession; // Le métier auquel appartient l'attque
    private int chosenId; // 0 si pas choisi, 1 à 5 (dans l'ordre) si choisi
    private ActionType actionType; // Degats, soins, hot, dot ...
    private String name;
    private int number; // Nombre de dégats, nombre de point de vie soigné
    private int criticalMultiplicator;
    private int criticalChance;
    private int failChance;
    private int manaCost;
    private int effectAttack; // Nombre d'attaques qui dure l'effet
    private int effectTurn; // Nombre de tours que dure l'effet
    private int maxReloadTurn;

    @Ignore
    private int reloadTurn; // Nombre de tour pour recharge l'attaque

    public Action() {
    }

    /**
     * Constructeur d'une action en fonction de l'id
     *
     * @param chosenId id de l'action voulu
     */
    public Action(int chosenId) {
        Action action = SugarRecord.find(Action.class, "chosen_id = ?", Integer.toString(chosenId)).get(0);
        this.profession = action.getProfession();
        this.chosenId = action.getChosenId();
        this.actionType = action.getActionType();
        this.name = action.getName();
        this.number = action.getNumber();
        this.criticalMultiplicator = action.getCriticalMultiplicator();
        this.criticalChance = action.getCriticalChance();
        this.failChance = action.getFailChance();
        this.manaCost = action.getManaCost();
        this.effectAttack = action.getEffectAttack();
        this.effectTurn = action.getEffectTurn();
        this.maxReloadTurn = action.getMaxReloadTurn();
        this.reloadTurn = 0;
    }

    public Action(Profession profession, int chosenId, ActionType actionType, String name, int number, int criticalMultiplicator, int criticalChance, int failChance, int manaCost, int effectAttack, int effectTurn, int maxReloadTurn) {
        this.profession = profession;
        this.chosenId = chosenId;
        this.actionType = actionType;
        this.name = name;
        this.number = number;
        this.criticalMultiplicator = criticalMultiplicator;
        this.criticalChance = criticalChance;
        this.failChance = failChance;
        this.manaCost = manaCost;
        this.effectAttack = effectAttack;
        this.effectTurn = effectTurn;
        this.maxReloadTurn = maxReloadTurn;
    }

    /**
     * Permet de générer le nombre de l'attack en fonctions du taux de critique ...
     *
     * @return int le nombre
     */
    public int generateAttack() {
        int number = this.number;
        int critcalRandom = ThreadLocalRandom.current().nextInt(0, 101);
        int failRandom = ThreadLocalRandom.current().nextInt(0, 101);

        if (criticalChance > critcalRandom)
            number *= (1 + (this.criticalMultiplicator / 100)); // pour faire * 1.15 par exemple
        if (failChance > failRandom)
            number = 0;

        return number;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        Action action;

        if (object instanceof Action) {
            action = (Action) object;
            if (name.equals(action.getName()))
                equals = true;
        }

        return equals;
    }

    /**
     * Permet d'avoir la liste de toutes les actions d'un m�tier
     *
     * @retrun la liste de toutes les actions en base
     */
    public static List<Action> getAllActions() {
        return SugarRecord.listAll(Action.class);
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

    public int getChosenId() {
        return chosenId;
    }

    public void setChosenId(int chosenId) {
        this.chosenId = chosenId;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCriticalMultiplicator() {
        return criticalMultiplicator;
    }

    public void setCriticalMultiplicator(int criticalMultiplicator) {
        this.criticalMultiplicator = criticalMultiplicator;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int getFailChance() {
        return failChance;
    }

    public void setFailChance(int failChance) {
        this.failChance = failChance;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getEffectAttack() {
        return effectAttack;
    }

    public void setEffectAttack(int effectAttack) {
        this.effectAttack = effectAttack;
    }

    public int getEffectTurn() {
        return effectTurn;
    }

    public void setEffectTurn(int effectTurn) {
        this.effectTurn = effectTurn;
    }

    public int getReloadTurn() {
        return reloadTurn;
    }

    public void setReloadTurn(int reloadTurn) {
        this.reloadTurn = reloadTurn;
    }

    public int getMaxReloadTurn() {
        return maxReloadTurn;
    }

    public void setMaxReloadTurn(int maxReloadTurn) {
        this.maxReloadTurn = maxReloadTurn;
    }
}