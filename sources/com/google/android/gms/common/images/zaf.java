package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zaf extends zag {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ImageManager.OnImageLoadedListener> f20212c;

    public zaf(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.c(onImageLoadedListener);
        this.f20212c = new WeakReference<>(onImageLoadedListener);
    }

    /* access modifiers changed from: protected */
    public final void a(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (!z2 && (onImageLoadedListener = this.f20212c.get()) != null) {
            onImageLoadedListener.a(this.f20213a.f20210a, drawable, z3);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zaf)) {
            return false;
        }
        zaf zaf = (zaf) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.f20212c.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zaf.f20212c.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.b(onImageLoadedListener2, onImageLoadedListener) && Objects.b(zaf.f20213a, this.f20213a);
    }

    public final int hashCode() {
        return Objects.c(this.f20213a);
    }
}
