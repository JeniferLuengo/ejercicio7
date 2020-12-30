package com.example.ejercicio7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.ejercicio7.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private String name;

    private FragmentTriviaBinding mBinding;
    private boolean choice;

    public TriviaFragment() {
        // Required empty public constructor
    }

    public static TriviaFragment newInstance(String param1) {
        TriviaFragment fragment = new TriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTriviaBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo, name);
        mBinding.tvSaludo.setText(saludo);

        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = mBinding.radioGroup
                        .indexOfChild(mBinding.radioGroup.findViewById(checkedId));
                if (index == 2){
                    choice = true;
                } else {
                    choice = false;
                }
            }
        });

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice){
                    //TODO añadir el metodo que inicia el fragmento ganador y pasa el nombre
                } else {
                    //Todo añadir el metodo que inicia el fragmento perdedor y pasa el nombre
                }
            }
        });
    }

    //TODO  crear el metodo para ir al fragmento ganador


    //Todo crear el metodo para ir al fragment perdedor.

}