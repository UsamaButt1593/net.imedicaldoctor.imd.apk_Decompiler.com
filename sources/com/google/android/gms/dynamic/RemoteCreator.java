package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f20449a;

    /* renamed from: b  reason: collision with root package name */
    private Object f20450b;

    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(@NonNull String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected RemoteCreator(@NonNull String str) {
        this.f20449a = str;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract T a(@NonNull IBinder iBinder);

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public final T b(@NonNull Context context) throws RemoteCreatorException {
        if (this.f20450b == null) {
            Preconditions.r(context);
            Context i2 = GooglePlayServicesUtilLight.i(context);
            if (i2 != null) {
                try {
                    this.f20450b = a((IBinder) i2.getClassLoader().loadClass(this.f20449a).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new RemoteCreatorException("Could not load creator class.", e2);
                } catch (InstantiationException e3) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e3);
                } catch (IllegalAccessException e4) {
                    throw new RemoteCreatorException("Could not access creator.", e4);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.f20450b;
    }
}
