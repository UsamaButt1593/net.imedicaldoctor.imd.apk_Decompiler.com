package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String o3 = "android:support:activity-result";
    private final LifecycleRegistry X2;
    final ContextAwareHelper Y;
    final SavedStateRegistryController Y2;
    private final MenuHostHelper Z;
    private ViewModelStore Z2;
    private ViewModelProvider.Factory a3;
    /* access modifiers changed from: private */
    public OnBackPressedDispatcher b3;
    final ReportFullyDrawnExecutor c3;
    @NonNull
    final FullyDrawnReporter d3;
    @LayoutRes
    private int e3;
    private final AtomicInteger f3;
    private final ActivityResultRegistry g3;
    private final CopyOnWriteArrayList<Consumer<Configuration>> h3;
    private final CopyOnWriteArrayList<Consumer<Integer>> i3;
    private final CopyOnWriteArrayList<Consumer<Intent>> j3;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> k3;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> l3;
    private boolean m3;
    private boolean n3;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {

        /* renamed from: a  reason: collision with root package name */
        Object f2421a;

        /* renamed from: b  reason: collision with root package name */
        ViewModelStore f2422b;

        NonConfigurationInstances() {
        }
    }

    private interface ReportFullyDrawnExecutor extends Executor {
        void C();

        void p0(@NonNull View view);
    }

    static class ReportFullyDrawnExecutorApi1 implements ReportFullyDrawnExecutor {
        final Handler s = a();

        ReportFullyDrawnExecutorApi1() {
        }

        @NonNull
        private Handler a() {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = Looper.getMainLooper();
            }
            return new Handler(myLooper);
        }

        public void C() {
        }

        public void execute(Runnable runnable) {
            this.s.postAtFrontOfQueue(runnable);
        }

        public void p0(@NonNull View view) {
        }
    }

    @RequiresApi(16)
    class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        Runnable X;
        boolean Y = false;
        final long s = (SystemClock.uptimeMillis() + 10000);

        ReportFullyDrawnExecutorApi16Impl() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.X;
            if (runnable != null) {
                runnable.run();
                this.X = null;
            }
        }

        public void C() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void execute(Runnable runnable) {
            this.X = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.Y) {
                decorView.postOnAnimation(new e(this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public void onDraw() {
            Runnable runnable = this.X;
            if (runnable != null) {
                runnable.run();
                this.X = null;
                if (!ComponentActivity.this.d3.e()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.s) {
                return;
            }
            this.Y = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        public void p0(@NonNull View view) {
            if (!this.Y) {
                this.Y = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.Y = new ContextAwareHelper();
        this.Z = new MenuHostHelper(new a(this));
        this.X2 = new LifecycleRegistry(this);
        SavedStateRegistryController a2 = SavedStateRegistryController.a(this);
        this.Y2 = a2;
        this.b3 = null;
        ReportFullyDrawnExecutor X = X();
        this.c3 = X;
        this.d3 = new FullyDrawnReporter(X, new b(this));
        this.f3 = new AtomicInteger();
        this.g3 = new ActivityResultRegistry() {
            public <I, O> void f(final int i2, @NonNull ActivityResultContract<I, O> activityResultContract, I i3, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                Bundle bundle;
                ComponentActivity componentActivity = ComponentActivity.this;
                final ActivityResultContract.SynchronousResult<O> b2 = activityResultContract.b(componentActivity, i3);
                if (b2 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AnonymousClass1.this.c(i2, b2.a());
                        }
                    });
                    return;
                }
                Intent a2 = activityResultContract.a(componentActivity, i3);
                if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                    a2.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (a2.hasExtra(ActivityResultContracts.StartActivityForResult.f2514b)) {
                    Bundle bundleExtra = a2.getBundleExtra(ActivityResultContracts.StartActivityForResult.f2514b);
                    a2.removeExtra(ActivityResultContracts.StartActivityForResult.f2514b);
                    bundle = bundleExtra;
                } else {
                    bundle = activityOptionsCompat != null ? activityOptionsCompat.m() : null;
                }
                if (ActivityResultContracts.RequestMultiplePermissions.f2510b.equals(a2.getAction())) {
                    String[] stringArrayExtra = a2.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.f2511c);
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.N(componentActivity, stringArrayExtra, i2);
                } else if (ActivityResultContracts.StartIntentSenderForResult.f2516b.equals(a2.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.f2517c);
                    try {
                        ActivityCompat.V(componentActivity, intentSenderRequest.d(), i2, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
                    } catch (IntentSender.SendIntentException e2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.b(i2, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.f2516b).putExtra(ActivityResultContracts.StartIntentSenderForResult.f2518d, e2));
                            }
                        });
                    }
                } else {
                    ActivityCompat.U(componentActivity, a2, i2, bundle);
                }
            }
        };
        this.h3 = new CopyOnWriteArrayList<>();
        this.i3 = new CopyOnWriteArrayList<>();
        this.j3 = new CopyOnWriteArrayList<>();
        this.k3 = new CopyOnWriteArrayList<>();
        this.l3 = new CopyOnWriteArrayList<>();
        this.m3 = false;
        this.n3 = false;
        if (a() != null) {
            int i2 = Build.VERSION.SDK_INT;
            a().a(new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            Api19Impl.a(peekDecorView);
                        }
                    }
                }
            });
            a().a(new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.Y.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.w().a();
                        }
                        ComponentActivity.this.c3.C();
                    }
                }
            });
            a().a(new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    ComponentActivity.this.Y();
                    ComponentActivity.this.a().d(this);
                }
            });
            a2.c();
            SavedStateHandleSupport.c(this);
            if (i2 <= 23) {
                a().a(new ImmLeaksCleaner(this));
            }
            A().j(o3, new c(this));
            J(new d(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private ReportFullyDrawnExecutor X() {
        return new ReportFullyDrawnExecutorApi16Impl();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit b0() {
        reportFullyDrawn();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle c0() {
        Bundle bundle = new Bundle();
        this.g3.h(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(Context context) {
        Bundle b2 = A().b(o3);
        if (b2 != null) {
            this.g3.g(b2);
        }
    }

    @NonNull
    public final SavedStateRegistry A() {
        return this.Y2.b();
    }

    public final void D(@NonNull Consumer<Integer> consumer) {
        this.i3.add(consumer);
    }

    public final void E(@NonNull Consumer<Intent> consumer) {
        this.j3.add(consumer);
    }

    @SuppressLint({"LambdaLast"})
    public void F(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.Z.e(menuProvider, lifecycleOwner, state);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> G(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return t(activityResultContract, this.g3, activityResultCallback);
    }

    public void H(@NonNull MenuProvider menuProvider) {
        this.Z.c(menuProvider);
    }

    public final void J(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.Y.a(onContextAvailableListener);
    }

    public void K() {
        invalidateOptionsMenu();
    }

    public final void L(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.k3.remove(consumer);
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        if (this.Z2 == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.Z2 = nonConfigurationInstances.f2422b;
            }
            if (this.Z2 == null) {
                this.Z2 = new ViewModelStore();
            }
        }
    }

    @Deprecated
    @Nullable
    public Object Z() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.f2421a;
        }
        return null;
    }

    @NonNull
    public Lifecycle a() {
        return this.X2;
    }

    @CallSuper
    public void a0() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.b(getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.b(getWindow().getDecorView(), this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        a0();
        this.c3.p0(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void c(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.Z.d(menuProvider, lifecycleOwner);
    }

    @NonNull
    public final OnBackPressedDispatcher e() {
        if (this.b3 == null) {
            this.b3 = new OnBackPressedDispatcher(new Runnable() {
                public void run() {
                    try {
                        ComponentActivity.super.onBackPressed();
                    } catch (IllegalStateException e2) {
                        if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                            throw e2;
                        }
                    } catch (NullPointerException e3) {
                        if (!TextUtils.equals(e3.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                            throw e3;
                        }
                    }
                }
            });
            a().a(new LifecycleEventObserver() {
                public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                        ComponentActivity.this.b3.s(Api33Impl.a((ComponentActivity) lifecycleOwner));
                    }
                }
            });
        }
        return this.b3;
    }

    @Deprecated
    @Nullable
    public Object e0() {
        return null;
    }

    public void f(@NonNull MenuProvider menuProvider) {
        this.Z.l(menuProvider);
    }

    @NonNull
    public FullyDrawnReporter g() {
        return this.d3;
    }

    public final void h(@NonNull Consumer<Configuration> consumer) {
        this.h3.add(consumer);
    }

    public final void k(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.l3.remove(consumer);
    }

    public final void l(@NonNull Consumer<Integer> consumer) {
        this.i3.remove(consumer);
    }

    public final void m(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.Y.e(onContextAvailableListener);
    }

    @NonNull
    public ViewModelProvider.Factory n() {
        if (this.a3 == null) {
            this.a3 = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.a3;
    }

    @CallSuper
    @NonNull
    public CreationExtras o() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f8614i, getApplication());
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f8580c, this);
        mutableCreationExtras.c(SavedStateHandleSupport.f8581d, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            mutableCreationExtras.c(SavedStateHandleSupport.f8582e, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @Deprecated
    public void onActivityResult(int i2, int i4, @Nullable Intent intent) {
        if (!this.g3.b(i2, i4, intent)) {
            super.onActivityResult(i2, i4, intent);
        }
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onBackPressed() {
        e().p();
    }

    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it2 = this.h3.iterator();
        while (it2.hasNext()) {
            it2.next().accept(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        this.Y2.d(bundle);
        this.Y.c(this);
        super.onCreate(bundle);
        ReportFragment.g(this);
        int i2 = this.e3;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public boolean onCreatePanelMenu(int i2, @NonNull Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        this.Z.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i2, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.Z.j(menuItem);
        }
        return false;
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        if (!this.m3) {
            Iterator<Consumer<MultiWindowModeChangedInfo>> it2 = this.k3.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new MultiWindowModeChangedInfo(z));
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it2 = this.j3.iterator();
        while (it2.hasNext()) {
            it2.next().accept(intent);
        }
    }

    public void onPanelClosed(int i2, @NonNull Menu menu) {
        this.Z.i(menu);
        super.onPanelClosed(i2, menu);
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        if (!this.n3) {
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it2 = this.l3.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new PictureInPictureModeChangedInfo(z));
            }
        }
    }

    public boolean onPreparePanel(int i2, @Nullable View view, @NonNull Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        this.Z.k(menu);
        return true;
    }

    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.g3.b(i2, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.f2511c, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.f2512d, iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object e0 = e0();
        ViewModelStore viewModelStore = this.Z2;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.f2422b;
        }
        if (viewModelStore == null && e0 == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.f2421a = e0;
        nonConfigurationInstances2.f2422b = viewModelStore;
        return nonConfigurationInstances2;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle a2 = a();
        if (a2 instanceof LifecycleRegistry) {
            ((LifecycleRegistry) a2).s(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.Y2.e(bundle);
    }

    @CallSuper
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<Consumer<Integer>> it2 = this.i3.iterator();
        while (it2.hasNext()) {
            it2.next().accept(Integer.valueOf(i2));
        }
    }

    @Nullable
    public Context p() {
        return this.Y.d();
    }

    public final void q(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.l3.add(consumer);
    }

    @NonNull
    public final ActivityResultRegistry r() {
        return this.g3;
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.h()) {
                Trace.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.d3.d();
            Trace.f();
        } catch (Throwable th) {
            Trace.f();
            throw th;
        }
    }

    public void setContentView(@LayoutRes int i2) {
        a0();
        this.c3.p0(getWindow().getDecorView());
        super.setContentView(i2);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i4, int i5, int i6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i4, i5, i6);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> t(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.j("activity_rq#" + this.f3.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public final void u(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.k3.add(consumer);
    }

    @NonNull
    public ViewModelStore w() {
        if (getApplication() != null) {
            Y();
            return this.Z2;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final void x(@NonNull Consumer<Intent> consumer) {
        this.j3.remove(consumer);
    }

    public final void z(@NonNull Consumer<Configuration> consumer) {
        this.h3.remove(consumer);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i2) {
        this();
        this.e3 = i2;
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z, @NonNull Configuration configuration) {
        this.m3 = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.m3 = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it2 = this.k3.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new MultiWindowModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.m3 = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z, @NonNull Configuration configuration) {
        this.n3 = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.n3 = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it2 = this.l3.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new PictureInPictureModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.n3 = false;
            throw th;
        }
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        a0();
        this.c3.p0(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i4, int i5, int i6, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i4, i5, i6, bundle);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        a0();
        this.c3.p0(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
