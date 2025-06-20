package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.util.TypedValue;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridAutoFitLayoutManager extends GridLayoutManager {
    private int a0;
    public int b0;
    private boolean c0 = true;

    public GridAutoFitLayoutManager(Context context, int i2) {
        super(context, 1);
        V3(U3(context, i2));
    }

    private int U3(Context context, int i2) {
        return i2 <= 0 ? (int) TypedValue.applyDimension(1, 48.0f, context.getResources().getDisplayMetrics()) : i2;
    }

    public void V3(int i2) {
        if (i2 > 0 && i2 != this.a0) {
            this.a0 = i2;
            this.c0 = true;
        }
    }

    public void s1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int j0;
        int q0;
        if (this.c0 && this.a0 > 0) {
            if (Q2() == 1) {
                j0 = D0() - t0();
                q0 = s0();
            } else {
                j0 = j0() - v0();
                q0 = q0();
            }
            int max = Math.max(1, (j0 - q0) / this.a0);
            Q3(max);
            this.b0 = max;
            this.c0 = false;
        }
        super.s1(recycler, state);
    }

    public GridAutoFitLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, 1, i3, z);
        V3(U3(context, i2));
    }
}
