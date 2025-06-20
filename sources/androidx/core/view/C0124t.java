package androidx.core.view;

import android.view.View;

/* renamed from: androidx.core.view.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0124t implements View.OnLongClickListener {
    public final /* synthetic */ DragStartHelper s;

    public /* synthetic */ C0124t(DragStartHelper dragStartHelper) {
        this.s = dragStartHelper;
    }

    public final boolean onLongClick(View view) {
        return this.s.d(view);
    }
}
