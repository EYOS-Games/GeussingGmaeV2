package com.eyos.ofir.guessinggame.SelectedQuestion;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SelectedQuestionDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(SelectQuestion selectQuestion);

    @Query("SELECT * FROM select_question_table WHERE matching_category_id = :matchingCategoryId AND matching_sub_category_id = :matchingSubCategoryId AND  matching_difficulty_id = :matchingDifficultyId")
    LiveData<List<SelectQuestion>> GetMatchingSelectedQuestions(long matchingCategoryId, long matchingSubCategoryId, long matchingDifficultyId);
}
