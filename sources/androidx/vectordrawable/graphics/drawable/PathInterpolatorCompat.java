package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {

    /* renamed from: c  reason: collision with root package name */
    private static final float f16345c = 0.002f;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16346d = 3000;

    /* renamed from: e  reason: collision with root package name */
    public static final double f16347e = 1.0E-5d;

    /* renamed from: a  reason: collision with root package name */
    private float[] f16348a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f16349b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(f16346d, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f16348a = new float[min];
            this.f16349b = new float[min];
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < min; i3++) {
                pathMeasure.getPosTan((((float) i3) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.f16348a[i3] = fArr[0];
                this.f16349b[i3] = fArr[1];
            }
            if (((double) Math.abs(this.f16348a[0])) <= 1.0E-5d && ((double) Math.abs(this.f16349b[0])) <= 1.0E-5d) {
                int i4 = min - 1;
                if (((double) Math.abs(this.f16348a[i4] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f16349b[i4] - 1.0f)) <= 1.0E-5d) {
                    float f2 = 0.0f;
                    int i5 = 0;
                    while (i2 < min) {
                        float[] fArr2 = this.f16348a;
                        int i6 = i5 + 1;
                        float f3 = fArr2[i5];
                        if (f3 >= f2) {
                            fArr2[i2] = f3;
                            i2++;
                            f2 = f3;
                            i5 = i6;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f16348a[0]);
            sb.append(",");
            sb.append(this.f16349b[0]);
            sb.append(" end:");
            int i7 = min - 1;
            sb.append(this.f16348a[i7]);
            sb.append(",");
            sb.append(this.f16349b[i7]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void c(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.r(xmlPullParser, "pathData")) {
            String m2 = TypedArrayUtils.m(typedArray, xmlPullParser, "pathData", 4);
            Path e2 = PathParser.e(m2);
            if (e2 != null) {
                b(e2);
                return;
            }
            throw new InflateException("The path is null, which is created from " + m2);
        } else if (!TypedArrayUtils.r(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (TypedArrayUtils.r(xmlPullParser, "controlY1")) {
            float j2 = TypedArrayUtils.j(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float j3 = TypedArrayUtils.j(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean r = TypedArrayUtils.r(xmlPullParser, "controlX2");
            if (r != TypedArrayUtils.r(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!r) {
                c(j2, j3);
            } else {
                a(j2, j3, TypedArrayUtils.j(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.j(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f16348a.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f16348a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f16348a;
        float f3 = fArr[length];
        float f4 = fArr[i2];
        float f5 = f3 - f4;
        if (f5 == 0.0f) {
            return this.f16349b[i2];
        }
        float[] fArr2 = this.f16349b;
        float f6 = fArr2[i2];
        return f6 + (((f2 - f4) / f5) * (fArr2[length] - f6));
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.r0);
        d(s, xmlPullParser);
        s.recycle();
    }
}
