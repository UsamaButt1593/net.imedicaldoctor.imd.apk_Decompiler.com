package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ShapePath[] f21847a = new ShapePath[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f21848b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f21849c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f21850d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f21851e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f21852f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final ShapePath f21853g = new ShapePath();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f21854h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f21855i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f21856j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f21857k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f21858l = true;

    private static class Lazy {

        /* renamed from: a  reason: collision with root package name */
        static final ShapeAppearancePathProvider f21859a = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void a(ShapePath shapePath, Matrix matrix, int i2);

        void b(ShapePath shapePath, Matrix matrix, int i2);
    }

    static final class ShapeAppearancePathSpec {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ShapeAppearanceModel f21860a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Path f21861b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final RectF f21862c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final PathListener f21863d;

        /* renamed from: e  reason: collision with root package name */
        public final float f21864e;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, @Nullable PathListener pathListener, Path path) {
            this.f21863d = pathListener;
            this.f21860a = shapeAppearanceModel;
            this.f21864e = f2;
            this.f21862c = rectF;
            this.f21861b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f21847a[i2] = new ShapePath();
            this.f21848b[i2] = new Matrix();
            this.f21849c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (float) (((i2 + 1) % 4) * 90);
    }

    private void b(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        this.f21854h[0] = this.f21847a[i2].l();
        this.f21854h[1] = this.f21847a[i2].m();
        this.f21848b[i2].mapPoints(this.f21854h);
        Path path = shapeAppearancePathSpec.f21861b;
        float[] fArr = this.f21854h;
        if (i2 == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f21847a[i2].d(this.f21848b[i2], shapeAppearancePathSpec.f21861b);
        PathListener pathListener = shapeAppearancePathSpec.f21863d;
        if (pathListener != null) {
            pathListener.a(this.f21847a[i2], this.f21848b[i2], i2);
        }
    }

    private void c(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        ShapePath shapePath;
        Matrix matrix;
        Path path;
        int i3 = (i2 + 1) % 4;
        this.f21854h[0] = this.f21847a[i2].j();
        this.f21854h[1] = this.f21847a[i2].k();
        this.f21848b[i2].mapPoints(this.f21854h);
        this.f21855i[0] = this.f21847a[i3].l();
        this.f21855i[1] = this.f21847a[i3].m();
        this.f21848b[i3].mapPoints(this.f21855i);
        float[] fArr = this.f21854h;
        float f2 = fArr[0];
        float[] fArr2 = this.f21855i;
        float max = Math.max(((float) Math.hypot((double) (f2 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float i4 = i(shapeAppearancePathSpec.f21862c, i2);
        this.f21853g.q(0.0f, 0.0f);
        EdgeTreatment j2 = j(i2, shapeAppearancePathSpec.f21860a);
        j2.b(max, i4, shapeAppearancePathSpec.f21864e, this.f21853g);
        this.f21856j.reset();
        this.f21853g.d(this.f21849c[i2], this.f21856j);
        if (!this.f21858l || (!j2.a() && !l(this.f21856j, i2) && !l(this.f21856j, i3))) {
            shapePath = this.f21853g;
            matrix = this.f21849c[i2];
            path = shapeAppearancePathSpec.f21861b;
        } else {
            Path path2 = this.f21856j;
            path2.op(path2, this.f21852f, Path.Op.DIFFERENCE);
            this.f21854h[0] = this.f21853g.l();
            this.f21854h[1] = this.f21853g.m();
            this.f21849c[i2].mapPoints(this.f21854h);
            Path path3 = this.f21851e;
            float[] fArr3 = this.f21854h;
            path3.moveTo(fArr3[0], fArr3[1]);
            shapePath = this.f21853g;
            matrix = this.f21849c[i2];
            path = this.f21851e;
        }
        shapePath.d(matrix, path);
        PathListener pathListener = shapeAppearancePathSpec.f21863d;
        if (pathListener != null) {
            pathListener.b(this.f21853g, this.f21849c[i2], i2);
        }
    }

    private void f(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        float f2;
        float f3;
        float f4;
        if (i2 == 1) {
            f2 = rectF.right;
            f4 = rectF.bottom;
        } else if (i2 != 2) {
            f3 = i2 != 3 ? rectF.right : rectF.left;
            f4 = rectF.top;
        } else {
            f2 = rectF.left;
            f4 = rectF.bottom;
        }
        pointF.set(f3, f4);
    }

    private CornerSize g(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i2 == 1) {
            return shapeAppearanceModel.l();
        }
        if (i2 != 2) {
            return i2 != 3 ? shapeAppearanceModel.t() : shapeAppearanceModel.r();
        }
        return shapeAppearanceModel.j();
    }

    private CornerTreatment h(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i2 == 1) {
            return shapeAppearanceModel.k();
        }
        if (i2 != 2) {
            return i2 != 3 ? shapeAppearanceModel.s() : shapeAppearanceModel.q();
        }
        return shapeAppearanceModel.i();
    }

    private float i(@NonNull RectF rectF, int i2) {
        float centerX;
        float f2;
        float[] fArr = this.f21854h;
        ShapePath shapePath = this.f21847a[i2];
        fArr[0] = shapePath.f21869c;
        fArr[1] = shapePath.f21870d;
        this.f21848b[i2].mapPoints(fArr);
        if (i2 == 1 || i2 == 3) {
            centerX = rectF.centerX();
            f2 = this.f21854h[0];
        } else {
            centerX = rectF.centerY();
            f2 = this.f21854h[1];
        }
        return Math.abs(centerX - f2);
    }

    private EdgeTreatment j(int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i2 == 1) {
            return shapeAppearanceModel.h();
        }
        if (i2 != 2) {
            return i2 != 3 ? shapeAppearanceModel.o() : shapeAppearanceModel.p();
        }
        return shapeAppearanceModel.n();
    }

    @UiThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static ShapeAppearancePathProvider k() {
        return Lazy.f21859a;
    }

    @RequiresApi(19)
    private boolean l(Path path, int i2) {
        this.f21857k.reset();
        this.f21847a[i2].d(this.f21848b[i2], this.f21857k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f21857k.computeBounds(rectF, true);
        path.op(this.f21857k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i2) {
        h(i2, shapeAppearancePathSpec.f21860a).c(this.f21847a[i2], 90.0f, shapeAppearancePathSpec.f21864e, shapeAppearancePathSpec.f21862c, g(i2, shapeAppearancePathSpec.f21860a));
        float a2 = a(i2);
        this.f21848b[i2].reset();
        f(i2, shapeAppearancePathSpec.f21862c, this.f21850d);
        Matrix matrix = this.f21848b[i2];
        PointF pointF = this.f21850d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f21848b[i2].preRotate(a2);
    }

    private void o(int i2) {
        this.f21854h[0] = this.f21847a[i2].j();
        this.f21854h[1] = this.f21847a[i2].k();
        this.f21848b[i2].mapPoints(this.f21854h);
        float a2 = a(i2);
        this.f21849c[i2].reset();
        Matrix matrix = this.f21849c[i2];
        float[] fArr = this.f21854h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f21849c[i2].preRotate(a2);
    }

    public void d(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, @NonNull Path path) {
        e(shapeAppearanceModel, f2, rectF, (PathListener) null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.f21851e.rewind();
        this.f21852f.rewind();
        this.f21852f.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f2, rectF, pathListener, path);
        for (int i2 = 0; i2 < 4; i2++) {
            m(shapeAppearancePathSpec, i2);
            o(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(shapeAppearancePathSpec, i3);
            c(shapeAppearancePathSpec, i3);
        }
        path.close();
        this.f21851e.close();
        if (!this.f21851e.isEmpty()) {
            path.op(this.f21851e, Path.Op.UNION);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z) {
        this.f21858l = z;
    }
}
