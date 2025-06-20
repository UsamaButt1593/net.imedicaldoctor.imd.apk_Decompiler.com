package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AlarmManagerCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static AlarmManager.AlarmClockInfo a(long j2, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j2, pendingIntent);
        }

        @DoNotInline
        static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void a(AlarmManager alarmManager, int i2, long j2, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i2, j2, pendingIntent);
        }

        @DoNotInline
        static void b(AlarmManager alarmManager, int i2, long j2, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i2, j2, pendingIntent);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean a(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean a(@NonNull AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(alarmManager);
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static void b(@NonNull AlarmManager alarmManager, long j2, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        Api21Impl.b(alarmManager, Api21Impl.a(j2, pendingIntent), pendingIntent2);
    }

    public static void c(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(alarmManager, i2, j2, pendingIntent);
        } else {
            alarmManager.set(i2, j2, pendingIntent);
        }
    }

    public static void d(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i2, j2, pendingIntent);
    }

    public static void e(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.b(alarmManager, i2, j2, pendingIntent);
        } else {
            d(alarmManager, i2, j2, pendingIntent);
        }
    }
}
