package com.example.ejercicio7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio7.databinding.FragmentWinnerBinding;

public class WinnerFragment extends Fragment {
private FragmentWinnerBinding mbinding;


    public WinnerFragment() {
        // Required empty public constructor
    }


    public static WinnerFragment newInstance(String name) {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mbinding= FragmentWinnerBinding.inflate(inflater,container,false);
        return mbinding.getRoot();
        mbinding.btcomenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mbinding.getRoot().getViewById()).navigate(R.id.action_winnerFragment_to_triviaFragment);

            }
        });
    }
}