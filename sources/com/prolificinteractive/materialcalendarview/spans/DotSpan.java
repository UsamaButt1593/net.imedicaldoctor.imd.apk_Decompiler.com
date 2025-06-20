package com.prolificinteractive.materialcalendarview.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

public class DotSpan implements LineBackgroundSpan {

    /* renamed from: c  reason: collision with root package name */
    public static final float f28159c = 3.0f;

    /* renamed from: a  reason: collision with root package name */
    private final float f28160a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28161b;

    public DotSpan() {
        this.f28160a = 3.0f;
        this.f28161b = 0;
    }

    public void drawBackground(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, int i9) {
        int color = paint.getColor();
        int i10 = this.f28161b;
        if (i10 != 0) {
            paint.setColor(i10);
        }
        float f2 = this.f28160a;
        canvas.drawCircle((float) ((i2 + i3) / 2), ((float) i6) + f2, f2, paint);
        paint.setColor(color);
    }

    public DotSpan(float f2) {
        this.f28160a = f2;
        this.f28161b = 0;
    }

    public DotSpan(float f2, int i2) {
        this.f28160a = f2;
        this.f28161b = i2;
    }

    public DotSpan(int i2) {
        this.f28160a = 3.0f;
        this.f28161b = i2;
    }
}
