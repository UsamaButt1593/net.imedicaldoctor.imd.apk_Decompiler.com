package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.MpegAudioUtil;

final class XingFrame {

    /* renamed from: g  reason: collision with root package name */
    private static final String f13482g = "XingHeader";

    /* renamed from: a  reason: collision with root package name */
    public final MpegAudioUtil.Header f13483a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13484b;

    /* renamed from: c  reason: collision with root package name */
    public final long f13485c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13486d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13487e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final long[] f13488f;

    private XingFrame(MpegAudioUtil.Header header, long j2, long j3, @Nullable long[] jArr, int i2, int i3) {
        this.f13483a = header;
        this.f13484b = j2;
        this.f13485c = j3;
        this.f13488f = jArr;
        this.f13486d = i2;
        this.f13487e = i3;
    }

    public static XingFrame a(MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        long[] jArr;
        int i2;
        int i3;
        int i4 = header.f13106g;
        int s = parsableByteArray.s();
        int P = (s & 1) != 0 ? parsableByteArray.P() : -1;
        long N = (s & 2) != 0 ? parsableByteArray.N() : -1;
        if ((s & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i5 = 0; i5 < 100; i5++) {
                jArr2[i5] = (long) parsableByteArray.L();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((s & 8) != 0) {
            parsableByteArray.Z(4);
        }
        if (parsableByteArray.a() >= 24) {
            parsableByteArray.Z(21);
            int O = parsableByteArray.O();
            i2 = O & 4095;
            i3 = (16773120 & O) >> 12;
        } else {
            i3 = -1;
            i2 = -1;
        }
        return new XingFrame(header, (long) P, N, jArr, i3, i2);
    }
}
