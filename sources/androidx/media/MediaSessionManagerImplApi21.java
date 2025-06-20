package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManager;

@RequiresApi(21)
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.f8980a = context;
    }

    private boolean d(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return g().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.c(), remoteUserInfoImpl.b()) == 0;
    }

    public boolean a(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return d(remoteUserInfoImpl) || super.a(remoteUserInfoImpl);
    }
}
