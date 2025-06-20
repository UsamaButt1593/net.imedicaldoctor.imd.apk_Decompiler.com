package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer {

    /* renamed from: i  reason: collision with root package name */
    private static final int f21777i = 68;

    /* renamed from: j  reason: collision with root package name */
    private static final int f21778j = 20;

    /* renamed from: k  reason: collision with root package name */
    private static final int f21779k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f21780l = new int[3];

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f21781m = {0.0f, 0.5f, 1.0f};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f21782n = new int[4];
    private static final float[] o = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f21783a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f21784b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f21785c;

    /* renamed from: d  reason: collision with root package name */
    private int f21786d;

    /* renamed from: e  reason: collision with root package name */
    private int f21787e;

    /* renamed from: f  reason: collision with root package name */
    private int f21788f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f21789g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f21790h;

    public ShadowRenderer() {
        this(ViewCompat.y);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i3 = i2;
        float f4 = f3;
        boolean z = f4 < 0.0f;
        Path path = this.f21789g;
        if (z) {
            int[] iArr = f21782n;
            iArr[0] = 0;
            iArr[1] = this.f21788f;
            iArr[2] = this.f21787e;
            iArr[3] = this.f21786d;
            float f5 = f2;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f2, f4);
            path.close();
            float f6 = (float) (-i3);
            rectF2.inset(f6, f6);
            int[] iArr2 = f21782n;
            iArr2[0] = 0;
            iArr2[1] = this.f21786d;
            iArr2[2] = this.f21787e;
            iArr2[3] = this.f21788f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f7 = 1.0f - (((float) i3) / width);
            float[] fArr = o;
            fArr[1] = f7;
            fArr[2] = ((1.0f - f7) / 2.0f) + f7;
            this.f21784b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f21782n, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF.height() / rectF.width());
            if (!z) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.f21790h);
            }
            canvas.drawArc(rectF, f2, f3, true, this.f21784b);
            canvas.restore();
        }
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2) {
        rectF.bottom += (float) i2;
        rectF.offset(0.0f, (float) (-i2));
        int[] iArr = f21780l;
        iArr[0] = this.f21788f;
        iArr[1] = this.f21787e;
        iArr[2] = this.f21786d;
        Paint paint = this.f21785c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f21781m, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f21785c);
        canvas.restore();
    }

    public void c(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3, @NonNull float[] fArr) {
        if (f3 > 0.0f) {
            f2 += f3;
            f3 = -f3;
        }
        a(canvas, matrix, rectF, i2, f2, f3);
        Path path = this.f21789g;
        path.rewind();
        path.moveTo(fArr[0], fArr[1]);
        path.arcTo(rectF, f2, f3);
        path.close();
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        canvas.drawPath(path, this.f21790h);
        canvas.drawPath(path, this.f21783a);
        canvas.restore();
    }

    @NonNull
    public Paint d() {
        return this.f21783a;
    }

    public void e(int i2) {
        this.f21786d = ColorUtils.D(i2, 68);
        this.f21787e = ColorUtils.D(i2, 20);
        this.f21788f = ColorUtils.D(i2, 0);
        this.f21783a.setColor(this.f21786d);
    }

    public ShadowRenderer(int i2) {
        this.f21789g = new Path();
        Paint paint = new Paint();
        this.f21790h = paint;
        this.f21783a = new Paint();
        e(i2);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f21784b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f21785c = new Paint(paint2);
    }
}
