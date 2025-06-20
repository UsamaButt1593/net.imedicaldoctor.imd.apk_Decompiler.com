package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse {
    private static final String G = "TouchResponse";
    private static final boolean H = false;
    private static final int I = 1000;
    private static final float J = 1.0E-7f;
    private static final float[][] K = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] L = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int P = 3;
    private static final int Q = 4;
    private static final int R = 5;
    private static final int S = 0;
    private static final int T = 1;
    private static final int U = 2;
    private static final int V = 3;
    private static final int W = 4;
    private static final int X = 5;
    private static final int Y = 6;
    static final int Z = 1;
    static final int a0 = 2;
    static final int b0 = 4;
    public static final int c0 = 0;
    public static final int d0 = 1;
    private float A = 10.0f;
    private float B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f4550a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4551b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f4552c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f4553d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f4554e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f4555f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f4556g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private float f4557h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    float f4558i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    float f4559j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private int f4560k = -1;

    /* renamed from: l  reason: collision with root package name */
    boolean f4561l = false;

    /* renamed from: m  reason: collision with root package name */
    private float f4562m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f4563n = 1.0f;
    private boolean o = false;
    private float[] p = new float[2];
    private int[] q = new int[2];
    private float r;
    private float s;
    private final MotionLayout t;
    private float u = 4.0f;
    private float v = 1.2f;
    private boolean w = true;
    private float x = 1.0f;
    private int y = 0;
    private float z = 10.0f;

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == R.styleable.Rk) {
                this.f4553d = typedArray.getResourceId(index, this.f4553d);
            } else if (index == R.styleable.Sk) {
                int i3 = typedArray.getInt(index, this.f4550a);
                this.f4550a = i3;
                float[] fArr = K[i3];
                this.f4557h = fArr[0];
                this.f4556g = fArr[1];
            } else if (index == R.styleable.Ck) {
                int i4 = typedArray.getInt(index, this.f4551b);
                this.f4551b = i4;
                float[][] fArr2 = L;
                if (i4 < fArr2.length) {
                    float[] fArr3 = fArr2[i4];
                    this.f4562m = fArr3[0];
                    this.f4563n = fArr3[1];
                } else {
                    this.f4563n = Float.NaN;
                    this.f4562m = Float.NaN;
                    this.f4561l = true;
                }
            } else if (index == R.styleable.Hk) {
                this.u = typedArray.getFloat(index, this.u);
            } else if (index == R.styleable.Gk) {
                this.v = typedArray.getFloat(index, this.v);
            } else if (index == R.styleable.Ik) {
                this.w = typedArray.getBoolean(index, this.w);
            } else if (index == R.styleable.Dk) {
                this.x = typedArray.getFloat(index, this.x);
            } else if (index == R.styleable.Ek) {
                this.z = typedArray.getFloat(index, this.z);
            } else if (index == R.styleable.Tk) {
                this.f4554e = typedArray.getResourceId(index, this.f4554e);
            } else if (index == R.styleable.Kk) {
                this.f4552c = typedArray.getInt(index, this.f4552c);
            } else if (index == R.styleable.Jk) {
                this.y = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.Fk) {
                this.f4555f = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.Lk) {
                this.f4560k = typedArray.getResourceId(index, this.f4560k);
            } else if (index == R.styleable.Nk) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R.styleable.Ok) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R.styleable.Pk) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R.styleable.Qk) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R.styleable.Mk) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R.styleable.Bk) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Ak);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void A(float f2, float f3) {
        this.r = f2;
        this.s = f3;
    }

    public void B(float f2) {
        this.v = f2;
    }

    public void C(float f2) {
        this.u = f2;
    }

    public void D(boolean z2) {
        if (z2) {
            float[][] fArr = L;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = K;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = L;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = K;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = K[this.f4550a];
        this.f4557h = fArr5[0];
        this.f4556g = fArr5[1];
        int i2 = this.f4551b;
        float[][] fArr6 = L;
        if (i2 < fArr6.length) {
            float[] fArr7 = fArr6[i2];
            this.f4562m = fArr7[0];
            this.f4563n = fArr7[1];
        }
    }

    public void E(float f2, float f3) {
        this.f4557h = f2;
        this.f4556g = f3;
    }

    public void F(int i2) {
        this.f4552c = i2;
    }

    /* access modifiers changed from: package-private */
    public void G(float f2, float f3) {
        this.r = f2;
        this.s = f3;
        this.o = false;
    }

    /* access modifiers changed from: package-private */
    public void H() {
        View view;
        int i2 = this.f4553d;
        if (i2 != -1) {
            view = this.t.findViewById(i2);
            if (view == null) {
                Log.e(G, "cannot find TouchAnchorId @id/" + Debug.i(this.t.getContext(), this.f4553d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener(this) {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) {
                public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f2, float f3) {
        return (f2 * this.f4562m) + (f3 * this.f4563n);
    }

    public int d() {
        return this.f4553d;
    }

    public int e() {
        return this.F;
    }

    public int f() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public RectF g(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f4555f;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f4555f;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.v;
    }

    public float j() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public float l(float f2, float f3) {
        this.t.A0(this.f4553d, this.t.getProgress(), this.f4557h, this.f4556g, this.p);
        float f4 = this.f4562m;
        if (f4 != 0.0f) {
            float[] fArr = this.p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f2 * f4) / fArr[0];
        }
        float[] fArr2 = this.p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f3 * this.f4563n) / fArr2[1];
    }

    public int m() {
        return this.E;
    }

    public float n() {
        return this.A;
    }

    public float o() {
        return this.B;
    }

    public float p() {
        return this.C;
    }

    public float q() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public RectF r(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f4554e;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f4554e;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return this.o;
    }

    public String toString() {
        if (Float.isNaN(this.f4562m)) {
            return Key.f4369i;
        }
        return this.f4562m + " , " + this.f4563n;
    }

    /* access modifiers changed from: package-private */
    public void u(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i2, MotionScene motionScene) {
        int i3;
        MotionLayout.MotionTracker motionTracker2 = motionTracker;
        if (this.f4561l) {
            v(motionEvent, motionTracker, i2, motionScene);
            return;
        }
        motionTracker2.d(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
        } else if (action == 1) {
            this.o = false;
            motionTracker2.g(1000);
            float f2 = motionTracker.f();
            float e2 = motionTracker.e();
            float progress = this.t.getProgress();
            int i4 = this.f4553d;
            if (i4 != -1) {
                this.t.A0(i4, progress, this.f4557h, this.f4556g, this.p);
            } else {
                float min = (float) Math.min(this.t.getWidth(), this.t.getHeight());
                float[] fArr = this.p;
                fArr[1] = this.f4563n * min;
                fArr[0] = min * this.f4562m;
            }
            float f3 = this.f4562m;
            float[] fArr2 = this.p;
            float f4 = f3 != 0.0f ? f2 / fArr2[0] : e2 / fArr2[1];
            float f5 = !Float.isNaN(f4) ? (f4 / 3.0f) + progress : progress;
            if (f5 != 0.0f && f5 != 1.0f && (i3 = this.f4552c) != 3) {
                float f6 = ((double) f5) < 0.5d ? 0.0f : 1.0f;
                if (i3 == 6) {
                    if (progress + f4 < 0.0f) {
                        f4 = Math.abs(f4);
                    }
                    f6 = 1.0f;
                }
                if (this.f4552c == 7) {
                    if (progress + f4 > 1.0f) {
                        f4 = -Math.abs(f4);
                    }
                    f6 = 0.0f;
                }
                this.t.b1(this.f4552c, f6, f4);
                if (0.0f < progress && 1.0f > progress) {
                    return;
                }
            } else if (0.0f < f5 && 1.0f > f5) {
                return;
            }
            this.t.setState(MotionLayout.TransitionState.FINISHED);
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.s;
            float rawX = motionEvent.getRawX() - this.r;
            if (Math.abs((this.f4562m * rawX) + (this.f4563n * rawY)) > this.z || this.o) {
                float progress2 = this.t.getProgress();
                if (!this.o) {
                    this.o = true;
                    this.t.setProgress(progress2);
                }
                int i5 = this.f4553d;
                if (i5 != -1) {
                    this.t.A0(i5, progress2, this.f4557h, this.f4556g, this.p);
                } else {
                    float min2 = (float) Math.min(this.t.getWidth(), this.t.getHeight());
                    float[] fArr3 = this.p;
                    fArr3[1] = this.f4563n * min2;
                    fArr3[0] = min2 * this.f4562m;
                }
                float f7 = this.f4562m;
                float[] fArr4 = this.p;
                if (((double) Math.abs(((f7 * fArr4[0]) + (this.f4563n * fArr4[1])) * this.x)) < 0.01d) {
                    float[] fArr5 = this.p;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                float max = Math.max(Math.min(progress2 + (this.f4562m != 0.0f ? rawX / this.p[0] : rawY / this.p[1]), 1.0f), 0.0f);
                if (this.f4552c == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.f4552c == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.t.getProgress();
                if (max != progress3) {
                    int i6 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i6 == 0 || progress3 == 1.0f) {
                        this.t.t0(i6 == 0);
                    }
                    this.t.setProgress(max);
                    motionTracker2.g(1000);
                    this.t.H3 = this.f4562m != 0.0f ? motionTracker.f() / this.p[0] : motionTracker.e() / this.p[1];
                } else {
                    this.t.H3 = 0.0f;
                }
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0317  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r25, int r26, androidx.constraintlayout.motion.widget.MotionScene r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r2 = r24
            r1.d(r2)
            int r3 = r24.getAction()
            r4 = 0
            if (r3 == 0) goto L_0x032a
            r5 = 1135869952(0x43b40000, float:360.0)
            r6 = -1
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1
            if (r3 == r10) goto L_0x01c4
            r11 = 2
            if (r3 == r11) goto L_0x001d
            goto L_0x0338
        L_0x001d:
            r24.getRawY()
            r24.getRawX()
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.f4560k
            if (r12 == r6) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            android.view.View r3 = r3.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r11 = r11[r4]
            float r11 = (float) r11
            int r12 = r3.getLeft()
            int r13 = r3.getRight()
            int r12 = r12 + r13
            float r12 = (float) r12
            float r12 = r12 / r9
            float r11 = r11 + r12
            int[] r12 = r0.q
            r12 = r12[r10]
            float r12 = (float) r12
            int r13 = r3.getTop()
            int r3 = r3.getBottom()
            int r13 = r13 + r3
            float r3 = (float) r13
            float r3 = r3 / r9
            float r3 = r3 + r12
            r22 = r11
            r11 = r3
            r3 = r22
            goto L_0x00b3
        L_0x006c:
            int r12 = r0.f4553d
            if (r12 == r6) goto L_0x00b3
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.t
            androidx.constraintlayout.motion.widget.MotionController r12 = r13.E0(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.t
            int r12 = r12.k()
            android.view.View r12 = r13.findViewById(r12)
            if (r12 != 0) goto L_0x008a
            java.lang.String r9 = "TouchResponse"
            java.lang.String r12 = "could not find view to animate to"
            android.util.Log.e(r9, r12)
            goto L_0x00b3
        L_0x008a:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            int[] r11 = r0.q
            r3.getLocationOnScreen(r11)
            int[] r3 = r0.q
            r3 = r3[r4]
            float r3 = (float) r3
            int r11 = r12.getLeft()
            int r13 = r12.getRight()
            int r11 = r11 + r13
            float r11 = (float) r11
            float r11 = r11 / r9
            float r3 = r3 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
            float r11 = (float) r11
            int r13 = r12.getTop()
            int r12 = r12.getBottom()
            int r13 = r13 + r12
            float r12 = (float) r13
            float r12 = r12 / r9
            float r11 = r11 + r12
        L_0x00b3:
            float r9 = r24.getRawX()
            float r9 = r9 - r3
            float r12 = r24.getRawY()
            float r12 = r12 - r11
            float r13 = r24.getRawY()
            float r13 = r13 - r11
            double r13 = (double) r13
            float r15 = r24.getRawX()
            float r15 = r15 - r3
            r27 = r9
            double r8 = (double) r15
            double r8 = java.lang.Math.atan2(r13, r8)
            float r13 = r0.s
            float r13 = r13 - r11
            double r13 = (double) r13
            float r11 = r0.r
            float r11 = r11 - r3
            double r6 = (double) r11
            double r6 = java.lang.Math.atan2(r13, r6)
            double r6 = r8 - r6
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r6 = r6 * r13
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r6 = r6 / r13
            float r6 = (float) r6
            r7 = 1134886912(0x43a50000, float:330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f3
            float r6 = r6 - r5
            goto L_0x00fa
        L_0x00f3:
            r7 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x00fa
            float r6 = r6 + r5
        L_0x00fa:
            float r7 = java.lang.Math.abs(r6)
            double r13 = (double) r7
            r16 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r7 > 0) goto L_0x010c
            boolean r7 = r0.o
            if (r7 == 0) goto L_0x0338
        L_0x010c:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            boolean r11 = r0.o
            if (r11 != 0) goto L_0x011d
            r0.o = r10
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            r11.setProgress(r7)
        L_0x011d:
            int r11 = r0.f4553d
            r3 = -1
            if (r11 == r3) goto L_0x0146
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            float r5 = r0.f4557h
            float r13 = r0.f4556g
            float[] r14 = r0.p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r13
            r21 = r14
            r16.A0(r17, r18, r19, r20, r21)
            float[] r3 = r0.p
            r5 = r3[r10]
            double r13 = (double) r5
            double r13 = java.lang.Math.toDegrees(r13)
            float r5 = (float) r13
            r3[r10] = r5
            goto L_0x014a
        L_0x0146:
            float[] r3 = r0.p
            r3[r10] = r5
        L_0x014a:
            float r3 = r0.x
            float r6 = r6 * r3
            float[] r3 = r0.p
            r3 = r3[r10]
            float r6 = r6 / r3
            float r7 = r7 + r6
            r3 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r7, r3)
            r6 = 0
            float r5 = java.lang.Math.max(r5, r6)
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x01b1
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0171
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0179
        L_0x0171:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            if (r6 != 0) goto L_0x0176
            r4 = 1
        L_0x0176:
            r3.t0(r4)
        L_0x0179:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            r3.setProgress(r5)
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.g(r3)
            float r3 = r25.f()
            float r1 = r25.e()
            double r4 = (double) r1
            double r6 = (double) r3
            double r10 = java.lang.Math.hypot(r4, r6)
            double r3 = java.lang.Math.atan2(r4, r6)
            double r3 = r3 - r8
            double r3 = java.lang.Math.sin(r3)
            double r10 = r10 * r3
            r9 = r27
            double r3 = (double) r9
            double r5 = (double) r12
            double r3 = java.lang.Math.hypot(r3, r5)
            double r10 = r10 / r3
            float r1 = (float) r10
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            double r4 = (double) r1
            double r4 = java.lang.Math.toDegrees(r4)
            float r1 = (float) r4
            r3.H3 = r1
            goto L_0x01b6
        L_0x01b1:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.t
            r3 = 0
            r1.H3 = r3
        L_0x01b6:
            float r1 = r24.getRawX()
            r0.r = r1
            float r1 = r24.getRawY()
            r0.s = r1
            goto L_0x0338
        L_0x01c4:
            r0.o = r4
            r6 = 16
            r1.g(r6)
            float r6 = r25.f()
            float r1 = r25.e()
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r8 = r8 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.f4560k
            r3 = -1
            if (r12 == r3) goto L_0x021f
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            android.view.View r8 = r8.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
        L_0x0210:
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
            int r12 = r12 + r8
            float r8 = (float) r12
            float r8 = r8 / r9
            float r11 = r11 + r8
            r8 = r4
            goto L_0x0251
        L_0x021f:
            int r12 = r0.f4553d
            r3 = -1
            if (r12 == r3) goto L_0x0251
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            androidx.constraintlayout.motion.widget.MotionController r8 = r8.E0(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r8 = r8.k()
            android.view.View r8 = r11.findViewById(r8)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
            goto L_0x0210
        L_0x0251:
            float r4 = r24.getRawX()
            float r4 = r4 - r8
            float r2 = r24.getRawY()
            float r2 = r2 - r11
            double r8 = (double) r2
            double r11 = (double) r4
            double r8 = java.lang.Math.atan2(r8, r11)
            double r8 = java.lang.Math.toDegrees(r8)
            int r11 = r0.f4553d
            r3 = -1
            if (r11 == r3) goto L_0x028e
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            float r5 = r0.f4557h
            float r12 = r0.f4556g
            float[] r13 = r0.p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r12
            r21 = r13
            r16.A0(r17, r18, r19, r20, r21)
            float[] r3 = r0.p
            r5 = r3[r10]
            double r11 = (double) r5
            double r11 = java.lang.Math.toDegrees(r11)
            float r5 = (float) r11
            r3[r10] = r5
            goto L_0x0292
        L_0x028e:
            float[] r3 = r0.p
            r3[r10] = r5
        L_0x0292:
            float r1 = r1 + r2
            double r1 = (double) r1
            float r6 = r6 + r4
            double r3 = (double) r6
            double r1 = java.lang.Math.atan2(r1, r3)
            double r1 = java.lang.Math.toDegrees(r1)
            double r1 = r1 - r8
            float r1 = (float) r1
            r2 = 1115291648(0x427a0000, float:62.5)
            float r1 = r1 * r2
            boolean r2 = java.lang.Float.isNaN(r1)
            r3 = 1077936128(0x40400000, float:3.0)
            if (r2 != 0) goto L_0x02ba
            float r2 = r1 * r3
            float r4 = r0.x
            float r2 = r2 * r4
            float[] r4 = r0.p
            r4 = r4[r10]
            float r2 = r2 / r4
            float r2 = r2 + r7
        L_0x02b8:
            r4 = 0
            goto L_0x02bc
        L_0x02ba:
            r2 = r7
            goto L_0x02b8
        L_0x02bc:
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0317
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0317
            int r4 = r0.f4552c
            r5 = 3
            if (r4 == r5) goto L_0x0317
            float r5 = r0.x
            float r1 = r1 * r5
            float[] r5 = r0.p
            r5 = r5[r10]
            float r1 = r1 / r5
            double r5 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x02dd
            r2 = 0
            goto L_0x02df
        L_0x02dd:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02df:
            r5 = 6
            if (r4 != r5) goto L_0x02ef
            float r2 = r7 + r1
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x02ed
            float r1 = java.lang.Math.abs(r1)
        L_0x02ed:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02ef:
            int r4 = r0.f4552c
            r5 = 7
            if (r4 != r5) goto L_0x0302
            float r2 = r7 + r1
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0301
            float r1 = java.lang.Math.abs(r1)
            float r1 = -r1
        L_0x0301:
            r2 = 0
        L_0x0302:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r0.t
            int r5 = r0.f4552c
            float r1 = r1 * r3
            r4.b1(r5, r2, r1)
            r1 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0322
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0338
            goto L_0x0322
        L_0x0317:
            r1 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0322
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0338
        L_0x0322:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.t
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r1.setState(r2)
            goto L_0x0338
        L_0x032a:
            float r1 = r24.getRawX()
            r0.r = r1
            float r1 = r24.getRawY()
            r0.s = r1
            r0.o = r4
        L_0x0338:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.v(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    /* access modifiers changed from: package-private */
    public void w(float f2, float f3) {
        float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.A0(this.f4553d, progress, this.f4557h, this.f4556g, this.p);
        float f4 = this.f4562m;
        float[] fArr = this.p;
        if (((double) Math.abs((f4 * fArr[0]) + (this.f4563n * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.f4562m;
        float max = Math.max(Math.min(progress + (f5 != 0.0f ? (f2 * f5) / this.p[0] : (f3 * this.f4563n) / this.p[1]), 1.0f), 0.0f);
        if (max != this.t.getProgress()) {
            this.t.setProgress(max);
        }
    }

    /* access modifiers changed from: package-private */
    public void x(float f2, float f3) {
        boolean z2 = false;
        this.o = false;
        float progress = this.t.getProgress();
        this.t.A0(this.f4553d, progress, this.f4557h, this.f4556g, this.p);
        float f4 = this.f4562m;
        float[] fArr = this.p;
        float f5 = 0.0f;
        float f6 = f4 != 0.0f ? (f2 * f4) / fArr[0] : (f3 * this.f4563n) / fArr[1];
        if (!Float.isNaN(f6)) {
            progress += f6 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z3 = progress != 1.0f;
            int i2 = this.f4552c;
            if (i2 != 3) {
                z2 = true;
            }
            if (z2 && z3) {
                MotionLayout motionLayout = this.t;
                if (((double) progress) >= 0.5d) {
                    f5 = 1.0f;
                }
                motionLayout.b1(i2, f5, f6);
            }
        }
    }

    public void y(int i2) {
        this.f4553d = i2;
    }

    /* access modifiers changed from: package-private */
    public void z(int i2) {
        this.F = i2;
    }

    public TouchResponse(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.t = motionLayout;
        this.f4553d = onSwipe.q();
        int r2 = onSwipe.r();
        this.f4550a = r2;
        if (r2 != -1) {
            float[] fArr = K[r2];
            this.f4557h = fArr[0];
            this.f4556g = fArr[1];
        }
        int b2 = onSwipe.b();
        this.f4551b = b2;
        float[][] fArr2 = L;
        if (b2 < fArr2.length) {
            float[] fArr3 = fArr2[b2];
            this.f4562m = fArr3[0];
            this.f4563n = fArr3[1];
        } else {
            this.f4563n = Float.NaN;
            this.f4562m = Float.NaN;
            this.f4561l = true;
        }
        this.u = onSwipe.g();
        this.v = onSwipe.f();
        this.w = onSwipe.h();
        this.x = onSwipe.c();
        this.z = onSwipe.d();
        this.f4554e = onSwipe.s();
        this.f4552c = onSwipe.j();
        this.y = onSwipe.i();
        this.f4555f = onSwipe.e();
        this.f4560k = onSwipe.k();
        this.E = onSwipe.l();
        this.A = onSwipe.m();
        this.B = onSwipe.n();
        this.C = onSwipe.o();
        this.D = onSwipe.p();
        this.F = onSwipe.a();
    }
}
