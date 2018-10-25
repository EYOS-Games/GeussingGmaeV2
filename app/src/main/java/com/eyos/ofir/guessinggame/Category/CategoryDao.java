package com.eyos.ofir.guessinggame.Category;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category_table")
    LiveData<List<Category>> getAllCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category category);

    @Update
    void UpdateCategory(Category category);

    @Query("DELETE FROM category_table")
    void clearTable();

}
