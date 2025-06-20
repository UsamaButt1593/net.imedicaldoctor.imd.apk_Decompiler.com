package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int a(int i2, int i3, double d2) {
        Cam16 b2 = Cam16.b(i2);
        Cam16 b3 = Cam16.b(i3);
        double n2 = b2.n();
        double i4 = b2.i();
        double j2 = b2.j();
        return Cam16.f(n2 + ((b3.n() - n2) * d2), i4 + ((b3.i() - i4) * d2), j2 + ((b3.j() - j2) * d2)).r();
    }

    public static int b(int i2, int i3) {
        Hct b2 = Hct.b(i2);
        Hct b3 = Hct.b(i3);
        return Hct.a(MathUtils.g(b2.d() + (Math.min(MathUtils.c(b2.d(), b3.d()) * 0.5d, 15.0d) * MathUtils.f(b2.d(), b3.d()))), b2.c(), b2.e()).k();
    }

    public static int c(int i2, int i3, double d2) {
        return Hct.a(Cam16.b(a(i2, i3, d2)).l(), Cam16.b(i2).k(), ColorUtils.o(i2)).k();
    }
}
