package com.eyos.ofir.guessinggame.SelectedQuestion;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "select_question_table")
public class SelectQuestion {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "select_question_id")
    private long selectQuestionId;

    @ColumnInfo(name = "matching_category_id")
    private long matchingCategoryId;

    @ColumnInfo(name = "matching_sub_category_id")
    private long matchingSubCategoryId;

    @ColumnInfo(name = "matching_difficulty_id")
    private long matchingDifficultyId;

    @ColumnInfo(name = "select_question_image_url")
    private String selectQuestionImgUrl;

    public SelectQuestion(long selectQuestionId, long matchingCategoryId, long matchingSubCategoryId, long matchingDifficultyId, String selectQuestionImgUrl) {
        this.selectQuestionId = selectQuestionId;
        this.matchingCategoryId = matchingCategoryId;
        this.matchingSubCategoryId = matchingSubCategoryId;
        this.matchingDifficultyId = matchingDifficultyId;
        this.selectQuestionImgUrl = selectQuestionImgUrl;
    }

    public long getSelectQuestionId() {
        return selectQuestionId;
    }

    public void setSelectQuestionId(long selectQuestionId) {
        this.selectQuestionId = selectQuestionId;
    }

    public long getMatchingCategoryId() {
        return matchingCategoryId;
    }

    public void setMatchingCategoryId(long matchingCategoryId) {
        this.matchingCategoryId = matchingCategoryId;
    }

    public long getMatchingSubCategoryId() {
        return matchingSubCategoryId;
    }

    public void setMatchingSubCategoryId(long matchingSubCategoryId) {
        this.matchingSubCategoryId = matchingSubCategoryId;
    }

    public long getMatchingDifficultyId() {
        return matchingDifficultyId;
    }

    public void setMatchingDifficultyId(long matchingDifficultyId) {
        this.matchingDifficultyId = matchingDifficultyId;
    }

    public String getSelectQuestionImgUrl() {
        return selectQuestionImgUrl;
    }

    public void setSelectQuestionImgUrl(String selectQuestionImgUrl) {
        this.selectQuestionImgUrl = selectQuestionImgUrl;
    }
}
