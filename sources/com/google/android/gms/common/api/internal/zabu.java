package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Api.Client f20111a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ApiKey<?> f20112b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private IAccountAccessor f20113c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f20114d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f20115e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f20116f;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey<?> apiKey) {
        this.f20116f = googleApiManager;
        this.f20111a = client;
        this.f20112b = apiKey;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void h() {
        IAccountAccessor iAccountAccessor;
        if (this.f20115e && (iAccountAccessor = this.f20113c) != null) {
            this.f20111a.f(iAccountAccessor, this.f20114d);
        }
    }

    public final void a(@NonNull ConnectionResult connectionResult) {
        this.f20116f.i3.post(new zabt(this, connectionResult));
    }

    @WorkerThread
    public final void b(ConnectionResult connectionResult) {
        zabq zabq = (zabq) this.f20116f.e3.get(this.f20112b);
        if (zabq != null) {
            zabq.I(connectionResult);
        }
    }

    @WorkerThread
    public final void c(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
            return;
        }
        this.f20113c = iAccountAccessor;
        this.f20114d = set;
        h();
    }
}
