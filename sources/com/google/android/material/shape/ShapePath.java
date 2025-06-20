package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {

    /* renamed from: j  reason: collision with root package name */
    private static final float f21865j = 270.0f;

    /* renamed from: k  reason: collision with root package name */
    protected static final float f21866k = 180.0f;
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f21867a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f21868b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f21869c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f21870d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f21871e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f21872f;

    /* renamed from: g  reason: collision with root package name */
    private final List<PathOperation> f21873g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<ShadowCompatOperation> f21874h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f21875i;

    static class ArcShadowOperation extends ShadowCompatOperation {

        /* renamed from: c  reason: collision with root package name */
        private final PathArcOperation f21879c;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.f21879c = pathArcOperation;
        }

        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i2, @NonNull Canvas canvas) {
            float h2 = this.f21879c.m();
            float i3 = this.f21879c.n();
            shadowRenderer.a(canvas, matrix, new RectF(this.f21879c.k(), this.f21879c.o(), this.f21879c.l(), this.f21879c.j()), i2, h2, i3);
        }
    }

    static class InnerCornerShadowOperation extends ShadowCompatOperation {

        /* renamed from: c  reason: collision with root package name */
        private final PathLineOperation f21880c;

        /* renamed from: d  reason: collision with root package name */
        private final PathLineOperation f21881d;

        /* renamed from: e  reason: collision with root package name */
        private final float f21882e;

        /* renamed from: f  reason: collision with root package name */
        private final float f21883f;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f2, float f3) {
            this.f21880c = pathLineOperation;
            this.f21881d = pathLineOperation2;
            this.f21882e = f2;
            this.f21883f = f3;
        }

        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            Matrix matrix2 = matrix;
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            int i3 = i2;
            Canvas canvas2 = canvas;
            float e2 = e();
            if (e2 <= 0.0f) {
                double hypot = Math.hypot((double) (this.f21880c.f21900b - this.f21882e), (double) (this.f21880c.f21901c - this.f21883f));
                double hypot2 = Math.hypot((double) (this.f21881d.f21900b - this.f21880c.f21900b), (double) (this.f21881d.f21901c - this.f21880c.f21901c));
                float min = (float) Math.min((double) i3, Math.min(hypot, hypot2));
                double d2 = (double) min;
                double tan = Math.tan(Math.toRadians((double) ((-e2) / 2.0f))) * d2;
                if (hypot > tan) {
                    RectF rectF = new RectF(0.0f, 0.0f, (float) (hypot - tan), 0.0f);
                    this.f21908a.set(matrix2);
                    this.f21908a.preTranslate(this.f21882e, this.f21883f);
                    this.f21908a.preRotate(d());
                    shadowRenderer.b(canvas2, this.f21908a, rectF, i3);
                } else {
                    ShadowRenderer shadowRenderer3 = shadowRenderer;
                }
                float f2 = 2.0f * min;
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, f2);
                this.f21908a.set(matrix2);
                this.f21908a.preTranslate(this.f21880c.f21900b, this.f21880c.f21901c);
                this.f21908a.preRotate(d());
                this.f21908a.preTranslate((float) ((-tan) - d2), -2.0f * min);
                float[] fArr = {(float) (d2 + tan), f2};
                int i4 = (int) min;
                double d3 = tan;
                shadowRenderer.c(canvas, this.f21908a, rectF2, i4, 450.0f, e2, fArr);
                if (hypot2 > d3) {
                    RectF rectF3 = new RectF(0.0f, 0.0f, (float) (hypot2 - d3), 0.0f);
                    this.f21908a.set(matrix2);
                    this.f21908a.preTranslate(this.f21880c.f21900b, this.f21880c.f21901c);
                    this.f21908a.preRotate(c());
                    this.f21908a.preTranslate((float) d3, 0.0f);
                    shadowRenderer.b(canvas, this.f21908a, rectF3, i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f21881d.f21901c - this.f21880c.f21901c) / (this.f21881d.f21900b - this.f21880c.f21900b))));
        }

        /* access modifiers changed from: package-private */
        public float d() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f21880c.f21901c - this.f21883f) / (this.f21880c.f21900b - this.f21882e))));
        }

        /* access modifiers changed from: package-private */
        public float e() {
            float c2 = ((c() - d()) + 360.0f) % 360.0f;
            return c2 <= ShapePath.f21866k ? c2 : c2 - 360.0f;
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {

        /* renamed from: c  reason: collision with root package name */
        private final PathLineOperation f21884c;

        /* renamed from: d  reason: collision with root package name */
        private final float f21885d;

        /* renamed from: e  reason: collision with root package name */
        private final float f21886e;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f2, float f3) {
            this.f21884c = pathLineOperation;
            this.f21885d = f2;
            this.f21886e = f3;
        }

        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i2, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f21884c.f21901c - this.f21886e), (double) (this.f21884c.f21900b - this.f21885d)), 0.0f);
            this.f21908a.set(matrix);
            this.f21908a.preTranslate(this.f21885d, this.f21886e);
            this.f21908a.preRotate(c());
            shadowRenderer.b(canvas, this.f21908a, rectF, i2);
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f21884c.f21901c - this.f21886e) / (this.f21884c.f21900b - this.f21885d))));
        }
    }

    public static class PathArcOperation extends PathOperation {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f21887h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f21888b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f21889c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f21890d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f21891e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f21892f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f21893g;

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* access modifiers changed from: private */
        public float j() {
            return this.f21891e;
        }

        /* access modifiers changed from: private */
        public float k() {
            return this.f21888b;
        }

        /* access modifiers changed from: private */
        public float l() {
            return this.f21890d;
        }

        /* access modifiers changed from: private */
        public float m() {
            return this.f21892f;
        }

        /* access modifiers changed from: private */
        public float n() {
            return this.f21893g;
        }

        /* access modifiers changed from: private */
        public float o() {
            return this.f21889c;
        }

        private void p(float f2) {
            this.f21891e = f2;
        }

        private void q(float f2) {
            this.f21888b = f2;
        }

        private void r(float f2) {
            this.f21890d = f2;
        }

        /* access modifiers changed from: private */
        public void s(float f2) {
            this.f21892f = f2;
        }

        /* access modifiers changed from: private */
        public void t(float f2) {
            this.f21893g = f2;
        }

        private void u(float f2) {
            this.f21889c = f2;
        }

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f21902a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f21887h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {

        /* renamed from: b  reason: collision with root package name */
        private float f21894b;

        /* renamed from: c  reason: collision with root package name */
        private float f21895c;

        /* renamed from: d  reason: collision with root package name */
        private float f21896d;

        /* renamed from: e  reason: collision with root package name */
        private float f21897e;

        /* renamed from: f  reason: collision with root package name */
        private float f21898f;

        /* renamed from: g  reason: collision with root package name */
        private float f21899g;

        public PathCubicOperation(float f2, float f3, float f4, float f5, float f6, float f7) {
            h(f2);
            j(f3);
            i(f4);
            k(f5);
            l(f6);
            m(f7);
        }

        private float b() {
            return this.f21894b;
        }

        private float c() {
            return this.f21896d;
        }

        private float d() {
            return this.f21895c;
        }

        private float e() {
            return this.f21895c;
        }

        private float f() {
            return this.f21898f;
        }

        private float g() {
            return this.f21899g;
        }

        private void h(float f2) {
            this.f21894b = f2;
        }

        private void i(float f2) {
            this.f21896d = f2;
        }

        private void j(float f2) {
            this.f21895c = f2;
        }

        private void k(float f2) {
            this.f21897e = f2;
        }

        private void l(float f2) {
            this.f21898f = f2;
        }

        private void m(float f2) {
            this.f21899g = f2;
        }

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f21902a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f21894b, this.f21895c, this.f21896d, this.f21897e, this.f21898f, this.f21899g);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f21900b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public float f21901c;

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f21902a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f21900b, this.f21901c);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f21902a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f21903b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f21904c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f21905d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f21906e;

        private float f() {
            return this.f21903b;
        }

        private float g() {
            return this.f21904c;
        }

        private float h() {
            return this.f21905d;
        }

        private float i() {
            return this.f21906e;
        }

        /* access modifiers changed from: private */
        public void j(float f2) {
            this.f21903b = f2;
        }

        /* access modifiers changed from: private */
        public void k(float f2) {
            this.f21904c = f2;
        }

        /* access modifiers changed from: private */
        public void l(float f2) {
            this.f21905d = f2;
        }

        /* access modifiers changed from: private */
        public void m(float f2) {
            this.f21906e = f2;
        }

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f21902a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(f(), g(), h(), i());
            path.transform(matrix);
        }
    }

    static abstract class ShadowCompatOperation {

        /* renamed from: b  reason: collision with root package name */
        static final Matrix f21907b = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        final Matrix f21908a = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas);

        public final void b(ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
            a(f21907b, shadowRenderer, i2, canvas);
        }
    }

    public ShapePath() {
        q(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (h() != f2) {
            float h2 = ((f2 - h()) + 360.0f) % 360.0f;
            if (h2 <= f21866k) {
                PathArcOperation pathArcOperation = new PathArcOperation(j(), k(), j(), k());
                pathArcOperation.s(h());
                pathArcOperation.t(h2);
                this.f21874h.add(new ArcShadowOperation(pathArcOperation));
                s(f2);
            }
        }
    }

    private void c(ShadowCompatOperation shadowCompatOperation, float f2, float f3) {
        b(f2);
        this.f21874h.add(shadowCompatOperation);
        s(f3);
    }

    private float h() {
        return this.f21871e;
    }

    private float i() {
        return this.f21872f;
    }

    private void s(float f2) {
        this.f21871e = f2;
    }

    private void t(float f2) {
        this.f21872f = f2;
    }

    private void u(float f2) {
        this.f21869c = f2;
    }

    private void v(float f2) {
        this.f21870d = f2;
    }

    private void w(float f2) {
        this.f21867a = f2;
    }

    private void x(float f2) {
        this.f21868b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
        pathArcOperation.s(f6);
        pathArcOperation.t(f7);
        this.f21873g.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + f21866k) % 360.0f;
        }
        c(arcShadowOperation, f6, z ? (f21866k + f8) % 360.0f : f8);
        double d2 = (double) f8;
        u(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        v(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f21873g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21873g.get(i2).a(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f21875i;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ShadowCompatOperation f(Matrix matrix) {
        b(i());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.f21874h);
        return new ShadowCompatOperation() {
            public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i2, Canvas canvas) {
                for (ShadowCompatOperation a2 : arrayList) {
                    a2.a(matrix2, shadowRenderer, i2, canvas);
                }
            }
        };
    }

    @RequiresApi(21)
    public void g(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f21873g.add(new PathCubicOperation(f2, f3, f4, f5, f6, f7));
        this.f21875i = true;
        u(f6);
        v(f7);
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f21869c;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f21870d;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f21867a;
    }

    /* access modifiers changed from: package-private */
    public float m() {
        return this.f21868b;
    }

    public void n(float f2, float f3) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f21900b = f2;
        float unused2 = pathLineOperation.f21901c = f3;
        this.f21873g.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, j(), k());
        c(lineShadowOperation, lineShadowOperation.c() + f21865j, lineShadowOperation.c() + f21865j);
        u(f2);
        v(f3);
    }

    public void o(float f2, float f3, float f4, float f5) {
        if ((Math.abs(f2 - j()) >= 0.001f || Math.abs(f3 - k()) >= 0.001f) && (Math.abs(f2 - f4) >= 0.001f || Math.abs(f3 - f5) >= 0.001f)) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            float unused = pathLineOperation.f21900b = f2;
            float unused2 = pathLineOperation.f21901c = f3;
            this.f21873g.add(pathLineOperation);
            PathLineOperation pathLineOperation2 = new PathLineOperation();
            float unused3 = pathLineOperation2.f21900b = f4;
            float unused4 = pathLineOperation2.f21901c = f5;
            this.f21873g.add(pathLineOperation2);
            InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, j(), k());
            if (innerCornerShadowOperation.e() > 0.0f) {
                n(f2, f3);
                n(f4, f5);
                return;
            }
            c(innerCornerShadowOperation, innerCornerShadowOperation.d() + f21865j, innerCornerShadowOperation.c() + f21865j);
            u(f4);
            v(f5);
            return;
        }
        n(f4, f5);
    }

    @RequiresApi(21)
    public void p(float f2, float f3, float f4, float f5) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.j(f2);
        pathQuadOperation.k(f3);
        pathQuadOperation.l(f4);
        pathQuadOperation.m(f5);
        this.f21873g.add(pathQuadOperation);
        this.f21875i = true;
        u(f4);
        v(f5);
    }

    public void q(float f2, float f3) {
        r(f2, f3, f21865j, 0.0f);
    }

    public void r(float f2, float f3, float f4, float f5) {
        w(f2);
        x(f3);
        u(f2);
        v(f3);
        s(f4);
        t((f4 + f5) % 360.0f);
        this.f21873g.clear();
        this.f21874h.clear();
        this.f21875i = false;
    }

    public ShapePath(float f2, float f3) {
        q(f2, f3);
    }
}
