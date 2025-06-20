package androidx.media3.exoplayer.dash;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import java.io.IOException;

final class EventSampleStream implements SampleStream {
    private final EventMessageEncoder X = new EventMessageEncoder();
    private EventStream X2;
    private long[] Y;
    private boolean Y2;
    private boolean Z;
    private int Z2;
    private long a3 = C.f9084b;
    private final Format s;

    public EventSampleStream(EventStream eventStream, Format format, boolean z) {
        this.s = format;
        this.X2 = eventStream;
        this.Y = eventStream.f11163b;
        e(eventStream, z);
    }

    public String a() {
        return this.X2.a();
    }

    public void b() throws IOException {
    }

    public void c(long j2) {
        int j3 = Util.j(this.Y, j2, true, false);
        this.Z2 = j3;
        if (!this.Z || j3 != this.Y.length) {
            j2 = C.f9084b;
        }
        this.a3 = j2;
    }

    public boolean d() {
        return true;
    }

    public void e(EventStream eventStream, boolean z) {
        int i2 = this.Z2;
        long j2 = i2 == 0 ? -9223372036854775807L : this.Y[i2 - 1];
        this.Z = z;
        this.X2 = eventStream;
        long[] jArr = eventStream.f11163b;
        this.Y = jArr;
        long j3 = this.a3;
        if (j3 != C.f9084b) {
            c(j3);
        } else if (j2 != C.f9084b) {
            this.Z2 = Util.j(jArr, j2, false, false);
        }
    }

    public int j(long j2) {
        int max = Math.max(this.Z2, Util.j(this.Y, j2, true, false));
        int i2 = max - this.Z2;
        this.Z2 = max;
        return i2;
    }

    public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        int i3 = this.Z2;
        boolean z = i3 == this.Y.length;
        if (z && !this.Z) {
            decoderInputBuffer.p(4);
            return -4;
        } else if ((i2 & 2) != 0 || !this.Y2) {
            formatHolder.f10226b = this.s;
            this.Y2 = true;
            return -5;
        } else if (z) {
            return -3;
        } else {
            if ((i2 & 1) == 0) {
                this.Z2 = i3 + 1;
            }
            if ((i2 & 4) == 0) {
                byte[] a2 = this.X.a(this.X2.f11162a[i3]);
                decoderInputBuffer.r(a2.length);
                decoderInputBuffer.Z.put(a2);
            }
            decoderInputBuffer.Y2 = this.Y[i3];
            decoderInputBuffer.p(1);
            return -4;
        }
    }
}
