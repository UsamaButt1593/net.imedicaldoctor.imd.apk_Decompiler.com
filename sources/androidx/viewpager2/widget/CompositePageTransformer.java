package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public final class CompositePageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.PageTransformer> f16560a = new ArrayList();

    public void a(@NonNull View view, float f2) {
        for (ViewPager2.PageTransformer a2 : this.f16560a) {
            a2.a(view, f2);
        }
    }

    public void b(@NonNull ViewPager2.PageTransformer pageTransformer) {
        this.f16560a.add(pageTransformer);
    }

    public void c(@NonNull ViewPager2.PageTransformer pageTransformer) {
        this.f16560a.remove(pageTransformer);
    }
}
