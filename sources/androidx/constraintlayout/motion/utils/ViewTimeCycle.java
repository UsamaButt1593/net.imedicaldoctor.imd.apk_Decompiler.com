package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String p = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setAlpha(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String q;
        SparseArray<ConstraintAttribute> r;
        SparseArray<float[]> s = new SparseArray<>();
        float[] t;
        float[] u;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.q = str.split(",")[1];
            this.r = sparseArray;
        }

        public void c(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void f(int i2) {
            int size = this.r.size();
            int p = this.r.valueAt(0).p();
            double[] dArr = new double[size];
            int i3 = p + 2;
            this.t = new float[i3];
            this.u = new float[p];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.r.keyAt(i4);
                float[] valueAt = this.s.valueAt(i4);
                dArr[i4] = ((double) keyAt) * 0.01d;
                this.r.valueAt(i4).l(this.t);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.t;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                double[] dArr3 = dArr2[i4];
                dArr3[p] = (double) valueAt[0];
                dArr3[p + 1] = (double) valueAt[1];
            }
            this.f3903a = CurveFit.a(i2, dArr, dArr2);
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            View view2 = view;
            long j3 = j2;
            this.f3903a.e((double) f2, this.t);
            float[] fArr = this.t;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j4 = j3 - this.f3911i;
            if (Float.isNaN(this.f3912j)) {
                float a2 = keyCache.a(view2, this.q, 0);
                this.f3912j = a2;
                if (Float.isNaN(a2)) {
                    this.f3912j = 0.0f;
                }
            }
            float f5 = (float) ((((double) this.f3912j) + ((((double) j4) * 1.0E-9d) * ((double) f3))) % 1.0d);
            this.f3912j = f5;
            this.f3911i = j3;
            float a3 = a(f5);
            this.f3910h = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.u;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.f3910h;
                float f6 = this.t[i2];
                this.f3910h = z | (((double) f6) != 0.0d);
                fArr2[i2] = (f6 * a3) + f4;
                i2++;
            }
            CustomSupport.b(this.r.valueAt(0), view2, this.u);
            if (f3 != 0.0f) {
                this.f3910h = true;
            }
            return this.f3910h;
        }

        public void k(int i2, ConstraintAttribute constraintAttribute, float f2, int i3, float f3) {
            this.r.append(i2, constraintAttribute);
            this.s.append(i2, new float[]{f2, f3});
            this.f3904b = Math.max(this.f3904b, i3);
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setElevation(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            return this.f3910h;
        }

        public boolean k(View view, KeyCache keyCache, float f2, long j2, double d2, double d3) {
            view.setRotation(g(f2, j2, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.f3910h;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean q = false;

        ProgressSet() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            Method method;
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(g(f2, j2, view, keyCache));
            } else if (this.q) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.q = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, new Object[]{Float.valueOf(g(f2, j2, view, keyCache))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e(ViewTimeCycle.p, "unable to setProgress", e2);
                    }
                }
            }
            return this.f3910h;
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotation(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationX(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationY(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleX(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleY(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationX(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationY(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        public boolean j(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationZ(g(f2, j2, view, keyCache));
            return this.f3910h;
        }
    }

    public static ViewTimeCycle h(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle i(String str, long j2) {
        ViewTimeCycle viewTimeCycle;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                viewTimeCycle = new RotationXset();
                break;
            case 1:
                viewTimeCycle = new RotationYset();
                break;
            case 2:
                viewTimeCycle = new TranslationXset();
                break;
            case 3:
                viewTimeCycle = new TranslationYset();
                break;
            case 4:
                viewTimeCycle = new TranslationZset();
                break;
            case 5:
                viewTimeCycle = new ProgressSet();
                break;
            case 6:
                viewTimeCycle = new ScaleXset();
                break;
            case 7:
                viewTimeCycle = new ScaleYset();
                break;
            case 8:
                viewTimeCycle = new RotationSet();
                break;
            case 9:
                viewTimeCycle = new ElevationSet();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new AlphaSet();
                break;
            default:
                return null;
        }
        viewTimeCycle.d(j2);
        return viewTimeCycle;
    }

    public float g(float f2, long j2, View view, KeyCache keyCache) {
        long j3 = j2;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.f3903a.e((double) f2, this.f3909g);
        float[] fArr = this.f3909g;
        float f3 = fArr[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.f3910h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f3912j)) {
            float a2 = keyCache2.a(view2, this.f3908f, 0);
            this.f3912j = a2;
            if (Float.isNaN(a2)) {
                this.f3912j = 0.0f;
            }
        }
        float f4 = (float) ((((double) this.f3912j) + ((((double) (j3 - this.f3911i)) * 1.0E-9d) * ((double) f3))) % 1.0d);
        this.f3912j = f4;
        keyCache2.b(view2, this.f3908f, 0, f4);
        this.f3911i = j3;
        float f5 = this.f3909g[0];
        float a3 = (a(this.f3912j) * f5) + this.f3909g[2];
        this.f3910h = (f5 == 0.0f && i2 == 0) ? false : true;
        return a3;
    }

    public abstract boolean j(View view, float f2, long j2, KeyCache keyCache);
}
