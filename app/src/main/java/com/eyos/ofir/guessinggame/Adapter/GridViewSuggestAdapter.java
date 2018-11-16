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

    private List<String> suggestSource;
    private Context context;
    private QuestionFragment questionFragment;

    private static boolean updateUI;


    public GridViewSuggestAdapter(Context context, List<String> suggestSource, QuestionFragment questionFragment) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.questionFragment = questionFragment;
        updateUI = false;

    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
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
            button.setText(suggestSource.get(position));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    char charAt = suggestSource.get(position).charAt(0); // Get char

                    for (int i = 0; i < questionFragment.correctAnswerCharArr.length; i++) {
                        if (Common.user_submit_answer[i] == 0) { //if there's an empty space
                            Common.user_submit_answer[i] = charAt;
                            updateUI = true;
                            break;
                        }

                    }

                    if (updateUI) {
                        //Update UI
                        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(context, Common.user_submit_answer);
                        questionFragment.gridViewAnswer.setAdapter(answerAdapter);
                        answerAdapter.notifyDataSetChanged();

                        //Remove from suggest source
                        questionFragment.suggestSource.set(position, "");
                        questionFragment.suggestAdapter = new GridViewSuggestAdapter(context, questionFragment.suggestSource, questionFragment);
                        questionFragment.gridViewSuggest.setAdapter(questionFragment.suggestAdapter);
                        questionFragment.suggestAdapter.notifyDataSetChanged();
                    } else
                        Toast.makeText(context, "cant add to answer, please remove first", Toast.LENGTH_SHORT).show();
                }
            });
        } else
            button = (Button) convertView;
        return button;
    }
}
