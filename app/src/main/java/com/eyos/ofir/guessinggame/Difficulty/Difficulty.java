package com.eyos.ofir.guessinggame.Difficulty;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "difficulty_table")
public class Difficulty {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "difficulty_id")
    private long difficultyId;

    @ColumnInfo(name = "difficulty_name")
    private String difficultyName;

    @ColumnInfo(name = "difficulty_img_url")
    private String difficultyImgUrl;

    public Difficulty(long difficultyId, String difficultyName, String difficultyImgUrl) {
        this.difficultyId = difficultyId;
        this.difficultyName = difficultyName;
        this.difficultyImgUrl = difficultyImgUrl;
    }

    public long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public String getDifficultyImgUrl() {
        return difficultyImgUrl;
    }

    public void setDifficultyImgUrl(String difficultyImgUrl) {
        this.difficultyImgUrl = difficultyImgUrl;
    }
}
