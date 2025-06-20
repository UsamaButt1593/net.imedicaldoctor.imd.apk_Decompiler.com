package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public class TileServiceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static TileServiceWrapper f6152a;

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(TileService tileService, Intent intent) {
            tileService.startActivityAndCollapse(intent);
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void a(TileService tileService, PendingIntent pendingIntent) {
            tileService.startActivityAndCollapse(pendingIntent);
        }
    }

    interface TileServiceWrapper {
        void a(Intent intent);

        void b(PendingIntent pendingIntent);
    }

    private TileServiceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void a() {
        f6152a = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void b(@NonNull TileServiceWrapper tileServiceWrapper) {
        f6152a = tileServiceWrapper;
    }

    public static void c(@NonNull TileService tileService, @NonNull PendingIntentActivityWrapper pendingIntentActivityWrapper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            TileServiceWrapper tileServiceWrapper = f6152a;
            if (tileServiceWrapper != null) {
                tileServiceWrapper.b(pendingIntentActivityWrapper.f());
            } else {
                Api34Impl.a(tileService, pendingIntentActivityWrapper.f());
            }
        } else if (i2 >= 24) {
            TileServiceWrapper tileServiceWrapper2 = f6152a;
            if (tileServiceWrapper2 != null) {
                tileServiceWrapper2.a(pendingIntentActivityWrapper.d());
            } else {
                Api24Impl.a(tileService, pendingIntentActivityWrapper.d());
            }
        }
    }
}
