package com.example.rigidityarmapp;

import android.graphics.Color;
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

    Button currBtn;

    void levelSwitch(Button toSwitchBtn, MainActivity theMainAct, int level) {
        try {
            theMainAct.send(level);
            if (currBtn != null) {
                currBtn.setBackgroundColor(Color.parseColor("#E84A27"));
            }
            currBtn = toSwitchBtn;
            currBtn.setBackgroundColor(Color.parseColor("#53DD22"));
        } catch (Exception e) {

        }
    }

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

        //Leadpipe Rigidity
        Button btnLevelL0 = root.findViewById(R.id.btnlevel0);
        Button btnLevelL1 = root.findViewById(R.id.btnlevel1);
        Button btnLevelL2 = root.findViewById(R.id.btnlevel2);
        Button btnLevelL3 = root.findViewById(R.id.btnlevel3);
        btnLevelL0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelL0, mainAct, L0);
            }
        });
        btnLevelL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelL1, mainAct, L1);
            }
        });
        btnLevelL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelL2, mainAct, L2);
            }
        });
        btnLevelL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelL3, mainAct, L3);
            }
        });

        //Cogwheel Rigidity
        Button btnLevelC0 = root.findViewById(R.id.btnlevel10);
        Button btnLevelC1 = root.findViewById(R.id.btnlevel11);
        Button btnLevelC2 = root.findViewById(R.id.btnlevel12);
        Button btnLevelC3 = root.findViewById(R.id.btnlevel13);
        btnLevelC0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelC0, mainAct, C0);
            }
        });
        btnLevelC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelC1, mainAct, C1);
            }
        });
        btnLevelC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelC2, mainAct, C2);
            }
        });
        btnLevelC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelC3, mainAct, C3);
            }
        });

        //Spasticity
        Button btnLevelS0 = root.findViewById(R.id.btnlevel20);
        Button btnLevelS1 = root.findViewById(R.id.btnlevel21);
        Button btnLevelS2 = root.findViewById(R.id.btnlevel22);
        Button btnLevelS3 = root.findViewById(R.id.btnlevel23);
        btnLevelS0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelS0, mainAct, S0);
            }
        });
        btnLevelS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelS1, mainAct, S1);
            }
        });
        btnLevelS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelS2, mainAct, S2);
            }
        });
        btnLevelS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSwitch(btnLevelS3, mainAct, S3);
            }
        });

        return root;
    }
}