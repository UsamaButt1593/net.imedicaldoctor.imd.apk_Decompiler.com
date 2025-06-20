package com.itextpdf.text.io;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

class ByteBufferRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f25770a;

    public ByteBufferRandomAccessSource(ByteBuffer byteBuffer) {
        this.f25770a = byteBuffer;
    }

    private static boolean c(final ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            /* renamed from: a */
            public Boolean run() {
                Boolean bool = Boolean.FALSE;
                try {
                    Method method = byteBuffer.getClass().getMethod("cleaner", (Class[]) null);
                    method.setAccessible(true);
                    Object invoke = method.invoke(byteBuffer, (Object[]) null);
                    invoke.getClass().getMethod("clean", (Class[]) null).invoke(invoke, (Object[]) null);
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return bool;
                }
            }
        })).booleanValue();
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        if (j2 > 2147483647L) {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        } else if (j2 >= ((long) this.f25770a.limit())) {
            return -1;
        } else {
            this.f25770a.position((int) j2);
            int min = Math.min(i3, this.f25770a.remaining());
            this.f25770a.get(bArr, i2, min);
            return min;
        }
    }

    public int b(long j2) throws IOException {
        if (j2 <= 2147483647L) {
            try {
                if (j2 >= ((long) this.f25770a.limit())) {
                    return -1;
                }
                return this.f25770a.get((int) j2) & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        }
    }

    public void close() throws IOException {
        c(this.f25770a);
    }

    public long length() {
        return (long) this.f25770a.limit();
    }
}
