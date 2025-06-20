package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.AnimRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final Object U3 = new Object();
    static final int V3 = -1;
    static final int W3 = 0;
    static final int X3 = 1;
    static final int Y3 = 2;
    static final int Z3 = 3;
    static final int a4 = 4;
    static final int b4 = 5;
    static final int c4 = 6;
    static final int d4 = 7;
    ViewGroup A3;
    View B3;
    boolean C3;
    boolean D3;
    AnimationInfo E3;
    Runnable F3;
    boolean G3;
    LayoutInflater H3;
    boolean I3;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String J3;
    Lifecycle.State K3;
    LifecycleRegistry L3;
    @Nullable
    FragmentViewLifecycleOwner M3;
    MutableLiveData<LifecycleOwner> N3;
    ViewModelProvider.Factory O3;
    SavedStateRegistryController P3;
    @LayoutRes
    private int Q3;
    private final AtomicInteger R3;
    private final ArrayList<OnPreAttachedListener> S3;
    private final OnPreAttachedListener T3;
    Bundle X;
    @Nullable
    Boolean X2;
    SparseArray<Parcelable> Y;
    @NonNull
    String Y2;
    Bundle Z;
    Bundle Z2;
    Fragment a3;
    String b3;
    int c3;
    private Boolean d3;
    boolean e3;
    boolean f3;
    boolean g3;
    boolean h3;
    boolean i3;
    boolean j3;
    boolean k3;
    int l3;
    FragmentManager m3;
    FragmentHostCallback<?> n3;
    @NonNull
    FragmentManager o3;
    Fragment p3;
    int q3;
    int r3;
    int s;
    String s3;
    boolean t3;
    boolean u3;
    boolean v3;
    boolean w3;
    boolean x3;
    boolean y3;
    private boolean z3;

    static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        View f7884a;

        /* renamed from: b  reason: collision with root package name */
        boolean f7885b;
        @AnimRes

        /* renamed from: c  reason: collision with root package name */
        int f7886c;
        @AnimRes

        /* renamed from: d  reason: collision with root package name */
        int f7887d;
        @AnimRes

        /* renamed from: e  reason: collision with root package name */
        int f7888e;
        @AnimRes

        /* renamed from: f  reason: collision with root package name */
        int f7889f;

        /* renamed from: g  reason: collision with root package name */
        int f7890g;

        /* renamed from: h  reason: collision with root package name */
        ArrayList<String> f7891h;

        /* renamed from: i  reason: collision with root package name */
        ArrayList<String> f7892i;

        /* renamed from: j  reason: collision with root package name */
        Object f7893j = null;

        /* renamed from: k  reason: collision with root package name */
        Object f7894k;

        /* renamed from: l  reason: collision with root package name */
        Object f7895l;

        /* renamed from: m  reason: collision with root package name */
        Object f7896m;

        /* renamed from: n  reason: collision with root package name */
        Object f7897n;
        Object o;
        Boolean p;
        Boolean q;
        SharedElementCallback r;
        SharedElementCallback s;
        float t;
        View u;
        boolean v;

        AnimationInfo() {
            Object obj = Fragment.U3;
            this.f7894k = obj;
            this.f7895l = null;
            this.f7896m = obj;
            this.f7897n = null;
            this.o = obj;
            this.r = null;
            this.s = null;
            this.t = 1.0f;
            this.u = null;
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(@NonNull View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        final Bundle s;

        SavedState(Bundle bundle) {
            this.s = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeBundle(this.s);
        }

        SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.s = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }
    }

    public Fragment() {
        this.s = -1;
        this.Y2 = UUID.randomUUID().toString();
        this.b3 = null;
        this.d3 = null;
        this.o3 = new FragmentManagerImpl();
        this.y3 = true;
        this.D3 = true;
        this.F3 = new Runnable() {
            public void run() {
                Fragment.this.H2();
            }
        };
        this.K3 = Lifecycle.State.RESUMED;
        this.N3 = new MutableLiveData<>();
        this.R3 = new AtomicInteger();
        this.S3 = new ArrayList<>();
        this.T3 = new OnPreAttachedListener() {
            /* access modifiers changed from: package-private */
            public void a() {
                Fragment.this.P3.c();
                SavedStateHandleSupport.c(Fragment.this);
            }
        };
        u0();
    }

    @NonNull
    private <I, O> ActivityResultLauncher<I> R1(@NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull Function<Void, ActivityResultRegistry> function, @NonNull ActivityResultCallback<O> activityResultCallback) {
        if (this.s <= 1) {
            final AtomicReference atomicReference = new AtomicReference();
            final Function<Void, ActivityResultRegistry> function2 = function;
            final AtomicReference atomicReference2 = atomicReference;
            final ActivityResultContract<I, O> activityResultContract2 = activityResultContract;
            final ActivityResultCallback<O> activityResultCallback2 = activityResultCallback;
            T1(new OnPreAttachedListener() {
                /* access modifiers changed from: package-private */
                public void a() {
                    atomicReference2.set(((ActivityResultRegistry) function2.apply(null)).j(Fragment.this.q(), Fragment.this, activityResultContract2, activityResultCallback2));
                }
            });
            return new ActivityResultLauncher<I>() {
                @NonNull
                public ActivityResultContract<I, ?> a() {
                    return activityResultContract;
                }

                public void c(I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
                    if (activityResultLauncher != null) {
                        activityResultLauncher.c(i2, activityOptionsCompat);
                        return;
                    }
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }

                public void d() {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.getAndSet((Object) null);
                    if (activityResultLauncher != null) {
                        activityResultLauncher.d();
                    }
                }
            };
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private int S() {
        Lifecycle.State state = this.K3;
        return (state == Lifecycle.State.INITIALIZED || this.p3 == null) ? state.ordinal() : Math.min(state.ordinal(), this.p3.S());
    }

    private void T1(@NonNull OnPreAttachedListener onPreAttachedListener) {
        if (this.s >= 0) {
            onPreAttachedListener.a();
        } else {
            this.S3.add(onPreAttachedListener);
        }
    }

    private void d2() {
        if (FragmentManager.W0(3)) {
            Log.d(FragmentManager.Y, "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.B3 != null) {
            e2(this.X);
        }
        this.X = null;
    }

    private AnimationInfo m() {
        if (this.E3 == null) {
            this.E3 = new AnimationInfo();
        }
        return this.E3;
    }

    @Nullable
    private Fragment m0(boolean z) {
        String str;
        if (z) {
            FragmentStrictMode.m(this);
        }
        Fragment fragment = this.a3;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.m3;
        if (fragmentManager == null || (str = this.b3) == null) {
            return null;
        }
        return fragmentManager.o0(str);
    }

    private void u0() {
        this.L3 = new LifecycleRegistry(this);
        this.P3 = SavedStateRegistryController.a(this);
        this.O3 = null;
        if (!this.S3.contains(this.T3)) {
            T1(this.T3);
        }
    }

    @NonNull
    @Deprecated
    public static Fragment w0(@NonNull Context context, @NonNull String str) {
        return x0(context, str, (Bundle) null);
    }

    @NonNull
    @Deprecated
    public static Fragment x0(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentFactory.d(context.getClassLoader(), str).getConstructor((Class[]) null).newInstance((Object[]) null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.i2(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    @NonNull
    public final SavedStateRegistry A() {
        return this.P3.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.m3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A0() {
        /*
            r2 = this;
            boolean r0 = r2.t3
            if (r0 != 0) goto L_0x0013
            androidx.fragment.app.FragmentManager r0 = r2.m3
            if (r0 == 0) goto L_0x0011
            androidx.fragment.app.Fragment r1 = r2.p3
            boolean r0 = r0.Z0(r1)
            if (r0 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.A0():boolean");
    }

    /* access modifiers changed from: package-private */
    public void A1() {
        this.s = -1;
        this.z3 = false;
        Y0();
        this.H3 = null;
        if (!this.z3) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.o3.V0()) {
            this.o3.L();
            this.o3 = new FragmentManagerImpl();
        }
    }

    @Deprecated
    public void A2(@Nullable Fragment fragment, int i2) {
        if (fragment != null) {
            FragmentStrictMode.p(this, fragment, i2);
        }
        FragmentManager fragmentManager = this.m3;
        FragmentManager fragmentManager2 = fragment != null ? fragment.m3 : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (!fragment2.equals(this)) {
                    fragment2 = fragment2.m0(false);
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.b3 = null;
            } else if (this.m3 == null || fragment.m3 == null) {
                this.b3 = null;
                this.a3 = fragment;
                this.c3 = i2;
                return;
            } else {
                this.b3 = fragment.Y2;
            }
            this.a3 = null;
            this.c3 = i2;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Nullable
    public Context B() {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.m();
    }

    /* access modifiers changed from: package-private */
    public final boolean B0() {
        return this.l3 > 0;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater B1(@Nullable Bundle bundle) {
        LayoutInflater Z0 = Z0(bundle);
        this.H3 = Z0;
        return Z0;
    }

    @Deprecated
    public void B2(boolean z) {
        FragmentStrictMode.q(this, z);
        if (!this.D3 && z && this.s < 5 && this.m3 != null && y0() && this.I3) {
            FragmentManager fragmentManager = this.m3;
            fragmentManager.q1(fragmentManager.D(this));
        }
        this.D3 = z;
        this.C3 = this.s < 5 && !z;
        if (this.X != null) {
            this.X2 = Boolean.valueOf(z);
        }
    }

    public final boolean C0() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public void C1() {
        onLowMemory();
    }

    public boolean C2(@NonNull String str) {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.B(str);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @AnimRes
    public int D() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f7886c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.m3;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean D0() {
        /*
            r2 = this;
            boolean r0 = r2.y3
            if (r0 == 0) goto L_0x0012
            androidx.fragment.app.FragmentManager r0 = r2.m3
            if (r0 == 0) goto L_0x0010
            androidx.fragment.app.Fragment r1 = r2.p3
            boolean r0 = r0.a1(r1)
            if (r0 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.D0():boolean");
    }

    /* access modifiers changed from: package-private */
    public void D1(boolean z) {
        d1(z);
    }

    public void D2(@SuppressLint({"UnknownNullness"}) Intent intent) {
        E2(intent, (Bundle) null);
    }

    @Nullable
    public Object E() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.f7893j;
    }

    /* access modifiers changed from: package-private */
    public boolean E0() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.v;
    }

    /* access modifiers changed from: package-private */
    public boolean E1(@NonNull MenuItem menuItem) {
        if (this.t3) {
            return false;
        }
        if (!this.x3 || !this.y3 || !e1(menuItem)) {
            return this.o3.R(menuItem);
        }
        return true;
    }

    public void E2(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.E(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* access modifiers changed from: package-private */
    public SharedElementCallback F() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.r;
    }

    public final boolean F0() {
        return this.f3;
    }

    /* access modifiers changed from: package-private */
    public void F1(@NonNull Menu menu) {
        if (!this.t3) {
            if (this.x3 && this.y3) {
                f1(menu);
            }
            this.o3.S(menu);
        }
    }

    @Deprecated
    public void F2(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (this.n3 != null) {
            V().k1(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> G(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return R1(activityResultContract, new Function<Void, ActivityResultRegistry>() {
            /* renamed from: a */
            public ActivityResultRegistry apply(Void voidR) {
                Fragment fragment = Fragment.this;
                FragmentHostCallback<?> fragmentHostCallback = fragment.n3;
                return fragmentHostCallback instanceof ActivityResultRegistryOwner ? ((ActivityResultRegistryOwner) fragmentHostCallback).r() : fragment.V1().r();
            }
        }, activityResultCallback);
    }

    public final boolean G0() {
        return this.s >= 7;
    }

    /* access modifiers changed from: package-private */
    public void G1() {
        this.o3.U();
        if (this.B3 != null) {
            this.M3.b(Lifecycle.Event.ON_PAUSE);
        }
        this.L3.l(Lifecycle.Event.ON_PAUSE);
        this.s = 6;
        this.z3 = false;
        g1();
        if (!this.z3) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    @Deprecated
    public void G2(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i4, int i5, int i6, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (this.n3 != null) {
            if (FragmentManager.W0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(this);
                sb.append(" received the following in startIntentSenderForResult() requestCode: ");
                int i7 = i2;
                sb.append(i2);
                sb.append(" IntentSender: ");
                IntentSender intentSender2 = intentSender;
                sb.append(intentSender);
                sb.append(" fillInIntent: ");
                Intent intent2 = intent;
                sb.append(intent);
                sb.append(" options: ");
                sb.append(bundle);
                Log.v(FragmentManager.Y, sb.toString());
            } else {
                IntentSender intentSender3 = intentSender;
                int i8 = i2;
                Intent intent3 = intent;
                Bundle bundle2 = bundle;
            }
            V().l1(this, intentSender, i2, intent, i4, i5, i6, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* access modifiers changed from: package-private */
    @AnimRes
    public int H() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f7887d;
    }

    public final boolean H0() {
        FragmentManager fragmentManager = this.m3;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.d1();
    }

    /* access modifiers changed from: package-private */
    public void H1(boolean z) {
        h1(z);
    }

    public void H2() {
        if (this.E3 != null && m().v) {
            if (this.n3 == null) {
                m().v = false;
            } else if (Looper.myLooper() != this.n3.n().getLooper()) {
                this.n3.n().postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        Fragment.this.j(false);
                    }
                });
            } else {
                j(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r1.B3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean I0() {
        /*
            r1 = this;
            boolean r0 = r1.y0()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.A0()
            if (r0 != 0) goto L_0x0020
            android.view.View r0 = r1.B3
            if (r0 == 0) goto L_0x0020
            android.os.IBinder r0 = r0.getWindowToken()
            if (r0 == 0) goto L_0x0020
            android.view.View r0 = r1.B3
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.I0():boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean I1(@NonNull Menu menu) {
        boolean z = false;
        if (this.t3) {
            return false;
        }
        if (this.x3 && this.y3) {
            i1(menu);
            z = true;
        }
        return z | this.o3.W(menu);
    }

    public void I2(@NonNull View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    @Nullable
    public Object J() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.f7895l;
    }

    /* access modifiers changed from: package-private */
    public void J0() {
        this.o3.n1();
    }

    /* access modifiers changed from: package-private */
    public void J1() {
        boolean b1 = this.m3.b1(this);
        Boolean bool = this.d3;
        if (bool == null || bool.booleanValue() != b1) {
            this.d3 = Boolean.valueOf(b1);
            j1(b1);
            this.o3.X();
        }
    }

    /* access modifiers changed from: package-private */
    public SharedElementCallback K() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.s;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void K0(@Nullable Bundle bundle) {
        this.z3 = true;
    }

    /* access modifiers changed from: package-private */
    public void K1() {
        this.o3.n1();
        this.o3.j0(true);
        this.s = 7;
        this.z3 = false;
        l1();
        if (this.z3) {
            LifecycleRegistry lifecycleRegistry = this.L3;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            lifecycleRegistry.l(event);
            if (this.B3 != null) {
                this.M3.b(event);
            }
            this.o3.Y();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public View L() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.u;
    }

    @Deprecated
    public void L0(int i2, int i4, @Nullable Intent intent) {
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i4 + " data: " + intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void L1(Bundle bundle) {
        m1(bundle);
        this.P3.e(bundle);
        Bundle Q1 = this.o3.e1();
        if (Q1 != null) {
            bundle.putParcelable("android:support:fragments", Q1);
        }
    }

    @Deprecated
    @Nullable
    public final FragmentManager M() {
        return this.m3;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void M0(@NonNull Activity activity) {
        this.z3 = true;
    }

    /* access modifiers changed from: package-private */
    public void M1() {
        this.o3.n1();
        this.o3.j0(true);
        this.s = 5;
        this.z3 = false;
        n1();
        if (this.z3) {
            LifecycleRegistry lifecycleRegistry = this.L3;
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            lifecycleRegistry.l(event);
            if (this.B3 != null) {
                this.M3.b(event);
            }
            this.o3.Z();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    @Nullable
    public final Object N() {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.p();
    }

    @CallSuper
    @MainThread
    public void N0(@NonNull Context context) {
        this.z3 = true;
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        Activity j2 = fragmentHostCallback == null ? null : fragmentHostCallback.j();
        if (j2 != null) {
            this.z3 = false;
            M0(j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void N1() {
        this.o3.b0();
        if (this.B3 != null) {
            this.M3.b(Lifecycle.Event.ON_STOP);
        }
        this.L3.l(Lifecycle.Event.ON_STOP);
        this.s = 4;
        this.z3 = false;
        o1();
        if (!this.z3) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final int O() {
        return this.q3;
    }

    @MainThread
    @Deprecated
    public void O0(@NonNull Fragment fragment) {
    }

    /* access modifiers changed from: package-private */
    public void O1() {
        p1(this.B3, this.X);
        this.o3.c0();
    }

    @NonNull
    public final LayoutInflater P() {
        LayoutInflater layoutInflater = this.H3;
        return layoutInflater == null ? B1((Bundle) null) : layoutInflater;
    }

    @MainThread
    public boolean P0(@NonNull MenuItem menuItem) {
        return false;
    }

    public void P1() {
        m().v = true;
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutInflater Q(@Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback != null) {
            LayoutInflater s2 = fragmentHostCallback.s();
            LayoutInflaterCompat.d(s2, this.o3.K0());
            return s2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    public void Q0(@Nullable Bundle bundle) {
        this.z3 = true;
        c2(bundle);
        if (!this.o3.c1(1)) {
            this.o3.J();
        }
    }

    public final void Q1(long j2, @NonNull TimeUnit timeUnit) {
        m().v = true;
        FragmentManager fragmentManager = this.m3;
        Handler n2 = fragmentManager != null ? fragmentManager.J0().n() : new Handler(Looper.getMainLooper());
        n2.removeCallbacks(this.F3);
        n2.postDelayed(this.F3, timeUnit.toMillis(j2));
    }

    @NonNull
    @Deprecated
    public LoaderManager R() {
        return LoaderManager.d(this);
    }

    @MainThread
    @Nullable
    public Animation R0(int i2, boolean z, int i4) {
        return null;
    }

    @MainThread
    @Nullable
    public Animator S0(int i2, boolean z, int i4) {
        return null;
    }

    public void S1(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    /* access modifiers changed from: package-private */
    public int T() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f7890g;
    }

    @MainThread
    @Deprecated
    public void T0(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    @Nullable
    public final Fragment U() {
        return this.p3;
    }

    @MainThread
    @Nullable
    public View U0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2 = this.Q3;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    @Deprecated
    public final void U1(@NonNull String[] strArr, int i2) {
        if (this.n3 != null) {
            V().j1(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentManager V() {
        FragmentManager fragmentManager = this.m3;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @CallSuper
    @MainThread
    public void V0() {
        this.z3 = true;
    }

    @NonNull
    public final FragmentActivity V1() {
        FragmentActivity r = r();
        if (r != null) {
            return r;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    /* access modifiers changed from: package-private */
    public boolean W() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.f7885b;
    }

    @MainThread
    @Deprecated
    public void W0() {
    }

    @NonNull
    public final Bundle W1() {
        Bundle y = y();
        if (y != null) {
            return y;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    /* access modifiers changed from: package-private */
    @AnimRes
    public int X() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f7888e;
    }

    @CallSuper
    @MainThread
    public void X0() {
        this.z3 = true;
    }

    @NonNull
    public final Context X1() {
        Context B = B();
        if (B != null) {
            return B;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* access modifiers changed from: package-private */
    @AnimRes
    public int Y() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f7889f;
    }

    @CallSuper
    @MainThread
    public void Y0() {
        this.z3 = true;
    }

    @NonNull
    @Deprecated
    public final FragmentManager Y1() {
        return V();
    }

    /* access modifiers changed from: package-private */
    public float Z() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return 1.0f;
        }
        return animationInfo.t;
    }

    @NonNull
    public LayoutInflater Z0(@Nullable Bundle bundle) {
        return Q(bundle);
    }

    @NonNull
    public final Object Z1() {
        Object N = N();
        if (N != null) {
            return N;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public Lifecycle a() {
        return this.L3;
    }

    @Nullable
    public Object a0() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.f7896m;
        return obj == U3 ? J() : obj;
    }

    @MainThread
    public void a1(boolean z) {
    }

    @NonNull
    public final Fragment a2() {
        Fragment U = U();
        if (U != null) {
            return U;
        }
        if (B() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + B());
    }

    @NonNull
    public final Resources b0() {
        return X1().getResources();
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void b1(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.z3 = true;
    }

    @NonNull
    public final View b2() {
        View q0 = q0();
        if (q0 != null) {
            return q0;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public final boolean c0() {
        FragmentStrictMode.k(this);
        return this.v3;
    }

    @CallSuper
    @UiThread
    public void c1(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.z3 = true;
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        Activity j2 = fragmentHostCallback == null ? null : fragmentHostCallback.j();
        if (j2 != null) {
            this.z3 = false;
            b1(j2, attributeSet, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void c2(@Nullable Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.o3.M1(parcelable);
            this.o3.J();
        }
    }

    @Nullable
    public Object d0() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.f7894k;
        return obj == U3 ? E() : obj;
    }

    public void d1(boolean z) {
    }

    @Nullable
    public Object e0() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.f7897n;
    }

    @MainThread
    @Deprecated
    public boolean e1(@NonNull MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void e2(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.Y;
        if (sparseArray != null) {
            this.B3.restoreHierarchyState(sparseArray);
            this.Y = null;
        }
        if (this.B3 != null) {
            this.M3.f(this.Z);
            this.Z = null;
        }
        this.z3 = false;
        q1(bundle);
        if (!this.z3) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.B3 != null) {
            this.M3.b(Lifecycle.Event.ON_CREATE);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Nullable
    public Object f0() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.o;
        return obj == U3 ? e0() : obj;
    }

    @MainThread
    @Deprecated
    public void f1(@NonNull Menu menu) {
    }

    public void f2(boolean z) {
        m().q = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f7891h;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> g0() {
        /*
            r1 = this;
            androidx.fragment.app.Fragment$AnimationInfo r0 = r1.E3
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList<java.lang.String> r0 = r0.f7891h
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.g0():java.util.ArrayList");
    }

    @CallSuper
    @MainThread
    public void g1() {
        this.z3 = true;
    }

    public void g2(boolean z) {
        m().p = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f7892i;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> h0() {
        /*
            r1 = this;
            androidx.fragment.app.Fragment$AnimationInfo r0 = r1.E3
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList<java.lang.String> r0 = r0.f7892i
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.h0():java.util.ArrayList");
    }

    public void h1(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void h2(@AnimRes int i2, @AnimRes int i4, @AnimRes int i5, @AnimRes int i6) {
        if (this.E3 != null || i2 != 0 || i4 != 0 || i5 != 0 || i6 != 0) {
            m().f7886c = i2;
            m().f7887d = i4;
            m().f7888e = i5;
            m().f7889f = i6;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public final String i0(@StringRes int i2) {
        return b0().getString(i2);
    }

    @MainThread
    @Deprecated
    public void i1(@NonNull Menu menu) {
    }

    public void i2(@Nullable Bundle bundle) {
        if (this.m3 == null || !H0()) {
            this.Z2 = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        AnimationInfo animationInfo = this.E3;
        if (animationInfo != null) {
            animationInfo.v = false;
        }
        if (this.B3 != null && (viewGroup = this.A3) != null && (fragmentManager = this.m3) != null) {
            final SpecialEffectsController n2 = SpecialEffectsController.n(viewGroup, fragmentManager);
            n2.p();
            if (z) {
                this.n3.n().post(new Runnable() {
                    public void run() {
                        n2.g();
                    }
                });
            } else {
                n2.g();
            }
        }
    }

    @NonNull
    public final String j0(@StringRes int i2, @Nullable Object... objArr) {
        return b0().getString(i2, objArr);
    }

    @MainThread
    public void j1(boolean z) {
    }

    public void j2(@Nullable SharedElementCallback sharedElementCallback) {
        m().r = sharedElementCallback;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer k() {
        return new FragmentContainer() {
            @Nullable
            public View g(int i2) {
                View view = Fragment.this.B3;
                if (view != null) {
                    return view.findViewById(i2);
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
            }

            public boolean i() {
                return Fragment.this.B3 != null;
            }
        };
    }

    @Nullable
    public final String k0() {
        return this.s3;
    }

    @Deprecated
    public void k1(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void k2(@Nullable Object obj) {
        m().f7893j = obj;
    }

    public void l(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.q3));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.r3));
        printWriter.print(" mTag=");
        printWriter.println(this.s3);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.s);
        printWriter.print(" mWho=");
        printWriter.print(this.Y2);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.l3);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.e3);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.h3);
        printWriter.print(" mInLayout=");
        printWriter.println(this.i3);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.t3);
        printWriter.print(" mDetached=");
        printWriter.print(this.u3);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.y3);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.x3);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.v3);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.D3);
        if (this.m3 != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.m3);
        }
        if (this.n3 != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.n3);
        }
        if (this.p3 != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.p3);
        }
        if (this.Z2 != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.Z2);
        }
        if (this.X != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.X);
        }
        if (this.Y != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.Y);
        }
        if (this.Z != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.Z);
        }
        Fragment m0 = m0(false);
        if (m0 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(m0);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.c3);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(W());
        if (D() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(D());
        }
        if (H() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(H());
        }
        if (X() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(X());
        }
        if (Y() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(Y());
        }
        if (this.A3 != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.A3);
        }
        if (this.B3 != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.B3);
        }
        if (x() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(x());
        }
        if (B() != null) {
            LoaderManager.d(this).b(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.o3 + ":");
        FragmentManager fragmentManager = this.o3;
        fragmentManager.e0(str + "  ", fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    @Nullable
    public final Fragment l0() {
        return m0(true);
    }

    @CallSuper
    @MainThread
    public void l1() {
        this.z3 = true;
    }

    public void l2(@Nullable SharedElementCallback sharedElementCallback) {
        m().s = sharedElementCallback;
    }

    @MainThread
    public void m1(@NonNull Bundle bundle) {
    }

    public void m2(@Nullable Object obj) {
        m().f7895l = obj;
    }

    @NonNull
    public ViewModelProvider.Factory n() {
        Application application;
        if (this.m3 != null) {
            if (this.O3 == null) {
                Context applicationContext = X1().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        application = null;
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && FragmentManager.W0(3)) {
                    Log.d(FragmentManager.Y, "Could not find Application instance from Context " + X1().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.O3 = new SavedStateViewModelFactory(application, this, y());
            }
            return this.O3;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Deprecated
    public final int n0() {
        FragmentStrictMode.l(this);
        return this.c3;
    }

    @CallSuper
    @MainThread
    public void n1() {
        this.z3 = true;
    }

    /* access modifiers changed from: package-private */
    public void n2(View view) {
        m().u = view;
    }

    @CallSuper
    @NonNull
    public CreationExtras o() {
        Application application;
        Context applicationContext = X1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        if (application == null && FragmentManager.W0(3)) {
            Log.d(FragmentManager.Y, "Could not find Application instance from Context " + X1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f8614i, application);
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f8580c, this);
        mutableCreationExtras.c(SavedStateHandleSupport.f8581d, this);
        if (y() != null) {
            mutableCreationExtras.c(SavedStateHandleSupport.f8582e, y());
        }
        return mutableCreationExtras;
    }

    @NonNull
    public final CharSequence o0(@StringRes int i2) {
        return b0().getText(i2);
    }

    @CallSuper
    @MainThread
    public void o1() {
        this.z3 = true;
    }

    @Deprecated
    public void o2(boolean z) {
        if (this.x3 != z) {
            this.x3 = z;
            if (y0() && !A0()) {
                this.n3.I();
            }
        }
    }

    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.z3 = true;
    }

    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        V1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.z3 = true;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment p(@NonNull String str) {
        return str.equals(this.Y2) ? this : this.o3.t0(str);
    }

    @Deprecated
    public boolean p0() {
        return this.D3;
    }

    @MainThread
    public void p1(@NonNull View view, @Nullable Bundle bundle) {
    }

    public void p2(@Nullable SavedState savedState) {
        Bundle bundle;
        if (this.m3 == null) {
            if (savedState == null || (bundle = savedState.s) == null) {
                bundle = null;
            }
            this.X = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String q() {
        return "fragment_" + this.Y2 + "_rq#" + this.R3.getAndIncrement();
    }

    @Nullable
    public View q0() {
        return this.B3;
    }

    @CallSuper
    @MainThread
    public void q1(@Nullable Bundle bundle) {
        this.z3 = true;
    }

    public void q2(boolean z) {
        if (this.y3 != z) {
            this.y3 = z;
            if (this.x3 && y0() && !A0()) {
                this.n3.I();
            }
        }
    }

    @Nullable
    public final FragmentActivity r() {
        FragmentHostCallback<?> fragmentHostCallback = this.n3;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.j();
    }

    @MainThread
    @NonNull
    public LifecycleOwner r0() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.M3;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void r1(Bundle bundle) {
        this.o3.n1();
        this.s = 3;
        this.z3 = false;
        K0(bundle);
        if (this.z3) {
            d2();
            this.o3.F();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void r2(int i2) {
        if (this.E3 != null || i2 != 0) {
            m();
            this.E3.f7890g = i2;
        }
    }

    @NonNull
    public LiveData<LifecycleOwner> s0() {
        return this.N3;
    }

    /* access modifiers changed from: package-private */
    public void s1() {
        Iterator<OnPreAttachedListener> it2 = this.S3.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.S3.clear();
        this.o3.s(this.n3, k(), this);
        this.s = 0;
        this.z3 = false;
        N0(this.n3.m());
        if (this.z3) {
            this.m3.P(this);
            this.o3.G();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* access modifiers changed from: package-private */
    public void s2(boolean z) {
        if (this.E3 != null) {
            m().f7885b = z;
        }
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        F2(intent, i2, (Bundle) null);
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> t(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return R1(activityResultContract, new Function<Void, ActivityResultRegistry>() {
            /* renamed from: a */
            public ActivityResultRegistry apply(Void voidR) {
                return activityResultRegistry;
            }
        }, activityResultCallback);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean t0() {
        return this.x3;
    }

    /* access modifiers changed from: package-private */
    public void t1(@NonNull Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: package-private */
    public void t2(float f2) {
        m().t = f2;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.Y2);
        if (this.q3 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.q3));
        }
        if (this.s3 != null) {
            sb.append(" tag=");
            sb.append(this.s3);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        Boolean bool;
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null || (bool = animationInfo.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean u1(@NonNull MenuItem menuItem) {
        if (this.t3) {
            return false;
        }
        if (P0(menuItem)) {
            return true;
        }
        return this.o3.I(menuItem);
    }

    public void u2(@Nullable Object obj) {
        m().f7896m = obj;
    }

    public boolean v() {
        Boolean bool;
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null || (bool = animationInfo.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void v0() {
        u0();
        this.J3 = this.Y2;
        this.Y2 = UUID.randomUUID().toString();
        this.e3 = false;
        this.f3 = false;
        this.h3 = false;
        this.i3 = false;
        this.j3 = false;
        this.l3 = 0;
        this.m3 = null;
        this.o3 = new FragmentManagerImpl();
        this.n3 = null;
        this.q3 = 0;
        this.r3 = 0;
        this.s3 = null;
        this.t3 = false;
        this.u3 = false;
    }

    /* access modifiers changed from: package-private */
    public void v1(Bundle bundle) {
        this.o3.n1();
        this.s = 1;
        this.z3 = false;
        this.L3.a(new LifecycleEventObserver() {
            public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                View view;
                if (event == Lifecycle.Event.ON_STOP && (view = Fragment.this.B3) != null) {
                    Api19Impl.a(view);
                }
            }
        });
        this.P3.d(bundle);
        Q0(bundle);
        this.I3 = true;
        if (this.z3) {
            this.L3.l(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    @Deprecated
    public void v2(boolean z) {
        FragmentStrictMode.o(this);
        this.v3 = z;
        FragmentManager fragmentManager = this.m3;
        if (fragmentManager == null) {
            this.w3 = true;
        } else if (z) {
            fragmentManager.q(this);
        } else {
            fragmentManager.G1(this);
        }
    }

    @NonNull
    public ViewModelStore w() {
        if (this.m3 == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (S() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.m3.R0(this);
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean w1(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        boolean z = false;
        if (this.t3) {
            return false;
        }
        if (this.x3 && this.y3) {
            T0(menu, menuInflater);
            z = true;
        }
        return z | this.o3.K(menu, menuInflater);
    }

    public void w2(@Nullable Object obj) {
        m().f7894k = obj;
    }

    /* access modifiers changed from: package-private */
    public View x() {
        AnimationInfo animationInfo = this.E3;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.f7884a;
    }

    /* access modifiers changed from: package-private */
    public void x1(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.o3.n1();
        this.k3 = true;
        this.M3 = new FragmentViewLifecycleOwner(this, w());
        View U0 = U0(layoutInflater, viewGroup, bundle);
        this.B3 = U0;
        if (U0 != null) {
            this.M3.c();
            ViewTreeLifecycleOwner.b(this.B3, this.M3);
            ViewTreeViewModelStoreOwner.b(this.B3, this.M3);
            ViewTreeSavedStateRegistryOwner.b(this.B3, this.M3);
            this.N3.r(this.M3);
        } else if (!this.M3.d()) {
            this.M3 = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    public void x2(@Nullable Object obj) {
        m().f7897n = obj;
    }

    @Nullable
    public final Bundle y() {
        return this.Z2;
    }

    public final boolean y0() {
        return this.n3 != null && this.e3;
    }

    /* access modifiers changed from: package-private */
    public void y1() {
        this.o3.L();
        this.L3.l(Lifecycle.Event.ON_DESTROY);
        this.s = 0;
        this.z3 = false;
        this.I3 = false;
        V0();
        if (!this.z3) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    public void y2(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        m();
        AnimationInfo animationInfo = this.E3;
        animationInfo.f7891h = arrayList;
        animationInfo.f7892i = arrayList2;
    }

    @NonNull
    public final FragmentManager z() {
        if (this.n3 != null) {
            return this.o3;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final boolean z0() {
        return this.u3;
    }

    /* access modifiers changed from: package-private */
    public void z1() {
        this.o3.M();
        if (this.B3 != null && this.M3.a().b().b(Lifecycle.State.CREATED)) {
            this.M3.b(Lifecycle.Event.ON_DESTROY);
        }
        this.s = 1;
        this.z3 = false;
        X0();
        if (this.z3) {
            LoaderManager.d(this).h();
            this.k3 = false;
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void z2(@Nullable Object obj) {
        m().o = obj;
    }

    @ContentView
    public Fragment(@LayoutRes int i2) {
        this();
        this.Q3 = i2;
    }
}
