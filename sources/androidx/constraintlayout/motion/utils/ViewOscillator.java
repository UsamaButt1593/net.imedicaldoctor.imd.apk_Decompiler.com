package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewOscillator extends KeyCycleOscillator {

    /* renamed from: i  reason: collision with root package name */
    private static final String f4342i = "ViewOscillator";

    static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        public void m(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    static class CustomSet extends ViewOscillator {

        /* renamed from: j  reason: collision with root package name */
        float[] f4343j = new float[1];

        /* renamed from: k  reason: collision with root package name */
        protected ConstraintAttribute f4344k;

        CustomSet() {
        }

        /* access modifiers changed from: protected */
        public void e(Object obj) {
            this.f4344k = (ConstraintAttribute) obj;
        }

        public void m(View view, float f2) {
            this.f4343j[0] = a(f2);
            CustomSupport.b(this.f4344k, view, this.f4343j);
        }
    }

    static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        public void m(View view, float f2) {
            view.setElevation(a(f2));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public void m(View view, float f2) {
        }

        public void n(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    static class ProgressSet extends ViewOscillator {

        /* renamed from: j  reason: collision with root package name */
        boolean f4345j = false;

        ProgressSet() {
        }

        public void m(View view, float f2) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f4345j) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f4345j = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e(ViewOscillator.f4342i, "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        public void m(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        public void m(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        public void m(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        public void m(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        public void m(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        public void m(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        public void m(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        public void m(View view, float f2) {
            view.setTranslationZ(a(f2));
        }
    }

    public static ViewOscillator l(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 13;
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
                return new RotationSet();
            case 10:
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case 12:
                return new AlphaSet();
            case 13:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void m(View view, float f2);
}
