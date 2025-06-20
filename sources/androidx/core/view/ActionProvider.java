package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class ActionProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final String f6335d = "ActionProvider(support)";

    /* renamed from: a  reason: collision with root package name */
    private final Context f6336a;

    /* renamed from: b  reason: collision with root package name */
    private SubUiVisibilityListener f6337b;

    /* renamed from: c  reason: collision with root package name */
    private VisibilityListener f6338c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface SubUiVisibilityListener {
        void a(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(@NonNull Context context) {
        this.f6336a = context;
    }

    @NonNull
    public Context a() {
        return this.f6336a;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    @NonNull
    public abstract View d();

    @NonNull
    public View e(@NonNull MenuItem menuItem) {
        return d();
    }

    public boolean f() {
        return false;
    }

    public void g(@NonNull SubMenu subMenu) {
    }

    public boolean h() {
        return false;
    }

    public void i() {
        if (this.f6338c != null && h()) {
            this.f6338c.onActionProviderVisibilityChanged(c());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void j() {
        this.f6338c = null;
        this.f6337b = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void k(@Nullable SubUiVisibilityListener subUiVisibilityListener) {
        this.f6337b = subUiVisibilityListener;
    }

    public void l(@Nullable VisibilityListener visibilityListener) {
        if (!(this.f6338c == null || visibilityListener == null)) {
            Log.w(f6335d, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f6338c = visibilityListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void m(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.f6337b;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.a(z);
        }
    }
}
