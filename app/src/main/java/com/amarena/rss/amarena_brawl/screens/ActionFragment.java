package com.amarena.rss.amarena_brawl.screens;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controllers.GameController;
import com.amarena.rss.amarena_brawl.models.Action;

import java.util.ArrayList;
import java.util.List;

public class ActionFragment extends Fragment {
    private GameController gameController = GameController.getInstance();
    private List<Action> usableAction;
    private List<Button> actionButtons;

    private Button fABtnAction1;
    private Button fABtnAction2;
    private Button fABtnAction3;
    private Button fABtnAction4;
    private Button fABtnAction5;

    public ActionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action, container, false);

        fABtnAction1 = (Button) view.findViewById(R.id.fABtnAction1);
        fABtnAction2 = (Button) view.findViewById(R.id.fABtnAction2);
        fABtnAction3 = (Button) view.findViewById(R.id.fABtnAction3);
        fABtnAction4 = (Button) view.findViewById(R.id.fABtnAction4);
        fABtnAction5 = (Button) view.findViewById(R.id.fABtnAction5);

        actionButtons = new ArrayList<>();
        actionButtons.add(fABtnAction1);
        actionButtons.add(fABtnAction2);
        actionButtons.add(fABtnAction3);
        actionButtons.add(fABtnAction4);
        actionButtons.add(fABtnAction5);

        if (((Activity) container.getContext()).getClass() == GameActivity.class) {
            fABtnAction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickActionGameActivity(1);
                }
            });
            fABtnAction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickActionGameActivity(2);
                }
            });
            fABtnAction3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickActionGameActivity(3);
                }
            });
            fABtnAction4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickActionGameActivity(4);
                }
            });
            fABtnAction5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickActionGameActivity(5);
                }
            });
        } else if (((Activity) container.getContext()).getClass() == CustomisationActivity.class) {
            // TODO A METTRE ICI CHARLY ! :)
        }
        return view;
    }

    /**
     * Lors du clic sur une action dont le numéro est renseigné
     *
     * @param number Le numéro de l'action
     */
    private void onClickActionGameActivity(int number) {
        switch (number) {
            case 1:
                gameController.doAction(1);
                break;
            case 2:
                gameController.doAction(2);
                break;
            case 3:
                gameController.doAction(3);
                break;
            case 4:
                gameController.doAction(4);
                break;
            case 5:
                gameController.doAction(5);
                break;
        }
        refreshButtonsGameActivity(); // Met a jour les bouttons
    }

    /**
     * Permet d'actualisé les bouttons en mettant un filtre et le nombre de tours restants
     */
    private void refreshButtonsGameActivity() {
        List<Integer> idButtons = new ArrayList<>();
        int counter = 0;

        usableAction = gameController.getPlayer().getUsableActions();

        for (Action action : usableAction) { // Récupére les id des buttons qui sont utilisables
            idButtons.add(action.getChosenId());
        }

        for (Button actionButton : actionButtons) {
            if (idButtons.contains(counter)) { // Si le bouton est bon
                actionButton.getBackground().setColorFilter(null);
            } else {
                actionButton.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.DARKEN); // Met un filtre foncé sur l'image
                if (gameController.getPlayer().getActions().get(counter).getReloadTurn() > 0) { // Si ce n'est pas un problème de mana
                    actionButton.setTextSize(30f);
                    actionButton.setText(gameController.getPlayer().getActions().get(counter).getReloadTurn()); // Ecrit le nombre de tours restants
                } else { // Si c'est juste un probleme de mana, ne mets pas le nombre de tours restants
                    actionButton.setText("");
                }
            }
            counter++;
        }
    }

}