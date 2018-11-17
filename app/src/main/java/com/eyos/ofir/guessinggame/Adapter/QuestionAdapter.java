package com.eyos.ofir.guessinggame.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;

import com.eyos.ofir.guessinggame.QuestionFragment;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import timber.log.Timber;

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
        Timber.d("QuestionAdapter setSelectQuestions called with question amount "  + selectQuestionList.size());
        notifyDataSetChanged();
    }




}
