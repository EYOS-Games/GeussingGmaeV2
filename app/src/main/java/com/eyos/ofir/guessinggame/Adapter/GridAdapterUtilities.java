package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.widget.GridView;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.QuestionFragment;

import java.util.List;

public class GridAdapterUtilities {

    public static void updateGridAnswerAdapter(Context context, QuestionFragment questionFragment){
        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, questionFragment, Common.user_submit_answer);
        questionFragment.gridViewAnswer.setAdapter(answerAdapter);
        answerAdapter.notifyDataSetChanged();
    }

    public static  void updateGridQuestionAdapter(Context context, QuestionFragment questionFragment, int position, String suggest){
        questionFragment.suggestSource.set(position, suggest);
        questionFragment.suggestAdapter = new GridViewSuggestAdapter(context, questionFragment);
        questionFragment.gridViewSuggest.setAdapter(questionFragment.suggestAdapter);
        questionFragment.suggestAdapter.notifyDataSetChanged();
    }

    public  static void setUpAnswerAdapter(Context context, QuestionFragment questionFragment , GridView gridViewAnswer, char[] correctAnswerCharArr){
        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, questionFragment, correctAnswerCharArr);
        gridViewAnswer.setAdapter(answerAdapter);
        answerAdapter.notifyDataSetChanged();
    }

    public  static void setUpQuestionAdapter(Context context , QuestionFragment questionFragment , GridView gridViewSuggest){
        GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(context, questionFragment);
        gridViewSuggest.setAdapter(suggestAdapter);
        suggestAdapter.notifyDataSetChanged();
    }
}
