package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface GoogleSignInOptionsExtension {
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public static final int f19730a = 1;
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    public static final int f19731b = 3;

    @NonNull
    @KeepForSdk
    Bundle a();

    @KeepForSdk
    int b();

    @KeepForSdk
    @Nullable
    List<Scope> c();
}
