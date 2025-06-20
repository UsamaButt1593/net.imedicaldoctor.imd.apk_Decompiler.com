package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.OnPageChangeCallback> f16559a;

    CompositeOnPageChangeCallback(int i2) {
        this.f16559a = new ArrayList(i2);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void a(int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback a2 : this.f16559a) {
                a2.a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            f(e2);
        }
    }

    public void b(int i2, float f2, @Px int i3) {
        try {
            for (ViewPager2.OnPageChangeCallback b2 : this.f16559a) {
                b2.b(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            f(e2);
        }
    }

    public void c(int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback c2 : this.f16559a) {
                c2.c(i2);
            }
        } catch (ConcurrentModificationException e2) {
            f(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16559a.add(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void e(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16559a.remove(onPageChangeCallback);
    }
}
