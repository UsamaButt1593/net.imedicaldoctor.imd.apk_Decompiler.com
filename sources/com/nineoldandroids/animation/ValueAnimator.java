package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator {
    private static final TypeEvaluator A3 = new IntEvaluator();
    private static final TypeEvaluator B3 = new FloatEvaluator();
    /* access modifiers changed from: private */
    public static long C3 = n3;
    public static final int D3 = 1;
    public static final int E3 = 2;
    public static final int F3 = -1;
    private static final long n3 = 10;
    static final int o3 = 0;
    static final int p3 = 1;
    static final int q3 = 0;
    static final int r3 = 1;
    static final int s3 = 2;
    private static ThreadLocal<AnimationHandler> t3 = new ThreadLocal<>();
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> u3 = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> v3 = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> w3 = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> x3 = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> y3 = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final Interpolator z3 = new AccelerateDecelerateInterpolator();
    long X;
    private int X2 = 0;
    long Y = -1;
    private float Y2 = 0.0f;
    private boolean Z = false;
    private boolean Z2 = false;
    private long a3;
    int b3 = 0;
    /* access modifiers changed from: private */
    public boolean c3 = false;
    private boolean d3 = false;
    boolean e3 = false;
    private long f3 = 300;
    /* access modifiers changed from: private */
    public long g3 = 0;
    private int h3 = 0;
    private int i3 = 1;
    private Interpolator j3 = z3;
    private ArrayList<AnimatorUpdateListener> k3 = null;
    PropertyValuesHolder[] l3;
    HashMap<String, PropertyValuesHolder> m3;

    private static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) ValueAnimator.u3.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.w3.get();
            int i2 = message.what;
            if (i2 == 0) {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.v3.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i3);
                        if (valueAnimator.g3 == 0) {
                            valueAnimator.K0();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            } else if (i2 == 1) {
                z = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.y3.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.x3.get();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i4);
                if (valueAnimator2.M(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i5 = 0; i5 < size3; i5++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i5);
                    valueAnimator3.K0();
                    boolean unused = valueAnimator3.c3 = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i6 = 0;
            while (i6 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i6);
                if (valueAnimator4.J(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i6++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i7 = 0; i7 < arrayList6.size(); i7++) {
                    ((ValueAnimator) arrayList6.get(i7)).Q();
                }
                arrayList6.clear();
            }
            if (!z) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.C3 - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void e(ValueAnimator valueAnimator);
    }

    private void H0(boolean z) {
        if (Looper.myLooper() != null) {
            this.Z = z;
            this.X2 = 0;
            this.b3 = 0;
            this.d3 = true;
            this.Z2 = false;
            v3.get().add(this);
            if (this.g3 == 0) {
                u0(Y());
                this.b3 = 0;
                this.c3 = true;
                ArrayList<Animator.AnimatorListener> arrayList = this.s;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((Animator.AnimatorListener) arrayList2.get(i2)).c(this);
                    }
                }
            }
            AnimationHandler animationHandler = t3.get();
            if (animationHandler == null) {
                animationHandler = new AnimationHandler();
                t3.set(animationHandler);
            }
            animationHandler.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public static void K() {
        u3.get().clear();
        v3.get().clear();
        w3.get().clear();
    }

    /* access modifiers changed from: private */
    public void K0() {
        ArrayList<Animator.AnimatorListener> arrayList;
        k0();
        u3.get().add(this);
        if (this.g3 > 0 && (arrayList = this.s) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Animator.AnimatorListener) arrayList2.get(i2)).c(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean M(long j2) {
        if (!this.Z2) {
            this.Z2 = true;
            this.a3 = j2;
            return false;
        }
        long j4 = j2 - this.a3;
        long j5 = this.g3;
        if (j4 <= j5) {
            return false;
        }
        this.X = j2 - (j4 - j5);
        this.b3 = 1;
        return true;
    }

    /* access modifiers changed from: private */
    public void Q() {
        ArrayList<Animator.AnimatorListener> arrayList;
        u3.get().remove(this);
        v3.get().remove(this);
        w3.get().remove(this);
        this.b3 = 0;
        if (this.c3 && (arrayList = this.s) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Animator.AnimatorListener) arrayList2.get(i2)).d(this);
            }
        }
        this.c3 = false;
        this.d3 = false;
    }

    public static int X() {
        return u3.get().size();
    }

    public static long b0() {
        return C3;
    }

    public static ValueAnimator l0(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.y0(fArr);
        return valueAnimator;
    }

    public static ValueAnimator n0(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.C0(iArr);
        return valueAnimator;
    }

    public static ValueAnimator o0(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.D0(objArr);
        valueAnimator.w0(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator q0(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.G0(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void z0(long j2) {
        C3 = j2;
    }

    public void C0(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                G0(PropertyValuesHolder.m("", iArr));
            } else {
                propertyValuesHolderArr[0].u(iArr);
            }
            this.e3 = false;
        }
    }

    public void D0(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                G0(PropertyValuesHolder.q("", (TypeEvaluator) null, objArr));
            } else {
                propertyValuesHolderArr[0].w(objArr);
            }
            this.e3 = false;
        }
    }

    public void E0(int i2) {
        this.h3 = i2;
    }

    public void F(AnimatorUpdateListener animatorUpdateListener) {
        if (this.k3 == null) {
            this.k3 = new ArrayList<>();
        }
        this.k3.add(animatorUpdateListener);
    }

    public void F0(int i2) {
        this.i3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void G(float f2) {
        float interpolation = this.j3.getInterpolation(f2);
        this.Y2 = interpolation;
        for (PropertyValuesHolder a2 : this.l3) {
            a2.a(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.k3;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.k3.get(i2).e(this);
            }
        }
    }

    public void G0(PropertyValuesHolder... propertyValuesHolderArr) {
        this.l3 = propertyValuesHolderArr;
        this.m3 = new HashMap<>(r0);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.m3.put(propertyValuesHolder.f(), propertyValuesHolder);
        }
        this.e3 = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean J(long r10) {
        /*
            r9 = this;
            int r0 = r9.b3
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001a
            r9.b3 = r3
            long r4 = r9.Y
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r9.X = r10
            goto L_0x001a
        L_0x0012:
            long r4 = r10 - r4
            r9.X = r4
            r4 = -1
            r9.Y = r4
        L_0x001a:
            int r0 = r9.b3
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L_0x0023
            if (r0 == r4) goto L_0x0023
            goto L_0x0082
        L_0x0023:
            long r6 = r9.f3
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0032
            long r1 = r9.X
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L_0x0034
        L_0x0032:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0034:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0077
            int r11 = r9.X2
            int r1 = r9.h3
            if (r11 < r1) goto L_0x0047
            r11 = -1
            if (r1 != r11) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            float r10 = java.lang.Math.min(r10, r0)
            goto L_0x0078
        L_0x0047:
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r11 = r9.s
            if (r11 == 0) goto L_0x0060
            int r11 = r11.size()
            r1 = 0
        L_0x0050:
            if (r1 >= r11) goto L_0x0060
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r2 = r9.s
            java.lang.Object r2 = r2.get(r1)
            com.nineoldandroids.animation.Animator$AnimatorListener r2 = (com.nineoldandroids.animation.Animator.AnimatorListener) r2
            r2.b(r9)
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0060:
            int r11 = r9.i3
            if (r11 != r4) goto L_0x0069
            boolean r11 = r9.Z
            r11 = r11 ^ r3
            r9.Z = r11
        L_0x0069:
            int r11 = r9.X2
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.X2 = r11
            float r10 = r10 % r0
            long r1 = r9.X
            long r3 = r9.f3
            long r1 = r1 + r3
            r9.X = r1
        L_0x0077:
            r3 = 0
        L_0x0078:
            boolean r11 = r9.Z
            if (r11 == 0) goto L_0x007e
            float r10 = r0 - r10
        L_0x007e:
            r9.G(r10)
            r5 = r3
        L_0x0082:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.ValueAnimator.J(long):boolean");
    }

    /* renamed from: L */
    public ValueAnimator clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.k3;
        if (arrayList != null) {
            valueAnimator.k3 = new ArrayList<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                valueAnimator.k3.add(arrayList.get(i2));
            }
        }
        valueAnimator.Y = -1;
        valueAnimator.Z = false;
        valueAnimator.X2 = 0;
        valueAnimator.e3 = false;
        valueAnimator.b3 = 0;
        valueAnimator.Z2 = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.l3 = new PropertyValuesHolder[length];
            valueAnimator.m3 = new HashMap<>(length);
            for (int i4 = 0; i4 < length; i4++) {
                PropertyValuesHolder b2 = propertyValuesHolderArr[i4].clone();
                valueAnimator.l3[i4] = b2;
                valueAnimator.m3.put(b2.f(), b2);
            }
        }
        return valueAnimator;
    }

    public float S() {
        return this.Y2;
    }

    public Object U() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].c();
    }

    public Object V(String str) {
        PropertyValuesHolder propertyValuesHolder = this.m3.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.c();
        }
        return null;
    }

    public long Y() {
        if (!this.e3 || this.b3 == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.X;
    }

    public void c() {
        if (!u3.get().contains(this) && !v3.get().contains(this)) {
            this.Z2 = false;
            K0();
        } else if (!this.e3) {
            k0();
        }
        int i2 = this.h3;
        G((i2 <= 0 || (i2 & 1) != 1) ? 1.0f : 0.0f);
        Q();
    }

    public Interpolator c0() {
        return this.j3;
    }

    public void cancel() {
        ArrayList<Animator.AnimatorListener> arrayList;
        if (this.b3 != 0 || v3.get().contains(this) || w3.get().contains(this)) {
            if (this.c3 && (arrayList = this.s) != null) {
                Iterator it2 = ((ArrayList) arrayList.clone()).iterator();
                while (it2.hasNext()) {
                    ((Animator.AnimatorListener) it2.next()).a(this);
                }
            }
            Q();
        }
    }

    public long d() {
        return this.f3;
    }

    public long f() {
        return this.g3;
    }

    public int f0() {
        return this.h3;
    }

    public boolean g() {
        return this.b3 == 1 || this.c3;
    }

    public int g0() {
        return this.i3;
    }

    public boolean h() {
        return this.d3;
    }

    public PropertyValuesHolder[] h0() {
        return this.l3;
    }

    /* access modifiers changed from: package-private */
    public void k0() {
        if (!this.e3) {
            for (PropertyValuesHolder g2 : this.l3) {
                g2.g();
            }
            this.e3 = true;
        }
    }

    public void n(Interpolator interpolator) {
        if (interpolator == null) {
            interpolator = new LinearInterpolator();
        }
        this.j3 = interpolator;
    }

    public void o(long j2) {
        this.g3 = j2;
    }

    public void r0() {
        ArrayList<AnimatorUpdateListener> arrayList = this.k3;
        if (arrayList != null) {
            arrayList.clear();
            this.k3 = null;
        }
    }

    public void s() {
        H0(false);
    }

    public void s0(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.k3;
        if (arrayList != null) {
            arrayList.remove(animatorUpdateListener);
            if (this.k3.size() == 0) {
                this.k3 = null;
            }
        }
    }

    public void t0() {
        this.Z = !this.Z;
        if (this.b3 == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.X = currentAnimationTimeMillis - (this.f3 - (currentAnimationTimeMillis - this.X));
            return;
        }
        H0(true);
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.l3 != null) {
            for (int i2 = 0; i2 < this.l3.length; i2++) {
                str = str + "\n    " + this.l3[i2].toString();
            }
        }
        return str;
    }

    public void u0(long j2) {
        k0();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.b3 != 1) {
            this.Y = j2;
            this.b3 = 2;
        }
        this.X = currentAnimationTimeMillis - j2;
        J(currentAnimationTimeMillis);
    }

    /* renamed from: v0 */
    public ValueAnimator m(long j2) {
        if (j2 >= 0) {
            this.f3 = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    public void w0(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.l3) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].s(typeEvaluator);
        }
    }

    public void y0(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                G0(PropertyValuesHolder.i("", fArr));
            } else {
                propertyValuesHolderArr[0].t(fArr);
            }
            this.e3 = false;
        }
    }
}
