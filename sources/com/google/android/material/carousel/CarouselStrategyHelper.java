package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    static float a(float f2, float f3, int i2) {
        return f2 + (((float) Math.max(0, i2 - 1)) * f3);
    }

    static float b(float f2, float f3, int i2) {
        return i2 > 0 ? f2 + (f3 / 2.0f) : f2;
    }

    static KeylineState c(@NonNull Context context, float f2, float f3, @NonNull Arrangement arrangement) {
        float f4;
        float f5;
        float f6 = f2;
        float f7 = f3;
        Arrangement arrangement2 = arrangement;
        float min = Math.min(f(context) + f6, arrangement2.f20922f);
        float f8 = min / 2.0f;
        float f9 = 0.0f - f8;
        float b2 = b(0.0f, arrangement2.f20918b, arrangement2.f20919c);
        float j2 = j(0.0f, a(b2, arrangement2.f20918b, (int) Math.floor((double) (((float) arrangement2.f20919c) / 2.0f))), arrangement2.f20918b, arrangement2.f20919c);
        float b3 = b(j2, arrangement2.f20921e, arrangement2.f20920d);
        float j3 = j(j2, a(b3, arrangement2.f20921e, (int) Math.floor((double) (((float) arrangement2.f20920d) / 2.0f))), arrangement2.f20921e, arrangement2.f20920d);
        float b4 = b(j3, arrangement2.f20922f, arrangement2.f20923g);
        float j4 = j(j3, a(b4, arrangement2.f20922f, arrangement2.f20923g), arrangement2.f20922f, arrangement2.f20923g);
        float b5 = b(j4, arrangement2.f20921e, arrangement2.f20920d);
        float b6 = b(j(j4, a(b5, arrangement2.f20921e, (int) Math.ceil((double) (((float) arrangement2.f20920d) / 2.0f))), arrangement2.f20921e, arrangement2.f20920d), arrangement2.f20918b, arrangement2.f20919c);
        float f10 = f8 + f7;
        float b7 = CarouselStrategy.b(min, arrangement2.f20922f, f6);
        float b8 = CarouselStrategy.b(arrangement2.f20918b, arrangement2.f20922f, f6);
        float b9 = CarouselStrategy.b(arrangement2.f20921e, arrangement2.f20922f, f6);
        KeylineState.Builder a2 = new KeylineState.Builder(arrangement2.f20922f, f7).a(f9, b7, min);
        int i2 = arrangement2.f20919c;
        if (i2 > 0) {
            f4 = f10;
            a2.g(b2, b8, arrangement2.f20918b, (int) Math.floor((double) (((float) i2) / 2.0f)));
        } else {
            f4 = f10;
        }
        int i3 = arrangement2.f20920d;
        if (i3 > 0) {
            a2.g(b3, b9, arrangement2.f20921e, (int) Math.floor((double) (((float) i3) / 2.0f)));
        }
        float f11 = b8;
        a2.h(b4, 0.0f, arrangement2.f20922f, arrangement2.f20923g, true);
        int i4 = arrangement2.f20920d;
        if (i4 > 0) {
            f5 = 2.0f;
            a2.g(b5, b9, arrangement2.f20921e, (int) Math.ceil((double) (((float) i4) / 2.0f)));
        } else {
            f5 = 2.0f;
        }
        int i5 = arrangement2.f20919c;
        if (i5 > 0) {
            a2.g(b6, f11, arrangement2.f20918b, (int) Math.ceil((double) (((float) i5) / f5)));
        }
        a2.a(f4, b7, min);
        return a2.i();
    }

    static KeylineState d(@NonNull Context context, float f2, float f3, @NonNull Arrangement arrangement, int i2) {
        return i2 == 1 ? c(context, f2, f3, arrangement) : e(context, f2, f3, arrangement);
    }

    static KeylineState e(@NonNull Context context, float f2, float f3, @NonNull Arrangement arrangement) {
        float min = Math.min(f(context) + f2, arrangement.f20922f);
        float f4 = min / 2.0f;
        float f5 = 0.0f - f4;
        float b2 = b(0.0f, arrangement.f20922f, arrangement.f20923g);
        float j2 = j(0.0f, a(b2, arrangement.f20922f, arrangement.f20923g), arrangement.f20922f, arrangement.f20923g);
        float b3 = b(j2, arrangement.f20921e, arrangement.f20920d);
        float b4 = b(j(j2, b3, arrangement.f20921e, arrangement.f20920d), arrangement.f20918b, arrangement.f20919c);
        float f6 = f4 + f3;
        float b5 = CarouselStrategy.b(min, arrangement.f20922f, f2);
        float b6 = CarouselStrategy.b(arrangement.f20918b, arrangement.f20922f, f2);
        float b7 = CarouselStrategy.b(arrangement.f20921e, arrangement.f20922f, f2);
        KeylineState.Builder h2 = new KeylineState.Builder(arrangement.f20922f, f3).a(f5, b5, min).h(b2, 0.0f, arrangement.f20922f, arrangement.f20923g, true);
        if (arrangement.f20920d > 0) {
            h2.b(b3, b7, arrangement.f20921e);
        }
        int i2 = arrangement.f20919c;
        if (i2 > 0) {
            h2.g(b4, b6, arrangement.f20918b, i2);
        }
        h2.a(f6, b5, min);
        return h2.i();
    }

    static float f(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.F3);
    }

    static float g(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.H3);
    }

    static float h(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.I3);
    }

    static int i(int[] iArr) {
        int i2 = Integer.MIN_VALUE;
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    static float j(float f2, float f3, float f4, int i2) {
        return i2 > 0 ? f3 + (f4 / 2.0f) : f2;
    }
}
