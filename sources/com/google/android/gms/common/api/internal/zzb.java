package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzb extends Fragment implements LifecycleFragment {
    private static final WeakHashMap Z = new WeakHashMap();
    /* access modifiers changed from: private */
    public int X = 0;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle Y;
    private final Map s = Collections.synchronizedMap(new ArrayMap());

    public static zzb g(Activity activity) {
        zzb zzb;
        WeakHashMap weakHashMap = Z;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (zzb = (zzb) weakReference.get()) != null) {
            return zzb;
        }
        try {
            zzb zzb2 = (zzb) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzb2 == null || zzb2.isRemoving()) {
                zzb2 = new zzb();
                activity.getFragmentManager().beginTransaction().add(zzb2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(zzb2));
            return zzb2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    public final boolean b() {
        return this.X > 0;
    }

    public final void c(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.s.containsKey(str)) {
            this.s.put(str, lifecycleCallback);
            if (this.X > 0) {
                new zzi(Looper.getMainLooper()).post(new zza(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    @Nullable
    public final <T extends LifecycleCallback> T d(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.s.get(str));
    }

    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.s.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public final Activity f() {
        return getActivity();
    }

    public final boolean i() {
        return this.X >= 2;
    }

    public final void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback f2 : this.s.values()) {
            f2.f(i2, i3, intent);
        }
    }

    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.X = 1;
        this.Y = bundle;
        for (Map.Entry entry : this.s.entrySet()) {
            ((LifecycleCallback) entry.getValue()).g(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.X = 5;
        for (LifecycleCallback h2 : this.s.values()) {
            h2.h();
        }
    }

    public final void onResume() {
        super.onResume();
        this.X = 3;
        for (LifecycleCallback i2 : this.s.values()) {
            i2.i();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.s.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).j(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.X = 2;
        for (LifecycleCallback k2 : this.s.values()) {
            k2.k();
        }
    }

    public final void onStop() {
        super.onStop();
        this.X = 4;
        for (LifecycleCallback l2 : this.s.values()) {
            l2.l();
        }
    }
}
