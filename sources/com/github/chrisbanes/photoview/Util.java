package com.github.chrisbanes.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

class Util {

    /* renamed from: com.github.chrisbanes.photoview.Util$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18880a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f18880a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    Util() {
    }

    static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static int b(int i2) {
        return (i2 & MotionEventCompat.f6446f) >> 8;
    }

    static boolean c(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass1.f18880a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
