package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* renamed from: e  reason: collision with root package name */
    private final View f20874e;

    /* renamed from: f  reason: collision with root package name */
    private int f20875f;

    /* renamed from: g  reason: collision with root package name */
    private int f20876g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f20877h = new int[2];

    public InsetsAnimationCallback(View view) {
        super(0);
        this.f20874e = view;
    }

    public void b(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f20874e.setTranslationY(0.0f);
    }

    public void c(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f20874e.getLocationOnScreen(this.f20877h);
        this.f20875f = this.f20877h[1];
    }

    @NonNull
    public WindowInsetsCompat d(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        Iterator<WindowInsetsAnimationCompat> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            WindowInsetsAnimationCompat next = it2.next();
            if ((next.f() & WindowInsetsCompat.Type.d()) != 0) {
                this.f20874e.setTranslationY((float) AnimationUtils.c(this.f20876g, 0, next.d()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsAnimationCompat.BoundsCompat e(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f20874e.getLocationOnScreen(this.f20877h);
        int i2 = this.f20875f - this.f20877h[1];
        this.f20876g = i2;
        this.f20874e.setTranslationY((float) i2);
        return boundsCompat;
    }
}
