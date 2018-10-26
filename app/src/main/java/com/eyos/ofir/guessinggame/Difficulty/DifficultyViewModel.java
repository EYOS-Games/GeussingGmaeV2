package com.eyos.ofir.guessinggame.Difficulty;

import android.app.Application;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.DataBase.MainRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class DifficultyViewModel extends AndroidViewModel {

    private MainRepo mainRepo;
    private LiveData<List<Difficulty>> difficultyList;

    public DifficultyViewModel(@NonNull Application application) {
        super(application);

        mainRepo = new MainRepo(application);
        difficultyList = mainRepo.getDifficultyList();
    }
    public LiveData<List<Difficulty>> getDifficultyList(){
        return  difficultyList;
    }
}
