package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

abstract class CarouselOrientationHelper {

    /* renamed from: a  reason: collision with root package name */
    final int f20936a;

    private CarouselOrientationHelper(int i2) {
        this.f20936a = i2;
    }

    private static CarouselOrientationHelper b(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) {
            public void a(RectF rectF, RectF rectF2, RectF rectF3) {
                float f2 = rectF2.left;
                float f3 = rectF3.left;
                if (f2 < f3 && rectF2.right > f3) {
                    float f4 = f3 - f2;
                    rectF.left += f4;
                    rectF2.left += f4;
                }
                float f5 = rectF2.right;
                float f6 = rectF3.right;
                if (f5 > f6 && rectF2.left < f6) {
                    float f7 = f5 - f6;
                    rectF.right = Math.max(rectF.right - f7, rectF.left);
                    rectF2.right = Math.max(rectF2.right - f7, rectF2.left);
                }
            }

            /* access modifiers changed from: package-private */
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.e0(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public float f(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.rightMargin + layoutParams.leftMargin);
            }

            public RectF g(float f2, float f3, float f4, float f5) {
                return new RectF(f5, 0.0f, f3 - f5, f2);
            }

            /* access modifiers changed from: package-private */
            public int h() {
                return carouselLayoutManager.j0() - carouselLayoutManager.q0();
            }

            /* access modifiers changed from: package-private */
            public int i() {
                return carouselLayoutManager.e3() ? j() : k();
            }

            /* access modifiers changed from: package-private */
            public int j() {
                return 0;
            }

            /* access modifiers changed from: package-private */
            public int k() {
                return carouselLayoutManager.D0();
            }

            /* access modifiers changed from: package-private */
            public int l() {
                return carouselLayoutManager.e3() ? k() : j();
            }

            /* access modifiers changed from: package-private */
            public int m() {
                return carouselLayoutManager.v0();
            }

            public void n(View view, int i2, int i3) {
                int m2 = m();
                carouselLayoutManager.T0(view, i2, m2, i3, m2 + e(view));
            }

            public void o(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    float floor = ((float) Math.floor((double) rectF.right)) - 1.0f;
                    rectF.right = floor;
                    rectF.left = Math.min(rectF.left, floor);
                }
                if (rectF2.left >= rectF3.right) {
                    float ceil = ((float) Math.ceil((double) rectF.left)) + 1.0f;
                    rectF.left = ceil;
                    rectF.right = Math.max(ceil, rectF.right);
                }
            }

            public void p(View view, Rect rect, float f2, float f3) {
                view.offsetLeftAndRight((int) (f3 - (((float) rect.left) + f2)));
            }
        };
    }

    static CarouselOrientationHelper c(CarouselLayoutManager carouselLayoutManager, int i2) {
        if (i2 == 0) {
            return b(carouselLayoutManager);
        }
        if (i2 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static CarouselOrientationHelper d(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) {
            public void a(RectF rectF, RectF rectF2, RectF rectF3) {
                float f2 = rectF2.top;
                float f3 = rectF3.top;
                if (f2 < f3 && rectF2.bottom > f3) {
                    float f4 = f3 - f2;
                    rectF.top += f4;
                    rectF3.top += f4;
                }
                float f5 = rectF2.bottom;
                float f6 = rectF3.bottom;
                if (f5 > f6 && rectF2.top < f6) {
                    float f7 = f5 - f6;
                    rectF.bottom = Math.max(rectF.bottom - f7, rectF.top);
                    rectF2.bottom = Math.max(rectF2.bottom - f7, rectF2.top);
                }
            }

            /* access modifiers changed from: package-private */
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.f0(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public float f(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.topMargin + layoutParams.bottomMargin);
            }

            public RectF g(float f2, float f3, float f4, float f5) {
                return new RectF(0.0f, f4, f3, f2 - f4);
            }

            /* access modifiers changed from: package-private */
            public int h() {
                return carouselLayoutManager.j0();
            }

            /* access modifiers changed from: package-private */
            public int i() {
                return h();
            }

            /* access modifiers changed from: package-private */
            public int j() {
                return carouselLayoutManager.s0();
            }

            /* access modifiers changed from: package-private */
            public int k() {
                return carouselLayoutManager.D0() - carouselLayoutManager.t0();
            }

            /* access modifiers changed from: package-private */
            public int l() {
                return m();
            }

            /* access modifiers changed from: package-private */
            public int m() {
                return 0;
            }

            public void n(View view, int i2, int i3) {
                int j2 = j();
                carouselLayoutManager.T0(view, j2, i2, j2 + e(view), i3);
            }

            public void o(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    float floor = ((float) Math.floor((double) rectF.bottom)) - 1.0f;
                    rectF.bottom = floor;
                    rectF.top = Math.min(rectF.top, floor);
                }
                if (rectF2.top >= rectF3.bottom) {
                    float ceil = ((float) Math.ceil((double) rectF.top)) + 1.0f;
                    rectF.top = ceil;
                    rectF.bottom = Math.max(ceil, rectF.bottom);
                }
            }

            public void p(View view, Rect rect, float f2, float f3) {
                view.offsetTopAndBottom((int) (f3 - (((float) rect.top) + f2)));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    /* access modifiers changed from: package-private */
    public abstract int e(View view);

    /* access modifiers changed from: package-private */
    public abstract float f(RecyclerView.LayoutParams layoutParams);

    /* access modifiers changed from: package-private */
    public abstract RectF g(float f2, float f3, float f4, float f5);

    /* access modifiers changed from: package-private */
    public abstract int h();

    /* access modifiers changed from: package-private */
    public abstract int i();

    /* access modifiers changed from: package-private */
    public abstract int j();

    /* access modifiers changed from: package-private */
    public abstract int k();

    /* access modifiers changed from: package-private */
    public abstract int l();

    /* access modifiers changed from: package-private */
    public abstract int m();

    /* access modifiers changed from: package-private */
    public abstract void n(View view, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void o(RectF rectF, RectF rectF2, RectF rectF3);

    /* access modifiers changed from: package-private */
    public abstract void p(View view, Rect rect, float f2, float f3);
}
