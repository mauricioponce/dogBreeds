package com.eme.dogbreed.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.eme.dogbreed.R;

/**
 * Binding Adapters
 * <p>
 * https://github.com/android/databinding-samples/blob/master/BasicSample/app/src/main/java/com/example/android/databinding/basicsample/util/BindingAdapters.kt
 */
public class PeakyBinder {

    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_cloud_download)
                .into(view);
    }
}
