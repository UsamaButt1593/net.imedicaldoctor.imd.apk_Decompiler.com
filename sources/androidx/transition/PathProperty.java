package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f16003a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f16004b;

    /* renamed from: c  reason: collision with root package name */
    private final float f16005c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f16006d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f16007e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f16008f;

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f16003a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f16004b = pathMeasure;
        this.f16005c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f16008f);
    }

    /* renamed from: b */
    public void set(T t, Float f2) {
        this.f16008f = f2.floatValue();
        this.f16004b.getPosTan(this.f16005c * f2.floatValue(), this.f16006d, (float[]) null);
        PointF pointF = this.f16007e;
        float[] fArr = this.f16006d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f16003a.set(t, pointF);
    }
}
