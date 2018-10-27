package com.eyos.ofir.guessinggame.Utiliteis;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PrepareClass {

    public static void setMainThemereImg(String imgUrl, Context context, ImageView imageView){
        Glide.with(context).load(imgUrl).into(imageView);
    }
}
