package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f16570a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.PageTransformer f16571b;

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f16570a = linearLayoutManager;
    }

    public void a(int i2) {
    }

    public void b(int i2, float f2, int i3) {
        if (this.f16571b != null) {
            float f3 = -f2;
            int i4 = 0;
            while (i4 < this.f16570a.V()) {
                View U = this.f16570a.U(i4);
                if (U != null) {
                    this.f16571b.a(U, ((float) (this.f16570a.w0(U) - i2)) + f3);
                    i4++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f16570a.V())}));
                }
            }
        }
    }

    public void c(int i2) {
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.PageTransformer d() {
        return this.f16571b;
    }

    /* access modifiers changed from: package-private */
    public void e(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f16571b = pageTransformer;
    }
}
