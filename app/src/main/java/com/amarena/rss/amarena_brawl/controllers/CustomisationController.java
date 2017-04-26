package com.amarena.rss.amarena_brawl.controllers;

import com.amarena.rss.amarena_brawl.enums.Profession;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.screens.CustomisationActivity;
import com.orm.SugarRecord;

/**
 * Created by MZK on 26/04/2017.
 */

public class CustomisationController {
    private static CustomisationController customisationController;

    public static CustomisationController getInstance() {
        if (customisationController == null) {
            customisationController = new CustomisationController();
        }
        return customisationController;
    }


    public void changeAction(int id) {

        System.out.println("CHANGE ACTION - "+id);
        Action getAction = Action.getActionFromChosenId(id);
        Action changedAction = CustomisationActivity.getSelectedSpell();
        System.out.println("L'action 1 est : "+getAction.getName());

        if (changedAction != null){
            System.out.println("L'action selectionnée est : "+changedAction.getName());
            changedAction.setChosenId(id);
            SugarRecord.save(changedAction);
            getAction.setChosenId(0);
            SugarRecord.save(getAction);
            getAction = Action.getActionFromChosenId(id);
            System.out.println("L'action 1 est maintenant : "+getAction.getName());
        }


    }
}
