package com.eyos.ofir.guessinggame.SubCategory;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface SubCategoryDao {

    @Insert
    void insert(SubCategory subCategory);

    @Query("SELECT * FROM sub_category_table WHERE matching_category_id = :matchingCategoryId")
    LiveData<List<SubCategory>> findMatchingSubCategories(long matchingCategoryId);
}
