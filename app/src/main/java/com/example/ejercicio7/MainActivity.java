package com.example.ejercicio7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ejercicio7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addTitleFragment();
    }

    private void addTitleFragment(){
        //Instanciar el fragmento que vamos añadir
        TitleFragment titleFragment = TitleFragment.newInstance("", "");
        //Instanciar el fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Instanciar la transaccion
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .add(binding.fragment.getId(), titleFragment,
                        TitleFragment.class.getSimpleName());
        //Activiar la transacción
        transaction.commit();
    }
}