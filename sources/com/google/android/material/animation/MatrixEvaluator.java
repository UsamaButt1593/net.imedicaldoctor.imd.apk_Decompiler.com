package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f20776a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f20777b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f20778c = new Matrix();

    @NonNull
    /* renamed from: a */
    public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f20776a);
        matrix2.getValues(this.f20777b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f20777b;
            float f3 = fArr[i2];
            float f4 = this.f20776a[i2];
            fArr[i2] = f4 + ((f3 - f4) * f2);
        }
        this.f20778c.setValues(this.f20777b);
        return this.f20778c;
    }
}
