package com.example.slide;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.manhinhchucnang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    private PagerAdapter pagerAdapter;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    public static ScreenSlidePageFragment newInstance(int args) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle param = new Bundle();
        param.putSerializable("ANSWER", args);
        fragment.setArguments(param);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_silder, container, false);
        return rootView;
    }

    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

    //check right ans
//    private void getCheckAns(String ans){
//        if(ans.equals("A")==true){
//            radA.setBackgroundColor(Color.RED);
//        }
//        else if(ans.equals("B")==true){
//            radB.setBackgroundColor(Color.RED);
//        }else if(ans.equals("C")==true){
//            radC.setBackgroundColor(Color.RED);
//        }else if(ans.equals("D")==true){
//            radD.setBackgroundColor(Color.RED);
//        }else ;
//    }


}
