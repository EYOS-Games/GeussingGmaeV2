package com.eyos.ofir.guessinggame.Category;

import android.app.Application;

import com.eyos.ofir.guessinggame.DataBase.MainRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CategoryViewModel extends AndroidViewModel {

    private MainRepo mainRepo;
    private LiveData<List<Category>> categoryList;

    public CategoryViewModel(@NonNull Application application) {
        super(application);

        mainRepo = new MainRepo(application);
        categoryList = mainRepo.getCategoryList();
    }

    public void populateDB(){
        mainRepo.populateDB();
    }

    public void Insert(Category category){
        mainRepo.insertCategory(category);
    }

    public void Update(Category category){
        mainRepo.updateCategory(category);
    }

    public LiveData<List<Category>> getCategoryList(){
        return  categoryList;
    }
}
