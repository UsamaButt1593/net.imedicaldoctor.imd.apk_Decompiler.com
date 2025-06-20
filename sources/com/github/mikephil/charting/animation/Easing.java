package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(11)
public class Easing {
    public static final EasingFunction A = new EasingFunction() {
        public float getInterpolation(float f2) {
            return 1.0f - Easing.B.getInterpolation(1.0f - f2);
        }
    };
    public static final EasingFunction B = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 < 0.36363637f) {
                return 7.5625f * f2 * f2;
            }
            if (f2 < 0.72727275f) {
                float f3 = f2 - 0.54545456f;
                return (7.5625f * f3 * f3) + 0.75f;
            } else if (f2 < 0.90909094f) {
                float f4 = f2 - 0.8181818f;
                return (7.5625f * f4 * f4) + 0.9375f;
            } else {
                float f5 = f2 - 0.95454544f;
                return (7.5625f * f5 * f5) + 0.984375f;
            }
        }
    };
    public static final EasingFunction C = new EasingFunction() {
        public float getInterpolation(float f2) {
            return f2 < 0.5f ? Easing.A.getInterpolation(f2 * 2.0f) * 0.5f : (Easing.B.getInterpolation((f2 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static final float f18894a = 6.2831855f;

    /* renamed from: b  reason: collision with root package name */
    public static final EasingFunction f18895b = new EasingFunction() {
        public float getInterpolation(float f2) {
            return f2;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final EasingFunction f18896c = new EasingFunction() {
        public float getInterpolation(float f2) {
            return f2 * f2;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final EasingFunction f18897d = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (-f2) * (f2 - 2.0f);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final EasingFunction f18898e = new EasingFunction() {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return 0.5f * f3 * f3;
            }
            float f4 = f3 - 1.0f;
            return ((f4 * (f4 - 2.0f)) - 1.0f) * -0.5f;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final EasingFunction f18899f = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (float) Math.pow((double) f2, 3.0d);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final EasingFunction f18900g = new EasingFunction() {
        public float getInterpolation(float f2) {
            return ((float) Math.pow((double) (f2 - 1.0f), 3.0d)) + 1.0f;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final EasingFunction f18901h = new EasingFunction() {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            return (f3 < 1.0f ? (float) Math.pow((double) f3, 3.0d) : ((float) Math.pow((double) (f3 - 2.0f), 3.0d)) + 2.0f) * 0.5f;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final EasingFunction f18902i = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (float) Math.pow((double) f2, 4.0d);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public static final EasingFunction f18903j = new EasingFunction() {
        public float getInterpolation(float f2) {
            return -(((float) Math.pow((double) (f2 - 1.0f), 4.0d)) - 1.0f);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public static final EasingFunction f18904k = new EasingFunction() {
        public float getInterpolation(float f2) {
            float pow;
            float f3;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                pow = (float) Math.pow((double) f4, 4.0d);
                f3 = 0.5f;
            } else {
                pow = ((float) Math.pow((double) (f4 - 2.0f), 4.0d)) - 2.0f;
                f3 = -0.5f;
            }
            return pow * f3;
        }
    };

    /* renamed from: l  reason: collision with root package name */
    public static final EasingFunction f18905l = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (-((float) Math.cos(((double) f2) * 1.5707963267948966d))) + 1.0f;
        }
    };

    /* renamed from: m  reason: collision with root package name */
    public static final EasingFunction f18906m = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (float) Math.sin(((double) f2) * 1.5707963267948966d);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public static final EasingFunction f18907n = new EasingFunction() {
        public float getInterpolation(float f2) {
            return (((float) Math.cos(((double) f2) * 3.141592653589793d)) - 1.0f) * -0.5f;
        }
    };
    public static final EasingFunction o = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (double) ((f2 - 1.0f) * 10.0f));
        }
    };
    public static final EasingFunction p = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (double) ((f2 + 1.0f) * -10.0f)));
        }
    };
    public static final EasingFunction q = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float f3 = f2 * 2.0f;
            return (f3 < 1.0f ? (float) Math.pow(2.0d, (double) ((f3 - 1.0f) * 10.0f)) : (-((float) Math.pow(2.0d, (double) ((f3 - 1.0f) * -10.0f)))) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction r = new EasingFunction() {
        public float getInterpolation(float f2) {
            return -(((float) Math.sqrt((double) (1.0f - (f2 * f2)))) - 1.0f);
        }
    };
    public static final EasingFunction s = new EasingFunction() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (float) Math.sqrt((double) (1.0f - (f3 * f3)));
        }
    };
    public static final EasingFunction t = new EasingFunction() {
        public float getInterpolation(float f2) {
            float sqrt;
            float f3;
            float f4 = f2 * 2.0f;
            if (f4 < 1.0f) {
                sqrt = ((float) Math.sqrt((double) (1.0f - (f4 * f4)))) - 1.0f;
                f3 = -0.5f;
            } else {
                float f5 = f4 - 2.0f;
                sqrt = ((float) Math.sqrt((double) (1.0f - (f5 * f5)))) + 1.0f;
                f3 = 0.5f;
            }
            return sqrt * f3;
        }
    };
    public static final EasingFunction u = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float f3 = f2 - 1.0f;
            return -(((float) Math.pow(2.0d, (double) (10.0f * f3))) * ((float) Math.sin((double) (((f3 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.f18894a) / 0.3f))));
        }
    };
    public static final EasingFunction v = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (double) (-10.0f * f2))) * ((float) Math.sin((double) (((f2 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.f18894a) / 0.3f)))) + 1.0f;
        }
    };
    public static final EasingFunction w = new EasingFunction() {
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            float f3 = f2 * 2.0f;
            if (f3 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            int i2 = (f3 > 1.0f ? 1 : (f3 == 1.0f ? 0 : -1));
            float f4 = f3 - 1.0f;
            return i2 < 0 ? ((float) Math.pow(2.0d, (double) (10.0f * f4))) * ((float) Math.sin((double) (((f4 * 1.0f) - asin) * Easing.f18894a * 2.2222223f))) * -0.5f : (((float) Math.pow(2.0d, (double) (-10.0f * f4))) * 0.5f * ((float) Math.sin((double) (((f4 * 1.0f) - asin) * Easing.f18894a * 2.2222223f)))) + 1.0f;
        }
    };
    public static final EasingFunction x = new EasingFunction() {
        public float getInterpolation(float f2) {
            return f2 * f2 * ((f2 * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction y = new EasingFunction() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * ((f3 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction z = new EasingFunction() {
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * f3 * ((3.5949094f * f3) - 2.5949094f) * 0.5f;
            }
            float f4 = f3 - 2.0f;
            return ((f4 * f4 * ((3.5949094f * f4) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };

    public interface EasingFunction extends TimeInterpolator {
        float getInterpolation(float f2);
    }
}
