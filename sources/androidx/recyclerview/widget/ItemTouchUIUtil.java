package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.View;

public interface ItemTouchUIUtil {
    @SuppressLint({"UnknownNullness"})
    void a(View view);

    @SuppressLint({"UnknownNullness"})
    void b(View view);

    @SuppressLint({"UnknownNullness"})
    void c(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z);

    @SuppressLint({"UnknownNullness"})
    void d(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z);
}
