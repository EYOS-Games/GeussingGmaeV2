package com.eyos.ofir.guessinggame.Difficulty;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "difficulty_table")
public class Difficulty implements Parcelable {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "difficulty_id")
    private long difficultyId;

    @ColumnInfo(name = "difficulty_name")
    private String difficultyName;

    @ColumnInfo(name = "difficulty_img_url")
    private String difficultyImgUrl;

    public Difficulty(long difficultyId, String difficultyName, String difficultyImgUrl)  {
        this.difficultyId = difficultyId;
        this.difficultyName = difficultyName;
        this.difficultyImgUrl = difficultyImgUrl;
    }

    protected Difficulty(Parcel in) {
        difficultyId = in.readLong();
        difficultyName = in.readString();
        difficultyImgUrl = in.readString();
    }

    public static final Creator<Difficulty> CREATOR = new Creator<Difficulty>() {
        @Override
        public Difficulty createFromParcel(Parcel in) {
            return new Difficulty(in);
        }

        @Override
        public Difficulty[] newArray(int size) {
            return new Difficulty[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(difficultyId);
        dest.writeString(difficultyName);
        dest.writeString(difficultyImgUrl);
    }
}
