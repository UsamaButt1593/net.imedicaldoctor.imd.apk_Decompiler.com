package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

final class zza extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f20492a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ProviderInstaller.ProviderInstallListener f20493b;

    zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f20492a = context;
        this.f20493b = providerInstallListener;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        int b2;
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.a(this.f20492a);
            b2 = 0;
        } catch (GooglePlayServicesRepairableException e2) {
            b2 = e2.b();
        } catch (GooglePlayServicesNotAvailableException e3) {
            b2 = e3.s;
        }
        return Integer.valueOf(b2);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.f20493b.a();
            return;
        }
        this.f20493b.b(num.intValue(), ProviderInstaller.f20488b.e(this.f20492a, num.intValue(), "pi"));
    }
}
