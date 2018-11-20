package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.QuestionFragment;

public class GridViewAnswerAdapter extends BaseAdapter {

    private char[] answerCharacter;
    private Context context;
    QuestionFragment questionFragment;
    private  boolean updateUI;
    private int indexToRestore;

    public GridViewAnswerAdapter(Context context, QuestionFragment questionFragment, char[] answerCharacter) {
        this.answerCharacter = answerCharacter;
        this.context = context;
        this.questionFragment = questionFragment;
    }

    @Override
    public int getCount() {
        return answerCharacter.length;
    }

    @Override
    public Object getItem(int position) {
        return answerCharacter[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            //create a new button
            button = new Button(context);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8);
            button.setBackgroundColor(Color.DKGRAY);
            button.setTextColor(Color.YELLOW);
            button.setText(String.valueOf(answerCharacter[position]));
            final char[] charAt = {' '};
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < questionFragment.suggestSource.size() ; i++) {
                        charAt[0] = Common.user_submit_answer[position]; // Get char
                        if (questionFragment.suggestSource.get(i).equals("")){
                            Common.user_submit_answer[position] = 0;
                            indexToRestore = i;
                            updateUI = true;
                            break;
                        }
                    }

                    if (updateUI) {
                        //Update UI
//
                        GridAdapterUtilities.updateGridAnswerAdapter(context, questionFragment);

                        //Remove from suggest source
                        GridAdapterUtilities.updateGridQuestionAdapter(context, questionFragment, indexToRestore, String.valueOf(charAt[0]));
//
                    }// else
                      //  Toast.makeText(context, "cant add to answer, please remove first", Toast.LENGTH_SHORT).show();
                }
            });

        } else
            button = (Button) convertView;
        return button;
    }
}
