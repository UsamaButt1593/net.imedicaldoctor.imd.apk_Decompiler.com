package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: androidx.core.view.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0126u implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper s;

    public /* synthetic */ C0126u(DragStartHelper dragStartHelper) {
        this.s = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.s.e(view, motionEvent);
    }
}
