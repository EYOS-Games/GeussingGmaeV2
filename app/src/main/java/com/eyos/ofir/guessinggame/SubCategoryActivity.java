package com.eyos.ofir.guessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eyos.ofir.guessinggame.Adapter.CategoryAdapter;
import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryViewModel;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryViewModel;
import com.eyos.ofir.guessinggame.Utiliteis.GridSpacingItemDecoration;
import com.eyos.ofir.guessinggame.Utiliteis.PrepareClass;

import java.util.List;

public class SubCategoryActivity extends AppCompatActivity {

    private SubCategoryViewModel subCategoryViewModel ;
    private RecyclerView mRecyclerView;
    private CategoryAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView =  findViewById(R.id.recycler_view);

        mAdapter = new CategoryAdapter(this, 1);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(10, this), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        subCategoryViewModel = ViewModelProviders.of(this).get(SubCategoryViewModel.class);

        subCategoryViewModel.getSubCategoriesList(getCategoryId()).observe(this, new Observer<List<SubCategory>>() {
                    @Override
                    public void onChanged(List<SubCategory> subCategories) {
                        mAdapter.setSubCategories(subCategories);
                    }
                });


         PrepareClass.setMainThemereImg("https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", this, findViewById(R.id.image_view_header));
    }

    private long getCategoryId(){
       // if(getIntent().hasExtra("selected_category")){
      return     getIntent().getLongExtra("selected_category", 0);


    }
}
