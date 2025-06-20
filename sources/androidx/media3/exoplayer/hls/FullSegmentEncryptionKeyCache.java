package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map;

final class FullSegmentEncryptionKeyCache {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Uri, byte[]> f11381a;

    public FullSegmentEncryptionKeyCache(int i2) {
        final int i3 = i2;
        this.f11381a = new LinkedHashMap<Uri, byte[]>(i2 + 1, 1.0f, false) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i3;
            }
        };
    }

    public boolean a(Uri uri) {
        return this.f11381a.containsKey(Assertions.g(uri));
    }

    @Nullable
    public byte[] b(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f11381a.get(uri);
    }

    @Nullable
    public byte[] c(Uri uri, byte[] bArr) {
        return this.f11381a.put((Uri) Assertions.g(uri), (byte[]) Assertions.g(bArr));
    }

    @Nullable
    public byte[] d(Uri uri) {
        return this.f11381a.remove(Assertions.g(uri));
    }
}
