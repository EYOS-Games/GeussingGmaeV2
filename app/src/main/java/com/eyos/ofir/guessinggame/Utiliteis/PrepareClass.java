package com.eyos.ofir.guessinggame.Utiliteis;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PrepareClass {

    public static void setMainThemeImg(String imgUrl, Context context, ImageView imageView){
        Glide.with(context).load(imgUrl).into(imageView);
    }

    public static char[] setupNullList(char[] answer) {

        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }
}
