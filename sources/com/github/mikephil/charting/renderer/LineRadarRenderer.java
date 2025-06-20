package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    private boolean o() {
        return Utils.C() >= 18;
    }

    /* access modifiers changed from: protected */
    public void p(Canvas canvas, Path path, int i2, int i3) {
        int i4 = (i2 & ViewCompat.x) | (i3 << 24);
        if (o()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i4);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.f19079c.getStyle();
        int color = this.f19079c.getColor();
        this.f19079c.setStyle(Paint.Style.FILL);
        this.f19079c.setColor(i4);
        canvas.drawPath(path, this.f19079c);
        this.f19079c.setColor(color);
        this.f19079c.setStyle(style);
    }

    /* access modifiers changed from: protected */
    public void q(Canvas canvas, Path path, Drawable drawable) {
        if (o()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.f19118a.h(), (int) this.f19118a.j(), (int) this.f19118a.i(), (int) this.f19118a.f());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.C() + ".");
    }
}
