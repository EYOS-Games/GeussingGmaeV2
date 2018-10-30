package com.eyos.ofir.guessinggame.DataBase.DataBaseProvider;

import com.eyos.ofir.guessinggame.SelectedQuestion.SelectQuestion;
import com.eyos.ofir.guessinggame.SelectedQuestion.SelectedQuestionDao;

public class SelectedQuestionProvier {

    public  static void addSelectedQuestionToDB(SelectedQuestionDao selectedQuestionDao){

        selectedQuestionDao.Insert(new SelectQuestion(1,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/american-sniper.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(2,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/banks.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(3,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/black-swan.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(4,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/casino-royale.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(5,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/dirtyharry.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(6,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/forrest-gump.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(7,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/freewilly.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(8,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/Gladiator.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(9,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/imitation-game.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(10,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/leathal-weapon.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(11,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/mission-impossible-rogue-nation.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(12,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/nightcrawler.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(13,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/pulp-fiction1.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(14,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/quantum-of-solace.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(15,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/ragingbull.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(16,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/rain-man.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(17,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/rockybalboa.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(18,1,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/the-sound-of-music.jpg"));

        selectedQuestionDao.Insert(new SelectQuestion(19,2,1,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/theexorcist.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(20,1,2,1
                , "http://www.fubiz.net/wp-content/uploads/2015/09/theterminator-1.jpg"));
        selectedQuestionDao.Insert(new SelectQuestion(21,1,1,2
                , "http://www.fubiz.net/wp-content/uploads/2015/09/titanic.jpg"));

    }
}
