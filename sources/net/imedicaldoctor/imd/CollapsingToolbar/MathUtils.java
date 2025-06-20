package net.imedicaldoctor.imd.CollapsingToolbar;

class MathUtils {
    MathUtils() {
    }

    static float a(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    static int b(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i3;
        }
        return i2 > i4 ? i4 : i2;
    }
}
