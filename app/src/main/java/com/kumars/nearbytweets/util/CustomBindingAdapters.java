package com.kumars.nearbytweets.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class CustomBindingAdapters {

    @BindingAdapter({"profile"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .transform(new CircleTransformation())
                .into(view);
    }
}
