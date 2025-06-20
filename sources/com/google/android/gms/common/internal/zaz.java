package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zaz extends RemoteCreator<zam> {

    /* renamed from: c  reason: collision with root package name */
    private static final zaz f20294c = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        zaz zaz = f20294c;
        try {
            zax zax = new zax(1, i2, i3, (Scope[]) null);
            return (View) ObjectWrapper.f(((zam) zaz.b(context)).e(ObjectWrapper.z(context), zax));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof zam ? (zam) queryLocalInterface : new zam(iBinder);
    }
}
