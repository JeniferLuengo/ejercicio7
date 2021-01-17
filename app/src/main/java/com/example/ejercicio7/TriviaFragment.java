package com.example.ejercicio7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.navigation.Navigation;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.ejercicio7.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {

private FragmentTriviaBinding mbinding;

    public TriviaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mbinding = FragmentTriviaBinding.inflate(inflater, container, false);
        return mbinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo);
        mbinding.tvSaludo.setText(saludo);

        mbinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int index = mbinding.radioGroup.indexOfChild(mbinding.radioGroup.findViewById(i));
                        boolean choice;
                        if (index == 2){
                            choice = true;
                            Navigation.findNavController(mbinding.getRoot()).navigate(R.id.action_triviaFragment_to_winnerFragment);
                        } else {
                            choice = false;
                            Navigation.findNavController(mbinding.getRoot()).navigate(R.id.action_triviaFragment_to_looserFragment);
                        }
                    }
        });
    }
}


   /* //TODO  crear el metodo para ir al fragmento ganador
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
}*/