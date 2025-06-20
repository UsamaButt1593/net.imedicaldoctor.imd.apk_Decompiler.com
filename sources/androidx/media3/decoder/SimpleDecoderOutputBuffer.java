package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@UnstableApi
public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer {
    private final DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> X2;
    @Nullable
    public ByteBuffer Y2;

    public SimpleDecoderOutputBuffer(DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> owner) {
        this.X2 = owner;
    }

    public void g() {
        super.g();
        ByteBuffer byteBuffer = this.Y2;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void q() {
        this.X2.a(this);
    }

    public ByteBuffer r(int i2) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(this.Y2);
        Assertions.a(i2 >= byteBuffer.limit());
        ByteBuffer order = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        int position = byteBuffer.position();
        byteBuffer.position(0);
        order.put(byteBuffer);
        order.position(position);
        order.limit(i2);
        this.Y2 = order;
        return order;
    }

    public ByteBuffer s(long j2, int i2) {
        this.X = j2;
        ByteBuffer byteBuffer = this.Y2;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.Y2 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        }
        this.Y2.position(0);
        this.Y2.limit(i2);
        return this.Y2;
    }
}
