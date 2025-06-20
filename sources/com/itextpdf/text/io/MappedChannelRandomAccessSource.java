package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

class MappedChannelRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f25786a;

    /* renamed from: b  reason: collision with root package name */
    private final long f25787b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25788c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBufferRandomAccessSource f25789d;

    public MappedChannelRandomAccessSource(FileChannel fileChannel, long j2, long j3) {
        if (j2 < 0) {
            throw new IllegalArgumentException(j2 + " is negative");
        } else if (j3 > 0) {
            this.f25786a = fileChannel;
            this.f25787b = j2;
            this.f25788c = j3;
            this.f25789d = null;
        } else {
            throw new IllegalArgumentException(j3 + " is zero or negative");
        }
    }

    private static boolean c(IOException iOException) {
        return iOException.getMessage() != null && iOException.getMessage().indexOf("Map failed") >= 0;
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.f25789d;
        if (byteBufferRandomAccessSource != null) {
            return byteBufferRandomAccessSource.a(j2, bArr, i2, i3);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public int b(long j2) throws IOException {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.f25789d;
        if (byteBufferRandomAccessSource != null) {
            return byteBufferRandomAccessSource.b(j2);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public void close() throws IOException {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.f25789d;
        if (byteBufferRandomAccessSource != null) {
            byteBufferRandomAccessSource.close();
            this.f25789d = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() throws IOException {
        if (this.f25789d == null) {
            if (this.f25786a.isOpen()) {
                try {
                    this.f25789d = new ByteBufferRandomAccessSource(this.f25786a.map(FileChannel.MapMode.READ_ONLY, this.f25787b, this.f25788c));
                } catch (IOException e2) {
                    if (c(e2)) {
                        throw new MapFailedException(e2);
                    }
                    throw e2;
                }
            } else {
                throw new IllegalStateException("Channel is closed");
            }
        }
    }

    public long length() {
        return this.f25788c;
    }

    public String toString() {
        return getClass().getName() + " (" + this.f25787b + ", " + this.f25788c + ")";
    }
}
