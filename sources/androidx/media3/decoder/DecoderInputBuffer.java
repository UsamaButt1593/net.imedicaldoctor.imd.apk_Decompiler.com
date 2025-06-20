package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@UnstableApi
public class DecoderInputBuffer extends Buffer {
    public static final int c3 = 0;
    public static final int d3 = 1;
    public static final int e3 = 2;
    @Nullable
    public Format X;
    public boolean X2;
    public final CryptoInfo Y;
    public long Y2;
    @Nullable
    public ByteBuffer Z;
    @Nullable
    public ByteBuffer Z2;
    private final int a3;
    private final int b3;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int X;
        public final int s;

        public InsufficientCapacityException(int i2, int i3) {
            super("Buffer too small (" + i2 + " < " + i3 + ")");
            this.s = i2;
            this.X = i3;
        }
    }

    static {
        MediaLibraryInfo.a("media3.decoder");
    }

    public DecoderInputBuffer(int i2) {
        this(i2, 0);
    }

    private ByteBuffer q(int i2) {
        int i3 = this.a3;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.Z;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i2);
    }

    public static DecoderInputBuffer v() {
        return new DecoderInputBuffer(0);
    }

    public void g() {
        super.g();
        ByteBuffer byteBuffer = this.Z;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.Z2;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.X2 = false;
    }

    @EnsuresNonNull({"data"})
    public void r(int i2) {
        int i3 = i2 + this.b3;
        ByteBuffer byteBuffer = this.Z;
        if (byteBuffer == null) {
            this.Z = q(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i4 = i3 + position;
        if (capacity >= i4) {
            this.Z = byteBuffer;
            return;
        }
        ByteBuffer q = q(i4);
        q.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            q.put(byteBuffer);
        }
        this.Z = q;
    }

    public final void s() {
        ByteBuffer byteBuffer = this.Z;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.Z2;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean u() {
        return i(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void w(int i2) {
        ByteBuffer byteBuffer = this.Z2;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.Z2 = ByteBuffer.allocate(i2);
        } else {
            this.Z2.clear();
        }
    }

    public DecoderInputBuffer(int i2, int i3) {
        this.Y = new CryptoInfo();
        this.a3 = i2;
        this.b3 = i3;
    }
}
