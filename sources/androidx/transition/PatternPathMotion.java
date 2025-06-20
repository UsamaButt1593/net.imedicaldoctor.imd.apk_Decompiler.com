package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private Path f16009a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Path f16010b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f16011c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f16010b = path;
        this.f16011c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f16009a = path;
    }

    private static float b(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    @NonNull
    public Path a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float b2 = b(f6, f7);
        double atan2 = Math.atan2((double) f7, (double) f6);
        this.f16011c.setScale(b2, b2);
        this.f16011c.postRotate((float) Math.toDegrees(atan2));
        this.f16011c.postTranslate(f2, f3);
        Path path = new Path();
        this.f16010b.transform(this.f16011c, path);
        return path;
    }

    @NonNull
    public Path c() {
        return this.f16009a;
    }

    public void d(@NonNull Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f16011c.setTranslate(-f4, -f5);
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float b2 = 1.0f / b(f6, f7);
        this.f16011c.postScale(b2, b2);
        this.f16011c.postRotate((float) Math.toDegrees(-Math.atan2((double) f7, (double) f6)));
        path.transform(this.f16011c, this.f16010b);
        this.f16009a = path;
    }

    public PatternPathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.f16010b = new Path();
        this.f16011c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16044k);
        try {
            String m2 = TypedArrayUtils.m(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (m2 != null) {
                d(PathParser.e(m2));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(@NonNull Path path) {
        this.f16010b = new Path();
        this.f16011c = new Matrix();
        d(path);
    }
}
