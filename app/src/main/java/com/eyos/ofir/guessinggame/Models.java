package com.eyos.ofir.guessinggame;

import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionViewModel;

public class Models {

    private static SelectedQuestionViewModel selectedQuestionViewModel = null;

    public static   SelectedQuestionViewModel getSelectedQuestionViewModel() {
        return selectedQuestionViewModel;
    }

    public static void setSelectedQuestionViewModel(SelectedQuestionViewModel _selectedQuestionViewModel) {
        selectedQuestionViewModel = _selectedQuestionViewModel;
    }
}
