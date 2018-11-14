package com.eyos.ofir.guessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import butterknife.ButterKnife;
import timber.log.Timber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.eyos.ofir.guessinggame.Adapter.GridViewAnswerAdapter;
import com.eyos.ofir.guessinggame.Adapter.GridViewSuggestAdapter;
import com.eyos.ofir.guessinggame.Adapter.QuestionAdapter;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionViewModel;
import com.eyos.ofir.guessinggame.Utiliteis.TimerUtilites;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements QuestionFragment.OnButtonClickListener {



    private ViewPager viewPager;

    private QuestionAdapter questionAdapter;
    private SelectedQuestionViewModel selectedQuestionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TimerUtilites.initTimer(); //TODO: MOVE TO MAIN ACTIVITY

        Timber.d("test test");



        viewPager = findViewById(R.id.view_pager_question);
        questionAdapter = new QuestionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(questionAdapter);

        selectedQuestionViewModel = ViewModelProviders.of(this).get(SelectedQuestionViewModel.class);

        selectedQuestionViewModel.getSelectedQuestions(1, 1, 1).observe(this, new Observer<List<SelectQuestion>>() {
            @Override
            public void onChanged(List<SelectQuestion> selectQuestions) {
                questionAdapter.setSelectQuestions(selectQuestions);
            }
        });

        ////



    }

    @Override
    public void onButtonClicked(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);


    }
}
