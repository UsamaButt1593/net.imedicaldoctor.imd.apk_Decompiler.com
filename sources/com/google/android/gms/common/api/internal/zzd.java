package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzd extends Fragment implements LifecycleFragment {
    private static final WeakHashMap h4 = new WeakHashMap();
    private final Map e4 = Collections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */
    public int f4 = 0;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle g4;

    public static zzd L2(FragmentActivity fragmentActivity) {
        zzd zzd;
        WeakHashMap weakHashMap = h4;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (zzd = (zzd) weakReference.get()) != null) {
            return zzd;
        }
        try {
            zzd zzd2 = (zzd) fragmentActivity.k0().s0("SupportLifecycleFragmentImpl");
            if (zzd2 == null || zzd2.F0()) {
                zzd2 = new zzd();
                fragmentActivity.k0().u().k(zzd2, "SupportLifecycleFragmentImpl").r();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(zzd2));
            return zzd2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    public final void L0(int i2, int i3, @Nullable Intent intent) {
        super.L0(i2, i3, intent);
        for (LifecycleCallback f2 : this.e4.values()) {
            f2.f(i2, i3, intent);
        }
    }

    public final void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        this.f4 = 1;
        this.g4 = bundle;
        for (Map.Entry entry : this.e4.entrySet()) {
            ((LifecycleCallback) entry.getValue()).g(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void V0() {
        super.V0();
        this.f4 = 5;
        for (LifecycleCallback h2 : this.e4.values()) {
            h2.h();
        }
    }

    public final boolean b() {
        return this.f4 > 0;
    }

    public final void c(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.e4.containsKey(str)) {
            this.e4.put(str, lifecycleCallback);
            if (this.f4 > 0) {
                new zzi(Looper.getMainLooper()).post(new zzc(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    @Nullable
    public final <T extends LifecycleCallback> T d(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.e4.get(str));
    }

    @Nullable
    public final /* synthetic */ Activity f() {
        return r();
    }

    public final boolean i() {
        return this.f4 >= 2;
    }

    public final void l(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.l(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.e4.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void l1() {
        super.l1();
        this.f4 = 3;
        for (LifecycleCallback i2 : this.e4.values()) {
            i2.i();
        }
    }

    public final void m1(Bundle bundle) {
        super.m1(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.e4.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).j(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void n1() {
        super.n1();
        this.f4 = 2;
        for (LifecycleCallback k2 : this.e4.values()) {
            k2.k();
        }
    }

    public final void o1() {
        super.o1();
        this.f4 = 4;
        for (LifecycleCallback l2 : this.e4.values()) {
            l2.l();
        }
    }
}
