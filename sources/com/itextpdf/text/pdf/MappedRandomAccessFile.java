package com.itextpdf.text.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MappedRandomAccessFile {

    /* renamed from: e  reason: collision with root package name */
    private static final int f26092e = 1073741824;

    /* renamed from: a  reason: collision with root package name */
    private FileChannel f26093a = null;

    /* renamed from: b  reason: collision with root package name */
    private MappedByteBuffer[] f26094b;

    /* renamed from: c  reason: collision with root package name */
    private long f26095c;

    /* renamed from: d  reason: collision with root package name */
    private long f26096d;

    public MappedRandomAccessFile(String str, String str2) throws FileNotFoundException, IOException {
        FileChannel channel;
        FileChannel.MapMode mapMode;
        if (str2.equals("rw")) {
            channel = new RandomAccessFile(str, str2).getChannel();
            mapMode = FileChannel.MapMode.READ_WRITE;
        } else {
            channel = new FileInputStream(str).getChannel();
            mapMode = FileChannel.MapMode.READ_ONLY;
        }
        e(channel, mapMode);
    }

    public static boolean a(final ByteBuffer byteBuffer) {
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

    private void e(FileChannel fileChannel, FileChannel.MapMode mapMode) throws IOException {
        this.f26093a = fileChannel;
        long size = fileChannel.size();
        this.f26095c = size;
        this.f26096d = 0;
        int i2 = ((int) (size / 1073741824)) + (size % 1073741824 == 0 ? 0 : 1);
        this.f26094b = new MappedByteBuffer[i2];
        long j2 = 0;
        int i3 = 0;
        while (true) {
            try {
                long j3 = this.f26095c;
                if (j2 >= j3) {
                    break;
                }
                this.f26094b[i3] = fileChannel.map(mapMode, j2, Math.min(j3 - j2, 1073741824));
                this.f26094b[i3].load();
                i3++;
                j2 += 1073741824;
            } catch (IOException e2) {
                b();
                throw e2;
            } catch (RuntimeException e3) {
                b();
                throw e3;
            }
        }
        if (i3 != i2) {
            throw new Error("Should never happen - " + i3 + " != " + i2);
        }
    }

    public void b() throws IOException {
        int i2 = 0;
        while (true) {
            MappedByteBuffer[] mappedByteBufferArr = this.f26094b;
            if (i2 >= mappedByteBufferArr.length) {
                break;
            }
            MappedByteBuffer mappedByteBuffer = mappedByteBufferArr[i2];
            if (mappedByteBuffer != null) {
                a(mappedByteBuffer);
                this.f26094b[i2] = null;
            }
            i2++;
        }
        FileChannel fileChannel = this.f26093a;
        if (fileChannel != null) {
            fileChannel.close();
        }
        this.f26093a = null;
    }

    public FileChannel c() {
        return this.f26093a;
    }

    public long d() {
        return this.f26096d;
    }

    public long f() {
        return this.f26095c;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        b();
        super.finalize();
    }

    public int g() {
        try {
            long j2 = this.f26096d;
            int i2 = (int) (j2 / 1073741824);
            int i3 = (int) (j2 % 1073741824);
            MappedByteBuffer[] mappedByteBufferArr = this.f26094b;
            if (i2 >= mappedByteBufferArr.length || i3 >= mappedByteBufferArr[i2].limit()) {
                return -1;
            }
            byte b2 = this.f26094b[i2].get(i3);
            this.f26096d++;
            return b2 & 255;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    public int h(byte[] bArr, int i2, int i3) {
        long j2 = this.f26096d;
        int i4 = (int) (j2 / 1073741824);
        int i5 = (int) (j2 % 1073741824);
        int i6 = 0;
        while (i6 < i3) {
            MappedByteBuffer[] mappedByteBufferArr = this.f26094b;
            if (i4 >= mappedByteBufferArr.length) {
                break;
            }
            MappedByteBuffer mappedByteBuffer = mappedByteBufferArr[i4];
            if (i5 > mappedByteBuffer.limit()) {
                break;
            }
            mappedByteBuffer.position(i5);
            int min = Math.min(i3 - i6, mappedByteBuffer.remaining());
            mappedByteBuffer.get(bArr, i2, min);
            i2 += min;
            this.f26096d += (long) min;
            i6 += min;
            i4++;
            i5 = 0;
        }
        if (i6 == 0) {
            return -1;
        }
        return i6;
    }

    public void i(long j2) {
        this.f26096d = j2;
    }
}
