package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.canvas.CanvasCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ShapeableDelegate {

    /* renamed from: a  reason: collision with root package name */
    boolean f21909a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f21910b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    ShapeAppearanceModel f21911c;

    /* renamed from: d  reason: collision with root package name */
    RectF f21912d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    final Path f21913e = new Path();

    @NonNull
    public static ShapeableDelegate a(@NonNull View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            return new ShapeableDelegateV33(view);
        }
        return i2 >= 22 ? new ShapeableDelegateV22(view) : new ShapeableDelegateV14();
    }

    private boolean d() {
        RectF rectF = this.f21912d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void k() {
        if (d() && this.f21911c != null) {
            ShapeAppearancePathProvider.k().d(this.f21911c, 1.0f, this.f21912d, this.f21913e);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void b(@NonNull View view);

    public boolean c() {
        return this.f21909a;
    }

    public void e(@NonNull Canvas canvas, @NonNull CanvasCompat.CanvasOperation canvasOperation) {
        if (!j() || this.f21913e.isEmpty()) {
            canvasOperation.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f21913e);
        canvasOperation.a(canvas);
        canvas.restore();
    }

    public void f(@NonNull View view, @NonNull RectF rectF) {
        this.f21912d = rectF;
        k();
        b(view);
    }

    public void g(@NonNull View view, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f21911c = shapeAppearanceModel;
        k();
        b(view);
    }

    public void h(@NonNull View view, boolean z) {
        if (z != this.f21909a) {
            this.f21909a = z;
            b(view);
        }
    }

    public void i(@NonNull View view, boolean z) {
        this.f21910b = z;
        b(view);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean j();
}
