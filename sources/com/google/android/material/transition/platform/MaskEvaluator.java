package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;

@RequiresApi(21)
class MaskEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22174a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f22175b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f22176c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f22177d = ShapeAppearancePathProvider.k();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f22178e;

    MaskEvaluator() {
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f22174a);
            return;
        }
        canvas.clipPath(this.f22175b);
        canvas.clipPath(this.f22176c, Region.Op.UNION);
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel q = TransitionUtils.q(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.d(), progressThresholds.c(), f2);
        this.f22178e = q;
        this.f22177d.d(q, 1.0f, rectF2, this.f22175b);
        this.f22177d.d(this.f22178e, 1.0f, rectF3, this.f22176c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f22174a.op(this.f22175b, this.f22176c, Path.Op.UNION);
        }
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f22178e;
    }

    /* access modifiers changed from: package-private */
    public Path d() {
        return this.f22174a;
    }
}
