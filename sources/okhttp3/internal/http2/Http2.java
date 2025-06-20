package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {

    /* renamed from: a  reason: collision with root package name */
    static final ByteString f31156a = ByteString.n("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    static final int f31157b = 16384;

    /* renamed from: c  reason: collision with root package name */
    static final byte f31158c = 0;

    /* renamed from: d  reason: collision with root package name */
    static final byte f31159d = 1;

    /* renamed from: e  reason: collision with root package name */
    static final byte f31160e = 2;

    /* renamed from: f  reason: collision with root package name */
    static final byte f31161f = 3;

    /* renamed from: g  reason: collision with root package name */
    static final byte f31162g = 4;

    /* renamed from: h  reason: collision with root package name */
    static final byte f31163h = 5;

    /* renamed from: i  reason: collision with root package name */
    static final byte f31164i = 6;

    /* renamed from: j  reason: collision with root package name */
    static final byte f31165j = 7;

    /* renamed from: k  reason: collision with root package name */
    static final byte f31166k = 8;

    /* renamed from: l  reason: collision with root package name */
    static final byte f31167l = 9;

    /* renamed from: m  reason: collision with root package name */
    static final byte f31168m = 0;

    /* renamed from: n  reason: collision with root package name */
    static final byte f31169n = 1;
    static final byte o = 1;
    static final byte p = 4;
    static final byte q = 4;
    static final byte r = 8;
    static final byte s = 32;
    static final byte t = 32;
    private static final String[] u = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] v = new String[64];
    static final String[] w = new String[256];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = w;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = Util.s("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = v;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i4 = iArr[0];
        strArr2[i4 | 8] = strArr2[i4] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            int i7 = iArr[0];
            String[] strArr3 = v;
            int i8 = i7 | i6;
            strArr3[i8] = strArr3[i7] + '|' + strArr3[i6];
            strArr3[i8 | 8] = strArr3[i7] + '|' + strArr3[i6] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = v;
            if (i2 < strArr4.length) {
                if (strArr4[i2] == null) {
                    strArr4[i2] = w[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private Http2() {
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : w[b3];
            }
            if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = v;
                String str = b3 < strArr.length ? strArr[b3] : w[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return w[b3];
    }

    static String b(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = u;
        return Util.s("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), b2 < strArr.length ? strArr[b2] : Util.s("0x%02x", Byte.valueOf(b2)), a(b2, b3));
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.s(str, objArr));
    }

    static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(Util.s(str, objArr));
    }
}
