package com.example.rigidityarmapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;

public class BluetoothConnectionService {
    private static final String TAG = "BluetoothConnectionServ";

    private static final String appName = "RIGIDITYARMAPP";

    private static final UUID MY_UUID_INSECURE = UUID.fromString("c419228b-30b0-4f51-9d46-f56348e4c830");

    private final BluetoothAdapter mBlueToothAdapter;
    Context mContext;

    private AcceptThread mInsecureAcceptThread;

    public BluetoothConnectionService(Context context) {
        mContext = context;
        mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    //Listens for incoming connections
    private class AcceptThread extends Thread {
        // Local server socket
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread() {
            BluetoothServerSocket tmp = null;

            //create new listening server socket
            try {
                tmp = mBlueToothAdapter.listenUsingInsecureRfcommWithServiceRecord(appName, MY_UUID_INSECURE);

                Log.d(TAG, "Accept Thread: Setting up Server using: " + MY_UUID_INSECURE);
            } catch (IOException e) {
                Log.e(TAG, "Accept Thread: IOException: " + e.getMessage() );
            }

            mmServerSocket = tmp;
        }

        public void run() {
            Log.d(TAG, "run: AcceptThread Running.");

            BluetoothSocket socket = null;

            try {
                //Blocking call: will only return when successful connection or exception
                Log.d(TAG, "run: RFCOM server socket start.....");

                socket = mmServerSocket.accept();

                Log.d(TAG, "run: RFCOM server socket accepted connection.");
            } catch (IOException e) {
                Log.e(TAG, "Accept Thread: IOException: " + e.getMessage() );
            }

            //look for in 3rd video
            if(socket != null) {
                //connected(socket, mmDevice);
            }

            Log.i(TAG, "END mAcceptThread");
        }

        public void cancel() {
            Log.d(TAG, "cancel: Cancelling AcceptThread");
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "cancel: Close of AcceptThread ServerSocket failed. " + e.getMessage() );
            }
        }
    }
}
