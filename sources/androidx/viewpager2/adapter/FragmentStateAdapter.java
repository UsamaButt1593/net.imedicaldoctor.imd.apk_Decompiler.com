package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresOptIn;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: m  reason: collision with root package name */
    private static final String f16533m = "f#";

    /* renamed from: n  reason: collision with root package name */
    private static final String f16534n = "s#";
    private static final long o = 10000;

    /* renamed from: d  reason: collision with root package name */
    final Lifecycle f16535d;

    /* renamed from: e  reason: collision with root package name */
    final FragmentManager f16536e;

    /* renamed from: f  reason: collision with root package name */
    final LongSparseArray<Fragment> f16537f;

    /* renamed from: g  reason: collision with root package name */
    private final LongSparseArray<Fragment.SavedState> f16538g;

    /* renamed from: h  reason: collision with root package name */
    private final LongSparseArray<Integer> f16539h;

    /* renamed from: i  reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f16540i;

    /* renamed from: j  reason: collision with root package name */
    FragmentEventDispatcher f16541j;

    /* renamed from: k  reason: collision with root package name */
    boolean f16542k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16543l;

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void a();

        public final void b(int i2, int i3) {
            a();
        }

        public final void c(int i2, int i3, @Nullable Object obj) {
            a();
        }

        public final void d(int i2, int i3) {
            a();
        }

        public final void e(int i2, int i3, int i4) {
            a();
        }

        public final void f(int i2, int i3) {
            a();
        }
    }

    @RequiresOptIn(level = RequiresOptIn.Level.WARNING)
    public @interface ExperimentalFragmentStateAdapterApi {
    }

    static class FragmentEventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        private List<FragmentTransactionCallback> f16547a = new CopyOnWriteArrayList();

        FragmentEventDispatcher() {
        }

        public List<FragmentTransactionCallback.OnPostEventListener> a(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback a2 : this.f16547a) {
                arrayList.add(a2.a(fragment, state));
            }
            return arrayList;
        }

        public void b(List<FragmentTransactionCallback.OnPostEventListener> list) {
            for (FragmentTransactionCallback.OnPostEventListener a2 : list) {
                a2.a();
            }
        }

        public List<FragmentTransactionCallback.OnPostEventListener> c(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback b2 : this.f16547a) {
                arrayList.add(b2.b(fragment));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> d(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback c2 : this.f16547a) {
                arrayList.add(c2.c(fragment));
            }
            return arrayList;
        }

        @OptIn(markerClass = {ExperimentalFragmentStateAdapterApi.class})
        public List<FragmentTransactionCallback.OnPostEventListener> e(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback d2 : this.f16547a) {
                arrayList.add(d2.d(fragment));
            }
            return arrayList;
        }

        public void f(FragmentTransactionCallback fragmentTransactionCallback) {
            this.f16547a.add(fragmentTransactionCallback);
        }

        public void g(FragmentTransactionCallback fragmentTransactionCallback) {
            this.f16547a.remove(fragmentTransactionCallback);
        }
    }

    class FragmentMaxLifecycleEnforcer {

        /* renamed from: a  reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f16548a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f16549b;

        /* renamed from: c  reason: collision with root package name */
        private LifecycleEventObserver f16550c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPager2 f16551d;

        /* renamed from: e  reason: collision with root package name */
        private long f16552e = -1;

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull RecyclerView recyclerView) {
            this.f16551d = a(recyclerView);
            AnonymousClass1 r2 = new ViewPager2.OnPageChangeCallback() {
                public void a(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }

                public void c(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f16548a = r2;
            this.f16551d.n(r2);
            AnonymousClass2 r22 = new DataSetChangeObserver() {
                public void a() {
                    FragmentMaxLifecycleEnforcer.this.d(true);
                }
            };
            this.f16549b = r22;
            FragmentStateAdapter.this.Z(r22);
            AnonymousClass3 r23 = new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f16550c = r23;
            FragmentStateAdapter.this.f16535d.a(r23);
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).x(this.f16548a);
            FragmentStateAdapter.this.c0(this.f16549b);
            FragmentStateAdapter.this.f16535d.d(this.f16550c);
            this.f16551d = null;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z) {
            int currentItem;
            Fragment h2;
            if (!FragmentStateAdapter.this.x0() && this.f16551d.getScrollState() == 0 && !FragmentStateAdapter.this.f16537f.n() && FragmentStateAdapter.this.b() != 0 && (currentItem = this.f16551d.getCurrentItem()) < FragmentStateAdapter.this.b()) {
                long B = FragmentStateAdapter.this.B(currentItem);
                if ((B != this.f16552e || z) && (h2 = FragmentStateAdapter.this.f16537f.h(B)) != null && h2.y0()) {
                    this.f16552e = B;
                    FragmentTransaction u = FragmentStateAdapter.this.f16536e.u();
                    ArrayList<List> arrayList = new ArrayList<>();
                    Fragment fragment = null;
                    for (int i2 = 0; i2 < FragmentStateAdapter.this.f16537f.y(); i2++) {
                        long o = FragmentStateAdapter.this.f16537f.o(i2);
                        Fragment z2 = FragmentStateAdapter.this.f16537f.z(i2);
                        if (z2.y0()) {
                            if (o != this.f16552e) {
                                Lifecycle.State state = Lifecycle.State.STARTED;
                                u.O(z2, state);
                                arrayList.add(FragmentStateAdapter.this.f16541j.a(z2, state));
                            } else {
                                fragment = z2;
                            }
                            z2.q2(o == this.f16552e);
                        }
                    }
                    if (fragment != null) {
                        Lifecycle.State state2 = Lifecycle.State.RESUMED;
                        u.O(fragment, state2);
                        arrayList.add(FragmentStateAdapter.this.f16541j.a(fragment, state2));
                    }
                    if (!u.A()) {
                        u.s();
                        Collections.reverse(arrayList);
                        for (List b2 : arrayList) {
                            FragmentStateAdapter.this.f16541j.b(b2);
                        }
                    }
                }
            }
        }
    }

    public static abstract class FragmentTransactionCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private static final OnPostEventListener f16556a = new OnPostEventListener() {
            public void a() {
            }
        };

        public interface OnPostEventListener {
            void a();
        }

        @NonNull
        public OnPostEventListener a(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
            return f16556a;
        }

        @NonNull
        public OnPostEventListener b(@NonNull Fragment fragment) {
            return f16556a;
        }

        @NonNull
        public OnPostEventListener c(@NonNull Fragment fragment) {
            return f16556a;
        }

        @NonNull
        @ExperimentalFragmentStateAdapterApi
        public OnPostEventListener d(@NonNull Fragment fragment) {
            return f16556a;
        }
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.z(), fragment.a());
    }

    @NonNull
    private static String g0(@NonNull String str, long j2) {
        return str + j2;
    }

    private void h0(int i2) {
        long B = B(i2);
        if (!this.f16537f.d(B)) {
            Fragment f0 = f0(i2);
            f0.p2(this.f16538g.h(B));
            this.f16537f.p(B, f0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r3 = r3.q0();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j0(long r3) {
        /*
            r2 = this;
            androidx.collection.LongSparseArray<java.lang.Integer> r0 = r2.f16539h
            boolean r0 = r0.d(r3)
            r1 = 1
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.collection.LongSparseArray<androidx.fragment.app.Fragment> r0 = r2.f16537f
            java.lang.Object r3 = r0.h(r3)
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r4 = 0
            if (r3 != 0) goto L_0x0016
            return r4
        L_0x0016:
            android.view.View r3 = r3.q0()
            if (r3 != 0) goto L_0x001d
            return r4
        L_0x001d:
            android.view.ViewParent r3 = r3.getParent()
            if (r3 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.adapter.FragmentStateAdapter.j0(long):boolean");
    }

    private static boolean k0(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long l0(int i2) {
        Long l2 = null;
        for (int i3 = 0; i3 < this.f16539h.y(); i3++) {
            if (this.f16539h.z(i3).intValue() == i2) {
                if (l2 == null) {
                    l2 = Long.valueOf(this.f16539h.o(i3));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l2;
    }

    private static long r0(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void u0(long j2) {
        ViewParent parent;
        Fragment h2 = this.f16537f.h(j2);
        if (h2 != null) {
            if (!(h2.q0() == null || (parent = h2.q0().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!e0(j2)) {
                this.f16538g.s(j2);
            }
            if (!h2.y0()) {
                this.f16537f.s(j2);
            } else if (x0()) {
                this.f16543l = true;
            } else {
                if (h2.y0() && e0(j2)) {
                    List<FragmentTransactionCallback.OnPostEventListener> e2 = this.f16541j.e(h2);
                    Fragment.SavedState T1 = this.f16536e.T1(h2);
                    this.f16541j.b(e2);
                    this.f16538g.p(j2, T1);
                }
                List<FragmentTransactionCallback.OnPostEventListener> d2 = this.f16541j.d(h2);
                try {
                    this.f16536e.u().B(h2).s();
                    this.f16537f.s(j2);
                } finally {
                    this.f16541j.b(d2);
                }
            }
        }
    }

    private void v0() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass3 r1 = new Runnable() {
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f16542k = false;
                fragmentStateAdapter.i0();
            }
        };
        this.f16535d.a(new LifecycleEventObserver() {
            public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r1);
                    lifecycleOwner.a().d(this);
                }
            }
        });
        handler.postDelayed(r1, o);
    }

    private void w0(final Fragment fragment, @NonNull final FrameLayout frameLayout) {
        this.f16536e.B1(new FragmentManager.FragmentLifecycleCallbacks() {
            public void m(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.f2(this);
                    FragmentStateAdapter.this.d0(view, frameLayout);
                }
            }
        }, false);
    }

    public long B(int i2) {
        return (long) i2;
    }

    @CallSuper
    public void Q(@NonNull RecyclerView recyclerView) {
        Preconditions.a(this.f16540i == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f16540i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @CallSuper
    public void U(@NonNull RecyclerView recyclerView) {
        this.f16540i.c(recyclerView);
        this.f16540i = null;
    }

    @NonNull
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f16537f.y() + this.f16538g.y());
        for (int i2 = 0; i2 < this.f16537f.y(); i2++) {
            long o2 = this.f16537f.o(i2);
            Fragment h2 = this.f16537f.h(o2);
            if (h2 != null && h2.y0()) {
                this.f16536e.A1(bundle, g0(f16533m, o2), h2);
            }
        }
        for (int i3 = 0; i3 < this.f16538g.y(); i3++) {
            long o3 = this.f16538g.o(i3);
            if (e0(o3)) {
                bundle.putParcelable(g0(f16534n, o3), this.f16538g.h(o3));
            }
        }
        return bundle;
    }

    public final void a0(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public final void d(@NonNull Parcelable parcelable) {
        long r0;
        Object obj;
        LongSparseArray longSparseArray;
        if (!this.f16538g.n() || !this.f16537f.n()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (k0(next, f16533m)) {
                r0 = r0(next, f16533m);
                obj = this.f16536e.E0(bundle, next);
                longSparseArray = this.f16537f;
            } else if (k0(next, f16534n)) {
                r0 = r0(next, f16534n);
                obj = (Fragment.SavedState) bundle.getParcelable(next);
                if (e0(r0)) {
                    longSparseArray = this.f16538g;
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
            longSparseArray.p(r0, obj);
        }
        if (!this.f16537f.n()) {
            this.f16543l = true;
            this.f16542k = true;
            i0();
            v0();
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean e0(long j2) {
        return j2 >= 0 && j2 < ((long) b());
    }

    @NonNull
    public abstract Fragment f0(int i2);

    /* access modifiers changed from: package-private */
    public void i0() {
        if (this.f16543l && !x0()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i2 = 0; i2 < this.f16537f.y(); i2++) {
                long o2 = this.f16537f.o(i2);
                if (!e0(o2)) {
                    arraySet.add(Long.valueOf(o2));
                    this.f16539h.s(o2);
                }
            }
            if (!this.f16542k) {
                this.f16543l = false;
                for (int i3 = 0; i3 < this.f16537f.y(); i3++) {
                    long o3 = this.f16537f.o(i3);
                    if (!j0(o3)) {
                        arraySet.add(Long.valueOf(o3));
                    }
                }
            }
            for (Long longValue : arraySet) {
                u0(longValue.longValue());
            }
        }
    }

    /* renamed from: m0 */
    public final void R(@NonNull FragmentViewHolder fragmentViewHolder, int i2) {
        long E = fragmentViewHolder.E();
        int id = fragmentViewHolder.j0().getId();
        Long l0 = l0(id);
        if (!(l0 == null || l0.longValue() == E)) {
            u0(l0.longValue());
            this.f16539h.s(l0.longValue());
        }
        this.f16539h.p(E, Integer.valueOf(id));
        h0(i2);
        if (ViewCompat.R0(fragmentViewHolder.j0())) {
            s0(fragmentViewHolder);
        }
        i0();
    }

    @NonNull
    /* renamed from: n0 */
    public final FragmentViewHolder T(@NonNull ViewGroup viewGroup, int i2) {
        return FragmentViewHolder.i0(viewGroup);
    }

    /* renamed from: o0 */
    public final boolean V(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    /* renamed from: p0 */
    public final void W(@NonNull FragmentViewHolder fragmentViewHolder) {
        s0(fragmentViewHolder);
        i0();
    }

    /* renamed from: q0 */
    public final void Y(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long l0 = l0(fragmentViewHolder.j0().getId());
        if (l0 != null) {
            u0(l0.longValue());
            this.f16539h.s(l0.longValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void s0(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment h2 = this.f16537f.h(fragmentViewHolder.E());
        if (h2 != null) {
            FrameLayout j0 = fragmentViewHolder.j0();
            View q0 = h2.q0();
            if (!h2.y0() && q0 != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (h2.y0() && q0 == null) {
                w0(h2, j0);
            } else if (!h2.y0() || q0.getParent() == null) {
                if (h2.y0()) {
                    d0(q0, j0);
                } else if (!x0()) {
                    w0(h2, j0);
                    List<FragmentTransactionCallback.OnPostEventListener> c2 = this.f16541j.c(h2);
                    try {
                        h2.q2(false);
                        FragmentTransaction u = this.f16536e.u();
                        u.k(h2, "f" + fragmentViewHolder.E()).O(h2, Lifecycle.State.STARTED).s();
                        this.f16540i.d(false);
                    } finally {
                        this.f16541j.b(c2);
                    }
                } else if (!this.f16536e.V0()) {
                    this.f16535d.a(new LifecycleEventObserver() {
                        public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.x0()) {
                                lifecycleOwner.a().d(this);
                                if (ViewCompat.R0(fragmentViewHolder.j0())) {
                                    FragmentStateAdapter.this.s0(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (q0.getParent() != j0) {
                d0(q0, j0);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public void t0(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.f16541j.f(fragmentTransactionCallback);
    }

    /* access modifiers changed from: package-private */
    public boolean x0() {
        return this.f16536e.d1();
    }

    public void y0(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.f16541j.g(fragmentTransactionCallback);
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.k0(), fragmentActivity.a());
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.f16537f = new LongSparseArray<>();
        this.f16538g = new LongSparseArray<>();
        this.f16539h = new LongSparseArray<>();
        this.f16541j = new FragmentEventDispatcher();
        this.f16542k = false;
        this.f16543l = false;
        this.f16536e = fragmentManager;
        this.f16535d = lifecycle;
        super.a0(true);
    }
}
