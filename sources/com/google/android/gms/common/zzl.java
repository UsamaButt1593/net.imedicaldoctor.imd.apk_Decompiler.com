package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzl extends zzj {

    /* renamed from: n  reason: collision with root package name */
    private static final WeakReference f20423n = new WeakReference((Object) null);

    /* renamed from: m  reason: collision with root package name */
    private WeakReference f20424m = f20423n;

    zzl(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] u0();

    /* access modifiers changed from: package-private */
    public final byte[] z() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.f20424m.get();
                if (bArr == null) {
                    bArr = u0();
                    this.f20424m = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }
}
