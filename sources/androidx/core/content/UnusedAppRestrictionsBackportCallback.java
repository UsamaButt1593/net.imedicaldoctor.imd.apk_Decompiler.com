package androidx.core.content;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

public class UnusedAppRestrictionsBackportCallback {

    /* renamed from: a  reason: collision with root package name */
    private IUnusedAppRestrictionsBackportCallback f5683a;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public UnusedAppRestrictionsBackportCallback(@NonNull IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.f5683a = iUnusedAppRestrictionsBackportCallback;
    }

    public void a(boolean z, boolean z2) throws RemoteException {
        this.f5683a.R0(z, z2);
    }
}
