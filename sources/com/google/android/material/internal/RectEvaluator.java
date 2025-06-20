package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f21543a;

    public RectEvaluator(@NonNull Rect rect) {
        this.f21543a = rect;
    }

    /* renamed from: a */
    public Rect evaluate(float f2, @NonNull Rect rect, @NonNull Rect rect2) {
        int i2 = rect.left;
        int i3 = i2 + ((int) (((float) (rect2.left - i2)) * f2));
        int i4 = rect.top;
        int i5 = i4 + ((int) (((float) (rect2.top - i4)) * f2));
        int i6 = rect.right;
        int i7 = rect.bottom;
        int i8 = i7 + ((int) (((float) (rect2.bottom - i7)) * f2));
        this.f21543a.set(i3, i5, i6 + ((int) (((float) (rect2.right - i6)) * f2)), i8);
        return this.f21543a;
    }
}
