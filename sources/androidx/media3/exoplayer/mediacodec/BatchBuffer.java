package androidx.media3.exoplayer.mediacodec;

import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

final class BatchBuffer extends DecoderInputBuffer {
    public static final int i3 = 32;
    @VisibleForTesting
    static final int j3 = 3072000;
    private long f3;
    private int g3;
    private int h3 = 32;

    public BatchBuffer() {
        super(2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r4.Z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean y(androidx.media3.decoder.DecoderInputBuffer r5) {
        /*
            r4 = this;
            boolean r0 = r4.D()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r4.g3
            int r2 = r4.h3
            r3 = 0
            if (r0 < r2) goto L_0x0010
            return r3
        L_0x0010:
            java.nio.ByteBuffer r5 = r5.Z
            if (r5 == 0) goto L_0x0027
            java.nio.ByteBuffer r0 = r4.Z
            if (r0 == 0) goto L_0x0027
            int r0 = r0.position()
            int r5 = r5.remaining()
            int r0 = r0 + r5
            r5 = 3072000(0x2ee000, float:4.304789E-39)
            if (r0 <= r5) goto L_0x0027
            return r3
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.BatchBuffer.y(androidx.media3.decoder.DecoderInputBuffer):boolean");
    }

    public long A() {
        return this.f3;
    }

    public int C() {
        return this.g3;
    }

    public boolean D() {
        return this.g3 > 0;
    }

    public void E(@IntRange(from = 1) int i2) {
        Assertions.a(i2 > 0);
        this.h3 = i2;
    }

    public void g() {
        super.g();
        this.g3 = 0;
    }

    public boolean x(DecoderInputBuffer decoderInputBuffer) {
        Assertions.a(!decoderInputBuffer.u());
        Assertions.a(!decoderInputBuffer.j());
        Assertions.a(!decoderInputBuffer.l());
        if (!y(decoderInputBuffer)) {
            return false;
        }
        int i2 = this.g3;
        this.g3 = i2 + 1;
        if (i2 == 0) {
            this.Y2 = decoderInputBuffer.Y2;
            if (decoderInputBuffer.n()) {
                p(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.Z;
        if (byteBuffer != null) {
            r(byteBuffer.remaining());
            this.Z.put(byteBuffer);
        }
        this.f3 = decoderInputBuffer.Y2;
        return true;
    }

    public long z() {
        return this.Y2;
    }
}
