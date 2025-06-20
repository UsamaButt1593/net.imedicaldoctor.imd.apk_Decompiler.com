package androidx.media3.common.util;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import com.google.common.util.concurrent.ListenableFuture;

@UnstableApi
public interface BitmapLoader {
    ListenableFuture<Bitmap> a(Uri uri);

    boolean b(String str);

    ListenableFuture<Bitmap> c(byte[] bArr);

    @Nullable
    ListenableFuture<Bitmap> d(MediaMetadata mediaMetadata);
}
