package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.ViewModelStoreOwner;
import org.apache.commons.lang3.StringUtils;

class FragmentStateManager {

    /* renamed from: f  reason: collision with root package name */
    private static final String f7962f = "FragmentManager";

    /* renamed from: g  reason: collision with root package name */
    private static final String f7963g = "android:target_req_state";

    /* renamed from: h  reason: collision with root package name */
    private static final String f7964h = "android:target_state";

    /* renamed from: i  reason: collision with root package name */
    private static final String f7965i = "android:view_state";

    /* renamed from: j  reason: collision with root package name */
    private static final String f7966j = "android:view_registry_state";

    /* renamed from: k  reason: collision with root package name */
    private static final String f7967k = "android:user_visible_hint";

    /* renamed from: a  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f7968a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentStore f7969b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f7970c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7971d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f7972e = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7973a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7973a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7973a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7973a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7973a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.AnonymousClass2.<clinit>():void");
        }
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment) {
        this.f7968a = fragmentLifecycleCallbacksDispatcher;
        this.f7969b = fragmentStore;
        this.f7970c = fragment;
    }

    private boolean l(@NonNull View view) {
        if (view == this.f7970c.B3) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f7970c.B3) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f7970c.L1(bundle);
        this.f7968a.j(this.f7970c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f7970c.B3 != null) {
            t();
        }
        if (this.f7970c.Y != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(f7965i, this.f7970c.Y);
        }
        if (this.f7970c.Z != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(f7966j, this.f7970c.Z);
        }
        if (!this.f7970c.D3) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f7967k, this.f7970c.D3);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f7970c);
        }
        Fragment fragment = this.f7970c;
        fragment.r1(fragment.X);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f7968a;
        Fragment fragment2 = this.f7970c;
        fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.X, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j2 = this.f7969b.j(this.f7970c);
        Fragment fragment = this.f7970c;
        fragment.A3.addView(fragment.B3, j2);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f7970c);
        }
        Fragment fragment = this.f7970c;
        Fragment fragment2 = fragment.a3;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager o = this.f7969b.o(fragment2.Y2);
            if (o != null) {
                Fragment fragment3 = this.f7970c;
                fragment3.b3 = fragment3.a3.Y2;
                fragment3.a3 = null;
                fragmentStateManager = o;
            } else {
                throw new IllegalStateException("Fragment " + this.f7970c + " declared target fragment " + this.f7970c.a3 + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.b3;
            if (str != null && (fragmentStateManager = this.f7969b.o(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f7970c + " declared target fragment " + this.f7970c.b3 + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.m();
        }
        Fragment fragment4 = this.f7970c;
        fragment4.n3 = fragment4.m3.J0();
        Fragment fragment5 = this.f7970c;
        fragment5.p3 = fragment5.m3.M0();
        this.f7968a.g(this.f7970c, false);
        this.f7970c.s1();
        this.f7968a.b(this.f7970c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        Fragment fragment = this.f7970c;
        if (fragment.m3 == null) {
            return fragment.s;
        }
        int i2 = this.f7972e;
        int i3 = AnonymousClass2.f7973a[fragment.K3.ordinal()];
        if (i3 != 1) {
            i2 = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(i2, -1) : Math.min(i2, 0) : Math.min(i2, 1) : Math.min(i2, 5);
        }
        Fragment fragment2 = this.f7970c;
        if (fragment2.h3) {
            if (fragment2.i3) {
                i2 = Math.max(this.f7972e, 2);
                View view = this.f7970c.B3;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f7972e < 4 ? Math.min(i2, fragment2.s) : Math.min(i2, 1);
            }
        }
        if (!this.f7970c.e3) {
            i2 = Math.min(i2, 1);
        }
        Fragment fragment3 = this.f7970c;
        ViewGroup viewGroup = fragment3.A3;
        SpecialEffectsController.Operation.LifecycleImpact l2 = viewGroup != null ? SpecialEffectsController.n(viewGroup, fragment3.V()).l(this) : null;
        if (l2 == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (l2 == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            Fragment fragment4 = this.f7970c;
            if (fragment4.f3) {
                i2 = fragment4.B0() ? Math.min(i2, 1) : Math.min(i2, -1);
            }
        }
        Fragment fragment5 = this.f7970c;
        if (fragment5.C3 && fragment5.s < 5) {
            i2 = Math.min(i2, 4);
        }
        if (FragmentManager.W0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i2 + " for " + this.f7970c);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f7970c);
        }
        Fragment fragment = this.f7970c;
        if (!fragment.I3) {
            this.f7968a.h(fragment, fragment.X, false);
            Fragment fragment2 = this.f7970c;
            fragment2.v1(fragment2.X);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f7968a;
            Fragment fragment3 = this.f7970c;
            fragmentLifecycleCallbacksDispatcher.c(fragment3, fragment3.X, false);
            return;
        }
        fragment.c2(fragment.X);
        this.f7970c.s = 1;
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r7 = this;
            androidx.fragment.app.Fragment r0 = r7.f7970c
            boolean r0 = r0.h3
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.W0(r0)
            java.lang.String r1 = "FragmentManager"
            if (r0 == 0) goto L_0x0026
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "moveto CREATE_VIEW: "
            r0.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f7970c
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L_0x0026:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.os.Bundle r2 = r0.X
            android.view.LayoutInflater r0 = r0.B1(r2)
            androidx.fragment.app.Fragment r2 = r7.f7970c
            android.view.ViewGroup r3 = r2.A3
            if (r3 == 0) goto L_0x0036
            goto L_0x00c0
        L_0x0036:
            int r3 = r2.r3
            if (r3 == 0) goto L_0x00bf
            r4 = -1
            if (r3 == r4) goto L_0x00a1
            androidx.fragment.app.FragmentManager r2 = r2.m3
            androidx.fragment.app.FragmentContainer r2 = r2.D0()
            androidx.fragment.app.Fragment r3 = r7.f7970c
            int r3 = r3.r3
            android.view.View r2 = r2.g(r3)
            r3 = r2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x0097
            androidx.fragment.app.Fragment r2 = r7.f7970c
            boolean r4 = r2.j3
            if (r4 == 0) goto L_0x0057
            goto L_0x00c0
        L_0x0057:
            android.content.res.Resources r0 = r2.b0()     // Catch:{ NotFoundException -> 0x0064 }
            androidx.fragment.app.Fragment r1 = r7.f7970c     // Catch:{ NotFoundException -> 0x0064 }
            int r1 = r1.r3     // Catch:{ NotFoundException -> 0x0064 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            java.lang.String r0 = "unknown"
        L_0x0066:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            androidx.fragment.app.Fragment r3 = r7.f7970c
            int r3 = r3.r3
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f7970c
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0097:
            boolean r2 = r3 instanceof androidx.fragment.app.FragmentContainerView
            if (r2 != 0) goto L_0x00c0
            androidx.fragment.app.Fragment r2 = r7.f7970c
            androidx.fragment.app.strictmode.FragmentStrictMode.r(r2, r3)
            goto L_0x00c0
        L_0x00a1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f7970c
            r1.append(r2)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00bf:
            r3 = 0
        L_0x00c0:
            androidx.fragment.app.Fragment r2 = r7.f7970c
            r2.A3 = r3
            android.os.Bundle r4 = r2.X
            r2.x1(r0, r3, r4)
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            r2 = 2
            if (r0 == 0) goto L_0x0173
            r4 = 0
            r0.setSaveFromParentEnabled(r4)
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r5 = r0.B3
            int r6 = androidx.fragment.R.id.f7839a
            r5.setTag(r6, r0)
            if (r3 == 0) goto L_0x00e2
            r7.b()
        L_0x00e2:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            boolean r3 = r0.t3
            if (r3 == 0) goto L_0x00ef
            android.view.View r0 = r0.B3
            r3 = 8
            r0.setVisibility(r3)
        L_0x00ef:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            boolean r0 = androidx.core.view.ViewCompat.R0(r0)
            if (r0 == 0) goto L_0x0101
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            androidx.core.view.ViewCompat.B1(r0)
            goto L_0x010d
        L_0x0101:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            androidx.fragment.app.FragmentStateManager$1 r3 = new androidx.fragment.app.FragmentStateManager$1
            r3.<init>(r0)
            r0.addOnAttachStateChangeListener(r3)
        L_0x010d:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            r0.O1()
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r0 = r7.f7968a
            androidx.fragment.app.Fragment r3 = r7.f7970c
            android.view.View r5 = r3.B3
            android.os.Bundle r6 = r3.X
            r0.m(r3, r5, r6, r4)
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            int r0 = r0.getVisibility()
            androidx.fragment.app.Fragment r3 = r7.f7970c
            android.view.View r3 = r3.B3
            float r3 = r3.getAlpha()
            androidx.fragment.app.Fragment r4 = r7.f7970c
            r4.t2(r3)
            androidx.fragment.app.Fragment r3 = r7.f7970c
            android.view.ViewGroup r4 = r3.A3
            if (r4 == 0) goto L_0x0173
            if (r0 != 0) goto L_0x0173
            android.view.View r0 = r3.B3
            android.view.View r0 = r0.findFocus()
            if (r0 == 0) goto L_0x016b
            androidx.fragment.app.Fragment r3 = r7.f7970c
            r3.n2(r0)
            boolean r3 = androidx.fragment.app.FragmentManager.W0(r2)
            if (r3 == 0) goto L_0x016b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestFocus: Saved focused view "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " for Fragment "
            r3.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f7970c
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.v(r1, r0)
        L_0x016b:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            android.view.View r0 = r0.B3
            r1 = 0
            r0.setAlpha(r1)
        L_0x0173:
            androidx.fragment.app.Fragment r0 = r7.f7970c
            r0.s = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.f():void");
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Fragment f2;
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f7970c);
        }
        Fragment fragment = this.f7970c;
        boolean z = true;
        boolean z2 = fragment.f3 && !fragment.B0();
        if (z2) {
            Fragment fragment2 = this.f7970c;
            if (!fragment2.g3) {
                this.f7969b.C(fragment2.Y2, (FragmentState) null);
            }
        }
        if (z2 || this.f7969b.q().u(this.f7970c)) {
            FragmentHostCallback<?> fragmentHostCallback = this.f7970c.n3;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = this.f7969b.q().q();
            } else if (fragmentHostCallback.m() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.m()).isChangingConfigurations();
            }
            if ((z2 && !this.f7970c.g3) || z) {
                this.f7969b.q().h(this.f7970c);
            }
            this.f7970c.y1();
            this.f7968a.d(this.f7970c, false);
            for (FragmentStateManager next : this.f7969b.l()) {
                if (next != null) {
                    Fragment k2 = next.k();
                    if (this.f7970c.Y2.equals(k2.b3)) {
                        k2.a3 = this.f7970c;
                        k2.b3 = null;
                    }
                }
            }
            Fragment fragment3 = this.f7970c;
            String str = fragment3.b3;
            if (str != null) {
                fragment3.a3 = this.f7969b.f(str);
            }
            this.f7969b.t(this);
            return;
        }
        String str2 = this.f7970c.b3;
        if (!(str2 == null || (f2 = this.f7969b.f(str2)) == null || !f2.v3)) {
            this.f7970c.a3 = f2;
        }
        this.f7970c.s = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f7970c);
        }
        Fragment fragment = this.f7970c;
        ViewGroup viewGroup = fragment.A3;
        if (!(viewGroup == null || (view = fragment.B3) == null)) {
            viewGroup.removeView(view);
        }
        this.f7970c.z1();
        this.f7968a.n(this.f7970c, false);
        Fragment fragment2 = this.f7970c;
        fragment2.A3 = null;
        fragment2.B3 = null;
        fragment2.M3 = null;
        fragment2.N3.r(null);
        this.f7970c.i3 = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f7970c);
        }
        this.f7970c.A1();
        this.f7968a.e(this.f7970c, false);
        Fragment fragment = this.f7970c;
        fragment.s = -1;
        fragment.n3 = null;
        fragment.p3 = null;
        fragment.m3 = null;
        if ((fragment.f3 && !fragment.B0()) || this.f7969b.q().u(this.f7970c)) {
            if (FragmentManager.W0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f7970c);
            }
            this.f7970c.v0();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f7970c;
        if (fragment.h3 && fragment.i3 && !fragment.k3) {
            if (FragmentManager.W0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f7970c);
            }
            Fragment fragment2 = this.f7970c;
            fragment2.x1(fragment2.B1(fragment2.X), (ViewGroup) null, this.f7970c.X);
            View view = this.f7970c.B3;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f7970c;
                fragment3.B3.setTag(R.id.f7839a, fragment3);
                Fragment fragment4 = this.f7970c;
                if (fragment4.t3) {
                    fragment4.B3.setVisibility(8);
                }
                this.f7970c.O1();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f7968a;
                Fragment fragment5 = this.f7970c;
                fragmentLifecycleCallbacksDispatcher.m(fragment5, fragment5.B3, fragment5.X, false);
                this.f7970c.s = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment k() {
        return this.f7970c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f7971d) {
            try {
                this.f7971d = true;
                boolean z = false;
                while (true) {
                    int d2 = d();
                    Fragment fragment = this.f7970c;
                    int i2 = fragment.s;
                    if (d2 != i2) {
                        if (d2 <= i2) {
                            switch (i2 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    if (fragment.g3 && this.f7969b.r(fragment.Y2) == null) {
                                        s();
                                    }
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f7970c.s = 1;
                                    break;
                                case 2:
                                    fragment.i3 = false;
                                    fragment.s = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.W0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f7970c);
                                    }
                                    Fragment fragment2 = this.f7970c;
                                    if (fragment2.g3) {
                                        s();
                                    } else if (fragment2.B3 != null && fragment2.Y == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f7970c;
                                    if (!(fragment3.B3 == null || (viewGroup2 = fragment3.A3) == null)) {
                                        SpecialEffectsController.n(viewGroup2, fragment3.V()).d(this);
                                    }
                                    this.f7970c.s = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.s = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i2 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.B3 == null || (viewGroup3 = fragment.A3) == null)) {
                                        SpecialEffectsController.n(viewGroup3, fragment.V()).b(SpecialEffectsController.Operation.State.b(this.f7970c.B3.getVisibility()), this);
                                    }
                                    this.f7970c.s = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.s = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                        z = true;
                    } else {
                        if (!z && i2 == -1 && fragment.f3 && !fragment.B0() && !this.f7970c.g3) {
                            if (FragmentManager.W0(3)) {
                                Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f7970c);
                            }
                            this.f7969b.q().h(this.f7970c);
                            this.f7969b.t(this);
                            if (FragmentManager.W0(3)) {
                                Log.d("FragmentManager", "initState called for fragment: " + this.f7970c);
                            }
                            this.f7970c.v0();
                        }
                        Fragment fragment4 = this.f7970c;
                        if (fragment4.G3) {
                            if (!(fragment4.B3 == null || (viewGroup = fragment4.A3) == null)) {
                                SpecialEffectsController n2 = SpecialEffectsController.n(viewGroup, fragment4.V());
                                if (this.f7970c.t3) {
                                    n2.c(this);
                                } else {
                                    n2.e(this);
                                }
                            }
                            Fragment fragment5 = this.f7970c;
                            FragmentManager fragmentManager = fragment5.m3;
                            if (fragmentManager != null) {
                                fragmentManager.U0(fragment5);
                            }
                            Fragment fragment6 = this.f7970c;
                            fragment6.G3 = false;
                            fragment6.a1(fragment6.t3);
                            this.f7970c.o3.Q();
                        }
                        this.f7971d = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                this.f7971d = false;
                throw th;
            }
        } else if (FragmentManager.W0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f7970c);
        }
        this.f7970c.G1();
        this.f7968a.f(this.f7970c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.f7970c.X;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f7970c;
            fragment.Y = fragment.X.getSparseParcelableArray(f7965i);
            Fragment fragment2 = this.f7970c;
            fragment2.Z = fragment2.X.getBundle(f7966j);
            Fragment fragment3 = this.f7970c;
            fragment3.b3 = fragment3.X.getString(f7964h);
            Fragment fragment4 = this.f7970c;
            if (fragment4.b3 != null) {
                fragment4.c3 = fragment4.X.getInt(f7963g, 0);
            }
            Fragment fragment5 = this.f7970c;
            Boolean bool = fragment5.X2;
            if (bool != null) {
                fragment5.D3 = bool.booleanValue();
                this.f7970c.X2 = null;
            } else {
                fragment5.D3 = fragment5.X.getBoolean(f7967k, true);
            }
            Fragment fragment6 = this.f7970c;
            if (!fragment6.D3) {
                fragment6.C3 = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f7970c);
        }
        View L = this.f7970c.L();
        if (L != null && l(L)) {
            boolean requestFocus = L.requestFocus();
            if (FragmentManager.W0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(L);
                sb.append(StringUtils.SPACE);
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f7970c);
                sb.append(" resulting in focused view ");
                sb.append(this.f7970c.B3.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f7970c.n2((View) null);
        this.f7970c.K1();
        this.f7968a.i(this.f7970c, false);
        Fragment fragment = this.f7970c;
        fragment.X = null;
        fragment.Y = null;
        fragment.Z = null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment.SavedState r() {
        Bundle q;
        if (this.f7970c.s <= -1 || (q = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        FragmentState fragmentState = new FragmentState(this.f7970c);
        Fragment fragment = this.f7970c;
        if (fragment.s <= -1 || fragmentState.f3 != null) {
            fragmentState.f3 = fragment.X;
        } else {
            Bundle q = q();
            fragmentState.f3 = q;
            if (this.f7970c.b3 != null) {
                if (q == null) {
                    fragmentState.f3 = new Bundle();
                }
                fragmentState.f3.putString(f7964h, this.f7970c.b3);
                int i2 = this.f7970c.c3;
                if (i2 != 0) {
                    fragmentState.f3.putInt(f7963g, i2);
                }
            }
        }
        this.f7969b.C(this.f7970c.Y2, fragmentState);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f7970c.B3 != null) {
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + this.f7970c + " with view " + this.f7970c.B3);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f7970c.B3.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f7970c.Y = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f7970c.M3.g(bundle);
            if (!bundle.isEmpty()) {
                this.f7970c.Z = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        this.f7972e = i2;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f7970c);
        }
        this.f7970c.M1();
        this.f7968a.k(this.f7970c, false);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.W0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f7970c);
        }
        this.f7970c.N1();
        this.f7968a.l(this.f7970c, false);
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.f7968a = fragmentLifecycleCallbacksDispatcher;
        this.f7969b = fragmentStore;
        this.f7970c = fragment;
        fragment.Y = null;
        fragment.Z = null;
        fragment.l3 = 0;
        fragment.i3 = false;
        fragment.e3 = false;
        Fragment fragment2 = fragment.a3;
        fragment.b3 = fragment2 != null ? fragment2.Y2 : null;
        fragment.a3 = null;
        Bundle bundle = fragmentState.f3;
        fragment.X = bundle == null ? new Bundle() : bundle;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.f7968a = fragmentLifecycleCallbacksDispatcher;
        this.f7969b = fragmentStore;
        Fragment a2 = fragmentState.a(fragmentFactory, classLoader);
        this.f7970c = a2;
        if (FragmentManager.W0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }
}
