package com.amarena.rss.amarena_brawl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by jhiertz on 04/04/2017.
 */

public class ConnectThread extends Thread {

    private static  final String TAG = ConnectThread.class.getSimpleName();
    private static final String UUID = "b48ef1d6-15c4-4393-a594-d53bf9dd20bb";
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;

    public ConnectThread(String deviceAddress) {
        mmDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(deviceAddress);
        BluetoothSocket tmp = null;

        try {
            tmp = mmDevice.createRfcommSocketToServiceRecord(java.util.UUID.fromString(UUID));
        } catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }

        mmSocket = tmp;
    }

    public void run() {
        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();

        try {
           mmSocket.connect();
        } catch (IOException connectException) {
            try {
                mmSocket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }
            return;
        }

        //TODO Manage Connected socket mmSocket
    }

    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the client socket", e);
        }
    }
}
