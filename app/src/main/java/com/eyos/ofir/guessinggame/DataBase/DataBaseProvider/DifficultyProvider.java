package com.eyos.ofir.guessinggame.DataBase.DataBaseProvider;

import com.eyos.ofir.guessinggame.Difficulty.Difficulty;
import com.eyos.ofir.guessinggame.Difficulty.DifficultyDao;

public class DifficultyProvider {

    public static void addDiffucltiesToDb(DifficultyDao difficultyDao){
        difficultyDao.Insert(new Difficulty(1,"easy", "https://www.kashflow.com/wp-content/uploads/2017/03/easy.jpg"));
        difficultyDao.Insert(new Difficulty(2,"medium", "https://cdn-images-1.medium.com/max/727/1*I0E7U5xI-4UvnkExSGKp_w.png"));
        difficultyDao.Insert(new Difficulty(3,"hard", "https://logos.textgiraffe.com/logos/logo-name/Hard-designstyle-friday-m.png"));
        difficultyDao.Insert(new Difficulty(4,"very hard", "https://pics.me.me/com-very-hard-29690165.png"));
    }
}
