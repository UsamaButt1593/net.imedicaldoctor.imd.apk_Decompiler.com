package net.imedicaldoctor.imd;

import android.content.Context;
import android.graphics.PointF;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class LinearLayoutManagerWithSmoothScroller extends LinearLayoutManager {

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        public TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public int C() {
            return -1;
        }

        public PointF a(int i2) {
            return LinearLayoutManagerWithSmoothScroller.this.a(i2);
        }
    }

    public LinearLayoutManagerWithSmoothScroller(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public void j2(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        TopSnappedSmoothScroller topSnappedSmoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        topSnappedSmoothScroller.q(i2);
        k2(topSnappedSmoothScroller);
    }
}
