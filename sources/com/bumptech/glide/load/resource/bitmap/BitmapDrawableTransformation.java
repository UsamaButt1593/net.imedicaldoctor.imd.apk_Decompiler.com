package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final Transformation<Drawable> f18234c;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f18234c = (Transformation) Preconditions.d(new DrawableTransformation(transformation, false));
    }

    private static Resource<BitmapDrawable> c(Resource<Drawable> resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    private static Resource<Drawable> d(Resource<BitmapDrawable> resource) {
        return resource;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        this.f18234c.a(messageDigest);
    }

    @NonNull
    public Resource<BitmapDrawable> b(@NonNull Context context, @NonNull Resource<BitmapDrawable> resource, int i2, int i3) {
        return c(this.f18234c.b(context, d(resource), i2, i3));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.f18234c.equals(((BitmapDrawableTransformation) obj).f18234c);
        }
        return false;
    }

    public int hashCode() {
        return this.f18234c.hashCode();
    }
}
