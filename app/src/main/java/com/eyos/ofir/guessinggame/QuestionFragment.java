package com.eyos.ofir.guessinggame;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eyos.ofir.guessinggame.Adapter.GridViewAnswerAdapter;
import com.eyos.ofir.guessinggame.Adapter.GridViewSuggestAdapter;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private ImageView imageView;

    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;
    private Button btnSubmit;
    public GridView gridViewAnswer, gridViewSuggest;
    public List<String> suggestSource, answerSource;

    private String correctAnswer;
    public char[] correctAnswerCharArr;
    private OnButtonClickListener mOnButtonClickListener;
    private QuestionFragment questionFragment;

    private boolean fragmentResume = false;
    private boolean fragmentVisible = false;
    private boolean fragmentOnCreated = false;

    private View view;

    public QuestionFragment() {
        // Required empty public constructor
    }

    interface OnButtonClickListener {
        void onButtonClicked(View view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        super.onAttach(context);
        try {
            mOnButtonClickListener = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " must implement OnButtonClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
           view = inflater.inflate(R.layout.fragment_question, container, false);


            updateUI(view);
      //  }


        return view;
    }




    private void updateUI(View view) {
        imageView = view.findViewById(R.id.imgLogo);
        gridViewAnswer = view.findViewById(R.id.gridViewAnswer);
        gridViewSuggest = view.findViewById(R.id.gridViewSuggest);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        questionFragment = this;
        suggestSource = new ArrayList<>();

        //  String imgUrl = getArguments().getString("message");
        SelectQuestion selectQuestion = getArguments().getParcelable("message");
        String imgUrl = selectQuestion.getSelectQuestionImgUrl();
        correctAnswer = selectQuestion.getSelectQuestionAnswer();
        correctAnswerCharArr = correctAnswer.toCharArray();

        GlideApp.with(getActivity())
                .load(imgUrl)
                .into(imageView);

        if ((!fragmentResume && fragmentVisible )||  fragmentResume) {   //only when first time fragment is created
            initGridView(correctAnswer);
        }

    }



    @Override
    public void setUserVisibleHint(boolean visible) {
        super.setUserVisibleHint(visible);
        if (visible && isResumed()) {   // only at fragment screen is resumed
            fragmentResume = true;
            fragmentVisible = false;
            fragmentOnCreated = true;
            updateUI(view);
        } else if (visible) {        // only at fragment onCreated
            fragmentResume = false;
            fragmentVisible = true;
            fragmentOnCreated = true;
        } else if (!visible && fragmentOnCreated) {// only when you go out of fragment screen
            fragmentVisible = false;
            fragmentResume = false;
        }
    }



    private void initGridView(String correctAnswer) {


        setupList();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = "";
                for (int i = 0; i < Common.user_submit_answer.length; i++)
                    result += String.valueOf(Common.user_submit_answer[i]);
                if (result.equals(correctAnswer)) {
                    Toast.makeText(getActivity(), "Finish ! This is " + result, Toast.LENGTH_SHORT).show();
                    mOnButtonClickListener.onButtonClicked(v);
                    //Reset
                    Common.count = 0;
                    Common.user_submit_answer = new char[correctAnswer.length()];

                    //set adapters
                    GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(getActivity(),setupNullList(correctAnswerCharArr), questionFragment);
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();
                    GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(getContext(), suggestSource, questionFragment);

                    //save to instance


                } else {
                    Toast.makeText(getActivity(), "Incorrect!!!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void setupList() {
        Random random = new Random();
        //Add Answer character to List
        suggestSource.clear();

        //char[] answer = correctAnswer.toCharArray();
        Common.user_submit_answer = new char[correctAnswerCharArr.length];
        //Add Answer character to List
        suggestSource.clear();
        for (char item : correctAnswerCharArr) {
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //Random add some character to list
        for (int i = correctAnswerCharArr.length; i < correctAnswerCharArr.length * 2; i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);


        //Set for GridView
        answerAdapter = new GridViewAnswerAdapter(getActivity(), setupNullList(correctAnswerCharArr), questionFragment);
        suggestAdapter = new GridViewSuggestAdapter(getActivity(), suggestSource, questionFragment);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);
    }


    private char[] setupNullList(char[] answer) {
        ;
        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }


}
