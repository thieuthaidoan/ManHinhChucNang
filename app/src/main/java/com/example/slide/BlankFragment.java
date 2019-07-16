package com.example.slide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manhinhchucnang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(int args) {
        BlankFragment fragment = new BlankFragment();
        Bundle param = new Bundle();
        param.putSerializable("ANSWER", args);
        fragment.setArguments(param);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        bundle.get("ANSWER");
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
