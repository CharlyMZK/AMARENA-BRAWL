package com.amarena.rss.amarena_brawl.screens;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.amarena.rss.amarena_brawl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = MenuActivity.class.getCanonicalName();
    private static final int REQUEST_ENABLE_BT = 1;
    private ListView listView = null;
    private HashMap<Integer, String> bluetoothDevices;

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
        if(!isBluetoothEnable()) {
            Log.d(TAG, "onClickBtnMenuPvb: Bluetooth disable !");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }else {
            Intent intent = new Intent(this, GameActivity.class);
            showBluetoothDialog();
            //startActivity(intent);
        }

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
        for(BluetoothDevice device : pairedDevices) {
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
