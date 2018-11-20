package com.eyos.ofir.guessinggame.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryDao;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.CategoriesProvider;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.DifficultyProvider;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.SelectedQuestionProvier;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.SubCategoriesProvier;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.Difficulty.DifficultyDao;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionDao;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MainRepo {

    private CategoryDao categoryDao;
    private SubCategoryDao subCategoryDao;
    private DifficultyDao difficultyDao;
    private SelectedQuestionDao selectedQuestionDao;

    private LiveData<List<Category>> categoryList;
    private LiveData<List<Difficulty>> difficultyList;
   // private LiveData<List<SelectedQuestionDao>> selectedQuestionList;

    public MainRepo(Application application) {
        MainDb database = MainDb.getInstance(application);
        categoryDao = database.categoryDao();
        subCategoryDao = database.subCategoryDao();
        difficultyDao = database.difficultyDao();
        selectedQuestionDao = database.selectedQuestionDao();

        categoryList = categoryDao.getAllCategories();
        difficultyList = difficultyDao.getAllDifficulties();
    }


    public void populateDB() {
        new populateDBAsyncTask(categoryDao, subCategoryDao, difficultyDao, selectedQuestionDao).execute();
    }


    public void updateQuestionDone(long questionId){
        new updateQuestionDoneAsyncTask(selectedQuestionDao).execute(questionId);
    }


    public LiveData<List<SelectQuestion>> getSelectedQuestions(long matchingCategoryId, long matchingSubCategoryId, long matchingDifficultyId) {
        return  selectedQuestionDao.GetMatchingSelectedQuestions(matchingCategoryId, matchingSubCategoryId,matchingDifficultyId);
    }

    public LiveData<List<Difficulty>> getDifficultyList() {
        return difficultyList;
    }

    public LiveData<List<SubCategory>> getMatchingSubCategories(long categoryId) {
        return subCategoryDao.findMatchingSubCategories(categoryId);
    }


    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    public void updateCategory(Category category) {
        new UpdateCategoryAsyncTask(categoryDao).execute(category);
    }

    public void insertCategory(Category category) {
        new InsertCategoryAsyncTask(categoryDao).execute(category);
    }

    private static class updateQuestionDoneAsyncTask extends  AsyncTask<Long, Void, Void>{

        private SelectedQuestionDao selectedQuestionDao;

        public updateQuestionDoneAsyncTask(SelectedQuestionDao selectedQuestionDao) {
            this.selectedQuestionDao = selectedQuestionDao;
        }

        @Override
        protected Void doInBackground(Long... longs) {
            long questionId = longs[0];
            selectedQuestionDao.setQuestionDone(questionId);
            return null;
        }
    }


    private static class populateDBAsyncTask extends AsyncTask<Void, Void, Void> {

        private CategoryDao categoryDao;
        private SubCategoryDao subCategoryDao;
        private DifficultyDao difficultyDao;
        private SelectedQuestionDao selectedQuestionDao;

        public populateDBAsyncTask(CategoryDao categoryDao, SubCategoryDao subCategoryDao, DifficultyDao difficultyDao, SelectedQuestionDao selectedQuestionDao) {
            this.categoryDao = categoryDao;
            this.subCategoryDao = subCategoryDao;
            this.difficultyDao = difficultyDao;
            this.selectedQuestionDao = selectedQuestionDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {

            CategoriesProvider.addCategoriesToDB(categoryDao);
            SubCategoriesProvier.addSsubCategoriesToDB(subCategoryDao);
            DifficultyProvider.addDiffucltiesToDb(difficultyDao);
            SelectedQuestionProvier.addSelectedQuestionToDB(selectedQuestionDao);
            return null;
        }
    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category, Void, Void> {

        private CategoryDao categoryDao;

        public InsertCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    private static class UpdateCategoryAsyncTask extends AsyncTask<Category, Void, Void> {

        private CategoryDao categoryDao;

        public UpdateCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.UpdateCategory(categories[0]);
            return null;
        }
    }
}
