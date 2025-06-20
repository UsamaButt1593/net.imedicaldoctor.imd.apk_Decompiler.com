package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public final class MarginPageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final int f16569a;

    public MarginPageTransformer(@Px int i2) {
        Preconditions.j(i2, "Margin must be non-negative");
        this.f16569a = i2;
    }

    private ViewPager2 b(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    public void a(@NonNull View view, float f2) {
        ViewPager2 b2 = b(view);
        float f3 = ((float) this.f16569a) * f2;
        if (b2.getOrientation() == 0) {
            if (b2.k()) {
                f3 = -f3;
            }
            view.setTranslationX(f3);
            return;
        }
        view.setTranslationY(f3);
    }
}
