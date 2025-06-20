package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.List;

final class CodedInputStreamReader implements Reader {

    /* renamed from: g  reason: collision with root package name */
    private static final int f7065g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final int f7066h = 7;

    /* renamed from: i  reason: collision with root package name */
    private static final int f7067i = 0;

    /* renamed from: c  reason: collision with root package name */
    private final CodedInputStream f7068c;

    /* renamed from: d  reason: collision with root package name */
    private int f7069d;

    /* renamed from: e  reason: collision with root package name */
    private int f7070e;

    /* renamed from: f  reason: collision with root package name */
    private int f7071f = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedInputStreamReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7072a;

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
                f7072a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f7072a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.AnonymousClass1.<clinit>():void");
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.e(codedInputStream, HTML.Tag.q0);
        this.f7068c = codedInputStream2;
        codedInputStream2.f7036d = this;
    }

    public static CodedInputStreamReader T(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f7036d;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private Object U(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        switch (AnonymousClass1.f7072a[fieldType.ordinal()]) {
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

    private <T> T V(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.f7070e;
        this.f7070e = WireFormat.c(WireFormat.a(this.f7069d), 4);
        try {
            T h2 = schema.h();
            schema.b(h2, this, extensionRegistryLite);
            schema.c(h2);
            if (this.f7069d == this.f7070e) {
                return h2;
            }
            throw InvalidProtocolBufferException.h();
        } finally {
            this.f7070e = i2;
        }
    }

    private <T> T W(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int Z = this.f7068c.Z();
        CodedInputStream codedInputStream = this.f7068c;
        if (codedInputStream.f7033a < codedInputStream.f7034b) {
            int t = codedInputStream.t(Z);
            T h2 = schema.h();
            this.f7068c.f7033a++;
            schema.b(h2, this, extensionRegistryLite);
            schema.c(h2);
            this.f7068c.a(0);
            CodedInputStream codedInputStream2 = this.f7068c;
            codedInputStream2.f7033a--;
            codedInputStream2.s(t);
            return h2;
        }
        throw InvalidProtocolBufferException.i();
    }

    private void Y(int i2) throws IOException {
        if (this.f7068c.h() != i2) {
            throw InvalidProtocolBufferException.l();
        }
    }

    private void Z(int i2) throws IOException {
        if (WireFormat.b(this.f7069d) != i2) {
            throw InvalidProtocolBufferException.e();
        }
    }

    private void a0(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    private void b0(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    public void A(List<Boolean> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    booleanArrayList.c1(this.f7068c.u());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    booleanArrayList.c1(this.f7068c.u());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f7068c.u()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Boolean.valueOf(this.f7068c.u()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public String B() throws IOException {
        Z(2);
        return this.f7068c.W();
    }

    public int C() throws IOException {
        int i2 = this.f7071f;
        if (i2 != 0) {
            this.f7069d = i2;
            this.f7071f = 0;
        } else {
            this.f7069d = this.f7068c.Y();
        }
        int i3 = this.f7069d;
        if (i3 == 0 || i3 == this.f7070e) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.a(i3);
    }

    public void D(List<String> list) throws IOException {
        X(list, false);
    }

    public void E(List<String> list) throws IOException {
        X(list, true);
    }

    public ByteString F() throws IOException {
        Z(2);
        return this.f7068c.x();
    }

    public void G(List<Float> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 2) {
                int Z = this.f7068c.Z();
                a0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    floatArrayList.J(this.f7068c.C());
                } while (this.f7068c.h() < h2);
            } else if (b2 == 5) {
                do {
                    floatArrayList.J(this.f7068c.C());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                a0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Float.valueOf(this.f7068c.C()));
                } while (this.f7068c.h() < h3);
            } else if (b3 == 5) {
                do {
                    list.add(Float.valueOf(this.f7068c.C()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public int H() throws IOException {
        Z(0);
        return this.f7068c.F();
    }

    public <T> void I(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int Y;
        if (WireFormat.b(this.f7069d) == 3) {
            int i2 = this.f7069d;
            do {
                list.add(V(schema, extensionRegistryLite));
                if (!this.f7068c.i() && this.f7071f == 0) {
                    Y = this.f7068c.Y();
                } else {
                    return;
                }
            } while (Y == i2);
            this.f7071f = Y;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    public boolean J() {
        return this.f7068c.f0();
    }

    public boolean K() throws IOException {
        int i2;
        if (this.f7068c.i() || (i2 = this.f7069d) == this.f7070e) {
            return false;
        }
        return this.f7068c.g0(i2);
    }

    public int L() throws IOException {
        Z(5);
        return this.f7068c.S();
    }

    public void M(List<ByteString> list) throws IOException {
        int Y;
        if (WireFormat.b(this.f7069d) == 2) {
            do {
                list.add(F());
                if (!this.f7068c.i()) {
                    Y = this.f7068c.Y();
                } else {
                    return;
                }
            } while (Y == this.f7069d);
            this.f7071f = Y;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    public void N(List<Double> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 1) {
                do {
                    doubleArrayList.k1(this.f7068c.y());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else if (b2 == 2) {
                int Z = this.f7068c.Z();
                b0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    doubleArrayList.k1(this.f7068c.y());
                } while (this.f7068c.h() < h2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 1) {
                do {
                    list.add(Double.valueOf(this.f7068c.y()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                b0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Double.valueOf(this.f7068c.y()));
                } while (this.f7068c.h() < h3);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public <T> void O(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int Y;
        if (WireFormat.b(this.f7069d) == 2) {
            int i2 = this.f7069d;
            do {
                list.add(W(schema, extensionRegistryLite));
                if (!this.f7068c.i() && this.f7071f == 0) {
                    Y = this.f7068c.Y();
                } else {
                    return;
                }
            } while (Y == i2);
            this.f7071f = Y;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    public long P() throws IOException {
        Z(0);
        return this.f7068c.G();
    }

    public String Q() throws IOException {
        Z(2);
        return this.f7068c.X();
    }

    public void R(List<Long> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 1) {
                do {
                    longArrayList.S0(this.f7068c.B());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else if (b2 == 2) {
                int Z = this.f7068c.Z();
                b0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    longArrayList.S0(this.f7068c.B());
                } while (this.f7068c.h() < h2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 1) {
                do {
                    list.add(Long.valueOf(this.f7068c.B()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                b0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Long.valueOf(this.f7068c.B()));
                } while (this.f7068c.h() < h3);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public <T> T S(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Z(3);
        return V(schema, extensionRegistryLite);
    }

    public void X(List<String> list, boolean z) throws IOException {
        int Y;
        int Y2;
        if (WireFormat.b(this.f7069d) != 2) {
            throw InvalidProtocolBufferException.e();
        } else if (!(list instanceof LazyStringList) || z) {
            do {
                list.add(z ? Q() : B());
                if (!this.f7068c.i()) {
                    Y = this.f7068c.Y();
                } else {
                    return;
                }
            } while (Y == this.f7069d);
            this.f7071f = Y;
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.C0(F());
                if (!this.f7068c.i()) {
                    Y2 = this.f7068c.Y();
                } else {
                    return;
                }
            } while (Y2 == this.f7069d);
            this.f7071f = Y2;
        }
    }

    public <T> T a(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Z(2);
        return W(schema, extensionRegistryLite);
    }

    public void b(List<Integer> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    intArrayList.h0(this.f7068c.U());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    intArrayList.h0(this.f7068c.U());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068c.U()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Integer.valueOf(this.f7068c.U()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public long c() throws IOException {
        Z(0);
        return this.f7068c.a0();
    }

    public long d() throws IOException {
        Z(1);
        return this.f7068c.B();
    }

    public <T> T e(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Z(2);
        return W(Protobuf.a().i(cls), extensionRegistryLite);
    }

    public <T> void f(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        I(list, Protobuf.a().i(cls), extensionRegistryLite);
    }

    public void g(List<Integer> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 2) {
                int Z = this.f7068c.Z();
                a0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    intArrayList.h0(this.f7068c.S());
                } while (this.f7068c.h() < h2);
            } else if (b2 == 5) {
                do {
                    intArrayList.h0(this.f7068c.S());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                a0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Integer.valueOf(this.f7068c.S()));
                } while (this.f7068c.h() < h3);
            } else if (b3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f7068c.S()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void h(List<Long> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    longArrayList.S0(this.f7068c.V());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    longArrayList.S0(this.f7068c.V());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f7068c.V()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Long.valueOf(this.f7068c.V()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public void i(List<Integer> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    intArrayList.h0(this.f7068c.Z());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    intArrayList.h0(this.f7068c.Z());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068c.Z()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Integer.valueOf(this.f7068c.Z()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public int j() throws IOException {
        Z(5);
        return this.f7068c.A();
    }

    public boolean k() throws IOException {
        Z(0);
        return this.f7068c.u();
    }

    public long l() throws IOException {
        Z(1);
        return this.f7068c.T();
    }

    public void m(List<Long> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    longArrayList.S0(this.f7068c.a0());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    longArrayList.S0(this.f7068c.a0());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f7068c.a0()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Long.valueOf(this.f7068c.a0()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public int n() {
        return this.f7069d;
    }

    public <T> T o(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Z(3);
        return V(Protobuf.a().i(cls), extensionRegistryLite);
    }

    public <T> void p(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        O(list, Protobuf.a().i(cls), extensionRegistryLite);
    }

    public int q() throws IOException {
        Z(0);
        return this.f7068c.Z();
    }

    public void r(List<Long> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    longArrayList.S0(this.f7068c.G());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    longArrayList.S0(this.f7068c.G());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Long.valueOf(this.f7068c.G()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Long.valueOf(this.f7068c.G()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public double readDouble() throws IOException {
        Z(1);
        return this.f7068c.y();
    }

    public float readFloat() throws IOException {
        Z(5);
        return this.f7068c.C();
    }

    public void s(List<Long> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 1) {
                do {
                    longArrayList.S0(this.f7068c.T());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else if (b2 == 2) {
                int Z = this.f7068c.Z();
                b0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    longArrayList.S0(this.f7068c.T());
                } while (this.f7068c.h() < h2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 1) {
                do {
                    list.add(Long.valueOf(this.f7068c.T()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                b0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Long.valueOf(this.f7068c.T()));
                } while (this.f7068c.h() < h3);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void t(List<Integer> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    intArrayList.h0(this.f7068c.F());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    intArrayList.h0(this.f7068c.F());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068c.F()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Integer.valueOf(this.f7068c.F()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    public void u(List<Integer> list) throws IOException {
        int i2;
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 0) {
                do {
                    intArrayList.h0(this.f7068c.z());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
                return;
            } else if (b2 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    intArrayList.h0(this.f7068c.z());
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068c.z()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
                return;
            } else if (b3 == 2) {
                i2 = this.f7068c.h() + this.f7068c.Z();
                do {
                    list.add(Integer.valueOf(this.f7068c.z()));
                } while (this.f7068c.h() < i2);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        Y(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (K() != false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void v(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.Z(r0)
            androidx.datastore.preferences.protobuf.CodedInputStream r1 = r7.f7068c
            int r1 = r1.Z()
            androidx.datastore.preferences.protobuf.CodedInputStream r2 = r7.f7068c
            int r1 = r2.t(r1)
            K r2 = r9.f7194b
            V r3 = r9.f7196d
        L_0x0014:
            int r4 = r7.C()     // Catch:{ all -> 0x003a }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005e
            androidx.datastore.preferences.protobuf.CodedInputStream r5 = r7.f7068c     // Catch:{ all -> 0x003a }
            boolean r5 = r5.i()     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x0026
            goto L_0x005e
        L_0x0026:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0049
            if (r4 == r0) goto L_0x003c
            boolean r4 = r7.K()     // Catch:{ InvalidWireTypeException -> 0x0051 }
            if (r4 == 0) goto L_0x0034
            goto L_0x0014
        L_0x0034:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x0051 }
            r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x0051 }
        L_0x003a:
            r8 = move-exception
            goto L_0x0067
        L_0x003c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7195c     // Catch:{ InvalidWireTypeException -> 0x0051 }
            V r5 = r9.f7196d     // Catch:{ InvalidWireTypeException -> 0x0051 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x0051 }
            java.lang.Object r3 = r7.U(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            goto L_0x0014
        L_0x0049:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7193a     // Catch:{ InvalidWireTypeException -> 0x0051 }
            r5 = 0
            java.lang.Object r2 = r7.U(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x0051 }
            goto L_0x0014
        L_0x0051:
            boolean r4 = r7.K()     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0058
            goto L_0x0014
        L_0x0058:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x003a }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x003a }
            throw r8     // Catch:{ all -> 0x003a }
        L_0x005e:
            r8.put(r2, r3)     // Catch:{ all -> 0x003a }
            androidx.datastore.preferences.protobuf.CodedInputStream r8 = r7.f7068c
            r8.s(r1)
            return
        L_0x0067:
            androidx.datastore.preferences.protobuf.CodedInputStream r9 = r7.f7068c
            r9.s(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.v(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    public int w() throws IOException {
        Z(0);
        return this.f7068c.z();
    }

    public void x(List<Integer> list) throws IOException {
        int Y;
        int Y2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b2 = WireFormat.b(this.f7069d);
            if (b2 == 2) {
                int Z = this.f7068c.Z();
                a0(Z);
                int h2 = this.f7068c.h() + Z;
                do {
                    intArrayList.h0(this.f7068c.A());
                } while (this.f7068c.h() < h2);
            } else if (b2 == 5) {
                do {
                    intArrayList.h0(this.f7068c.A());
                    if (!this.f7068c.i()) {
                        Y2 = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y2 == this.f7069d);
                this.f7071f = Y2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b3 = WireFormat.b(this.f7069d);
            if (b3 == 2) {
                int Z2 = this.f7068c.Z();
                a0(Z2);
                int h3 = this.f7068c.h() + Z2;
                do {
                    list.add(Integer.valueOf(this.f7068c.A()));
                } while (this.f7068c.h() < h3);
            } else if (b3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f7068c.A()));
                    if (!this.f7068c.i()) {
                        Y = this.f7068c.Y();
                    } else {
                        return;
                    }
                } while (Y == this.f7069d);
                this.f7071f = Y;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public int y() throws IOException {
        Z(0);
        return this.f7068c.U();
    }

    public long z() throws IOException {
        Z(0);
        return this.f7068c.V();
    }
}
