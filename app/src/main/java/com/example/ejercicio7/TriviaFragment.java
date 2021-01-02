package com.example.ejercicio7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

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
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
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
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int index = mBinding.radioGroup.indexOfChild(mBinding.radioGroup.findViewById(i));
                        if (index == 2){
                            choice = true;
                            WinnerFragment(name);
                        } else {
                            choice = false;
                            LooserFragment(name);
                        }
                    }
        });
    }

    //TODO  crear el metodo para ir al fragmento ganador
    private void WinnerFragment(String name) {
        //Instanciar el fragmento que vamos añadir
        WinnerFragment winnerFragment = WinnerFragment.newInstance(" name");
        //Instanciar el fragment Manager
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //Instanciar la transaccion
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, winnerFragment, TriviaFragment.class.getSimpleName())
                // añadir el fragmento a la pila
                .addToBackStack(null);
        //Activiar la transacción
        transaction.commit();
    }

    //Todo crear el metodo para ir al fragment perdedor.
        private void LooserFragment(String name){
            //Instanciar el fragmento que vamos añadir
            LooserFragment looserFragment = com.example.ejercicio7.LooserFragment.newInstance("name");
            //Instanciar el fragment Manager
            FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
            //Instanciar la transaccion
            FragmentTransaction transaction1 = supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, looserFragment, TriviaFragment.class.getSimpleName())
                    // añadir el fragmento a la pila
                    .addToBackStack(null);
            //Activiar la transacción
            transaction1.commit();
        }
}