package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5596a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5597b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5598c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f5599d = 255;

    /* renamed from: e  reason: collision with root package name */
    private static final int f5600e = 1073745919;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(Service service, int i2) {
            service.stopForeground(i2);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(Service service, int i2, Notification notification, int i3) {
            if (!(i3 == 0 || i3 == -1)) {
                i3 &= 255;
            }
            service.startForeground(i2, notification, i3);
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void a(Service service, int i2, Notification notification, int i3) {
            if (!(i3 == 0 || i3 == -1)) {
                i3 &= ServiceCompat.f5600e;
            }
            service.startForeground(i2, notification, i3);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void a(@NonNull Service service, int i2, @NonNull Notification notification, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            Api34Impl.a(service, i2, notification, i3);
        } else if (i4 >= 29) {
            Api29Impl.a(service, i2, notification, i3);
        } else {
            service.startForeground(i2, notification);
        }
    }

    public static void b(@NonNull Service service, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.a(service, i2);
            return;
        }
        boolean z = true;
        if ((i2 & 1) == 0) {
            z = false;
        }
        service.stopForeground(z);
    }
}
