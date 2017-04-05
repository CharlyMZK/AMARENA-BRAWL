package com.amarena.rss.amarena_brawl.screens;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.controllers.BotController;
import com.amarena.rss.amarena_brawl.controllers.DataBaseLoader;
import com.amarena.rss.amarena_brawl.controllers.GameController;
import com.amarena.rss.amarena_brawl.enums.GameMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MenuActivity extends Activity {

    private static final String TAG = MenuActivity.class.getCanonicalName();
    private static final int REQUEST_ENABLE_BT = 1;
    private ListView listView = null;
    private HashMap<Integer, String> bluetoothDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DataBaseLoader.LoadDataBase(); // Mise en place de la base de données si elle n'existe pas

        initButton();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        GameController.destroyInstance(); // Permet de détruire la partie quand on reviens sur le menu
        BotController.destroyInstance();
    }

    /**
     * Permet d'initialiser les boutons
     */
    private void initButton() {
        Button aMBtnPvp = (Button) findViewById(R.id.aMBtnPvp);
        Button aMBtnPvb = (Button) findViewById(R.id.aMBtnPvb);
        Button aMBtnCustomisation = (Button) findViewById(R.id.aMBtnCustomisation);
        Button aMBtnSettings = (Button) findViewById(R.id.aMBtnSettings);

        if (aMBtnPvp != null)
            aMBtnPvp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuPvp();
                }
            });
        if (aMBtnPvb != null)
            aMBtnPvb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuPvb();
                }
            });
        if (aMBtnCustomisation != null)
            aMBtnCustomisation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnMenuCustomisation();
                }
            });
        if (aMBtnSettings != null)
            aMBtnSettings.setOnClickListener(new View.OnClickListener() {
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
        if (!isBluetoothEnable()) {
            Log.d(TAG, "onClickBtnMenuPvb: Bluetooth disable !");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("gameMode", GameMode.PVP);
            showBluetoothDialog();
            //startActivity(intent);
        }

    }

    /**
     * Actions pour le bouton du menu pvb
     */
    private void onClickBtnMenuPvb() {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("gameMode", GameMode.PVB);
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

    private boolean isBluetoothEnable() {
        return BluetoothAdapter.getDefaultAdapter() != null && BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    private void showBluetoothDialog() {

        listView = new ListView(this);
        ArrayList<String> items = new ArrayList<>();
        bluetoothDevices = new HashMap<>();

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        final Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        int i = 0;
        for (BluetoothDevice device : pairedDevices) {
            items.add(device.getName());
            bluetoothDevices.put(i, device.getAddress());
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtListBluetooth, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + bluetoothDevices.get(i));
                //TODO Pair with this device
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Choose your adversary");
        builder.setNegativeButton("Cancel", null);
        builder.setView(listView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
