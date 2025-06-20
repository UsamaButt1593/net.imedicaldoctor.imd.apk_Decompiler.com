package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;

@UnstableApi
public final class Ac4Util {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12912a = 44096;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12913b = 44097;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12914c = 336000;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12915d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12916e = 7;

    /* renamed from: f  reason: collision with root package name */
    public static final int f12917f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f12918g = {PlaybackException.c3, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static final class SyncFrameInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f12919a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12920b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12921c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12922d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12923e;

        private SyncFrameInfo(int i2, int i3, int i4, int i5, int i6) {
            this.f12919a = i2;
            this.f12921c = i3;
            this.f12920b = i4;
            this.f12922d = i5;
            this.f12923e = i6;
        }
    }

    private Ac4Util() {
    }

    public static void a(int i2, ParsableByteArray parsableByteArray) {
        parsableByteArray.U(7);
        byte[] e2 = parsableByteArray.e();
        e2[0] = -84;
        e2[1] = SignedBytes.f22967a;
        e2[2] = -1;
        e2[3] = -1;
        e2[4] = (byte) ((i2 >> 16) & 255);
        e2[5] = (byte) ((i2 >> 8) & 255);
        e2[6] = (byte) (i2 & 255);
    }

    public static Format b(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        parsableByteArray.Z(1);
        return new Format.Builder().X(str).k0(MimeTypes.T).L(2).l0(((parsableByteArray.L() & 32) >> 5) == 1 ? OpusUtil.f13107a : 44100).R(drmInitData).b0(str2).I();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new ParsableBitArray(bArr)).f12923e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r11 != 11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        if (r11 != 11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        if (r11 != 8) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.extractor.Ac4Util.SyncFrameInfo d(androidx.media3.common.util.ParsableBitArray r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = 4
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L_0x002f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L_0x002f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L_0x0045
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L_0x0045
            r11.s(r0)
        L_0x0045:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L_0x0055
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0058
        L_0x0055:
            r9 = 44100(0xac44, float:6.1797E-41)
        L_0x0058:
            int r11 = r11.h(r3)
            if (r9 != r6) goto L_0x0067
            r4 = 13
            if (r11 != r4) goto L_0x0067
            int[] r0 = f12918g
            r11 = r0[r11]
            goto L_0x0095
        L_0x0067:
            if (r9 != r7) goto L_0x0094
            int[] r4 = f12918g
            int r6 = r4.length
            if (r11 >= r6) goto L_0x0094
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L_0x008f
            r7 = 11
            if (r1 == r0) goto L_0x008a
            if (r1 == r2) goto L_0x008f
            if (r1 == r3) goto L_0x0080
            goto L_0x0088
        L_0x0080:
            if (r11 == r2) goto L_0x0086
            if (r11 == r6) goto L_0x0086
            if (r11 != r7) goto L_0x0088
        L_0x0086:
            int r4 = r4 + 1
        L_0x0088:
            r11 = r4
            goto L_0x0095
        L_0x008a:
            if (r11 == r6) goto L_0x0086
            if (r11 != r7) goto L_0x0088
            goto L_0x0086
        L_0x008f:
            if (r11 == r2) goto L_0x0086
            if (r11 != r6) goto L_0x0088
            goto L_0x0086
        L_0x0094:
            r11 = 0
        L_0x0095:
            androidx.media3.extractor.Ac4Util$SyncFrameInfo r0 = new androidx.media3.extractor.Ac4Util$SyncFrameInfo
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.Ac4Util.d(androidx.media3.common.util.ParsableBitArray):androidx.media3.extractor.Ac4Util$SyncFrameInfo");
    }

    public static int e(byte[] bArr, int i2) {
        int i3 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b2 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (b2 == 65535) {
            b2 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i3 = 4;
        }
        if (i2 == 44097) {
            i3 += 2;
        }
        return b2 + i3;
    }

    private static int f(ParsableBitArray parsableBitArray, int i2) {
        int i3 = 0;
        while (true) {
            int h2 = i3 + parsableBitArray.h(i2);
            if (!parsableBitArray.g()) {
                return h2;
            }
            i3 = (h2 + 1) << i2;
        }
    }
}
