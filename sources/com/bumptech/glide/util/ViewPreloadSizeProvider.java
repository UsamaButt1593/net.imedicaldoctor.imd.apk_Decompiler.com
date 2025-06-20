package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private int[] f18544a;

    /* renamed from: b  reason: collision with root package name */
    private SizeViewTarget f18545b;

    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        SizeViewTarget(@NonNull View view) {
            super(view);
        }

        public void e(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void k(@Nullable Drawable drawable) {
        }

        /* access modifiers changed from: protected */
        public void m(@Nullable Drawable drawable) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        int[] iArr = this.f18544a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(@NonNull View view) {
        if (this.f18544a == null && this.f18545b == null) {
            SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
            this.f18545b = sizeViewTarget;
            sizeViewTarget.s(this);
        }
    }

    public void e(int i2, int i3) {
        this.f18544a = new int[]{i2, i3};
        this.f18545b = null;
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
        this.f18545b = sizeViewTarget;
        sizeViewTarget.s(this);
    }
}
