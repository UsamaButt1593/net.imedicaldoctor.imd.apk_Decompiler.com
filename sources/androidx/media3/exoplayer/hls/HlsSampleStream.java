package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {
    private final HlsSampleStreamWrapper X;
    private int Y = -1;
    private final int s;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i2) {
        this.X = hlsSampleStreamWrapper;
        this.s = i2;
    }

    private boolean c() {
        int i2 = this.Y;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    public void a() {
        Assertions.a(this.Y == -1);
        this.Y = this.X.x(this.s);
    }

    public void b() throws IOException {
        int i2 = this.Y;
        if (i2 == -2) {
            throw new SampleQueueMappingException(this.X.s().d(this.s).d(0).f3);
        } else if (i2 == -1) {
            this.X.V();
        } else if (i2 != -3) {
            this.X.W(i2);
        }
    }

    public boolean d() {
        return this.Y == -3 || (c() && this.X.R(this.Y));
    }

    public void e() {
        if (this.Y != -1) {
            this.X.r0(this.s);
            this.Y = -1;
        }
    }

    public int j(long j2) {
        if (c()) {
            return this.X.q0(this.Y, j2);
        }
        return 0;
    }

    public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (this.Y == -3) {
            decoderInputBuffer.f(4);
            return -4;
        } else if (c()) {
            return this.X.g0(this.Y, formatHolder, decoderInputBuffer, i2);
        } else {
            return -3;
        }
    }
}
