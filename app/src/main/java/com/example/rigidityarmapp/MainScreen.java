package com.example.rigidityarmapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "MainScreen";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public MainScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main_screen.
     */
    // TODO: Rename and change types and number of parameters
    public static MainScreen newInstance(String param1, String param2) {
        MainScreen fragment = new MainScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.fragment_main_screen, container, false);
        Button btnInstructor = root.findViewById(R.id.btnInstructor);
        Button btnStudent = root.findViewById(R.id.btnStudent);
        btnInstructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.MainScreen, new Instructor());
                fr.commit();
            }
        });
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.MainScreen, new Student());
                fr.commit();
            }
        });

        MainActivity mainAct = ((MainActivity) getActivity());
        Button btnONOFF = root.findViewById(R.id.btnONOFF);
        Button btnEnableDisable_Discoverable = root.findViewById(R.id.btnDiscoverable_on_off);
        ListView lvNewDevices = root.findViewById(R.id.lvNewDevices);
        ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();

        Button btnStartConnection = root.findViewById(R.id.btnStartConnection);

        //Broadcasts when bond state changes (ie:pairing)
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);

        mainAct.registerReceiver(mainAct.mBroadcastReceiver4, filter);

        mainAct.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //Need to fix this
        //lvNewDevices.setOnItemClickListener(mainAct.this);


        btnONOFF.setOnClickListener(v -> {
            Log.d(TAG, "onClick: enabling/disabling bluetooth.");
            mainAct.enableDisableBT();
        });

/*
        btnStartConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainAct.startConnection();
            }
        });

*/
        return root;
    }
}