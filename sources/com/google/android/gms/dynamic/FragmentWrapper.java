package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: l  reason: collision with root package name */
    private final Fragment f20447l;

    private FragmentWrapper(Fragment fragment) {
        this.f20447l = fragment;
    }

    @KeepForSdk
    @Nullable
    public static FragmentWrapper f(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    public final void B(boolean z) {
        this.f20447l.setHasOptionsMenu(z);
    }

    public final boolean C() {
        return this.f20447l.isRemoving();
    }

    @NonNull
    public final IObjectWrapper D() {
        return ObjectWrapper.z(this.f20447l.getResources());
    }

    public final void E(boolean z) {
        this.f20447l.setMenuVisibility(z);
    }

    public final void H0(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.f(iObjectWrapper);
        Preconditions.r(view);
        this.f20447l.registerForContextMenu(view);
    }

    public final boolean I0() {
        return this.f20447l.isAdded();
    }

    public final void J0(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.f(iObjectWrapper);
        Preconditions.r(view);
        this.f20447l.unregisterForContextMenu(view);
    }

    public final boolean L0() {
        return this.f20447l.isDetached();
    }

    @Nullable
    public final IFragmentWrapper O0() {
        return f(this.f20447l.getParentFragment());
    }

    @Nullable
    public final String Q0() {
        return this.f20447l.getTag();
    }

    public final boolean U0() {
        return this.f20447l.getRetainInstance();
    }

    public final boolean V() {
        return this.f20447l.isResumed();
    }

    public final void W0(boolean z) {
        this.f20447l.setUserVisibleHint(z);
    }

    @NonNull
    public final IObjectWrapper a() {
        return ObjectWrapper.z(this.f20447l.getView());
    }

    public final boolean a1() {
        return this.f20447l.isVisible();
    }

    public final int b() {
        return this.f20447l.getTargetRequestCode();
    }

    public final void b0(boolean z) {
        this.f20447l.setRetainInstance(z);
    }

    @NonNull
    public final IObjectWrapper c() {
        return ObjectWrapper.z(this.f20447l.getActivity());
    }

    public final boolean c1() {
        return this.f20447l.getUserVisibleHint();
    }

    @Nullable
    public final Bundle d() {
        return this.f20447l.getArguments();
    }

    public final int g() {
        return this.f20447l.getId();
    }

    public final void h0(@NonNull Intent intent) {
        this.f20447l.startActivity(intent);
    }

    public final boolean k0() {
        return this.f20447l.isHidden();
    }

    public final void l0(@NonNull Intent intent, int i2) {
        this.f20447l.startActivityForResult(intent, i2);
    }

    @Nullable
    public final IFragmentWrapper n0() {
        return f(this.f20447l.getTargetFragment());
    }

    public final boolean v0() {
        return this.f20447l.isInLayout();
    }
}
