package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private final KeyEventDispatcher.Component X2;
    private AppCompatDelegate Z;

    public AppCompatDialog(@NonNull Context context) {
        this(context, 0);
    }

    private static int l(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.Z0, typedValue, true);
        return typedValue.resourceId;
    }

    private void m() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.b(getWindow().getDecorView(), this);
    }

    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        h().f(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        h().N();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.e(this.X2, getWindow().getDecorView(), this, keyEvent);
    }

    @Nullable
    public <T extends View> T findViewById(@IdRes int i2) {
        return h().s(i2);
    }

    @NonNull
    public AppCompatDelegate h() {
        if (this.Z == null) {
            this.Z = AppCompatDelegate.o(this, this);
        }
        return this.Z;
    }

    public void i(ActionMode actionMode) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        h().F();
    }

    public void j(ActionMode actionMode) {
    }

    public ActionBar k() {
        return h().C();
    }

    /* access modifiers changed from: package-private */
    public boolean n(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean o(int i2) {
        return h().V(i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        h().E();
        super.onCreate(bundle);
        h().M(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        h().S();
    }

    public void setContentView(@LayoutRes int i2) {
        m();
        h().Z(i2);
    }

    public void setTitle(int i2) {
        super.setTitle(i2);
        h().j0(getContext().getString(i2));
    }

    @Nullable
    public ActionMode y(ActionMode.Callback callback) {
        return null;
    }

    public AppCompatDialog(@NonNull Context context, int i2) {
        super(context, l(context, i2));
        this.X2 = new r(this);
        AppCompatDelegate h2 = h();
        h2.i0(l(context, i2));
        h2.M((Bundle) null);
    }

    public void setContentView(@NonNull View view) {
        m();
        h().a0(view);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        h().j0(charSequence);
    }

    protected AppCompatDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.X2 = new r(this);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        m();
        h().b0(view, layoutParams);
    }
}
