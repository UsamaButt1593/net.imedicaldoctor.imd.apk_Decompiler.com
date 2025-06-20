package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import java.io.EOFException;
import java.io.IOException;

@UnstableApi
public final class Id3Peeker {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f13082a = new ParsableByteArray(10);

    @Nullable
    public Metadata a(ExtractorInput extractorInput, @Nullable Id3Decoder.FramePredicate framePredicate) throws IOException {
        Metadata metadata = null;
        int i2 = 0;
        while (true) {
            try {
                extractorInput.s(this.f13082a.e(), 0, 10);
                this.f13082a.Y(0);
                if (this.f13082a.O() != 4801587) {
                    break;
                }
                this.f13082a.Z(3);
                int K = this.f13082a.K();
                int i3 = K + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f13082a.e(), 0, bArr, 0, 10);
                    extractorInput.s(bArr, 10, K);
                    metadata = new Id3Decoder(framePredicate).e(bArr, i3);
                } else {
                    extractorInput.j(K);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        extractorInput.n();
        extractorInput.j(i2);
        return metadata;
    }
}
