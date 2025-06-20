package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import com.google.common.base.Ascii;
import com.itextpdf.tool.xml.html.HTML;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public abstract class CodedInputStream {

    /* renamed from: f  reason: collision with root package name */
    private static final int f7030f = 4096;

    /* renamed from: g  reason: collision with root package name */
    private static final int f7031g = 100;

    /* renamed from: h  reason: collision with root package name */
    private static final int f7032h = Integer.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    int f7033a;

    /* renamed from: b  reason: collision with root package name */
    int f7034b;

    /* renamed from: c  reason: collision with root package name */
    int f7035c;

    /* renamed from: d  reason: collision with root package name */
    CodedInputStreamReader f7036d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7037e;

    private static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: i  reason: collision with root package name */
        private final byte[] f7038i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f7039j;

        /* renamed from: k  reason: collision with root package name */
        private int f7040k;

        /* renamed from: l  reason: collision with root package name */
        private int f7041l;

        /* renamed from: m  reason: collision with root package name */
        private int f7042m;

        /* renamed from: n  reason: collision with root package name */
        private int f7043n;
        private int o;
        private boolean p;
        private int q;

        private ArrayDecoder(byte[] bArr, int i2, int i3, boolean z) {
            super();
            this.q = Integer.MAX_VALUE;
            this.f7038i = bArr;
            this.f7040k = i3 + i2;
            this.f7042m = i2;
            this.f7043n = i2;
            this.f7039j = z;
        }

        private void m0() {
            int i2 = this.f7040k + this.f7041l;
            this.f7040k = i2;
            int i3 = i2 - this.f7043n;
            int i4 = this.q;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f7041l = i5;
                this.f7040k = i2 - i5;
                return;
            }
            this.f7041l = 0;
        }

        private void n0() throws IOException {
            if (this.f7040k - this.f7042m >= 10) {
                o0();
            } else {
                p0();
            }
        }

        private void o0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                byte[] bArr = this.f7038i;
                int i3 = this.f7042m;
                this.f7042m = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void p0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                if (J() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public int A() throws IOException {
            return L();
        }

        public long B() throws IOException {
            return M();
        }

        public float C() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public <T extends MessageLite> T D(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                T t = (MessageLite) parser.y(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return t;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void E(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                builder.Q1(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public int F() throws IOException {
            return N();
        }

        public long G() throws IOException {
            return Q();
        }

        public <T extends MessageLite> T H(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                T t2 = (MessageLite) parser.y(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return t2;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void I(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                builder.Q1(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public byte J() throws IOException {
            int i2 = this.f7042m;
            if (i2 != this.f7040k) {
                byte[] bArr = this.f7038i;
                this.f7042m = i2 + 1;
                return bArr[i2];
            }
            throw InvalidProtocolBufferException.l();
        }

        public byte[] K(int i2) throws IOException {
            if (i2 > 0) {
                int i3 = this.f7040k;
                int i4 = this.f7042m;
                if (i2 <= i3 - i4) {
                    int i5 = i2 + i4;
                    this.f7042m = i5;
                    return Arrays.copyOfRange(this.f7038i, i4, i5);
                }
            }
            if (i2 > 0) {
                throw InvalidProtocolBufferException.l();
            } else if (i2 == 0) {
                return Internal.f7169d;
            } else {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int L() throws IOException {
            int i2 = this.f7042m;
            if (this.f7040k - i2 >= 4) {
                byte[] bArr = this.f7038i;
                this.f7042m = i2 + 4;
                return ((bArr[i2 + 3] & 255) << Ascii.B) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.l();
        }

        public long M() throws IOException {
            int i2 = this.f7042m;
            if (this.f7040k - i2 >= 8) {
                byte[] bArr = this.f7038i;
                this.f7042m = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.l();
        }

        public int N() throws IOException {
            byte b2;
            byte b3;
            int i2 = this.f7042m;
            int i3 = this.f7040k;
            if (i3 != i2) {
                byte[] bArr = this.f7038i;
                int i4 = i2 + 1;
                byte b4 = bArr[i2];
                if (b4 >= 0) {
                    this.f7042m = i4;
                    return b4;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b5 = (bArr[i4] << 7) ^ b4;
                    if (b5 < 0) {
                        b2 = b5 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b6 = (bArr[i5] << 14) ^ b5;
                        if (b6 >= 0) {
                            b3 = b6 ^ 16256;
                        } else {
                            int i7 = i2 + 4;
                            byte b7 = b6 ^ (bArr[i6] << Ascii.y);
                            if (b7 < 0) {
                                b2 = -2080896 ^ b7;
                            } else {
                                i6 = i2 + 5;
                                byte b8 = bArr[i7];
                                byte b9 = (b7 ^ (b8 << Ascii.F)) ^ 266354560;
                                if (b8 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b10 = b9;
                                                        i5 = i8;
                                                        b2 = b10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b2 = b9;
                                }
                                b3 = b9;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.f7042m = i5;
                    return b2;
                }
            }
            return (int) R();
        }

        public long Q() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2 = this.f7042m;
            int i3 = this.f7040k;
            if (i3 != i2) {
                byte[] bArr = this.f7038i;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f7042m = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b3 = (bArr[i4] << 7) ^ b2;
                    if (b3 < 0) {
                        j2 = (long) (b3 ^ Byte.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b4 = (bArr[i5] << 14) ^ b3;
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ 16256);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b5 = b4 ^ (bArr[i6] << Ascii.y);
                            if (b5 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b5);
                            } else {
                                long j5 = (long) b5;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.f7042m = i5;
                    return j2;
                }
            }
            return R();
        }

        /* access modifiers changed from: package-private */
        public long R() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte J = J();
                j2 |= ((long) (J & Byte.MAX_VALUE)) << i2;
                if ((J & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public int S() throws IOException {
            return L();
        }

        public long T() throws IOException {
            return M();
        }

        public int U() throws IOException {
            return CodedInputStream.b(N());
        }

        public long V() throws IOException {
            return CodedInputStream.c(Q());
        }

        public String W() throws IOException {
            int N = N();
            if (N > 0) {
                int i2 = this.f7040k;
                int i3 = this.f7042m;
                if (N <= i2 - i3) {
                    String str = new String(this.f7038i, i3, N, Internal.f7166a);
                    this.f7042m += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.l();
        }

        public String X() throws IOException {
            int N = N();
            if (N > 0) {
                int i2 = this.f7040k;
                int i3 = this.f7042m;
                if (N <= i2 - i3) {
                    String h2 = Utf8.h(this.f7038i, i3, N);
                    this.f7042m += N;
                    return h2;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.l();
        }

        public int Y() throws IOException {
            if (i()) {
                this.o = 0;
                return 0;
            }
            int N = N();
            this.o = N;
            if (WireFormat.a(N) != 0) {
                return this.o;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int Z() throws IOException {
            return N();
        }

        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.o != i2) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public long a0() throws IOException {
            return Q();
        }

        @Deprecated
        public void b0(int i2, MessageLite.Builder builder) throws IOException {
            E(i2, builder, ExtensionRegistryLite.d());
        }

        public void c0() {
            this.f7043n = this.f7042m;
        }

        public void e(boolean z) {
            this.p = z;
        }

        public int f() {
            int i2 = this.q;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - h();
        }

        public int g() {
            return this.o;
        }

        public boolean g0(int i2) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                n0();
                return true;
            } else if (b2 == 1) {
                k0(8);
                return true;
            } else if (b2 == 2) {
                k0(N());
                return true;
            } else if (b2 == 3) {
                i0();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    k0(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public int h() {
            return this.f7042m - this.f7043n;
        }

        public boolean h0(int i2, CodedOutputStream codedOutputStream) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                long G = G();
                codedOutputStream.Z1(i2);
                codedOutputStream.i2(G);
                return true;
            } else if (b2 == 1) {
                long M = M();
                codedOutputStream.Z1(i2);
                codedOutputStream.D1(M);
                return true;
            } else if (b2 == 2) {
                ByteString x = x();
                codedOutputStream.Z1(i2);
                codedOutputStream.z1(x);
                return true;
            } else if (b2 == 3) {
                codedOutputStream.Z1(i2);
                j0(codedOutputStream);
                int c2 = WireFormat.c(WireFormat.a(i2), 4);
                a(c2);
                codedOutputStream.Z1(c2);
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    int L = L();
                    codedOutputStream.Z1(i2);
                    codedOutputStream.C1(L);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public boolean i() throws IOException {
            return this.f7042m == this.f7040k;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void i0() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.g0(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.i0():void");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void j0(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.h0(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.j0(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public void k0(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.f7040k;
                int i4 = this.f7042m;
                if (i2 <= i3 - i4) {
                    this.f7042m = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.l();
        }

        public void s(int i2) {
            this.q = i2;
            m0();
        }

        public int t(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int h2 = i2 + h();
                int i3 = this.q;
                if (h2 <= i3) {
                    this.q = h2;
                    m0();
                    return i3;
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean u() throws IOException {
            return Q() != 0;
        }

        public byte[] v() throws IOException {
            return K(N());
        }

        public ByteBuffer w() throws IOException {
            int N = N();
            if (N > 0) {
                int i2 = this.f7040k;
                int i3 = this.f7042m;
                if (N <= i2 - i3) {
                    ByteBuffer wrap = (this.f7039j || !this.p) ? ByteBuffer.wrap(Arrays.copyOfRange(this.f7038i, i3, i3 + N)) : ByteBuffer.wrap(this.f7038i, i3, N).slice();
                    this.f7042m += N;
                    return wrap;
                }
            }
            if (N == 0) {
                return Internal.f7170e;
            }
            if (N < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.l();
        }

        public ByteString x() throws IOException {
            int N = N();
            if (N > 0) {
                int i2 = this.f7040k;
                int i3 = this.f7042m;
                if (N <= i2 - i3) {
                    ByteString z = (!this.f7039j || !this.p) ? ByteString.z(this.f7038i, i3, N) : ByteString.u0(this.f7038i, i3, N);
                    this.f7042m += N;
                    return z;
                }
            }
            return N == 0 ? ByteString.X2 : ByteString.t0(K(N));
        }

        public double y() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int z() throws IOException {
            return N();
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* renamed from: i  reason: collision with root package name */
        private Iterable<ByteBuffer> f7044i;

        /* renamed from: j  reason: collision with root package name */
        private Iterator<ByteBuffer> f7045j;

        /* renamed from: k  reason: collision with root package name */
        private ByteBuffer f7046k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f7047l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f7048m;

        /* renamed from: n  reason: collision with root package name */
        private int f7049n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private long t;
        private long u;
        private long v;
        private long w;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i2, boolean z) {
            super();
            this.p = Integer.MAX_VALUE;
            this.f7049n = i2;
            this.f7044i = iterable;
            this.f7045j = iterable.iterator();
            this.f7047l = z;
            this.r = 0;
            this.s = 0;
            if (i2 == 0) {
                this.f7046k = Internal.f7170e;
                this.t = 0;
                this.u = 0;
                this.w = 0;
                this.v = 0;
                return;
            }
            t0();
        }

        private long m0() {
            return this.w - this.t;
        }

        private void n0() throws InvalidProtocolBufferException {
            if (this.f7045j.hasNext()) {
                t0();
                return;
            }
            throw InvalidProtocolBufferException.l();
        }

        private void o0(byte[] bArr, int i2, int i3) throws IOException {
            if (i3 >= 0 && i3 <= q0()) {
                int i4 = i3;
                while (i4 > 0) {
                    if (m0() == 0) {
                        n0();
                    }
                    int min = Math.min(i4, (int) m0());
                    long j2 = (long) min;
                    UnsafeUtil.n(this.t, bArr, (long) ((i3 - i4) + i2), j2);
                    i4 -= min;
                    this.t += j2;
                }
            } else if (i3 > 0) {
                throw InvalidProtocolBufferException.l();
            } else if (i3 != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void p0() {
            int i2 = this.f7049n + this.o;
            this.f7049n = i2;
            int i3 = i2 - this.s;
            int i4 = this.p;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.o = i5;
                this.f7049n = i2 - i5;
                return;
            }
            this.o = 0;
        }

        private int q0() {
            return (int) ((((long) (this.f7049n - this.r)) - this.t) + this.u);
        }

        private void r0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                if (J() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r3.f7046k.position(r0);
            r3.f7046k.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer s0(int r4, int r5) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f7046k
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f7046k
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f7046k     // Catch:{ IllegalArgumentException -> 0x0029 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.f7046k     // Catch:{ IllegalArgumentException -> 0x0029 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.f7046k     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r5 = r3.f7046k
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f7046k
                r5.limit(r1)
                return r4
            L_0x0027:
                r4 = move-exception
                goto L_0x002e
            L_0x0029:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()     // Catch:{ all -> 0x0027 }
                throw r4     // Catch:{ all -> 0x0027 }
            L_0x002e:
                java.nio.ByteBuffer r5 = r3.f7046k
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f7046k
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.s0(int, int):java.nio.ByteBuffer");
        }

        private void t0() {
            ByteBuffer next = this.f7045j.next();
            this.f7046k = next;
            this.r += (int) (this.t - this.u);
            long position = (long) next.position();
            this.t = position;
            this.u = position;
            this.w = (long) this.f7046k.limit();
            long i2 = UnsafeUtil.i(this.f7046k);
            this.v = i2;
            this.t += i2;
            this.u += i2;
            this.w += i2;
        }

        public int A() throws IOException {
            return L();
        }

        public long B() throws IOException {
            return M();
        }

        public float C() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public <T extends MessageLite> T D(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                T t2 = (MessageLite) parser.y(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return t2;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void E(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                builder.Q1(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public int F() throws IOException {
            return N();
        }

        public long G() throws IOException {
            return Q();
        }

        public <T extends MessageLite> T H(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t2 = t(N);
                this.f7033a++;
                T t3 = (MessageLite) parser.y(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t2);
                return t3;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void I(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t2 = t(N);
                this.f7033a++;
                builder.Q1(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t2);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public byte J() throws IOException {
            if (m0() == 0) {
                n0();
            }
            long j2 = this.t;
            this.t = 1 + j2;
            return UnsafeUtil.y(j2);
        }

        public byte[] K(int i2) throws IOException {
            if (i2 >= 0) {
                long j2 = (long) i2;
                if (j2 <= m0()) {
                    byte[] bArr = new byte[i2];
                    UnsafeUtil.n(this.t, bArr, 0, j2);
                    this.t += j2;
                    return bArr;
                }
            }
            if (i2 >= 0 && i2 <= q0()) {
                byte[] bArr2 = new byte[i2];
                o0(bArr2, 0, i2);
                return bArr2;
            } else if (i2 > 0) {
                throw InvalidProtocolBufferException.l();
            } else if (i2 == 0) {
                return Internal.f7169d;
            } else {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int L() throws IOException {
            if (m0() < 4) {
                return (J() & 255) | ((J() & 255) << 8) | ((J() & 255) << 16) | ((J() & 255) << Ascii.B);
            }
            long j2 = this.t;
            this.t = 4 + j2;
            return ((UnsafeUtil.y(j2 + 3) & 255) << Ascii.B) | (UnsafeUtil.y(j2) & 255) | ((UnsafeUtil.y(1 + j2) & 255) << 8) | ((UnsafeUtil.y(2 + j2) & 255) << 16);
        }

        public long M() throws IOException {
            if (m0() < 8) {
                return (((long) J()) & 255) | ((((long) J()) & 255) << 8) | ((((long) J()) & 255) << 16) | ((((long) J()) & 255) << 24) | ((((long) J()) & 255) << 32) | ((((long) J()) & 255) << 40) | ((((long) J()) & 255) << 48) | ((((long) J()) & 255) << 56);
            }
            long j2 = this.t;
            this.t = 8 + j2;
            long y = (((long) UnsafeUtil.y(j2)) & 255) | ((((long) UnsafeUtil.y(1 + j2)) & 255) << 8);
            return ((((long) UnsafeUtil.y(j2 + 7)) & 255) << 56) | ((((long) UnsafeUtil.y(2 + j2)) & 255) << 16) | y | ((((long) UnsafeUtil.y(3 + j2)) & 255) << 24) | ((((long) UnsafeUtil.y(4 + j2)) & 255) << 32) | ((((long) UnsafeUtil.y(5 + j2)) & 255) << 40) | ((((long) UnsafeUtil.y(6 + j2)) & 255) << 48);
        }

        public int N() throws IOException {
            byte b2;
            byte b3;
            long j2 = this.t;
            if (this.w != j2) {
                long j3 = j2 + 1;
                byte y = UnsafeUtil.y(j2);
                if (y >= 0) {
                    this.t++;
                    return y;
                } else if (this.w - this.t >= 10) {
                    long j4 = 2 + j2;
                    byte y2 = (UnsafeUtil.y(j3) << 7) ^ y;
                    if (y2 < 0) {
                        b2 = y2 ^ Byte.MIN_VALUE;
                    } else {
                        long j5 = 3 + j2;
                        byte y3 = (UnsafeUtil.y(j4) << 14) ^ y2;
                        if (y3 >= 0) {
                            b3 = y3 ^ 16256;
                        } else {
                            long j6 = 4 + j2;
                            byte y4 = y3 ^ (UnsafeUtil.y(j5) << Ascii.y);
                            if (y4 < 0) {
                                b2 = -2080896 ^ y4;
                            } else {
                                j5 = 5 + j2;
                                byte y5 = UnsafeUtil.y(j6);
                                byte b4 = (y4 ^ (y5 << Ascii.F)) ^ 266354560;
                                if (y5 < 0) {
                                    j6 = 6 + j2;
                                    if (UnsafeUtil.y(j5) < 0) {
                                        j5 = 7 + j2;
                                        if (UnsafeUtil.y(j6) < 0) {
                                            j6 = 8 + j2;
                                            if (UnsafeUtil.y(j5) < 0) {
                                                j5 = 9 + j2;
                                                if (UnsafeUtil.y(j6) < 0) {
                                                    long j7 = j2 + 10;
                                                    if (UnsafeUtil.y(j5) >= 0) {
                                                        long j8 = j7;
                                                        b2 = b4;
                                                        j4 = j8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b2 = b4;
                                }
                                b3 = b4;
                            }
                            j4 = j6;
                        }
                        j4 = j5;
                    }
                    this.t = j4;
                    return b2;
                }
            }
            return (int) R();
        }

        public long Q() throws IOException {
            long j2;
            long j3;
            long j4;
            long j5 = this.t;
            if (this.w != j5) {
                long j6 = j5 + 1;
                byte y = UnsafeUtil.y(j5);
                if (y >= 0) {
                    this.t++;
                    return (long) y;
                } else if (this.w - this.t >= 10) {
                    long j7 = 2 + j5;
                    byte y2 = (UnsafeUtil.y(j6) << 7) ^ y;
                    if (y2 < 0) {
                        j2 = (long) (y2 ^ Byte.MIN_VALUE);
                    } else {
                        long j8 = 3 + j5;
                        byte y3 = (UnsafeUtil.y(j7) << 14) ^ y2;
                        if (y3 >= 0) {
                            j2 = (long) (y3 ^ 16256);
                            j7 = j8;
                        } else {
                            long j9 = 4 + j5;
                            byte y4 = y3 ^ (UnsafeUtil.y(j8) << Ascii.y);
                            if (y4 < 0) {
                                j2 = (long) (-2080896 ^ y4);
                                j7 = j9;
                            } else {
                                long j10 = 5 + j5;
                                long y5 = (((long) UnsafeUtil.y(j9)) << 28) ^ ((long) y4);
                                if (y5 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j11 = 6 + j5;
                                    long y6 = y5 ^ (((long) UnsafeUtil.y(j10)) << 35);
                                    if (y6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j10 = 7 + j5;
                                        y5 = y6 ^ (((long) UnsafeUtil.y(j11)) << 42);
                                        if (y5 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j11 = 8 + j5;
                                            y6 = y5 ^ (((long) UnsafeUtil.y(j10)) << 49);
                                            if (y6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j10 = 9 + j5;
                                                long y7 = (y6 ^ (((long) UnsafeUtil.y(j11)) << 56)) ^ 71499008037633920L;
                                                if (y7 < 0) {
                                                    long j12 = j5 + 10;
                                                    if (((long) UnsafeUtil.y(j10)) >= 0) {
                                                        long j13 = j12;
                                                        j2 = y7;
                                                        j7 = j13;
                                                    }
                                                } else {
                                                    j2 = y7;
                                                    j7 = j10;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ y6;
                                    j7 = j11;
                                }
                                j2 = j4 ^ y5;
                                j7 = j10;
                            }
                        }
                    }
                    this.t = j7;
                    return j2;
                }
            }
            return R();
        }

        /* access modifiers changed from: package-private */
        public long R() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte J = J();
                j2 |= ((long) (J & Byte.MAX_VALUE)) << i2;
                if ((J & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public int S() throws IOException {
            return L();
        }

        public long T() throws IOException {
            return M();
        }

        public int U() throws IOException {
            return CodedInputStream.b(N());
        }

        public long V() throws IOException {
            return CodedInputStream.c(Q());
        }

        public String W() throws IOException {
            int N = N();
            if (N > 0) {
                long j2 = (long) N;
                long j3 = this.w;
                long j4 = this.t;
                if (j2 <= j3 - j4) {
                    byte[] bArr = new byte[N];
                    UnsafeUtil.n(j4, bArr, 0, j2);
                    String str = new String(bArr, Internal.f7166a);
                    this.t += j2;
                    return str;
                }
            }
            if (N > 0 && N <= q0()) {
                byte[] bArr2 = new byte[N];
                o0(bArr2, 0, N);
                return new String(bArr2, Internal.f7166a);
            } else if (N == 0) {
                return "";
            } else {
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public String X() throws IOException {
            int N = N();
            if (N > 0) {
                long j2 = (long) N;
                long j3 = this.w;
                long j4 = this.t;
                if (j2 <= j3 - j4) {
                    String g2 = Utf8.g(this.f7046k, (int) (j4 - this.u), N);
                    this.t += j2;
                    return g2;
                }
            }
            if (N >= 0 && N <= q0()) {
                byte[] bArr = new byte[N];
                o0(bArr, 0, N);
                return Utf8.h(bArr, 0, N);
            } else if (N == 0) {
                return "";
            } else {
                if (N <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public int Y() throws IOException {
            if (i()) {
                this.q = 0;
                return 0;
            }
            int N = N();
            this.q = N;
            if (WireFormat.a(N) != 0) {
                return this.q;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int Z() throws IOException {
            return N();
        }

        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.q != i2) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public long a0() throws IOException {
            return Q();
        }

        @Deprecated
        public void b0(int i2, MessageLite.Builder builder) throws IOException {
            E(i2, builder, ExtensionRegistryLite.d());
        }

        public void c0() {
            this.s = (int) ((((long) this.r) + this.t) - this.u);
        }

        public void e(boolean z) {
            this.f7048m = z;
        }

        public int f() {
            int i2 = this.p;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - h();
        }

        public int g() {
            return this.q;
        }

        public boolean g0(int i2) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                r0();
                return true;
            } else if (b2 == 1) {
                k0(8);
                return true;
            } else if (b2 == 2) {
                k0(N());
                return true;
            } else if (b2 == 3) {
                i0();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    k0(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public int h() {
            return (int) ((((long) (this.r - this.s)) + this.t) - this.u);
        }

        public boolean h0(int i2, CodedOutputStream codedOutputStream) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                long G = G();
                codedOutputStream.Z1(i2);
                codedOutputStream.i2(G);
                return true;
            } else if (b2 == 1) {
                long M = M();
                codedOutputStream.Z1(i2);
                codedOutputStream.D1(M);
                return true;
            } else if (b2 == 2) {
                ByteString x = x();
                codedOutputStream.Z1(i2);
                codedOutputStream.z1(x);
                return true;
            } else if (b2 == 3) {
                codedOutputStream.Z1(i2);
                j0(codedOutputStream);
                int c2 = WireFormat.c(WireFormat.a(i2), 4);
                a(c2);
                codedOutputStream.Z1(c2);
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    int L = L();
                    codedOutputStream.Z1(i2);
                    codedOutputStream.C1(L);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public boolean i() throws IOException {
            return (((long) this.r) + this.t) - this.u == ((long) this.f7049n);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void i0() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.g0(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.i0():void");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void j0(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.h0(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.j0(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public void k0(int i2) throws IOException {
            if (i2 >= 0 && ((long) i2) <= (((long) (this.f7049n - this.r)) - this.t) + this.u) {
                while (i2 > 0) {
                    if (m0() == 0) {
                        n0();
                    }
                    int min = Math.min(i2, (int) m0());
                    i2 -= min;
                    this.t += (long) min;
                }
            } else if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.l();
            }
        }

        public void s(int i2) {
            this.p = i2;
            p0();
        }

        public int t(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int h2 = i2 + h();
                int i3 = this.p;
                if (h2 <= i3) {
                    this.p = h2;
                    p0();
                    return i3;
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean u() throws IOException {
            return Q() != 0;
        }

        public byte[] v() throws IOException {
            return K(N());
        }

        public ByteBuffer w() throws IOException {
            int N = N();
            if (N > 0) {
                long j2 = (long) N;
                if (j2 <= m0()) {
                    if (this.f7047l || !this.f7048m) {
                        byte[] bArr = new byte[N];
                        UnsafeUtil.n(this.t, bArr, 0, j2);
                        this.t += j2;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j3 = this.t + j2;
                    this.t = j3;
                    long j4 = this.v;
                    return s0((int) ((j3 - j4) - j2), (int) (j3 - j4));
                }
            }
            if (N > 0 && N <= q0()) {
                byte[] bArr2 = new byte[N];
                o0(bArr2, 0, N);
                return ByteBuffer.wrap(bArr2);
            } else if (N == 0) {
                return Internal.f7170e;
            } else {
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public ByteString x() throws IOException {
            int N = N();
            if (N > 0) {
                long j2 = (long) N;
                long j3 = this.w;
                long j4 = this.t;
                if (j2 <= j3 - j4) {
                    if (!this.f7047l || !this.f7048m) {
                        byte[] bArr = new byte[N];
                        UnsafeUtil.n(j4, bArr, 0, j2);
                        this.t += j2;
                        return ByteString.t0(bArr);
                    }
                    int i2 = (int) (j4 - this.v);
                    ByteString q0 = ByteString.q0(s0(i2, N + i2));
                    this.t += j2;
                    return q0;
                }
            }
            if (N > 0 && N <= q0()) {
                byte[] bArr2 = new byte[N];
                o0(bArr2, 0, N);
                return ByteString.t0(bArr2);
            } else if (N == 0) {
                return ByteString.X2;
            } else {
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public double y() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int z() throws IOException {
            return N();
        }
    }

    private static final class StreamDecoder extends CodedInputStream {

        /* renamed from: i  reason: collision with root package name */
        private final InputStream f7050i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f7051j;

        /* renamed from: k  reason: collision with root package name */
        private int f7052k;

        /* renamed from: l  reason: collision with root package name */
        private int f7053l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f7054m;

        /* renamed from: n  reason: collision with root package name */
        private int f7055n;
        private int o;
        private int p;
        private RefillCallback q;

        private interface RefillCallback {
            void a();
        }

        private class SkippedDataSink implements RefillCallback {

            /* renamed from: a  reason: collision with root package name */
            private int f7056a;

            /* renamed from: b  reason: collision with root package name */
            private ByteArrayOutputStream f7057b;

            private SkippedDataSink() {
                this.f7056a = StreamDecoder.this.f7054m;
            }

            public void a() {
                if (this.f7057b == null) {
                    this.f7057b = new ByteArrayOutputStream();
                }
                this.f7057b.write(StreamDecoder.this.f7051j, this.f7056a, StreamDecoder.this.f7054m - this.f7056a);
                this.f7056a = 0;
            }

            /* access modifiers changed from: package-private */
            public ByteBuffer b() {
                ByteArrayOutputStream byteArrayOutputStream = this.f7057b;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.f7051j, this.f7056a, StreamDecoder.this.f7054m - this.f7056a);
                }
                byteArrayOutputStream.write(StreamDecoder.this.f7051j, this.f7056a, StreamDecoder.this.f7054m);
                return ByteBuffer.wrap(this.f7057b.toByteArray());
            }
        }

        private StreamDecoder(InputStream inputStream, int i2) {
            super();
            this.p = Integer.MAX_VALUE;
            this.q = null;
            Internal.e(inputStream, HTML.Tag.q0);
            this.f7050i = inputStream;
            this.f7051j = new byte[i2];
            this.f7052k = 0;
            this.f7054m = 0;
            this.o = 0;
        }

        private ByteString o0(int i2) throws IOException {
            byte[] q0 = q0(i2);
            if (q0 != null) {
                return ByteString.x(q0);
            }
            int i3 = this.f7054m;
            int i4 = this.f7052k;
            int i5 = i4 - i3;
            this.o += i4;
            this.f7054m = 0;
            this.f7052k = 0;
            List<byte[]> r0 = r0(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f7051j, i3, bArr, 0, i5);
            for (byte[] next : r0) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return ByteString.t0(bArr);
        }

        private byte[] p0(int i2, boolean z) throws IOException {
            byte[] q0 = q0(i2);
            if (q0 != null) {
                return z ? (byte[]) q0.clone() : q0;
            }
            int i3 = this.f7054m;
            int i4 = this.f7052k;
            int i5 = i4 - i3;
            this.o += i4;
            this.f7054m = 0;
            this.f7052k = 0;
            List<byte[]> r0 = r0(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f7051j, i3, bArr, 0, i5);
            for (byte[] next : r0) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return bArr;
        }

        private byte[] q0(int i2) throws IOException {
            if (i2 == 0) {
                return Internal.f7169d;
            }
            if (i2 >= 0) {
                int i3 = this.o;
                int i4 = this.f7054m;
                int i5 = i3 + i4 + i2;
                if (i5 - this.f7035c <= 0) {
                    int i6 = this.p;
                    if (i5 <= i6) {
                        int i7 = this.f7052k - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f7050i.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f7051j, this.f7054m, bArr, 0, i7);
                        this.o += this.f7052k;
                        this.f7054m = 0;
                        this.f7052k = 0;
                        while (i7 < i2) {
                            int read = this.f7050i.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.o += read;
                                i7 += read;
                            } else {
                                throw InvalidProtocolBufferException.l();
                            }
                        }
                        return bArr;
                    }
                    k0((i6 - i3) - i4);
                    throw InvalidProtocolBufferException.l();
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.g();
        }

        private List<byte[]> r0(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.f7050i.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.o += read;
                        i3 += read;
                    } else {
                        throw InvalidProtocolBufferException.l();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void s0() {
            int i2 = this.f7052k + this.f7053l;
            this.f7052k = i2;
            int i3 = this.o + i2;
            int i4 = this.p;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f7053l = i5;
                this.f7052k = i2 - i5;
                return;
            }
            this.f7053l = 0;
        }

        private void t0(int i2) throws IOException {
            if (y0(i2)) {
                return;
            }
            if (i2 > (this.f7035c - this.o) - this.f7054m) {
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.l();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f7050i.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void u0(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0094
                int r0 = r8.o
                int r1 = r8.f7054m
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.p
                if (r2 > r3) goto L_0x008a
                androidx.datastore.preferences.protobuf.CodedInputStream$StreamDecoder$RefillCallback r2 = r8.q
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.o = r0
                int r0 = r8.f7052k
                int r0 = r0 - r1
                r8.f7052k = r3
                r8.f7054m = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f7050i     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = r1.skip(r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r1 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r1
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.f7050i     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.o
                int r0 = r0 + r3
                r8.o = r0
                r8.s0()
                throw r9
            L_0x0067:
                int r0 = r8.o
                int r0 = r0 + r3
                r8.o = r0
                r8.s0()
            L_0x006f:
                if (r3 >= r9) goto L_0x0089
                int r0 = r8.f7052k
                int r1 = r8.f7054m
                int r1 = r0 - r1
                r8.f7054m = r0
                r0 = 1
            L_0x007a:
                r8.t0(r0)
                int r2 = r9 - r1
                int r3 = r8.f7052k
                if (r2 <= r3) goto L_0x0087
                int r1 = r1 + r3
                r8.f7054m = r3
                goto L_0x007a
            L_0x0087:
                r8.f7054m = r2
            L_0x0089:
                return
            L_0x008a:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.k0(r3)
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()
                throw r9
            L_0x0094:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.u0(int):void");
        }

        private void v0() throws IOException {
            if (this.f7052k - this.f7054m >= 10) {
                w0();
            } else {
                x0();
            }
        }

        private void w0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                byte[] bArr = this.f7051j;
                int i3 = this.f7054m;
                this.f7054m = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void x0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                if (J() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean y0(int i2) throws IOException {
            int i3 = this.f7054m;
            if (i3 + i2 > this.f7052k) {
                int i4 = this.f7035c;
                int i5 = this.o;
                if (i2 > (i4 - i5) - i3 || i5 + i3 + i2 > this.p) {
                    return false;
                }
                RefillCallback refillCallback = this.q;
                if (refillCallback != null) {
                    refillCallback.a();
                }
                int i6 = this.f7054m;
                if (i6 > 0) {
                    int i7 = this.f7052k;
                    if (i7 > i6) {
                        byte[] bArr = this.f7051j;
                        System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                    }
                    this.o += i6;
                    this.f7052k -= i6;
                    this.f7054m = 0;
                }
                InputStream inputStream = this.f7050i;
                byte[] bArr2 = this.f7051j;
                int i8 = this.f7052k;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.f7035c - this.o) - i8));
                if (read == 0 || read < -1 || read > this.f7051j.length) {
                    throw new IllegalStateException(this.f7050i.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f7052k += read;
                    s0();
                    if (this.f7052k >= i2) {
                        return true;
                    }
                    return y0(i2);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
            }
        }

        public int A() throws IOException {
            return L();
        }

        public long B() throws IOException {
            return M();
        }

        public float C() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public <T extends MessageLite> T D(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                T t = (MessageLite) parser.y(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return t;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void E(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                builder.Q1(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public int F() throws IOException {
            return N();
        }

        public long G() throws IOException {
            return Q();
        }

        public <T extends MessageLite> T H(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                T t2 = (MessageLite) parser.y(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return t2;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void I(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                builder.Q1(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public byte J() throws IOException {
            if (this.f7054m == this.f7052k) {
                t0(1);
            }
            byte[] bArr = this.f7051j;
            int i2 = this.f7054m;
            this.f7054m = i2 + 1;
            return bArr[i2];
        }

        public byte[] K(int i2) throws IOException {
            int i3 = this.f7054m;
            if (i2 > this.f7052k - i3 || i2 <= 0) {
                return p0(i2, false);
            }
            int i4 = i2 + i3;
            this.f7054m = i4;
            return Arrays.copyOfRange(this.f7051j, i3, i4);
        }

        public int L() throws IOException {
            int i2 = this.f7054m;
            if (this.f7052k - i2 < 4) {
                t0(4);
                i2 = this.f7054m;
            }
            byte[] bArr = this.f7051j;
            this.f7054m = i2 + 4;
            return ((bArr[i2 + 3] & 255) << Ascii.B) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long M() throws IOException {
            int i2 = this.f7054m;
            if (this.f7052k - i2 < 8) {
                t0(8);
                i2 = this.f7054m;
            }
            byte[] bArr = this.f7051j;
            this.f7054m = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        public int N() throws IOException {
            byte b2;
            byte b3;
            int i2 = this.f7054m;
            int i3 = this.f7052k;
            if (i3 != i2) {
                byte[] bArr = this.f7051j;
                int i4 = i2 + 1;
                byte b4 = bArr[i2];
                if (b4 >= 0) {
                    this.f7054m = i4;
                    return b4;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b5 = (bArr[i4] << 7) ^ b4;
                    if (b5 < 0) {
                        b2 = b5 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b6 = (bArr[i5] << 14) ^ b5;
                        if (b6 >= 0) {
                            b3 = b6 ^ 16256;
                        } else {
                            int i7 = i2 + 4;
                            byte b7 = b6 ^ (bArr[i6] << Ascii.y);
                            if (b7 < 0) {
                                b2 = -2080896 ^ b7;
                            } else {
                                i6 = i2 + 5;
                                byte b8 = bArr[i7];
                                byte b9 = (b7 ^ (b8 << Ascii.F)) ^ 266354560;
                                if (b8 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b10 = b9;
                                                        i5 = i8;
                                                        b2 = b10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b2 = b9;
                                }
                                b3 = b9;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.f7054m = i5;
                    return b2;
                }
            }
            return (int) R();
        }

        public long Q() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2 = this.f7054m;
            int i3 = this.f7052k;
            if (i3 != i2) {
                byte[] bArr = this.f7051j;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f7054m = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b3 = (bArr[i4] << 7) ^ b2;
                    if (b3 < 0) {
                        j2 = (long) (b3 ^ Byte.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b4 = (bArr[i5] << 14) ^ b3;
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ 16256);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b5 = b4 ^ (bArr[i6] << Ascii.y);
                            if (b5 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b5);
                            } else {
                                long j5 = (long) b5;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.f7054m = i5;
                    return j2;
                }
            }
            return R();
        }

        /* access modifiers changed from: package-private */
        public long R() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte J = J();
                j2 |= ((long) (J & Byte.MAX_VALUE)) << i2;
                if ((J & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public int S() throws IOException {
            return L();
        }

        public long T() throws IOException {
            return M();
        }

        public int U() throws IOException {
            return CodedInputStream.b(N());
        }

        public long V() throws IOException {
            return CodedInputStream.c(Q());
        }

        public String W() throws IOException {
            int N = N();
            if (N > 0) {
                int i2 = this.f7052k;
                int i3 = this.f7054m;
                if (N <= i2 - i3) {
                    String str = new String(this.f7051j, i3, N, Internal.f7166a);
                    this.f7054m += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N > this.f7052k) {
                return new String(p0(N, false), Internal.f7166a);
            }
            t0(N);
            String str2 = new String(this.f7051j, this.f7054m, N, Internal.f7166a);
            this.f7054m += N;
            return str2;
        }

        public String X() throws IOException {
            byte[] bArr;
            int N = N();
            int i2 = this.f7054m;
            int i3 = this.f7052k;
            if (N <= i3 - i2 && N > 0) {
                bArr = this.f7051j;
                this.f7054m = i2 + N;
            } else if (N == 0) {
                return "";
            } else {
                i2 = 0;
                if (N <= i3) {
                    t0(N);
                    bArr = this.f7051j;
                    this.f7054m = N;
                } else {
                    bArr = p0(N, false);
                }
            }
            return Utf8.h(bArr, i2, N);
        }

        public int Y() throws IOException {
            if (i()) {
                this.f7055n = 0;
                return 0;
            }
            int N = N();
            this.f7055n = N;
            if (WireFormat.a(N) != 0) {
                return this.f7055n;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int Z() throws IOException {
            return N();
        }

        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.f7055n != i2) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public long a0() throws IOException {
            return Q();
        }

        @Deprecated
        public void b0(int i2, MessageLite.Builder builder) throws IOException {
            E(i2, builder, ExtensionRegistryLite.d());
        }

        public void c0() {
            this.o = -this.f7054m;
        }

        public void e(boolean z) {
        }

        public int f() {
            int i2 = this.p;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - (this.o + this.f7054m);
        }

        public int g() {
            return this.f7055n;
        }

        public boolean g0(int i2) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                v0();
                return true;
            } else if (b2 == 1) {
                k0(8);
                return true;
            } else if (b2 == 2) {
                k0(N());
                return true;
            } else if (b2 == 3) {
                i0();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    k0(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public int h() {
            return this.o + this.f7054m;
        }

        public boolean h0(int i2, CodedOutputStream codedOutputStream) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                long G = G();
                codedOutputStream.Z1(i2);
                codedOutputStream.i2(G);
                return true;
            } else if (b2 == 1) {
                long M = M();
                codedOutputStream.Z1(i2);
                codedOutputStream.D1(M);
                return true;
            } else if (b2 == 2) {
                ByteString x = x();
                codedOutputStream.Z1(i2);
                codedOutputStream.z1(x);
                return true;
            } else if (b2 == 3) {
                codedOutputStream.Z1(i2);
                j0(codedOutputStream);
                int c2 = WireFormat.c(WireFormat.a(i2), 4);
                a(c2);
                codedOutputStream.Z1(c2);
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    int L = L();
                    codedOutputStream.Z1(i2);
                    codedOutputStream.C1(L);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public boolean i() throws IOException {
            return this.f7054m == this.f7052k && !y0(1);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void i0() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.g0(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.i0():void");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void j0(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.h0(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.j0(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public void k0(int i2) throws IOException {
            int i3 = this.f7052k;
            int i4 = this.f7054m;
            if (i2 > i3 - i4 || i2 < 0) {
                u0(i2);
            } else {
                this.f7054m = i4 + i2;
            }
        }

        public void s(int i2) {
            this.p = i2;
            s0();
        }

        public int t(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int i3 = i2 + this.o + this.f7054m;
                int i4 = this.p;
                if (i3 <= i4) {
                    this.p = i3;
                    s0();
                    return i4;
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean u() throws IOException {
            return Q() != 0;
        }

        public byte[] v() throws IOException {
            int N = N();
            int i2 = this.f7052k;
            int i3 = this.f7054m;
            if (N > i2 - i3 || N <= 0) {
                return p0(N, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.f7051j, i3, i3 + N);
            this.f7054m += N;
            return copyOfRange;
        }

        public ByteBuffer w() throws IOException {
            int N = N();
            int i2 = this.f7052k;
            int i3 = this.f7054m;
            if (N > i2 - i3 || N <= 0) {
                return N == 0 ? Internal.f7170e : ByteBuffer.wrap(p0(N, true));
            }
            ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f7051j, i3, i3 + N));
            this.f7054m += N;
            return wrap;
        }

        public ByteString x() throws IOException {
            int N = N();
            int i2 = this.f7052k;
            int i3 = this.f7054m;
            if (N > i2 - i3 || N <= 0) {
                return N == 0 ? ByteString.X2 : o0(N);
            }
            ByteString z = ByteString.z(this.f7051j, i3, N);
            this.f7054m += N;
            return z;
        }

        public double y() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int z() throws IOException {
            return N();
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: i  reason: collision with root package name */
        private final ByteBuffer f7059i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f7060j;

        /* renamed from: k  reason: collision with root package name */
        private final long f7061k;

        /* renamed from: l  reason: collision with root package name */
        private long f7062l;

        /* renamed from: m  reason: collision with root package name */
        private long f7063m;

        /* renamed from: n  reason: collision with root package name */
        private long f7064n;
        private int o;
        private int p;
        private boolean q;
        private int r;

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z) {
            super();
            this.r = Integer.MAX_VALUE;
            this.f7059i = byteBuffer;
            long i2 = UnsafeUtil.i(byteBuffer);
            this.f7061k = i2;
            this.f7062l = ((long) byteBuffer.limit()) + i2;
            long position = i2 + ((long) byteBuffer.position());
            this.f7063m = position;
            this.f7064n = position;
            this.f7060j = z;
        }

        private int m0(long j2) {
            return (int) (j2 - this.f7061k);
        }

        static boolean n0() {
            return UnsafeUtil.T();
        }

        private void o0() {
            long j2 = this.f7062l + ((long) this.o);
            this.f7062l = j2;
            int i2 = (int) (j2 - this.f7064n);
            int i3 = this.r;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.o = i4;
                this.f7062l = j2 - ((long) i4);
                return;
            }
            this.o = 0;
        }

        private int p0() {
            return (int) (this.f7062l - this.f7063m);
        }

        private void q0() throws IOException {
            if (p0() >= 10) {
                r0();
            } else {
                s0();
            }
        }

        private void r0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                long j2 = this.f7063m;
                this.f7063m = 1 + j2;
                if (UnsafeUtil.y(j2) < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void s0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                if (J() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.f7059i.position(r0);
            r3.f7059i.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer t0(long r4, long r6) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f7059i
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f7059i
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f7059i     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r4 = r3.m0(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f7059i     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r5 = r3.m0(r6)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f7059i     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r5 = r3.f7059i
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f7059i
                r5.limit(r1)
                return r4
            L_0x002f:
                r4 = move-exception
                goto L_0x0036
            L_0x0031:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()     // Catch:{ all -> 0x002f }
                throw r4     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r5 = r3.f7059i
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f7059i
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.t0(long, long):java.nio.ByteBuffer");
        }

        public int A() throws IOException {
            return L();
        }

        public long B() throws IOException {
            return M();
        }

        public float C() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public <T extends MessageLite> T D(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                T t = (MessageLite) parser.y(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return t;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void E(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i3 = this.f7033a;
            if (i3 < this.f7034b) {
                this.f7033a = i3 + 1;
                builder.Q1(this, extensionRegistryLite);
                a(WireFormat.c(i2, 4));
                this.f7033a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public int F() throws IOException {
            return N();
        }

        public long G() throws IOException {
            return Q();
        }

        public <T extends MessageLite> T H(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                T t2 = (MessageLite) parser.y(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return t2;
            }
            throw InvalidProtocolBufferException.i();
        }

        public void I(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int N = N();
            if (this.f7033a < this.f7034b) {
                int t = t(N);
                this.f7033a++;
                builder.Q1(this, extensionRegistryLite);
                a(0);
                this.f7033a--;
                s(t);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        public byte J() throws IOException {
            long j2 = this.f7063m;
            if (j2 != this.f7062l) {
                this.f7063m = 1 + j2;
                return UnsafeUtil.y(j2);
            }
            throw InvalidProtocolBufferException.l();
        }

        public byte[] K(int i2) throws IOException {
            if (i2 >= 0 && i2 <= p0()) {
                byte[] bArr = new byte[i2];
                long j2 = this.f7063m;
                long j3 = (long) i2;
                t0(j2, j2 + j3).get(bArr);
                this.f7063m += j3;
                return bArr;
            } else if (i2 > 0) {
                throw InvalidProtocolBufferException.l();
            } else if (i2 == 0) {
                return Internal.f7169d;
            } else {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int L() throws IOException {
            long j2 = this.f7063m;
            if (this.f7062l - j2 >= 4) {
                this.f7063m = 4 + j2;
                return ((UnsafeUtil.y(j2 + 3) & 255) << Ascii.B) | (UnsafeUtil.y(j2) & 255) | ((UnsafeUtil.y(1 + j2) & 255) << 8) | ((UnsafeUtil.y(2 + j2) & 255) << 16);
            }
            throw InvalidProtocolBufferException.l();
        }

        public long M() throws IOException {
            long j2 = this.f7063m;
            if (this.f7062l - j2 >= 8) {
                this.f7063m = 8 + j2;
                return ((((long) UnsafeUtil.y(j2 + 7)) & 255) << 56) | (((long) UnsafeUtil.y(j2)) & 255) | ((((long) UnsafeUtil.y(1 + j2)) & 255) << 8) | ((((long) UnsafeUtil.y(2 + j2)) & 255) << 16) | ((((long) UnsafeUtil.y(3 + j2)) & 255) << 24) | ((((long) UnsafeUtil.y(4 + j2)) & 255) << 32) | ((((long) UnsafeUtil.y(5 + j2)) & 255) << 40) | ((((long) UnsafeUtil.y(6 + j2)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.l();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.y(r3) < 0) goto L_0x008e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int N() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f7063m
                long r2 = r10.f7062l
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto L_0x000a
                goto L_0x008e
            L_0x000a:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r0)
                if (r4 < 0) goto L_0x0016
                r10.f7063m = r2
                return r4
            L_0x0016:
                long r5 = r10.f7062l
                long r5 = r5 - r2
                r7 = 9
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 >= 0) goto L_0x0021
                goto L_0x008e
            L_0x0021:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L_0x0031
                r0 = r2 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0098
            L_0x0031:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L_0x0041
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003f:
                r5 = r3
                goto L_0x0098
            L_0x0041:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L_0x0052
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0098
            L_0x0052:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L_0x0096
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r3)
                if (r3 >= 0) goto L_0x0094
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r3)
                if (r3 >= 0) goto L_0x0094
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r3)
                if (r0 >= 0) goto L_0x0094
            L_0x008e:
                long r0 = r10.R()
                int r1 = (int) r0
                return r1
            L_0x0094:
                r0 = r2
                goto L_0x0098
            L_0x0096:
                r0 = r2
                goto L_0x003f
            L_0x0098:
                r10.f7063m = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.N():int");
        }

        public long Q() throws IOException {
            long j2;
            long j3;
            long j4;
            byte b2;
            long j5 = this.f7063m;
            if (this.f7062l != j5) {
                long j6 = 1 + j5;
                byte y = UnsafeUtil.y(j5);
                if (y >= 0) {
                    this.f7063m = j6;
                    return (long) y;
                } else if (this.f7062l - j6 >= 9) {
                    long j7 = 2 + j5;
                    byte y2 = (UnsafeUtil.y(j6) << 7) ^ y;
                    if (y2 < 0) {
                        b2 = y2 ^ Byte.MIN_VALUE;
                    } else {
                        long j8 = 3 + j5;
                        byte y3 = y2 ^ (UnsafeUtil.y(j7) << 14);
                        if (y3 >= 0) {
                            j2 = (long) (y3 ^ 16256);
                            j7 = j8;
                        } else {
                            j7 = 4 + j5;
                            byte y4 = y3 ^ (UnsafeUtil.y(j8) << Ascii.y);
                            if (y4 < 0) {
                                b2 = -2080896 ^ y4;
                            } else {
                                long j9 = 5 + j5;
                                long y5 = ((long) y4) ^ (((long) UnsafeUtil.y(j7)) << 28);
                                if (y5 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j10 = 6 + j5;
                                    long y6 = y5 ^ (((long) UnsafeUtil.y(j9)) << 35);
                                    if (y6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j9 = 7 + j5;
                                        y5 = y6 ^ (((long) UnsafeUtil.y(j10)) << 42);
                                        if (y5 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j10 = 8 + j5;
                                            y6 = y5 ^ (((long) UnsafeUtil.y(j9)) << 49);
                                            if (y6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                long j11 = j5 + 9;
                                                long y7 = (y6 ^ (((long) UnsafeUtil.y(j10)) << 56)) ^ 71499008037633920L;
                                                if (y7 < 0) {
                                                    long j12 = j5 + 10;
                                                    if (((long) UnsafeUtil.y(j11)) >= 0) {
                                                        j7 = j12;
                                                        j2 = y7;
                                                    }
                                                } else {
                                                    j2 = y7;
                                                    j7 = j11;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ y6;
                                    j7 = j10;
                                }
                                j2 = j4 ^ y5;
                                j7 = j9;
                            }
                        }
                        this.f7063m = j7;
                        return j2;
                    }
                    j2 = (long) b2;
                    this.f7063m = j7;
                    return j2;
                }
            }
            return R();
        }

        /* access modifiers changed from: package-private */
        public long R() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte J = J();
                j2 |= ((long) (J & Byte.MAX_VALUE)) << i2;
                if ((J & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public int S() throws IOException {
            return L();
        }

        public long T() throws IOException {
            return M();
        }

        public int U() throws IOException {
            return CodedInputStream.b(N());
        }

        public long V() throws IOException {
            return CodedInputStream.c(Q());
        }

        public String W() throws IOException {
            int N = N();
            if (N > 0 && N <= p0()) {
                byte[] bArr = new byte[N];
                long j2 = (long) N;
                UnsafeUtil.n(this.f7063m, bArr, 0, j2);
                String str = new String(bArr, Internal.f7166a);
                this.f7063m += j2;
                return str;
            } else if (N == 0) {
                return "";
            } else {
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public String X() throws IOException {
            int N = N();
            if (N > 0 && N <= p0()) {
                String g2 = Utf8.g(this.f7059i, m0(this.f7063m), N);
                this.f7063m += (long) N;
                return g2;
            } else if (N == 0) {
                return "";
            } else {
                if (N <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            }
        }

        public int Y() throws IOException {
            if (i()) {
                this.p = 0;
                return 0;
            }
            int N = N();
            this.p = N;
            if (WireFormat.a(N) != 0) {
                return this.p;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int Z() throws IOException {
            return N();
        }

        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.p != i2) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public long a0() throws IOException {
            return Q();
        }

        @Deprecated
        public void b0(int i2, MessageLite.Builder builder) throws IOException {
            E(i2, builder, ExtensionRegistryLite.d());
        }

        public void c0() {
            this.f7064n = this.f7063m;
        }

        public void e(boolean z) {
            this.q = z;
        }

        public int f() {
            int i2 = this.r;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - h();
        }

        public int g() {
            return this.p;
        }

        public boolean g0(int i2) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                q0();
                return true;
            } else if (b2 == 1) {
                k0(8);
                return true;
            } else if (b2 == 2) {
                k0(N());
                return true;
            } else if (b2 == 3) {
                i0();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    k0(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public int h() {
            return (int) (this.f7063m - this.f7064n);
        }

        public boolean h0(int i2, CodedOutputStream codedOutputStream) throws IOException {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                long G = G();
                codedOutputStream.Z1(i2);
                codedOutputStream.i2(G);
                return true;
            } else if (b2 == 1) {
                long M = M();
                codedOutputStream.Z1(i2);
                codedOutputStream.D1(M);
                return true;
            } else if (b2 == 2) {
                ByteString x = x();
                codedOutputStream.Z1(i2);
                codedOutputStream.z1(x);
                return true;
            } else if (b2 == 3) {
                codedOutputStream.Z1(i2);
                j0(codedOutputStream);
                int c2 = WireFormat.c(WireFormat.a(i2), 4);
                a(c2);
                codedOutputStream.Z1(c2);
                return true;
            } else if (b2 == 4) {
                return false;
            } else {
                if (b2 == 5) {
                    int L = L();
                    codedOutputStream.Z1(i2);
                    codedOutputStream.C1(L);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public boolean i() throws IOException {
            return this.f7063m == this.f7062l;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void i0() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.g0(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.i0():void");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void j0(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.Y()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.h0(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.j0(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public void k0(int i2) throws IOException {
            if (i2 >= 0 && i2 <= p0()) {
                this.f7063m += (long) i2;
            } else if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.l();
            }
        }

        public void s(int i2) {
            this.r = i2;
            o0();
        }

        public int t(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int h2 = i2 + h();
                int i3 = this.r;
                if (h2 <= i3) {
                    this.r = h2;
                    o0();
                    return i3;
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean u() throws IOException {
            return Q() != 0;
        }

        public byte[] v() throws IOException {
            return K(N());
        }

        public ByteBuffer w() throws IOException {
            int N = N();
            if (N <= 0 || N > p0()) {
                if (N == 0) {
                    return Internal.f7170e;
                }
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            } else if (this.f7060j || !this.q) {
                byte[] bArr = new byte[N];
                long j2 = (long) N;
                UnsafeUtil.n(this.f7063m, bArr, 0, j2);
                this.f7063m += j2;
                return ByteBuffer.wrap(bArr);
            } else {
                long j3 = this.f7063m;
                long j4 = (long) N;
                ByteBuffer t0 = t0(j3, j3 + j4);
                this.f7063m += j4;
                return t0;
            }
        }

        public ByteString x() throws IOException {
            int N = N();
            if (N <= 0 || N > p0()) {
                if (N == 0) {
                    return ByteString.X2;
                }
                if (N < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.l();
            } else if (!this.f7060j || !this.q) {
                byte[] bArr = new byte[N];
                long j2 = (long) N;
                UnsafeUtil.n(this.f7063m, bArr, 0, j2);
                this.f7063m += j2;
                return ByteString.t0(bArr);
            } else {
                long j3 = this.f7063m;
                long j4 = (long) N;
                ByteBuffer t0 = t0(j3, j3 + j4);
                this.f7063m += j4;
                return ByteString.q0(t0);
            }
        }

        public double y() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int z() throws IOException {
            return N();
        }
    }

    private CodedInputStream() {
        this.f7034b = 100;
        this.f7035c = Integer.MAX_VALUE;
        this.f7037e = false;
    }

    public static int O(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & WorkQueueKt.f29430c;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i3 |= (read & WorkQueueKt.f29430c) << i4;
                if ((read & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            } else {
                throw InvalidProtocolBufferException.l();
            }
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.l();
            } else if ((read2 & 128) == 0) {
                return i3;
            } else {
                i4 += 7;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    static int P(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return O(read, inputStream);
        }
        throw InvalidProtocolBufferException.l();
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static CodedInputStream j(InputStream inputStream) {
        return k(inputStream, 4096);
    }

    public static CodedInputStream k(InputStream inputStream, int i2) {
        if (i2 > 0) {
            return inputStream == null ? p(Internal.f7169d) : new StreamDecoder(inputStream, i2);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream l(Iterable<ByteBuffer> iterable) {
        return !UnsafeDirectNioDecoder.n0() ? j(new IterableByteBufferInputStream(iterable)) : m(iterable, false);
    }

    static CodedInputStream m(Iterable<ByteBuffer> iterable, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        for (ByteBuffer next : iterable) {
            i2 += next.remaining();
            z2 = next.hasArray() ? z2 | true : next.isDirect() ? z2 | true : z2 | true;
        }
        return z2 ? new IterableDirectByteBufferDecoder(iterable, i2, z) : j(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream n(ByteBuffer byteBuffer) {
        return o(byteBuffer, false);
    }

    static CodedInputStream o(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return r(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.n0()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return r(bArr, 0, remaining, true);
    }

    public static CodedInputStream p(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    public static CodedInputStream q(byte[] bArr, int i2, int i3) {
        return r(bArr, i2, i3, false);
    }

    static CodedInputStream r(byte[] bArr, int i2, int i3, boolean z) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i2, i3, z);
        try {
            arrayDecoder.t(i3);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int A() throws IOException;

    public abstract long B() throws IOException;

    public abstract float C() throws IOException;

    public abstract <T extends MessageLite> T D(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void E(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int F() throws IOException;

    public abstract long G() throws IOException;

    public abstract <T extends MessageLite> T H(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void I(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte J() throws IOException;

    public abstract byte[] K(int i2) throws IOException;

    public abstract int L() throws IOException;

    public abstract long M() throws IOException;

    public abstract int N() throws IOException;

    public abstract long Q() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long R() throws IOException;

    public abstract int S() throws IOException;

    public abstract long T() throws IOException;

    public abstract int U() throws IOException;

    public abstract long V() throws IOException;

    public abstract String W() throws IOException;

    public abstract String X() throws IOException;

    public abstract int Y() throws IOException;

    public abstract int Z() throws IOException;

    public abstract void a(int i2) throws InvalidProtocolBufferException;

    public abstract long a0() throws IOException;

    @Deprecated
    public abstract void b0(int i2, MessageLite.Builder builder) throws IOException;

    public abstract void c0();

    /* access modifiers changed from: package-private */
    public final void d() {
        this.f7037e = true;
    }

    public final int d0(int i2) {
        if (i2 >= 0) {
            int i3 = this.f7034b;
            this.f7034b = i2;
            return i3;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i2);
    }

    public abstract void e(boolean z);

    public final int e0(int i2) {
        if (i2 >= 0) {
            int i3 = this.f7035c;
            this.f7035c = i2;
            return i3;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i2);
    }

    public abstract int f();

    /* access modifiers changed from: package-private */
    public final boolean f0() {
        return this.f7037e;
    }

    public abstract int g();

    public abstract boolean g0(int i2) throws IOException;

    public abstract int h();

    @Deprecated
    public abstract boolean h0(int i2, CodedOutputStream codedOutputStream) throws IOException;

    public abstract boolean i() throws IOException;

    public abstract void i0() throws IOException;

    public abstract void j0(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void k0(int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public final void l0() {
        this.f7037e = false;
    }

    public abstract void s(int i2);

    public abstract int t(int i2) throws InvalidProtocolBufferException;

    public abstract boolean u() throws IOException;

    public abstract byte[] v() throws IOException;

    public abstract ByteBuffer w() throws IOException;

    public abstract ByteString x() throws IOException;

    public abstract double y() throws IOException;

    public abstract int z() throws IOException;
}
