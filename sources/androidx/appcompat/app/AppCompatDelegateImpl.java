package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.material.internal.ViewUtils;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    private static final SimpleArrayMap<String, Integer> p4 = new SimpleArrayMap<>();
    private static final boolean q4 = false;
    private static final int[] r4 = {16842836};
    private static final boolean s4 = (!"robolectric".equals(Build.FINGERPRINT));
    private static boolean t4 = false;
    static final String u4 = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    ActionMode A3;
    ActionBarContextView B3;
    PopupWindow C3;
    Runnable D3;
    ViewPropertyAnimatorCompat E3;
    private boolean F3;
    private boolean G3;
    ViewGroup H3;
    private TextView I3;
    private View J3;
    private boolean K3;
    private boolean L3;
    boolean M3;
    boolean N3;
    boolean O3;
    boolean P3;
    boolean Q3;
    private boolean R3;
    private PanelFeatureState[] S3;
    private PanelFeatureState T3;
    private boolean U3;
    private boolean V3;
    private boolean W3;
    boolean X3;
    private Configuration Y3;
    private int Z3;
    private int a4;
    private int b4;
    private boolean c4;
    private AutoNightModeManager d4;
    private AutoNightModeManager e4;
    boolean f4;
    int g4;
    private final Runnable h4;
    private boolean i4;
    private Rect j4;
    private Rect k4;
    private AppCompatViewInflater l4;
    private LayoutIncludeDetector m4;
    private OnBackInvokedDispatcher n4;
    private OnBackInvokedCallback o4;
    final Object p3;
    final Context q3;
    Window r3;
    private AppCompatWindowCallback s3;
    final AppCompatCallback t3;
    ActionBar u3;
    MenuInflater v3;
    private CharSequence w3;
    private DecorContentParent x3;
    private ActionMenuPresenterCallback y3;
    private PanelMenuPresenterCallback z3;

    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        public void a(Drawable drawable, int i2) {
            ActionBar C = AppCompatDelegateImpl.this.C();
            if (C != null) {
                C.l0(drawable);
                C.i0(i2);
            }
        }

        public Drawable b() {
            TintTypedArray F = TintTypedArray.F(e(), (AttributeSet) null, new int[]{R.attr.E1});
            Drawable h2 = F.h(0);
            F.I();
            return h2;
        }

        public void c(int i2) {
            ActionBar C = AppCompatDelegateImpl.this.C();
            if (C != null) {
                C.i0(i2);
            }
        }

        public boolean d() {
            ActionBar C = AppCompatDelegateImpl.this.C();
            return (C == null || (C.p() & 4) == 0) ? false : true;
        }

        public Context e() {
            return AppCompatDelegateImpl.this.I0();
        }
    }

    interface ActionBarMenuCallback {
        boolean a(int i2);

        @Nullable
        View onCreatePanelView(int i2);
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.u0(menuBuilder);
        }

        public boolean d(@NonNull MenuBuilder menuBuilder) {
            Window.Callback R0 = AppCompatDelegateImpl.this.R0();
            if (R0 == null) {
                return true;
            }
            R0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private ActionMode.Callback f2762a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f2762a = callback;
        }

        public void a(ActionMode actionMode) {
            this.f2762a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.C3 != null) {
                appCompatDelegateImpl.r3.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.D3);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.B3 != null) {
                appCompatDelegateImpl2.D0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.E3 = ViewCompat.g(appCompatDelegateImpl3.B3).b(0.0f);
                AppCompatDelegateImpl.this.E3.u(new ViewPropertyAnimatorListenerAdapter() {
                    public void b(View view) {
                        AppCompatDelegateImpl.this.B3.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.C3;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.B3.getParent() instanceof View) {
                            ViewCompat.B1((View) AppCompatDelegateImpl.this.B3.getParent());
                        }
                        AppCompatDelegateImpl.this.B3.t();
                        AppCompatDelegateImpl.this.E3.u((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.E3 = null;
                        ViewCompat.B1(appCompatDelegateImpl2.H3);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.t3;
            if (appCompatCallback != null) {
                appCompatCallback.j(appCompatDelegateImpl4.A3);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.A3 = null;
            ViewCompat.B1(appCompatDelegateImpl5.H3);
            AppCompatDelegateImpl.this.x1();
        }

        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f2762a.b(actionMode, menu);
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            ViewCompat.B1(AppCompatDelegateImpl.this.H3);
            return this.f2762a.c(actionMode, menu);
        }

        public boolean d(ActionMode actionMode, MenuItem menuItem) {
            return this.f2762a.d(actionMode, menuItem);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList a2 = configuration.getLocales();
            LocaleList a3 = configuration2.getLocales();
            if (!a2.equals(a3)) {
                configuration3.setLocales(a3);
                configuration3.locale = configuration2.locale;
            }
        }

        @DoNotInline
        static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.m()));
        }

        @DoNotInline
        static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.m()));
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 3);
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 12);
            }
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

        @DoNotInline
        static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            q qVar = new q(appCompatDelegateImpl);
            m.a(obj).registerOnBackInvokedCallback(1000000, qVar);
            return qVar;
        }

        @DoNotInline
        static void c(Object obj, Object obj2) {
            m.a(obj).unregisterOnBackInvokedCallback(l.a(obj2));
        }
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback X;
        private boolean X2;
        private boolean Y;
        private boolean Z;

        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.Z = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.Z = false;
                return dispatchKeyEvent;
            } catch (Throwable th) {
                this.Z = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback) {
            try {
                this.Y = true;
                callback.onContentChanged();
                this.Y = false;
            } catch (Throwable th) {
                this.Y = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void d(Window.Callback callback, int i2, Menu menu) {
            try {
                this.X2 = true;
                callback.onPanelClosed(i2, menu);
                this.X2 = false;
            } catch (Throwable th) {
                this.X2 = false;
                throw th;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.Z ? a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.B0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.b1(keyEvent.getKeyCode(), keyEvent);
        }

        /* access modifiers changed from: package-private */
        public void e(@Nullable ActionBarMenuCallback actionBarMenuCallback) {
            this.X = actionBarMenuCallback;
        }

        /* access modifiers changed from: package-private */
        public final android.view.ActionMode f(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.q3, callback);
            androidx.appcompat.view.ActionMode k0 = AppCompatDelegateImpl.this.k0(callbackWrapper);
            if (k0 != null) {
                return callbackWrapper.e(k0);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.Y) {
                a().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r0.onCreatePanelView(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View onCreatePanelView(int r2) {
            /*
                r1 = this;
                androidx.appcompat.app.AppCompatDelegateImpl$ActionBarMenuCallback r0 = r1.X
                if (r0 == 0) goto L_0x000b
                android.view.View r0 = r0.onCreatePanelView(r2)
                if (r0 == 0) goto L_0x000b
                return r0
            L_0x000b:
                android.view.View r2 = super.onCreatePanelView(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback.onCreatePanelView(int):android.view.View");
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl.this.e1(i2);
            return true;
        }

        public void onPanelClosed(int i2, Menu menu) {
            if (this.X2) {
                a().onPanelClosed(i2, menu);
                return;
            }
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.f1(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i2 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z = true;
            if (menuBuilder != null) {
                menuBuilder.j0(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.X;
            if (actionBarMenuCallback == null || !actionBarMenuCallback.a(i2)) {
                z = false;
            }
            if (!z) {
                z = super.onPreparePanel(i2, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.j0(false);
            }
            return z;
        }

        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            MenuBuilder menuBuilder;
            PanelFeatureState O0 = AppCompatDelegateImpl.this.O0(0, true);
            if (O0 == null || (menuBuilder = O0.f2781j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i2);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.I() ? f(callback) : super.onWindowStartingActionMode(callback);
        }

        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            return (!AppCompatDelegateImpl.this.I() || i2 != 0) ? super.onWindowStartingActionMode(callback, i2) : f(callback);
        }
    }

    private class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f2765c;

        AutoBatteryNightModeManager(@NonNull Context context) {
            super();
            this.f2765c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return Api21Impl.a(this.f2765c) ? 2 : 1;
        }

        public void e() {
            AppCompatDelegateImpl.this.h();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    abstract class AutoNightModeManager {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f2767a;

        AutoNightModeManager() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f2767a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.q3.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f2767a = null;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f2767a != null;
        }

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public void f() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f2767a == null) {
                    this.f2767a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.e();
                        }
                    };
                }
                AppCompatDelegateImpl.this.q3.registerReceiver(this.f2767a, b2);
            }
        }
    }

    private class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final TwilightManager f2770c;

        AutoTimeNightModeManager(@NonNull TwilightManager twilightManager) {
            super();
            this.f2770c = twilightManager;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f2770c.d() ? 2 : 1;
        }

        public void e() {
            AppCompatDelegateImpl.this.h();
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean c(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.B0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.w0(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AppCompatResources.b(getContext(), i2));
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f2772a;

        /* renamed from: b  reason: collision with root package name */
        int f2773b;

        /* renamed from: c  reason: collision with root package name */
        int f2774c;

        /* renamed from: d  reason: collision with root package name */
        int f2775d;

        /* renamed from: e  reason: collision with root package name */
        int f2776e;

        /* renamed from: f  reason: collision with root package name */
        int f2777f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f2778g;

        /* renamed from: h  reason: collision with root package name */
        View f2779h;

        /* renamed from: i  reason: collision with root package name */
        View f2780i;

        /* renamed from: j  reason: collision with root package name */
        MenuBuilder f2781j;

        /* renamed from: k  reason: collision with root package name */
        ListMenuPresenter f2782k;

        /* renamed from: l  reason: collision with root package name */
        Context f2783l;

        /* renamed from: m  reason: collision with root package name */
        boolean f2784m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2785n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        boolean s;
        Bundle t;
        Bundle u;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            };
            boolean X;
            Bundle Y;
            int s;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.s = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.X = z;
                if (z) {
                    savedState.Y = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.s);
                parcel.writeInt(this.X ? 1 : 0);
                if (this.X) {
                    parcel.writeBundle(this.Y);
                }
            }
        }

        PanelFeatureState(int i2) {
            this.f2772a = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Bundle bundle;
            MenuBuilder menuBuilder = this.f2781j;
            if (menuBuilder != null && (bundle = this.t) != null) {
                menuBuilder.V(bundle);
                this.t = null;
            }
        }

        public void b() {
            MenuBuilder menuBuilder = this.f2781j;
            if (menuBuilder != null) {
                menuBuilder.T(this.f2782k);
            }
            this.f2782k = null;
        }

        /* access modifiers changed from: package-private */
        public MenuView c(MenuPresenter.Callback callback) {
            if (this.f2781j == null) {
                return null;
            }
            if (this.f2782k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f2783l, R.layout.q);
                this.f2782k = listMenuPresenter;
                listMenuPresenter.h(callback);
                this.f2781j.b(this.f2782k);
            }
            return this.f2782k.m(this.f2778g);
        }

        public boolean d() {
            if (this.f2779h == null) {
                return false;
            }
            return this.f2780i != null || this.f2782k.a().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public void e(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.f2772a = savedState.s;
            this.s = savedState.X;
            this.t = savedState.Y;
            this.f2779h = null;
            this.f2778g = null;
        }

        /* access modifiers changed from: package-private */
        public Parcelable f() {
            SavedState savedState = new SavedState();
            savedState.s = this.f2772a;
            savedState.X = this.o;
            if (this.f2781j != null) {
                Bundle bundle = new Bundle();
                savedState.Y = bundle;
                this.f2781j.X(bundle);
            }
            return savedState;
        }

        /* access modifiers changed from: package-private */
        public void g(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f2781j;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.T(this.f2782k);
                }
                this.f2781j = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.f2782k) != null) {
                    menuBuilder.b(listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.f2553c, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R.attr.x2, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 == 0) {
                i3 = R.style.P3;
            }
            newTheme.applyStyle(i3, true);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f2783l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.S0);
            this.f2773b = obtainStyledAttributes.getResourceId(R.styleable.B2, 0);
            this.f2777f = obtainStyledAttributes.getResourceId(R.styleable.U0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
            MenuBuilder G = menuBuilder.G();
            boolean z2 = G != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = G;
            }
            PanelFeatureState G0 = appCompatDelegateImpl.G0(menuBuilder);
            if (G0 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.t0(G0.f2772a, G0, G);
                AppCompatDelegateImpl.this.x0(G0, true);
                return;
            }
            AppCompatDelegateImpl.this.x0(G0, z);
        }

        public boolean d(@NonNull MenuBuilder menuBuilder) {
            Window.Callback R0;
            if (menuBuilder != menuBuilder.G()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.M3 || (R0 = appCompatDelegateImpl.R0()) == null || AppCompatDelegateImpl.this.X3) {
                return true;
            }
            R0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    private void A1(View view) {
        Context context;
        int i2;
        if ((ViewCompat.F0(view) & 8192) != 0) {
            context = this.q3;
            i2 = R.color.f2573g;
        } else {
            context = this.q3;
            i2 = R.color.f2572f;
        }
        view.setBackgroundColor(ContextCompat.g(context, i2));
    }

    private void E0() {
        if (!this.G3) {
            this.H3 = z0();
            CharSequence Q0 = Q0();
            if (!TextUtils.isEmpty(Q0)) {
                DecorContentParent decorContentParent = this.x3;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(Q0);
                } else if (i1() != null) {
                    i1().B0(Q0);
                } else {
                    TextView textView = this.I3;
                    if (textView != null) {
                        textView.setText(Q0);
                    }
                }
            }
            p0();
            g1(this.H3);
            this.G3 = true;
            PanelFeatureState O0 = O0(0, false);
            if (this.X3) {
                return;
            }
            if (O0 == null || O0.f2781j == null) {
                W0(108);
            }
        }
    }

    private void F0() {
        if (this.r3 == null) {
            Object obj = this.p3;
            if (obj instanceof Activity) {
                q0(((Activity) obj).getWindow());
            }
        }
        if (this.r3 == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    private static Configuration H0(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i5 = configuration.mnc;
            int i6 = configuration2.mnc;
            if (i5 != i6) {
                configuration3.mnc = i6;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 24) {
                Api24Impl.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i8 = configuration.touchscreen;
            int i9 = configuration2.touchscreen;
            if (i8 != i9) {
                configuration3.touchscreen = i9;
            }
            int i10 = configuration.keyboard;
            int i11 = configuration2.keyboard;
            if (i10 != i11) {
                configuration3.keyboard = i11;
            }
            int i12 = configuration.keyboardHidden;
            int i13 = configuration2.keyboardHidden;
            if (i12 != i13) {
                configuration3.keyboardHidden = i13;
            }
            int i14 = configuration.navigation;
            int i15 = configuration2.navigation;
            if (i14 != i15) {
                configuration3.navigation = i15;
            }
            int i16 = configuration.navigationHidden;
            int i17 = configuration2.navigationHidden;
            if (i16 != i17) {
                configuration3.navigationHidden = i17;
            }
            int i18 = configuration.orientation;
            int i19 = configuration2.orientation;
            if (i18 != i19) {
                configuration3.orientation = i19;
            }
            int i20 = configuration.screenLayout & 15;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 15)) {
                configuration3.screenLayout |= i21 & 15;
            }
            int i22 = configuration.screenLayout & PsExtractor.x;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & PsExtractor.x)) {
                configuration3.screenLayout |= i23 & PsExtractor.x;
            }
            int i24 = configuration.screenLayout & 48;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 48)) {
                configuration3.screenLayout |= i25 & 48;
            }
            int i26 = configuration.screenLayout & ViewUtils.f21582a;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & ViewUtils.f21582a)) {
                configuration3.screenLayout |= i27 & ViewUtils.f21582a;
            }
            if (i7 >= 26) {
                Api26Impl.a(configuration, configuration2, configuration3);
            }
            int i28 = configuration.uiMode & 15;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 15)) {
                configuration3.uiMode |= i29 & 15;
            }
            int i30 = configuration.uiMode & 48;
            int i31 = configuration2.uiMode;
            if (i30 != (i31 & 48)) {
                configuration3.uiMode |= i31 & 48;
            }
            int i32 = configuration.screenWidthDp;
            int i33 = configuration2.screenWidthDp;
            if (i32 != i33) {
                configuration3.screenWidthDp = i33;
            }
            int i34 = configuration.screenHeightDp;
            int i35 = configuration2.screenHeightDp;
            if (i34 != i35) {
                configuration3.screenHeightDp = i35;
            }
            int i36 = configuration.smallestScreenWidthDp;
            int i37 = configuration2.smallestScreenWidthDp;
            if (i36 != i37) {
                configuration3.smallestScreenWidthDp = i37;
            }
            int i38 = configuration.densityDpi;
            int i39 = configuration2.densityDpi;
            if (i38 != i39) {
                configuration3.densityDpi = i39;
            }
        }
        return configuration3;
    }

    private int J0(Context context) {
        if (!this.c4 && (this.p3 instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.p3.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.b4 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.b4 = 0;
            }
        }
        this.c4 = true;
        return this.b4;
    }

    private AutoNightModeManager K0(@NonNull Context context) {
        if (this.e4 == null) {
            this.e4 = new AutoBatteryNightModeManager(context);
        }
        return this.e4;
    }

    private AutoNightModeManager M0(@NonNull Context context) {
        if (this.d4 == null) {
            this.d4 = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.d4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S0() {
        /*
            r3 = this;
            r3.E0()
            boolean r0 = r3.M3
            if (r0 == 0) goto L_0x0037
            androidx.appcompat.app.ActionBar r0 = r3.u3
            if (r0 == 0) goto L_0x000c
            goto L_0x0037
        L_0x000c:
            java.lang.Object r0 = r3.p3
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0020
            androidx.appcompat.app.WindowDecorActionBar r0 = new androidx.appcompat.app.WindowDecorActionBar
            java.lang.Object r1 = r3.p3
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.N3
            r0.<init>(r1, r2)
        L_0x001d:
            r3.u3 = r0
            goto L_0x002e
        L_0x0020:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L_0x002e
            androidx.appcompat.app.WindowDecorActionBar r0 = new androidx.appcompat.app.WindowDecorActionBar
            java.lang.Object r1 = r3.p3
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>((android.app.Dialog) r1)
            goto L_0x001d
        L_0x002e:
            androidx.appcompat.app.ActionBar r0 = r3.u3
            if (r0 == 0) goto L_0x0037
            boolean r1 = r3.i4
            r0.X(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.S0():void");
    }

    private boolean T0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f2780i;
        if (view != null) {
            panelFeatureState.f2779h = view;
            return true;
        } else if (panelFeatureState.f2781j == null) {
            return false;
        } else {
            if (this.z3 == null) {
                this.z3 = new PanelMenuPresenterCallback();
            }
            View view2 = (View) panelFeatureState.c(this.z3);
            panelFeatureState.f2779h = view2;
            return view2 != null;
        }
    }

    private boolean U0(PanelFeatureState panelFeatureState) {
        panelFeatureState.h(I0());
        panelFeatureState.f2778g = new ListMenuDecorView(panelFeatureState.f2783l);
        panelFeatureState.f2774c = 81;
        return true;
    }

    private boolean V0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.q3;
        int i2 = panelFeatureState.f2772a;
        if ((i2 == 0 || i2 == 108) && this.x3 != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R.attr.f2560j, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R.attr.f2561k, typedValue, true);
            } else {
                theme2.resolveAttribute(R.attr.f2561k, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.Y(this);
        panelFeatureState.g(menuBuilder);
        return true;
    }

    private void W0(int i2) {
        this.g4 = (1 << i2) | this.g4;
        if (!this.f4) {
            ViewCompat.v1(this.r3.getDecorView(), this.h4);
            this.f4 = true;
        }
    }

    private boolean a1(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState O0 = O0(i2, true);
        if (!O0.o) {
            return k1(O0, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d1(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.A3
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.O0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.x3
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.h()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.q3
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.x3
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.X3
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.k1(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.x3
            boolean r0 = r5.l()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.x3
            boolean r0 = r5.k()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f2785n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f2784m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.r
            if (r5 == 0) goto L_0x005b
            r2.f2784m = r1
            boolean r5 = r4.k1(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = 1
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.h1(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = 0
            goto L_0x0068
        L_0x0064:
            r4.x0(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.q3
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.d1(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h1(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r12.o
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r11.X3
            if (r0 == 0) goto L_0x000a
            goto L_0x00f3
        L_0x000a:
            int r0 = r12.f2772a
            if (r0 != 0) goto L_0x0020
            android.content.Context r0 = r11.q3
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r1 = 4
            if (r0 != r1) goto L_0x0020
            return
        L_0x0020:
            android.view.Window$Callback r0 = r11.R0()
            r1 = 1
            if (r0 == 0) goto L_0x0035
            int r2 = r12.f2772a
            androidx.appcompat.view.menu.MenuBuilder r3 = r12.f2781j
            boolean r0 = r0.onMenuOpened(r2, r3)
            if (r0 != 0) goto L_0x0035
            r11.x0(r12, r1)
            return
        L_0x0035:
            android.content.Context r0 = r11.q3
            java.lang.String r2 = "window"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0042
            return
        L_0x0042:
            boolean r13 = r11.k1(r12, r13)
            if (r13 != 0) goto L_0x0049
            return
        L_0x0049:
            android.view.ViewGroup r13 = r12.f2778g
            r2 = -2
            if (r13 == 0) goto L_0x0064
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x0053
            goto L_0x0064
        L_0x0053:
            android.view.View r13 = r12.f2780i
            if (r13 == 0) goto L_0x00c6
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 == 0) goto L_0x00c6
            int r13 = r13.width
            r3 = -1
            if (r13 != r3) goto L_0x00c6
            r4 = -1
            goto L_0x00c7
        L_0x0064:
            if (r13 != 0) goto L_0x0071
            boolean r13 = r11.U0(r12)
            if (r13 == 0) goto L_0x0070
            android.view.ViewGroup r13 = r12.f2778g
            if (r13 != 0) goto L_0x0080
        L_0x0070:
            return
        L_0x0071:
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x0080
            int r13 = r13.getChildCount()
            if (r13 <= 0) goto L_0x0080
            android.view.ViewGroup r13 = r12.f2778g
            r13.removeAllViews()
        L_0x0080:
            boolean r13 = r11.T0(r12)
            if (r13 == 0) goto L_0x00f1
            boolean r13 = r12.d()
            if (r13 != 0) goto L_0x008d
            goto L_0x00f1
        L_0x008d:
            android.view.View r13 = r12.f2779h
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 != 0) goto L_0x009a
            android.view.ViewGroup$LayoutParams r13 = new android.view.ViewGroup$LayoutParams
            r13.<init>(r2, r2)
        L_0x009a:
            int r3 = r12.f2773b
            android.view.ViewGroup r4 = r12.f2778g
            r4.setBackgroundResource(r3)
            android.view.View r3 = r12.f2779h
            android.view.ViewParent r3 = r3.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00b2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r4 = r12.f2779h
            r3.removeView(r4)
        L_0x00b2:
            android.view.ViewGroup r3 = r12.f2778g
            android.view.View r4 = r12.f2779h
            r3.addView(r4, r13)
            android.view.View r13 = r12.f2779h
            boolean r13 = r13.hasFocus()
            if (r13 != 0) goto L_0x00c6
            android.view.View r13 = r12.f2779h
            r13.requestFocus()
        L_0x00c6:
            r4 = -2
        L_0x00c7:
            r13 = 0
            r12.f2785n = r13
            android.view.WindowManager$LayoutParams r13 = new android.view.WindowManager$LayoutParams
            int r6 = r12.f2775d
            int r7 = r12.f2776e
            r9 = 8519680(0x820000, float:1.1938615E-38)
            r10 = -3
            r5 = -2
            r8 = 1002(0x3ea, float:1.404E-42)
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            int r2 = r12.f2774c
            r13.gravity = r2
            int r2 = r12.f2777f
            r13.windowAnimations = r2
            android.view.ViewGroup r2 = r12.f2778g
            r0.addView(r2, r13)
            r12.o = r1
            int r12 = r12.f2772a
            if (r12 != 0) goto L_0x00f0
            r11.x1()
        L_0x00f0:
            return
        L_0x00f1:
            r12.q = r1
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.h1(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean j1(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f2784m || k1(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f2781j) != null) {
            z = menuBuilder.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.x3 == null) {
            x0(panelFeatureState, true);
        }
        return z;
    }

    private boolean k1(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.X3) {
            return false;
        }
        if (panelFeatureState.f2784m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.T3;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            x0(panelFeatureState2, false);
        }
        Window.Callback R0 = R0();
        if (R0 != null) {
            panelFeatureState.f2780i = R0.onCreatePanelView(panelFeatureState.f2772a);
        }
        int i2 = panelFeatureState.f2772a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (decorContentParent3 = this.x3) != null) {
            decorContentParent3.e();
        }
        if (panelFeatureState.f2780i == null && (!z || !(i1() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f2781j;
            if (menuBuilder == null || panelFeatureState.r) {
                if (menuBuilder == null && (!V0(panelFeatureState) || panelFeatureState.f2781j == null)) {
                    return false;
                }
                if (z && this.x3 != null) {
                    if (this.y3 == null) {
                        this.y3 = new ActionMenuPresenterCallback();
                    }
                    this.x3.a(panelFeatureState.f2781j, this.y3);
                }
                panelFeatureState.f2781j.n0();
                if (!R0.onCreatePanelMenu(panelFeatureState.f2772a, panelFeatureState.f2781j)) {
                    panelFeatureState.g((MenuBuilder) null);
                    if (z && (decorContentParent2 = this.x3) != null) {
                        decorContentParent2.a((Menu) null, this.y3);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.f2781j.n0();
            Bundle bundle = panelFeatureState.u;
            if (bundle != null) {
                panelFeatureState.f2781j.U(bundle);
                panelFeatureState.u = null;
            }
            if (!R0.onPreparePanel(0, panelFeatureState.f2780i, panelFeatureState.f2781j)) {
                if (z && (decorContentParent = this.x3) != null) {
                    decorContentParent.a((Menu) null, this.y3);
                }
                panelFeatureState.f2781j.m0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.p = z2;
            panelFeatureState.f2781j.setQwertyMode(z2);
            panelFeatureState.f2781j.m0();
        }
        panelFeatureState.f2784m = true;
        panelFeatureState.f2785n = false;
        this.T3 = panelFeatureState;
        return true;
    }

    private void l1(boolean z) {
        DecorContentParent decorContentParent = this.x3;
        if (decorContentParent == null || !decorContentParent.h() || (ViewConfiguration.get(this.q3).hasPermanentMenuKey() && !this.x3.j())) {
            PanelFeatureState O0 = O0(0, true);
            O0.q = true;
            x0(O0, false);
            h1(O0, (KeyEvent) null);
            return;
        }
        Window.Callback R0 = R0();
        if (this.x3.d() && z) {
            this.x3.k();
            if (!this.X3) {
                R0.onPanelClosed(108, O0(0, true).f2781j);
            }
        } else if (R0 != null && !this.X3) {
            if (this.f4 && (this.g4 & 1) != 0) {
                this.r3.getDecorView().removeCallbacks(this.h4);
                this.h4.run();
            }
            PanelFeatureState O02 = O0(0, true);
            MenuBuilder menuBuilder = O02.f2781j;
            if (menuBuilder != null && !O02.r && R0.onPreparePanel(0, O02.f2780i, menuBuilder)) {
                R0.onMenuOpened(108, O02.f2781j);
                this.x3.l();
            }
        }
    }

    private int m1(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean n0(boolean z) {
        return o0(z, true);
    }

    private boolean o0(boolean z, boolean z2) {
        if (this.X3) {
            return false;
        }
        int s0 = s0();
        int X0 = X0(this.q3, s0);
        LocaleListCompat r0 = Build.VERSION.SDK_INT < 33 ? r0(this.q3) : null;
        if (!z2 && r0 != null) {
            r0 = N0(this.q3.getResources().getConfiguration());
        }
        boolean w1 = w1(X0, r0, z);
        if (s0 == 0) {
            M0(this.q3).f();
        } else {
            AutoNightModeManager autoNightModeManager = this.d4;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (s0 == 3) {
            K0(this.q3).f();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.e4;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return w1;
    }

    private void p0() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.H3.findViewById(16908290);
        View decorView = this.r3.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.q3.obtainStyledAttributes(R.styleable.S0);
        obtainStyledAttributes.getValue(R.styleable.n3, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.o3, contentFrameLayout.getMinWidthMinor());
        int i2 = R.styleable.l3;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = R.styleable.m3;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i5 = R.styleable.j3;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMajor());
        }
        int i6 = R.styleable.k3;
        if (obtainStyledAttributes.hasValue(i6)) {
            obtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void q0(@NonNull Window window) {
        if (this.r3 == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.s3 = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray F = TintTypedArray.F(this.q3, (AttributeSet) null, r4);
                Drawable i2 = F.i(0);
                if (i2 != null) {
                    window.setBackgroundDrawable(i2);
                }
                F.I();
                this.r3 = window;
                if (Build.VERSION.SDK_INT >= 33 && this.n4 == null) {
                    g0((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean q1(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.r3.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int s0() {
        int i2 = this.Z3;
        return i2 != -100 ? i2 : AppCompatDelegate.v();
    }

    private void t1() {
        if (this.G3) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Nullable
    private AppCompatActivity u1() {
        Context context = this.q3;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void v0() {
        AutoNightModeManager autoNightModeManager = this.d4;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.e4;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    private void v1(Configuration configuration) {
        Activity activity = (Activity) this.p3;
        if (activity instanceof LifecycleOwner) {
            if (!((LifecycleOwner) activity).a().b().b(Lifecycle.State.CREATED)) {
                return;
            }
        } else if (!this.W3 || this.X3) {
            return;
        }
        activity.onConfigurationChanged(configuration);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean w1(int r10, @androidx.annotation.Nullable androidx.core.os.LocaleListCompat r11, boolean r12) {
        /*
            r9 = this;
            android.content.Context r1 = r9.q3
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r0 = r0.y0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r9.q3
            int r1 = r9.J0(r1)
            android.content.res.Configuration r2 = r9.Y3
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r9.q3
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r9.N0(r2)
            r5 = 0
            if (r11 != 0) goto L_0x0030
            r6 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r6 = r9.N0(r0)
        L_0x0034:
            r7 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            if (r6 == 0) goto L_0x0045
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0045
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L_0x0045:
            int r2 = ~r1
            r2 = r2 & r3
            r8 = 1
            if (r2 == 0) goto L_0x008c
            if (r12 == 0) goto L_0x008c
            boolean r12 = r9.V3
            if (r12 == 0) goto L_0x008c
            boolean r12 = s4
            if (r12 != 0) goto L_0x0058
            boolean r12 = r9.W3
            if (r12 == 0) goto L_0x008c
        L_0x0058:
            java.lang.Object r12 = r9.p3
            boolean r2 = r12 instanceof android.app.Activity
            if (r2 == 0) goto L_0x008c
            android.app.Activity r12 = (android.app.Activity) r12
            boolean r12 = r12.isChild()
            if (r12 != 0) goto L_0x008c
            int r12 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r12 < r2) goto L_0x0083
            r12 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x0083
            java.lang.Object r12 = r9.p3
            android.app.Activity r12 = (android.app.Activity) r12
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            int r0 = r0.getLayoutDirection()
            r12.setLayoutDirection(r0)
        L_0x0083:
            java.lang.Object r12 = r9.p3
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.core.app.ActivityCompat.L(r12)
            r12 = 1
            goto L_0x008d
        L_0x008c:
            r12 = 0
        L_0x008d:
            if (r12 != 0) goto L_0x009a
            if (r3 == 0) goto L_0x009a
            r12 = r3 & r1
            if (r12 != r3) goto L_0x0096
            r7 = 1
        L_0x0096:
            r9.y1(r4, r6, r7, r5)
            goto L_0x009b
        L_0x009a:
            r8 = r12
        L_0x009b:
            if (r8 == 0) goto L_0x00b7
            java.lang.Object r12 = r9.p3
            boolean r0 = r12 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L_0x00b7
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x00ac
            androidx.appcompat.app.AppCompatActivity r12 = (androidx.appcompat.app.AppCompatActivity) r12
            r12.K0(r10)
        L_0x00ac:
            r10 = r3 & 4
            if (r10 == 0) goto L_0x00b7
            java.lang.Object r10 = r9.p3
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10
            r10.J0(r11)
        L_0x00b7:
            if (r6 == 0) goto L_0x00ca
            android.content.Context r10 = r9.q3
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            androidx.core.os.LocaleListCompat r10 = r9.N0(r10)
            r9.o1(r10)
        L_0x00ca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.w1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    @NonNull
    private Configuration y0(@NonNull Context context, int i2, @Nullable LocaleListCompat localeListCompat, @Nullable Configuration configuration, boolean z) {
        int i3 = i2 != 1 ? i2 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            n1(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private void y1(int i2, @Nullable LocaleListCompat localeListCompat, boolean z, @Nullable Configuration configuration) {
        Resources resources = this.q3.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            n1(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            ResourcesFlusher.a(resources);
        }
        int i5 = this.a4;
        if (i5 != 0) {
            this.q3.setTheme(i5);
            if (i3 >= 23) {
                this.q3.getTheme().applyStyle(this.a4, true);
            }
        }
        if (z && (this.p3 instanceof Activity)) {
            v1(configuration2);
        }
    }

    private ViewGroup z0() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.q3.obtainStyledAttributes(R.styleable.S0);
        int i2 = R.styleable.g3;
        if (obtainStyledAttributes.hasValue(i2)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.p3, false)) {
                V(1);
            } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                V(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.h3, false)) {
                V(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.i3, false)) {
                V(10);
            }
            this.P3 = obtainStyledAttributes.getBoolean(R.styleable.T0, false);
            obtainStyledAttributes.recycle();
            F0();
            this.r3.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.q3);
            if (this.Q3) {
                viewGroup = (ViewGroup) from.inflate(this.O3 ? R.layout.w : R.layout.v, (ViewGroup) null);
            } else if (this.P3) {
                viewGroup = (ViewGroup) from.inflate(R.layout.f2646m, (ViewGroup) null);
                this.N3 = false;
                this.M3 = false;
            } else if (this.M3) {
                TypedValue typedValue = new TypedValue();
                this.q3.getTheme().resolveAttribute(R.attr.f2560j, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.q3, typedValue.resourceId) : this.q3).inflate(R.layout.x, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.x);
                this.x3 = decorContentParent;
                decorContentParent.setWindowCallback(R0());
                if (this.N3) {
                    this.x3.n(109);
                }
                if (this.K3) {
                    this.x3.n(2);
                }
                if (this.L3) {
                    this.x3.n(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ViewCompat.k2(viewGroup, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        int r = windowInsetsCompat.r();
                        int z1 = AppCompatDelegateImpl.this.z1(windowInsetsCompat, (Rect) null);
                        if (r != z1) {
                            windowInsetsCompat = windowInsetsCompat.D(windowInsetsCompat.p(), z1, windowInsetsCompat.q(), windowInsetsCompat.o());
                        }
                        return ViewCompat.k1(view, windowInsetsCompat);
                    }
                });
                if (this.x3 == null) {
                    this.I3 = (TextView) viewGroup.findViewById(R.id.s0);
                }
                androidx.appcompat.widget.ViewUtils.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.f2610b);
                ViewGroup viewGroup2 = (ViewGroup) this.r3.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.r3.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                    public void a() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.A0();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.M3 + ", windowActionBarOverlay: " + this.N3 + ", android:windowIsFloating: " + this.P3 + ", windowActionModeOverlay: " + this.O3 + ", windowNoTitle: " + this.Q3 + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* access modifiers changed from: package-private */
    public void A0() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.x3;
        if (decorContentParent != null) {
            decorContentParent.o();
        }
        if (this.C3 != null) {
            this.r3.getDecorView().removeCallbacks(this.D3);
            if (this.C3.isShowing()) {
                try {
                    this.C3.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.C3 = null;
        }
        D0();
        PanelFeatureState O0 = O0(0, false);
        if (O0 != null && (menuBuilder = O0.f2781j) != null) {
            menuBuilder.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean B0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.p3;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.r3.getDecorView()) != null && KeyEventDispatcher.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.s3.b(this.r3.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? Z0(keyCode, keyEvent) : c1(keyCode, keyEvent);
    }

    public ActionBar C() {
        S0();
        return this.u3;
    }

    /* access modifiers changed from: package-private */
    public void C0(int i2) {
        PanelFeatureState O0;
        PanelFeatureState O02 = O0(i2, true);
        if (O02.f2781j != null) {
            Bundle bundle = new Bundle();
            O02.f2781j.W(bundle);
            if (bundle.size() > 0) {
                O02.u = bundle;
            }
            O02.f2781j.n0();
            O02.f2781j.clear();
        }
        O02.r = true;
        O02.q = true;
        if ((i2 == 108 || i2 == 0) && this.x3 != null && (O0 = O0(0, false)) != null) {
            O0.f2784m = false;
            k1(O0, (KeyEvent) null);
        }
    }

    public boolean D(int i2) {
        int m1 = m1(i2);
        return (m1 != 1 ? m1 != 2 ? m1 != 5 ? m1 != 10 ? m1 != 108 ? m1 != 109 ? false : this.N3 : this.M3 : this.O3 : this.L3 : this.K3 : this.Q3) || this.r3.hasFeature(i2);
    }

    /* access modifiers changed from: package-private */
    public void D0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.E3;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.d();
        }
    }

    public void E() {
        LayoutInflater from = LayoutInflater.from(this.q3);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.d(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void F() {
        if (i1() != null && !C().D()) {
            W0(0);
        }
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState G0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.S3;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.f2781j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public boolean I() {
        return this.F3;
    }

    /* access modifiers changed from: package-private */
    public final Context I0() {
        ActionBar C = C();
        Context A = C != null ? C.A() : null;
        return A == null ? this.q3 : A;
    }

    public void L(Configuration configuration) {
        ActionBar C;
        if (this.M3 && this.G3 && (C = C()) != null) {
            C.I(configuration);
        }
        AppCompatDrawableManager.b().g(this.q3);
        this.Y3 = new Configuration(this.q3.getResources().getConfiguration());
        o0(false, false);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AutoNightModeManager L0() {
        return M0(this.q3);
    }

    public void M(Bundle bundle) {
        String str;
        this.V3 = true;
        n0(false);
        F0();
        Object obj = this.p3;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.d((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar i1 = i1();
                if (i1 == null) {
                    this.i4 = true;
                } else {
                    i1.X(true);
                }
            }
            AppCompatDelegate.e(this);
        }
        this.Y3 = new Configuration(this.q3.getResources().getConfiguration());
        this.W3 = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.p3
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.T(r3)
        L_0x0009:
            boolean r0 = r3.f4
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.r3
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.h4
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.X3 = r0
            int r0 = r3.Z3
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.p3
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = p4
            java.lang.Object r1 = r3.p3
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.Z3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = p4
            java.lang.Object r1 = r3.p3
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.u3
            if (r0 == 0) goto L_0x005b
            r0.J()
        L_0x005b:
            r3.v0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.N():void");
    }

    /* access modifiers changed from: package-private */
    public LocaleListCompat N0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.b(configuration) : LocaleListCompat.c(Api21Impl.b(configuration.locale));
    }

    public void O(Bundle bundle) {
        E0();
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState O0(int i2, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.S3;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.S3 = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public void P() {
        ActionBar C = C();
        if (C != null) {
            C.u0(true);
        }
    }

    /* access modifiers changed from: package-private */
    public ViewGroup P0() {
        return this.H3;
    }

    public void Q(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public final CharSequence Q0() {
        Object obj = this.p3;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.w3;
    }

    public void R() {
        o0(true, false);
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback R0() {
        return this.r3.getCallback();
    }

    public void S() {
        ActionBar C = C();
        if (C != null) {
            C.u0(false);
        }
    }

    public boolean V(int i2) {
        int m1 = m1(i2);
        if (this.Q3 && m1 == 108) {
            return false;
        }
        if (this.M3 && m1 == 1) {
            this.M3 = false;
        }
        if (m1 == 1) {
            t1();
            this.Q3 = true;
            return true;
        } else if (m1 == 2) {
            t1();
            this.K3 = true;
            return true;
        } else if (m1 == 5) {
            t1();
            this.L3 = true;
            return true;
        } else if (m1 == 10) {
            t1();
            this.O3 = true;
            return true;
        } else if (m1 == 108) {
            t1();
            this.M3 = true;
            return true;
        } else if (m1 != 109) {
            return this.r3.requestFeature(m1);
        } else {
            t1();
            this.N3 = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public int X0(@NonNull Context context, int i2) {
        AutoNightModeManager M0;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        M0 = K0(context);
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                M0 = M0(context);
            }
            return M0.c();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean Y0() {
        boolean z = this.U3;
        this.U3 = false;
        PanelFeatureState O0 = O0(0, false);
        if (O0 == null || !O0.o) {
            androidx.appcompat.view.ActionMode actionMode = this.A3;
            if (actionMode != null) {
                actionMode.c();
                return true;
            }
            ActionBar C = C();
            return C != null && C.m();
        }
        if (!z) {
            x0(O0, true);
        }
        return true;
    }

    public void Z(int i2) {
        E0();
        ViewGroup viewGroup = (ViewGroup) this.H3.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.q3).inflate(i2, viewGroup);
        this.s3.c(this.r3.getCallback());
    }

    /* access modifiers changed from: package-private */
    public boolean Z0(int i2, KeyEvent keyEvent) {
        boolean z = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.U3 = z;
        } else if (i2 == 82) {
            a1(0, keyEvent);
            return true;
        }
        return false;
    }

    public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        PanelFeatureState G0;
        Window.Callback R0 = R0();
        if (R0 == null || this.X3 || (G0 = G0(menuBuilder.G())) == null) {
            return false;
        }
        return R0.onMenuItemSelected(G0.f2772a, menuItem);
    }

    public void a0(View view) {
        E0();
        ViewGroup viewGroup = (ViewGroup) this.H3.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.s3.c(this.r3.getCallback());
    }

    public void b(@NonNull MenuBuilder menuBuilder) {
        l1(true);
    }

    public void b0(View view, ViewGroup.LayoutParams layoutParams) {
        E0();
        ViewGroup viewGroup = (ViewGroup) this.H3.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.s3.c(this.r3.getCallback());
    }

    /* access modifiers changed from: package-private */
    public boolean b1(int i2, KeyEvent keyEvent) {
        ActionBar C = C();
        if (C != null && C.K(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.T3;
        if (panelFeatureState == null || !j1(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.T3 == null) {
                PanelFeatureState O0 = O0(0, true);
                k1(O0, keyEvent);
                boolean j1 = j1(O0, keyEvent.getKeyCode(), keyEvent, 1);
                O0.f2784m = false;
                if (j1) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.T3;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f2785n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean c1(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                d1(0, keyEvent);
                return true;
            }
        } else if (Y0()) {
            return true;
        }
        return false;
    }

    public void d0(boolean z) {
        this.F3 = z;
    }

    /* access modifiers changed from: package-private */
    public void e1(int i2) {
        ActionBar C;
        if (i2 == 108 && (C = C()) != null) {
            C.n(true);
        }
    }

    public void f(View view, ViewGroup.LayoutParams layoutParams) {
        E0();
        ((ViewGroup) this.H3.findViewById(16908290)).addView(view, layoutParams);
        this.s3.c(this.r3.getCallback());
    }

    public void f0(int i2) {
        if (this.Z3 != i2) {
            this.Z3 = i2;
            if (this.V3) {
                h();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f1(int i2) {
        if (i2 == 108) {
            ActionBar C = C();
            if (C != null) {
                C.n(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState O0 = O0(i2, true);
            if (O0.o) {
                x0(O0, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (AppCompatDelegate.G(this.q3) && AppCompatDelegate.A() != null && !AppCompatDelegate.A().equals(AppCompatDelegate.B())) {
            k(this.q3);
        }
        return n0(true);
    }

    @RequiresApi(33)
    public void g0(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.g0(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.n4;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.o4) == null)) {
            Api33Impl.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.o4 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.p3;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                onBackInvokedDispatcher = Api33Impl.a((Activity) this.p3);
            }
        }
        this.n4 = onBackInvokedDispatcher;
        x1();
    }

    /* access modifiers changed from: package-private */
    public void g1(ViewGroup viewGroup) {
    }

    public boolean h() {
        return n0(true);
    }

    public void h0(Toolbar toolbar) {
        if (this.p3 instanceof Activity) {
            ActionBar C = C();
            if (!(C instanceof WindowDecorActionBar)) {
                this.v3 = null;
                if (C != null) {
                    C.J();
                }
                this.u3 = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, Q0(), this.s3);
                    this.u3 = toolbarActionBar;
                    this.s3.e(toolbarActionBar.f2807k);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.s3.e((ActionBarMenuCallback) null);
                }
                F();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void i0(@StyleRes int i2) {
        this.a4 = i2;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar i1() {
        return this.u3;
    }

    public final void j0(CharSequence charSequence) {
        this.w3 = charSequence;
        DecorContentParent decorContentParent = this.x3;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (i1() != null) {
            i1().B0(charSequence);
        } else {
            TextView textView = this.I3;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public androidx.appcompat.view.ActionMode k0(@NonNull ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode = this.A3;
            if (actionMode != null) {
                actionMode.c();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar C = C();
            if (C != null) {
                androidx.appcompat.view.ActionMode D0 = C.D0(actionModeCallbackWrapperV9);
                this.A3 = D0;
                if (!(D0 == null || (appCompatCallback = this.t3) == null)) {
                    appCompatCallback.i(D0);
                }
            }
            if (this.A3 == null) {
                this.A3 = s1(actionModeCallbackWrapperV9);
            }
            x1();
            return this.A3;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    @CallSuper
    @NonNull
    public Context m(@NonNull Context context) {
        this.V3 = true;
        int X0 = X0(context, s0());
        if (AppCompatDelegate.G(context)) {
            AppCompatDelegate.m0(context);
        }
        LocaleListCompat r0 = r0(context);
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                ((android.view.ContextThemeWrapper) context).applyOverrideConfiguration(y0(context, X0, r0, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).a(y0(context, X0, r0, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!s4) {
            return super.m(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration y0 = y0(context, X0, r0, !configuration2.equals(configuration3) ? H0(configuration2, configuration3) : null, true);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.b4);
        contextThemeWrapper.a(y0);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.m(contextThemeWrapper);
    }

    /* access modifiers changed from: package-private */
    public void n1(Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.d(configuration, localeListCompat);
            return;
        }
        configuration.setLocale(localeListCompat.d(0));
        configuration.setLayoutDirection(localeListCompat.d(0));
    }

    /* access modifiers changed from: package-private */
    public void o1(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.d(0));
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return r(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.H3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p1() {
        /*
            r1 = this;
            boolean r0 = r1.G3
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.H3
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isLaidOut()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.p1():boolean");
    }

    public View r(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        if (this.l4 == null) {
            TypedArray obtainStyledAttributes = this.q3.obtainStyledAttributes(R.styleable.S0);
            String string = obtainStyledAttributes.getString(R.styleable.f3);
            obtainStyledAttributes.recycle();
            if (string == null) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.l4 = (AppCompatViewInflater) this.q3.getClassLoader().loadClass(string).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.l4 = appCompatViewInflater;
        }
        boolean z2 = q4;
        boolean z4 = false;
        if (z2) {
            if (this.m4 == null) {
                this.m4 = new LayoutIncludeDetector();
            }
            if (this.m4.a(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    z4 = q1((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z4 = true;
                }
                z = z4;
            }
        } else {
            z = false;
        }
        return this.l4.r(view, str, context, attributeSet, z, z2, true, VectorEnabledTintResources.d());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public LocaleListCompat r0(@NonNull Context context) {
        LocaleListCompat A;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (A = AppCompatDelegate.A()) == null) {
            return null;
        }
        LocaleListCompat N0 = N0(context.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat c2 = i2 >= 24 ? LocaleOverlayHelper.c(A, N0) : A.j() ? LocaleListCompat.g() : LocaleListCompat.c(Api21Impl.b(A.d(0)));
        return c2.j() ? N0 : c2;
    }

    /* access modifiers changed from: package-private */
    public boolean r1() {
        if (this.n4 == null) {
            return false;
        }
        PanelFeatureState O0 = O0(0, false);
        return (O0 != null && O0.o) || this.A3 != null;
    }

    @Nullable
    public <T extends View> T s(@IdRes int i2) {
        E0();
        return this.r3.findViewById(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode s1(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.D0()
            androidx.appcompat.view.ActionMode r0 = r7.A3
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.t3
            r1 = 0
            if (r0 == 0) goto L_0x0023
            boolean r2 = r7.X3
            if (r2 != 0) goto L_0x0023
            androidx.appcompat.view.ActionMode r0 = r0.y(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0024
        L_0x0022:
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x002a
            r7.A3 = r0
            goto L_0x015c
        L_0x002a:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.B3
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r7.P3
            if (r0 == 0) goto L_0x00b6
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.q3
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.f2560j
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0069
            android.content.Context r5 = r7.q3
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.q3
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006b
        L_0x0069:
            android.content.Context r4 = r7.q3
        L_0x006b:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.B3 = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.y
            r5.<init>(r4, r1, r6)
            r7.C3 = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.d(r5, r6)
            android.widget.PopupWindow r5 = r7.C3
            androidx.appcompat.widget.ActionBarContextView r6 = r7.B3
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.C3
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.f2554d
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.B3
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.C3
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.D3 = r0
            goto L_0x00d5
        L_0x00b6:
            android.view.ViewGroup r0 = r7.H3
            int r4 = androidx.appcompat.R.id.f2620l
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d5
            android.content.Context r4 = r7.I0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.B3 = r0
        L_0x00d5:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.B3
            if (r0 == 0) goto L_0x015c
            r7.D0()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.B3
            r0.t()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.B3
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.B3
            android.widget.PopupWindow r6 = r7.C3
            if (r6 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.b(r0, r3)
            if (r8 == 0) goto L_0x015a
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            r8.q(r0)
            r7.A3 = r0
            boolean r8 = r7.p1()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012b
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.g(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.b(r0)
            r7.E3 = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.u(r0)
            goto L_0x014a
        L_0x012b:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x014a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.B3
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.B1(r8)
        L_0x014a:
            android.widget.PopupWindow r8 = r7.C3
            if (r8 == 0) goto L_0x015c
            android.view.Window r8 = r7.r3
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.D3
            r8.post(r0)
            goto L_0x015c
        L_0x015a:
            r7.A3 = r1
        L_0x015c:
            androidx.appcompat.view.ActionMode r8 = r7.A3
            if (r8 == 0) goto L_0x0167
            androidx.appcompat.app.AppCompatCallback r0 = r7.t3
            if (r0 == 0) goto L_0x0167
            r0.i(r8)
        L_0x0167:
            r7.x1()
            androidx.appcompat.view.ActionMode r8 = r7.A3
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.s1(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    /* access modifiers changed from: package-private */
    public void t0(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.S3;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f2781j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.X3) {
            this.s3.d(this.r3.getCallback(), i2, menu);
        }
    }

    public Context u() {
        return this.q3;
    }

    /* access modifiers changed from: package-private */
    public void u0(@NonNull MenuBuilder menuBuilder) {
        if (!this.R3) {
            this.R3 = true;
            this.x3.o();
            Window.Callback R0 = R0();
            if (R0 != null && !this.X3) {
                R0.onPanelClosed(108, menuBuilder);
            }
            this.R3 = false;
        }
    }

    public final ActionBarDrawerToggle.Delegate w() {
        return new ActionBarDrawableToggleImpl();
    }

    /* access modifiers changed from: package-private */
    public void w0(int i2) {
        x0(O0(i2, true), true);
    }

    public int x() {
        return this.Z3;
    }

    /* access modifiers changed from: package-private */
    public void x0(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z || panelFeatureState.f2772a != 0 || (decorContentParent = this.x3) == null || !decorContentParent.d()) {
            WindowManager windowManager = (WindowManager) this.q3.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.o || (viewGroup = panelFeatureState.f2778g) == null)) {
                windowManager.removeView(viewGroup);
                if (z) {
                    t0(panelFeatureState.f2772a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f2784m = false;
            panelFeatureState.f2785n = false;
            panelFeatureState.o = false;
            panelFeatureState.f2779h = null;
            panelFeatureState.q = true;
            if (this.T3 == panelFeatureState) {
                this.T3 = null;
            }
            if (panelFeatureState.f2772a == 0) {
                x1();
                return;
            }
            return;
        }
        u0(panelFeatureState.f2781j);
    }

    /* access modifiers changed from: package-private */
    public void x1() {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedCallback onBackInvokedCallback2;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean r1 = r1();
            if (r1 && this.o4 == null) {
                onBackInvokedCallback2 = Api33Impl.b(this.n4, this);
            } else if (!r1 && (onBackInvokedCallback = this.o4) != null) {
                Api33Impl.c(this.n4, onBackInvokedCallback);
                onBackInvokedCallback2 = null;
            } else {
                return;
            }
            this.o4 = onBackInvokedCallback2;
        }
    }

    public MenuInflater z() {
        if (this.v3 == null) {
            S0();
            ActionBar actionBar = this.u3;
            this.v3 = new SupportMenuInflater(actionBar != null ? actionBar.A() : this.q3);
        }
        return this.v3;
    }

    /* access modifiers changed from: package-private */
    public final int z1(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        boolean z;
        boolean z2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i2;
        int i3 = 0;
        int r = windowInsetsCompat != null ? windowInsetsCompat.r() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.B3;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.B3.getLayoutParams();
            boolean z4 = true;
            if (this.B3.isShown()) {
                if (this.j4 == null) {
                    this.j4 = new Rect();
                    this.k4 = new Rect();
                }
                Rect rect2 = this.j4;
                Rect rect3 = this.k4;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.p(), windowInsetsCompat.r(), windowInsetsCompat.q(), windowInsetsCompat.o());
                }
                androidx.appcompat.widget.ViewUtils.a(this.H3, rect2, rect3);
                int i5 = rect2.top;
                int i6 = rect2.left;
                int i7 = rect2.right;
                WindowInsetsCompat r0 = ViewCompat.r0(this.H3);
                int p = r0 == null ? 0 : r0.p();
                int q = r0 == null ? 0 : r0.q();
                if (marginLayoutParams2.topMargin == i5 && marginLayoutParams2.leftMargin == i6 && marginLayoutParams2.rightMargin == i7) {
                    z2 = false;
                } else {
                    marginLayoutParams2.topMargin = i5;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i7;
                    z2 = true;
                }
                if (i5 <= 0 || this.J3 != null) {
                    View view = this.J3;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i2 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == p && marginLayoutParams.rightMargin == q))) {
                        marginLayoutParams.height = i2;
                        marginLayoutParams.leftMargin = p;
                        marginLayoutParams.rightMargin = q;
                        this.J3.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.q3);
                    this.J3 = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = p;
                    layoutParams.rightMargin = q;
                    this.H3.addView(this.J3, -1, layoutParams);
                }
                View view3 = this.J3;
                if (view3 == null) {
                    z4 = false;
                }
                if (z4 && view3.getVisibility() != 0) {
                    A1(this.J3);
                }
                if (!this.O3 && z4) {
                    r = 0;
                }
                z = z4;
                z4 = z2;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z = false;
            } else {
                z = false;
                z4 = false;
            }
            if (z4) {
                this.B3.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.J3;
        if (view4 != null) {
            if (!z) {
                i3 = 8;
            }
            view4.setVisibility(i3);
        }
        return r;
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, (Window) null, appCompatCallback, activity);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = p4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.AppCompatCallback r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.E3 = r0
            r0 = 1
            r2.F3 = r0
            r0 = -100
            r2.Z3 = r0
            androidx.appcompat.app.AppCompatDelegateImpl$2 r1 = new androidx.appcompat.app.AppCompatDelegateImpl$2
            r1.<init>()
            r2.h4 = r1
            r2.q3 = r3
            r2.t3 = r5
            r2.p3 = r6
            int r3 = r2.Z3
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.u1()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatDelegate r3 = r3.E0()
            int r3 = r3.x()
            r2.Z3 = r3
        L_0x0032:
            int r3 = r2.Z3
            if (r3 != r0) goto L_0x0059
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r3 = p4
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.Z3 = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.q0(r4)
        L_0x005e:
            androidx.appcompat.widget.AppCompatDrawableManager.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.AppCompatCallback, java.lang.Object):void");
    }
}
