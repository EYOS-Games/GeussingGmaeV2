package com.eyos.ofir.guessinggame.DataBase.DataBaseProvider;

import com.eyos.ofir.guessinggame.Category.Category;
import com.eyos.ofir.guessinggame.Category.CategoryDao;

public class CategoriesProvider {

    public static void addCategoriesToDB(CategoryDao categoryDao){
        categoryDao.insert(new Category(1, "Movies", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
        categoryDao.insert(new Category(2, "two", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
        categoryDao.insert(new Category(3,"three", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
        categoryDao.insert(new Category(4,"four", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
        categoryDao.insert(new Category(5,"five", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
        categoryDao.insert(new Category(5,"six", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2018/07/Movie.jpg", 0));
    }
}
