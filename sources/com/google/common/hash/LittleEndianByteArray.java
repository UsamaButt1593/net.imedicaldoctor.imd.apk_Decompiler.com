package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.primitives.Longs;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
final class LittleEndianByteArray {

    /* renamed from: a  reason: collision with root package name */
    private static final LittleEndianBytes f22682a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22683b = false;

    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE {
            public long a(byte[] bArr, int i2) {
                return Longs.k(bArr[i2 + 7], bArr[i2 + 6], bArr[i2 + 5], bArr[i2 + 4], bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]);
            }

            public void b(byte[] bArr, int i2, long j2) {
                long j3 = 255;
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i2 + i3] = (byte) ((int) ((j2 & j3) >> (i3 * 8)));
                    j3 <<= 8;
                }
            }
        }
    }

    private interface LittleEndianBytes {
        long a(byte[] bArr, int i2);

        void b(byte[] bArr, int i2, long j2);
    }

    private enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN {
            public long a(byte[] bArr, int i2) {
                return UnsafeByteArray.Y.getLong(bArr, ((long) i2) + ((long) UnsafeByteArray.Z));
            }

            public void b(byte[] bArr, int i2, long j2) {
                UnsafeByteArray.Y.putLong(bArr, ((long) i2) + ((long) UnsafeByteArray.Z), j2);
            }
        },
        UNSAFE_BIG_ENDIAN {
            public long a(byte[] bArr, int i2) {
                return Long.reverseBytes(UnsafeByteArray.Y.getLong(bArr, ((long) i2) + ((long) UnsafeByteArray.Z)));
            }

            public void b(byte[] bArr, int i2, long j2) {
                long reverseBytes = Long.reverseBytes(j2);
                UnsafeByteArray.Y.putLong(bArr, ((long) i2) + ((long) UnsafeByteArray.Z), reverseBytes);
            }
        };
        
        /* access modifiers changed from: private */
        public static final Unsafe Y = null;
        /* access modifiers changed from: private */
        public static final int Z = 0;

        static {
            Unsafe h2 = h();
            Y = h2;
            Class<byte[]> cls = byte[].class;
            Z = h2.arrayBaseOffset(cls);
            if (h2.arrayIndexScale(cls) != 1) {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.b());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static sun.misc.Unsafe h() {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                return r0
            L_0x0005:
                com.google.common.hash.b r0 = new com.google.common.hash.b     // Catch:{ PrivilegedActionException -> 0x0011 }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                return r0
            L_0x0011:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.h():sun.misc.Unsafe");
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        f22682a = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }

    static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << Ascii.B) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static long b(byte[] bArr, int i2) {
        return f22682a.a(bArr, i2);
    }

    static long c(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, 8);
        long j2 = 0;
        for (int i4 = 0; i4 < min; i4++) {
            j2 |= (((long) bArr[i2 + i4]) & 255) << (i4 * 8);
        }
        return j2;
    }

    static void d(byte[] bArr, int i2, long j2) {
        f22682a.b(bArr, i2, j2);
    }

    static boolean e() {
        return f22682a instanceof UnsafeByteArray;
    }
}
