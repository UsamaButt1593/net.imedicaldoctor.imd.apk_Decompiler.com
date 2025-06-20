package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import java.util.UUID;

@UnstableApi
public final class FrameworkCryptoConfig implements CryptoConfig {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f11330d;

    /* renamed from: a  reason: collision with root package name */
    public final UUID f11331a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f11332b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11333c;

    static {
        boolean z;
        if ("Amazon".equals(Util.f9648c)) {
            String str = Util.f9649d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
                f11330d = z;
            }
        }
        z = false;
        f11330d = z;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z) {
        this.f11331a = uuid;
        this.f11332b = bArr;
        this.f11333c = z;
    }
}
