package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 4;
    public static final int F = 8;
    public static final int G = 15;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    private static final int K = 20;
    private static final int L = 256;
    private static final int M = 600;
    private static final Interpolator N = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final String x = "ViewDragHelper";
    public static final int y = -1;
    public static final int z = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f6880a;

    /* renamed from: b  reason: collision with root package name */
    private int f6881b;

    /* renamed from: c  reason: collision with root package name */
    private int f6882c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f6883d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f6884e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f6885f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f6886g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f6887h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f6888i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f6889j;

    /* renamed from: k  reason: collision with root package name */
    private int f6890k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f6891l;

    /* renamed from: m  reason: collision with root package name */
    private float f6892m;

    /* renamed from: n  reason: collision with root package name */
    private float f6893n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r;
    private final Callback s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private final Runnable w = new Runnable() {
        public void run() {
            ViewDragHelper.this.R(0);
        }
    };

    public static abstract class Callback {
        public int a(@NonNull View view, int i2, int i3) {
            return 0;
        }

        public int b(@NonNull View view, int i2, int i3) {
            return 0;
        }

        public int c(int i2) {
            return i2;
        }

        public int d(@NonNull View view) {
            return 0;
        }

        public int e(@NonNull View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(@NonNull View view, int i2) {
        }

        public void j(int i2) {
        }

        public void k(@NonNull View view, int i2, int i3, @Px int i4, @Px int i5) {
        }

        public void l(@NonNull View view, float f2, float f3) {
        }

        public abstract boolean m(@NonNull View view, int i2);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.v = viewGroup;
            this.s = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.p = i2;
            this.o = i2;
            this.f6881b = viewConfiguration.getScaledTouchSlop();
            this.f6892m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f6893n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, N);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private int C(int i2, int i3) {
        int i4 = i2 < this.v.getLeft() + this.o ? 1 : 0;
        if (i3 < this.v.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.v.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.v.getBottom() - this.o ? i4 | 8 : i4;
    }

    private boolean K(int i2) {
        if (J(i2)) {
            return true;
        }
        Log.e(x, "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void N() {
        this.f6891l.computeCurrentVelocity(1000, this.f6892m);
        r(i(this.f6891l.getXVelocity(this.f6882c), this.f6893n, this.f6892m), i(this.f6891l.getYVelocity(this.f6882c), this.f6893n, this.f6892m));
    }

    private void O(float f2, float f3, int i2) {
        boolean e2 = e(f2, f3, i2, 1);
        if (e(f3, f2, i2, 4)) {
            e2 |= true;
        }
        if (e(f2, f3, i2, 2)) {
            e2 |= true;
        }
        if (e(f3, f2, i2, 8)) {
            e2 |= true;
        }
        if (e2) {
            int[] iArr = this.f6888i;
            iArr[i2] = iArr[i2] | e2;
            this.s.f(e2 ? 1 : 0, i2);
        }
    }

    private void P(float f2, float f3, int i2) {
        u(i2);
        float[] fArr = this.f6883d;
        this.f6885f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f6884e;
        this.f6886g[i2] = f3;
        fArr2[i2] = f3;
        this.f6887h[i2] = C((int) f2, (int) f3);
        this.f6890k |= 1 << i2;
    }

    private void Q(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (K(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f6885f[pointerId] = x2;
                this.f6886g[pointerId] = y2;
            }
        }
    }

    private boolean e(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f6887h[i2] & i3) != i3 || (this.q & i3) == 0 || (this.f6889j[i2] & i3) == i3 || (this.f6888i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f6881b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.s.g(i3)) {
            return (this.f6888i[i2] & i3) == 0 && abs > ((float) this.f6881b);
        }
        int[] iArr = this.f6889j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean h(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.s.d(view) > 0;
        boolean z3 = this.s.e(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f6881b) : z3 && Math.abs(f3) > ((float) this.f6881b);
        }
        int i2 = this.f6881b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    private float i(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    private int j(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    private void k() {
        float[] fArr = this.f6883d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f6884e, 0.0f);
            Arrays.fill(this.f6885f, 0.0f);
            Arrays.fill(this.f6886g, 0.0f);
            Arrays.fill(this.f6887h, 0);
            Arrays.fill(this.f6888i, 0);
            Arrays.fill(this.f6889j, 0);
            this.f6890k = 0;
        }
    }

    private void l(int i2) {
        if (this.f6883d != null && J(i2)) {
            this.f6883d[i2] = 0.0f;
            this.f6884e[i2] = 0.0f;
            this.f6885f[i2] = 0.0f;
            this.f6886g[i2] = 0.0f;
            this.f6887h[i2] = 0;
            this.f6888i[i2] = 0;
            this.f6889j[i2] = 0;
            this.f6890k = (~(1 << i2)) & this.f6890k;
        }
    }

    private int m(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = (float) (width / 2);
        float s2 = f2 + (s(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(s2 / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f), 600);
    }

    private int n(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int j2 = j(i4, (int) this.f6893n, (int) this.f6892m);
        int j3 = j(i5, (int) this.f6893n, (int) this.f6892m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(j2);
        int abs4 = Math.abs(j3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (j2 != 0) {
            f2 = (float) abs3;
            f3 = (float) i6;
        } else {
            f2 = (float) abs;
            f3 = (float) i7;
        }
        float f6 = f2 / f3;
        if (j3 != 0) {
            f4 = (float) abs4;
            f5 = (float) i6;
        } else {
            f4 = (float) abs2;
            f5 = (float) i7;
        }
        float f7 = f4 / f5;
        return (int) ((((float) m(i2, j2, this.s.d(view))) * f6) + (((float) m(i3, j3, this.s.e(view))) * f7));
    }

    public static ViewDragHelper p(@NonNull ViewGroup viewGroup, float f2, @NonNull Callback callback) {
        ViewDragHelper q2 = q(viewGroup, callback);
        q2.f6881b = (int) (((float) q2.f6881b) * (1.0f / f2));
        return q2;
    }

    public static ViewDragHelper q(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void r(float f2, float f3) {
        this.u = true;
        this.s.l(this.t, f2, f3);
        this.u = false;
        if (this.f6880a == 1) {
            R(0);
        }
    }

    private float s(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private void t(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i4 != 0) {
            i2 = this.s.a(this.t, i2, i4);
            ViewCompat.i1(this.t, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.s.b(this.t, i3, i5);
            ViewCompat.j1(this.t, i3 - top);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            this.s.k(this.t, i6, i7, i6 - left, i7 - top);
        }
    }

    private void u(int i2) {
        float[] fArr = this.f6883d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f6884e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f6885f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f6886g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f6887h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6888i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6889j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6883d = fArr2;
            this.f6884e = fArr3;
            this.f6885f = fArr4;
            this.f6886g = fArr5;
            this.f6887h = iArr;
            this.f6888i = iArr2;
            this.f6889j = iArr3;
        }
    }

    private boolean x(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            R(0);
            return false;
        }
        this.r.startScroll(left, top, i6, i7, n(this.t, i6, i7, i4, i5));
        R(2);
        return true;
    }

    @Px
    public int A() {
        return this.p;
    }

    @Px
    public int B() {
        return this.o;
    }

    public float D() {
        return this.f6893n;
    }

    @Px
    public int E() {
        return this.f6881b;
    }

    public int F() {
        return this.f6880a;
    }

    public boolean G(int i2, int i3) {
        return L(this.t, i2, i3);
    }

    public boolean H(int i2) {
        int length = this.f6887h.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (I(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean I(int i2, int i3) {
        return J(i3) && (i2 & this.f6887h[i3]) != 0;
    }

    public boolean J(int i2) {
        return ((1 << i2) & this.f6890k) != 0;
    }

    public boolean L(@Nullable View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void M(@NonNull MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.f6891l == null) {
            this.f6891l = VelocityTracker.obtain();
        }
        this.f6891l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f6880a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i3 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i3);
                            if (K(pointerId)) {
                                float x2 = motionEvent.getX(i3);
                                float y2 = motionEvent.getY(i3);
                                float f2 = x2 - this.f6883d[pointerId];
                                float f3 = y2 - this.f6884e[pointerId];
                                O(f2, f3, pointerId);
                                if (this.f6880a != 1) {
                                    View v2 = v((int) x2, (int) y2);
                                    if (h(v2, f2, f3) && Y(v2, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i3++;
                        }
                    } else if (K(this.f6882c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f6882c);
                        float x3 = motionEvent.getX(findPointerIndex);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f6885f;
                        int i4 = this.f6882c;
                        int i5 = (int) (x3 - fArr[i4]);
                        int i6 = (int) (y3 - this.f6886g[i4]);
                        t(this.t.getLeft() + i5, this.t.getTop() + i6, i5, i6);
                    } else {
                        return;
                    }
                    Q(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x4 = motionEvent.getX(actionIndex);
                        float y4 = motionEvent.getY(actionIndex);
                        P(x4, y4, pointerId2);
                        if (this.f6880a == 0) {
                            Y(v((int) x4, (int) y4), pointerId2);
                            int i7 = this.f6887h[pointerId2];
                            int i8 = this.q;
                            if ((i7 & i8) != 0) {
                                this.s.h(i7 & i8, pointerId2);
                                return;
                            }
                            return;
                        } else if (G((int) x4, (int) y4)) {
                            Y(this.t, pointerId2);
                            return;
                        } else {
                            return;
                        }
                    } else if (actionMasked == 6) {
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        if (this.f6880a == 1 && pointerId3 == this.f6882c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i3 >= pointerCount2) {
                                    i2 = -1;
                                    break;
                                }
                                int pointerId4 = motionEvent.getPointerId(i3);
                                if (pointerId4 != this.f6882c) {
                                    View v3 = v((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                                    View view = this.t;
                                    if (v3 == view && Y(view, pointerId4)) {
                                        i2 = this.f6882c;
                                        break;
                                    }
                                }
                                i3++;
                            }
                            if (i2 == -1) {
                                N();
                            }
                        }
                        l(pointerId3);
                        return;
                    } else {
                        return;
                    }
                } else if (this.f6880a == 1) {
                    r(0.0f, 0.0f);
                }
            } else if (this.f6880a == 1) {
                N();
            }
            c();
            return;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View v4 = v((int) x5, (int) y5);
        P(x5, y5, pointerId5);
        Y(v4, pointerId5);
        int i9 = this.f6887h[pointerId5];
        int i10 = this.q;
        if ((i9 & i10) != 0) {
            this.s.h(i9 & i10, pointerId5);
        }
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        this.v.removeCallbacks(this.w);
        if (this.f6880a != i2) {
            this.f6880a = i2;
            this.s.j(i2);
            if (this.f6880a == 0) {
                this.t = null;
            }
        }
    }

    public void S(@Px @IntRange(from = 0) int i2) {
        this.o = i2;
    }

    public void T(int i2) {
        this.q = i2;
    }

    public void U(float f2) {
        this.f6893n = f2;
    }

    public boolean V(int i2, int i3) {
        if (this.u) {
            return x(i2, i3, (int) this.f6891l.getXVelocity(this.f6882c), (int) this.f6891l.getYVelocity(this.f6882c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean W(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.c()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f6891l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f6891l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f6891l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.l(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.P(r7, r1, r2)
            int r3 = r0.f6880a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f6887h
            r1 = r1[r2]
            int r3 = r0.q
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.s
            r1 = r1 & r3
            r4.h(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.v(r3, r1)
            android.view.View r3 = r0.t
            if (r1 != r3) goto L_0x0031
            r0.Y(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f6883d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f6884e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.K(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f6883d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f6884e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.v(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.h(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.s
            int r12 = r14.a(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.s
            int r5 = r5.b(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.s
            int r14 = r14.d(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.s
            int r15 = r15.e(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.O(r9, r10, r4)
            int r5 = r0.f6880a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.Y(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.Q(r17)
            goto L_0x0031
        L_0x00ff:
            r16.c()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.P(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.v(r2, r3)
            android.view.View r3 = r0.t
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f6880a
            if (r3 != r4) goto L_0x0125
            r0.Y(r2, r1)
        L_0x0125:
            int[] r2 = r0.f6887h
            r2 = r2[r1]
            int r3 = r0.q
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.s
            r2 = r2 & r3
            r4.h(r2, r1)
        L_0x0135:
            int r1 = r0.f6880a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.W(android.view.MotionEvent):boolean");
    }

    public boolean X(@NonNull View view, int i2, int i3) {
        this.t = view;
        this.f6882c = -1;
        boolean x2 = x(i2, i3, 0, 0);
        if (!x2 && this.f6880a == 0 && this.t != null) {
            this.t = null;
        }
        return x2;
    }

    /* access modifiers changed from: package-private */
    public boolean Y(View view, int i2) {
        if (view == this.t && this.f6882c == i2) {
            return true;
        }
        if (view == null || !this.s.m(view, i2)) {
            return false;
        }
        this.f6882c = i2;
        d(view, i2);
        return true;
    }

    public void a() {
        c();
        if (this.f6880a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.k(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        R(0);
    }

    /* access modifiers changed from: protected */
    public boolean b(@NonNull View view, boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom()) {
                    if (b(childAt, true, i2, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z2 && (view.canScrollHorizontally(-i2) || view.canScrollVertically(-i3));
    }

    public void c() {
        this.f6882c = -1;
        k();
        VelocityTracker velocityTracker = this.f6891l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6891l = null;
        }
    }

    public void d(@NonNull View view, int i2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.f6882c = i2;
            this.s.i(view, i2);
            R(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean f(int i2) {
        int length = this.f6883d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (g(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i2, int i3) {
        if (!J(i3)) {
            return false;
        }
        boolean z2 = (i2 & 1) == 1;
        boolean z3 = (i2 & 2) == 2;
        float f2 = this.f6885f[i3] - this.f6883d[i3];
        float f3 = this.f6886g[i3] - this.f6884e[i3];
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f6881b) : z3 && Math.abs(f3) > ((float) this.f6881b);
        }
        int i4 = this.f6881b;
        return (f2 * f2) + (f3 * f3) > ((float) (i4 * i4));
    }

    public boolean o(boolean z2) {
        if (this.f6880a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                ViewCompat.i1(this.t, left);
            }
            if (top != 0) {
                ViewCompat.j1(this.t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.s.k(this.t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z2) {
                    this.v.post(this.w);
                } else {
                    R(0);
                }
            }
        }
        return this.f6880a == 2;
    }

    @Nullable
    public View v(int i2, int i3) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void w(int i2, int i3, int i4, int i5) {
        if (this.u) {
            this.r.fling(this.t.getLeft(), this.t.getTop(), (int) this.f6891l.getXVelocity(this.f6882c), (int) this.f6891l.getYVelocity(this.f6882c), i2, i4, i3, i5);
            R(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int y() {
        return this.f6882c;
    }

    @Nullable
    public View z() {
        return this.t;
    }
}
