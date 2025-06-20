package com.google.firebase.crashlytics.internal.metadata;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class QueueFile implements Closeable {
    private static final Logger Z2 = Logger.getLogger(QueueFile.class.getName());
    private static final int a3 = 4096;
    static final int b3 = 16;
    int X;
    private Element X2;
    private int Y;
    private final byte[] Y2 = new byte[16];
    private Element Z;
    /* access modifiers changed from: private */
    public final RandomAccessFile s;

    static class Element {

        /* renamed from: c  reason: collision with root package name */
        static final int f23723c = 4;

        /* renamed from: d  reason: collision with root package name */
        static final Element f23724d = new Element(0, 0);

        /* renamed from: a  reason: collision with root package name */
        final int f23725a;

        /* renamed from: b  reason: collision with root package name */
        final int f23726b;

        Element(int i2, int i3) {
            this.f23725a = i2;
            this.f23726b = i3;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f23725a + ", length = " + this.f23726b + "]";
        }
    }

    private final class ElementInputStream extends InputStream {
        private int X;
        private int s;

        private ElementInputStream(Element element) {
            this.s = QueueFile.this.L(element.f23725a + 4);
            this.X = element.f23726b;
        }

        public int read() throws IOException {
            if (this.X == 0) {
                return -1;
            }
            QueueFile.this.s.seek((long) this.s);
            int read = QueueFile.this.s.read();
            this.s = QueueFile.this.L(this.s + 1);
            this.X--;
            return read;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            Object unused = QueueFile.s(bArr, "buffer");
            if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = this.X;
            if (i4 <= 0) {
                return -1;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            QueueFile.this.F(this.s, bArr, i2, i3);
            this.s = QueueFile.this.L(this.s + i3);
            this.X -= i3;
            return i3;
        }
    }

    public interface ElementReader {
        void e(InputStream inputStream, int i2) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            q(file);
        }
        this.s = t(file);
        x();
    }

    private int A() {
        return this.X - J();
    }

    /* access modifiers changed from: private */
    public void F(int i2, byte[] bArr, int i3, int i4) throws IOException {
        RandomAccessFile randomAccessFile;
        int L = L(i2);
        int i5 = L + i4;
        int i6 = this.X;
        if (i5 <= i6) {
            this.s.seek((long) L);
            randomAccessFile = this.s;
        } else {
            int i7 = i6 - L;
            this.s.seek((long) L);
            this.s.readFully(bArr, i3, i7);
            this.s.seek(16);
            randomAccessFile = this.s;
            i3 += i7;
            i4 -= i7;
        }
        randomAccessFile.readFully(bArr, i3, i4);
    }

    private void G(int i2, byte[] bArr, int i3, int i4) throws IOException {
        RandomAccessFile randomAccessFile;
        int L = L(i2);
        int i5 = L + i4;
        int i6 = this.X;
        if (i5 <= i6) {
            this.s.seek((long) L);
            randomAccessFile = this.s;
        } else {
            int i7 = i6 - L;
            this.s.seek((long) L);
            this.s.write(bArr, i3, i7);
            this.s.seek(16);
            randomAccessFile = this.s;
            i3 += i7;
            i4 -= i7;
        }
        randomAccessFile.write(bArr, i3, i4);
    }

    private void H(int i2) throws IOException {
        this.s.setLength((long) i2);
        this.s.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    public int L(int i2) {
        int i3 = this.X;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    private void N(int i2, int i3, int i4, int i5) throws IOException {
        P(this.Y2, i2, i3, i4, i5);
        this.s.seek(0);
        this.s.write(this.Y2);
    }

    private static void O(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    private static void P(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int O : iArr) {
            O(bArr, i2, O);
            i2 += 4;
        }
    }

    private void k(int i2) throws IOException {
        int i3 = i2 + 4;
        int A = A();
        if (A < i3) {
            int i4 = this.X;
            do {
                A += i4;
                i4 <<= 1;
            } while (A < i3);
            H(i4);
            Element element = this.X2;
            int L = L(element.f23725a + 4 + element.f23726b);
            if (L < this.Z.f23725a) {
                FileChannel channel = this.s.getChannel();
                channel.position((long) this.X);
                long j2 = (long) (L - 4);
                if (channel.transferTo(16, j2, channel) != j2) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i5 = this.X2.f23725a;
            int i6 = this.Z.f23725a;
            if (i5 < i6) {
                int i7 = (this.X + i5) - 16;
                N(i4, this.Y, i6, i7);
                this.X2 = new Element(i7, this.X2.f23726b);
            } else {
                N(i4, this.Y, i6, i5);
            }
            this.X = i4;
        }
    }

    /* JADX INFO: finally extract failed */
    private static void q(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile t = t(file2);
        try {
            t.setLength(PlaybackStateCompat.r3);
            t.seek(0);
            byte[] bArr = new byte[16];
            P(bArr, 4096, 0, 0, 0);
            t.write(bArr);
            t.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            t.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static <T> T s(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile t(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private Element w(int i2) throws IOException {
        if (i2 == 0) {
            return Element.f23724d;
        }
        this.s.seek((long) i2);
        return new Element(i2, this.s.readInt());
    }

    private void x() throws IOException {
        this.s.seek(0);
        this.s.readFully(this.Y2);
        int y = y(this.Y2, 0);
        this.X = y;
        if (((long) y) <= this.s.length()) {
            this.Y = y(this.Y2, 4);
            int y2 = y(this.Y2, 8);
            int y3 = y(this.Y2, 12);
            this.Z = w(y2);
            this.X2 = w(y3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.X + ", Actual length: " + this.s.length());
    }

    private static int y(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << Ascii.B) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public synchronized void C() throws IOException {
        try {
            if (r()) {
                throw new NoSuchElementException();
            } else if (this.Y == 1) {
                i();
            } else {
                Element element = this.Z;
                int L = L(element.f23725a + 4 + element.f23726b);
                F(L, this.Y2, 0, 4);
                int y = y(this.Y2, 0);
                N(this.X, this.Y - 1, L, this.X2.f23725a);
                this.Y--;
                this.Z = new Element(L, y);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int I() {
        return this.Y;
    }

    public int J() {
        if (this.Y == 0) {
            return 16;
        }
        Element element = this.X2;
        int i2 = element.f23725a;
        int i3 = this.Z.f23725a;
        return i2 >= i3 ? (i2 - i3) + 4 + element.f23726b + 16 : (((i2 + 4) + element.f23726b) + this.X) - i3;
    }

    public synchronized void close() throws IOException {
        this.s.close();
    }

    public void f(byte[] bArr) throws IOException {
        h(bArr, 0, bArr.length);
    }

    public synchronized void h(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        try {
            s(bArr, "buffer");
            if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            k(i3);
            boolean r = r();
            if (r) {
                i4 = 16;
            } else {
                Element element = this.X2;
                i4 = L(element.f23725a + 4 + element.f23726b);
            }
            Element element2 = new Element(i4, i3);
            O(this.Y2, 0, i3);
            G(element2.f23725a, this.Y2, 0, 4);
            G(element2.f23725a + 4, bArr, i2, i3);
            N(this.X, this.Y + 1, r ? element2.f23725a : this.Z.f23725a, element2.f23725a);
            this.X2 = element2;
            this.Y++;
            if (r) {
                this.Z = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i() throws IOException {
        try {
            N(4096, 0, 0, 0);
            this.Y = 0;
            Element element = Element.f23724d;
            this.Z = element;
            this.X2 = element;
            if (this.X > 4096) {
                H(4096);
            }
            this.X = 4096;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void n(ElementReader elementReader) throws IOException {
        int i2 = this.Z.f23725a;
        for (int i3 = 0; i3 < this.Y; i3++) {
            Element w = w(i2);
            elementReader.e(new ElementInputStream(w), w.f23726b);
            i2 = L(w.f23725a + 4 + w.f23726b);
        }
    }

    public boolean p(int i2, int i3) {
        return (J() + 4) + i2 <= i3;
    }

    public synchronized boolean r() {
        return this.Y == 0;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.X);
        sb.append(", size=");
        sb.append(this.Y);
        sb.append(", first=");
        sb.append(this.Z);
        sb.append(", last=");
        sb.append(this.X2);
        sb.append(", element lengths=[");
        try {
            n(new ElementReader() {

                /* renamed from: a  reason: collision with root package name */
                boolean f23720a = true;

                public void e(InputStream inputStream, int i2) throws IOException {
                    if (this.f23720a) {
                        this.f23720a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i2);
                }
            });
        } catch (IOException e2) {
            Z2.log(Level.WARNING, "read error", e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public synchronized void u(ElementReader elementReader) throws IOException {
        if (this.Y > 0) {
            elementReader.e(new ElementInputStream(this.Z), this.Z.f23726b);
        }
    }

    public synchronized byte[] v() throws IOException {
        if (r()) {
            return null;
        }
        Element element = this.Z;
        int i2 = element.f23726b;
        byte[] bArr = new byte[i2];
        F(element.f23725a + 4, bArr, 0, i2);
        return bArr;
    }

    QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.s = randomAccessFile;
        x();
    }
}
