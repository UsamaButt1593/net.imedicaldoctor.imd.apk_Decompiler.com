package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation<GifDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final Transformation<Bitmap> f18380c;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifDrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.bumptech.glide.util.Preconditions.d(r1)
            com.bumptech.glide.load.Transformation r1 = (com.bumptech.glide.load.Transformation) r1
            r0.f18380c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifDrawableTransformation.<init>(com.bumptech.glide.load.Transformation):void");
    }

    public void a(@NonNull MessageDigest messageDigest) {
        this.f18380c.a(messageDigest);
    }

    @NonNull
    public Resource<GifDrawable> b(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i2, int i3) {
        GifDrawable gifDrawable = resource.get();
        BitmapResource bitmapResource = new BitmapResource(gifDrawable.h(), Glide.d(context).g());
        Resource<Bitmap> b2 = this.f18380c.b(context, bitmapResource, i2, i3);
        if (!bitmapResource.equals(b2)) {
            bitmapResource.recycle();
        }
        gifDrawable.r(this.f18380c, b2.get());
        return resource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.f18380c.equals(((GifDrawableTransformation) obj).f18380c);
        }
        return false;
    }

    public int hashCode() {
        return this.f18380c.hashCode();
    }
}
