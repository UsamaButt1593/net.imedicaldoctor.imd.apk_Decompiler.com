package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.zae;

@KeepForSdk
public class SignInClientImpl extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int L3 = 0;
    private final boolean H3 = true;
    private final ClientSettings I3;
    private final Bundle J3;
    @Nullable
    private final Integer K3;

    public SignInClientImpl(@NonNull Context context, @NonNull Looper looper, boolean z, @NonNull ClientSettings clientSettings, @NonNull Bundle bundle, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.I3 = clientSettings;
        this.J3 = bundle;
        this.K3 = clientSettings.l();
    }

    @NonNull
    @KeepForSdk
    public static Bundle u0(@NonNull ClientSettings clientSettings) {
        clientSettings.k();
        Integer l2 = clientSettings.l();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.b());
        if (l2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", l2.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final /* synthetic */ IInterface A(@NonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zaf ? (zaf) queryLocalInterface : new zaf(iBinder);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Bundle I() {
        if (!G().getPackageName().equals(this.I3.h())) {
            this.J3.putString("com.google.android.gms.signin.internal.realClientPackageName", this.I3.h());
        }
        return this.J3;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String N() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String O() {
        return "com.google.android.gms.signin.service.START";
    }

    public final void b() {
        try {
            ((zaf) M()).e(((Integer) Preconditions.r(this.K3)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void c() {
        k(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    public final void q(zae zae) {
        Preconditions.s(zae, "Expecting a valid ISignInCallbacks");
        try {
            Account d2 = this.I3.d();
            ((zaf) M()).z(new zai(1, new zat(d2, ((Integer) Preconditions.r(this.K3)).intValue(), "<<default account>>".equals(d2.name) ? Storage.b(G()).c() : null)), zae);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zae.Y(new zak(1, new ConnectionResult(8, (PendingIntent) null), (zav) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public final int r() {
        return GooglePlayServicesUtilLight.f19883a;
    }

    public final void t(@NonNull IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) M()).f(iAccountAccessor, ((Integer) Preconditions.r(this.K3)).intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final boolean w() {
        return this.H3;
    }
}
