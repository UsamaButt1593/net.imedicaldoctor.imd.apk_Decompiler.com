package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;

@Deprecated
interface RegistersComponents {
    void b(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry);
}
