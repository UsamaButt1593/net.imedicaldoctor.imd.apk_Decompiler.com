package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class ByteBufferUtil {
    public static int a(ByteBuffer byteBuffer) {
        return byteBuffer.getInt(byteBuffer.position());
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(duplicate.position() + 4);
        return duplicate;
    }
}
