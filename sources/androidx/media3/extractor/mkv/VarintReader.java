package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {

    /* renamed from: d  reason: collision with root package name */
    private static final int f13448d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13449e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f13450f = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13451a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private int f13452b;

    /* renamed from: c  reason: collision with root package name */
    private int f13453c;

    public static long a(byte[] bArr, int i2, boolean z) {
        long j2 = ((long) bArr[0]) & 255;
        if (z) {
            j2 &= ~f13450f[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public static int c(int i2) {
        int i3;
        int i4 = 0;
        do {
            long[] jArr = f13450f;
            if (i4 >= jArr.length) {
                return -1;
            }
            i3 = ((jArr[i4] & ((long) i2)) > 0 ? 1 : ((jArr[i4] & ((long) i2)) == 0 ? 0 : -1));
            i4++;
        } while (i3 == 0);
        return i4;
    }

    public int b() {
        return this.f13453c;
    }

    public long d(ExtractorInput extractorInput, boolean z, boolean z2, int i2) throws IOException {
        if (this.f13452b == 0) {
            if (!extractorInput.d(this.f13451a, 0, 1, z)) {
                return -1;
            }
            int c2 = c(this.f13451a[0] & 255);
            this.f13453c = c2;
            if (c2 != -1) {
                this.f13452b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f13453c;
        if (i3 > i2) {
            this.f13452b = 0;
            return -2;
        }
        if (i3 != 1) {
            extractorInput.readFully(this.f13451a, 1, i3 - 1);
        }
        this.f13452b = 0;
        return a(this.f13451a, this.f13453c, z2);
    }

    public void e() {
        this.f13452b = 0;
        this.f13453c = 0;
    }
}
