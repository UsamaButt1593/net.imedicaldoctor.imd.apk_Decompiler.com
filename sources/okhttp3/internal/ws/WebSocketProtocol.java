package okhttp3.internal.ws;

import okio.Buffer;
import okio.ByteString;

public final class WebSocketProtocol {

    /* renamed from: a  reason: collision with root package name */
    static final String f31300a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b  reason: collision with root package name */
    static final int f31301b = 128;

    /* renamed from: c  reason: collision with root package name */
    static final int f31302c = 64;

    /* renamed from: d  reason: collision with root package name */
    static final int f31303d = 32;

    /* renamed from: e  reason: collision with root package name */
    static final int f31304e = 16;

    /* renamed from: f  reason: collision with root package name */
    static final int f31305f = 15;

    /* renamed from: g  reason: collision with root package name */
    static final int f31306g = 8;

    /* renamed from: h  reason: collision with root package name */
    static final int f31307h = 128;

    /* renamed from: i  reason: collision with root package name */
    static final int f31308i = 127;

    /* renamed from: j  reason: collision with root package name */
    static final int f31309j = 0;

    /* renamed from: k  reason: collision with root package name */
    static final int f31310k = 1;

    /* renamed from: l  reason: collision with root package name */
    static final int f31311l = 2;

    /* renamed from: m  reason: collision with root package name */
    static final int f31312m = 8;

    /* renamed from: n  reason: collision with root package name */
    static final int f31313n = 9;
    static final int o = 10;
    static final long p = 125;
    static final long q = 123;
    static final int r = 126;
    static final long s = 65535;
    static final int t = 127;
    static final int u = 1001;
    static final int v = 1005;

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }

    public static String a(String str) {
        return ByteString.n(str + f31300a).i0().e();
    }

    static String b(int i2) {
        StringBuilder sb;
        if (i2 < 1000 || i2 >= 5000) {
            sb = new StringBuilder();
            sb.append("Code must be in range [1000,5000): ");
            sb.append(i2);
        } else if ((i2 < 1004 || i2 > 1006) && (i2 < 1012 || i2 > 2999)) {
            return null;
        } else {
            sb = new StringBuilder();
            sb.append("Code ");
            sb.append(i2);
            sb.append(" is reserved and may not be used.");
        }
        return sb.toString();
    }

    static void c(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        do {
            byte[] bArr2 = unsafeCursor.X2;
            int i3 = unsafeCursor.Y2;
            int i4 = unsafeCursor.Z2;
            while (i3 < i4) {
                int i5 = i2 % length;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i5]);
                i3++;
                i2 = i5 + 1;
            }
        } while (unsafeCursor.d() != -1);
    }

    static void d(int i2) {
        String b2 = b(i2);
        if (b2 != null) {
            throw new IllegalArgumentException(b2);
        }
    }
}
