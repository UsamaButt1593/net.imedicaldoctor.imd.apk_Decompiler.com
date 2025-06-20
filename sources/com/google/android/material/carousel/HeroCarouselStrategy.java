package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public class HeroCarouselStrategy extends CarouselStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f20945d = {1};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f20946e = {0, 1};

    /* renamed from: c  reason: collision with root package name */
    private int f20947c = 0;

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState g(@NonNull Carousel carousel, @NonNull View view) {
        int i2;
        int d2 = carousel.d();
        if (carousel.g()) {
            d2 = carousel.c();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredWidth = (float) (view.getMeasuredWidth() * 2);
        if (carousel.g()) {
            f2 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredWidth = (float) (view.getMeasuredHeight() * 2);
        }
        float d3 = d() + f2;
        float max = Math.max(c() + f2, d3);
        float f3 = (float) d2;
        float min = Math.min(measuredWidth + f2, f3);
        float d4 = MathUtils.d((measuredWidth / 3.0f) + f2, d3 + f2, max + f2);
        float f4 = (min + d4) / 2.0f;
        int[] iArr = f20945d;
        int[] iArr2 = f3 < 2.0f * d3 ? new int[]{0} : iArr;
        int max2 = (int) Math.max(1.0d, Math.floor((double) ((f3 - (((float) CarouselStrategyHelper.i(iArr)) * max)) / min)));
        int ceil = (((int) Math.ceil((double) (f3 / min))) - max2) + 1;
        int[] iArr3 = new int[ceil];
        for (int i3 = 0; i3 < ceil; i3++) {
            iArr3[i3] = max2 + i3;
        }
        int i4 = carousel.f() == 1 ? 1 : 0;
        int[] a2 = i4 != 0 ? CarouselStrategy.a(iArr2) : iArr2;
        int[] iArr4 = f20946e;
        if (i4 != 0) {
            iArr4 = CarouselStrategy.a(iArr4);
        }
        int[] iArr5 = iArr3;
        Arrangement c2 = Arrangement.c(f3, d4, d3, max, a2, f4, iArr4, min, iArr3);
        this.f20947c = c2.e();
        if (c2.e() > carousel.b()) {
            c2 = Arrangement.c(f3, d4, d3, max, iArr2, f4, f20946e, min, iArr5);
            i2 = 0;
        } else {
            i2 = i4;
        }
        return CarouselStrategyHelper.d(view.getContext(), f2, f3, c2, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean j(@NonNull Carousel carousel, int i2) {
        if (carousel.f() == 1) {
            if (i2 >= this.f20947c || carousel.b() < this.f20947c) {
                return i2 >= this.f20947c && carousel.b() < this.f20947c;
            }
            return true;
        }
    }
}
