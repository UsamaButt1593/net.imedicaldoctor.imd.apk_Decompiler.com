package androidx.media3.extractor.mkv;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class Sniffer {

    /* renamed from: c  reason: collision with root package name */
    private static final int f13444c = 1024;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13445d = 440786851;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f13446a = new ParsableByteArray(8);

    /* renamed from: b  reason: collision with root package name */
    private int f13447b;

    private long a(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        extractorInput.s(this.f13446a.e(), 0, 1);
        byte b2 = this.f13446a.e()[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((b2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = b2 & (~i3);
        extractorInput.s(this.f13446a.e(), 1, i4);
        while (i2 < i4) {
            i2++;
            i5 = (this.f13446a.e()[i2] & 255) + (i5 << 8);
        }
        this.f13447b += i4 + 1;
        return (long) i5;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        long a2;
        int i2;
        long length = extractorInput.getLength();
        long j2 = PlaybackStateCompat.p3;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i3 != 0 && length <= PlaybackStateCompat.p3) {
            j2 = length;
        }
        int i4 = (int) j2;
        extractorInput.s(this.f13446a.e(), 0, 4);
        long N = this.f13446a.N();
        this.f13447b = 4;
        while (N != 440786851) {
            int i5 = this.f13447b + 1;
            this.f13447b = i5;
            if (i5 == i4) {
                return false;
            }
            extractorInput.s(this.f13446a.e(), 0, 1);
            N = ((N << 8) & -256) | ((long) (this.f13446a.e()[0] & 255));
        }
        long a3 = a(extractorInput);
        long j3 = (long) this.f13447b;
        if (a3 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j3 + a3 >= length) {
            return false;
        }
        while (true) {
            int i6 = this.f13447b;
            long j4 = j3 + a3;
            if (((long) i6) >= j4) {
                return ((long) i6) == j4;
            }
            if (a(extractorInput) != Long.MIN_VALUE && a2 >= 0 && a2 <= 2147483647L) {
                if (i2 != 0) {
                    int a4 = (int) (a2 = a(extractorInput));
                    extractorInput.j(a4);
                    this.f13447b += a4;
                }
            }
        }
        return false;
    }
}
