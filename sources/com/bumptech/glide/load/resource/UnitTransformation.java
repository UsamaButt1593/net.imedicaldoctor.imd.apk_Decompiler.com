package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Transformation<?> f18229c = new UnitTransformation();

    private UnitTransformation() {
    }

    @NonNull
    public static <T> UnitTransformation<T> c() {
        return (UnitTransformation) f18229c;
    }

    public void a(@NonNull MessageDigest messageDigest) {
    }

    @NonNull
    public Resource<T> b(@NonNull Context context, @NonNull Resource<T> resource, int i2, int i3) {
        return resource;
    }
}
