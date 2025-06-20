package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float O = 100.0f;

    SmoothCalendarLayoutManager(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public void j2(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public float w(DisplayMetrics displayMetrics) {
                return SmoothCalendarLayoutManager.O / ((float) displayMetrics.densityDpi);
            }
        };
        r2.q(i2);
        k2(r2);
    }
}
