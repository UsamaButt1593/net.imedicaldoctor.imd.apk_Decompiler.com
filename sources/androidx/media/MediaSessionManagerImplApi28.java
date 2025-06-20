package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplBase;

@RequiresApi(28)
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* renamed from: h  reason: collision with root package name */
    MediaSessionManager f8973h;

    @RequiresApi(28)
    static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {

        /* renamed from: d  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f8974d;

        RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
            this.f8974d = remoteUserInfo;
        }

        static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            return remoteUserInfo.getPackageName();
        }

        RemoteUserInfoImplApi28(String str, int i2, int i3) {
            super(str, i2, i3);
            this.f8974d = i.a(str, i2, i3);
        }
    }

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.f8973h = (MediaSessionManager) context.getSystemService("media_session");
    }

    public boolean a(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return super.a(remoteUserInfoImpl);
    }
}
