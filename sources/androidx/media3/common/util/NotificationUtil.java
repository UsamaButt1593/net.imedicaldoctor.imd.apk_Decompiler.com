package androidx.media3.common.util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
@SuppressLint({"InlinedApi"})
public final class NotificationUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9601a = -1000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9602b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9603c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9604d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9605e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9606f = 4;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    private NotificationUtil() {
    }

    public static void a(Context context, String str, @StringRes int i2, @StringRes int i3, int i4) {
        if (Util.f9646a >= 26) {
            NotificationManager notificationManager = (NotificationManager) Assertions.g((NotificationManager) context.getSystemService("notification"));
            l.a();
            NotificationChannel a2 = k.a(str, context.getString(i2), i4);
            if (i3 != 0) {
                a2.setDescription(context.getString(i3));
            }
            notificationManager.createNotificationChannel(a2);
        }
    }

    public static void b(Context context, int i2, @Nullable Notification notification) {
        NotificationManager notificationManager = (NotificationManager) Assertions.g((NotificationManager) context.getSystemService("notification"));
        if (notification != null) {
            notificationManager.notify(i2, notification);
        } else {
            notificationManager.cancel(i2);
        }
    }
}
