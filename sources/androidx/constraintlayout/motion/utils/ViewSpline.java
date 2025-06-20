package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewSpline extends SplineSet {

    /* renamed from: g  reason: collision with root package name */
    private static final String f4346g = "ViewSpline";

    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        public void m(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    public static class CustomSet extends ViewSpline {

        /* renamed from: h  reason: collision with root package name */
        String f4347h;

        /* renamed from: i  reason: collision with root package name */
        SparseArray<ConstraintAttribute> f4348i;

        /* renamed from: j  reason: collision with root package name */
        float[] f4349j;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f4347h = str.split(",")[1];
            this.f4348i = sparseArray;
        }

        public void g(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void j(int i2) {
            int size = this.f4348i.size();
            int p = this.f4348i.valueAt(0).p();
            double[] dArr = new double[size];
            this.f4349j = new float[p];
            int[] iArr = new int[2];
            iArr[1] = p;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = ((double) this.f4348i.keyAt(i3)) * 0.01d;
                this.f4348i.valueAt(i3).l(this.f4349j);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f4349j;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.f3860a = CurveFit.a(i2, dArr, dArr2);
        }

        public void m(View view, float f2) {
            this.f3860a.e((double) f2, this.f4349j);
            CustomSupport.b(this.f4348i.valueAt(0), view, this.f4349j);
        }

        public void n(int i2, ConstraintAttribute constraintAttribute) {
            this.f4348i.append(i2, constraintAttribute);
        }
    }

    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        public void m(View view, float f2) {
            view.setElevation(a(f2));
        }
    }

    public static class PathRotate extends ViewSpline {
        public void m(View view, float f2) {
        }

        public void n(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        public void m(View view, float f2) {
            view.setPivotX(a(f2));
        }
    }

    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        public void m(View view, float f2) {
            view.setPivotY(a(f2));
        }
    }

    static class ProgressSet extends ViewSpline {

        /* renamed from: h  reason: collision with root package name */
        boolean f4350h = false;

        ProgressSet() {
        }

        public void m(View view, float f2) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f4350h) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f4350h = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e(ViewSpline.f4346g, "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        public void m(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        public void m(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        public void m(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        public void m(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        public void m(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        public void m(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        public void m(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        public void m(View view, float f2) {
            view.setTranslationZ(a(f2));
        }
    }

    public static ViewSpline k(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewSpline l(String str) {
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
            case -797520672:
                if (str.equals(Key.t)) {
                    c2 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals(Key.f4372l)) {
                    c2 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.f4373m)) {
                    c2 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new PivotXset();
            case 10:
                return new PivotYset();
            case 11:
                return new RotationSet();
            case 12:
                return new ElevationSet();
            case 13:
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void m(View view, float f2);
}
