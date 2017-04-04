package com.amarena.rss.amarena_brawl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by jhiertz on 04/04/2017.
 */

public class ServerThread extends Thread {

    private final String TAG = ServerThread.class.getSimpleName();
    private static final String UUID = "b48ef1d6-15c4-4393-a594-d53bf9dd20bb";
    private static final String NAME = "AMARENA-BRAWL";
    private final BluetoothServerSocket mmServerSocket;

    public ServerThread() {

        BluetoothServerSocket tmp = null;

        try {
            tmp = BluetoothAdapter.getDefaultAdapter().listenUsingRfcommWithServiceRecord(NAME, java.util.UUID.fromString(UUID));
        } catch (IOException e) {
            Log.e(TAG, "Socket's listen() method failed", e);
        }

        mmServerSocket = tmp;
    }

    @Override
    public void run() {
        BluetoothSocket socket = null;
        Log.d(TAG, "run: Server bluetooth listening...");
        while (true) {

            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                Log.e(TAG, "Socket's accept() method failed", e);
                break;
            }

            if(socket != null) {
                // TODO Manage the socket in a separate thread

                try {
                    mmServerSocket.close();
                } catch (IOException e) {
                    Log.e(TAG, "Socket's close() method failed", e);
                }

                break;
            }
        }
    }

    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the connect socket", e);
        }
    }
}
