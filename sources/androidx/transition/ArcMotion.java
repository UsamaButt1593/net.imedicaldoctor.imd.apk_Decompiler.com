package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {

    /* renamed from: g  reason: collision with root package name */
    private static final float f15960g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private static final float f15961h = 70.0f;

    /* renamed from: i  reason: collision with root package name */
    private static final float f15962i = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: a  reason: collision with root package name */
    private float f15963a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f15964b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f15965c = f15961h;

    /* renamed from: d  reason: collision with root package name */
    private float f15966d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f15967e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f15968f = f15962i;

    public ArcMotion() {
    }

    private static float h(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    @NonNull
    public Path a(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f11 = f4 - f2;
        float f12 = f5 - f3;
        float f13 = (f11 * f11) + (f12 * f12);
        float f14 = (f2 + f4) / 2.0f;
        float f15 = (f3 + f5) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z = f3 > f5;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z) {
                f7 = abs + f5;
                f6 = f4;
            } else {
                f7 = abs + f3;
                f6 = f2;
            }
            f8 = this.f15967e;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z) {
                f10 = f3;
                f9 = f17 + f2;
            } else {
                f9 = f4 - f17;
                f10 = f5;
            }
            f8 = this.f15966d;
        }
        float f18 = f16 * f8 * f8;
        float f19 = f14 - f6;
        float f20 = f15 - f7;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = this.f15968f;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f18 / f21));
            f6 = ((f6 - f14) * sqrt) + f14;
            f7 = f15 + (sqrt * (f7 - f15));
        }
        path.cubicTo((f2 + f6) / 2.0f, (f3 + f7) / 2.0f, (f6 + f4) / 2.0f, (f7 + f5) / 2.0f, f4, f5);
        return path;
    }

    public float b() {
        return this.f15965c;
    }

    public float c() {
        return this.f15963a;
    }

    public float d() {
        return this.f15964b;
    }

    public void e(float f2) {
        this.f15965c = f2;
        this.f15968f = h(f2);
    }

    public void f(float f2) {
        this.f15963a = f2;
        this.f15966d = h(f2);
    }

    public void g(float f2) {
        this.f15964b = f2;
        this.f15967e = h(f2);
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16043j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        g(TypedArrayUtils.j(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        f(TypedArrayUtils.j(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        e(TypedArrayUtils.j(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, f15961h));
        obtainStyledAttributes.recycle();
    }
}
