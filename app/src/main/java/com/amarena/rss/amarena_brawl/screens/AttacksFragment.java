package com.amarena.rss.amarena_brawl.screens;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controlers.GameControler;

public class AttacksFragment extends Fragment {
    private GameControler gameControler = GameControler.getInstance();

    public AttacksFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attacks, container, false);

        ImageButton fAIBtnAttacks1 = (ImageButton) view.findViewById(R.id.fAIBtnAttacks1);
        ImageButton fAIBtnAttacks2 = (ImageButton) view.findViewById(R.id.fAIBtnAttacks2);
        ImageButton fAIBtnAttacks3 = (ImageButton) view.findViewById(R.id.fAIBtnAttacks3);
        ImageButton fAIBtnAttacks4 = (ImageButton) view.findViewById(R.id.fAIBtnAttacks4);
        ImageButton fAIBtnAttacks5 = (ImageButton) view.findViewById(R.id.fAIBtnAttacks5);

        fAIBtnAttacks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAttack1();
            }
        });
        fAIBtnAttacks2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAttack2();
            }
        });
        fAIBtnAttacks3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAttack3();
            }
        });
        fAIBtnAttacks4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAttack4();
            }
        });
        fAIBtnAttacks5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAttack5();
            }
        });

        return view;
    }


    private void onClickAttack1(){
        gameControler.Attack();
    }

    private void onClickAttack2(){

    }

    private void onClickAttack3(){

    }

    private void onClickAttack4(){

    }

    private void onClickAttack5(){

    }

}
