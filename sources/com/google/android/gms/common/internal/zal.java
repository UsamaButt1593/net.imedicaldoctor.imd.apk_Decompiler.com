package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

public final class zal {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f20287a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleApiAvailabilityLight f20288b;

    public zal() {
        this(GoogleApiAvailability.x());
    }

    public final int a(Context context, int i2) {
        return this.f20287a.get(i2, -1);
    }

    public final int b(@NonNull Context context, @NonNull Api.Client client) {
        Preconditions.r(context);
        Preconditions.r(client);
        int i2 = 0;
        if (!client.p()) {
            return 0;
        }
        int r = client.r();
        int a2 = a(context, r);
        if (a2 == -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f20287a.size()) {
                    i2 = -1;
                    break;
                }
                int keyAt = this.f20287a.keyAt(i3);
                if (keyAt > r && this.f20287a.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            a2 = i2 == -1 ? this.f20288b.k(context, r) : i2;
            this.f20287a.put(r, a2);
        }
        return a2;
    }

    public final void c() {
        this.f20287a.clear();
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f20287a = new SparseIntArray();
        Preconditions.r(googleApiAvailabilityLight);
        this.f20288b = googleApiAvailabilityLight;
    }
}
