package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    private static final String x3 = "androidx:appcompat";
    private AppCompatDelegate v3;
    private Resources w3;

    public AppCompatActivity() {
        G0();
    }

    private void G0() {
        A().j(x3, new SavedStateRegistry.SavedStateProvider() {
            @NonNull
            public Bundle a() {
                Bundle bundle = new Bundle();
                AppCompatActivity.this.E0().Q(bundle);
                return bundle;
            }
        });
        J(new OnContextAvailableListener() {
            public void a(@NonNull Context context) {
                AppCompatDelegate E0 = AppCompatActivity.this.E0();
                E0.E();
                E0.M(AppCompatActivity.this.A().b(AppCompatActivity.x3));
            }
        });
    }

    private void H0() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.b(getWindow().getDecorView(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean O0(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.O0(android.view.KeyEvent):boolean");
    }

    public void B0() {
        E0().F();
    }

    @NonNull
    public AppCompatDelegate E0() {
        if (this.v3 == null) {
            this.v3 = AppCompatDelegate.n(this, this);
        }
        return this.v3;
    }

    @Nullable
    public ActionBar F0() {
        return E0().C();
    }

    public void I0(@NonNull TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.d(this);
    }

    /* access modifiers changed from: protected */
    public void J0(@NonNull LocaleListCompat localeListCompat) {
    }

    /* access modifiers changed from: protected */
    public void K0(int i2) {
    }

    public void L0(@NonNull TaskStackBuilder taskStackBuilder) {
    }

    @Deprecated
    public void M0() {
    }

    public boolean N0() {
        Intent v = v();
        if (v == null) {
            return false;
        }
        if (X0(v)) {
            TaskStackBuilder j2 = TaskStackBuilder.j(this);
            I0(j2);
            L0(j2);
            j2.x();
            try {
                ActivityCompat.D(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            V0(v);
            return true;
        }
    }

    public void P0(@Nullable Toolbar toolbar) {
        E0().h0(toolbar);
    }

    @Deprecated
    public void Q0(int i2) {
    }

    @Deprecated
    public void R0(boolean z) {
    }

    @Deprecated
    public void S0(boolean z) {
    }

    @Deprecated
    public void T0(boolean z) {
    }

    @Nullable
    public ActionMode U0(@NonNull ActionMode.Callback callback) {
        return E0().k0(callback);
    }

    public void V0(@NonNull Intent intent) {
        NavUtils.g(this, intent);
    }

    public boolean W0(int i2) {
        return E0().V(i2);
    }

    public boolean X0(@NonNull Intent intent) {
        return NavUtils.h(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        H0();
        E0().f(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(E0().m(context));
    }

    @Nullable
    public ActionBarDrawerToggle.Delegate b() {
        return E0().w();
    }

    public void closeOptionsMenu() {
        ActionBar F0 = F0();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (F0 == null || !F0.l()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar F0 = F0();
        if (keyCode != 82 || F0 == null || !F0.L(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(@IdRes int i2) {
        return E0().s(i2);
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return E0().z();
    }

    public Resources getResources() {
        if (this.w3 == null && VectorEnabledTintResources.d()) {
            this.w3 = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.w3;
        return resources == null ? super.getResources() : resources;
    }

    @CallSuper
    public void i(@NonNull ActionMode actionMode) {
    }

    public void invalidateOptionsMenu() {
        E0().F();
    }

    @CallSuper
    public void j(@NonNull ActionMode actionMode) {
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        E0().L(configuration);
        if (this.w3 != null) {
            this.w3.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        M0();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        E0().N();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (O0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final boolean onMenuItemSelected(int i2, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar F0 = F0();
        if (menuItem.getItemId() != 16908332 || F0 == null || (F0.p() & 4) == 0) {
            return false;
        }
        return N0();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, @NonNull Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        E0().O(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        E0().P();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        E0().R();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        E0().S();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        E0().j0(charSequence);
    }

    public void openOptionsMenu() {
        ActionBar F0 = F0();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (F0 == null || !F0.M()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(@LayoutRes int i2) {
        H0();
        E0().Z(i2);
    }

    public void setTheme(@StyleRes int i2) {
        super.setTheme(i2);
        E0().i0(i2);
    }

    @Nullable
    public Intent v() {
        return NavUtils.a(this);
    }

    @Nullable
    public ActionMode y(@NonNull ActionMode.Callback callback) {
        return null;
    }

    @ContentView
    public AppCompatActivity(@LayoutRes int i2) {
        super(i2);
        G0();
    }

    public void setContentView(View view) {
        H0();
        E0().a0(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        H0();
        E0().b0(view, layoutParams);
    }
}
