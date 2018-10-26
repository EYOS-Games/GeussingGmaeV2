package com.eyos.ofir.guessinggame.Difficulty;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DifficultyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(Difficulty difficulty);

    @Query("SELECT * FROM difficulty_table")
    LiveData<List<Difficulty>> getAllDifficulties();
}
