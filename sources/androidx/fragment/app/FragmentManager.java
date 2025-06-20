package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

public abstract class FragmentManager implements FragmentResultOwner {
    static final String S = "android:support:fragments";
    static final String T = "state";
    static final String U = "result_";
    static final String V = "state";
    static final String W = "fragment_";
    private static boolean X = false;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String Y = "FragmentManager";
    public static final int Z = 1;
    private static final String a0 = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    private FragmentFactory A = new FragmentFactory() {
        @NonNull
        public Fragment a(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.J0().d(FragmentManager.this.J0().m(), str, (Bundle) null);
        }
    };
    private SpecialEffectsControllerFactory B = null;
    private SpecialEffectsControllerFactory C = new SpecialEffectsControllerFactory() {
        @NonNull
        public SpecialEffectsController a(@NonNull ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    private ActivityResultLauncher<Intent> D;
    private ActivityResultLauncher<IntentSenderRequest> E;
    private ActivityResultLauncher<String[]> F;
    ArrayDeque<LaunchedFragmentInfo> G = new ArrayDeque<>();
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList<BackStackRecord> M;
    private ArrayList<Boolean> N;
    private ArrayList<Fragment> O;
    private FragmentManagerViewModel P;
    private FragmentStrictMode.Policy Q;
    private Runnable R = new Runnable() {
        public void run() {
            FragmentManager.this.j0(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<OpGenerator> f7907a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f7908b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FragmentStore f7909c = new FragmentStore();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<BackStackRecord> f7910d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f7911e;

    /* renamed from: f  reason: collision with root package name */
    private final FragmentLayoutInflaterFactory f7912f = new FragmentLayoutInflaterFactory(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f7913g;

    /* renamed from: h  reason: collision with root package name */
    private final OnBackPressedCallback f7914h = new OnBackPressedCallback(false) {
        public void d() {
            FragmentManager.this.S0();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f7915i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, BackStackState> f7916j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Bundle> f7917k = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, LifecycleAwareResultListener> f7918l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<OnBackStackChangedListener> f7919m;

    /* renamed from: n  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f7920n = new FragmentLifecycleCallbacksDispatcher(this);
    private final CopyOnWriteArrayList<FragmentOnAttachListener> o = new CopyOnWriteArrayList<>();
    private final Consumer<Configuration> p = new e(this);
    private final Consumer<Integer> q = new f(this);
    private final Consumer<MultiWindowModeChangedInfo> r = new g(this);
    private final Consumer<PictureInPictureModeChangedInfo> s = new h(this);
    private final MenuProvider t = new MenuProvider() {
        public boolean a(@NonNull MenuItem menuItem) {
            return FragmentManager.this.R(menuItem);
        }

        public void b(@NonNull Menu menu) {
            FragmentManager.this.S(menu);
        }

        public void c(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            FragmentManager.this.K(menu, menuInflater);
        }

        public void d(@NonNull Menu menu) {
            FragmentManager.this.W(menu);
        }
    };
    int u = -1;
    private FragmentHostCallback<?> v;
    private FragmentContainer w;
    private Fragment x;
    @Nullable
    Fragment y;
    private FragmentFactory z = null;

    public interface BackStackEntry {
        @Deprecated
        @Nullable
        CharSequence a();

        @StringRes
        @Deprecated
        int c();

        @StringRes
        @Deprecated
        int d();

        @Deprecated
        @Nullable
        CharSequence e();

        int getId();

        @Nullable
        String getName();
    }

    private class ClearBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        private final String f7928a;

        ClearBackStackState(@NonNull String str) {
            this.f7928a = str;
        }

        public boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.z(arrayList, arrayList2, this.f7928a);
        }
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @NonNull
        /* renamed from: d */
        public Intent a(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.f2516b);
            Intent a2 = intentSenderRequest.a();
            if (!(a2 == null || (bundleExtra = a2.getBundleExtra(ActivityResultContracts.StartActivityForResult.f2514b)) == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.f2514b, bundleExtra);
                a2.removeExtra(ActivityResultContracts.StartActivityForResult.f2514b);
                if (a2.getBooleanExtra(FragmentManager.a0, false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.d()).b((Intent) null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.f2517c, intentSenderRequest);
            if (FragmentManager.W0(2)) {
                Log.v(FragmentManager.Y, "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @NonNull
        /* renamed from: e */
        public ActivityResult c(int i2, @Nullable Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void b(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void c(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void d(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void e(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void f(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void g(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void h(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void i(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void j(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void k(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void l(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void m(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void n(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() {
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        };
        int X;
        String s;

        LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.s = parcel.readString();
            this.X = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.s);
            parcel.writeInt(this.X);
        }

        LaunchedFragmentInfo(@NonNull String str, int i2) {
            this.s = str;
            this.X = i2;
        }
    }

    private static class LifecycleAwareResultListener implements FragmentResultListener {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f7930a;

        /* renamed from: b  reason: collision with root package name */
        private final FragmentResultListener f7931b;

        /* renamed from: c  reason: collision with root package name */
        private final LifecycleEventObserver f7932c;

        LifecycleAwareResultListener(@NonNull Lifecycle lifecycle, @NonNull FragmentResultListener fragmentResultListener, @NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f7930a = lifecycle;
            this.f7931b = fragmentResultListener;
            this.f7932c = lifecycleEventObserver;
        }

        public void a(@NonNull String str, @NonNull Bundle bundle) {
            this.f7931b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f7930a.b().b(state);
        }

        public void c() {
            this.f7930a.d(this.f7932c);
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void a();
    }

    interface OpGenerator {
        boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    private class PopBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        final String f7933a;

        /* renamed from: b  reason: collision with root package name */
        final int f7934b;

        /* renamed from: c  reason: collision with root package name */
        final int f7935c;

        PopBackStackState(@Nullable String str, int i2, int i3) {
            this.f7933a = str;
            this.f7934b = i2;
            this.f7935c = i3;
        }

        public boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.y;
            if (fragment != null && this.f7934b < 0 && this.f7933a == null && fragment.z().v1()) {
                return false;
            }
            return FragmentManager.this.z1(arrayList, arrayList2, this.f7933a, this.f7934b, this.f7935c);
        }
    }

    private class RestoreBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        private final String f7937a;

        RestoreBackStackState(@NonNull String str) {
            this.f7937a = str;
        }

        public boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.K1(arrayList, arrayList2, this.f7937a);
        }
    }

    private class SaveBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        private final String f7939a;

        SaveBackStackState(@NonNull String str) {
            this.f7939a = str;
        }

        public boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.S1(arrayList, arrayList2, this.f7939a);
        }
    }

    private void A() {
        FragmentHostCallback<?> fragmentHostCallback = this.v;
        if (fragmentHostCallback instanceof ViewModelStoreOwner ? this.f7909c.q().q() : fragmentHostCallback.m() instanceof Activity ? !((Activity) this.v.m()).isChangingConfigurations() : true) {
            for (BackStackState backStackState : this.f7916j.values()) {
                for (String i2 : backStackState.s) {
                    this.f7909c.q().i(i2);
                }
            }
        }
    }

    private Set<SpecialEffectsController> B() {
        HashSet hashSet = new HashSet();
        for (FragmentStateManager k2 : this.f7909c.l()) {
            ViewGroup viewGroup = k2.k().A3;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, O0()));
            }
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> C(@NonNull ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<FragmentTransaction.Op> it2 = arrayList.get(i2).f7996c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = it2.next().f8009b;
                if (!(fragment == null || (viewGroup = fragment.A3) == null)) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    @NonNull
    private FragmentManagerViewModel C0(@NonNull Fragment fragment) {
        return this.P.l(fragment);
    }

    private ViewGroup F0(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.A3;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.r3 > 0 && this.w.i()) {
            View g2 = this.w.g(fragment.r3);
            if (g2 instanceof ViewGroup) {
                return (ViewGroup) g2;
            }
        }
        return null;
    }

    private void F1(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).r) {
                        if (i3 != i2) {
                            m0(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).r) {
                                i3++;
                            }
                        }
                        m0(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    m0(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void H1() {
        if (this.f7919m != null) {
            for (int i2 = 0; i2 < this.f7919m.size(); i2++) {
                this.f7919m.get(i2).a();
            }
        }
    }

    static int O1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 == 8194) {
            return FragmentTransaction.I;
        }
        if (i2 == 8197) {
            return FragmentTransaction.L;
        }
        if (i2 == 4099) {
            return FragmentTransaction.K;
        }
        if (i2 != 4100) {
            return 0;
        }
        return FragmentTransaction.M;
    }

    @Nullable
    static Fragment Q0(@NonNull View view) {
        Object tag = view.getTag(R.id.f7839a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void T(@Nullable Fragment fragment) {
        if (fragment != null && fragment.equals(o0(fragment.Y2))) {
            fragment.J1();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean W0(int i2) {
        return X || Log.isLoggable(Y, i2);
    }

    private boolean X0(@NonNull Fragment fragment) {
        return (fragment.x3 && fragment.y3) || fragment.o3.v();
    }

    private boolean Y0() {
        Fragment fragment = this.x;
        if (fragment == null) {
            return true;
        }
        return fragment.y0() && this.x.V().Y0();
    }

    /* JADX INFO: finally extract failed */
    private void a0(int i2) {
        try {
            this.f7908b = true;
            this.f7909c.d(i2);
            m1(i2, false);
            for (SpecialEffectsController j2 : B()) {
                j2.j();
            }
            this.f7908b = false;
            j0(true);
        } catch (Throwable th) {
            this.f7908b = false;
            throw th;
        }
    }

    private void b2(@NonNull Fragment fragment) {
        ViewGroup F0 = F0(fragment);
        if (F0 != null && fragment.D() + fragment.H() + fragment.X() + fragment.Y() > 0) {
            int i2 = R.id.f7841c;
            if (F0.getTag(i2) == null) {
                F0.setTag(i2, fragment);
            }
            ((Fragment) F0.getTag(i2)).s2(fragment.W());
        }
    }

    private void d0() {
        if (this.L) {
            this.L = false;
            d2();
        }
    }

    private void d2() {
        for (FragmentStateManager q1 : this.f7909c.l()) {
            q1(q1);
        }
    }

    private void e2(RuntimeException runtimeException) {
        Log.e(Y, runtimeException.getMessage());
        Log.e(Y, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(Y));
        FragmentHostCallback<?> fragmentHostCallback = this.v;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.o("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(Y, "Failed dumping state", e2);
            }
        } else {
            e0("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    @Deprecated
    public static void f0(boolean z2) {
        X = z2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(Configuration configuration) {
        if (Y0()) {
            H(configuration, false);
        }
    }

    private void g0() {
        for (SpecialEffectsController j2 : B()) {
            j2.j();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(Integer num) {
        if (Y0() && num.intValue() == 80) {
            N(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        r0 = r3.f7914h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (B0() <= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (b1(r3.x) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0.j(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g2() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r0 = r3.f7907a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r1 = r3.f7907a     // Catch:{ all -> 0x0013 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0013 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            androidx.activity.OnBackPressedCallback r1 = r3.f7914h     // Catch:{ all -> 0x0013 }
            r1.j(r2)     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x002c
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            androidx.activity.OnBackPressedCallback r0 = r3.f7914h
            int r1 = r3.B0()
            if (r1 <= 0) goto L_0x0027
            androidx.fragment.app.Fragment r1 = r3.x
            boolean r1 = r3.b1(r1)
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            r0.j(r2)
            return
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.g2():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (Y0()) {
            O(multiWindowModeChangedInfo.b(), false);
        }
    }

    private void i0(boolean z2) {
        if (this.f7908b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.v == null) {
            if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.v.n().getLooper()) {
            if (!z2) {
                w();
            }
            if (this.M == null) {
                this.M = new ArrayList<>();
                this.N = new ArrayList<>();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (Y0()) {
            V(pictureInPictureModeChangedInfo.b(), false);
        }
    }

    private static void l0(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            BackStackRecord backStackRecord = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                backStackRecord.U(-1);
                backStackRecord.a0();
            } else {
                backStackRecord.U(1);
                backStackRecord.Z();
            }
            i2++;
        }
    }

    private void m0(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3) {
        boolean z2 = arrayList.get(i2).r;
        ArrayList<Fragment> arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f7909c.p());
        Fragment N0 = N0();
        boolean z3 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            N0 = !arrayList2.get(i4).booleanValue() ? backStackRecord.b0(this.O, N0) : backStackRecord.d0(this.O, N0);
            z3 = z3 || backStackRecord.f8002i;
        }
        this.O.clear();
        if (!z2 && this.u >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator<FragmentTransaction.Op> it2 = arrayList.get(i5).f7996c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = it2.next().f8009b;
                    if (!(fragment == null || fragment.m3 == null)) {
                        this.f7909c.s(D(fragment));
                    }
                }
            }
        }
        l0(arrayList, arrayList2, i2, i3);
        boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
        for (int i6 = i2; i6 < i3; i6++) {
            BackStackRecord backStackRecord2 = arrayList.get(i6);
            if (booleanValue) {
                for (int size = backStackRecord2.f7996c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = backStackRecord2.f7996c.get(size).f8009b;
                    if (fragment2 != null) {
                        D(fragment2).m();
                    }
                }
            } else {
                Iterator<FragmentTransaction.Op> it3 = backStackRecord2.f7996c.iterator();
                while (it3.hasNext()) {
                    Fragment fragment3 = it3.next().f8009b;
                    if (fragment3 != null) {
                        D(fragment3).m();
                    }
                }
            }
        }
        m1(this.u, true);
        for (SpecialEffectsController next : C(arrayList, i2, i3)) {
            next.r(booleanValue);
            next.p();
            next.g();
        }
        while (i2 < i3) {
            BackStackRecord backStackRecord3 = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue() && backStackRecord3.P >= 0) {
                backStackRecord3.P = -1;
            }
            backStackRecord3.c0();
            i2++;
        }
        if (z3) {
            H1();
        }
    }

    private int p0(@Nullable String str, int i2, boolean z2) {
        ArrayList<BackStackRecord> arrayList = this.f7910d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i2 >= 0) {
            int size = this.f7910d.size() - 1;
            while (size >= 0) {
                BackStackRecord backStackRecord = this.f7910d.get(size);
                if ((str != null && str.equals(backStackRecord.getName())) || (i2 >= 0 && i2 == backStackRecord.P)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z2) {
                while (size > 0) {
                    BackStackRecord backStackRecord2 = this.f7910d.get(size - 1);
                    if ((str == null || !str.equals(backStackRecord2.getName())) && (i2 < 0 || i2 != backStackRecord2.P)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.f7910d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z2) {
            return 0;
        } else {
            return this.f7910d.size() - 1;
        }
    }

    @NonNull
    public static <F extends Fragment> F q0(@NonNull View view) {
        F v0 = v0(view);
        if (v0 != null) {
            return v0;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @NonNull
    static FragmentManager u0(@NonNull View view) {
        FragmentActivity fragmentActivity;
        Fragment v0 = v0(view);
        if (v0 == null) {
            Context context = view.getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    fragmentActivity = null;
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.k0();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (v0.y0()) {
            return v0.z();
        } else {
            throw new IllegalStateException("The Fragment " + v0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    @Nullable
    private static Fragment v0(@NonNull View view) {
        while (view != null) {
            Fragment Q0 = Q0(view);
            if (Q0 != null) {
                return Q0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void w() {
        if (d1()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void w0() {
        for (SpecialEffectsController k2 : B()) {
            k2.k();
        }
    }

    private void x() {
        this.f7908b = false;
        this.N.clear();
        this.M.clear();
    }

    private boolean x0(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.f7907a) {
            if (this.f7907a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f7907a.size();
                boolean z2 = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z2 |= this.f7907a.get(i2).b(arrayList, arrayList2);
                }
                return z2;
            } finally {
                this.f7907a.clear();
                this.v.n().removeCallbacks(this.R);
            }
        }
    }

    private boolean y1(@Nullable String str, int i2, int i3) {
        j0(false);
        i0(true);
        Fragment fragment = this.y;
        if (fragment != null && i2 < 0 && str == null && fragment.z().v1()) {
            return true;
        }
        boolean z1 = z1(this.M, this.N, str, i2, i3);
        if (z1) {
            this.f7908b = true;
            try {
                F1(this.M, this.N);
            } finally {
                x();
            }
        }
        g2();
        d0();
        this.f7909c.b();
        return z1;
    }

    @NonNull
    public BackStackEntry A0(int i2) {
        return this.f7910d.get(i2);
    }

    public void A1(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.m3 != this) {
            e2(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.Y2);
    }

    public int B0() {
        ArrayList<BackStackRecord> arrayList = this.f7910d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void B1(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.f7920n.o(fragmentLifecycleCallbacks, z2);
    }

    /* access modifiers changed from: package-private */
    public void C1(@NonNull Fragment fragment) {
        if (W0(2)) {
            Log.v(Y, "remove: " + fragment + " nesting=" + fragment.l3);
        }
        boolean z2 = !fragment.B0();
        if (!fragment.u3 || z2) {
            this.f7909c.v(fragment);
            if (X0(fragment)) {
                this.H = true;
            }
            fragment.f3 = true;
            b2(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentStateManager D(@NonNull Fragment fragment) {
        FragmentStateManager o2 = this.f7909c.o(fragment.Y2);
        if (o2 != null) {
            return o2;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.f7920n, this.f7909c, fragment);
        fragmentStateManager.o(this.v.m().getClassLoader());
        fragmentStateManager.u(this.u);
        return fragmentStateManager;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer D0() {
        return this.w;
    }

    public void D1(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.o.remove(fragmentOnAttachListener);
    }

    /* access modifiers changed from: package-private */
    public void E(@NonNull Fragment fragment) {
        if (W0(2)) {
            Log.v(Y, "detach: " + fragment);
        }
        if (!fragment.u3) {
            fragment.u3 = true;
            if (fragment.e3) {
                if (W0(2)) {
                    Log.v(Y, "remove from detach: " + fragment);
                }
                this.f7909c.v(fragment);
                if (X0(fragment)) {
                    this.H = true;
                }
                b2(fragment);
            }
        }
    }

    @Nullable
    public Fragment E0(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment o0 = o0(string);
        if (o0 == null) {
            e2(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return o0;
    }

    public void E1(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.f7919m;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        a0(4);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        a0(0);
    }

    @NonNull
    public FragmentFactory G0() {
        FragmentFactory fragmentFactory = this.z;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.m3.G0() : this.A;
    }

    /* access modifiers changed from: package-private */
    public void G1(@NonNull Fragment fragment) {
        this.P.r(fragment);
    }

    /* access modifiers changed from: package-private */
    public void H(@NonNull Configuration configuration, boolean z2) {
        if (z2 && (this.v instanceof OnConfigurationChangedProvider)) {
            e2(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null) {
                next.t1(configuration);
                if (z2) {
                    next.o3.H(configuration, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentStore H0() {
        return this.f7909c;
    }

    /* access modifiers changed from: package-private */
    public boolean I(@NonNull MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null && next.u1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public List<Fragment> I0() {
        return this.f7909c.p();
    }

    /* access modifiers changed from: package-private */
    public void I1(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.v instanceof ViewModelStoreOwner) {
            e2(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.P.s(fragmentManagerNonConfig);
        M1(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        a0(1);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FragmentHostCallback<?> J0() {
        return this.v;
    }

    public void J1(@NonNull String str) {
        h0(new RestoreBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    public boolean K(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment next : this.f7909c.p()) {
            if (next != null && a1(next) && next.w1(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z2 = true;
            }
        }
        if (this.f7911e != null) {
            for (int i2 = 0; i2 < this.f7911e.size(); i2++) {
                Fragment fragment = this.f7911e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.W0();
                }
            }
        }
        this.f7911e = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater.Factory2 K0() {
        return this.f7912f;
    }

    /* access modifiers changed from: package-private */
    public boolean K1(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        BackStackState remove = this.f7916j.remove(str);
        if (remove == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator<BackStackRecord> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BackStackRecord next = it2.next();
            if (next.Q) {
                Iterator<FragmentTransaction.Op> it3 = next.f7996c.iterator();
                while (it3.hasNext()) {
                    Fragment fragment = it3.next().f8009b;
                    if (fragment != null) {
                        hashMap.put(fragment.Y2, fragment);
                    }
                }
            }
        }
        Iterator<BackStackRecord> it4 = remove.a(this, hashMap).iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it4.hasNext()) {
                    return z2;
                }
                if (it4.next().b(arrayList, arrayList2) || z2) {
                    z2 = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void L() {
        this.K = true;
        j0(true);
        g0();
        A();
        a0(-1);
        FragmentHostCallback<?> fragmentHostCallback = this.v;
        if (fragmentHostCallback instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback).l(this.q);
        }
        FragmentHostCallback<?> fragmentHostCallback2 = this.v;
        if (fragmentHostCallback2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback2).z(this.p);
        }
        FragmentHostCallback<?> fragmentHostCallback3 = this.v;
        if (fragmentHostCallback3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback3).L(this.r);
        }
        FragmentHostCallback<?> fragmentHostCallback4 = this.v;
        if (fragmentHostCallback4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback4).k(this.s);
        }
        FragmentHostCallback<?> fragmentHostCallback5 = this.v;
        if (fragmentHostCallback5 instanceof MenuHost) {
            ((MenuHost) fragmentHostCallback5).f(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.f7913g != null) {
            this.f7914h.h();
            this.f7913g = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.D;
        if (activityResultLauncher != null) {
            activityResultLauncher.d();
            this.E.d();
            this.F.d();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentLifecycleCallbacksDispatcher L0() {
        return this.f7920n;
    }

    /* access modifiers changed from: package-private */
    public void L1(@Nullable Parcelable parcelable) {
        if (this.v instanceof SavedStateRegistryOwner) {
            e2(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        M1(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void M() {
        a0(1);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment M0() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void M1(@Nullable Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable != null) {
            Bundle bundle3 = (Bundle) parcelable;
            for (String next : bundle3.keySet()) {
                if (next.startsWith(U) && (bundle2 = bundle3.getBundle(next)) != null) {
                    bundle2.setClassLoader(this.v.m().getClassLoader());
                    this.f7917k.put(next.substring(7), bundle2);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String next2 : bundle3.keySet()) {
                if (next2.startsWith(W) && (bundle = bundle3.getBundle(next2)) != null) {
                    bundle.setClassLoader(this.v.m().getClassLoader());
                    arrayList.add((FragmentState) bundle.getParcelable("state"));
                }
            }
            this.f7909c.y(arrayList);
            FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
            if (fragmentManagerState != null) {
                this.f7909c.w();
                Iterator<String> it2 = fragmentManagerState.s.iterator();
                while (it2.hasNext()) {
                    FragmentState C2 = this.f7909c.C(it2.next(), (FragmentState) null);
                    if (C2 != null) {
                        Fragment k2 = this.P.k(C2.X);
                        if (k2 != null) {
                            if (W0(2)) {
                                Log.v(Y, "restoreSaveState: re-attaching retained " + k2);
                            }
                            fragmentStateManager = new FragmentStateManager(this.f7920n, this.f7909c, k2, C2);
                        } else {
                            fragmentStateManager = new FragmentStateManager(this.f7920n, this.f7909c, this.v.m().getClassLoader(), G0(), C2);
                        }
                        Fragment k3 = fragmentStateManager.k();
                        k3.m3 = this;
                        if (W0(2)) {
                            Log.v(Y, "restoreSaveState: active (" + k3.Y2 + "): " + k3);
                        }
                        fragmentStateManager.o(this.v.m().getClassLoader());
                        this.f7909c.s(fragmentStateManager);
                        fragmentStateManager.u(this.u);
                    }
                }
                for (Fragment next3 : this.P.n()) {
                    if (!this.f7909c.c(next3.Y2)) {
                        if (W0(2)) {
                            Log.v(Y, "Discarding retained Fragment " + next3 + " that was not found in the set of active Fragments " + fragmentManagerState.s);
                        }
                        this.P.r(next3);
                        next3.m3 = this;
                        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.f7920n, this.f7909c, next3);
                        fragmentStateManager2.u(1);
                        fragmentStateManager2.m();
                        next3.f3 = true;
                        fragmentStateManager2.m();
                    }
                }
                this.f7909c.x(fragmentManagerState.X);
                if (fragmentManagerState.Y != null) {
                    this.f7910d = new ArrayList<>(fragmentManagerState.Y.length);
                    int i2 = 0;
                    while (true) {
                        BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.Y;
                        if (i2 >= backStackRecordStateArr.length) {
                            break;
                        }
                        BackStackRecord b2 = backStackRecordStateArr[i2].b(this);
                        if (W0(2)) {
                            Log.v(Y, "restoreAllState: back stack #" + i2 + " (index " + b2.P + "): " + b2);
                            PrintWriter printWriter = new PrintWriter(new LogWriter(Y));
                            b2.Y("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f7910d.add(b2);
                        i2++;
                    }
                } else {
                    this.f7910d = null;
                }
                this.f7915i.set(fragmentManagerState.Z);
                String str = fragmentManagerState.X2;
                if (str != null) {
                    Fragment o0 = o0(str);
                    this.y = o0;
                    T(o0);
                }
                ArrayList<String> arrayList2 = fragmentManagerState.Y2;
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        this.f7916j.put(arrayList2.get(i3), fragmentManagerState.Z2.get(i3));
                    }
                }
                this.G = new ArrayDeque<>(fragmentManagerState.a3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void N(boolean z2) {
        if (z2 && (this.v instanceof OnTrimMemoryProvider)) {
            e2(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null) {
                next.C1();
                if (z2) {
                    next.o3.N(true);
                }
            }
        }
    }

    @Nullable
    public Fragment N0() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig N1() {
        if (this.v instanceof ViewModelStoreOwner) {
            e2(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.P.o();
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z2, boolean z3) {
        if (z3 && (this.v instanceof OnMultiWindowModeChangedProvider)) {
            e2(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null) {
                next.D1(z2);
                if (z3) {
                    next.o3.O(z2, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SpecialEffectsControllerFactory O0() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.B;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.m3.O0() : this.C;
    }

    /* access modifiers changed from: package-private */
    public void P(@NonNull Fragment fragment) {
        Iterator<FragmentOnAttachListener> it2 = this.o.iterator();
        while (it2.hasNext()) {
            it2.next().b(this, fragment);
        }
    }

    @Nullable
    public FragmentStrictMode.Policy P0() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public Parcelable P1() {
        if (this.v instanceof SavedStateRegistryOwner) {
            e2(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle Q1 = e1();
        if (Q1.isEmpty()) {
            return null;
        }
        return Q1;
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        for (Fragment next : this.f7909c.m()) {
            if (next != null) {
                next.a1(next.A0());
                next.o3.Q();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: Q1 */
    public Bundle e1() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        w0();
        g0();
        j0(true);
        this.I = true;
        this.P.t(true);
        ArrayList<String> z2 = this.f7909c.z();
        ArrayList<FragmentState> n2 = this.f7909c.n();
        if (!n2.isEmpty()) {
            ArrayList<String> A2 = this.f7909c.A();
            ArrayList<BackStackRecord> arrayList = this.f7910d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackRecordStateArr[i2] = new BackStackRecordState(this.f7910d.get(i2));
                    if (W0(2)) {
                        Log.v(Y, "saveAllState: adding back stack #" + i2 + ": " + this.f7910d.get(i2));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.s = z2;
            fragmentManagerState.X = A2;
            fragmentManagerState.Y = backStackRecordStateArr;
            fragmentManagerState.Z = this.f7915i.get();
            Fragment fragment = this.y;
            if (fragment != null) {
                fragmentManagerState.X2 = fragment.Y2;
            }
            fragmentManagerState.Y2.addAll(this.f7916j.keySet());
            fragmentManagerState.Z2.addAll(this.f7916j.values());
            fragmentManagerState.a3 = new ArrayList<>(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String next : this.f7917k.keySet()) {
                bundle.putBundle(U + next, this.f7917k.get(next));
            }
            Iterator<FragmentState> it2 = n2.iterator();
            while (it2.hasNext()) {
                FragmentState next2 = it2.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", next2);
                bundle.putBundle(W + next2.X, bundle2);
            }
        } else if (W0(2)) {
            Log.v(Y, "saveAllState: no fragments!");
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public boolean R(@NonNull MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null && next.E1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ViewModelStore R0(@NonNull Fragment fragment) {
        return this.P.p(fragment);
    }

    public void R1(@NonNull String str) {
        h0(new SaveBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    public void S(@NonNull Menu menu) {
        if (this.u >= 1) {
            for (Fragment next : this.f7909c.p()) {
                if (next != null) {
                    next.F1(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S0() {
        j0(true);
        if (this.f7914h.g()) {
            v1();
        } else {
            this.f7913g.p();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean S1(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        StringBuilder sb;
        Object obj;
        int i2;
        String str2 = str;
        int p0 = p0(str2, -1, true);
        if (p0 < 0) {
            return false;
        }
        for (int i3 = p0; i3 < this.f7910d.size(); i3++) {
            BackStackRecord backStackRecord = this.f7910d.get(i3);
            if (!backStackRecord.r) {
                e2(new IllegalArgumentException("saveBackStack(\"" + str2 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + backStackRecord + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i4 = p0; i4 < this.f7910d.size(); i4++) {
            BackStackRecord backStackRecord2 = this.f7910d.get(i4);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator<FragmentTransaction.Op> it2 = backStackRecord2.f7996c.iterator();
            while (it2.hasNext()) {
                FragmentTransaction.Op next = it2.next();
                Fragment fragment = next.f8009b;
                if (fragment != null) {
                    if (!next.f8010c || (i2 = next.f8008a) == 1 || i2 == 2 || i2 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i5 = next.f8008a;
                    if (i5 == 1 || i5 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str2);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                if (hashSet2.size() == 1) {
                    sb = new StringBuilder();
                    sb.append(StringUtils.SPACE);
                    obj = hashSet2.iterator().next();
                } else {
                    sb = new StringBuilder();
                    sb.append("s ");
                    obj = hashSet2;
                }
                sb.append(obj);
                sb2.append(sb.toString());
                sb2.append(" in ");
                sb2.append(backStackRecord2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                e2(new IllegalArgumentException(sb2.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.v3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("saveBackStack(\"");
                sb3.append(str2);
                sb3.append("\") must not contain retained fragments. Found ");
                sb3.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb3.append("fragment ");
                sb3.append(fragment2);
                e2(new IllegalArgumentException(sb3.toString()));
            }
            for (Fragment next2 : fragment2.o3.z0()) {
                if (next2 != null) {
                    arrayDeque.addLast(next2);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Fragment) it3.next()).Y2);
        }
        ArrayList arrayList4 = new ArrayList(this.f7910d.size() - p0);
        for (int i6 = p0; i6 < this.f7910d.size(); i6++) {
            arrayList4.add((Object) null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.f7910d.size() - 1; size >= p0; size--) {
            BackStackRecord remove = this.f7910d.remove(size);
            BackStackRecord backStackRecord3 = new BackStackRecord(remove);
            backStackRecord3.V();
            arrayList4.set(size - p0, new BackStackRecordState(backStackRecord3));
            remove.Q = true;
            arrayList.add(remove);
            arrayList2.add(Boolean.TRUE);
        }
        this.f7916j.put(str2, backStackState);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void T0(@NonNull Fragment fragment) {
        if (W0(2)) {
            Log.v(Y, "hide: " + fragment);
        }
        if (!fragment.t3) {
            fragment.t3 = true;
            fragment.G3 = true ^ fragment.G3;
            b2(fragment);
        }
    }

    @Nullable
    public Fragment.SavedState T1(@NonNull Fragment fragment) {
        FragmentStateManager o2 = this.f7909c.o(fragment.Y2);
        if (o2 == null || !o2.k().equals(fragment)) {
            e2(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return o2.r();
    }

    /* access modifiers changed from: package-private */
    public void U() {
        a0(5);
    }

    /* access modifiers changed from: package-private */
    public void U0(@NonNull Fragment fragment) {
        if (fragment.e3 && X0(fragment)) {
            this.H = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void U1() {
        synchronized (this.f7907a) {
            try {
                if (this.f7907a.size() == 1) {
                    this.v.n().removeCallbacks(this.R);
                    this.v.n().post(this.R);
                    g2();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V(boolean z2, boolean z3) {
        if (z3 && (this.v instanceof OnPictureInPictureModeChangedProvider)) {
            e2(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null) {
                next.H1(z2);
                if (z3) {
                    next.o3.V(z2, true);
                }
            }
        }
    }

    public boolean V0() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public void V1(@NonNull Fragment fragment, boolean z2) {
        ViewGroup F0 = F0(fragment);
        if (F0 != null && (F0 instanceof FragmentContainerView)) {
            ((FragmentContainerView) F0).setDrawDisappearingViewsLast(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean W(@NonNull Menu menu) {
        boolean z2 = false;
        if (this.u < 1) {
            return false;
        }
        for (Fragment next : this.f7909c.p()) {
            if (next != null && a1(next) && next.I1(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public void W1(@NonNull FragmentFactory fragmentFactory) {
        this.z = fragmentFactory;
    }

    /* access modifiers changed from: package-private */
    public void X() {
        g2();
        T(this.y);
    }

    /* access modifiers changed from: package-private */
    public void X1(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(o0(fragment.Y2)) || !(fragment.n3 == null || fragment.m3 == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.K3 = state;
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        a0(7);
    }

    /* access modifiers changed from: package-private */
    public void Y1(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(o0(fragment.Y2)) && (fragment.n3 == null || fragment.m3 == this))) {
            Fragment fragment2 = this.y;
            this.y = fragment;
            T(fragment2);
            T(this.y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        this.I = false;
        this.J = false;
        this.P.t(false);
        a0(5);
    }

    /* access modifiers changed from: package-private */
    public boolean Z0(@Nullable Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.A0();
    }

    /* access modifiers changed from: package-private */
    public void Z1(@NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.B = specialEffectsControllerFactory;
    }

    public final void a(@NonNull String str, @NonNull Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.f7918l.get(str);
        if (lifecycleAwareResultListener == null || !lifecycleAwareResultListener.b(Lifecycle.State.STARTED)) {
            this.f7917k.put(str, bundle);
        } else {
            lifecycleAwareResultListener.a(str, bundle);
        }
        if (W0(2)) {
            Log.v(Y, "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a1(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.D0();
    }

    public void a2(@Nullable FragmentStrictMode.Policy policy) {
        this.Q = policy;
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void b(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final FragmentResultListener fragmentResultListener) {
        final Lifecycle a2 = lifecycleOwner.a();
        if (a2.b() != Lifecycle.State.DESTROYED) {
            AnonymousClass6 r0 = new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    Bundle bundle;
                    if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f7917k.get(str)) != null) {
                        fragmentResultListener.a(str, bundle);
                        FragmentManager.this.d(str);
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        a2.d(this);
                        FragmentManager.this.f7918l.remove(str);
                    }
                }
            };
            a2.a(r0);
            LifecycleAwareResultListener put = this.f7918l.put(str, new LifecycleAwareResultListener(a2, fragmentResultListener, r0));
            if (put != null) {
                put.c();
            }
            if (W0(2)) {
                Log.v(Y, "Setting FragmentResultListener with key " + str + " lifecycleOwner " + a2 + " and listener " + fragmentResultListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        this.J = true;
        this.P.t(true);
        a0(4);
    }

    /* access modifiers changed from: package-private */
    public boolean b1(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.m3;
        return fragment.equals(fragmentManager.N0()) && b1(fragmentManager.x);
    }

    public final void c(@NonNull String str) {
        LifecycleAwareResultListener remove = this.f7918l.remove(str);
        if (remove != null) {
            remove.c();
        }
        if (W0(2)) {
            Log.v(Y, "Clearing FragmentResultListener for key " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        a0(2);
    }

    /* access modifiers changed from: package-private */
    public boolean c1(int i2) {
        return this.u >= i2;
    }

    /* access modifiers changed from: package-private */
    public void c2(@NonNull Fragment fragment) {
        if (W0(2)) {
            Log.v(Y, "show: " + fragment);
        }
        if (fragment.t3) {
            fragment.t3 = false;
            fragment.G3 = !fragment.G3;
        }
    }

    public final void d(@NonNull String str) {
        this.f7917k.remove(str);
        if (W0(2)) {
            Log.v(Y, "Clearing fragment result with key " + str);
        }
    }

    public boolean d1() {
        return this.I || this.J;
    }

    public void e0(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f7909c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f7911e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f7911e.get(i2).toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.f7910d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = this.f7910d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.X(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f7915i.get());
        synchronized (this.f7907a) {
            try {
                int size3 = this.f7907a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(this.f7907a.get(i4));
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public void f2(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f7920n.p(fragmentLifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    public void h0(@NonNull OpGenerator opGenerator, boolean z2) {
        if (!z2) {
            if (this.v != null) {
                w();
            } else if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f7907a) {
            try {
                if (this.v != null) {
                    this.f7907a.add(opGenerator);
                    U1();
                } else if (!z2) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j0(boolean z2) {
        i0(z2);
        boolean z3 = false;
        while (x0(this.M, this.N)) {
            z3 = true;
            this.f7908b = true;
            try {
                F1(this.M, this.N);
            } finally {
                x();
            }
        }
        g2();
        d0();
        this.f7909c.b();
        return z3;
    }

    /* access modifiers changed from: package-private */
    public void j1(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
        if (this.F != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.Y2, i2));
            this.F.b(strArr);
            return;
        }
        this.v.x(fragment, strArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void k0(@NonNull OpGenerator opGenerator, boolean z2) {
        if (!z2 || (this.v != null && !this.K)) {
            i0(z2);
            if (opGenerator.b(this.M, this.N)) {
                this.f7908b = true;
                try {
                    F1(this.M, this.N);
                } finally {
                    x();
                }
            }
            g2();
            d0();
            this.f7909c.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void k1(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (this.D != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.Y2, i2));
            if (!(intent == null || bundle == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.f2514b, bundle);
            }
            this.D.b(intent);
            return;
        }
        this.v.E(fragment, intent, i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public void l1(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.E != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra(a0, true);
                } else {
                    intent2 = intent;
                }
                if (W0(2)) {
                    Log.v(Y, "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra(ActivityResultContracts.StartActivityForResult.f2514b, bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest a2 = new IntentSenderRequest.Builder(intentSender).b(intent2).c(i4, i3).a();
            int i6 = i2;
            this.G.addLast(new LaunchedFragmentInfo(fragment2.Y2, i2));
            if (W0(2)) {
                Log.v(Y, "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.E.b(a2);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        this.v.G(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public void m(BackStackRecord backStackRecord) {
        if (this.f7910d == null) {
            this.f7910d = new ArrayList<>();
        }
        this.f7910d.add(backStackRecord);
    }

    /* access modifiers changed from: package-private */
    public void m1(int i2, boolean z2) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.u) {
            this.u = i2;
            this.f7909c.u();
            d2();
            if (this.H && (fragmentHostCallback = this.v) != null && this.u == 7) {
                fragmentHostCallback.I();
                this.H = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager n(@NonNull Fragment fragment) {
        String str = fragment.J3;
        if (str != null) {
            FragmentStrictMode.i(fragment, str);
        }
        if (W0(2)) {
            Log.v(Y, "add: " + fragment);
        }
        FragmentStateManager D2 = D(fragment);
        fragment.m3 = this;
        this.f7909c.s(D2);
        if (!fragment.u3) {
            this.f7909c.a(fragment);
            fragment.f3 = false;
            if (fragment.B3 == null) {
                fragment.G3 = false;
            }
            if (X0(fragment)) {
                this.H = true;
            }
        }
        return D2;
    }

    public boolean n0() {
        boolean j0 = j0(true);
        w0();
        return j0;
    }

    /* access modifiers changed from: package-private */
    public void n1() {
        if (this.v != null) {
            this.I = false;
            this.J = false;
            this.P.t(false);
            for (Fragment next : this.f7909c.p()) {
                if (next != null) {
                    next.J0();
                }
            }
        }
    }

    public void o(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.o.add(fragmentOnAttachListener);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment o0(@NonNull String str) {
        return this.f7909c.f(str);
    }

    /* access modifiers changed from: package-private */
    public void o1(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        for (FragmentStateManager next : this.f7909c.l()) {
            Fragment k2 = next.k();
            if (k2.r3 == fragmentContainerView.getId() && (view = k2.B3) != null && view.getParent() == null) {
                k2.A3 = fragmentContainerView;
                next.b();
            }
        }
    }

    public void p(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f7919m == null) {
            this.f7919m = new ArrayList<>();
        }
        this.f7919m.add(onBackStackChangedListener);
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FragmentTransaction p1() {
        return u();
    }

    /* access modifiers changed from: package-private */
    public void q(@NonNull Fragment fragment) {
        this.P.g(fragment);
    }

    /* access modifiers changed from: package-private */
    public void q1(@NonNull FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (!k2.C3) {
            return;
        }
        if (this.f7908b) {
            this.L = true;
            return;
        }
        k2.C3 = false;
        fragmentStateManager.m();
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.f7915i.getAndIncrement();
    }

    @Nullable
    public Fragment r0(@IdRes int i2) {
        return this.f7909c.g(i2);
    }

    public void r1() {
        h0(new PopBackStackState((String) null, -1, 0), false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0150  */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> r4, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r5, @androidx.annotation.Nullable final androidx.fragment.app.Fragment r6) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r3.v
            if (r0 != 0) goto L_0x0167
            r3.v = r4
            r3.w = r5
            r3.x = r6
            if (r6 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$7 r5 = new androidx.fragment.app.FragmentManager$7
            r5.<init>(r6)
        L_0x0011:
            r3.o(r5)
            goto L_0x001d
        L_0x0015:
            boolean r5 = r4 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r5 == 0) goto L_0x001d
            r5 = r4
            androidx.fragment.app.FragmentOnAttachListener r5 = (androidx.fragment.app.FragmentOnAttachListener) r5
            goto L_0x0011
        L_0x001d:
            androidx.fragment.app.Fragment r5 = r3.x
            if (r5 == 0) goto L_0x0024
            r3.g2()
        L_0x0024:
            boolean r5 = r4 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r5 == 0) goto L_0x0039
            r5 = r4
            androidx.activity.OnBackPressedDispatcherOwner r5 = (androidx.activity.OnBackPressedDispatcherOwner) r5
            androidx.activity.OnBackPressedDispatcher r0 = r5.e()
            r3.f7913g = r0
            if (r6 == 0) goto L_0x0034
            r5 = r6
        L_0x0034:
            androidx.activity.OnBackPressedCallback r1 = r3.f7914h
            r0.i(r5, r1)
        L_0x0039:
            if (r6 == 0) goto L_0x0044
            androidx.fragment.app.FragmentManager r4 = r6.m3
            androidx.fragment.app.FragmentManagerViewModel r4 = r4.C0(r6)
        L_0x0041:
            r3.P = r4
            goto L_0x005a
        L_0x0044:
            boolean r5 = r4 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r5 == 0) goto L_0x0053
            androidx.lifecycle.ViewModelStoreOwner r4 = (androidx.lifecycle.ViewModelStoreOwner) r4
            androidx.lifecycle.ViewModelStore r4 = r4.w()
            androidx.fragment.app.FragmentManagerViewModel r4 = androidx.fragment.app.FragmentManagerViewModel.m(r4)
            goto L_0x0041
        L_0x0053:
            androidx.fragment.app.FragmentManagerViewModel r4 = new androidx.fragment.app.FragmentManagerViewModel
            r5 = 0
            r4.<init>(r5)
            goto L_0x0041
        L_0x005a:
            androidx.fragment.app.FragmentManagerViewModel r4 = r3.P
            boolean r5 = r3.d1()
            r4.t(r5)
            androidx.fragment.app.FragmentStore r4 = r3.f7909c
            androidx.fragment.app.FragmentManagerViewModel r5 = r3.P
            r4.B(r5)
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.savedstate.SavedStateRegistryOwner
            if (r5 == 0) goto L_0x008b
            if (r6 != 0) goto L_0x008b
            androidx.savedstate.SavedStateRegistryOwner r4 = (androidx.savedstate.SavedStateRegistryOwner) r4
            androidx.savedstate.SavedStateRegistry r4 = r4.A()
            androidx.fragment.app.i r5 = new androidx.fragment.app.i
            r5.<init>(r3)
            java.lang.String r0 = "android:support:fragments"
            r4.j(r0, r5)
            android.os.Bundle r4 = r4.b(r0)
            if (r4 == 0) goto L_0x008b
            r3.M1(r4)
        L_0x008b:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r5 == 0) goto L_0x0123
            androidx.activity.result.ActivityResultRegistryOwner r4 = (androidx.activity.result.ActivityResultRegistryOwner) r4
            androidx.activity.result.ActivityResultRegistry r4 = r4.r()
            if (r6 == 0) goto L_0x00ad
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r6.Y2
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            goto L_0x00af
        L_0x00ad:
            java.lang.String r5 = ""
        L_0x00af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FragmentManager:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartActivityForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r1 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r1.<init>()
            androidx.fragment.app.FragmentManager$8 r2 = new androidx.fragment.app.FragmentManager$8
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.i(r0, r1, r2)
            r3.D = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartIntentSenderForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.fragment.app.FragmentManager$FragmentIntentSenderContract r1 = new androidx.fragment.app.FragmentManager$FragmentIntentSenderContract
            r1.<init>()
            androidx.fragment.app.FragmentManager$9 r2 = new androidx.fragment.app.FragmentManager$9
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.i(r0, r1, r2)
            r3.E = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "RequestPermissions"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r0 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r0.<init>()
            androidx.fragment.app.FragmentManager$10 r1 = new androidx.fragment.app.FragmentManager$10
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.i(r5, r0, r1)
            r3.F = r4
        L_0x0123:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.core.content.OnConfigurationChangedProvider
            if (r5 == 0) goto L_0x0130
            androidx.core.content.OnConfigurationChangedProvider r4 = (androidx.core.content.OnConfigurationChangedProvider) r4
            androidx.core.util.Consumer<android.content.res.Configuration> r5 = r3.p
            r4.h(r5)
        L_0x0130:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.core.content.OnTrimMemoryProvider
            if (r5 == 0) goto L_0x013d
            androidx.core.content.OnTrimMemoryProvider r4 = (androidx.core.content.OnTrimMemoryProvider) r4
            androidx.core.util.Consumer<java.lang.Integer> r5 = r3.q
            r4.D(r5)
        L_0x013d:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.core.app.OnMultiWindowModeChangedProvider
            if (r5 == 0) goto L_0x014a
            androidx.core.app.OnMultiWindowModeChangedProvider r4 = (androidx.core.app.OnMultiWindowModeChangedProvider) r4
            androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo> r5 = r3.r
            r4.u(r5)
        L_0x014a:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.core.app.OnPictureInPictureModeChangedProvider
            if (r5 == 0) goto L_0x0157
            androidx.core.app.OnPictureInPictureModeChangedProvider r4 = (androidx.core.app.OnPictureInPictureModeChangedProvider) r4
            androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo> r5 = r3.s
            r4.q(r5)
        L_0x0157:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.v
            boolean r5 = r4 instanceof androidx.core.view.MenuHost
            if (r5 == 0) goto L_0x0166
            if (r6 != 0) goto L_0x0166
            androidx.core.view.MenuHost r4 = (androidx.core.view.MenuHost) r4
            androidx.core.view.MenuProvider r5 = r3.t
            r4.H(r5)
        L_0x0166:
            return
        L_0x0167:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Already attached"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.s(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    @Nullable
    public Fragment s0(@Nullable String str) {
        return this.f7909c.h(str);
    }

    public void s1(int i2, int i3) {
        t1(i2, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull Fragment fragment) {
        if (W0(2)) {
            Log.v(Y, "attach: " + fragment);
        }
        if (fragment.u3) {
            fragment.u3 = false;
            if (!fragment.e3) {
                this.f7909c.a(fragment);
                if (W0(2)) {
                    Log.v(Y, "add from attach: " + fragment);
                }
                if (X0(fragment)) {
                    this.H = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment t0(@NonNull String str) {
        return this.f7909c.i(str);
    }

    /* access modifiers changed from: package-private */
    public void t1(int i2, int i3, boolean z2) {
        if (i2 >= 0) {
            h0(new PopBackStackState((String) null, i2, i3), z2);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    @NonNull
    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.x;
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.v;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                obj = this.v;
            } else {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    @NonNull
    public FragmentTransaction u() {
        return new BackStackRecord(this);
    }

    public void u1(@Nullable String str, int i2) {
        h0(new PopBackStackState(str, -1, i2), false);
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        boolean z2 = false;
        for (Fragment next : this.f7909c.m()) {
            if (next != null) {
                z2 = X0(next);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean v1() {
        return y1((String) null, -1, 0);
    }

    public boolean w1(int i2, int i3) {
        if (i2 >= 0) {
            return y1((String) null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public boolean x1(@Nullable String str, int i2) {
        return y1(str, -1, i2);
    }

    public void y(@NonNull String str) {
        h0(new ClearBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    public int y0() {
        return this.f7909c.k();
    }

    /* access modifiers changed from: package-private */
    public boolean z(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        if (!K1(arrayList, arrayList2, str)) {
            return false;
        }
        return z1(arrayList, arrayList2, str, -1, 1);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> z0() {
        return this.f7909c.m();
    }

    /* access modifiers changed from: package-private */
    public boolean z1(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i2, int i3) {
        int p0 = p0(str, i2, (i3 & 1) != 0);
        if (p0 < 0) {
            return false;
        }
        for (int size = this.f7910d.size() - 1; size >= p0; size--) {
            arrayList.add(this.f7910d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }
}
