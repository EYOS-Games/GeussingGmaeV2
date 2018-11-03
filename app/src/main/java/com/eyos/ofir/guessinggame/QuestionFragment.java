package com.eyos.ofir.guessinggame;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.eyos.ofir.guessinggame.Adapter.GridViewAnswerAdapter;
import com.eyos.ofir.guessinggame.Adapter.GridViewSuggestAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private ImageView imageView;

    private GridViewAnswerAdapter answerAdapter;
    private GridViewSuggestAdapter suggestAdapter;
    private Button btnSubmit;
    private GridView gridViewAnswer, gridViewSuggest;
    private List<String> suggestSource;
    private char[] answer;


    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        imageView = view.findViewById(R.id.imgLogo);
        String imgUrl = getArguments().getString("message");
        GlideApp.with(getActivity())
                .load(imgUrl)
                .into(imageView);
        initGridView(view);
        return view;
    }

    private void initGridView(View view) {
        gridViewAnswer = view.findViewById(R.id.gridViewAnswer);
        gridViewSuggest = view.findViewById(R.id.gridViewSuggest);
    }


    private char[] setUpNullList() {
        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }


}
