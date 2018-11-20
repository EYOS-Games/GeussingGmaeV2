package com.eyos.ofir.guessinggame.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
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
import com.eyos.ofir.guessinggame.Models;
import com.eyos.ofir.guessinggame.R;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionViewModel;
import com.eyos.ofir.guessinggame.Utiliteis.TimerUtilites;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements GridViewSuggestAdapter.OnButtonClickListener {



    private ViewPager viewPager;

    public static QuestionAdapter questionAdapter;
    private SelectedQuestionViewModel selectedQuestionViewModel;
    LifecycleOwner lifecycleOwner = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TimerUtilites.initTimer(); //TODO: MOVE TO MAIN ACTIVITY

        Timber.d("QuestionActivity started");



        viewPager = findViewById(R.id.view_pager_question);

        questionAdapter = new QuestionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(questionAdapter);

        Models.setSelectedQuestionViewModel(ViewModelProviders.of(this).get(SelectedQuestionViewModel.class));

        selectedQuestionViewModel = Models.getSelectedQuestionViewModel();//ViewModelProviders.of(this).get(SelectedQuestionViewModel.class);

        selectedQuestionViewModel.getSelectedQuestions(1, 1, 1).observe(lifecycleOwner, new Observer<List<SelectQuestion>>() {
            @Override
            public void onChanged(List<SelectQuestion> selectQuestions) {
                Timber.d("QuestionActivity onChanged called");
                questionAdapter.setSelectQuestions(selectQuestions);

            }
        });
    }

    @Override
    public void onButtonClicked(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

//    @Override
//    public void onButtonClicked(View view) {
//        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//    }
}
