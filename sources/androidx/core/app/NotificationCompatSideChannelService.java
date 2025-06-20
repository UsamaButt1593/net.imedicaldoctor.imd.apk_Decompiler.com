package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.annotation.DeprecatedSinceApi;

public abstract class NotificationCompatSideChannelService extends Service {

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        NotificationSideChannelStub() {
        }

        public void G0(String str, int i2, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.a(str, i2, str2);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void Y0(String str, int i2, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.d(str, i2, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void c0(String str) {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.b(str);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void a(String str, int i2, String str2);

    public abstract void b(String str);

    /* access modifiers changed from: package-private */
    public void c(int i2, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i2);
        int length = packagesForUid.length;
        int i3 = 0;
        while (i3 < length) {
            if (!packagesForUid[i3].equals(str)) {
                i3++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i2 + " is not authorized for package " + str);
    }

    public abstract void d(String str, int i2, String str2, Notification notification);

    @DeprecatedSinceApi(api = 19, message = "SDKs past 19 have no need for side channeling.")
    public IBinder onBind(Intent intent) {
        intent.getAction().equals(NotificationManagerCompat.f5521g);
        return null;
    }
}
