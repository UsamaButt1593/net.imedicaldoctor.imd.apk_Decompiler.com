package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;

public class Carousel extends MotionHelper {
    private static final boolean D3 = false;
    private static final String E3 = "Carousel";
    public static final int F3 = 1;
    public static final int G3 = 2;
    private int A3 = 200;
    int B3 = -1;
    Runnable C3 = new Runnable() {
        public void run() {
            Carousel.this.n3.setProgress(0.0f);
            Carousel.this.a0();
            Carousel.this.j3.a(Carousel.this.m3);
            float velocity = Carousel.this.n3.getVelocity();
            if (Carousel.this.x3 == 2 && velocity > Carousel.this.y3 && Carousel.this.m3 < Carousel.this.j3.count() - 1) {
                final float R = velocity * Carousel.this.u3;
                if (Carousel.this.m3 == 0 && Carousel.this.l3 > Carousel.this.m3) {
                    return;
                }
                if (Carousel.this.m3 != Carousel.this.j3.count() - 1 || Carousel.this.l3 >= Carousel.this.m3) {
                    Carousel.this.n3.post(new Runnable() {
                        public void run() {
                            Carousel.this.n3.b1(5, 1.0f, R);
                        }
                    });
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Adapter j3 = null;
    private final ArrayList<View> k3 = new ArrayList<>();
    /* access modifiers changed from: private */
    public int l3 = 0;
    /* access modifiers changed from: private */
    public int m3 = 0;
    /* access modifiers changed from: private */
    public MotionLayout n3;
    private int o3 = -1;
    private boolean p3 = false;
    private int q3 = -1;
    private int r3 = -1;
    private int s3 = -1;
    private int t3 = -1;
    /* access modifiers changed from: private */
    public float u3 = 0.9f;
    private int v3 = 0;
    private int w3 = 4;
    /* access modifiers changed from: private */
    public int x3 = 1;
    /* access modifiers changed from: private */
    public float y3 = 2.0f;
    private int z3 = -1;

    public interface Adapter {
        void a(int i2);

        void b(View view, int i2);

        int count();
    }

    public Carousel(Context context) {
        super(context);
    }

    private void T(boolean z) {
        Iterator<MotionScene.Transition> it2 = this.n3.getDefinedTransitions().iterator();
        while (it2.hasNext()) {
            it2.next().Q(z);
        }
    }

    private boolean U(int i2, boolean z) {
        MotionLayout motionLayout;
        MotionScene.Transition F0;
        if (i2 == -1 || (motionLayout = this.n3) == null || (F0 = motionLayout.F0(i2)) == null || z == F0.K()) {
            return false;
        }
        F0.Q(z);
        return true;
    }

    private void V(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.G3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.K3) {
                    this.o3 = obtainStyledAttributes.getResourceId(index, this.o3);
                } else if (index == R.styleable.I3) {
                    this.q3 = obtainStyledAttributes.getResourceId(index, this.q3);
                } else if (index == R.styleable.L3) {
                    this.r3 = obtainStyledAttributes.getResourceId(index, this.r3);
                } else if (index == R.styleable.J3) {
                    this.w3 = obtainStyledAttributes.getInt(index, this.w3);
                } else if (index == R.styleable.O3) {
                    this.s3 = obtainStyledAttributes.getResourceId(index, this.s3);
                } else if (index == R.styleable.N3) {
                    this.t3 = obtainStyledAttributes.getResourceId(index, this.t3);
                } else if (index == R.styleable.Q3) {
                    this.u3 = obtainStyledAttributes.getFloat(index, this.u3);
                } else if (index == R.styleable.P3) {
                    this.x3 = obtainStyledAttributes.getInt(index, this.x3);
                } else if (index == R.styleable.R3) {
                    this.y3 = obtainStyledAttributes.getFloat(index, this.y3);
                } else if (index == R.styleable.M3) {
                    this.p3 = obtainStyledAttributes.getBoolean(index, this.p3);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X() {
        MotionLayout motionLayout;
        int i2;
        this.n3.setTransitionDuration(this.A3);
        if (this.z3 < this.m3) {
            motionLayout = this.n3;
            i2 = this.s3;
        } else {
            motionLayout = this.n3;
            i2 = this.t3;
        }
        motionLayout.h1(i2, this.A3);
    }

    /* access modifiers changed from: private */
    public void a0() {
        Adapter adapter = this.j3;
        if (adapter != null && this.n3 != null && adapter.count() != 0) {
            int size = this.k3.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k3.get(i2);
                int i3 = (this.m3 + i2) - this.v3;
                if (!this.p3) {
                    if (i3 < 0 || i3 >= this.j3.count()) {
                        c0(view, this.w3);
                    }
                    c0(view, 0);
                } else if (i3 < 0) {
                    int i4 = this.w3;
                    if (i4 != 4) {
                        c0(view, i4);
                    } else {
                        c0(view, 0);
                    }
                    if (i3 % this.j3.count() == 0) {
                        this.j3.b(view, 0);
                    } else {
                        Adapter adapter2 = this.j3;
                        adapter2.b(view, adapter2.count() + (i3 % this.j3.count()));
                    }
                } else {
                    if (i3 >= this.j3.count()) {
                        if (i3 == this.j3.count()) {
                            i3 = 0;
                        } else if (i3 > this.j3.count()) {
                            i3 %= this.j3.count();
                        }
                        int i5 = this.w3;
                        if (i5 != 4) {
                            c0(view, i5);
                        }
                    }
                    c0(view, 0);
                }
                this.j3.b(view, i3);
            }
            int i6 = this.z3;
            if (i6 != -1 && i6 != this.m3) {
                this.n3.post(new a(this));
            } else if (i6 == this.m3) {
                this.z3 = -1;
            }
            if (this.q3 == -1 || this.r3 == -1) {
                Log.w(E3, "No backward or forward transitions defined for Carousel!");
            } else if (!this.p3) {
                int count = this.j3.count();
                if (this.m3 == 0) {
                    U(this.q3, false);
                } else {
                    U(this.q3, true);
                    this.n3.setTransition(this.q3);
                }
                if (this.m3 == count - 1) {
                    U(this.r3, false);
                    return;
                }
                U(this.r3, true);
                this.n3.setTransition(this.r3);
            }
        }
    }

    private boolean b0(int i2, View view, int i3) {
        ConstraintSet.Constraint k0;
        ConstraintSet B0 = this.n3.B0(i2);
        if (B0 == null || (k0 = B0.k0(view.getId())) == null) {
            return false;
        }
        k0.f4712c.f4762c = 1;
        view.setVisibility(i3);
        return true;
    }

    private boolean c0(View view, int i2) {
        MotionLayout motionLayout = this.n3;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z = false;
        for (int b0 : constraintSetIds) {
            z |= b0(b0, view, i2);
        }
        return z;
    }

    public void W(int i2) {
        this.m3 = Math.max(0, Math.min(getCount() - 1, i2));
        Y();
    }

    public void Y() {
        int size = this.k3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.k3.get(i2);
            if (this.j3.count() == 0) {
                c0(view, this.w3);
            } else {
                c0(view, 0);
            }
        }
        this.n3.T0();
        a0();
    }

    public void Z(int i2, int i3) {
        MotionLayout motionLayout;
        int i4;
        this.z3 = Math.max(0, Math.min(getCount() - 1, i2));
        int max = Math.max(0, i3);
        this.A3 = max;
        this.n3.setTransitionDuration(max);
        if (i2 < this.m3) {
            motionLayout = this.n3;
            i4 = this.s3;
        } else {
            motionLayout = this.n3;
            i4 = this.t3;
        }
        motionLayout.h1(i4, this.A3);
    }

    public void a(MotionLayout motionLayout, int i2, int i3, float f2) {
        this.B3 = i2;
    }

    public int getCount() {
        Adapter adapter = this.j3;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.m3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.constraintlayout.motion.widget.MotionLayout r2, int r3) {
        /*
            r1 = this;
            int r2 = r1.m3
            r1.l3 = r2
            int r0 = r1.t3
            if (r3 != r0) goto L_0x000d
            int r2 = r2 + 1
        L_0x000a:
            r1.m3 = r2
            goto L_0x0014
        L_0x000d:
            int r0 = r1.s3
            if (r3 != r0) goto L_0x0014
            int r2 = r2 + -1
            goto L_0x000a
        L_0x0014:
            boolean r2 = r1.p3
            r3 = 0
            if (r2 == 0) goto L_0x0034
            int r2 = r1.m3
            androidx.constraintlayout.helper.widget.Carousel$Adapter r0 = r1.j3
            int r0 = r0.count()
            if (r2 < r0) goto L_0x0025
            r1.m3 = r3
        L_0x0025:
            int r2 = r1.m3
            if (r2 >= 0) goto L_0x004e
            androidx.constraintlayout.helper.widget.Carousel$Adapter r2 = r1.j3
            int r2 = r2.count()
            int r2 = r2 + -1
            r1.m3 = r2
            goto L_0x004e
        L_0x0034:
            int r2 = r1.m3
            androidx.constraintlayout.helper.widget.Carousel$Adapter r0 = r1.j3
            int r0 = r0.count()
            if (r2 < r0) goto L_0x0048
            androidx.constraintlayout.helper.widget.Carousel$Adapter r2 = r1.j3
            int r2 = r2.count()
            int r2 = r2 + -1
            r1.m3 = r2
        L_0x0048:
            int r2 = r1.m3
            if (r2 >= 0) goto L_0x004e
            r1.m3 = r3
        L_0x004e:
            int r2 = r1.l3
            int r3 = r1.m3
            if (r2 == r3) goto L_0x005b
            androidx.constraintlayout.motion.widget.MotionLayout r2 = r1.n3
            java.lang.Runnable r3 = r1.C3
            r2.post(r3)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Carousel.k(androidx.constraintlayout.motion.widget.MotionLayout, int):void");
    }

    /* access modifiers changed from: protected */
    @RequiresApi(api = 17)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i2 = 0; i2 < this.X2; i2++) {
                int i3 = this.s[i2];
                View o = motionLayout.o(i3);
                if (this.o3 == i3) {
                    this.v3 = i2;
                }
                this.k3.add(o);
            }
            this.n3 = motionLayout;
            if (this.x3 == 2) {
                MotionScene.Transition F0 = motionLayout.F0(this.r3);
                if (F0 != null) {
                    F0.U(5);
                }
                MotionScene.Transition F02 = this.n3.F0(this.q3);
                if (F02 != null) {
                    F02.U(5);
                }
            }
            a0();
        }
    }

    public void setAdapter(Adapter adapter) {
        this.j3 = adapter;
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        V(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        V(context, attributeSet);
    }
}
