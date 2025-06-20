package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String u3 = "android:support:lifecycle";
    final FragmentController p3 = FragmentController.b(new HostCallbacks());
    final LifecycleRegistry q3 = new LifecycleRegistry(this);
    boolean r3;
    boolean s3;
    boolean t3 = true;

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        @NonNull
        public SavedStateRegistry A() {
            return FragmentActivity.this.A();
        }

        public boolean B(@NonNull String str) {
            return ActivityCompat.T(FragmentActivity.this, str);
        }

        public void D(@NonNull Consumer<Integer> consumer) {
            FragmentActivity.this.D(consumer);
        }

        public void F(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
            FragmentActivity.this.F(menuProvider, lifecycleOwner, state);
        }

        public void H(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.H(menuProvider);
        }

        public void I() {
            K();
        }

        /* renamed from: J */
        public FragmentActivity p() {
            return FragmentActivity.this;
        }

        public void K() {
            FragmentActivity.this.invalidateOptionsMenu();
        }

        public void L(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.L(consumer);
        }

        @NonNull
        public Lifecycle a() {
            return FragmentActivity.this.q3;
        }

        public void b(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            FragmentActivity.this.t0(fragment);
        }

        public void c(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
            FragmentActivity.this.c(menuProvider, lifecycleOwner);
        }

        @NonNull
        public OnBackPressedDispatcher e() {
            return FragmentActivity.this.e();
        }

        public void f(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.f(menuProvider);
        }

        @Nullable
        public View g(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        public void h(@NonNull Consumer<Configuration> consumer) {
            FragmentActivity.this.h(consumer);
        }

        public boolean i() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public void k(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.k(consumer);
        }

        public void l(@NonNull Consumer<Integer> consumer) {
            FragmentActivity.this.l(consumer);
        }

        public void o(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public void q(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.q(consumer);
        }

        @NonNull
        public ActivityResultRegistry r() {
            return FragmentActivity.this.r();
        }

        @NonNull
        public LayoutInflater s() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int t() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public void u(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.u(consumer);
        }

        public boolean v() {
            return FragmentActivity.this.getWindow() != null;
        }

        @NonNull
        public ViewModelStore w() {
            return FragmentActivity.this.w();
        }

        public boolean y(@NonNull Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public void z(@NonNull Consumer<Configuration> consumer) {
            FragmentActivity.this.z(consumer);
        }
    }

    public FragmentActivity() {
        m0();
    }

    private void m0() {
        A().j(u3, new a(this));
        h(new b(this));
        E(new c(this));
        J(new d(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle n0() {
        r0();
        this.q3.l(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(Configuration configuration) {
        this.p3.F();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(Intent intent) {
        this.p3.F();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(Context context) {
        this.p3.a((Fragment) null);
    }

    private static boolean s0(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment next : fragmentManager.I0()) {
            if (next != null) {
                if (next.N() != null) {
                    z |= s0(next.z(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = next.M3;
                if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.a().b().b(Lifecycle.State.STARTED)) {
                    next.M3.h(state);
                    z = true;
                }
                if (next.L3.b().b(Lifecycle.State.STARTED)) {
                    next.L3.s(state);
                    z = true;
                }
            }
        }
        return z;
    }

    public void A0() {
        ActivityCompat.E(this);
    }

    @Deprecated
    public void B0() {
        invalidateOptionsMenu();
    }

    public void C0() {
        ActivityCompat.K(this);
    }

    public void D0() {
        ActivityCompat.W(this);
    }

    @Deprecated
    public final void d(int i2) {
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (Q(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.r3);
            printWriter.print(" mResumed=");
            printWriter.print(this.s3);
            printWriter.print(" mStopped=");
            printWriter.print(this.t3);
            if (getApplication() != null) {
                LoaderManager.d(this).b(str2, fileDescriptor, printWriter, strArr);
            }
            this.p3.D().e0(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final View j0(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.p3.G(view, str, context, attributeSet);
    }

    @NonNull
    public FragmentManager k0() {
        return this.p3.D();
    }

    @NonNull
    @Deprecated
    public LoaderManager l0() {
        return LoaderManager.d(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        this.p3.F();
        super.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.q3.l(Lifecycle.Event.ON_CREATE);
        this.p3.f();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View j0 = j0(view, str, context, attributeSet);
        return j0 == null ? super.onCreateView(view, str, context, attributeSet) : j0;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.p3.h();
        this.q3.l(Lifecycle.Event.ON_DESTROY);
    }

    public boolean onMenuItemSelected(int i2, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 6) {
            return this.p3.e(menuItem);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.s3 = false;
        this.p3.n();
        this.q3.l(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        u0();
    }

    @CallSuper
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.p3.F();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.p3.F();
        super.onResume();
        this.s3 = true;
        this.p3.z();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.p3.F();
        super.onStart();
        this.t3 = false;
        if (!this.r3) {
            this.r3 = true;
            this.p3.c();
        }
        this.p3.z();
        this.q3.l(Lifecycle.Event.ON_START);
        this.p3.s();
    }

    public void onStateNotSaved() {
        this.p3.F();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.t3 = true;
        r0();
        this.p3.t();
        this.q3.l(Lifecycle.Event.ON_STOP);
    }

    /* access modifiers changed from: package-private */
    public void r0() {
        do {
        } while (s0(k0(), Lifecycle.State.CREATED));
    }

    @MainThread
    @Deprecated
    public void t0(@NonNull Fragment fragment) {
    }

    /* access modifiers changed from: protected */
    public void u0() {
        this.q3.l(Lifecycle.Event.ON_RESUME);
        this.p3.r();
    }

    public void v0(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.P(this, sharedElementCallback);
    }

    public void w0(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.Q(this, sharedElementCallback);
    }

    public void x0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        y0(fragment, intent, i2, (Bundle) null);
    }

    public void y0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (i2 == -1) {
            ActivityCompat.U(this, intent, -1, bundle);
        } else {
            fragment.F2(intent, i2, bundle);
        }
    }

    @Deprecated
    public void z0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            ActivityCompat.V(this, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            fragment.G2(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @ContentView
    public FragmentActivity(@LayoutRes int i2) {
        super(i2);
        m0();
    }

    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View j0 = j0((View) null, str, context, attributeSet);
        return j0 == null ? super.onCreateView(str, context, attributeSet) : j0;
    }
}
