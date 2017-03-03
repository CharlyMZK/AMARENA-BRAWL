package com.amarena.rss.amarena_brawl;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initButton();
    }

    private void initButton(){
        FancyButton btn_menu_pvp = (FancyButton) this.findViewById(R.id.btn_menu_pvp);
        btn_menu_pvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "PEDALE", Toast.LENGTH_SHORT);
            }
        });
    }
}
