package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

final class ByteBufferWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7021a = 1024;

    /* renamed from: b  reason: collision with root package name */
    private static final int f7022b = 16384;

    /* renamed from: c  reason: collision with root package name */
    private static final float f7023c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f7024d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Class<?> f7025e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f7026f;

    static {
        Class<?> f2 = f("java.io.FileOutputStream");
        f7025e = f2;
        f7026f = c(f2);
    }

    private ByteBufferWriter() {
    }

    static void a() {
        f7024d.set((Object) null);
    }

    private static byte[] b() {
        SoftReference softReference = f7024d.get();
        if (softReference == null) {
            return null;
        }
        return (byte[]) softReference.get();
    }

    private static long c(Class<?> cls) {
        if (cls == null) {
            return -1;
        }
        try {
            if (UnsafeUtil.S()) {
                return UnsafeUtil.W(cls.getDeclaredField("channel"));
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static byte[] d(int i2) {
        int max = Math.max(i2, 1024);
        byte[] b2 = b();
        if (b2 == null || e(max, b2.length)) {
            b2 = new byte[max];
            if (max <= 16384) {
                g(b2);
            }
        }
        return b2;
    }

    private static boolean e(int i2, int i3) {
        return i3 < i2 && ((float) i3) < ((float) i2) * 0.5f;
    }

    private static Class<?> f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void g(byte[] bArr) {
        f7024d.set(new SoftReference(bArr));
    }

    static void h(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!i(byteBuffer, outputStream)) {
                byte[] d2 = d(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), d2.length);
                    byteBuffer.get(d2, 0, min);
                    outputStream.write(d2, 0, min);
                }
            }
        } finally {
            byteBuffer.position(position);
        }
    }

    private static boolean i(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannel;
        long j2 = f7026f;
        if (j2 < 0 || !f7025e.isInstance(outputStream)) {
            return false;
        }
        try {
            writableByteChannel = (WritableByteChannel) UnsafeUtil.O(outputStream, j2);
        } catch (ClassCastException unused) {
            writableByteChannel = null;
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
