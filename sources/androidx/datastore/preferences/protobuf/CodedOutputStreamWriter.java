package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Writer;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final CodedOutputStream f7101a;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7102a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7102a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f7102a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.e(codedOutputStream, HTML.Tag.U);
        this.f7101a = codedOutputStream2;
        codedOutputStream2.f7077a = this;
    }

    public static CodedOutputStreamWriter T(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f7077a;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void V(int i2, boolean z, V v, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.f7101a.g2(i2, 2);
        this.f7101a.h2(MapEntryLite.b(metadata, Boolean.valueOf(z), v));
        MapEntryLite.l(this.f7101a, metadata, Boolean.valueOf(z), v);
    }

    private <V> void W(int i2, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i3 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i3] = intValue.intValue();
            i3++;
        }
        Arrays.sort(iArr);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            V v = map.get(Integer.valueOf(i5));
            this.f7101a.g2(i2, 2);
            this.f7101a.h2(MapEntryLite.b(metadata, Integer.valueOf(i5), v));
            MapEntryLite.l(this.f7101a, metadata, Integer.valueOf(i5), v);
        }
    }

    private <V> void X(int i2, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i3 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i3] = longValue.longValue();
            i3++;
        }
        Arrays.sort(jArr);
        for (int i4 = 0; i4 < size; i4++) {
            long j2 = jArr[i4];
            V v = map.get(Long.valueOf(j2));
            this.f7101a.g2(i2, 2);
            this.f7101a.h2(MapEntryLite.b(metadata, Long.valueOf(j2), v));
            MapEntryLite.l(this.f7101a, metadata, Long.valueOf(j2), v);
        }
    }

    private <K, V> void Y(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.f7102a[metadata.f7193a.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    V(i2, false, v, metadata);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    V(i2, true, v2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                W(i2, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                X(i2, metadata, map);
                return;
            case 12:
                Z(i2, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f7193a);
        }
    }

    private <V> void Z(int i2, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i3 = 0;
        for (String str : map.keySet()) {
            strArr[i3] = str;
            i3++;
        }
        Arrays.sort(strArr);
        for (int i4 = 0; i4 < size; i4++) {
            String str2 = strArr[i4];
            V v = map.get(str2);
            this.f7101a.g2(i2, 2);
            this.f7101a.h2(MapEntryLite.b(metadata, str2, v));
            MapEntryLite.l(this.f7101a, metadata, str2, v);
        }
    }

    private void a0(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f7101a.o(i2, (String) obj);
        } else {
            this.f7101a.z(i2, (ByteString) obj);
        }
    }

    public void A(int i2, long j2) throws IOException {
        this.f7101a.A(i2, j2);
    }

    public void B(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.n0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.C1(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void C(int i2, Object obj, Schema schema) throws IOException {
        this.f7101a.M1(i2, (MessageLite) obj, schema);
    }

    public void D(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.b0(list.get(i5).booleanValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.t1(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.t(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public void E(int i2, Object obj) throws IOException {
        this.f7101a.F1(i2, (MessageLite) obj);
    }

    public void F(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.Z0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.h2(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void G(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.U0(list.get(i5).longValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.e2(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.H(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public void H(int i2, long j2) throws IOException {
        this.f7101a.H(i2, j2);
    }

    public void I(int i2, float f2) throws IOException {
        this.f7101a.I(i2, f2);
    }

    public void J(int i2) throws IOException {
        this.f7101a.g2(i2, 4);
    }

    public void K(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.S0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.d2(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.Q(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void L(int i2, int i3) throws IOException {
        this.f7101a.L(i2, i3);
    }

    public void M(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.z0(list.get(i5).longValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.K1(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.s(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public void N(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.l0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.B1(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.L(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void O(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.j0(list.get(i5).doubleValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.A1(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.e(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public <K, V> void P(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.f7101a.h1()) {
            Y(i2, metadata, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.f7101a.g2(i2, 2);
            this.f7101a.h2(MapEntryLite.b(metadata, next.getKey(), next.getValue()));
            MapEntryLite.l(this.f7101a, metadata, next.getKey(), next.getValue());
        }
    }

    public void Q(int i2, int i3) throws IOException {
        this.f7101a.Q(i2, i3);
    }

    public void R(int i2, List<ByteString> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f7101a.z(i2, list.get(i3));
        }
    }

    public void S(int i2, Object obj, Schema schema) throws IOException {
        this.f7101a.G1(i2, (MessageLite) obj, schema);
    }

    public int U() {
        return this.f7101a.f1();
    }

    public void a(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.r0(list.get(i5).floatValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.E1(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.I(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public void b(int i2, int i3) throws IOException {
        this.f7101a.b(i2, i3);
    }

    public final void c(int i2, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f7101a.Y1(i2, (ByteString) obj);
        } else {
            this.f7101a.P1(i2, (MessageLite) obj);
        }
    }

    public void d(int i2, int i3) throws IOException {
        this.f7101a.d(i2, i3);
    }

    public void e(int i2, double d2) throws IOException {
        this.f7101a.e(i2, d2);
    }

    public void f(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.Q0(list.get(i5).longValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.c2(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.A(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public void g(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.b1(list.get(i5).longValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.i2(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.p(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public void h(int i2, List<?> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            E(i2, list.get(i3));
        }
    }

    public void i(int i2, long j2) throws IOException {
        this.f7101a.i(i2, j2);
    }

    public Writer.FieldOrder j() {
        return Writer.FieldOrder.ASCENDING;
    }

    public void k(int i2, List<?> list, Schema schema) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            C(i2, list.get(i3), schema);
        }
    }

    public void l(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i3 < list.size()) {
                a0(i2, lazyStringList.w2(i3));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.o(i2, list.get(i3));
            i3++;
        }
    }

    public void m(int i2, List<?> list, Schema schema) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            S(i2, list.get(i3), schema);
        }
    }

    public void n(int i2, List<?> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            q(i2, list.get(i3));
        }
    }

    public void o(int i2, String str) throws IOException {
        this.f7101a.o(i2, str);
    }

    public void p(int i2, long j2) throws IOException {
        this.f7101a.p(i2, j2);
    }

    public void q(int i2, Object obj) throws IOException {
        this.f7101a.L1(i2, (MessageLite) obj);
    }

    public void r(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.x0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.J1(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.w(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void s(int i2, long j2) throws IOException {
        this.f7101a.s(i2, j2);
    }

    public void t(int i2, boolean z) throws IOException {
        this.f7101a.t(i2, z);
    }

    public void u(int i2, int i3) throws IOException {
        this.f7101a.u(i2, i3);
    }

    public void v(int i2) throws IOException {
        this.f7101a.g2(i2, 3);
    }

    public void w(int i2, int i3) throws IOException {
        this.f7101a.w(i2, i3);
    }

    public void x(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.p0(list.get(i5).longValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.D1(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.i(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public void y(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f7101a.g2(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += CodedOutputStream.O0(list.get(i5).intValue());
            }
            this.f7101a.h2(i4);
            while (i3 < list.size()) {
                this.f7101a.b2(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f7101a.u(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public void z(int i2, ByteString byteString) throws IOException {
        this.f7101a.z(i2, byteString);
    }
}
