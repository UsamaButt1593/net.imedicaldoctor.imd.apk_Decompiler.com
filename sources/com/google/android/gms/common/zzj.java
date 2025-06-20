package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzj extends zzz {

    /* renamed from: l  reason: collision with root package name */
    private final int f20421l;

    protected zzj(byte[] bArr) {
        Preconditions.a(bArr.length == 25);
        this.f20421l = Arrays.hashCode(bArr);
    }

    protected static byte[] f(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int b() {
        return this.f20421l;
    }

    public final IObjectWrapper d() {
        return ObjectWrapper.z(z());
    }

    public final boolean equals(@Nullable Object obj) {
        IObjectWrapper d2;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaa = (zzaa) obj;
                if (zzaa.b() != this.f20421l || (d2 = zzaa.d()) == null) {
                    return false;
                }
                return Arrays.equals(z(), (byte[]) ObjectWrapper.f(d2));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f20421l;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] z();
}
