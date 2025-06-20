package com.timehop.stickyheadersrecyclerview.caching;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.util.OrientationProvider;

public class HeaderViewCache implements HeaderProvider {

    /* renamed from: a  reason: collision with root package name */
    private final StickyRecyclerHeadersAdapter f28210a;

    /* renamed from: b  reason: collision with root package name */
    private final LongSparseArray<View> f28211b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final OrientationProvider f28212c;

    public HeaderViewCache(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, OrientationProvider orientationProvider) {
        this.f28210a = stickyRecyclerHeadersAdapter;
        this.f28212c = orientationProvider;
    }

    public View a(RecyclerView recyclerView, int i2) {
        int i3;
        int i4;
        long r = this.f28210a.r(i2);
        View h2 = this.f28211b.h(r);
        if (h2 == null) {
            RecyclerView.ViewHolder o = this.f28210a.o(recyclerView);
            this.f28210a.p(o, i2);
            h2 = o.f15587a;
            if (h2.getLayoutParams() == null) {
                h2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            if (this.f28212c.a(recyclerView) == 1) {
                i3 = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
                i4 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0);
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 0);
                i4 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
            }
            h2.measure(ViewGroup.getChildMeasureSpec(i3, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), h2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i4, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), h2.getLayoutParams().height));
            h2.layout(0, 0, h2.getMeasuredWidth(), h2.getMeasuredHeight());
            this.f28211b.p(r, h2);
        }
        return h2;
    }

    public void c() {
        this.f28211b.b();
    }
}
