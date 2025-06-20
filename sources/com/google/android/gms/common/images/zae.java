package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zai;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zae extends zag {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ImageView> f20211c;

    public zae(ImageView imageView, int i2) {
        super(Uri.EMPTY, i2);
        Asserts.c(imageView);
        this.f20211c = new WeakReference<>(imageView);
    }

    /* access modifiers changed from: protected */
    public final void a(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = this.f20211c.get();
        if (imageView == null) {
            return;
        }
        if (z2 || z3 || !(imageView instanceof zaj)) {
            boolean z4 = false;
            if (!z2 && !z) {
                z4 = true;
            }
            if (z4) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zai) {
                    drawable2 = ((zai) drawable2).zaa();
                }
                drawable = new zai(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                zaj zaj = (zaj) imageView;
                throw null;
            } else if (drawable != null && z4) {
                ((zai) drawable).zab(ItemTouchHelper.Callback.f15380c);
            }
        } else {
            zaj zaj2 = (zaj) imageView;
            throw null;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = this.f20211c.get();
        ImageView imageView2 = ((zae) obj).f20211c.get();
        return (imageView2 == null || imageView == null || !Objects.b(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.c(imageView);
        this.f20211c = new WeakReference<>(imageView);
    }
}
