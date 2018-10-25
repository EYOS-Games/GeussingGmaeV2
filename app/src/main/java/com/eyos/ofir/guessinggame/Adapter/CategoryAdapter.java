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

import com.eyos.ofir.guessinggame.R;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList = new ArrayList<>();
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private int currentScreen;

    public CategoryAdapter(Context mContext, int currentScreen) {

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
        if (currentScreen == 0){
            Category currentCategory = categoryList.get(position);
            title = currentCategory.getCategoryName();
            id = currentCategory.getCategoryId();
            img_url = currentCategory.getCategoryImageUrl();
            key =  "selected_category";
        }else if (currentScreen == 1){
            SubCategory currentSubCategory = subCategoryList.get(position);
            title  = currentSubCategory.getSubCategoryName();
            id = currentSubCategory.getSubCategoryID();
            img_url = currentSubCategory.getSubCategoryImgUrl();
            key = "selected_subcategory";
        }

        holder.title.setText(title);
        holder.count.setText(id + " done");

        // loading category cover using Glide library
        Glide.with(mContext).load(img_url).into(holder.thumbnail);

        String finalKey = key;
        long finalId = id;
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SubCategoryActivity.class);
                intent.putExtra(finalKey, finalId);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        int size  = 0;
        if(currentScreen == 0)
            size =  categoryList.size();
        else if(currentScreen == 1)
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
