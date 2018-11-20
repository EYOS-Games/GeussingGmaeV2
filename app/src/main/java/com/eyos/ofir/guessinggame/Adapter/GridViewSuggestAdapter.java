package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.QuestionFragment;

import java.util.List;

public class GridViewSuggestAdapter extends BaseAdapter {

    //  private List<String> suggestSource;
    private Context context;
    private QuestionFragment questionFragment;
    private OnButtonClickListener mOnButtonClickListener;

    private static boolean updateUI, checkForCorrectAnswer;
    private String correctAnswer;


    public GridViewSuggestAdapter(Context context, List<String> suggestSource, QuestionFragment questionFragment) {
        //  this.suggestSource = suggestSource;
        this.context = context;
        this.questionFragment = questionFragment;
        updateUI = false;
        checkForCorrectAnswer = true;
        correctAnswer = questionFragment.correctAnswer;
        mOnButtonClickListener = (OnButtonClickListener) context;

    }

    public interface OnButtonClickListener {
        void onButtonClicked(View view);
    }


    @Override
    public int getCount() {
        return questionFragment.suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return questionFragment.suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(context);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8);
            button.setBackgroundColor(Color.DKGRAY);
            button.setTextColor(Color.YELLOW);
            button.setText(questionFragment.suggestSource.get(position));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    char charAt = questionFragment.suggestSource.get(position).charAt(0); // Get char

                    for (int i = 0; i < questionFragment.correctAnswerCharArr.length; i++) {
                        if (Common.user_submit_answer[i] == 0) { //if there's an empty space
                            Common.user_submit_answer[i] = charAt;
                            updateUI = true;
                            if (i == questionFragment.correctAnswerCharArr.length - 1)
                                checkForCorrectAnswer = true;
                            break;
                        }
                    }
                    if (updateUI) {
                        //Update UI
//                        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, Common.user_submit_answer, questionFragment);
//                        questionFragment.gridViewAnswer.setAdapter(answerAdapter);
//                        answerAdapter.notifyDataSetChanged();
                         GridAdapterUtilities.updateGridAnswerAdapter(context, questionFragment);

                        //Remove from suggest source
                        GridAdapterUtilities.updateGridQuestionAdapter(context, questionFragment, position, "");

//                        questionFragment.suggestSource.set(position, "");
//                        questionFragment.suggestAdapter = new GridViewSuggestAdapter(context, questionFragment.suggestSource, questionFragment);
//                        questionFragment.gridViewSuggest.setAdapter(questionFragment.suggestAdapter);
//                        questionFragment.suggestAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "cant add to answer, please remove first", Toast.LENGTH_SHORT).show();
                    }

                    for (int i = 0; i < questionFragment.correctAnswerCharArr.length; i++) {
                        if (Common.user_submit_answer[i] == 0) { //if there's an empty space
                            checkForCorrectAnswer = false;
                            break;
                        }
                    }

                    if (checkForCorrectAnswer) {
                        String result = "";
                        for (int i = 0; i < Common.user_submit_answer.length; i++)
                            result += String.valueOf(Common.user_submit_answer[i]);
                        if (result.equals(correctAnswer)) {
                            Toast.makeText(context, "Finish ! This is " + result, Toast.LENGTH_SHORT).show();

                            mOnButtonClickListener.onButtonClicked(v);
                            //Reset
                            Common.count = 0;
                            Common.user_submit_answer = new char[correctAnswer.length()];

                            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, questionFragment.setupNullList(correctAnswer.toCharArray()), questionFragment);
                            questionFragment.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();
                            GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(context, questionFragment.suggestSource, questionFragment);
                        } else {
                            Toast.makeText(context, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
        } else
            button = (Button) convertView;
        return button;
    }
}
