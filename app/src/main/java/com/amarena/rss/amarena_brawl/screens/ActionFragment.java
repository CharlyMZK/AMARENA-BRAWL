package com.amarena.rss.amarena_brawl.screens;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controllers.GameController;

public class ActionFragment extends Fragment {
    private GameController gameController = GameController.getInstance();

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

        ImageButton fAIBtnAction1 = (ImageButton) view.findViewById(R.id.fAIBtnAction1);
        ImageButton fAIBtnAction2 = (ImageButton) view.findViewById(R.id.fAIBtnAction2);
        ImageButton fAIBtnAction3 = (ImageButton) view.findViewById(R.id.fAIBtnAction3);
        ImageButton fAIBtnAction4 = (ImageButton) view.findViewById(R.id.fAIBtnAction4);
        ImageButton fAIBtnAction5 = (ImageButton) view.findViewById(R.id.fAIBtnAction5);

        fAIBtnAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction1();
            }
        });
        fAIBtnAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction2();
            }
        });
        fAIBtnAction3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction3();
            }
        });
        fAIBtnAction4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction4();
            }
        });
        fAIBtnAction5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction5();
            }
        });

        return view;
    }


    private void onClickAction1() {
        gameController.doAction(1);
    }

    private void onClickAction2() {
        gameController.doAction(2);
    }

    private void onClickAction3() {
        gameController.doAction(3);
    }

    private void onClickAction4() {
        gameController.doAction(4);
    }

    private void onClickAction5() {
        gameController.doAction(5);
    }

}
