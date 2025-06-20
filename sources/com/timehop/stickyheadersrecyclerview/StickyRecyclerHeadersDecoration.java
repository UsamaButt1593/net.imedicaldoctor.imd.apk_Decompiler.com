package com.timehop.stickyheadersrecyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.caching.HeaderProvider;
import com.timehop.stickyheadersrecyclerview.caching.HeaderViewCache;
import com.timehop.stickyheadersrecyclerview.calculation.DimensionCalculator;
import com.timehop.stickyheadersrecyclerview.rendering.HeaderRenderer;
import com.timehop.stickyheadersrecyclerview.util.LinearLayoutOrientationProvider;
import com.timehop.stickyheadersrecyclerview.util.OrientationProvider;

public class StickyRecyclerHeadersDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final StickyRecyclerHeadersAdapter f28197a;

    /* renamed from: b  reason: collision with root package name */
    private final ItemVisibilityAdapter f28198b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Rect> f28199c;

    /* renamed from: d  reason: collision with root package name */
    private final HeaderProvider f28200d;

    /* renamed from: e  reason: collision with root package name */
    private final OrientationProvider f28201e;

    /* renamed from: f  reason: collision with root package name */
    private final HeaderPositionCalculator f28202f;

    /* renamed from: g  reason: collision with root package name */
    private final HeaderRenderer f28203g;

    /* renamed from: h  reason: collision with root package name */
    private final DimensionCalculator f28204h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f28205i;

    public StickyRecyclerHeadersDecoration(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter) {
        this(stickyRecyclerHeadersAdapter, new LinearLayoutOrientationProvider(), new DimensionCalculator(), (ItemVisibilityAdapter) null);
    }

    private void o(Rect rect, View view, int i2) {
        this.f28204h.b(this.f28205i, view);
        if (i2 == 1) {
            int height = view.getHeight();
            Rect rect2 = this.f28205i;
            rect.top = height + rect2.top + rect2.bottom;
            return;
        }
        int width = view.getWidth();
        Rect rect3 = this.f28205i;
        rect.left = width + rect3.left + rect3.right;
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.g(rect, view, recyclerView, state);
        int u0 = recyclerView.u0(view);
        if (u0 != -1 && this.f28202f.d(u0, this.f28201e.b(recyclerView))) {
            o(rect, m(recyclerView, u0), this.f28201e.a(recyclerView));
        }
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean e2;
        super.k(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        if (childCount > 0 && this.f28197a.b() > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                int u0 = recyclerView.u0(childAt);
                if (u0 != -1 && (e2 || this.f28202f.d(u0, this.f28201e.b(recyclerView)))) {
                    View a2 = this.f28200d.a(recyclerView, u0);
                    Rect rect = this.f28199c.get(u0);
                    if (rect == null) {
                        rect = new Rect();
                        this.f28199c.put(u0, rect);
                    }
                    Rect rect2 = rect;
                    this.f28202f.h(rect2, recyclerView, a2, childAt, (e2 = this.f28202f.e(childAt, this.f28201e.a(recyclerView), u0)));
                    this.f28203g.a(recyclerView, canvas, a2, rect2);
                }
            }
        }
    }

    public int l(int i2, int i3) {
        for (int i4 = 0; i4 < this.f28199c.size(); i4++) {
            SparseArray<Rect> sparseArray = this.f28199c;
            if (sparseArray.get(sparseArray.keyAt(i4)).contains(i2, i3)) {
                int keyAt = this.f28199c.keyAt(i4);
                ItemVisibilityAdapter itemVisibilityAdapter = this.f28198b;
                if (itemVisibilityAdapter == null || itemVisibilityAdapter.a(keyAt)) {
                    return keyAt;
                }
            }
        }
        return -1;
    }

    public View m(RecyclerView recyclerView, int i2) {
        return this.f28200d.a(recyclerView, i2);
    }

    public void n() {
        this.f28200d.c();
        this.f28199c.clear();
    }

    public StickyRecyclerHeadersDecoration(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, ItemVisibilityAdapter itemVisibilityAdapter) {
        this(stickyRecyclerHeadersAdapter, new LinearLayoutOrientationProvider(), new DimensionCalculator(), itemVisibilityAdapter);
    }

    private StickyRecyclerHeadersDecoration(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, HeaderRenderer headerRenderer, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator, HeaderProvider headerProvider, HeaderPositionCalculator headerPositionCalculator, ItemVisibilityAdapter itemVisibilityAdapter) {
        this.f28199c = new SparseArray<>();
        this.f28205i = new Rect();
        this.f28197a = stickyRecyclerHeadersAdapter;
        this.f28200d = headerProvider;
        this.f28201e = orientationProvider;
        this.f28203g = headerRenderer;
        this.f28204h = dimensionCalculator;
        this.f28202f = headerPositionCalculator;
        this.f28198b = itemVisibilityAdapter;
    }

    private StickyRecyclerHeadersDecoration(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator, ItemVisibilityAdapter itemVisibilityAdapter) {
        this(stickyRecyclerHeadersAdapter, orientationProvider, dimensionCalculator, new HeaderRenderer(orientationProvider), new HeaderViewCache(stickyRecyclerHeadersAdapter, orientationProvider), itemVisibilityAdapter);
    }

    private StickyRecyclerHeadersDecoration(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator, HeaderRenderer headerRenderer, HeaderProvider headerProvider, ItemVisibilityAdapter itemVisibilityAdapter) {
        this(stickyRecyclerHeadersAdapter, headerRenderer, orientationProvider, dimensionCalculator, headerProvider, new HeaderPositionCalculator(stickyRecyclerHeadersAdapter, headerProvider, orientationProvider, dimensionCalculator), itemVisibilityAdapter);
    }
}
