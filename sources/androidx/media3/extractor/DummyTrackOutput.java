package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;
import java.io.IOException;

@UnstableApi
public final class DummyTrackOutput implements TrackOutput {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f13035d = new byte[4096];

    public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        parsableByteArray.Z(i2);
    }

    public /* synthetic */ int b(DataReader dataReader, int i2, boolean z) {
        return g.a(this, dataReader, i2, z);
    }

    public int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException {
        int read = dataReader.read(this.f13035d, 0, Math.min(this.f13035d.length, i2));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public void e(Format format) {
    }

    public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
    }
}
