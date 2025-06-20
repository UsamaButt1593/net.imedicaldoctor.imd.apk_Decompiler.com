package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {

    /* renamed from: a  reason: collision with root package name */
    static final ItemTouchUIUtil f15389a = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != view) {
                float T = ViewCompat.T(childAt);
                if (T > f2) {
                    f2 = T;
                }
            }
        }
        return f2;
    }

    public void a(@NonNull View view) {
        int i2 = R.id.f15173a;
        Object tag = view.getTag(i2);
        if (tag instanceof Float) {
            ViewCompat.V1(view, ((Float) tag).floatValue());
        }
        view.setTag(i2, (Object) null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void b(@NonNull View view) {
    }

    public void c(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f2, float f3, int i2, boolean z) {
    }

    public void d(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f2, float f3, int i2, boolean z) {
        if (z) {
            int i3 = R.id.f15173a;
            if (view.getTag(i3) == null) {
                Float valueOf = Float.valueOf(ViewCompat.T(view));
                ViewCompat.V1(view, e(recyclerView, view) + 1.0f);
                view.setTag(i3, valueOf);
            }
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }
}
