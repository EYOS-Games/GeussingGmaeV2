package com.eyos.ofir.guessinggame.Adapter;

import android.content.Intent;
import android.os.Bundle;

import com.eyos.ofir.guessinggame.QuestionFragment;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class QuestionAdapter extends FragmentStatePagerAdapter {

    private List<SelectQuestion> selectQuestionList = new ArrayList<>();

    public QuestionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        QuestionFragment questionFragment = new QuestionFragment();
        SelectQuestion selectQuestion = selectQuestionList.get(position);
        Bundle bundle = new Bundle();

       // String imgUrl = selectQuestionList.get(position).getSelectQuestionImgUrl();
      //  bundle.putString("message", imgUrl);
        bundle.putParcelable("message", selectQuestion);
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    @Override
    public int getCount() {
        return selectQuestionList.size();
    }

    public void setSelectQuestions(List<SelectQuestion> selectQuestions) {
        this.selectQuestionList = selectQuestions;
        notifyDataSetChanged();
    }
}
