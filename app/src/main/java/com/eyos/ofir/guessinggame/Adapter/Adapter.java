package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eyos.ofir.guessinggame.Category.Category;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.DifficultyActivity;
import com.eyos.ofir.guessinggame.R;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList = new ArrayList<>();
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private List<Difficulty> difficultyList = new ArrayList<>();
    private int currentScreen;

    public Adapter(Context mContext, int currentScreen) {

        this.mContext = mContext;
        this.currentScreen = currentScreen;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = "",img_url = "", key = "";
        long id = 0;
        Category currentCategory = null;
        SubCategory  currentSubCategory  = null;
        if (currentScreen == Common.MAIN_SCREEN){
            currentCategory = categoryList.get(position);
            title = currentCategory.getCategoryName();
            id = currentCategory.getCategoryId();
            img_url = currentCategory.getCategoryImageUrl();
            key =  Common.SELECTED_CATEGORY_KEY;
        }else if (currentScreen == Common.SUB_CATEGORY_SCREEN){
            currentSubCategory = subCategoryList.get(position);
            title  = currentSubCategory.getSubCategoryName();
            id = currentSubCategory.getSubCategoryID();
            img_url = currentSubCategory.getSubCategoryImgUrl();
            key = Common.SELECTED_SUB_CATEGORY_KEY_;
        }

        holder.title.setText(title);
        holder.count.setText(id + " done");

        // loading category cover using Glide library
        Glide.with(mContext).load(img_url).into(holder.thumbnail);


        long slectedId = id;
        Category selectedCurrentCategory = currentCategory;
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
               if (currentScreen == Common.MAIN_SCREEN){
                   intent = new Intent(mContext, SubCategoryActivity.class);
                   intent.putExtra(Common.SELECTED_CATEGORY_KEY, selectedCurrentCategory);
                   mContext.startActivity(intent);
               } else if (currentScreen == Common.SUB_CATEGORY_SCREEN){
                   intent = new Intent(mContext, DifficultyActivity.class);
                   mContext.startActivity(intent);
               }
            }
        });
    }

    @Override
    public int getItemCount() {
        int size  = 0;
        if(currentScreen == Common.MAIN_SCREEN)
            size =  categoryList.size();
        else if(currentScreen == Common.SUB_CATEGORY_SCREEN)
            size =  subCategoryList.size();

        return size;
    }

    public void setCategories(List<Category> categories) {
        this.categoryList = categories;
        notifyDataSetChanged();
    }

    public void setSubCategories(List<SubCategory> subCategories){
        this.subCategoryList = subCategories;
        notifyDataSetChanged();
    }

    public  void setDiffiuclyies(List<Difficulty> diffiuclties){
        this.difficultyList = diffiuclties;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, count;
        private ImageView thumbnail;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);
            cardView = view.findViewById(R.id.card_view);

        }
    }
}
