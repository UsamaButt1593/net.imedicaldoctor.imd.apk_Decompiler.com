package androidx.media3.extractor.avi;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;

final class AviStreamHeaderChunk implements AviChunk {

    /* renamed from: g  reason: collision with root package name */
    private static final String f13212g = "AviStreamHeaderChunk";

    /* renamed from: a  reason: collision with root package name */
    public final int f13213a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13214b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13215c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13216d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13217e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13218f;

    private AviStreamHeaderChunk(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f13213a = i2;
        this.f13214b = i3;
        this.f13215c = i4;
        this.f13216d = i5;
        this.f13217e = i6;
        this.f13218f = i7;
    }

    public static AviStreamHeaderChunk d(ParsableByteArray parsableByteArray) {
        int w = parsableByteArray.w();
        parsableByteArray.Z(12);
        int w2 = parsableByteArray.w();
        int w3 = parsableByteArray.w();
        int w4 = parsableByteArray.w();
        parsableByteArray.Z(4);
        int w5 = parsableByteArray.w();
        int w6 = parsableByteArray.w();
        parsableByteArray.Z(8);
        return new AviStreamHeaderChunk(w, w2, w3, w4, w5, w6);
    }

    public long a() {
        return Util.c2((long) this.f13217e, ((long) this.f13215c) * 1000000, (long) this.f13216d);
    }

    public float b() {
        return ((float) this.f13216d) / ((float) this.f13215c);
    }

    public int c() {
        int i2 = this.f13213a;
        if (i2 == 1935960438) {
            return 2;
        }
        if (i2 == 1935963489) {
            return 1;
        }
        if (i2 == 1937012852) {
            return 3;
        }
        Log.n(f13212g, "Found unsupported streamType fourCC: " + Integer.toHexString(this.f13213a));
        return -1;
    }

    public int getType() {
        return AviExtractor.F;
    }
}
