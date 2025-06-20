package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    @NonNull
    private final Context X;
    final FragmentManager X2;
    @NonNull
    private final Handler Y;
    private final int Z;
    @Nullable
    private final Activity s;

    FragmentHostCallback(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i2) {
        this.X2 = new FragmentManagerImpl();
        this.s = activity;
        this.X = (Context) Preconditions.m(context, "context == null");
        this.Y = (Handler) Preconditions.m(handler, "handler == null");
        this.Z = i2;
    }

    public boolean B(@NonNull String str) {
        return false;
    }

    public void C(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        E(fragment, intent, i2, (Bundle) null);
    }

    public void E(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (i2 == -1) {
            ContextCompat.A(this.X, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void G(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            ActivityCompat.V(this.s, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void I() {
    }

    @Nullable
    public View g(int i2) {
        return null;
    }

    public boolean i() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Activity j() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Context m() {
        return this.X;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Handler n() {
        return this.Y;
    }

    public void o(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Nullable
    public abstract E p();

    @NonNull
    public LayoutInflater s() {
        return LayoutInflater.from(this.X);
    }

    public int t() {
        return this.Z;
    }

    public boolean v() {
        return true;
    }

    @Deprecated
    public void x(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
    }

    public boolean y(@NonNull Fragment fragment) {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(@NonNull Context context, @NonNull Handler handler, int i2) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i2);
    }

    FragmentHostCallback(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }
}
