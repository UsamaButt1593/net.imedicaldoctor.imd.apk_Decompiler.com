package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zaca {
    ConnectionResult c();

    boolean d();

    ConnectionResult f(long j2, TimeUnit timeUnit);

    void g();

    <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(@NonNull T t);

    boolean i();

    <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T j(@NonNull T t);

    void k();

    void l();

    void m();

    boolean n(SignInConnectionListener signInConnectionListener);

    void o(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr);

    @Nullable
    ConnectionResult p(@NonNull Api<?> api);
}
