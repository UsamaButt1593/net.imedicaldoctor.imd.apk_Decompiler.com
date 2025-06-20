package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;

class MaskEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22109a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f22110b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f22111c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f22112d = ShapeAppearancePathProvider.k();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f22113e;

    MaskEvaluator() {
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f22109a);
            return;
        }
        canvas.clipPath(this.f22110b);
        canvas.clipPath(this.f22111c, Region.Op.UNION);
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel q = TransitionUtils.q(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.d(), progressThresholds.c(), f2);
        this.f22113e = q;
        this.f22112d.d(q, 1.0f, rectF2, this.f22110b);
        this.f22112d.d(this.f22113e, 1.0f, rectF3, this.f22111c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f22109a.op(this.f22110b, this.f22111c, Path.Op.UNION);
        }
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f22113e;
    }

    /* access modifiers changed from: package-private */
    public Path d() {
        return this.f22109a;
    }
}
