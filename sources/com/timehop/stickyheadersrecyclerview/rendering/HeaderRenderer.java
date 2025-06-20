package com.timehop.stickyheadersrecyclerview.rendering;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.calculation.DimensionCalculator;
import com.timehop.stickyheadersrecyclerview.util.OrientationProvider;

public class HeaderRenderer {

    /* renamed from: a  reason: collision with root package name */
    private final DimensionCalculator f28213a;

    /* renamed from: b  reason: collision with root package name */
    private final OrientationProvider f28214b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f28215c;

    public HeaderRenderer(OrientationProvider orientationProvider) {
        this(orientationProvider, new DimensionCalculator());
    }

    private void b(Rect rect, RecyclerView recyclerView, View view) {
        int paddingLeft;
        int paddingTop;
        int width;
        int height;
        int i2;
        this.f28213a.b(rect, view);
        if (this.f28214b.a(recyclerView) == 1) {
            paddingLeft = recyclerView.getPaddingLeft();
            paddingTop = recyclerView.getPaddingTop();
            width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - rect.right;
            height = recyclerView.getHeight();
            i2 = recyclerView.getPaddingBottom();
        } else {
            paddingLeft = recyclerView.getPaddingLeft();
            paddingTop = recyclerView.getPaddingTop();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            i2 = rect.bottom;
        }
        rect.set(paddingLeft, paddingTop, width, height - i2);
    }

    public void a(RecyclerView recyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (recyclerView.getLayoutManager().Z()) {
            b(this.f28215c, recyclerView, view);
            canvas.clipRect(this.f28215c);
        }
        canvas.translate((float) rect.left, (float) rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    private HeaderRenderer(OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator) {
        this.f28215c = new Rect();
        this.f28214b = orientationProvider;
        this.f28213a = dimensionCalculator;
    }
}
