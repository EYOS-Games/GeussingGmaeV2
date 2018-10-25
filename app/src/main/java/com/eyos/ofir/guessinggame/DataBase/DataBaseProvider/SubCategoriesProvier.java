package com.eyos.ofir.guessinggame.DataBase.DataBaseProvider;

import com.eyos.ofir.guessinggame.SubCategory.SubCategory;
import com.eyos.ofir.guessinggame.SubCategory.SubCategoryDao;

public class SubCategoriesProvier {

    public  static void addSsubCategoriesToDB(SubCategoryDao subCategoryDao){


        subCategoryDao.insert(new SubCategory(1, 1
                , "70's movies"
                , "https://bfmbrainfall.files.wordpress.com/2015/10/classic_70s_movies_featured.jpg?w=283"));
        subCategoryDao.insert(new SubCategory(2, 1
                , "80's movies"
                , "https://cdn.mos.cms.futurecdn.net/5ee7b1d2719043be7761efee2988a0b4.jpg"));
        subCategoryDao.insert(new SubCategory(3, 1
                , "90's movies"
                , "https://frackmanthemovie.com/wp-content/uploads/2018/07/Screen-Shot-2018-07-23-at-5.21.35-PM.png"));
        subCategoryDao.insert(new SubCategory(4, 1
                , "2000 movies"
                , "https://cdn.taschen.com/media/images/960/movies_of_the_2000s_hc_bu_gb_3d_49322_1612271446_id_1103966.png"));

        subCategoryDao.insert(new SubCategory(5, 2
                , "other stuff"
                , "https://cdn.taschen.com/media/images/960/movies_of_the_2000s_hc_bu_gb_3d_49322_1612271446_id_1103966.png"));
        subCategoryDao.insert(new SubCategory(6, 3
                , "some other stuff"
                , "https://cdn.mos.cms.futurecdn.net/5ee7b1d2719043be7761efee2988a0b4.jpg"));

    }
}
