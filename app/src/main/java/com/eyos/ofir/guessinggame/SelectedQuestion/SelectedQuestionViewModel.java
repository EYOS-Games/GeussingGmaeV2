package com.eyos.ofir.guessinggame.SelectedQuestion;

import android.app.Application;

import com.eyos.ofir.guessinggame.DataBase.MainRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class SelectedQuestionViewModel extends AndroidViewModel {

    private MainRepo mainRepo;

    public SelectedQuestionViewModel(@NonNull Application application) {
        super(application);

        mainRepo = new MainRepo(application);
    }

    public LiveData<List<SelectQuestion>> getSelectedQuestions(long matchingCategoryId, long matchingSubCategoryId, long matchingDifficultyId) {
        return mainRepo.getSelectedQuestions(matchingCategoryId, matchingSubCategoryId, matchingDifficultyId);
    }
}
