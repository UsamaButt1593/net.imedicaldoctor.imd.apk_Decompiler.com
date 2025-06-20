package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag extends GoogleApiClient {

    /* renamed from: e  reason: collision with root package name */
    private final String f20047e = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public zaag(String str) {
    }

    public final void A() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void B(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void C(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void E(@NonNull FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void F(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void G(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final ConnectionResult d() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final ConnectionResult e(long j2, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final PendingResult<Status> f() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void g() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void i() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    @NonNull
    public final ConnectionResult p(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final boolean t(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final boolean u() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final boolean v() {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final boolean w(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.f20047e);
    }

    public final boolean x(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f20047e);
    }
}
