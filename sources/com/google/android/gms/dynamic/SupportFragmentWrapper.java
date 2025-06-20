package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: l  reason: collision with root package name */
    private final Fragment f20451l;

    private SupportFragmentWrapper(Fragment fragment) {
        this.f20451l = fragment;
    }

    @KeepForSdk
    @Nullable
    public static SupportFragmentWrapper f(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    public final void B(boolean z) {
        this.f20451l.o2(z);
    }

    public final boolean C() {
        return this.f20451l.F0();
    }

    @NonNull
    public final IObjectWrapper D() {
        return ObjectWrapper.z(this.f20451l.b0());
    }

    public final void E(boolean z) {
        this.f20451l.q2(z);
    }

    public final void H0(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.f(iObjectWrapper);
        Preconditions.r(view);
        this.f20451l.S1(view);
    }

    public final boolean I0() {
        return this.f20451l.y0();
    }

    public final void J0(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.f(iObjectWrapper);
        Preconditions.r(view);
        this.f20451l.I2(view);
    }

    public final boolean L0() {
        return this.f20451l.z0();
    }

    @Nullable
    public final IFragmentWrapper O0() {
        return f(this.f20451l.U());
    }

    @Nullable
    public final String Q0() {
        return this.f20451l.k0();
    }

    public final boolean U0() {
        return this.f20451l.c0();
    }

    public final boolean V() {
        return this.f20451l.G0();
    }

    public final void W0(boolean z) {
        this.f20451l.B2(z);
    }

    @NonNull
    public final IObjectWrapper a() {
        return ObjectWrapper.z(this.f20451l.q0());
    }

    public final boolean a1() {
        return this.f20451l.I0();
    }

    public final int b() {
        return this.f20451l.n0();
    }

    public final void b0(boolean z) {
        this.f20451l.v2(z);
    }

    @NonNull
    public final IObjectWrapper c() {
        return ObjectWrapper.z(this.f20451l.r());
    }

    public final boolean c1() {
        return this.f20451l.p0();
    }

    @Nullable
    public final Bundle d() {
        return this.f20451l.y();
    }

    public final int g() {
        return this.f20451l.O();
    }

    public final void h0(@NonNull Intent intent) {
        this.f20451l.D2(intent);
    }

    public final boolean k0() {
        return this.f20451l.A0();
    }

    public final void l0(@NonNull Intent intent, int i2) {
        this.f20451l.startActivityForResult(intent, i2);
    }

    @Nullable
    public final IFragmentWrapper n0() {
        return f(this.f20451l.l0());
    }

    public final boolean v0() {
        return this.f20451l.C0();
    }
}
