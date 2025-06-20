package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zad {

    /* renamed from: a  reason: collision with root package name */
    public static final Api.ClientKey<SignInClientImpl> f20494a;
    @ShowFirstParty

    /* renamed from: b  reason: collision with root package name */
    public static final Api.ClientKey<SignInClientImpl> f20495b;

    /* renamed from: c  reason: collision with root package name */
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> f20496c;

    /* renamed from: d  reason: collision with root package name */
    static final Api.AbstractClientBuilder<SignInClientImpl, zac> f20497d;

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f20498e = new Scope(Scopes.f19906a);

    /* renamed from: f  reason: collision with root package name */
    public static final Scope f20499f = new Scope("email");

    /* renamed from: g  reason: collision with root package name */
    public static final Api<SignInOptions> f20500g;

    /* renamed from: h  reason: collision with root package name */
    public static final Api<zac> f20501h;

    static {
        Api.ClientKey<SignInClientImpl> clientKey = new Api.ClientKey<>();
        f20494a = clientKey;
        Api.ClientKey<SignInClientImpl> clientKey2 = new Api.ClientKey<>();
        f20495b = clientKey2;
        zaa zaa = new zaa();
        f20496c = zaa;
        zab zab = new zab();
        f20497d = zab;
        f20500g = new Api<>("SignIn.API", zaa, clientKey);
        f20501h = new Api<>("SignIn.INTERNAL_API", zab, clientKey2);
    }
}
