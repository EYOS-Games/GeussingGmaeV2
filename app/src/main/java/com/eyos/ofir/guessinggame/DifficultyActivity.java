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
import com.eyos.ofir.guessinggame.Difficulty.DifficultyViewModel;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.Utiliteis.GridSpacingItemDecoration;
import com.eyos.ofir.guessinggame.Utiliteis.PrepareClass;

import java.util.List;

public class DifficultyActivity extends AppCompatActivity {

    private DifficultyViewModel difficultyViewModel;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);

        mAdapter = new Adapter(this, Common.DIFFICULTY_SCREEN);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(10, this), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        difficultyViewModel = ViewModelProviders.of(this).get(DifficultyViewModel.class);

        SubCategory subCategory = getSelectedSubCategory();

        difficultyViewModel.getDifficultyList().observe(this, new Observer<List<Difficulty>>() {
            @Override
            public void onChanged(List<Difficulty> difficulties) {
                mAdapter.setDiffiuclyies(difficulties);
            }
        });


        PrepareClass.setMainThemereImg(subCategory.getSubCategoryImgUrl(), this, findViewById(R.id.image_view_header));

    }

    private SubCategory getSelectedSubCategory(){
        return     getIntent().getParcelableExtra(Common.SELECTED_SUB_CATEGORY_KEY);
    }
}
