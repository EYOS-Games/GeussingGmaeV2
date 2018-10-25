package com.eyos.ofir.guessinggame.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryDao;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.CategoriesProvider;
import com.eyos.ofir.guessinggame.DataBase.DataBaseProvider.SubCategoriesProvier;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MainRepo {

    private CategoryDao categoryDao;
    private SubCategoryDao subCategoryDao;

    private LiveData<List<Category>> categoryList;

    public MainRepo(Application application) {
        MainDb database = MainDb.getInstance(application);
        categoryDao = database.categoryDao();
        subCategoryDao = database.subCategoryDao();
        categoryList = categoryDao.getAllCategories();
    }


    public void populateDB(){
        new populateDBAsyncTask(categoryDao, subCategoryDao).execute();
    }

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

        public populateDBAsyncTask(CategoryDao categoryDao, SubCategoryDao subCategoryDao) {
            this.categoryDao = categoryDao;
            this.subCategoryDao = subCategoryDao;
        }



        @Override
        protected Void doInBackground(Void... voids) {

            CategoriesProvider.addCategoriesToDB(categoryDao);
            SubCategoriesProvier.addSsubCategoriesToDB(subCategoryDao);
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
