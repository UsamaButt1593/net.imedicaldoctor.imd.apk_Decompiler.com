package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f17346a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static boolean d(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    private static int e(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    static int f(float f2, float f3) {
        return g((int) f2, (int) f3);
    }

    private static int g(int i2, int i3) {
        return i2 - (i3 * e(i2, i3));
    }

    public static void h(ShapeData shapeData, Path path) {
        path.reset();
        PointF b2 = shapeData.b();
        path.moveTo(b2.x, b2.y);
        f17346a.set(b2.x, b2.y);
        for (int i2 = 0; i2 < shapeData.a().size(); i2++) {
            CubicCurveData cubicCurveData = shapeData.a().get(i2);
            PointF a2 = cubicCurveData.a();
            PointF b3 = cubicCurveData.b();
            PointF c2 = cubicCurveData.c();
            if (!a2.equals(f17346a) || !b3.equals(c2)) {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            } else {
                path.lineTo(c2.x, c2.y);
            }
            f17346a.set(c2.x, c2.y);
        }
        if (shapeData.d()) {
            path.close();
        }
    }

    public static double i(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float j(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int k(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (((float) i2) + (f2 * ((float) (i3 - i2))));
    }

    public static void l(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.c(keyPathElementContent.getName(), i2)) {
            list.add(keyPath2.a(keyPathElementContent.getName()).j(keyPathElementContent));
        }
    }
}
