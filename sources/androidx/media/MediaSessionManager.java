package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

public final class MediaSessionManager {

    /* renamed from: b  reason: collision with root package name */
    static final String f8964b = "MediaSessionManager";

    /* renamed from: c  reason: collision with root package name */
    static final boolean f8965c = Log.isLoggable(f8964b, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final Object f8966d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static volatile MediaSessionManager f8967e;

    /* renamed from: a  reason: collision with root package name */
    MediaSessionManagerImpl f8968a;

    interface MediaSessionManagerImpl {
        boolean a(RemoteUserInfoImpl remoteUserInfoImpl);

        Context g();
    }

    public static final class RemoteUserInfo {

        /* renamed from: b  reason: collision with root package name */
        public static final String f8969b = "android.media.session.MediaController";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: c  reason: collision with root package name */
        public static final int f8970c = -1;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: d  reason: collision with root package name */
        public static final int f8971d = -1;

        /* renamed from: a  reason: collision with root package name */
        RemoteUserInfoImpl f8972a;

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String a2 = MediaSessionManagerImplApi28.RemoteUserInfoImplApi28.a(remoteUserInfo);
            if (a2 == null) {
                throw new NullPointerException("package shouldn't be null");
            } else if (!TextUtils.isEmpty(a2)) {
                this.f8972a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
            } else {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
        }

        @NonNull
        public String a() {
            return this.f8972a.r();
        }

        public int b() {
            return this.f8972a.c();
        }

        public int c() {
            return this.f8972a.b();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f8972a.equals(((RemoteUserInfo) obj).f8972a);
        }

        public int hashCode() {
            return this.f8972a.hashCode();
        }

        public RemoteUserInfo(@NonNull String str, int i2, int i3) {
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            } else if (!TextUtils.isEmpty(str)) {
                this.f8972a = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i2, i3) : new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i2, i3);
            } else {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
        }
    }

    interface RemoteUserInfoImpl {
        int b();

        int c();

        String r();
    }

    private MediaSessionManager(Context context) {
        this.f8968a = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28(context) : new MediaSessionManagerImplApi21(context);
    }

    @NonNull
    public static MediaSessionManager b(@NonNull Context context) {
        MediaSessionManager mediaSessionManager;
        if (context != null) {
            synchronized (f8966d) {
                try {
                    if (f8967e == null) {
                        f8967e = new MediaSessionManager(context.getApplicationContext());
                    }
                    mediaSessionManager = f8967e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return mediaSessionManager;
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public Context a() {
        return this.f8968a.g();
    }

    public boolean c(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f8968a.a(remoteUserInfo.f8972a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
