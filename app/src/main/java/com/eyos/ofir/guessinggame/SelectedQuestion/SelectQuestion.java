package com.eyos.ofir.guessinggame.SelectedQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "select_question_table")
public class  SelectQuestion implements Parcelable {

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

    @ColumnInfo(name = "is_question_done")
    private boolean isQuestionDone;

    public SelectQuestion(long selectQuestionId, long matchingCategoryId, long matchingSubCategoryId, long matchingDifficultyId, String selectQuestionImgUrl) {
        this.selectQuestionId = selectQuestionId;
        this.matchingCategoryId = matchingCategoryId;
        this.matchingSubCategoryId = matchingSubCategoryId;
        this.matchingDifficultyId = matchingDifficultyId;
        this.selectQuestionImgUrl = selectQuestionImgUrl;
    }

    protected SelectQuestion(Parcel in) {
        selectQuestionId = in.readLong();
        matchingCategoryId = in.readLong();
        matchingSubCategoryId = in.readLong();
        matchingDifficultyId = in.readLong();
        selectQuestionImgUrl = in.readString();
        isQuestionDone = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(selectQuestionId);
        dest.writeLong(matchingCategoryId);
        dest.writeLong(matchingSubCategoryId);
        dest.writeLong(matchingDifficultyId);
        dest.writeString(selectQuestionImgUrl);
        dest.writeByte((byte) (isQuestionDone ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SelectQuestion> CREATOR = new Creator<SelectQuestion>() {
        @Override
        public SelectQuestion createFromParcel(Parcel in) {
            return new SelectQuestion(in);
        }

        @Override
        public SelectQuestion[] newArray(int size) {
            return new SelectQuestion[size];
        }
    };

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

    public boolean isQuestionDone() {
        return isQuestionDone;
    }

    public void setQuestionDone(boolean questionDone) {
        isQuestionDone = questionDone;
    }
    public String getSelectQuestionAnswer(){
        String answer = "";
        try {
            answer =  Paths.get(new URI(selectQuestionImgUrl).getPath()).getFileName().toString().split("\\.")[0];;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return answer;
    }
}

