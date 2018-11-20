package com.eyos.ofir.guessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eyos.ofir.guessinggame.Adapter.Adapter;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionViewModel;
import com.eyos.ofir.guessinggame.Utiliteis.GridSpacingItemDecoration;
import com.eyos.ofir.guessinggame.Utiliteis.PrepareClass;

import java.util.List;

public class SelectQuestionActivity extends AppCompatActivity {

    private SelectedQuestionViewModel selectedQuestionViewModel;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);

        mAdapter = new Adapter(this, Common.SELECTED_QUESTION_SCREEN);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(5, GridSpacingItemDecoration.dpToPx(10, this), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        selectedQuestionViewModel = ViewModelProviders.of(this).get(SelectedQuestionViewModel.class);
        session = Session.getInstance();
        long matchingCategoryId = session.getMatchingCategoryId();
        long matchingSubCategoryId = session.getMatchingSubCategoryId();
        long matchingDifficultyId = session.getMatchingDifficultyId();
        selectedQuestionViewModel.getSelectedQuestions(matchingCategoryId, matchingSubCategoryId, matchingDifficultyId).observe(this, new Observer<List<SelectQuestion>>() {
            @Override
            public void onChanged(List<SelectQuestion> selectQuestions) {
                mAdapter.setSelectQuestions(selectQuestions);
            }
        });

        PrepareClass.setMainThemeImg(getSelectedDiffuclty().getDifficultyImgUrl(), this, findViewById(R.id.image_view_header));
    }

    private Difficulty getSelectedDiffuclty() {
        Difficulty Difficulty = getIntent().getParcelableExtra(Common.SELECTED_DIFFICULTY_KEY);
        return  Difficulty;
    }
}
