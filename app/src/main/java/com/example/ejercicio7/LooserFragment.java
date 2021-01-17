package com.example.ejercicio7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio7.databinding.FragmentLooserBinding;


public class LooserFragment extends Fragment {
private FragmentLooserBinding mbinding;

    public LooserFragment() {
        // Required empty public constructor
    }

    public static LooserFragment newInstance(String name) {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mbinding = FragmentLooserBinding .inflate(inflater,container,false);
        return mbinding.getRoot();

        mbinding.btcomenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mbinding.getRoot().getViewById()).navigate(R.id.action_looserFragment_to_triviaFragment);

            }
        });
    }
}