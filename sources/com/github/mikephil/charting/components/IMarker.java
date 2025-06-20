package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

public interface IMarker {
    void a(Entry entry, Highlight highlight);

    void b(Canvas canvas, float f2, float f3);

    MPPointF c(float f2, float f3);

    MPPointF getOffset();
}
