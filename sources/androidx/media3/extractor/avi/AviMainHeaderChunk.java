package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

final class AviMainHeaderChunk implements AviChunk {

    /* renamed from: e  reason: collision with root package name */
    private static final int f13207e = 16;

    /* renamed from: a  reason: collision with root package name */
    public final int f13208a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13209b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13210c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13211d;

    private AviMainHeaderChunk(int i2, int i3, int i4, int i5) {
        this.f13208a = i2;
        this.f13209b = i3;
        this.f13210c = i4;
        this.f13211d = i5;
    }

    public static AviMainHeaderChunk b(ParsableByteArray parsableByteArray) {
        int w = parsableByteArray.w();
        parsableByteArray.Z(8);
        int w2 = parsableByteArray.w();
        int w3 = parsableByteArray.w();
        parsableByteArray.Z(4);
        int w4 = parsableByteArray.w();
        parsableByteArray.Z(12);
        return new AviMainHeaderChunk(w, w2, w3, w4);
    }

    public boolean a() {
        return (this.f13209b & 16) == 16;
    }

    public int getType() {
        return AviExtractor.x;
    }
}
