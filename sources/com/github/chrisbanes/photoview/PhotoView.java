package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class PhotoView extends AppCompatImageView {
    private PhotoViewAttacher Z2;
    private ImageView.ScaleType a3;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void e() {
        this.Z2 = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.a3;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.a3 = null;
        }
    }

    public void b(Matrix matrix) {
        this.Z2.D(matrix);
    }

    public void c(Matrix matrix) {
        this.Z2.P(matrix);
    }

    public boolean f() {
        return this.Z2.S();
    }

    public boolean g(Matrix matrix) {
        return this.Z2.W(matrix);
    }

    public PhotoViewAttacher getAttacher() {
        return this.Z2;
    }

    public RectF getDisplayRect() {
        return this.Z2.E();
    }

    public Matrix getImageMatrix() {
        return this.Z2.H();
    }

    public float getMaximumScale() {
        return this.Z2.K();
    }

    public float getMediumScale() {
        return this.Z2.L();
    }

    public float getMinimumScale() {
        return this.Z2.M();
    }

    public float getScale() {
        return this.Z2.N();
    }

    public ImageView.ScaleType getScaleType() {
        return this.Z2.O();
    }

    public void h(float f2, float f3, float f4, boolean z) {
        this.Z2.o0(f2, f3, f4, z);
    }

    public void i(float f2, boolean z) {
        this.Z2.p0(f2, z);
    }

    public void j(float f2, float f3, float f4) {
        this.Z2.q0(f2, f3, f4);
    }

    public boolean k(Matrix matrix) {
        return this.Z2.W(matrix);
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.Z2.U(z);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.Z2.v0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.Z2;
        if (photoViewAttacher != null) {
            photoViewAttacher.v0();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        PhotoViewAttacher photoViewAttacher = this.Z2;
        if (photoViewAttacher != null) {
            photoViewAttacher.v0();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.Z2;
        if (photoViewAttacher != null) {
            photoViewAttacher.v0();
        }
    }

    public void setMaximumScale(float f2) {
        this.Z2.Y(f2);
    }

    public void setMediumScale(float f2) {
        this.Z2.Z(f2);
    }

    public void setMinimumScale(float f2) {
        this.Z2.a0(f2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Z2.b0(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.Z2.c0(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Z2.d0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.Z2.e0(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.Z2.f0(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.Z2.g0(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.Z2.h0(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.Z2.i0(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.Z2.j0(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.Z2.k0(onViewTapListener);
    }

    public void setRotationBy(float f2) {
        this.Z2.l0(f2);
    }

    public void setRotationTo(float f2) {
        this.Z2.m0(f2);
    }

    public void setScale(float f2) {
        this.Z2.n0(f2);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.Z2;
        if (photoViewAttacher == null) {
            this.a3 = scaleType;
        } else {
            photoViewAttacher.r0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.Z2.t0(i2);
    }

    public void setZoomable(boolean z) {
        this.Z2.u0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
