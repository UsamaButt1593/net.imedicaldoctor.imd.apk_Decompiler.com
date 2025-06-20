package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Collection<? extends Transformation<T>> f17831c;

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.f17831c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public void a(@NonNull MessageDigest messageDigest) {
        for (Transformation a2 : this.f17831c) {
            a2.a(messageDigest);
        }
    }

    @NonNull
    public Resource<T> b(@NonNull Context context, @NonNull Resource<T> resource, int i2, int i3) {
        Resource<T> resource2 = resource;
        for (Transformation b2 : this.f17831c) {
            Resource<T> b3 = b2.b(context, resource2, i2, i3);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(b3)) {
                resource2.recycle();
            }
            resource2 = b3;
        }
        return resource2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.f17831c.equals(((MultiTransformation) obj).f17831c);
        }
        return false;
    }

    public int hashCode() {
        return this.f17831c.hashCode();
    }

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.f17831c = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
