package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TabLayout f21999a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f22000b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22001c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22002d;

    /* renamed from: e  reason: collision with root package name */
    private final TabConfigurationStrategy f22003e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f22004f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22005g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private TabLayoutOnPageChangeCallback f22006h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.OnTabSelectedListener f22007i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f22008j;

    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        PagerAdapterObserver() {
        }

        public void a() {
            TabLayoutMediator.this.d();
        }

        public void b(int i2, int i3) {
            TabLayoutMediator.this.d();
        }

        public void c(int i2, int i3, @Nullable Object obj) {
            TabLayoutMediator.this.d();
        }

        public void d(int i2, int i3) {
            TabLayoutMediator.this.d();
        }

        public void e(int i2, int i3, int i4) {
            TabLayoutMediator.this.d();
        }

        public void f(int i2, int i3) {
            TabLayoutMediator.this.d();
        }
    }

    public interface TabConfigurationStrategy {
        void a(@NonNull TabLayout.Tab tab, int i2);
    }

    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f22010a;

        /* renamed from: b  reason: collision with root package name */
        private int f22011b;

        /* renamed from: c  reason: collision with root package name */
        private int f22012c;

        TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.f22010a = new WeakReference<>(tabLayout);
            d();
        }

        public void a(int i2) {
            this.f22011b = this.f22012c;
            this.f22012c = i2;
            TabLayout tabLayout = this.f22010a.get();
            if (tabLayout != null) {
                tabLayout.d0(this.f22012c);
            }
        }

        public void b(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f22010a.get();
            if (tabLayout != null) {
                int i4 = this.f22012c;
                tabLayout.W(i2, f2, i4 != 2 || this.f22011b == 1, (i4 == 2 && this.f22011b == 0) ? false : true, false);
            }
        }

        public void c(int i2) {
            TabLayout tabLayout = this.f22010a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f22012c;
                tabLayout.S(tabLayout.D(i2), i3 == 0 || (i3 == 2 && this.f22011b == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f22012c = 0;
            this.f22011b = 0;
        }
    }

    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager2 f22013a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f22014b;

        ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z) {
            this.f22013a = viewPager2;
            this.f22014b = z;
        }

        public void a(TabLayout.Tab tab) {
        }

        public void b(@NonNull TabLayout.Tab tab) {
            this.f22013a.s(tab.k(), this.f22014b);
        }

        public void c(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public void a() {
        if (!this.f22005g) {
            RecyclerView.Adapter<?> adapter = this.f22000b.getAdapter();
            this.f22004f = adapter;
            if (adapter != null) {
                this.f22005g = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.f21999a);
                this.f22006h = tabLayoutOnPageChangeCallback;
                this.f22000b.n(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.f22000b, this.f22002d);
                this.f22007i = viewPagerOnTabSelectedListener;
                this.f21999a.h(viewPagerOnTabSelectedListener);
                if (this.f22001c) {
                    PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
                    this.f22008j = pagerAdapterObserver;
                    this.f22004f.Z(pagerAdapterObserver);
                }
                d();
                this.f21999a.U(this.f22000b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void b() {
        RecyclerView.Adapter<?> adapter;
        if (this.f22001c && (adapter = this.f22004f) != null) {
            adapter.c0(this.f22008j);
            this.f22008j = null;
        }
        this.f21999a.N(this.f22007i);
        this.f22000b.x(this.f22006h);
        this.f22007i = null;
        this.f22006h = null;
        this.f22004f = null;
        this.f22005g = false;
    }

    public boolean c() {
        return this.f22005g;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int min;
        this.f21999a.L();
        RecyclerView.Adapter<?> adapter = this.f22004f;
        if (adapter != null) {
            int b2 = adapter.b();
            for (int i2 = 0; i2 < b2; i2++) {
                TabLayout.Tab I = this.f21999a.I();
                this.f22003e.a(I, i2);
                this.f21999a.l(I, false);
            }
            if (b2 > 0 && (min = Math.min(this.f22000b.getCurrentItem(), this.f21999a.getTabCount() - 1)) != this.f21999a.getSelectedTabPosition()) {
                TabLayout tabLayout = this.f21999a;
                tabLayout.R(tabLayout.D(min));
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, boolean z2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this.f21999a = tabLayout;
        this.f22000b = viewPager2;
        this.f22001c = z;
        this.f22002d = z2;
        this.f22003e = tabConfigurationStrategy;
    }
}
