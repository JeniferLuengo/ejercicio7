package com.example.ejercicio7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ejercicio7.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private FragmentTitleBinding mBinding;


    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance(String param1, String param2) {
        TitleFragment fragment = new TitleFragment();
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
        mBinding = FragmentTitleBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.btcomenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.editTextTextPersonName.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Debes indicar tu nombre"
                            , Toast.LENGTH_SHORT).show();
                } else {
                    addTriviaFragment(mBinding.editTextTextPersonName.getText().toString());
                }

            }
        });

    }

    private void addTriviaFragment(String name){
        //Instanciar el fragmento que vamos añadir
        TriviaFragment triviaFragment = TriviaFragment.newInstance(name);
        //Instanciar el fragment Manager
        FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
        //Instanciar la transaccion
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, triviaFragment, TriviaFragment.class.getSimpleName())
              // añadir el fragmento a la pila
                .addToBackStack(null);
        //Activiar la transacción
        transaction.commit();
    }
}