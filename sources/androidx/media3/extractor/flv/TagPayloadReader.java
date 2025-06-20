package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;

abstract class TagPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackOutput f13299a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, (Throwable) null, false, 1);
        }
    }

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f13299a = trackOutput;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j2);
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(ParsableByteArray parsableByteArray) throws ParserException;

    /* access modifiers changed from: protected */
    public abstract boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException;

    public abstract void d();
}
