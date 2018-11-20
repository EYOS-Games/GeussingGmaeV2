package com.eyos.ofir.guessinggame.Activitys;


import android.os.Bundle;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.R;
import com.eyos.ofir.guessinggame.Utiliteis.GridSpacingItemDecoration;
import com.eyos.ofir.guessinggame.Utiliteis.PrepareClass;
import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Adapter.Adapter;
import com.eyos.ofir.guessinggame.Category.CategoryViewModel;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private  CategoryViewModel CategoryViewModel ;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView =  findViewById(R.id.recycler_view);

        mAdapter = new Adapter(this, Common.MAIN_SCREEN);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(10, this), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        CategoryViewModel.populateDB();
        CategoryViewModel.getCategoryList().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                mAdapter.setCategories(categories);
            }
        });


        PrepareClass.setMainThemeImg("https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg",this,  findViewById(R.id.image_view_header));


    }

  /*  public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }*/
}
