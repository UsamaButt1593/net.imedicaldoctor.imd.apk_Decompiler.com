package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f7073c = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7074d = UnsafeUtil.S();
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final int f7075e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f7076f = 4096;

    /* renamed from: a  reason: collision with root package name */
    CodedOutputStreamWriter f7077a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7078b;

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: g  reason: collision with root package name */
        final byte[] f7079g;

        /* renamed from: h  reason: collision with root package name */
        final int f7080h;

        /* renamed from: i  reason: collision with root package name */
        int f7081i;

        /* renamed from: j  reason: collision with root package name */
        int f7082j;

        AbstractBufferedEncoder(int i2) {
            super();
            if (i2 >= 0) {
                byte[] bArr = new byte[Math.max(i2, 20)];
                this.f7079g = bArr;
                this.f7080h = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int f1() {
            return this.f7082j;
        }

        /* access modifiers changed from: package-private */
        public final void j2(byte b2) {
            byte[] bArr = this.f7079g;
            int i2 = this.f7081i;
            this.f7081i = i2 + 1;
            bArr[i2] = b2;
            this.f7082j++;
        }

        /* access modifiers changed from: package-private */
        public final void k2(int i2) {
            byte[] bArr = this.f7079g;
            int i3 = this.f7081i;
            int i4 = i3 + 1;
            this.f7081i = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i3 + 2;
            this.f7081i = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i3 + 3;
            this.f7081i = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f7081i = i3 + 4;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
            this.f7082j += 4;
        }

        /* access modifiers changed from: package-private */
        public final void l2(long j2) {
            byte[] bArr = this.f7079g;
            int i2 = this.f7081i;
            int i3 = i2 + 1;
            this.f7081i = i3;
            bArr[i2] = (byte) ((int) (j2 & 255));
            int i4 = i2 + 2;
            this.f7081i = i4;
            bArr[i3] = (byte) ((int) ((j2 >> 8) & 255));
            int i5 = i2 + 3;
            this.f7081i = i5;
            bArr[i4] = (byte) ((int) ((j2 >> 16) & 255));
            int i6 = i2 + 4;
            this.f7081i = i6;
            bArr[i5] = (byte) ((int) (255 & (j2 >> 24)));
            int i7 = i2 + 5;
            this.f7081i = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i2 + 6;
            this.f7081i = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i2 + 7;
            this.f7081i = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f7081i = i2 + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            this.f7082j += 8;
        }

        /* access modifiers changed from: package-private */
        public final void m2(int i2) {
            if (i2 >= 0) {
                o2(i2);
            } else {
                p2((long) i2);
            }
        }

        /* access modifiers changed from: package-private */
        public final void n2(int i2, int i3) {
            o2(WireFormat.c(i2, i3));
        }

        /* access modifiers changed from: package-private */
        public final void o2(int i2) {
            if (CodedOutputStream.f7074d) {
                long j2 = (long) this.f7081i;
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f7079g;
                    int i3 = this.f7081i;
                    this.f7081i = i3 + 1;
                    UnsafeUtil.d0(bArr, (long) i3, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.f7079g;
                int i4 = this.f7081i;
                this.f7081i = i4 + 1;
                UnsafeUtil.d0(bArr2, (long) i4, (byte) i2);
                this.f7082j += (int) (((long) this.f7081i) - j2);
                return;
            }
            while ((i2 & -128) != 0) {
                byte[] bArr3 = this.f7079g;
                int i5 = this.f7081i;
                this.f7081i = i5 + 1;
                bArr3[i5] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
                this.f7082j++;
                i2 >>>= 7;
            }
            byte[] bArr4 = this.f7079g;
            int i6 = this.f7081i;
            this.f7081i = i6 + 1;
            bArr4[i6] = (byte) i2;
            this.f7082j++;
        }

        /* access modifiers changed from: package-private */
        public final void p2(long j2) {
            if (CodedOutputStream.f7074d) {
                long j3 = (long) this.f7081i;
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f7079g;
                    int i2 = this.f7081i;
                    this.f7081i = i2 + 1;
                    UnsafeUtil.d0(bArr, (long) i2, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f7079g;
                int i3 = this.f7081i;
                this.f7081i = i3 + 1;
                UnsafeUtil.d0(bArr2, (long) i3, (byte) ((int) j2));
                this.f7082j += (int) (((long) this.f7081i) - j3);
                return;
            }
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.f7079g;
                int i4 = this.f7081i;
                this.f7081i = i4 + 1;
                bArr3[i4] = (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128);
                this.f7082j++;
                j2 >>>= 7;
            }
            byte[] bArr4 = this.f7079g;
            int i5 = this.f7081i;
            this.f7081i = i5 + 1;
            bArr4[i5] = (byte) ((int) j2);
            this.f7082j++;
        }

        public final int r1() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f7083g;

        /* renamed from: h  reason: collision with root package name */
        private final int f7084h;

        /* renamed from: i  reason: collision with root package name */
        private final int f7085i;

        /* renamed from: j  reason: collision with root package name */
        private int f7086j;

        ArrayEncoder(byte[] bArr, int i2, int i3) {
            super();
            if (bArr != null) {
                int i4 = i2 + i3;
                if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                    this.f7083g = bArr;
                    this.f7084h = i2;
                    this.f7086j = i2;
                    this.f7085i = i4;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void C1(int i2) throws IOException {
            try {
                byte[] bArr = this.f7083g;
                int i3 = this.f7086j;
                int i4 = i3 + 1;
                this.f7086j = i4;
                bArr[i3] = (byte) (i2 & 255);
                int i5 = i3 + 2;
                this.f7086j = i5;
                bArr[i4] = (byte) ((i2 >> 8) & 255);
                int i6 = i3 + 3;
                this.f7086j = i6;
                bArr[i5] = (byte) ((i2 >> 16) & 255);
                this.f7086j = i3 + 4;
                bArr[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), 1}), e2);
            }
        }

        public final void D1(long j2) throws IOException {
            try {
                byte[] bArr = this.f7083g;
                int i2 = this.f7086j;
                int i3 = i2 + 1;
                this.f7086j = i3;
                bArr[i2] = (byte) (((int) j2) & 255);
                int i4 = i2 + 2;
                this.f7086j = i4;
                bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
                int i5 = i2 + 3;
                this.f7086j = i5;
                bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
                int i6 = i2 + 4;
                this.f7086j = i6;
                bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
                int i7 = i2 + 5;
                this.f7086j = i7;
                bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
                int i8 = i2 + 6;
                this.f7086j = i8;
                bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
                int i9 = i2 + 7;
                this.f7086j = i9;
                bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
                this.f7086j = i2 + 8;
                bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), 1}), e2);
            }
        }

        public final void J1(int i2) throws IOException {
            if (i2 >= 0) {
                h2(i2);
            } else {
                i2((long) i2);
            }
        }

        public final void L1(int i2, MessageLite messageLite) throws IOException {
            g2(i2, 2);
            N1(messageLite);
        }

        /* access modifiers changed from: package-private */
        public final void M1(int i2, MessageLite messageLite, Schema schema) throws IOException {
            g2(i2, 2);
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public final void N1(MessageLite messageLite) throws IOException {
            h2(messageLite.R0());
            messageLite.j1(this);
        }

        /* access modifiers changed from: package-private */
        public final void O1(MessageLite messageLite, Schema schema) throws IOException {
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public final void P1(int i2, MessageLite messageLite) throws IOException {
            g2(1, 3);
            b(2, i2);
            L1(3, messageLite);
            g2(1, 4);
        }

        public final void T(byte b2) throws IOException {
            try {
                byte[] bArr = this.f7083g;
                int i2 = this.f7086j;
                this.f7086j = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), 1}), e2);
            }
        }

        public final void T1(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                V(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            U(duplicate);
        }

        public final void U(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f7083g, this.f7086j, remaining);
                this.f7086j += remaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), Integer.valueOf(remaining)}), e2);
            }
        }

        public final void V(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f7083g, this.f7086j, i3);
                this.f7086j += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), Integer.valueOf(i3)}), e2);
            }
        }

        public final void W(ByteBuffer byteBuffer) throws IOException {
            U(byteBuffer);
        }

        public final void X(byte[] bArr, int i2, int i3) throws IOException {
            V(bArr, i2, i3);
        }

        public final void Y1(int i2, ByteString byteString) throws IOException {
            g2(1, 3);
            b(2, i2);
            z(3, byteString);
            g2(1, 4);
        }

        public final void b(int i2, int i3) throws IOException {
            g2(i2, 0);
            h2(i3);
        }

        public final void d(int i2, int i3) throws IOException {
            g2(i2, 5);
            C1(i3);
        }

        public void e1() {
        }

        public final int f1() {
            return this.f7086j - this.f7084h;
        }

        public final void f2(String str) throws IOException {
            int i2;
            int i3 = this.f7086j;
            try {
                int Z0 = CodedOutputStream.Z0(str.length() * 3);
                int Z02 = CodedOutputStream.Z0(str.length());
                if (Z02 == Z0) {
                    int i4 = i3 + Z02;
                    this.f7086j = i4;
                    i2 = Utf8.i(str, this.f7083g, i4, r1());
                    this.f7086j = i3;
                    h2((i2 - i3) - Z02);
                } else {
                    h2(Utf8.k(str));
                    i2 = Utf8.i(str, this.f7083g, this.f7086j, r1());
                }
                this.f7086j = i2;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f7086j = i3;
                g1(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public final void g2(int i2, int i3) throws IOException {
            h2(WireFormat.c(i2, i3));
        }

        public final void h2(int i2) throws IOException {
            if (!CodedOutputStream.f7074d || Android.c() || r1() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f7083g;
                    int i3 = this.f7086j;
                    this.f7086j = i3 + 1;
                    bArr[i3] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f7083g;
                    int i4 = this.f7086j;
                    this.f7086j = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), 1}), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f7083g;
                int i5 = this.f7086j;
                this.f7086j = 1 + i5;
                UnsafeUtil.d0(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f7083g;
                int i6 = this.f7086j;
                this.f7086j = i6 + 1;
                UnsafeUtil.d0(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f7083g;
                    int i8 = this.f7086j;
                    this.f7086j = 1 + i8;
                    UnsafeUtil.d0(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f7083g;
                int i9 = this.f7086j;
                this.f7086j = i9 + 1;
                UnsafeUtil.d0(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i2 >>> 14;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f7083g;
                    int i11 = this.f7086j;
                    this.f7086j = 1 + i11;
                    UnsafeUtil.d0(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f7083g;
                int i12 = this.f7086j;
                this.f7086j = i12 + 1;
                UnsafeUtil.d0(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i2 >>> 21;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f7083g;
                    int i14 = this.f7086j;
                    this.f7086j = 1 + i14;
                    UnsafeUtil.d0(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f7083g;
                int i15 = this.f7086j;
                this.f7086j = i15 + 1;
                UnsafeUtil.d0(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f7083g;
                int i16 = this.f7086j;
                this.f7086j = 1 + i16;
                UnsafeUtil.d0(bArr11, (long) i16, (byte) (i2 >>> 28));
            }
        }

        public final void i(int i2, long j2) throws IOException {
            g2(i2, 1);
            D1(j2);
        }

        public final void i2(long j2) throws IOException {
            if (!CodedOutputStream.f7074d || r1() < 10) {
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f7083g;
                    int i2 = this.f7086j;
                    this.f7086j = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128);
                    j2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f7083g;
                    int i3 = this.f7086j;
                    this.f7086j = i3 + 1;
                    bArr2[i3] = (byte) ((int) j2);
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7086j), Integer.valueOf(this.f7085i), 1}), e2);
                }
            } else {
                while ((j2 & -128) != 0) {
                    byte[] bArr3 = this.f7083g;
                    int i4 = this.f7086j;
                    this.f7086j = i4 + 1;
                    UnsafeUtil.d0(bArr3, (long) i4, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr4 = this.f7083g;
                int i5 = this.f7086j;
                this.f7086j = 1 + i5;
                UnsafeUtil.d0(bArr4, (long) i5, (byte) ((int) j2));
            }
        }

        public final void o(int i2, String str) throws IOException {
            g2(i2, 2);
            f2(str);
        }

        public final void p(int i2, long j2) throws IOException {
            g2(i2, 0);
            i2(j2);
        }

        public final int r1() {
            return this.f7085i - this.f7086j;
        }

        public final void t(int i2, boolean z) throws IOException {
            g2(i2, 0);
            T(z ? (byte) 1 : 0);
        }

        public final void u1(int i2, byte[] bArr) throws IOException {
            v1(i2, bArr, 0, bArr.length);
        }

        public final void v1(int i2, byte[] bArr, int i3, int i4) throws IOException {
            g2(i2, 2);
            x1(bArr, i3, i4);
        }

        public final void w(int i2, int i3) throws IOException {
            g2(i2, 0);
            J1(i3);
        }

        public final void x1(byte[] bArr, int i2, int i3) throws IOException {
            h2(i3);
            V(bArr, i2, i3);
        }

        public final void y1(int i2, ByteBuffer byteBuffer) throws IOException {
            g2(i2, 2);
            h2(byteBuffer.capacity());
            T1(byteBuffer);
        }

        public final void z(int i2, ByteString byteString) throws IOException {
            g2(i2, 2);
            z1(byteString);
        }

        public final void z1(ByteString byteString) throws IOException {
            h2(byteString.size());
            byteString.w0(this);
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {

        /* renamed from: k  reason: collision with root package name */
        private final ByteOutput f7087k;

        ByteOutputEncoder(ByteOutput byteOutput, int i2) {
            super(i2);
            if (byteOutput != null) {
                this.f7087k = byteOutput;
                return;
            }
            throw new NullPointerException("out");
        }

        private void q2() throws IOException {
            this.f7087k.V(this.f7079g, 0, this.f7081i);
            this.f7081i = 0;
        }

        private void r2(int i2) throws IOException {
            if (this.f7080h - this.f7081i < i2) {
                q2();
            }
        }

        public void C1(int i2) throws IOException {
            r2(4);
            k2(i2);
        }

        public void D1(long j2) throws IOException {
            r2(8);
            l2(j2);
        }

        public void J1(int i2) throws IOException {
            if (i2 >= 0) {
                h2(i2);
            } else {
                i2((long) i2);
            }
        }

        public void L1(int i2, MessageLite messageLite) throws IOException {
            g2(i2, 2);
            N1(messageLite);
        }

        /* access modifiers changed from: package-private */
        public void M1(int i2, MessageLite messageLite, Schema schema) throws IOException {
            g2(i2, 2);
            O1(messageLite, schema);
        }

        public void N1(MessageLite messageLite) throws IOException {
            h2(messageLite.R0());
            messageLite.j1(this);
        }

        /* access modifiers changed from: package-private */
        public void O1(MessageLite messageLite, Schema schema) throws IOException {
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public void P1(int i2, MessageLite messageLite) throws IOException {
            g2(1, 3);
            b(2, i2);
            L1(3, messageLite);
            g2(1, 4);
        }

        public void T(byte b2) throws IOException {
            if (this.f7081i == this.f7080h) {
                q2();
            }
            j2(b2);
        }

        public void T1(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                V(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            U(duplicate);
        }

        public void U(ByteBuffer byteBuffer) throws IOException {
            e1();
            int remaining = byteBuffer.remaining();
            this.f7087k.U(byteBuffer);
            this.f7082j += remaining;
        }

        public void V(byte[] bArr, int i2, int i3) throws IOException {
            e1();
            this.f7087k.V(bArr, i2, i3);
            this.f7082j += i3;
        }

        public void W(ByteBuffer byteBuffer) throws IOException {
            e1();
            int remaining = byteBuffer.remaining();
            this.f7087k.W(byteBuffer);
            this.f7082j += remaining;
        }

        public void X(byte[] bArr, int i2, int i3) throws IOException {
            e1();
            this.f7087k.X(bArr, i2, i3);
            this.f7082j += i3;
        }

        public void Y1(int i2, ByteString byteString) throws IOException {
            g2(1, 3);
            b(2, i2);
            z(3, byteString);
            g2(1, 4);
        }

        public void b(int i2, int i3) throws IOException {
            r2(20);
            n2(i2, 0);
            o2(i3);
        }

        public void d(int i2, int i3) throws IOException {
            r2(14);
            n2(i2, 5);
            k2(i3);
        }

        public void e1() throws IOException {
            if (this.f7081i > 0) {
                q2();
            }
        }

        public void f2(String str) throws IOException {
            int length = str.length() * 3;
            int Z0 = CodedOutputStream.Z0(length);
            int i2 = Z0 + length;
            int i3 = this.f7080h;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int i4 = Utf8.i(str, bArr, 0, length);
                h2(i4);
                X(bArr, 0, i4);
                return;
            }
            if (i2 > i3 - this.f7081i) {
                q2();
            }
            int i5 = this.f7081i;
            try {
                int Z02 = CodedOutputStream.Z0(str.length());
                if (Z02 == Z0) {
                    int i6 = i5 + Z02;
                    this.f7081i = i6;
                    int i7 = Utf8.i(str, this.f7079g, i6, this.f7080h - i6);
                    this.f7081i = i5;
                    int i8 = (i7 - i5) - Z02;
                    o2(i8);
                    this.f7081i = i7;
                    this.f7082j += i8;
                    return;
                }
                int k2 = Utf8.k(str);
                o2(k2);
                this.f7081i = Utf8.i(str, this.f7079g, this.f7081i, k2);
                this.f7082j += k2;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f7082j -= this.f7081i - i5;
                this.f7081i = i5;
                g1(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void g2(int i2, int i3) throws IOException {
            h2(WireFormat.c(i2, i3));
        }

        public void h2(int i2) throws IOException {
            r2(5);
            o2(i2);
        }

        public void i(int i2, long j2) throws IOException {
            r2(18);
            n2(i2, 1);
            l2(j2);
        }

        public void i2(long j2) throws IOException {
            r2(10);
            p2(j2);
        }

        public void o(int i2, String str) throws IOException {
            g2(i2, 2);
            f2(str);
        }

        public void p(int i2, long j2) throws IOException {
            r2(20);
            n2(i2, 0);
            p2(j2);
        }

        public void t(int i2, boolean z) throws IOException {
            r2(11);
            n2(i2, 0);
            j2(z ? (byte) 1 : 0);
        }

        public void u1(int i2, byte[] bArr) throws IOException {
            v1(i2, bArr, 0, bArr.length);
        }

        public void v1(int i2, byte[] bArr, int i3, int i4) throws IOException {
            g2(i2, 2);
            x1(bArr, i3, i4);
        }

        public void w(int i2, int i3) throws IOException {
            r2(20);
            n2(i2, 0);
            m2(i3);
        }

        public void x1(byte[] bArr, int i2, int i3) throws IOException {
            h2(i3);
            V(bArr, i2, i3);
        }

        public void y1(int i2, ByteBuffer byteBuffer) throws IOException {
            g2(i2, 2);
            h2(byteBuffer.capacity());
            T1(byteBuffer);
        }

        public void z(int i2, ByteString byteString) throws IOException {
            g2(i2, 2);
            z1(byteString);
        }

        public void z1(ByteString byteString) throws IOException {
            h2(byteString.size());
            byteString.w0(this);
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {

        /* renamed from: k  reason: collision with root package name */
        private final ByteBuffer f7088k;

        /* renamed from: l  reason: collision with root package name */
        private int f7089l;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f7088k = byteBuffer;
            this.f7089l = byteBuffer.position();
        }

        public void e1() {
            this.f7088k.position(this.f7089l + f1());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String X = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long s = -6947486886997889499L;

        OutOfSpaceException() {
            super(X);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        OutOfSpaceException(Throwable th) {
            super(X, th);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: k  reason: collision with root package name */
        private final OutputStream f7090k;

        OutputStreamEncoder(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream != null) {
                this.f7090k = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void q2() throws IOException {
            this.f7090k.write(this.f7079g, 0, this.f7081i);
            this.f7081i = 0;
        }

        private void r2(int i2) throws IOException {
            if (this.f7080h - this.f7081i < i2) {
                q2();
            }
        }

        public void C1(int i2) throws IOException {
            r2(4);
            k2(i2);
        }

        public void D1(long j2) throws IOException {
            r2(8);
            l2(j2);
        }

        public void J1(int i2) throws IOException {
            if (i2 >= 0) {
                h2(i2);
            } else {
                i2((long) i2);
            }
        }

        public void L1(int i2, MessageLite messageLite) throws IOException {
            g2(i2, 2);
            N1(messageLite);
        }

        /* access modifiers changed from: package-private */
        public void M1(int i2, MessageLite messageLite, Schema schema) throws IOException {
            g2(i2, 2);
            O1(messageLite, schema);
        }

        public void N1(MessageLite messageLite) throws IOException {
            h2(messageLite.R0());
            messageLite.j1(this);
        }

        /* access modifiers changed from: package-private */
        public void O1(MessageLite messageLite, Schema schema) throws IOException {
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public void P1(int i2, MessageLite messageLite) throws IOException {
            g2(1, 3);
            b(2, i2);
            L1(3, messageLite);
            g2(1, 4);
        }

        public void T(byte b2) throws IOException {
            if (this.f7081i == this.f7080h) {
                q2();
            }
            j2(b2);
        }

        public void T1(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                V(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            U(duplicate);
        }

        public void U(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i2 = this.f7080h;
            int i3 = this.f7081i;
            if (i2 - i3 >= remaining) {
                byteBuffer.get(this.f7079g, i3, remaining);
                this.f7081i += remaining;
            } else {
                int i4 = i2 - i3;
                byteBuffer.get(this.f7079g, i3, i4);
                remaining -= i4;
                this.f7081i = this.f7080h;
                this.f7082j += i4;
                q2();
                while (true) {
                    int i5 = this.f7080h;
                    if (remaining <= i5) {
                        break;
                    }
                    byteBuffer.get(this.f7079g, 0, i5);
                    this.f7090k.write(this.f7079g, 0, this.f7080h);
                    int i6 = this.f7080h;
                    remaining -= i6;
                    this.f7082j += i6;
                }
                byteBuffer.get(this.f7079g, 0, remaining);
                this.f7081i = remaining;
            }
            this.f7082j += remaining;
        }

        public void V(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f7080h;
            int i5 = this.f7081i;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.f7079g, i5, i3);
                this.f7081i += i3;
            } else {
                int i6 = i4 - i5;
                System.arraycopy(bArr, i2, this.f7079g, i5, i6);
                int i7 = i2 + i6;
                i3 -= i6;
                this.f7081i = this.f7080h;
                this.f7082j += i6;
                q2();
                if (i3 <= this.f7080h) {
                    System.arraycopy(bArr, i7, this.f7079g, 0, i3);
                    this.f7081i = i3;
                } else {
                    this.f7090k.write(bArr, i7, i3);
                }
            }
            this.f7082j += i3;
        }

        public void W(ByteBuffer byteBuffer) throws IOException {
            U(byteBuffer);
        }

        public void X(byte[] bArr, int i2, int i3) throws IOException {
            V(bArr, i2, i3);
        }

        public void Y1(int i2, ByteString byteString) throws IOException {
            g2(1, 3);
            b(2, i2);
            z(3, byteString);
            g2(1, 4);
        }

        public void b(int i2, int i3) throws IOException {
            r2(20);
            n2(i2, 0);
            o2(i3);
        }

        public void d(int i2, int i3) throws IOException {
            r2(14);
            n2(i2, 5);
            k2(i3);
        }

        public void e1() throws IOException {
            if (this.f7081i > 0) {
                q2();
            }
        }

        public void f2(String str) throws IOException {
            int i2;
            int i3;
            try {
                int length = str.length() * 3;
                int Z0 = CodedOutputStream.Z0(length);
                int i4 = Z0 + length;
                int i5 = this.f7080h;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int i6 = Utf8.i(str, bArr, 0, length);
                    h2(i6);
                    X(bArr, 0, i6);
                    return;
                }
                if (i4 > i5 - this.f7081i) {
                    q2();
                }
                int Z02 = CodedOutputStream.Z0(str.length());
                i2 = this.f7081i;
                if (Z02 == Z0) {
                    int i7 = i2 + Z02;
                    this.f7081i = i7;
                    int i8 = Utf8.i(str, this.f7079g, i7, this.f7080h - i7);
                    this.f7081i = i2;
                    i3 = (i8 - i2) - Z02;
                    o2(i3);
                    this.f7081i = i8;
                } else {
                    i3 = Utf8.k(str);
                    o2(i3);
                    this.f7081i = Utf8.i(str, this.f7079g, this.f7081i, i3);
                }
                this.f7082j += i3;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f7082j -= this.f7081i - i2;
                this.f7081i = i2;
                throw e2;
            } catch (ArrayIndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            } catch (Utf8.UnpairedSurrogateException e4) {
                g1(str, e4);
            }
        }

        public void g2(int i2, int i3) throws IOException {
            h2(WireFormat.c(i2, i3));
        }

        public void h2(int i2) throws IOException {
            r2(5);
            o2(i2);
        }

        public void i(int i2, long j2) throws IOException {
            r2(18);
            n2(i2, 1);
            l2(j2);
        }

        public void i2(long j2) throws IOException {
            r2(10);
            p2(j2);
        }

        public void o(int i2, String str) throws IOException {
            g2(i2, 2);
            f2(str);
        }

        public void p(int i2, long j2) throws IOException {
            r2(20);
            n2(i2, 0);
            p2(j2);
        }

        public void t(int i2, boolean z) throws IOException {
            r2(11);
            n2(i2, 0);
            j2(z ? (byte) 1 : 0);
        }

        public void u1(int i2, byte[] bArr) throws IOException {
            v1(i2, bArr, 0, bArr.length);
        }

        public void v1(int i2, byte[] bArr, int i3, int i4) throws IOException {
            g2(i2, 2);
            x1(bArr, i3, i4);
        }

        public void w(int i2, int i3) throws IOException {
            r2(20);
            n2(i2, 0);
            m2(i3);
        }

        public void x1(byte[] bArr, int i2, int i3) throws IOException {
            h2(i3);
            V(bArr, i2, i3);
        }

        public void y1(int i2, ByteBuffer byteBuffer) throws IOException {
            g2(i2, 2);
            h2(byteBuffer.capacity());
            T1(byteBuffer);
        }

        public void z(int i2, ByteString byteString) throws IOException {
            g2(i2, 2);
            z1(byteString);
        }

        public void z1(ByteString byteString) throws IOException {
            h2(byteString.size());
            byteString.w0(this);
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f7091g;

        /* renamed from: h  reason: collision with root package name */
        private final ByteBuffer f7092h;

        /* renamed from: i  reason: collision with root package name */
        private final int f7093i;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f7091g = byteBuffer;
            this.f7092h = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f7093i = byteBuffer.position();
        }

        private void j2(String str) throws IOException {
            try {
                Utf8.j(str, this.f7092h);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void C1(int i2) throws IOException {
            try {
                this.f7092h.putInt(i2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void D1(long j2) throws IOException {
            try {
                this.f7092h.putLong(j2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void J1(int i2) throws IOException {
            if (i2 >= 0) {
                h2(i2);
            } else {
                i2((long) i2);
            }
        }

        public void L1(int i2, MessageLite messageLite) throws IOException {
            g2(i2, 2);
            N1(messageLite);
        }

        /* access modifiers changed from: package-private */
        public void M1(int i2, MessageLite messageLite, Schema schema) throws IOException {
            g2(i2, 2);
            O1(messageLite, schema);
        }

        public void N1(MessageLite messageLite) throws IOException {
            h2(messageLite.R0());
            messageLite.j1(this);
        }

        /* access modifiers changed from: package-private */
        public void O1(MessageLite messageLite, Schema schema) throws IOException {
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public void P1(int i2, MessageLite messageLite) throws IOException {
            g2(1, 3);
            b(2, i2);
            L1(3, messageLite);
            g2(1, 4);
        }

        public void T(byte b2) throws IOException {
            try {
                this.f7092h.put(b2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void T1(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                V(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            U(duplicate);
        }

        public void U(ByteBuffer byteBuffer) throws IOException {
            try {
                this.f7092h.put(byteBuffer);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void V(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.f7092h.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void W(ByteBuffer byteBuffer) throws IOException {
            U(byteBuffer);
        }

        public void X(byte[] bArr, int i2, int i3) throws IOException {
            V(bArr, i2, i3);
        }

        public void Y1(int i2, ByteString byteString) throws IOException {
            g2(1, 3);
            b(2, i2);
            z(3, byteString);
            g2(1, 4);
        }

        public void b(int i2, int i3) throws IOException {
            g2(i2, 0);
            h2(i3);
        }

        public void d(int i2, int i3) throws IOException {
            g2(i2, 5);
            C1(i3);
        }

        public void e1() {
            this.f7091g.position(this.f7092h.position());
        }

        public int f1() {
            return this.f7092h.position() - this.f7093i;
        }

        public void f2(String str) throws IOException {
            int position = this.f7092h.position();
            try {
                int Z0 = CodedOutputStream.Z0(str.length() * 3);
                int Z02 = CodedOutputStream.Z0(str.length());
                if (Z02 == Z0) {
                    int position2 = this.f7092h.position() + Z02;
                    this.f7092h.position(position2);
                    j2(str);
                    int position3 = this.f7092h.position();
                    this.f7092h.position(position);
                    h2(position3 - position2);
                    this.f7092h.position(position3);
                    return;
                }
                h2(Utf8.k(str));
                j2(str);
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f7092h.position(position);
                g1(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void g2(int i2, int i3) throws IOException {
            h2(WireFormat.c(i2, i3));
        }

        public void h2(int i2) throws IOException {
            while ((i2 & -128) != 0) {
                this.f7092h.put((byte) ((i2 & WorkQueueKt.f29430c) | 128));
                i2 >>>= 7;
            }
            try {
                this.f7092h.put((byte) i2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void i(int i2, long j2) throws IOException {
            g2(i2, 1);
            D1(j2);
        }

        public void i2(long j2) throws IOException {
            while ((-128 & j2) != 0) {
                this.f7092h.put((byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
                j2 >>>= 7;
            }
            try {
                this.f7092h.put((byte) ((int) j2));
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void o(int i2, String str) throws IOException {
            g2(i2, 2);
            f2(str);
        }

        public void p(int i2, long j2) throws IOException {
            g2(i2, 0);
            i2(j2);
        }

        public int r1() {
            return this.f7092h.remaining();
        }

        public void t(int i2, boolean z) throws IOException {
            g2(i2, 0);
            T(z ? (byte) 1 : 0);
        }

        public void u1(int i2, byte[] bArr) throws IOException {
            v1(i2, bArr, 0, bArr.length);
        }

        public void v1(int i2, byte[] bArr, int i3, int i4) throws IOException {
            g2(i2, 2);
            x1(bArr, i3, i4);
        }

        public void w(int i2, int i3) throws IOException {
            g2(i2, 0);
            J1(i3);
        }

        public void x1(byte[] bArr, int i2, int i3) throws IOException {
            h2(i3);
            V(bArr, i2, i3);
        }

        public void y1(int i2, ByteBuffer byteBuffer) throws IOException {
            g2(i2, 2);
            h2(byteBuffer.capacity());
            T1(byteBuffer);
        }

        public void z(int i2, ByteString byteString) throws IOException {
            g2(i2, 2);
            z1(byteString);
        }

        public void z1(ByteString byteString) throws IOException {
            h2(byteString.size());
            byteString.w0(this);
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f7094g;

        /* renamed from: h  reason: collision with root package name */
        private final ByteBuffer f7095h;

        /* renamed from: i  reason: collision with root package name */
        private final long f7096i;

        /* renamed from: j  reason: collision with root package name */
        private final long f7097j;

        /* renamed from: k  reason: collision with root package name */
        private final long f7098k;

        /* renamed from: l  reason: collision with root package name */
        private final long f7099l;

        /* renamed from: m  reason: collision with root package name */
        private long f7100m;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f7094g = byteBuffer;
            this.f7095h = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long i2 = UnsafeUtil.i(byteBuffer);
            this.f7096i = i2;
            long position = ((long) byteBuffer.position()) + i2;
            this.f7097j = position;
            long limit = i2 + ((long) byteBuffer.limit());
            this.f7098k = limit;
            this.f7099l = limit - 10;
            this.f7100m = position;
        }

        private int j2(long j2) {
            return (int) (j2 - this.f7096i);
        }

        static boolean k2() {
            return UnsafeUtil.T();
        }

        private void l2(long j2) {
            this.f7095h.position(j2(j2));
        }

        public void C1(int i2) throws IOException {
            this.f7095h.putInt(j2(this.f7100m), i2);
            this.f7100m += 4;
        }

        public void D1(long j2) throws IOException {
            this.f7095h.putLong(j2(this.f7100m), j2);
            this.f7100m += 8;
        }

        public void J1(int i2) throws IOException {
            if (i2 >= 0) {
                h2(i2);
            } else {
                i2((long) i2);
            }
        }

        public void L1(int i2, MessageLite messageLite) throws IOException {
            g2(i2, 2);
            N1(messageLite);
        }

        /* access modifiers changed from: package-private */
        public void M1(int i2, MessageLite messageLite, Schema schema) throws IOException {
            g2(i2, 2);
            O1(messageLite, schema);
        }

        public void N1(MessageLite messageLite) throws IOException {
            h2(messageLite.R0());
            messageLite.j1(this);
        }

        /* access modifiers changed from: package-private */
        public void O1(MessageLite messageLite, Schema schema) throws IOException {
            h2(((AbstractMessageLite) messageLite).I(schema));
            schema.e(messageLite, this.f7077a);
        }

        public void P1(int i2, MessageLite messageLite) throws IOException {
            g2(1, 3);
            b(2, i2);
            L1(3, messageLite);
            g2(1, 4);
        }

        public void T(byte b2) throws IOException {
            long j2 = this.f7100m;
            if (j2 < this.f7098k) {
                this.f7100m = 1 + j2;
                UnsafeUtil.b0(j2, b2);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f7100m), Long.valueOf(this.f7098k), 1}));
        }

        public void T1(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                V(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            U(duplicate);
        }

        public void U(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                l2(this.f7100m);
                this.f7095h.put(byteBuffer);
                this.f7100m += (long) remaining;
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void V(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = (long) i3;
                long j3 = this.f7100m;
                if (this.f7098k - j2 >= j3) {
                    UnsafeUtil.o(bArr, (long) i2, j3, j2);
                    this.f7100m += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f7100m), Long.valueOf(this.f7098k), Integer.valueOf(i3)}));
        }

        public void W(ByteBuffer byteBuffer) throws IOException {
            U(byteBuffer);
        }

        public void X(byte[] bArr, int i2, int i3) throws IOException {
            V(bArr, i2, i3);
        }

        public void Y1(int i2, ByteString byteString) throws IOException {
            g2(1, 3);
            b(2, i2);
            z(3, byteString);
            g2(1, 4);
        }

        public void b(int i2, int i3) throws IOException {
            g2(i2, 0);
            h2(i3);
        }

        public void d(int i2, int i3) throws IOException {
            g2(i2, 5);
            C1(i3);
        }

        public void e1() {
            this.f7094g.position(j2(this.f7100m));
        }

        public int f1() {
            return (int) (this.f7100m - this.f7097j);
        }

        public void f2(String str) throws IOException {
            long j2 = this.f7100m;
            try {
                int Z0 = CodedOutputStream.Z0(str.length() * 3);
                int Z02 = CodedOutputStream.Z0(str.length());
                if (Z02 == Z0) {
                    int j22 = j2(this.f7100m) + Z02;
                    this.f7095h.position(j22);
                    Utf8.j(str, this.f7095h);
                    int position = this.f7095h.position() - j22;
                    h2(position);
                    this.f7100m += (long) position;
                    return;
                }
                int k2 = Utf8.k(str);
                h2(k2);
                l2(this.f7100m);
                Utf8.j(str, this.f7095h);
                this.f7100m += (long) k2;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f7100m = j2;
                l2(j2);
                g1(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException((Throwable) e4);
            }
        }

        public void g2(int i2, int i3) throws IOException {
            h2(WireFormat.c(i2, i3));
        }

        public void h2(int i2) throws IOException {
            if (this.f7100m <= this.f7099l) {
                while ((i2 & -128) != 0) {
                    long j2 = this.f7100m;
                    this.f7100m = j2 + 1;
                    UnsafeUtil.b0(j2, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.f7100m;
                this.f7100m = 1 + j3;
                UnsafeUtil.b0(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.f7100m;
                if (j4 >= this.f7098k) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f7100m), Long.valueOf(this.f7098k), 1}));
                } else if ((i2 & -128) == 0) {
                    this.f7100m = 1 + j4;
                    UnsafeUtil.b0(j4, (byte) i2);
                    return;
                } else {
                    this.f7100m = j4 + 1;
                    UnsafeUtil.b0(j4, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
                    i2 >>>= 7;
                }
            }
        }

        public void i(int i2, long j2) throws IOException {
            g2(i2, 1);
            D1(j2);
        }

        public void i2(long j2) throws IOException {
            if (this.f7100m <= this.f7099l) {
                while (true) {
                    int i2 = ((j2 & -128) > 0 ? 1 : ((j2 & -128) == 0 ? 0 : -1));
                    long j3 = this.f7100m;
                    if (i2 == 0) {
                        this.f7100m = 1 + j3;
                        UnsafeUtil.b0(j3, (byte) ((int) j2));
                        return;
                    }
                    this.f7100m = j3 + 1;
                    UnsafeUtil.b0(j3, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
                    j2 >>>= 7;
                }
            } else {
                while (true) {
                    long j4 = this.f7100m;
                    if (j4 >= this.f7098k) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f7100m), Long.valueOf(this.f7098k), 1}));
                    } else if ((j2 & -128) == 0) {
                        this.f7100m = 1 + j4;
                        UnsafeUtil.b0(j4, (byte) ((int) j2));
                        return;
                    } else {
                        this.f7100m = j4 + 1;
                        UnsafeUtil.b0(j4, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
                        j2 >>>= 7;
                    }
                }
            }
        }

        public void o(int i2, String str) throws IOException {
            g2(i2, 2);
            f2(str);
        }

        public void p(int i2, long j2) throws IOException {
            g2(i2, 0);
            i2(j2);
        }

        public int r1() {
            return (int) (this.f7098k - this.f7100m);
        }

        public void t(int i2, boolean z) throws IOException {
            g2(i2, 0);
            T(z ? (byte) 1 : 0);
        }

        public void u1(int i2, byte[] bArr) throws IOException {
            v1(i2, bArr, 0, bArr.length);
        }

        public void v1(int i2, byte[] bArr, int i3, int i4) throws IOException {
            g2(i2, 2);
            x1(bArr, i3, i4);
        }

        public void w(int i2, int i3) throws IOException {
            g2(i2, 0);
            J1(i3);
        }

        public void x1(byte[] bArr, int i2, int i3) throws IOException {
            h2(i3);
            V(bArr, i2, i3);
        }

        public void y1(int i2, ByteBuffer byteBuffer) throws IOException {
            g2(i2, 2);
            h2(byteBuffer.capacity());
            T1(byteBuffer);
        }

        public void z(int i2, ByteString byteString) throws IOException {
            g2(i2, 2);
            z1(byteString);
        }

        public void z1(ByteString byteString) throws IOException {
            h2(byteString.size());
            byteString.w0(this);
        }
    }

    private CodedOutputStream() {
    }

    public static int A0(int i2, LazyFieldLite lazyFieldLite) {
        return (X0(1) * 2) + Y0(2, i2) + B0(3, lazyFieldLite);
    }

    public static int B0(int i2, LazyFieldLite lazyFieldLite) {
        return X0(i2) + C0(lazyFieldLite);
    }

    public static int C0(LazyFieldLite lazyFieldLite) {
        return D0(lazyFieldLite.f());
    }

    static int D0(int i2) {
        return Z0(i2) + i2;
    }

    public static int E0(int i2, MessageLite messageLite) {
        return (X0(1) * 2) + Y0(2, i2) + F0(3, messageLite);
    }

    public static int F0(int i2, MessageLite messageLite) {
        return X0(i2) + H0(messageLite);
    }

    static int G0(int i2, MessageLite messageLite, Schema schema) {
        return X0(i2) + I0(messageLite, schema);
    }

    public static int H0(MessageLite messageLite) {
        return D0(messageLite.R0());
    }

    static int I0(MessageLite messageLite, Schema schema) {
        return D0(((AbstractMessageLite) messageLite).I(schema));
    }

    static int J0(int i2) {
        if (i2 > 4096) {
            return 4096;
        }
        return i2;
    }

    public static int K0(int i2, ByteString byteString) {
        return (X0(1) * 2) + Y0(2, i2) + g0(3, byteString);
    }

    @Deprecated
    public static int L0(int i2) {
        return Z0(i2);
    }

    @Deprecated
    public static int M0(long j2) {
        return b1(j2);
    }

    public static int N0(int i2, int i3) {
        return X0(i2) + O0(i3);
    }

    public static int O0(int i2) {
        return 4;
    }

    public static int P0(int i2, long j2) {
        return X0(i2) + Q0(j2);
    }

    public static int Q0(long j2) {
        return 8;
    }

    public static int R0(int i2, int i3) {
        return X0(i2) + S0(i3);
    }

    public static int S0(int i2) {
        return Z0(c1(i2));
    }

    public static int T0(int i2, long j2) {
        return X0(i2) + U0(j2);
    }

    public static int U0(long j2) {
        return b1(d1(j2));
    }

    public static int V0(int i2, String str) {
        return X0(i2) + W0(str);
    }

    public static int W0(String str) {
        int i2;
        try {
            i2 = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i2 = str.getBytes(Internal.f7166a).length;
        }
        return D0(i2);
    }

    public static int X0(int i2) {
        return Z0(WireFormat.c(i2, 0));
    }

    public static int Y0(int i2, int i3) {
        return X0(i2) + Z0(i3);
    }

    public static int Z0(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int a0(int i2, boolean z) {
        return X0(i2) + b0(z);
    }

    public static int a1(int i2, long j2) {
        return X0(i2) + b1(j2);
    }

    public static int b0(boolean z) {
        return 1;
    }

    public static int b1(long j2) {
        int i2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i2 + 1 : i2;
    }

    public static int c0(int i2, byte[] bArr) {
        return X0(i2) + d0(bArr);
    }

    public static int c1(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static int d0(byte[] bArr) {
        return D0(bArr.length);
    }

    public static long d1(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int e0(int i2, ByteBuffer byteBuffer) {
        return X0(i2) + f0(byteBuffer);
    }

    public static int f0(ByteBuffer byteBuffer) {
        return D0(byteBuffer.capacity());
    }

    public static int g0(int i2, ByteString byteString) {
        return X0(i2) + h0(byteString);
    }

    public static int h0(ByteString byteString) {
        return D0(byteString.size());
    }

    public static int i0(int i2, double d2) {
        return X0(i2) + j0(d2);
    }

    static CodedOutputStream i1(ByteOutput byteOutput, int i2) {
        if (i2 >= 0) {
            return new ByteOutputEncoder(byteOutput, i2);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    public static int j0(double d2) {
        return 8;
    }

    public static CodedOutputStream j1(OutputStream outputStream) {
        return k1(outputStream, 4096);
    }

    public static int k0(int i2, int i3) {
        return X0(i2) + l0(i3);
    }

    public static CodedOutputStream k1(OutputStream outputStream, int i2) {
        return new OutputStreamEncoder(outputStream, i2);
    }

    public static int l0(int i2) {
        return x0(i2);
    }

    public static CodedOutputStream l1(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return UnsafeDirectNioEncoder.k2() ? q1(byteBuffer) : p1(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int m0(int i2, int i3) {
        return X0(i2) + n0(i3);
    }

    @Deprecated
    public static CodedOutputStream m1(ByteBuffer byteBuffer, int i2) {
        return l1(byteBuffer);
    }

    public static int n0(int i2) {
        return 4;
    }

    public static CodedOutputStream n1(byte[] bArr) {
        return o1(bArr, 0, bArr.length);
    }

    public static int o0(int i2, long j2) {
        return X0(i2) + p0(j2);
    }

    public static CodedOutputStream o1(byte[] bArr, int i2, int i3) {
        return new ArrayEncoder(bArr, i2, i3);
    }

    public static int p0(long j2) {
        return 8;
    }

    static CodedOutputStream p1(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static int q0(int i2, float f2) {
        return X0(i2) + r0(f2);
    }

    static CodedOutputStream q1(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public static int r0(float f2) {
        return 4;
    }

    @Deprecated
    public static int s0(int i2, MessageLite messageLite) {
        return (X0(i2) * 2) + u0(messageLite);
    }

    @Deprecated
    static int t0(int i2, MessageLite messageLite, Schema schema) {
        return (X0(i2) * 2) + v0(messageLite, schema);
    }

    @Deprecated
    public static int u0(MessageLite messageLite) {
        return messageLite.R0();
    }

    @Deprecated
    static int v0(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).I(schema);
    }

    public static int w0(int i2, int i3) {
        return X0(i2) + x0(i3);
    }

    public static int x0(int i2) {
        if (i2 >= 0) {
            return Z0(i2);
        }
        return 10;
    }

    public static int y0(int i2, long j2) {
        return X0(i2) + z0(j2);
    }

    public static int z0(long j2) {
        return b1(j2);
    }

    public final void A(int i2, long j2) throws IOException {
        i(i2, j2);
    }

    public final void A1(double d2) throws IOException {
        D1(Double.doubleToRawLongBits(d2));
    }

    public final void B1(int i2) throws IOException {
        J1(i2);
    }

    public abstract void C1(int i2) throws IOException;

    public abstract void D1(long j2) throws IOException;

    public final void E1(float f2) throws IOException {
        C1(Float.floatToRawIntBits(f2));
    }

    @Deprecated
    public final void F1(int i2, MessageLite messageLite) throws IOException {
        g2(i2, 3);
        H1(messageLite);
        g2(i2, 4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void G1(int i2, MessageLite messageLite, Schema schema) throws IOException {
        g2(i2, 3);
        I1(messageLite, schema);
        g2(i2, 4);
    }

    public final void H(int i2, long j2) throws IOException {
        p(i2, d1(j2));
    }

    @Deprecated
    public final void H1(MessageLite messageLite) throws IOException {
        messageLite.j1(this);
    }

    public final void I(int i2, float f2) throws IOException {
        d(i2, Float.floatToRawIntBits(f2));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void I1(MessageLite messageLite, Schema schema) throws IOException {
        schema.e(messageLite, this.f7077a);
    }

    public abstract void J1(int i2) throws IOException;

    public final void K1(long j2) throws IOException {
        i2(j2);
    }

    public final void L(int i2, int i3) throws IOException {
        w(i2, i3);
    }

    public abstract void L1(int i2, MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void M1(int i2, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void N1(MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void O1(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void P1(int i2, MessageLite messageLite) throws IOException;

    public final void Q(int i2, int i3) throws IOException {
        b(i2, c1(i3));
    }

    public final void Q1(byte b2) throws IOException {
        T(b2);
    }

    public final void R1(int i2) throws IOException {
        T((byte) i2);
    }

    public final void S1(ByteString byteString) throws IOException {
        byteString.w0(this);
    }

    public abstract void T(byte b2) throws IOException;

    public abstract void T1(ByteBuffer byteBuffer) throws IOException;

    public abstract void U(ByteBuffer byteBuffer) throws IOException;

    public final void U1(byte[] bArr) throws IOException {
        V(bArr, 0, bArr.length);
    }

    public abstract void V(byte[] bArr, int i2, int i3) throws IOException;

    public final void V1(byte[] bArr, int i2, int i3) throws IOException {
        V(bArr, i2, i3);
    }

    public abstract void W(ByteBuffer byteBuffer) throws IOException;

    @Deprecated
    public final void W1(int i2) throws IOException {
        C1(i2);
    }

    public abstract void X(byte[] bArr, int i2, int i3) throws IOException;

    @Deprecated
    public final void X1(long j2) throws IOException {
        D1(j2);
    }

    public abstract void Y1(int i2, ByteString byteString) throws IOException;

    public final void Z() {
        if (r1() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    public final void Z1(int i2) throws IOException {
        h2(i2);
    }

    @Deprecated
    public final void a2(long j2) throws IOException {
        i2(j2);
    }

    public abstract void b(int i2, int i3) throws IOException;

    public final void b2(int i2) throws IOException {
        C1(i2);
    }

    public final void c2(long j2) throws IOException {
        D1(j2);
    }

    public abstract void d(int i2, int i3) throws IOException;

    public final void d2(int i2) throws IOException {
        h2(c1(i2));
    }

    public final void e(int i2, double d2) throws IOException {
        i(i2, Double.doubleToRawLongBits(d2));
    }

    public abstract void e1() throws IOException;

    public final void e2(long j2) throws IOException {
        i2(d1(j2));
    }

    public abstract int f1();

    public abstract void f2(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public final void g1(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f7073c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f7166a);
        try {
            h2(bytes.length);
            X(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException((Throwable) e2);
        } catch (OutOfSpaceException e3) {
            throw e3;
        }
    }

    public abstract void g2(int i2, int i3) throws IOException;

    /* access modifiers changed from: package-private */
    public boolean h1() {
        return this.f7078b;
    }

    public abstract void h2(int i2) throws IOException;

    public abstract void i(int i2, long j2) throws IOException;

    public abstract void i2(long j2) throws IOException;

    public abstract void o(int i2, String str) throws IOException;

    public abstract void p(int i2, long j2) throws IOException;

    public abstract int r1();

    public final void s(int i2, long j2) throws IOException {
        p(i2, j2);
    }

    public void s1() {
        this.f7078b = true;
    }

    public abstract void t(int i2, boolean z) throws IOException;

    public final void t1(boolean z) throws IOException {
        T(z ? (byte) 1 : 0);
    }

    public final void u(int i2, int i3) throws IOException {
        d(i2, i3);
    }

    public abstract void u1(int i2, byte[] bArr) throws IOException;

    public abstract void v1(int i2, byte[] bArr, int i3, int i4) throws IOException;

    public abstract void w(int i2, int i3) throws IOException;

    public final void w1(byte[] bArr) throws IOException {
        x1(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public abstract void x1(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void y1(int i2, ByteBuffer byteBuffer) throws IOException;

    public abstract void z(int i2, ByteString byteString) throws IOException;

    public abstract void z1(ByteString byteString) throws IOException;
}
