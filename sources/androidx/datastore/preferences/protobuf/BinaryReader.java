package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

abstract class BinaryReader implements Reader {

    /* renamed from: c  reason: collision with root package name */
    private static final int f6980c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f6981d = 7;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6982a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6982a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f6982a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class SafeHeapReader extends BinaryReader {

        /* renamed from: e  reason: collision with root package name */
        private final boolean f6983e;

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f6984f;

        /* renamed from: g  reason: collision with root package name */
        private int f6985g;

        /* renamed from: h  reason: collision with root package name */
        private final int f6986h;

        /* renamed from: i  reason: collision with root package name */
        private int f6987i;

        /* renamed from: j  reason: collision with root package name */
        private int f6988j;

        /* renamed from: k  reason: collision with root package name */
        private int f6989k;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z) {
            super((AnonymousClass1) null);
            this.f6983e = z;
            this.f6984f = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f6985g = arrayOffset;
            this.f6986h = arrayOffset;
            this.f6987i = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean V() {
            return this.f6985g == this.f6987i;
        }

        private byte W() throws IOException {
            int i2 = this.f6985g;
            if (i2 != this.f6987i) {
                byte[] bArr = this.f6984f;
                this.f6985g = i2 + 1;
                return bArr[i2];
            }
            throw InvalidProtocolBufferException.l();
        }

        private Object X(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.f6982a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(k());
                case 2:
                    return F();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(w());
                case 5:
                    return Integer.valueOf(j());
                case 6:
                    return Long.valueOf(d());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(H());
                case 9:
                    return Long.valueOf(P());
                case 10:
                    return e(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(L());
                case 12:
                    return Long.valueOf(l());
                case 13:
                    return Integer.valueOf(y());
                case 14:
                    return Long.valueOf(z());
                case 15:
                    return Q();
                case 16:
                    return Integer.valueOf(q());
                case 17:
                    return Long.valueOf(c());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T Y(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i2 = this.f6989k;
            this.f6989k = WireFormat.c(WireFormat.a(this.f6988j), 4);
            try {
                T h2 = schema.h();
                schema.b(h2, this, extensionRegistryLite);
                schema.c(h2);
                if (this.f6988j == this.f6989k) {
                    return h2;
                }
                throw InvalidProtocolBufferException.h();
            } finally {
                this.f6989k = i2;
            }
        }

        private int Z() throws IOException {
            j0(4);
            return a0();
        }

        private int a0() {
            int i2 = this.f6985g;
            byte[] bArr = this.f6984f;
            this.f6985g = i2 + 4;
            return ((bArr[i2 + 3] & 255) << Ascii.B) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        private long b0() throws IOException {
            j0(8);
            return c0();
        }

        private long c0() {
            int i2 = this.f6985g;
            byte[] bArr = this.f6984f;
            this.f6985g = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        private <T> T d0(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int g0 = g0();
            j0(g0);
            int i2 = this.f6987i;
            int i3 = this.f6985g + g0;
            this.f6987i = i3;
            try {
                T h2 = schema.h();
                schema.b(h2, this, extensionRegistryLite);
                schema.c(h2);
                if (this.f6985g == i3) {
                    return h2;
                }
                throw InvalidProtocolBufferException.h();
            } finally {
                this.f6987i = i2;
            }
        }

        private int g0() throws IOException {
            byte b2;
            byte b3;
            int i2 = this.f6985g;
            int i3 = this.f6987i;
            if (i3 != i2) {
                byte[] bArr = this.f6984f;
                int i4 = i2 + 1;
                byte b4 = bArr[i2];
                if (b4 >= 0) {
                    this.f6985g = i4;
                    return b4;
                } else if (i3 - i4 < 9) {
                    return (int) i0();
                } else {
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
                                                    } else {
                                                        throw InvalidProtocolBufferException.f();
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
                    this.f6985g = i5;
                    return b2;
                }
            } else {
                throw InvalidProtocolBufferException.l();
            }
        }

        private long i0() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte W = W();
                j2 |= ((long) (W & Byte.MAX_VALUE)) << i2;
                if ((W & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void j0(int i2) throws IOException {
            if (i2 < 0 || i2 > this.f6987i - this.f6985g) {
                throw InvalidProtocolBufferException.l();
            }
        }

        private void k0(int i2) throws IOException {
            if (this.f6985g != i2) {
                throw InvalidProtocolBufferException.l();
            }
        }

        private void l0(int i2) throws IOException {
            if (WireFormat.b(this.f6988j) != i2) {
                throw InvalidProtocolBufferException.e();
            }
        }

        private void m0(int i2) throws IOException {
            j0(i2);
            this.f6985g += i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void n0() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.f6989k
                int r1 = r3.f6988j
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.a(r1)
                r2 = 4
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.c(r1, r2)
                r3.f6989k = r1
            L_0x000f:
                int r1 = r3.C()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.K()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f6988j
                int r2 = r3.f6989k
                if (r1 != r2) goto L_0x0027
                r3.f6989k = r0
                return
            L_0x0027:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.n0():void");
        }

        private void o0() throws IOException {
            int i2 = this.f6987i;
            int i3 = this.f6985g;
            if (i2 - i3 >= 10) {
                byte[] bArr = this.f6984f;
                int i4 = 0;
                while (i4 < 10) {
                    int i5 = i3 + 1;
                    if (bArr[i3] >= 0) {
                        this.f6985g = i5;
                        return;
                    } else {
                        i4++;
                        i3 = i5;
                    }
                }
            }
            p0();
        }

        private void p0() throws IOException {
            int i2 = 0;
            while (i2 < 10) {
                if (W() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void q0(int i2) throws IOException {
            j0(i2);
            if ((i2 & 3) != 0) {
                throw InvalidProtocolBufferException.h();
            }
        }

        private void r0(int i2) throws IOException {
            j0(i2);
            if ((i2 & 7) != 0) {
                throw InvalidProtocolBufferException.h();
            }
        }

        public void A(List<Boolean> list) throws IOException {
            int i2;
            int i3;
            int i4;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        booleanArrayList.c1(k());
                        if (!V()) {
                            i4 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i4;
                    return;
                } else if (b2 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        booleanArrayList.c1(g0() != 0);
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Boolean.valueOf(k()));
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                    return;
                } else if (b3 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        list.add(Boolean.valueOf(g0() != 0));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
            k0(i2);
        }

        public String B() throws IOException {
            return e0(false);
        }

        public int C() throws IOException {
            if (V()) {
                return Integer.MAX_VALUE;
            }
            int g0 = g0();
            this.f6988j = g0;
            if (g0 == this.f6989k) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(g0);
        }

        public void D(List<String> list) throws IOException {
            f0(list, false);
        }

        public void E(List<String> list) throws IOException {
            f0(list, true);
        }

        public ByteString F() throws IOException {
            l0(2);
            int g0 = g0();
            if (g0 == 0) {
                return ByteString.X2;
            }
            j0(g0);
            ByteString u0 = this.f6983e ? ByteString.u0(this.f6984f, this.f6985g, g0) : ByteString.z(this.f6984f, this.f6985g, g0);
            this.f6985g += g0;
            return u0;
        }

        public void G(List<Float> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 2) {
                    int g0 = g0();
                    q0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        floatArrayList.J(Float.intBitsToFloat(a0()));
                    }
                } else if (b2 == 5) {
                    do {
                        floatArrayList.J(readFloat());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 2) {
                    int g02 = g0();
                    q0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Float.valueOf(Float.intBitsToFloat(a0())));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public int H() throws IOException {
            l0(0);
            return g0();
        }

        public <T> void I(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i2;
            if (WireFormat.b(this.f6988j) == 3) {
                int i3 = this.f6988j;
                do {
                    list.add(Y(schema, extensionRegistryLite));
                    if (!V()) {
                        i2 = this.f6985g;
                    } else {
                        return;
                    }
                } while (g0() == i3);
                this.f6985g = i2;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        public boolean K() throws IOException {
            int i2;
            int i3;
            if (V() || (i2 = this.f6988j) == this.f6989k) {
                return false;
            }
            int b2 = WireFormat.b(i2);
            if (b2 != 0) {
                if (b2 == 1) {
                    i3 = 8;
                } else if (b2 == 2) {
                    i3 = g0();
                } else if (b2 == 3) {
                    n0();
                    return true;
                } else if (b2 == 5) {
                    i3 = 4;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
                m0(i3);
                return true;
            }
            o0();
            return true;
        }

        public int L() throws IOException {
            l0(5);
            return Z();
        }

        public void M(List<ByteString> list) throws IOException {
            int i2;
            if (WireFormat.b(this.f6988j) == 2) {
                do {
                    list.add(F());
                    if (!V()) {
                        i2 = this.f6985g;
                    } else {
                        return;
                    }
                } while (g0() == this.f6988j);
                this.f6985g = i2;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        public void N(List<Double> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 1) {
                    do {
                        doubleArrayList.k1(readDouble());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = g0();
                    r0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        doubleArrayList.k1(Double.longBitsToDouble(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = g0();
                    r0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Double.valueOf(Double.longBitsToDouble(c0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public <T> void O(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i2;
            if (WireFormat.b(this.f6988j) == 2) {
                int i3 = this.f6988j;
                do {
                    list.add(d0(schema, extensionRegistryLite));
                    if (!V()) {
                        i2 = this.f6985g;
                    } else {
                        return;
                    }
                } while (g0() == i3);
                this.f6985g = i2;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        public long P() throws IOException {
            l0(0);
            return h0();
        }

        public String Q() throws IOException {
            return e0(true);
        }

        public void R(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 1) {
                    do {
                        longArrayList.S0(d());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = g0();
                    r0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        longArrayList.S0(c0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 1) {
                    do {
                        list.add(Long.valueOf(d()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = g0();
                    r0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public <T> T S(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            l0(3);
            return Y(schema, extensionRegistryLite);
        }

        public int T() {
            return this.f6985g - this.f6986h;
        }

        public <T> T a(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            l0(2);
            return d0(schema, extensionRegistryLite);
        }

        public void b(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        intArrayList.h0(y());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = this.f6985g + g0();
                    while (this.f6985g < g0) {
                        intArrayList.h0(CodedInputStream.b(g0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(y()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = this.f6985g + g0();
                    while (this.f6985g < g02) {
                        list.add(Integer.valueOf(CodedInputStream.b(g0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public long c() throws IOException {
            l0(0);
            return h0();
        }

        public long d() throws IOException {
            l0(1);
            return b0();
        }

        public <T> T e(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            l0(2);
            return d0(Protobuf.a().i(cls), extensionRegistryLite);
        }

        public String e0(boolean z) throws IOException {
            l0(2);
            int g0 = g0();
            if (g0 == 0) {
                return "";
            }
            j0(g0);
            if (z) {
                byte[] bArr = this.f6984f;
                int i2 = this.f6985g;
                if (!Utf8.u(bArr, i2, i2 + g0)) {
                    throw InvalidProtocolBufferException.d();
                }
            }
            String str = new String(this.f6984f, this.f6985g, g0, Internal.f7166a);
            this.f6985g += g0;
            return str;
        }

        public <T> void f(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            I(list, Protobuf.a().i(cls), extensionRegistryLite);
        }

        public void f0(List<String> list, boolean z) throws IOException {
            int i2;
            int i3;
            if (WireFormat.b(this.f6988j) != 2) {
                throw InvalidProtocolBufferException.e();
            } else if (!(list instanceof LazyStringList) || z) {
                do {
                    list.add(e0(z));
                    if (!V()) {
                        i2 = this.f6985g;
                    } else {
                        return;
                    }
                } while (g0() == this.f6988j);
                this.f6985g = i2;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.C0(F());
                    if (!V()) {
                        i3 = this.f6985g;
                    } else {
                        return;
                    }
                } while (g0() == this.f6988j);
                this.f6985g = i3;
            }
        }

        public void g(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 2) {
                    int g0 = g0();
                    q0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        intArrayList.h0(a0());
                    }
                } else if (b2 == 5) {
                    do {
                        intArrayList.h0(L());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 2) {
                    int g02 = g0();
                    q0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Integer.valueOf(a0()));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Integer.valueOf(L()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public void h(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        longArrayList.S0(z());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = this.f6985g + g0();
                    while (this.f6985g < g0) {
                        longArrayList.S0(CodedInputStream.c(h0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(z()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = this.f6985g + g0();
                    while (this.f6985g < g02) {
                        list.add(Long.valueOf(CodedInputStream.c(h0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public long h0() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2 = this.f6985g;
            int i3 = this.f6987i;
            if (i3 != i2) {
                byte[] bArr = this.f6984f;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f6985g = i4;
                    return (long) b2;
                } else if (i3 - i4 < 9) {
                    return i0();
                } else {
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
                                                    } else {
                                                        throw InvalidProtocolBufferException.f();
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
                    this.f6985g = i5;
                    return j2;
                }
            } else {
                throw InvalidProtocolBufferException.l();
            }
        }

        public void i(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        intArrayList.h0(q());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = this.f6985g + g0();
                    while (this.f6985g < g0) {
                        intArrayList.h0(g0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(q()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = this.f6985g + g0();
                    while (this.f6985g < g02) {
                        list.add(Integer.valueOf(g0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public int j() throws IOException {
            l0(5);
            return Z();
        }

        public boolean k() throws IOException {
            l0(0);
            return g0() != 0;
        }

        public long l() throws IOException {
            l0(1);
            return b0();
        }

        public void m(List<Long> list) throws IOException {
            int i2;
            int i3;
            int i4;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        longArrayList.S0(c());
                        if (!V()) {
                            i4 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i4;
                    return;
                } else if (b2 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        longArrayList.S0(h0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(c()));
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                    return;
                } else if (b3 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        list.add(Long.valueOf(h0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
            k0(i2);
        }

        public int n() {
            return this.f6988j;
        }

        public <T> T o(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            l0(3);
            return Y(Protobuf.a().i(cls), extensionRegistryLite);
        }

        public <T> void p(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            O(list, Protobuf.a().i(cls), extensionRegistryLite);
        }

        public int q() throws IOException {
            l0(0);
            return g0();
        }

        public void r(List<Long> list) throws IOException {
            int i2;
            int i3;
            int i4;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        longArrayList.S0(P());
                        if (!V()) {
                            i4 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i4;
                    return;
                } else if (b2 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        longArrayList.S0(h0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Long.valueOf(P()));
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                    return;
                } else if (b3 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        list.add(Long.valueOf(h0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
            k0(i2);
        }

        public double readDouble() throws IOException {
            l0(1);
            return Double.longBitsToDouble(b0());
        }

        public float readFloat() throws IOException {
            l0(5);
            return Float.intBitsToFloat(Z());
        }

        public void s(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 1) {
                    do {
                        longArrayList.S0(l());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = g0();
                    r0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        longArrayList.S0(c0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 1) {
                    do {
                        list.add(Long.valueOf(l()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = g0();
                    r0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public void t(List<Integer> list) throws IOException {
            int i2;
            int i3;
            int i4;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        intArrayList.h0(H());
                        if (!V()) {
                            i4 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i4;
                    return;
                } else if (b2 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        intArrayList.h0(g0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(H()));
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                    return;
                } else if (b3 == 2) {
                    i2 = this.f6985g + g0();
                    while (this.f6985g < i2) {
                        list.add(Integer.valueOf(g0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
            k0(i2);
        }

        public void u(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 0) {
                    do {
                        intArrayList.h0(w());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else if (b2 == 2) {
                    int g0 = this.f6985g + g0();
                    while (this.f6985g < g0) {
                        intArrayList.h0(g0());
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 0) {
                    do {
                        list.add(Integer.valueOf(w()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else if (b3 == 2) {
                    int g02 = this.f6985g + g0();
                    while (this.f6985g < g02) {
                        list.add(Integer.valueOf(g0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|(2:23|35)(3:30|24|25)) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            if (K() != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void v(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.l0(r0)
                int r1 = r7.g0()
                r7.j0(r1)
                int r2 = r7.f6987i
                int r3 = r7.f6985g
                int r3 = r3 + r1
                r7.f6987i = r3
                K r1 = r9.f7194b     // Catch:{ all -> 0x0025 }
                V r3 = r9.f7196d     // Catch:{ all -> 0x0025 }
            L_0x0016:
                int r4 = r7.C()     // Catch:{ all -> 0x0025 }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0027
                r8.put(r1, r3)     // Catch:{ all -> 0x0025 }
                r7.f6987i = r2
                return
            L_0x0025:
                r8 = move-exception
                goto L_0x005d
            L_0x0027:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0048
                if (r4 == r0) goto L_0x003b
                boolean r4 = r7.K()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                if (r4 == 0) goto L_0x0035
                goto L_0x0016
            L_0x0035:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x0050 }
            L_0x003b:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7195c     // Catch:{ InvalidWireTypeException -> 0x0050 }
                V r5 = r9.f7196d     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Object r3 = r7.X(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0048:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7193a     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r5 = 0
                java.lang.Object r1 = r7.X(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0050:
                boolean r4 = r7.K()     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0057
                goto L_0x0016
            L_0x0057:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0025 }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0025 }
                throw r8     // Catch:{ all -> 0x0025 }
            L_0x005d:
                r7.f6987i = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.v(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
        }

        public int w() throws IOException {
            l0(0);
            return g0();
        }

        public void x(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b2 = WireFormat.b(this.f6988j);
                if (b2 == 2) {
                    int g0 = g0();
                    q0(g0);
                    int i4 = this.f6985g + g0;
                    while (this.f6985g < i4) {
                        intArrayList.h0(a0());
                    }
                } else if (b2 == 5) {
                    do {
                        intArrayList.h0(j());
                        if (!V()) {
                            i3 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i3;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            } else {
                int b3 = WireFormat.b(this.f6988j);
                if (b3 == 2) {
                    int g02 = g0();
                    q0(g02);
                    int i5 = this.f6985g + g02;
                    while (this.f6985g < i5) {
                        list.add(Integer.valueOf(a0()));
                    }
                } else if (b3 == 5) {
                    do {
                        list.add(Integer.valueOf(j()));
                        if (!V()) {
                            i2 = this.f6985g;
                        } else {
                            return;
                        }
                    } while (g0() == this.f6988j);
                    this.f6985g = i2;
                } else {
                    throw InvalidProtocolBufferException.e();
                }
            }
        }

        public int y() throws IOException {
            l0(0);
            return CodedInputStream.b(g0());
        }

        public long z() throws IOException {
            l0(0);
            return CodedInputStream.c(h0());
        }
    }

    private BinaryReader() {
    }

    public static BinaryReader U(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public boolean J() {
        return false;
    }

    public abstract int T();

    /* synthetic */ BinaryReader(AnonymousClass1 r1) {
        this();
    }
}
