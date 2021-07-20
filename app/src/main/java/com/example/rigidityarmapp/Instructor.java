package com.example.rigidityarmapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.nio.charset.Charset;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Instructor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Instructor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Variables of all modes + levels condition
    // Leadpipe Rigidity (1st)
    int L0 = 0;
    int L1 = 1;
    int L2 = 2;
    int L3 = 3;
    int L_end = L3 + 1;
    // Cogwheel Rigidity (2nd)
    int C0 = 0 + L_end;
    int C1 = 1 + L_end;
    int C2 = 2 + L_end;
    int C3 = 3 + L_end;
    int C_end = C3 + 1;
    // Spasticity (3rd)
    int S0 = 0 + C_end;
    int S1 = 1 + C_end;
    int S2 = 2 + C_end;
    int S3 = 3 + C_end;

    public Instructor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Instructor.
     */
    // TODO: Rename and change types and number of parameters
    public static Instructor newInstance(String param1, String param2) {
        Instructor fragment = new Instructor();
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
        // Inflate the layout for this fragment

        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.fragment_instructor, container, false);
        Button btnBackIns = root.findViewById(R.id.btnBackIns);
        btnBackIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.Instructor, new MainScreen());
                fr.commit();
            }
        });
        MainActivity mainAct = ((MainActivity) getActivity());

        Button btnLevelL0 = root.findViewById(R.id.btnlevel0);
        Button btnLevelL1 = root.findViewById(R.id.btnlevel1);
        Button btnLevelL2 = root.findViewById(R.id.btnlevel2);
        Button btnLevelL3 = root.findViewById(R.id.btnlevel3);
        btnLevelL0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAct.send(L0);
            }
        });
        btnLevelL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAct.send(L1);
            }
        });
        btnLevelL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAct.send(L2);
            }
        });
        btnLevelL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAct.send(L3);
            }
        });



        return root;
    }
}