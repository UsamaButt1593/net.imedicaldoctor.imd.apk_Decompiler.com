package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

abstract class BufferAllocator {

    /* renamed from: a  reason: collision with root package name */
    private static final BufferAllocator f7020a = new BufferAllocator() {
        public AllocatedBuffer a(int i2) {
            return AllocatedBuffer.j(ByteBuffer.allocateDirect(i2));
        }

        public AllocatedBuffer b(int i2) {
            return AllocatedBuffer.k(new byte[i2]);
        }
    };

    BufferAllocator() {
    }

    public static BufferAllocator c() {
        return f7020a;
    }

    public abstract AllocatedBuffer a(int i2);

    public abstract AllocatedBuffer b(int i2);
}
