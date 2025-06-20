package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public ResultTransform<? super R, ? extends Result> f20146a = null;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public zada<? extends Result> f20147b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile ResultCallbacks<? super R> f20148c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PendingResult<R> f20149d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f20150e = new Object();
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Status f20151f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final WeakReference<GoogleApiClient> f20152g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final zacz f20153h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20154i = false;

    public zada(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.s(weakReference, "GoogleApiClient reference must not be null");
        this.f20152g = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.f20153h = new zacz(this, googleApiClient != null ? googleApiClient.r() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public final void m(Status status) {
        synchronized (this.f20150e) {
            this.f20151f = status;
            o(status);
        }
    }

    @GuardedBy("mSyncToken")
    private final void n() {
        if (this.f20146a != null || this.f20148c != null) {
            GoogleApiClient googleApiClient = this.f20152g.get();
            if (!(this.f20154i || this.f20146a == null || googleApiClient == null)) {
                googleApiClient.H(this);
                this.f20154i = true;
            }
            Status status = this.f20151f;
            if (status != null) {
                o(status);
                return;
            }
            PendingResult<R> pendingResult = this.f20149d;
            if (pendingResult != null) {
                pendingResult.h(this);
            }
        }
    }

    private final void o(Status status) {
        synchronized (this.f20150e) {
            try {
                ResultTransform<? super R, ? extends Result> resultTransform = this.f20146a;
                if (resultTransform != null) {
                    ((zada) Preconditions.r(this.f20147b)).m((Status) Preconditions.s(resultTransform.b(status), "onFailure must not return null"));
                } else if (p()) {
                    ((ResultCallbacks) Preconditions.r(this.f20148c)).b(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean p() {
        return (this.f20148c == null || this.f20152g.get() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static final void q(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).a();
            } catch (RuntimeException e2) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e2);
            }
        }
    }

    public final void a(R r) {
        synchronized (this.f20150e) {
            try {
                if (!r.d().R()) {
                    m(r.d());
                    q(r);
                } else if (this.f20146a != null) {
                    zaco.a().submit(new zacy(this, r));
                } else if (p()) {
                    ((ResultCallbacks) Preconditions.r(this.f20148c)).c(r);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.f20150e) {
            boolean z = false;
            Preconditions.y(this.f20148c == null, "Cannot call andFinally() twice.");
            if (this.f20146a == null) {
                z = true;
            }
            Preconditions.y(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f20148c = resultCallbacks;
            n();
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> c(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zada<? extends Result> zada;
        synchronized (this.f20150e) {
            boolean z = false;
            Preconditions.y(this.f20146a == null, "Cannot call then() twice.");
            if (this.f20148c == null) {
                z = true;
            }
            Preconditions.y(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f20146a = resultTransform;
            zada = new zada<>(this.f20152g);
            this.f20147b = zada;
            n();
        }
        return zada;
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        this.f20148c = null;
    }

    public final void l(PendingResult<?> pendingResult) {
        synchronized (this.f20150e) {
            this.f20149d = pendingResult;
            n();
        }
    }
}
