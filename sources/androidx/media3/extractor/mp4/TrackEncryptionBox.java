package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class TrackEncryptionBox {

    /* renamed from: f  reason: collision with root package name */
    private static final String f13669f = "TrackEncryptionBox";

    /* renamed from: a  reason: collision with root package name */
    public final boolean f13670a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f13671b;

    /* renamed from: c  reason: collision with root package name */
    public final TrackOutput.CryptoData f13672c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13673d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f13674e;

    public TrackEncryptionBox(boolean z, @Nullable String str, int i2, byte[] bArr, int i3, int i4, @Nullable byte[] bArr2) {
        boolean z2 = false;
        Assertions.a((bArr2 == null ? true : z2) ^ (i2 == 0));
        this.f13670a = z;
        this.f13671b = str;
        this.f13673d = i2;
        this.f13674e = bArr2;
        this.f13672c = new TrackOutput.CryptoData(a(str), bArr, i3, i4);
    }

    private static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.e2)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C.g2)) {
                    c2 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C.d2)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C.f2)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                Log.n(f13669f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                break;
        }
        return 1;
    }
}
