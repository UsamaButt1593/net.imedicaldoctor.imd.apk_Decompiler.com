package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zag {

    /* renamed from: a  reason: collision with root package name */
    final zad f20213a;

    /* renamed from: b  reason: collision with root package name */
    protected int f20214b = 0;

    public zag(Uri uri, int i2) {
        this.f20213a = new zad(uri);
        this.f20214b = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void a(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: package-private */
    public final void b(Context context, zak zak, boolean z) {
        int i2 = this.f20214b;
        a(i2 != 0 ? context.getResources().getDrawable(i2) : null, z, false, false);
    }

    /* access modifiers changed from: package-private */
    public final void c(Context context, Bitmap bitmap, boolean z) {
        Asserts.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
