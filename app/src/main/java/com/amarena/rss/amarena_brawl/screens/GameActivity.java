package com.amarena.rss.amarena_brawl.screens;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controllers.GameController;
import com.amarena.rss.amarena_brawl.enums.GameMode;
import com.amarena.rss.amarena_brawl.views.GameView;


public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Récupération du mode de jeu
        GameMode gameMode = (GameMode)getIntent().getSerializableExtra("gameMode");

        //On initialise le GameMode du GameControler
        GameController.getInstance().initGameMode(gameMode);

        // Recupération de la GameView
        GameView gameView = (GameView) findViewById(R.id.gameView);

        //On initialise la GameView du GameControler
        GameController.getInstance().initGameView(gameView);

        // Mise en place du fragment des attaques
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAction, new ActionFragment());
        fragmentTransaction.commit();
    }
}
