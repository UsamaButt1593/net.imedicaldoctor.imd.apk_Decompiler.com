package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

@VisibleForTesting
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    private static final int G = 0;
    private static final int H = 1;
    private static final int I = 2;
    private static final int J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int N = 500;
    private static final int O = 1500;
    private static final int P = 1200;
    private static final int Q = 500;
    private static final int R = 255;
    private static final int[] S = {16842919};
    private static final int[] T = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.OnScrollListener C;

    /* renamed from: a  reason: collision with root package name */
    private final int f15332a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15333b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f15334c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f15335d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15336e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15337f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f15338g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f15339h;

    /* renamed from: i  reason: collision with root package name */
    private final int f15340i;

    /* renamed from: j  reason: collision with root package name */
    private final int f15341j;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    int f15342k;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    int f15343l;
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    float f15344m;
    @VisibleForTesting

    /* renamed from: n  reason: collision with root package name */
    int f15345n;
    @VisibleForTesting
    int o;
    @VisibleForTesting
    float p;
    private int q = 0;
    private int r = 0;
    private RecyclerView s;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final int[] x = new int[2];
    private final int[] y = new int[2];
    final ValueAnimator z;

    private class AnimatorListener extends AnimatorListenerAdapter {
        private boolean s = false;

        AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.s = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.s) {
                this.s = false;
            } else if (((Float) FastScroller.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.G(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.D();
            }
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f15334c.setAlpha(floatValue);
            FastScroller.this.f15335d.setAlpha(floatValue);
            FastScroller.this.D();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.z = ofFloat;
        this.A = 0;
        this.B = new Runnable() {
            public void run() {
                FastScroller.this.w(500);
            }
        };
        this.C = new RecyclerView.OnScrollListener() {
            public void b(RecyclerView recyclerView, int i2, int i3) {
                FastScroller.this.J(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.f15334c = stateListDrawable;
        this.f15335d = drawable;
        this.f15338g = stateListDrawable2;
        this.f15339h = drawable2;
        this.f15336e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f15337f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f15340i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f15341j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f15332a = i3;
        this.f15333b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        l(recyclerView);
    }

    private void E(int i2) {
        m();
        this.s.postDelayed(this.B, (long) i2);
    }

    private int F(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void H() {
        this.s.setItemDecoration(this);
        this.s.s(this);
        this.s.t(this.C);
    }

    private void K(float f2) {
        int[] t2 = t();
        float max = Math.max((float) t2[0], Math.min((float) t2[1], f2));
        if (Math.abs(((float) this.f15343l) - max) >= 2.0f) {
            int F2 = F(this.f15344m, max, t2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
            if (F2 != 0) {
                this.s.scrollBy(0, F2);
            }
            this.f15344m = max;
        }
    }

    private void m() {
        this.s.removeCallbacks(this.B);
    }

    private void n() {
        this.s.A1(this);
        this.s.D1(this);
        this.s.E1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i2 = this.r;
        int i3 = this.f15340i;
        int i4 = i2 - i3;
        int i5 = this.o;
        int i6 = this.f15345n;
        int i7 = i5 - (i6 / 2);
        this.f15338g.setBounds(0, 0, i6, i3);
        this.f15339h.setBounds(0, 0, this.q, this.f15341j);
        canvas.translate(0.0f, (float) i4);
        this.f15339h.draw(canvas);
        canvas.translate((float) i7, 0.0f);
        this.f15338g.draw(canvas);
        canvas.translate((float) (-i7), (float) (-i4));
    }

    private void p(Canvas canvas) {
        int i2 = this.q;
        int i3 = this.f15336e;
        int i4 = i2 - i3;
        int i5 = this.f15343l;
        int i6 = this.f15342k;
        int i7 = i5 - (i6 / 2);
        this.f15334c.setBounds(0, 0, i3, i6);
        this.f15335d.setBounds(0, 0, this.f15337f, this.r);
        if (z()) {
            this.f15335d.draw(canvas);
            canvas.translate((float) this.f15336e, (float) i7);
            canvas.scale(-1.0f, 1.0f);
            this.f15334c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            i4 = this.f15336e;
        } else {
            canvas.translate((float) i4, 0.0f);
            this.f15335d.draw(canvas);
            canvas.translate(0.0f, (float) i7);
            this.f15334c.draw(canvas);
        }
        canvas.translate((float) (-i4), (float) (-i7));
    }

    private int[] q() {
        int[] iArr = this.y;
        int i2 = this.f15333b;
        iArr[0] = i2;
        iArr[1] = this.q - i2;
        return iArr;
    }

    private int[] t() {
        int[] iArr = this.x;
        int i2 = this.f15333b;
        iArr[0] = i2;
        iArr[1] = this.r - i2;
        return iArr;
    }

    private void x(float f2) {
        int[] q2 = q();
        float max = Math.max((float) q2[0], Math.min((float) q2[1], f2));
        if (Math.abs(((float) this.o) - max) >= 2.0f) {
            int F2 = F(this.p, max, q2, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
            if (F2 != 0) {
                this.s.scrollBy(F2, 0);
            }
            this.p = max;
        }
    }

    private boolean z() {
        return ViewCompat.c0(this.s) == 1;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean A(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.f15340i))) {
            int i2 = this.o;
            int i3 = this.f15345n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean B(float f2, float f3) {
        if (!z() ? f2 >= ((float) (this.q - this.f15336e)) : f2 <= ((float) this.f15336e)) {
            int i2 = this.f15343l;
            int i3 = this.f15342k;
            return f3 >= ((float) (i2 - (i3 / 2))) && f3 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean C() {
        return this.v == 1;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.s.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void G(int i2) {
        int i3;
        if (i2 == 2 && this.v != 2) {
            this.f15334c.setState(S);
            m();
        }
        if (i2 == 0) {
            D();
        } else {
            I();
        }
        if (this.v != 2 || i2 == 2) {
            if (i2 == 1) {
                i3 = 1500;
            }
            this.v = i2;
        }
        this.f15334c.setState(T);
        i3 = P;
        E(i3);
        this.v = i2;
    }

    public void I() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.z.setDuration(500);
        this.z.setStartDelay(0);
        this.z.start();
    }

    /* access modifiers changed from: package-private */
    public void J(int i2, int i3) {
        int computeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i4 = this.r;
        this.t = computeVerticalScrollRange - i4 > 0 && i4 >= this.f15332a;
        int computeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i5 = this.q;
        boolean z2 = computeHorizontalScrollRange - i5 > 0 && i5 >= this.f15332a;
        this.u = z2;
        boolean z3 = this.t;
        if (z3 || z2) {
            if (z3) {
                float f2 = (float) i4;
                this.f15343l = (int) ((f2 * (((float) i3) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f15342k = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
            }
            if (this.u) {
                float f3 = (float) i5;
                this.o = (int) ((f3 * (((float) i2) + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f15345n = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
            }
            int i6 = this.v;
            if (i6 == 0 || i6 == 1) {
                G(1);
            }
        } else if (this.v != 0) {
            G(0);
        }
    }

    public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean B2 = B(motionEvent.getX(), motionEvent.getY());
                boolean A2 = A(motionEvent.getX(), motionEvent.getY());
                if (B2 || A2) {
                    if (A2) {
                        this.w = 1;
                        this.p = (float) ((int) motionEvent.getX());
                    } else if (B2) {
                        this.w = 2;
                        this.f15344m = (float) ((int) motionEvent.getY());
                    }
                    G(2);
                }
            } else if (motionEvent.getAction() == 1 && this.v == 2) {
                this.f15344m = 0.0f;
                this.p = 0.0f;
                G(1);
                this.w = 0;
            } else if (motionEvent.getAction() == 2 && this.v == 2) {
                I();
                if (this.w == 1) {
                    x(motionEvent.getX());
                }
                if (this.w == 2) {
                    K(motionEvent.getY());
                }
            }
        }
    }

    public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 != 1) {
            return i2 == 2;
        }
        boolean B2 = B(motionEvent.getX(), motionEvent.getY());
        boolean A2 = A(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!B2 && !A2) {
            return false;
        }
        if (A2) {
            this.w = 1;
            this.p = (float) ((int) motionEvent.getX());
        } else if (B2) {
            this.w = 2;
            this.f15344m = (float) ((int) motionEvent.getY());
        }
        G(2);
    }

    public void e(boolean z2) {
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            G(0);
        } else if (this.A != 0) {
            if (this.t) {
                p(canvas);
            }
            if (this.u) {
                o(canvas);
            }
        }
    }

    public void l(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                n();
            }
            this.s = recyclerView;
            if (recyclerView != null) {
                H();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable r() {
        return this.f15338g;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable s() {
        return this.f15339h;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable u() {
        return this.f15334c;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable v() {
        return this.f15335d;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void w(int i2) {
        int i3 = this.A;
        if (i3 == 1) {
            this.z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.z.setDuration((long) i2);
        this.z.start();
    }

    public boolean y() {
        return this.v == 2;
    }
}
