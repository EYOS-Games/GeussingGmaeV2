package com.eyos.ofir.guessinggame.SubCategory;

import android.app.Application;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.DataBase.MainRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class SubCategoryViewModel extends AndroidViewModel {

    private MainRepo mainRepo;
    //private LiveData<List<SubCategory>> subCategoriesList;

    public SubCategoryViewModel(@NonNull Application application) {
        super(application);
        mainRepo = new MainRepo(application);

    }

    public LiveData<List<SubCategory>> getSubCategoriesList(long categoryId){
        return mainRepo.getMatchingSubCategories(categoryId);
    }
}
