package com.eyos.ofir.guessinggame.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.eyos.ofir.guessinggame.Category.Category;

import com.eyos.ofir.guessinggame.Common;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.Activitys.DifficultyActivity;
import com.eyos.ofir.guessinggame.GlideApp;
import com.eyos.ofir.guessinggame.R;
import com.eyos.ofir.guessinggame.Activitys.SelectQuestionActivity;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.Session;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.Activitys.SubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList = new ArrayList<>();
    private List<SubCategory> subCategoryList = new ArrayList<>();
    private List<Difficulty> difficultyList = new ArrayList<>();
    private List<SelectQuestion> selectQuestionList = new ArrayList<>();
    private int currentScreen;
    private Session session;


    public Adapter(Context mContext, int currentScreen) {

        this.mContext = mContext;
        this.currentScreen = currentScreen;
        session = Session.getInstance();
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
        String title = "", img_url = "", key = "";
        long id = 0;
        Category currentCategory = null;
        SubCategory currentSubCategory = null;
        Difficulty currentDifficulty = null;
        SelectQuestion currentSelectQuestion = null;
        if (currentScreen == Common.MAIN_SCREEN) {
            currentCategory = categoryList.get(position);
            title = currentCategory.getCategoryName();
            id = currentCategory.getCategoryId();
            img_url = currentCategory.getCategoryImageUrl();
            key = Common.SELECTED_CATEGORY_KEY;

        } else if (currentScreen == Common.SUB_CATEGORY_SCREEN) {
            currentSubCategory = subCategoryList.get(position);
            title = currentSubCategory.getSubCategoryName();
            id = currentSubCategory.getSubCategoryID();
            img_url = currentSubCategory.getSubCategoryImgUrl();
            key = Common.SELECTED_SUB_CATEGORY_KEY;

        } else if (currentScreen == Common.DIFFICULTY_SCREEN) {
            currentDifficulty = difficultyList.get(position);
            title = currentDifficulty.getDifficultyName();
            id = currentDifficulty.getDifficultyId();
            img_url = currentDifficulty.getDifficultyImgUrl();
            key = Common.SELECTED_DIFFICULTY_KEY;
        } else if(currentScreen == Common.SELECTED_QUESTION_SCREEN){
            currentSelectQuestion = selectQuestionList.get(position);
            title = "";
            id = currentSelectQuestion.getSelectQuestionId();
            img_url = currentSelectQuestion.getSelectQuestionImgUrl();
            key = Common.SELECTED_SELECTED_QUESTION_KEY;
        }

        holder.title.setText(title);
        holder.count.setText(id + "");

        // loading category cover using Glide library



        GlideApp.with(mContext)
                .load(img_url)
                .centerInside()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.thumbnail);



        String selectedKey = key;
        Category selectedCurrentCategory = currentCategory;
        SubCategory selectedCurrentSubCategory = currentSubCategory;
        Difficulty selectedCurrentDifficulty = currentDifficulty;


        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (currentScreen == Common.MAIN_SCREEN) {
                    session.setMatchingCategoryId(selectedCurrentCategory.getCategoryId());
                    intent = new Intent(mContext, SubCategoryActivity.class);
                    intent.putExtra(selectedKey, selectedCurrentCategory);
                    mContext.startActivity(intent);
                } else if (currentScreen == Common.SUB_CATEGORY_SCREEN) {
                    session.setMatchingSubCategoryId(selectedCurrentSubCategory.getSubCategoryID());
                    intent = new Intent(mContext, DifficultyActivity.class);
                    intent.putExtra(selectedKey, selectedCurrentSubCategory);
                    mContext.startActivity(intent);
                } else if (currentScreen == Common.DIFFICULTY_SCREEN) {
                    session.setMatchingDifficultyId(selectedCurrentDifficulty.getDifficultyId());
                    intent = new Intent(mContext, SelectQuestionActivity.class);
                    intent.putExtra(selectedKey, selectedCurrentDifficulty);
                    mContext.startActivity(intent);
                } else if(currentScreen == Common.SELECTED_QUESTION_SCREEN){

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (currentScreen == Common.MAIN_SCREEN)
            size = categoryList.size();
        else if (currentScreen == Common.SUB_CATEGORY_SCREEN)
            size = subCategoryList.size();
        else if (currentScreen == Common.DIFFICULTY_SCREEN)
            size = difficultyList.size();
        else if (currentScreen == Common.SELECTED_QUESTION_SCREEN)
            size = selectQuestionList.size();

        return size;
    }



    public void setCategories(List<Category> categories) {
        this.categoryList = categories;
        notifyDataSetChanged();
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategoryList = subCategories;
        notifyDataSetChanged();
    }

    public void setDiffiuclyies(List<Difficulty> diffiuclties) {
        this.difficultyList = diffiuclties;
        notifyDataSetChanged();
    }

    public void setSelectQuestions(List<SelectQuestion> selectQuestions) {
        this.selectQuestionList = selectQuestions;
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
