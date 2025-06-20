package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DisplayNotification {

    /* renamed from: d  reason: collision with root package name */
    private static final int f24731d = 5;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f24732a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f24733b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationParams f24734c;

    public DisplayNotification(Context context, NotificationParams notificationParams, ExecutorService executorService) {
        this.f24732a = executorService;
        this.f24733b = context;
        this.f24734c = notificationParams;
    }

    private boolean b() {
        if (((KeyguardManager) this.f24733b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.j()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f24733b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.importance == 100;
            }
        }
        return false;
    }

    private void c(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        if (Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "Showing notification");
        }
        ((NotificationManager) this.f24733b.getSystemService("notification")).notify(displayNotificationInfo.f24668b, displayNotificationInfo.f24669c, displayNotificationInfo.f24667a.h());
    }

    @Nullable
    private ImageDownload d() {
        ImageDownload e2 = ImageDownload.e(this.f24734c.p(Constants.MessageNotificationKeys.f24694j));
        if (e2 != null) {
            e2.i(this.f24732a);
        }
        return e2;
    }

    private void e(NotificationCompat.Builder builder, @Nullable ImageDownload imageDownload) {
        if (imageDownload != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.b(imageDownload.f(), 5, TimeUnit.SECONDS);
                builder.b0(bitmap);
                builder.z0(new NotificationCompat.BigPictureStyle().D(bitmap).B((Bitmap) null));
            } catch (ExecutionException e2) {
                Log.w(Constants.f24670a, "Failed to download image: " + e2.getCause());
            } catch (InterruptedException unused) {
                Log.w(Constants.f24670a, "Interrupted while downloading image, showing notification without it");
                imageDownload.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                Log.w(Constants.f24670a, "Failed to download image in time, showing notification without it");
                imageDownload.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f24734c.a(Constants.MessageNotificationKeys.f24690f)) {
            return true;
        }
        if (b()) {
            return false;
        }
        ImageDownload d2 = d();
        CommonNotificationBuilder.DisplayNotificationInfo e2 = CommonNotificationBuilder.e(this.f24733b, this.f24734c);
        e(e2.f24667a, d2);
        c(e2);
        return true;
    }
}
