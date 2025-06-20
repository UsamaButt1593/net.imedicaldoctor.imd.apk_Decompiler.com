package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    /* renamed from: c  reason: collision with root package name */
    private static final String f8975c = "MediaSessionManager";

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f8976d = MediaSessionManager.f8965c;

    /* renamed from: e  reason: collision with root package name */
    private static final String f8977e = "android.permission.STATUS_BAR_SERVICE";

    /* renamed from: f  reason: collision with root package name */
    private static final String f8978f = "android.permission.MEDIA_CONTENT_CONTROL";

    /* renamed from: g  reason: collision with root package name */
    private static final String f8979g = "enabled_notification_listeners";

    /* renamed from: a  reason: collision with root package name */
    Context f8980a;

    /* renamed from: b  reason: collision with root package name */
    ContentResolver f8981b;

    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a  reason: collision with root package name */
        private String f8982a;

        /* renamed from: b  reason: collision with root package name */
        private int f8983b;

        /* renamed from: c  reason: collision with root package name */
        private int f8984c;

        RemoteUserInfoImplBase(String str, int i2, int i3) {
            this.f8982a = str;
            this.f8983b = i2;
            this.f8984c = i3;
        }

        public int b() {
            return this.f8984c;
        }

        public int c() {
            return this.f8983b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            return (this.f8983b < 0 || remoteUserInfoImplBase.f8983b < 0) ? TextUtils.equals(this.f8982a, remoteUserInfoImplBase.f8982a) && this.f8984c == remoteUserInfoImplBase.f8984c : TextUtils.equals(this.f8982a, remoteUserInfoImplBase.f8982a) && this.f8983b == remoteUserInfoImplBase.f8983b && this.f8984c == remoteUserInfoImplBase.f8984c;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f8982a, Integer.valueOf(this.f8984c));
        }

        public String r() {
            return this.f8982a;
        }
    }

    MediaSessionManagerImplBase(Context context) {
        this.f8980a = context;
        this.f8981b = context.getContentResolver();
    }

    private boolean c(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        return remoteUserInfoImpl.c() < 0 ? this.f8980a.getPackageManager().checkPermission(str, remoteUserInfoImpl.r()) == 0 : this.f8980a.checkPermission(str, remoteUserInfoImpl.c(), remoteUserInfoImpl.b()) == 0;
    }

    public boolean a(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        try {
            if (this.f8980a.getPackageManager().getApplicationInfo(remoteUserInfoImpl.r(), 0) == null) {
                return false;
            }
            return c(remoteUserInfoImpl, f8977e) || c(remoteUserInfoImpl, f8978f) || remoteUserInfoImpl.b() == 1000 || b(remoteUserInfoImpl);
        } catch (PackageManager.NameNotFoundException unused) {
            if (f8976d) {
                Log.d(f8975c, "Package " + remoteUserInfoImpl.r() + " doesn't exist");
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.f8981b, f8979g);
        if (string != null) {
            String[] split = string.split(":");
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(remoteUserInfoImpl.r())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Context g() {
        return this.f8980a;
    }
}
