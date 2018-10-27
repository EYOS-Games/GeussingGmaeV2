package com.eyos.ofir.guessinggame.SubCategory;

import android.os.Parcel;
import android.os.Parcelable;

import com.eyos.ofir.guessinggame.Category.Category;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "sub_category_table"
        ,primaryKeys = {"sub_category_id", "matching_category_id"}
        ,indices = {@Index("matching_category_id")}
        , foreignKeys =
         @ForeignKey(
              entity = Category.class
            , parentColumns = "category_id"
            , childColumns = "matching_category_id"
            , onDelete = ForeignKey.CASCADE))
public class SubCategory implements Parcelable {

    @ColumnInfo(name = "sub_category_id")
    private long subCategoryID;


    @ColumnInfo(name = "matching_category_id")
    private long matchingCategoryId;

    @ColumnInfo(name = "sub_category_name")
    private String subCategoryName;

    @ColumnInfo(name = "sub_category_img_url")
    private String SubCategoryImgUrl;

    public SubCategory(long subCategoryID, long matchingCategoryId, String subCategoryName, String subCategoryImgUrl) {
        this.subCategoryID = subCategoryID;
        this.matchingCategoryId = matchingCategoryId;
        this.subCategoryName = subCategoryName;
        SubCategoryImgUrl = subCategoryImgUrl;
    }

    protected SubCategory(Parcel in) {
        subCategoryID = in.readLong();
        matchingCategoryId = in.readLong();
        subCategoryName = in.readString();
        SubCategoryImgUrl = in.readString();
    }

    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };

    public long getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public  SubCategory() {}

    public long getMatchingCategoryId() {
        return matchingCategoryId;
    }

    public void setMatchingCategoryId(long matchingCategoryId) {
        this.matchingCategoryId = matchingCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryImgUrl() {
        return SubCategoryImgUrl;
    }

    public void setSubCategoryImgUrl(String subCategoryImgUrl) {
        SubCategoryImgUrl = subCategoryImgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(subCategoryID);
        dest.writeLong(matchingCategoryId);
        dest.writeString(subCategoryName);
        dest.writeString(SubCategoryImgUrl);
    }
}
