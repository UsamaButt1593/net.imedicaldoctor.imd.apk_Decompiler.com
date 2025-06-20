package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;

@UnstableApi
public class VideoDecoderOutputBuffer extends DecoderOutputBuffer {
    public static final int i3 = 0;
    public static final int j3 = 1;
    public static final int k3 = 2;
    public static final int l3 = 3;
    public int X2;
    public int Y2;
    @Nullable
    public ByteBuffer Z2;
    public int a3;
    public int b3;
    @Nullable
    public Format c3;
    @Nullable
    public ByteBuffer[] d3;
    @Nullable
    public int[] e3;
    public int f3;
    @Nullable
    public ByteBuffer g3;
    private final DecoderOutputBuffer.Owner<VideoDecoderOutputBuffer> h3;

    public VideoDecoderOutputBuffer(DecoderOutputBuffer.Owner<VideoDecoderOutputBuffer> owner) {
        this.h3 = owner;
    }

    private static boolean v(int i2, int i4) {
        return i2 >= 0 && i4 >= 0 && (i4 <= 0 || i2 < Integer.MAX_VALUE / i4);
    }

    public void q() {
        this.h3.a(this);
    }

    public void r(long j2, int i2, @Nullable ByteBuffer byteBuffer) {
        this.X = j2;
        this.Y2 = i2;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.g3 = null;
            return;
        }
        f(268435456);
        int limit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.g3;
        if (byteBuffer2 == null || byteBuffer2.capacity() < limit) {
            this.g3 = ByteBuffer.allocate(limit);
        } else {
            this.g3.clear();
        }
        this.g3.put(byteBuffer);
        this.g3.flip();
        byteBuffer.position(0);
    }

    public void s(int i2, int i4) {
        this.a3 = i2;
        this.b3 = i4;
    }

    public boolean u(int i2, int i4, int i5, int i6, int i7) {
        this.a3 = i2;
        this.b3 = i4;
        this.f3 = i7;
        int i8 = (int) ((((long) i4) + 1) / 2);
        if (v(i5, i4) && v(i6, i8)) {
            int i9 = i4 * i5;
            int i10 = i8 * i6;
            int i11 = (i10 * 2) + i9;
            if (v(i10, 2) && i11 >= i9) {
                ByteBuffer byteBuffer = this.Z2;
                if (byteBuffer == null || byteBuffer.capacity() < i11) {
                    this.Z2 = ByteBuffer.allocateDirect(i11);
                } else {
                    this.Z2.position(0);
                    this.Z2.limit(i11);
                }
                if (this.d3 == null) {
                    this.d3 = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.Z2;
                ByteBuffer[] byteBufferArr = this.d3;
                ByteBuffer slice = byteBuffer2.slice();
                byteBufferArr[0] = slice;
                slice.limit(i9);
                byteBuffer2.position(i9);
                ByteBuffer slice2 = byteBuffer2.slice();
                byteBufferArr[1] = slice2;
                slice2.limit(i10);
                byteBuffer2.position(i9 + i10);
                ByteBuffer slice3 = byteBuffer2.slice();
                byteBufferArr[2] = slice3;
                slice3.limit(i10);
                if (this.e3 == null) {
                    this.e3 = new int[3];
                }
                int[] iArr = this.e3;
                iArr[0] = i5;
                iArr[1] = i6;
                iArr[2] = i6;
                return true;
            }
        }
        return false;
    }
}
