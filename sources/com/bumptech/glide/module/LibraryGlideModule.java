package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;

public abstract class LibraryGlideModule implements RegistersComponents {
    public void b(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
    }
}
