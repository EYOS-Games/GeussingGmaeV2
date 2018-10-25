package com.eyos.ofir.guessinggame.SubCategory;

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
public class SubCategory {

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
}
