package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.widget.GridView;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.QuestionFragment;

import java.util.List;

public class GridAdapterUtilities {

    public static void updateGridAnswerAdapter(Context context, QuestionFragment questionFragment){
        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, Common.user_submit_answer, questionFragment);
        questionFragment.gridViewAnswer.setAdapter(answerAdapter);
        answerAdapter.notifyDataSetChanged();
    }

    public static  void updateGridQuestionAdapter(Context context, QuestionFragment questionFragment, int position, String sugget){
        questionFragment.suggestSource.set(position, sugget);
        questionFragment.suggestAdapter = new GridViewSuggestAdapter(context, questionFragment.suggestSource, questionFragment);
        questionFragment.gridViewSuggest.setAdapter(questionFragment.suggestAdapter);
        questionFragment.suggestAdapter.notifyDataSetChanged();
    }

    public  static void setUpAnswerAdapter(Context context, QuestionFragment questionFragment , GridView gridViewAnswer, char[] correctAnswerCharArr){
        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, correctAnswerCharArr, questionFragment);
        answerAdapter.notifyDataSetChanged();
        gridViewAnswer.setAdapter(answerAdapter);
    }

    public  static void setUpQuestionAdapter(Context context , QuestionFragment questionFragment , GridView gridViewSuggest,  List<String> suggestSource){
        GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(context, suggestSource, questionFragment);
        suggestAdapter.notifyDataSetChanged();
        gridViewSuggest.setAdapter(suggestAdapter);
    }
}
