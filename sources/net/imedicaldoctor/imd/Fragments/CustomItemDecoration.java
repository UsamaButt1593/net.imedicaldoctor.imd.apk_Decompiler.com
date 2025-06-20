package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class CustomItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f29669a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29670b;

    public CustomItemDecoration(Context context) {
        Drawable l2 = ContextCompat.l(context, R.drawable.f726recycler_view_divider);
        this.f29669a = l2;
        this.f29670b = l2 != null ? l2.getIntrinsicHeight() : 0;
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i2;
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt.getLayoutParams().height != 0 && childAt.getVisibility() != 8 && !CompressHelper.C1(childAt) && ((childCount <= (i2 = i3 + 1) || !CompressHelper.C1(recyclerView.getChildAt(i2))) && (childAt.findViewById(R.id.f1135title_item) == null || childCount <= i2 || recyclerView.getChildAt(i2).findViewById(R.id.f1135title_item) == null))) {
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                this.f29669a.setBounds(paddingLeft, bottom, width, this.f29670b + bottom);
                this.f29669a.draw(canvas);
            }
        }
    }
}
