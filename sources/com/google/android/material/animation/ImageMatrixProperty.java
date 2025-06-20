package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class ImageMatrixProperty extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f20775a = new Matrix();

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
    }

    @NonNull
    /* renamed from: a */
    public Matrix get(@NonNull ImageView imageView) {
        this.f20775a.set(imageView.getImageMatrix());
        return this.f20775a;
    }

    /* renamed from: b */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
