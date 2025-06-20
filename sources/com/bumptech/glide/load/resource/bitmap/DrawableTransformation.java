package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: c  reason: collision with root package name */
    private final Transformation<Bitmap> f18291c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18292d;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f18291c = transformation;
        this.f18292d = z;
    }

    private Resource<Drawable> d(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.e(context.getResources(), resource);
    }

    public void a(@NonNull MessageDigest messageDigest) {
        this.f18291c.a(messageDigest);
    }

    @NonNull
    public Resource<Drawable> b(@NonNull Context context, @NonNull Resource<Drawable> resource, int i2, int i3) {
        BitmapPool g2 = Glide.d(context).g();
        Drawable drawable = resource.get();
        Resource<Bitmap> a2 = DrawableToBitmapConverter.a(g2, drawable, i2, i3);
        if (a2 != null) {
            Resource<Bitmap> b2 = this.f18291c.b(context, a2, i2, i3);
            if (!b2.equals(a2)) {
                return d(context, b2);
            }
            b2.recycle();
            return resource;
        } else if (!this.f18292d) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public Transformation<BitmapDrawable> c() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f18291c.equals(((DrawableTransformation) obj).f18291c);
        }
        return false;
    }

    public int hashCode() {
        return this.f18291c.hashCode();
    }
}
