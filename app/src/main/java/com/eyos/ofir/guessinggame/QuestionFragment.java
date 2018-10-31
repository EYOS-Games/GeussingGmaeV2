package com.eyos.ofir.guessinggame;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private ImageView imageView;
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_question, container, false);
        imageView = view.findViewById(R.id.imgLogo);
        String imgUrl = getArguments().getString("message");
        GlideApp.with(getActivity())
                .load(imgUrl)

                .into(imageView);
        //imageView.setim(message);
        return view;
    }

}
