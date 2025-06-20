package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;

public final class zak extends zap {
    private final SparseArray<zaj> Y2 = new SparseArray<>();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.x());
        this.s.c("AutoManageHelper", this);
    }

    public static zak u(LifecycleActivity lifecycleActivity) {
        LifecycleFragment e2 = LifecycleCallback.e(lifecycleActivity);
        zak zak = (zak) e2.d("AutoManageHelper", zak.class);
        return zak != null ? zak : new zak(e2);
    }

    @Nullable
    private final zaj x(int i2) {
        if (this.Y2.size() <= i2) {
            return null;
        }
        SparseArray<zaj> sparseArray = this.Y2;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.Y2.size(); i2++) {
            zaj x = x(i2);
            if (x != null) {
                printWriter.append(str).append("GoogleApiClient #").print(x.f20166l);
                printWriter.println(":");
                x.f20167m.j(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void k() {
        super.k();
        boolean z = this.X;
        String valueOf = String.valueOf(this.Y2);
        StringBuilder sb = new StringBuilder(valueOf.length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(StringUtils.SPACE);
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.Y.get() == null) {
            for (int i2 = 0; i2 < this.Y2.size(); i2++) {
                zaj x = x(i2);
                if (x != null) {
                    x.f20167m.g();
                }
            }
        }
    }

    public final void l() {
        super.l();
        for (int i2 = 0; i2 < this.Y2.size(); i2++) {
            zaj x = x(i2);
            if (x != null) {
                x.f20167m.i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void n(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zaj = this.Y2.get(i2);
        if (zaj != null) {
            w(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaj.f20168n;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.f(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void o() {
        for (int i2 = 0; i2 < this.Y2.size(); i2++) {
            zaj x = x(i2);
            if (x != null) {
                x.f20167m.g();
            }
        }
    }

    public final void v(int i2, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.s(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.Y2.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        Preconditions.y(z, sb.toString());
        zam zam = this.Y.get();
        boolean z2 = this.X;
        String valueOf = String.valueOf(zam);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(StringUtils.SPACE);
        sb2.append(z2);
        sb2.append(StringUtils.SPACE);
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        zaj zaj = new zaj(this, i2, googleApiClient, onConnectionFailedListener);
        googleApiClient.C(zaj);
        this.Y2.put(i2, zaj);
        if (this.X && zam == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.g();
        }
    }

    public final void w(int i2) {
        zaj zaj = this.Y2.get(i2);
        this.Y2.remove(i2);
        if (zaj != null) {
            zaj.f20167m.G(zaj);
            zaj.f20167m.i();
        }
    }
}
