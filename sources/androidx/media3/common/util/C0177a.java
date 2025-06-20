package androidx.media3.common.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: androidx.media3.common.util.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0177a {
    @Nullable
    public static ListenableFuture a(BitmapLoader bitmapLoader, MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.c3;
        if (bArr != null) {
            return bitmapLoader.c(bArr);
        }
        Uri uri = mediaMetadata.e3;
        if (uri != null) {
            return bitmapLoader.a(uri);
        }
        return null;
    }
}
