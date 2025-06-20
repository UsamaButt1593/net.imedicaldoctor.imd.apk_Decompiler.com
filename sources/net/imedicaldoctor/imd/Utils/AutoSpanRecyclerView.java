package net.imedicaldoctor.imd.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AutoSpanRecyclerView extends RecyclerView {
    private int m5;
    private int n5;
    private final LayoutRequester o5 = new LayoutRequester();

    private class LayoutRequester implements Runnable {
        private LayoutRequester() {
        }

        public void run() {
            AutoSpanRecyclerView.this.requestLayout();
        }
    }

    public AutoSpanRecyclerView(Context context) {
        super(context);
    }

    public void f2(int i2, int i3, int i4) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, i2, false);
        this.n5 = i3;
        this.m5 = i4;
        setLayoutManager(gridLayoutManager);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                View inflate = LayoutInflater.from(getContext()).inflate(this.n5, this, false);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                inflate.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = inflate.getMeasuredWidth();
                ((GridLayoutManager) layoutManager).Q3(Math.max(this.m5, getMeasuredWidth() / measuredWidth));
                post(this.o5);
            }
        }
    }
}
