package com.timehop.stickyheadersrecyclerview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class StickyRecyclerHeadersTouchListener implements RecyclerView.OnItemTouchListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f28206a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final StickyRecyclerHeadersDecoration f28207b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f28208c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public OnHeaderClickListener f28209d;

    public interface OnHeaderClickListener {
        void a(View view, int i2, long j2);
    }

    public StickyRecyclerHeadersTouchListener(RecyclerView recyclerView, StickyRecyclerHeadersDecoration stickyRecyclerHeadersDecoration) {
        this.f28206a = recyclerView;
        this.f28207b = stickyRecyclerHeadersDecoration;
        this.f28208c = new GestureDetector(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                int l2 = StickyRecyclerHeadersTouchListener.this.f28207b.l((int) motionEvent.getX(), (int) motionEvent.getY());
                if (l2 == -1 || StickyRecyclerHeadersTouchListener.this.f28209d == null) {
                    return false;
                }
                StickyRecyclerHeadersTouchListener.this.f28209d.a(StickyRecyclerHeadersTouchListener.this.f28207b.m(StickyRecyclerHeadersTouchListener.this.f28206a, l2), l2, StickyRecyclerHeadersTouchListener.this.g().r(l2));
                return true;
            }
        });
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f28208c.onTouchEvent(motionEvent);
    }

    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        return this.f28208c.onTouchEvent(motionEvent);
    }

    public void e(boolean z) {
    }

    public StickyRecyclerHeadersAdapter g() {
        if (this.f28206a.getAdapter() instanceof StickyRecyclerHeadersAdapter) {
            return (StickyRecyclerHeadersAdapter) this.f28206a.getAdapter();
        }
        throw new IllegalStateException("A RecyclerView with " + StickyRecyclerHeadersTouchListener.class.getSimpleName() + " requires a " + StickyRecyclerHeadersAdapter.class.getSimpleName());
    }

    public void h(OnHeaderClickListener onHeaderClickListener) {
        this.f28209d = onHeaderClickListener;
    }
}
