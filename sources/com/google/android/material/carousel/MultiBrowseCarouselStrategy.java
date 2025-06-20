package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f20979d = {1};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f20980e = {1, 0};

    /* renamed from: c  reason: collision with root package name */
    private int f20981c = 0;

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState g(@NonNull Carousel carousel, @NonNull View view) {
        float d2 = (float) carousel.d();
        if (carousel.g()) {
            d2 = (float) carousel.c();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.g()) {
            f2 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f3 = f2;
        float d3 = d() + f3;
        float max = Math.max(c() + f3, d3);
        float min = Math.min(measuredHeight + f3, d2);
        float d4 = MathUtils.d((measuredHeight / 3.0f) + f3, d3 + f3, max + f3);
        float f4 = (min + d4) / 2.0f;
        int[] iArr = f20979d;
        if (d2 < 2.0f * d3) {
            iArr = new int[]{0};
        }
        int[] iArr2 = f20980e;
        if (carousel.f() == 1) {
            iArr = CarouselStrategy.a(iArr);
            iArr2 = CarouselStrategy.a(iArr2);
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int ceil = (int) Math.ceil((double) (d2 / min));
        int max2 = (ceil - ((int) Math.max(1.0d, Math.floor((double) (((d2 - (((float) CarouselStrategyHelper.i(iArr4)) * f4)) - (((float) CarouselStrategyHelper.i(iArr3)) * max)) / min))))) + 1;
        int[] iArr5 = new int[max2];
        for (int i2 = 0; i2 < max2; i2++) {
            iArr5[i2] = ceil - i2;
        }
        Arrangement c2 = Arrangement.c(d2, d4, d3, max, iArr3, f4, iArr4, min, iArr5);
        this.f20981c = c2.e();
        if (k(c2, carousel.b())) {
            c2 = Arrangement.c(d2, d4, d3, max, new int[]{c2.f20919c}, f4, new int[]{c2.f20920d}, min, new int[]{c2.f20923g});
        }
        return CarouselStrategyHelper.d(view.getContext(), f3, d2, c2, carousel.f());
    }

    /* access modifiers changed from: package-private */
    public boolean j(Carousel carousel, int i2) {
        return (i2 < this.f20981c && carousel.b() >= this.f20981c) || (i2 >= this.f20981c && carousel.b() < this.f20981c);
    }

    /* access modifiers changed from: package-private */
    public boolean k(Arrangement arrangement, int i2) {
        int e2 = arrangement.e() - i2;
        boolean z = e2 > 0 && (arrangement.f20919c > 0 || arrangement.f20920d > 1);
        while (e2 > 0) {
            int i3 = arrangement.f20919c;
            if (i3 > 0) {
                arrangement.f20919c = i3 - 1;
            } else {
                int i4 = arrangement.f20920d;
                if (i4 > 1) {
                    arrangement.f20920d = i4 - 1;
                }
            }
            e2--;
        }
        return z;
    }
}
