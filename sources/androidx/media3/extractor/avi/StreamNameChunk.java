package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

final class StreamNameChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f13237a;

    private StreamNameChunk(String str) {
        this.f13237a = str;
    }

    public static StreamNameChunk a(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.I(parsableByteArray.a()));
    }

    public int getType() {
        return AviExtractor.E;
    }
}
