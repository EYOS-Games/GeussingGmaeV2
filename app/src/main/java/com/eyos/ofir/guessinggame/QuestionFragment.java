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
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;

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
      //  String imgUrl = getArguments().getString("message");
        SelectQuestion selectQuestion = getArguments().getParcelable("message");
        String imgUrl = selectQuestion.getSelectQuestionImgUrl();
        String correctAnswer = selectQuestion.getSelectQuestionAnswer();

        GlideApp.with(getActivity())
                .load(imgUrl)
                .into(imageView);
        initGridView(view, correctAnswer);
        return view;
    }

    private void initGridView(View view, String correctAnswer) {
        gridViewAnswer = view.findViewById(R.id.gridViewAnswer);
        gridViewSuggest = view.findViewById(R.id.gridViewSuggest);

        // setUpList();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                for (int i = 0; i < Common.user_submit_answer.length; i++)
                    result += String.valueOf(Common.user_submit_answer[i]);
                if(result.equals(correctAnswer)){

                }

            }
        });
    }


    private char[] setUpNullList() {
        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }


}
