package com.eyos.ofir.guessinggame.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryDao;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.CategoriesProvider;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.DifficultyProvider;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.SubCategoriesProvier;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.Difficulty.DifficultyDao;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MainRepo {

    private CategoryDao categoryDao;
    private SubCategoryDao subCategoryDao;
    private DifficultyDao difficultyDao;

    private LiveData<List<Category>> categoryList;
    private  LiveData<List<Difficulty>> difficultyList;

    public MainRepo(Application application) {
        MainDb database = MainDb.getInstance(application);
        categoryDao = database.categoryDao();
        subCategoryDao = database.subCategoryDao();
        difficultyDao = database.difficultyDao();

        categoryList = categoryDao.getAllCategories();
        difficultyList = difficultyDao.getAllDifficulties();
    }


    public void populateDB(){
        new populateDBAsyncTask(categoryDao, subCategoryDao, difficultyDao).execute();
    }

    public LiveData<List<Difficulty>> getDifficultyList() { return  difficultyList;}

    public LiveData<List<SubCategory>> getMatchingSubCategories(long categoryId){
        return subCategoryDao.findMatchingSubCategories(categoryId);
    }


    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    public void updateCategory(Category category){
        new UpdateCategoryAsyncTask(categoryDao).execute(category);
    }

    public void insertCategory(Category category){
        new InsertCategoryAsyncTask(categoryDao).execute(category);
    }


    private static class populateDBAsyncTask extends  AsyncTask<Void,Void,Void>{

        private CategoryDao categoryDao;
        private SubCategoryDao subCategoryDao;
        private DifficultyDao difficultyDao;

        public populateDBAsyncTask(CategoryDao categoryDao, SubCategoryDao subCategoryDao, DifficultyDao difficultyDao) {
            this.categoryDao = categoryDao;
            this.subCategoryDao = subCategoryDao;
            this.difficultyDao = difficultyDao;
        }



        @Override
        protected Void doInBackground(Void... voids) {

            CategoriesProvider.addCategoriesToDB(categoryDao);
            SubCategoriesProvier.addSsubCategoriesToDB(subCategoryDao);
            DifficultyProvider.addDiffucltiesToDb(difficultyDao);
            return null;
        }
    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category, Void, Void>{

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

    private static class UpdateCategoryAsyncTask extends  AsyncTask<Category, Void, Void>{

        private  CategoryDao categoryDao;

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
