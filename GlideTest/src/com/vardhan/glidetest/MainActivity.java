package com.vardhan.glidetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends Activity {
    private String url;
    private ImageView imageView;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "http://upload.wikimedia.org/wikipedia/commons/2/2b/Seven_segment_display-animated.gif";

        imageView = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        Glide.with(this).load(url).asGif().fitCenter().into(imageView);

        Glide.with(this).load(url).asGif().listener(new MyRequestListener()).into(imageView2);

    }

    public class MyRequestListener<T, GlideDrawable> implements RequestListener<T, GlideDrawable> {

        @Override
        public boolean onException(Exception e, T model, Target<GlideDrawable> target, boolean isFirstResource) {
            ImageView view = ((ImageViewTarget<?>) target).getView();
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, T model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

            ImageView view = ((ImageViewTarget<?>) target).getView();
            GifDrawable drawable = (GifDrawable) resource;
            view.setBackgroundDrawable(drawable);
            return false;
        }

    }

}
