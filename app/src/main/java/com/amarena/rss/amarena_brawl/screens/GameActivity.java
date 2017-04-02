package com.amarena.rss.amarena_brawl.screens;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.views.GameView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        GameView gameView = (GameView) findViewById(R.id.gameView);
        RelativeLayout fragmentSpell = (RelativeLayout) findViewById(R.id.fragmentSpell);
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentSpell, new SpellFragment());
        fragmentTransaction.commit();
    }
}
