package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte Y2 = 13;
    private static final byte Z2 = 10;
    /* access modifiers changed from: private */
    public final Charset X;
    private int X2;
    private byte[] Y;
    private int Z;
    private final InputStream s;

    public StrictLineReader(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Util.f17761a)) {
            this.s = inputStream;
            this.X = charset;
            this.Y = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    private void c() throws IOException {
        InputStream inputStream = this.s;
        byte[] bArr = this.Y;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.Z = 0;
            this.X2 = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.s) {
            try {
                if (this.Y != null) {
                    this.Y = null;
                    this.s.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d() {
        return this.X2 == -1;
    }

    public String e() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.s) {
            try {
                if (this.Y != null) {
                    if (this.Z >= this.X2) {
                        c();
                    }
                    for (int i4 = this.Z; i4 != this.X2; i4++) {
                        byte[] bArr2 = this.Y;
                        if (bArr2[i4] == 10) {
                            int i5 = this.Z;
                            if (i4 != i5) {
                                i3 = i4 - 1;
                                if (bArr2[i3] == 13) {
                                    String str = new String(bArr2, i5, i3 - i5, this.X.name());
                                    this.Z = i4 + 1;
                                    return str;
                                }
                            }
                            i3 = i4;
                            String str2 = new String(bArr2, i5, i3 - i5, this.X.name());
                            this.Z = i4 + 1;
                            return str2;
                        }
                    }
                    AnonymousClass1 r1 = new ByteArrayOutputStream((this.X2 - this.Z) + 80) {
                        public String toString() {
                            int i2 = this.count;
                            if (i2 > 0 && this.buf[i2 - 1] == 13) {
                                i2--;
                            }
                            try {
                                return new String(this.buf, 0, i2, StrictLineReader.this.X.name());
                            } catch (UnsupportedEncodingException e2) {
                                throw new AssertionError(e2);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        byte[] bArr3 = this.Y;
                        int i6 = this.Z;
                        r1.write(bArr3, i6, this.X2 - i6);
                        this.X2 = -1;
                        c();
                        i2 = this.Z;
                        while (true) {
                            if (i2 != this.X2) {
                                bArr = this.Y;
                                if (bArr[i2] == 10) {
                                    break loop1;
                                }
                                i2++;
                            }
                        }
                    }
                    int i7 = this.Z;
                    if (i2 != i7) {
                        r1.write(bArr, i7, i2 - i7);
                    }
                    this.Z = i2 + 1;
                    String byteArrayOutputStream = r1.toString();
                    return byteArrayOutputStream;
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }
}
