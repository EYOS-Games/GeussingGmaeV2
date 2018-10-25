package com.eyos.ofir.guessinggame.Category;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class Category {

    //@PrimaryKey(autoGenerate = true)
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "category_id")
    private long categoryId;

    @ColumnInfo(name = "category_name")
    private String categoryName;

    @ColumnInfo(name = "category_img_url")
    private String categoryImageUrl;

    @ColumnInfo(name = "category_progress")
    private int categoryProgress;

    public Category(long categoryId, String categoryName, String categoryImageUrl, int categoryProgress) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImageUrl = categoryImageUrl;
        this.categoryProgress = categoryProgress;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    public int getCategoryProgress() {
        return categoryProgress;
    }

    public void setCategoryProgress(int categoryProgress) {
        this.categoryProgress = categoryProgress;
    }



}
