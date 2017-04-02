package com.amarena.rss.amarena_brawl.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.amarena.rss.amarena_brawl.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initButton();
    }

    /**
     * Permet d'initialiser les boutons
     */
    private void initButton() {
        Button btnMenuPvp = (Button) this.findViewById(R.id.btnMenuPvp);
        Button btnMenuPvb = (Button) this.findViewById(R.id.btnMenuPvb);
        Button btnMenuCustomisation = (Button) this.findViewById(R.id.btnMenuCustomisation);
        Button btnMenuSettings = (Button) this.findViewById(R.id.btnMenuSettings);

        if (btnMenuPvp != null)
            btnMenuPvp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuPvp();
                }
            });
        if (btnMenuPvb != null)
            btnMenuPvb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuPvb();
                }
            });
        if (btnMenuCustomisation != null)
            btnMenuCustomisation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuCustomisation();
                }
            });
        if (btnMenuSettings != null)
            btnMenuSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuSettings();
                }
            });
    }

    /**
     * Actions pour le bouton du menu pvp
     */
    private void onClickBtnMenuPvp() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * Actions pour le bouton du menu pvb
     */
    private void onClickBtnMenuPvb() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * Actions pour le bouton du menu de personnalisation
     */
    private void onClickBtnMenuCustomisation() {
        Intent intent = new Intent(this, CustomisationActivity.class);
        startActivity(intent);
    }

    /**
     * Actions pour le bouton du menu des paramètres
     */
    private void onClickBtnMenuSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
