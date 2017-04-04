package com.amarena.rss.amarena_brawl.screens;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controllers.GameController;
import com.amarena.rss.amarena_brawl.views.GameView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Recupération de la GameView
        GameView gameView = (GameView) findViewById(R.id.gameView);

        //On initialise le gameControler
        GameController.getInstance().initGameControler(gameView);

        // Mise en place du fragment des attaques
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAttacks, new ActionFragment());
        fragmentTransaction.commit();
    }
}
