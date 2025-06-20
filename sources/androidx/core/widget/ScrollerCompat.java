package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat {

    /* renamed from: a  reason: collision with root package name */
    OverScroller f6763a;

    ScrollerCompat(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator == null) {
            overScroller = new OverScroller(context);
        }
        this.f6763a = overScroller;
    }

    @Deprecated
    public static ScrollerCompat c(Context context) {
        return d(context, (Interpolator) null);
    }

    @Deprecated
    public static ScrollerCompat d(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void a() {
        this.f6763a.abortAnimation();
    }

    @Deprecated
    public boolean b() {
        return this.f6763a.computeScrollOffset();
    }

    @Deprecated
    public void e(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f6763a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Deprecated
    public void f(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f6763a.fling(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    @Deprecated
    public float g() {
        return this.f6763a.getCurrVelocity();
    }

    @Deprecated
    public int h() {
        return this.f6763a.getCurrX();
    }

    @Deprecated
    public int i() {
        return this.f6763a.getCurrY();
    }

    @Deprecated
    public int j() {
        return this.f6763a.getFinalX();
    }

    @Deprecated
    public int k() {
        return this.f6763a.getFinalY();
    }

    @Deprecated
    public boolean l() {
        return this.f6763a.isFinished();
    }

    @Deprecated
    public boolean m() {
        return this.f6763a.isOverScrolled();
    }

    @Deprecated
    public void n(int i2, int i3, int i4) {
        this.f6763a.notifyHorizontalEdgeReached(i2, i3, i4);
    }

    @Deprecated
    public void o(int i2, int i3, int i4) {
        this.f6763a.notifyVerticalEdgeReached(i2, i3, i4);
    }

    @Deprecated
    public boolean p(int i2, int i3, int i4, int i5, int i6, int i7) {
        return this.f6763a.springBack(i2, i3, i4, i5, i6, i7);
    }

    @Deprecated
    public void q(int i2, int i3, int i4, int i5) {
        this.f6763a.startScroll(i2, i3, i4, i5);
    }

    @Deprecated
    public void r(int i2, int i3, int i4, int i5, int i6) {
        this.f6763a.startScroll(i2, i3, i4, i5, i6);
    }
}
