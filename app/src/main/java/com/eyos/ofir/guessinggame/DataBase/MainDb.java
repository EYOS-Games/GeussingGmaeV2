package com.eyos.ofir.guessinggame.DataBase;

import android.content.Context;
import android.os.AsyncTask;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryDao;
import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.Difficulty.DifficultyDao;
import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryDao;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Category.class, SubCategory.class, Difficulty.class}, version  = 4, exportSchema = false)
public abstract class MainDb extends RoomDatabase {

    private static MainDb INSTANCE;

    public abstract CategoryDao categoryDao();
    public abstract SubCategoryDao subCategoryDao();
    public abstract DifficultyDao difficultyDao();

    public synchronized static MainDb getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MainDb.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

  /*  private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CategoryDao categoryDao;

        private PopulateDbAsyncTask(MainDb db) {
            categoryDao = db.categoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //DataBaseProvider.addCategoriesToDB(categoryDao);



            return null;
        }
    }*/
}
