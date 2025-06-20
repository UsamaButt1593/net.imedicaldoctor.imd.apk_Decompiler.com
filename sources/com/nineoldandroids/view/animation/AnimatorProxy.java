package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation {
    public static final boolean j3 = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);
    private static final WeakHashMap<View, AnimatorProxy> k3 = new WeakHashMap<>();
    private final Camera X = new Camera();
    private float X2;
    private boolean Y;
    private float Y2;
    private float Z = 1.0f;
    private float Z2;
    private float a3;
    private float b3;
    private float c3 = 1.0f;
    private float d3 = 1.0f;
    private float e3;
    private float f3;
    private final RectF g3 = new RectF();
    private final RectF h3 = new RectF();
    private final Matrix i3 = new Matrix();
    private final WeakReference<View> s;

    private AnimatorProxy(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.s = new WeakReference<>(view);
    }

    private void K(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.Y;
        float f2 = z ? this.X2 : width / 2.0f;
        float f4 = z ? this.Y2 : height / 2.0f;
        float f5 = this.Z2;
        float f6 = this.a3;
        float f7 = this.b3;
        if (!(f5 == 0.0f && f6 == 0.0f && f7 == 0.0f)) {
            Camera camera = this.X;
            camera.save();
            camera.rotateX(f5);
            camera.rotateY(f6);
            camera.rotateZ(-f7);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f4);
            matrix.postTranslate(f2, f4);
        }
        float f8 = this.c3;
        float f9 = this.d3;
        if (!(f8 == 1.0f && f9 == 1.0f)) {
            matrix.postScale(f8, f9);
            matrix.postTranslate((-(f2 / width)) * ((f8 * width) - width), (-(f4 / height)) * ((f9 * height) - height));
        }
        matrix.postTranslate(this.e3, this.f3);
    }

    public static AnimatorProxy L(View view) {
        WeakHashMap<View, AnimatorProxy> weakHashMap = k3;
        AnimatorProxy animatorProxy = weakHashMap.get(view);
        if (animatorProxy != null && animatorProxy == view.getAnimation()) {
            return animatorProxy;
        }
        AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
        weakHashMap.put(view, animatorProxy2);
        return animatorProxy2;
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.i3;
        matrix.reset();
        K(matrix, view);
        this.i3.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        float f2 = rectF.right;
        float f4 = rectF.left;
        if (f2 < f4) {
            rectF.right = f4;
            rectF.left = f2;
        }
        float f5 = rectF.bottom;
        float f6 = rectF.top;
        if (f5 < f6) {
            rectF.top = f5;
            rectF.bottom = f6;
        }
    }

    private void r() {
        View view = this.s.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.h3;
            a(rectF, view);
            rectF.union(this.g3);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void s() {
        View view = this.s.get();
        if (view != null) {
            a(this.g3, view);
        }
    }

    public void A(float f2) {
        if (this.d3 != f2) {
            s();
            this.d3 = f2;
            r();
        }
    }

    public void B(int i2) {
        View view = this.s.get();
        if (view != null) {
            view.scrollTo(i2, view.getScrollY());
        }
    }

    public void D(int i2) {
        View view = this.s.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i2);
        }
    }

    public void E(float f2) {
        if (this.e3 != f2) {
            s();
            this.e3 = f2;
            r();
        }
    }

    public void F(float f2) {
        if (this.f3 != f2) {
            s();
            this.f3 = f2;
            r();
        }
    }

    public void G(float f2) {
        View view = this.s.get();
        if (view != null) {
            E(f2 - ((float) view.getLeft()));
        }
    }

    public void J(float f2) {
        View view = this.s.get();
        if (view != null) {
            F(f2 - ((float) view.getTop()));
        }
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        View view = this.s.get();
        if (view != null) {
            transformation.setAlpha(this.Z);
            K(transformation.getMatrix(), view);
        }
    }

    public float b() {
        return this.Z;
    }

    public float c() {
        return this.X2;
    }

    public float d() {
        return this.Y2;
    }

    public float e() {
        return this.b3;
    }

    public float f() {
        return this.Z2;
    }

    public float g() {
        return this.a3;
    }

    public float h() {
        return this.c3;
    }

    public float i() {
        return this.d3;
    }

    public int l() {
        View view = this.s.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int m() {
        View view = this.s.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float n() {
        return this.e3;
    }

    public float o() {
        return this.f3;
    }

    public float p() {
        View view = this.s.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.e3;
    }

    public float q() {
        View view = this.s.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f3;
    }

    public void t(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            View view = this.s.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void u(float f2) {
        if (!this.Y || this.X2 != f2) {
            s();
            this.Y = true;
            this.X2 = f2;
            r();
        }
    }

    public void v(float f2) {
        if (!this.Y || this.Y2 != f2) {
            s();
            this.Y = true;
            this.Y2 = f2;
            r();
        }
    }

    public void w(float f2) {
        if (this.b3 != f2) {
            s();
            this.b3 = f2;
            r();
        }
    }

    public void x(float f2) {
        if (this.Z2 != f2) {
            s();
            this.Z2 = f2;
            r();
        }
    }

    public void y(float f2) {
        if (this.a3 != f2) {
            s();
            this.a3 = f2;
            r();
        }
    }

    public void z(float f2) {
        if (this.c3 != f2) {
            s();
            this.c3 = f2;
            r();
        }
    }
}
