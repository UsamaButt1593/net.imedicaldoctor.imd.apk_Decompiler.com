package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zzf extends zza {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f20309g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20310h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzf(BaseGmsClient baseGmsClient, @Nullable int i2, @Nullable IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i2, bundle);
        this.f20310h = baseGmsClient;
        this.f20309g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(ConnectionResult connectionResult) {
        if (this.f20310h.o3 != null) {
            this.f20310h.o3.f(connectionResult);
        }
        this.f20310h.U(connectionResult);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        String str;
        try {
            IBinder iBinder = this.f20309g;
            Preconditions.r(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f20310h.N().equals(interfaceDescriptor)) {
                str = "service descriptor mismatch: " + this.f20310h.N() + " vs. " + interfaceDescriptor;
                Log.w("GmsClient", str);
                return false;
            }
            IInterface A = this.f20310h.A(this.f20309g);
            if (A == null || (!BaseGmsClient.o0(this.f20310h, 2, 4, A) && !BaseGmsClient.o0(this.f20310h, 3, 4, A))) {
                return false;
            }
            this.f20310h.s3 = null;
            BaseGmsClient baseGmsClient = this.f20310h;
            Bundle F = baseGmsClient.F();
            if (baseGmsClient.n3 == null) {
                return true;
            }
            this.f20310h.n3.z(F);
            return true;
        } catch (RemoteException unused) {
            str = "service probably died";
        }
    }
}
