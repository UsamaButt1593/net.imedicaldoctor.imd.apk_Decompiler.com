package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.KeylineState;

public final class UncontainedCarouselStrategy extends CarouselStrategy {

    /* renamed from: c  reason: collision with root package name */
    private static final float f20982c = 0.85f;

    private float k(float f2, float f3, float f4) {
        float max = Math.max(1.5f * f4, f2);
        float f5 = f20982c * f3;
        if (max > f5) {
            max = Math.max(f5, f4 * 1.2f);
        }
        return Math.min(f3, max);
    }

    private KeylineState l(float f2, float f3, float f4, int i2, float f5, float f6, float f7) {
        float f8 = f3;
        float f9 = f4;
        float f10 = f5;
        float min = Math.min(f6, f9);
        float b2 = CarouselStrategy.b(min, f9, f8);
        float b3 = CarouselStrategy.b(f10, f9, f8);
        float f11 = f10 / 2.0f;
        float f12 = (f7 + 0.0f) - f11;
        float f13 = f12 + f11;
        float f14 = min / 2.0f;
        float f15 = (((float) i2) * f9) + f13;
        KeylineState.Builder h2 = new KeylineState.Builder(f9, f2).a((f12 - f11) - f14, b2, min).c(f12, b3, f10, false).h((f9 / 2.0f) + f13, 0.0f, f9, i2, true);
        h2.c(f11 + f15, b3, f10, false);
        h2.a(f15 + f10 + f14, b2, min);
        return h2.i();
    }

    private KeylineState m(Context context, float f2, float f3, float f4, int i2, float f5, int i3, float f6) {
        float f7 = f2;
        float f8 = f4;
        float f9 = f5;
        float min = Math.min(f6, f8);
        float max = Math.max(min, 0.5f * f9);
        float b2 = CarouselStrategy.b(max, f8, f7);
        float b3 = CarouselStrategy.b(min, f8, f7);
        float b4 = CarouselStrategy.b(f9, f8, f7);
        float f10 = (((float) i2) * f8) + 0.0f;
        KeylineState.Builder h2 = new KeylineState.Builder(f8, f3).a(0.0f - (max / 2.0f), b2, max).h(f8 / 2.0f, 0.0f, f8, i2, true);
        if (i3 > 0) {
            float f11 = (f9 / 2.0f) + f10;
            f10 += f9;
            h2.c(f11, b4, f9, false);
        }
        h2.a(f10 + (CarouselStrategyHelper.f(context) / 2.0f), b3, min);
        return h2.i();
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState g(@NonNull Carousel carousel, @NonNull View view) {
        float f2;
        float c2 = (float) (carousel.g() ? carousel.c() : carousel.d());
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f3 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.g()) {
            float f4 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
            f2 = f4;
        } else {
            f2 = f3;
        }
        float f5 = measuredHeight + f2;
        float f6 = CarouselStrategyHelper.f(view.getContext()) + f2;
        float f7 = CarouselStrategyHelper.f(view.getContext()) + f2;
        int max = Math.max(1, (int) Math.floor((double) (c2 / f5)));
        float f8 = c2 - (((float) max) * f5);
        if (carousel.f() == 1) {
            float f9 = f8 / 2.0f;
            return l(c2, f2, f5, max, Math.max(Math.min(3.0f * f9, f5), d() + f2), f7, f9);
        }
        return m(view.getContext(), f2, c2, f5, max, k(f6, f5, f8), f8 > 0.0f ? 1 : 0, f7);
    }
}
