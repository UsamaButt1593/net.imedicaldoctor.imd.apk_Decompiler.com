package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class MessageSchema<T> implements Schema<T> {
    private static final int r = 3;
    private static final int s = 20;
    private static final int t = 1048575;
    private static final int u = 267386880;
    private static final int v = 268435456;
    private static final int w = 536870912;
    private static final int[] x = new int[0];
    static final int y = 51;
    private static final Unsafe z = UnsafeUtil.R();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f7203a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f7204b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7205c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7206d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f7207e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7208f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7209g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7210h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f7211i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f7212j;

    /* renamed from: k  reason: collision with root package name */
    private final int f7213k;

    /* renamed from: l  reason: collision with root package name */
    private final int f7214l;

    /* renamed from: m  reason: collision with root package name */
    private final NewInstanceSchema f7215m;

    /* renamed from: n  reason: collision with root package name */
    private final ListFieldSchema f7216n;
    private final UnknownFieldSchema<?, ?> o;
    private final ExtensionSchema<?> p;
    private final MapFieldSchema q;

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7217a;

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
                f7217a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f7217a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i2, int i3, MessageLite messageLite, boolean z2, boolean z3, int[] iArr2, int i4, int i5, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f7203a = iArr;
        this.f7204b = objArr;
        this.f7205c = i2;
        this.f7206d = i3;
        this.f7209g = messageLite instanceof GeneratedMessageLite;
        this.f7210h = z2;
        this.f7208f = extensionSchema != null && extensionSchema.e(messageLite);
        this.f7211i = z3;
        this.f7212j = iArr2;
        this.f7213k = i4;
        this.f7214l = i5;
        this.f7215m = newInstanceSchema;
        this.f7216n = listFieldSchema;
        this.o = unknownFieldSchema;
        this.p = extensionSchema;
        this.f7207e = messageLite;
        this.q = mapFieldSchema;
    }

    private <UT, UB> int A(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2) {
        return unknownFieldSchema.h(unknownFieldSchema.g(t2));
    }

    private <UT, UB> void A0(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2, Writer writer) throws IOException {
        unknownFieldSchema.t(unknownFieldSchema.g(t2), writer);
    }

    private static <T> int B(T t2, long j2) {
        return UnsafeUtil.I(t2, j2);
    }

    private static boolean C(int i2) {
        return (i2 & 536870912) != 0;
    }

    private boolean D(T t2, int i2) {
        if (this.f7210h) {
            int u0 = u0(i2);
            long W = W(u0);
            switch (t0(u0)) {
                case 0:
                    return UnsafeUtil.D(t2, W) != 0.0d;
                case 1:
                    return UnsafeUtil.F(t2, W) != 0.0f;
                case 2:
                    return UnsafeUtil.L(t2, W) != 0;
                case 3:
                    return UnsafeUtil.L(t2, W) != 0;
                case 4:
                    return UnsafeUtil.I(t2, W) != 0;
                case 5:
                    return UnsafeUtil.L(t2, W) != 0;
                case 6:
                    return UnsafeUtil.I(t2, W) != 0;
                case 7:
                    return UnsafeUtil.u(t2, W);
                case 8:
                    Object O = UnsafeUtil.O(t2, W);
                    if (O instanceof String) {
                        return !((String) O).isEmpty();
                    }
                    if (O instanceof ByteString) {
                        return !ByteString.X2.equals(O);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.O(t2, W) != null;
                case 10:
                    return !ByteString.X2.equals(UnsafeUtil.O(t2, W));
                case 11:
                    return UnsafeUtil.I(t2, W) != 0;
                case 12:
                    return UnsafeUtil.I(t2, W) != 0;
                case 13:
                    return UnsafeUtil.I(t2, W) != 0;
                case 14:
                    return UnsafeUtil.L(t2, W) != 0;
                case 15:
                    return UnsafeUtil.I(t2, W) != 0;
                case 16:
                    return UnsafeUtil.L(t2, W) != 0;
                case 17:
                    return UnsafeUtil.O(t2, W) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int j0 = j0(i2);
            return (UnsafeUtil.I(t2, (long) (j0 & t)) & (1 << (j0 >>> 20))) != 0;
        }
    }

    private boolean E(T t2, int i2, int i3, int i4) {
        if (this.f7210h) {
            return D(t2, i2);
        }
        return (i3 & i4) != 0;
    }

    private static boolean F(Object obj, int i2, Schema schema) {
        return schema.d(UnsafeUtil.O(obj, W(i2)));
    }

    private <N> boolean G(Object obj, int i2, int i3) {
        List list = (List) UnsafeUtil.O(obj, W(i2));
        if (list.isEmpty()) {
            return true;
        }
        Schema v2 = v(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!v2.d(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    private boolean H(T t2, int i2, int i3) {
        Map<?, ?> h2 = this.q.h(UnsafeUtil.O(t2, W(i2)));
        if (h2.isEmpty()) {
            return true;
        }
        if (this.q.c(u(i3)).f7195c.a() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : h2.values()) {
            if (schema == null) {
                schema = Protobuf.a().i(next.getClass());
            }
            if (!schema.d(next)) {
                return false;
            }
        }
        return true;
    }

    private boolean I(T t2, T t3, int i2) {
        long j0 = (long) (j0(i2) & t);
        return UnsafeUtil.I(t2, j0) == UnsafeUtil.I(t3, j0);
    }

    private boolean J(T t2, int i2, int i3) {
        return UnsafeUtil.I(t2, (long) (j0(i3) & t)) == i2;
    }

    private static boolean K(int i2) {
        return (i2 & 268435456) != 0;
    }

    private static List<?> L(Object obj, long j2) {
        return (List) UnsafeUtil.O(obj, j2);
    }

    private static <T> long M(T t2, long j2) {
        return UnsafeUtil.L(t2, j2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:160|161|(2:163|(5:191|165|(2:168|166)|228|(2:170|237)(1:238))(1:223))(3:(2:172|173)|174|(5:192|176|(2:179|177)|229|(2:181|239)(1:240))(1:224))) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02bc, code lost:
        r0.x(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02cb, code lost:
        r0.R(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02da, code lost:
        r0.t(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02e9, code lost:
        r0.m(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02f8, code lost:
        r0.r(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0307, code lost:
        r0.G(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0316, code lost:
        r0.N(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x040e, code lost:
        androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0422, code lost:
        p0(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0529, code lost:
        if (r9.q(r0) != false) goto L_0x052b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x052f, code lost:
        if (r20.K() == false) goto L_0x0531;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0531, code lost:
        r0 = r8.f7213k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0535, code lost:
        if (r0 < r8.f7214l) goto L_0x0537;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0537, code lost:
        r13 = q(r10, r8.f7212j[r0], r13, r9);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0542, code lost:
        if (r13 != null) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0544, code lost:
        r9.o(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0548, code lost:
        if (r13 == null) goto L_0x054a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        r13 = r9.f(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0553, code lost:
        if (r9.m(r13, r0) == false) goto L_0x0555;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0555, code lost:
        r0 = r8.f7213k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0559, code lost:
        if (r0 < r8.f7214l) goto L_0x055b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x055b, code lost:
        r13 = q(r10, r8.f7212j[r0], r13, r9);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0566, code lost:
        if (r13 != null) goto L_0x0568;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0568, code lost:
        r9.o(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x056c, code lost:
        r1 = r8.f7213k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0570, code lost:
        if (r1 < r8.f7214l) goto L_0x0572;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0572, code lost:
        r13 = q(r10, r8.f7212j[r1], r13, r9);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x057d, code lost:
        if (r13 != null) goto L_0x057f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x057f, code lost:
        r9.o(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0582, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d1, code lost:
        q0(r10, r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0127, code lost:
        r13 = androidx.datastore.preferences.protobuf.SchemaUtil.Q(r1, r2, r13, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x024b, code lost:
        r0.h(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x025a, code lost:
        r0.b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0269, code lost:
        r0.s(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0278, code lost:
        r0.g(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x028e, code lost:
        r13 = androidx.datastore.preferences.protobuf.SchemaUtil.C(r1, r2, r3, r13, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x029e, code lost:
        r0.i(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02ad, code lost:
        r0.A(r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:160:0x0525 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void N(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r17, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r18, T r19, androidx.datastore.preferences.protobuf.Reader r20, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.C()     // Catch:{ all -> 0x004e }
            int r3 = r8.h0(r1)     // Catch:{ all -> 0x004e }
            if (r3 >= 0) goto L_0x0092
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.f7213k
        L_0x001e:
            int r1 = r8.f7214l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.f7212j
            r1 = r1[r0]
            java.lang.Object r13 = r8.q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f7208f     // Catch:{ all -> 0x004e }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.f7207e     // Catch:{ all -> 0x004e }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x004e }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x0060
            if (r14 != 0) goto L_0x0051
            androidx.datastore.preferences.protobuf.FieldSet r1 = r18.d(r19)     // Catch:{ all -> 0x004e }
            r14 = r1
            goto L_0x0051
        L_0x004e:
            r0 = move-exception
            goto L_0x056c
        L_0x0051:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            goto L_0x000d
        L_0x0060:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x006d
            boolean r1 = r20.K()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x007b
            goto L_0x000d
        L_0x006d:
            if (r13 != 0) goto L_0x0074
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x004e }
            r13 = r1
        L_0x0074:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x007b
            goto L_0x000d
        L_0x007b:
            int r0 = r8.f7213k
        L_0x007d:
            int r1 = r8.f7214l
            if (r0 >= r1) goto L_0x008c
            int[] r1 = r8.f7212j
            r1 = r1[r0]
            java.lang.Object r13 = r8.q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x008c:
            if (r13 == 0) goto L_0x0091
            r9.o(r10, r13)
        L_0x0091:
            return
        L_0x0092:
            r15 = r18
            int r4 = r8.u0(r3)     // Catch:{ all -> 0x004e }
            int r2 = t0(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            switch(r2) {
                case 0: goto L_0x0518;
                case 1: goto L_0x050b;
                case 2: goto L_0x04fe;
                case 3: goto L_0x04f1;
                case 4: goto L_0x04e4;
                case 5: goto L_0x04d7;
                case 6: goto L_0x04ca;
                case 7: goto L_0x04bd;
                case 8: goto L_0x04b8;
                case 9: goto L_0x0487;
                case 10: goto L_0x047b;
                case 11: goto L_0x046f;
                case 12: goto L_0x0457;
                case 13: goto L_0x044b;
                case 14: goto L_0x043f;
                case 15: goto L_0x0433;
                case 16: goto L_0x0427;
                case 17: goto L_0x03f0;
                case 18: goto L_0x03e4;
                case 19: goto L_0x03d8;
                case 20: goto L_0x03cc;
                case 21: goto L_0x03c0;
                case 22: goto L_0x03b4;
                case 23: goto L_0x03a8;
                case 24: goto L_0x039c;
                case 25: goto L_0x0390;
                case 26: goto L_0x038b;
                case 27: goto L_0x0379;
                case 28: goto L_0x036a;
                case 29: goto L_0x035e;
                case 30: goto L_0x034b;
                case 31: goto L_0x033f;
                case 32: goto L_0x0333;
                case 33: goto L_0x0327;
                case 34: goto L_0x031b;
                case 35: goto L_0x030c;
                case 36: goto L_0x02fd;
                case 37: goto L_0x02ee;
                case 38: goto L_0x02df;
                case 39: goto L_0x02d0;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b2;
                case 42: goto L_0x02a3;
                case 43: goto L_0x0294;
                case 44: goto L_0x027d;
                case 45: goto L_0x026e;
                case 46: goto L_0x025f;
                case 47: goto L_0x0250;
                case 48: goto L_0x0241;
                case 49: goto L_0x022b;
                case 50: goto L_0x021a;
                case 51: goto L_0x0209;
                case 52: goto L_0x01f8;
                case 53: goto L_0x01e7;
                case 54: goto L_0x01d6;
                case 55: goto L_0x01c5;
                case 56: goto L_0x01b4;
                case 57: goto L_0x01a3;
                case 58: goto L_0x0192;
                case 59: goto L_0x018d;
                case 60: goto L_0x0156;
                case 61: goto L_0x0149;
                case 62: goto L_0x0139;
                case 63: goto L_0x0116;
                case 64: goto L_0x0106;
                case 65: goto L_0x00f6;
                case 66: goto L_0x00e6;
                case 67: goto L_0x00d6;
                case 68: goto L_0x00c2;
                default: goto L_0x009f;
            }     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x009f:
            if (r13 != 0) goto L_0x00a5
            java.lang.Object r13 = r17.n()     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x00a5:
            boolean r1 = r9.m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f7213k
        L_0x00ad:
            int r1 = r8.f7214l
            if (r0 >= r1) goto L_0x00bc
            int[] r1 = r8.f7212j
            r1 = r1[r0]
            java.lang.Object r13 = r8.q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x00ad
        L_0x00bc:
            if (r13 == 0) goto L_0x00c1
            r9.o(r10, r13)
        L_0x00c1:
            return
        L_0x00c2:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = r0.S(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x00d1:
            r8.q0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x00d6:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r6 = r20.z()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x00e6:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r2 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x00f6:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r6 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0106:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r2 = r20.L()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0116:
            int r2 = r20.w()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r5 == 0) goto L_0x012d
            boolean r5 = r5.a(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r5 == 0) goto L_0x0127
            goto L_0x012d
        L_0x0127:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.Q(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x012d:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0139:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r2 = r20.q()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0149:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.ByteString r2 = r20.F()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0156:
            boolean r2 = r8.J(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r2 == 0) goto L_0x0179
            long r5 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r5 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r5 = r0.a(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.Internal.v(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0179:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = r0.a(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x018d:
            r8.m0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0192:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            boolean r2 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01a3:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r2 = r20.j()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01b4:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r6 = r20.d()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01c5:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r2 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01d6:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r6 = r20.c()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01e7:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r6 = r20.P()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x01f8:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x0209:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x00d1
        L_0x021a:
            java.lang.Object r4 = r8.u(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.O(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x022b:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r6 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.k0(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0241:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x024b:
            r0.h(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0250:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x025a:
            r0.b(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x025f:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x0269:
            r0.s(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x026e:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x0278:
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x027d:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r0.u(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x028e:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.C(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0294:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x029e:
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02a3:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02ad:
            r0.A(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02b2:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02bc:
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02c1:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02cb:
            r0.R(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02d0:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02da:
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02df:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02e9:
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02ee:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x02f8:
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x02fd:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x0307:
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x030c:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x0316:
            r0.N(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x031b:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x024b
        L_0x0327:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x025a
        L_0x0333:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0269
        L_0x033f:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0278
        L_0x034b:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r0.u(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x028e
        L_0x035e:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x029e
        L_0x036a:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r0.M(r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0379:
            androidx.datastore.preferences.protobuf.Schema r5 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.l0(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x038b:
            r8.n0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0390:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02ad
        L_0x039c:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02bc
        L_0x03a8:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02cb
        L_0x03b4:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02da
        L_0x03c0:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02e9
        L_0x03cc:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x02f8
        L_0x03d8:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0307
        L_0x03e4:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.f7216n     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0316
        L_0x03f0:
            boolean r1 = r8.D(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r1 == 0) goto L_0x0413
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = r0.S(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.v(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x040e:
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0413:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r4 = r0.S(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
        L_0x0422:
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x000d
        L_0x0427:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = r20.z()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x0433:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r4 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x043f:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x044b:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r4 = r20.L()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x0457:
            int r2 = r20.w()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r5 == 0) goto L_0x0467
            boolean r5 = r5.a(r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r5 == 0) goto L_0x0127
        L_0x0467:
            long r4 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x046f:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r4 = r20.q()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x047b:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.ByteString r4 = r20.F()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x0487:
            boolean r1 = r8.D(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            if (r1 == 0) goto L_0x04a7
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r2 = r0.a(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.v(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r2 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x040e
        L_0x04a7:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.v(r3)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            java.lang.Object r4 = r0.a(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04b8:
            r8.m0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04bd:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            boolean r4 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.X(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04ca:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r4 = r20.j()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04d7:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = r20.d()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04e4:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            int r4 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04f1:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = r20.c()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x04fe:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            long r4 = r20.P()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x050b:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.i0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x0518:
            long r1 = W(r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0525 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.g0(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0525 }
            goto L_0x0422
        L_0x0525:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0548
            boolean r1 = r20.K()     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f7213k
        L_0x0533:
            int r1 = r8.f7214l
            if (r0 >= r1) goto L_0x0542
            int[] r1 = r8.f7212j
            r1 = r1[r0]
            java.lang.Object r13 = r8.q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0533
        L_0x0542:
            if (r13 == 0) goto L_0x0547
            r9.o(r10, r13)
        L_0x0547:
            return
        L_0x0548:
            if (r13 != 0) goto L_0x054f
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x004e }
            r13 = r1
        L_0x054f:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f7213k
        L_0x0557:
            int r1 = r8.f7214l
            if (r0 >= r1) goto L_0x0566
            int[] r1 = r8.f7212j
            r1 = r1[r0]
            java.lang.Object r13 = r8.q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0557
        L_0x0566:
            if (r13 == 0) goto L_0x056b
            r9.o(r10, r13)
        L_0x056b:
            return
        L_0x056c:
            int r1 = r8.f7213k
        L_0x056e:
            int r2 = r8.f7214l
            if (r1 >= r2) goto L_0x057d
            int[] r2 = r8.f7212j
            r2 = r2[r1]
            java.lang.Object r13 = r8.q(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x056e
        L_0x057d:
            if (r13 == 0) goto L_0x0582
            r9.o(r10, r13)
        L_0x0582:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.N(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void O(Object obj, int i2, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long W = W(u0(i2));
        Object O = UnsafeUtil.O(obj, W);
        if (O == null) {
            O = this.q.e(obj2);
            UnsafeUtil.q0(obj, W, O);
        } else if (this.q.g(O)) {
            Object e2 = this.q.e(obj2);
            this.q.a(e2, O);
            UnsafeUtil.q0(obj, W, e2);
            O = e2;
        }
        reader.v(this.q.d(O), this.q.c(obj2), extensionRegistryLite);
    }

    private void P(T t2, T t3, int i2) {
        long W = W(u0(i2));
        if (D(t3, i2)) {
            Object O = UnsafeUtil.O(t2, W);
            Object O2 = UnsafeUtil.O(t3, W);
            if (O != null && O2 != null) {
                O2 = Internal.v(O, O2);
            } else if (O2 == null) {
                return;
            }
            UnsafeUtil.q0(t2, W, O2);
            p0(t2, i2);
        }
    }

    private void Q(T t2, T t3, int i2) {
        int u0 = u0(i2);
        int V = V(i2);
        long W = W(u0);
        if (J(t3, V, i2)) {
            Object O = UnsafeUtil.O(t2, W);
            Object O2 = UnsafeUtil.O(t3, W);
            if (O != null && O2 != null) {
                O2 = Internal.v(O, O2);
            } else if (O2 == null) {
                return;
            }
            UnsafeUtil.q0(t2, W, O2);
            q0(t2, V, i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r6, r1, androidx.datastore.preferences.protobuf.UnsafeUtil.L(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        p0(r6, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r6, r1, androidx.datastore.preferences.protobuf.UnsafeUtil.I(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r6, r1, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r7, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r6, r1, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r7, r1));
        q0(r6, r3, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void R(T r6, T r7, int r8) {
        /*
            r5 = this;
            int r0 = r5.u0(r8)
            long r1 = W(r0)
            int r3 = r5.V(r8)
            int r0 = t0(r0)
            switch(r0) {
                case 0: goto L_0x00d7;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00ba;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00ac;
                case 6: goto L_0x00a5;
                case 7: goto L_0x0097;
                case 8: goto L_0x0090;
                case 9: goto L_0x0041;
                case 10: goto L_0x0082;
                case 11: goto L_0x007b;
                case 12: goto L_0x0074;
                case 13: goto L_0x006d;
                case 14: goto L_0x0066;
                case 15: goto L_0x0058;
                case 16: goto L_0x0046;
                case 17: goto L_0x0041;
                case 18: goto L_0x003a;
                case 19: goto L_0x003a;
                case 20: goto L_0x003a;
                case 21: goto L_0x003a;
                case 22: goto L_0x003a;
                case 23: goto L_0x003a;
                case 24: goto L_0x003a;
                case 25: goto L_0x003a;
                case 26: goto L_0x003a;
                case 27: goto L_0x003a;
                case 28: goto L_0x003a;
                case 29: goto L_0x003a;
                case 30: goto L_0x003a;
                case 31: goto L_0x003a;
                case 32: goto L_0x003a;
                case 33: goto L_0x003a;
                case 34: goto L_0x003a;
                case 35: goto L_0x003a;
                case 36: goto L_0x003a;
                case 37: goto L_0x003a;
                case 38: goto L_0x003a;
                case 39: goto L_0x003a;
                case 40: goto L_0x003a;
                case 41: goto L_0x003a;
                case 42: goto L_0x003a;
                case 43: goto L_0x003a;
                case 44: goto L_0x003a;
                case 45: goto L_0x003a;
                case 46: goto L_0x003a;
                case 47: goto L_0x003a;
                case 48: goto L_0x003a;
                case 49: goto L_0x003a;
                case 50: goto L_0x0033;
                case 51: goto L_0x002c;
                case 52: goto L_0x002c;
                case 53: goto L_0x002c;
                case 54: goto L_0x002c;
                case 55: goto L_0x002c;
                case 56: goto L_0x002c;
                case 57: goto L_0x002c;
                case 58: goto L_0x002c;
                case 59: goto L_0x002c;
                case 60: goto L_0x0015;
                case 61: goto L_0x001a;
                case 62: goto L_0x001a;
                case 63: goto L_0x001a;
                case 64: goto L_0x001a;
                case 65: goto L_0x001a;
                case 66: goto L_0x001a;
                case 67: goto L_0x001a;
                case 68: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00e6
        L_0x0015:
            r5.Q(r6, r7, r8)
            goto L_0x00e6
        L_0x001a:
            boolean r0 = r5.J(r7, r3, r8)
            if (r0 == 0) goto L_0x00e6
        L_0x0020:
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r6, r1, r7)
            r5.q0(r6, r3, r8)
            goto L_0x00e6
        L_0x002c:
            boolean r0 = r5.J(r7, r3, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x0020
        L_0x0033:
            androidx.datastore.preferences.protobuf.MapFieldSchema r8 = r5.q
            androidx.datastore.preferences.protobuf.SchemaUtil.I(r8, r6, r7, r1)
            goto L_0x00e6
        L_0x003a:
            androidx.datastore.preferences.protobuf.ListFieldSchema r8 = r5.f7216n
            r8.d(r6, r7, r1)
            goto L_0x00e6
        L_0x0041:
            r5.P(r6, r7, r8)
            goto L_0x00e6
        L_0x0046:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
        L_0x004c:
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.L(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.o0(r6, r1, r3)
        L_0x0053:
            r5.p0(r6, r8)
            goto L_0x00e6
        L_0x0058:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
        L_0x005e:
            int r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.l0(r6, r1, r7)
            goto L_0x0053
        L_0x0066:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x004c
        L_0x006d:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x005e
        L_0x0074:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x005e
        L_0x007b:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x005e
        L_0x0082:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
        L_0x0088:
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.q0(r6, r1, r7)
            goto L_0x0053
        L_0x0090:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x0088
        L_0x0097:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            boolean r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.X(r6, r1, r7)
            goto L_0x0053
        L_0x00a5:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x005e
        L_0x00ac:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x004c
        L_0x00b3:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x005e
        L_0x00ba:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x004c
        L_0x00c1:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            goto L_0x004c
        L_0x00c8:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            float r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.i0(r6, r1, r7)
            goto L_0x0053
        L_0x00d7:
            boolean r0 = r5.D(r7, r8)
            if (r0 == 0) goto L_0x00e6
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r7, r1)
            androidx.datastore.preferences.protobuf.UnsafeUtil.g0(r6, r1, r3)
            goto L_0x0053
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.R(java.lang.Object, java.lang.Object, int):void");
    }

    static <T> MessageSchema<T> S(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? U((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : T((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> T(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i2;
        int i3;
        int i4;
        boolean z2 = structuralMessageInfo.f() == ProtoSyntax.PROTO3;
        FieldInfo[] d2 = structuralMessageInfo.d();
        if (d2.length == 0) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = d2[0].p();
            i2 = d2[d2.length - 1].p();
        }
        int length = d2.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i5 = 0;
        int i6 = 0;
        for (FieldInfo fieldInfo : d2) {
            if (fieldInfo.y() == FieldType.MAP) {
                i5++;
            } else if (fieldInfo.y().f() >= 18 && fieldInfo.y().f() <= 49) {
                i6++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i5 > 0 ? new int[i5] : null;
        if (i6 > 0) {
            iArr2 = new int[i6];
        }
        int[] c2 = structuralMessageInfo.c();
        if (c2 == null) {
            c2 = x;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < d2.length) {
            FieldInfo fieldInfo2 = d2[i7];
            int p2 = fieldInfo2.p();
            s0(fieldInfo2, iArr, i8, z2, objArr);
            if (i9 < c2.length && c2[i9] == p2) {
                c2[i9] = i8;
                i9++;
            }
            if (fieldInfo2.y() == FieldType.MAP) {
                iArr3[i10] = i8;
                i10++;
            } else if (fieldInfo2.y().f() >= 18 && fieldInfo2.y().f() <= 49) {
                i4 = i8;
                iArr2[i11] = (int) UnsafeUtil.W(fieldInfo2.o());
                i11++;
                i7++;
                i8 = i4 + 3;
            }
            i4 = i8;
            i7++;
            i8 = i4 + 3;
        }
        if (iArr3 == null) {
            iArr3 = x;
        }
        if (iArr2 == null) {
            iArr2 = x;
        }
        int[] iArr4 = new int[(c2.length + iArr3.length + iArr2.length)];
        System.arraycopy(c2, 0, iArr4, 0, c2.length);
        System.arraycopy(iArr3, 0, iArr4, c2.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, c2.length + iArr3.length, iArr2.length);
        return new MessageSchema(iArr, objArr, i3, i2, structuralMessageInfo.b(), z2, true, iArr4, c2.length, c2.length + iArr3.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0398  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> U(androidx.datastore.preferences.protobuf.RawMessageInfo r36, androidx.datastore.preferences.protobuf.NewInstanceSchema r37, androidx.datastore.preferences.protobuf.ListFieldSchema r38, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r39, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r40, androidx.datastore.preferences.protobuf.MapFieldSchema r41) {
        /*
            androidx.datastore.preferences.protobuf.ProtoSyntax r0 = r36.f()
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = 0
        L_0x000c:
            java.lang.String r0 = r36.d()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x0035
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = 1
            r8 = 13
        L_0x0022:
            int r9 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0032
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r8
            r4 = r4 | r7
            int r8 = r8 + 13
            r7 = r9
            goto L_0x0022
        L_0x0032:
            int r7 = r7 << r8
            r4 = r4 | r7
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            int r7 = r9 + 1
            char r8 = r0.charAt(r9)
            if (r8 < r6) goto L_0x0055
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r11 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r8 = r8 | r7
            int r9 = r9 + 13
            r7 = r11
            goto L_0x0042
        L_0x0052:
            int r7 = r7 << r9
            r8 = r8 | r7
            r7 = r11
        L_0x0055:
            if (r8 != 0) goto L_0x0062
            int[] r8 = x
            r13 = r8
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            goto L_0x0177
        L_0x0062:
            int r8 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0081
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x007e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r7 = r7 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x006e
        L_0x007e:
            int r8 = r8 << r9
            r7 = r7 | r8
            r8 = r11
        L_0x0081:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x00a0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00a0:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00bc
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00ac
        L_0x00bc:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00bf:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00de
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r2 = r16
            r16 = 13
        L_0x014f:
            int r18 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r6) goto L_0x0161
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r16
            r15 = r15 | r2
            int r16 = r16 + 13
            r2 = r18
            goto L_0x014f
        L_0x0161:
            int r2 = r2 << r16
            r15 = r15 | r2
            r16 = r18
        L_0x0166:
            int r2 = r15 + r13
            int r2 = r2 + r14
            int[] r2 = new int[r2]
            int r14 = r7 * 2
            int r14 = r14 + r8
            r8 = r7
            r7 = r16
            r35 = r13
            r13 = r2
            r2 = r9
            r9 = r35
        L_0x0177:
            sun.misc.Unsafe r5 = z
            java.lang.Object[] r18 = r36.c()
            androidx.datastore.preferences.protobuf.MessageLite r19 = r36.b()
            java.lang.Class r3 = r19.getClass()
            int r6 = r12 * 3
            int[] r6 = new int[r6]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r15 + r9
            r23 = r15
            r24 = r21
            r9 = 0
            r22 = 0
        L_0x0196:
            if (r7 >= r1) goto L_0x03e5
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            r26 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r1) goto L_0x01ca
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r1 = r25
            r25 = 13
        L_0x01ab:
            int r27 = r1 + 1
            char r1 = r0.charAt(r1)
            r28 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x01c4
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r25
            r7 = r7 | r1
            int r25 = r25 + 13
            r1 = r27
            r15 = r28
            goto L_0x01ab
        L_0x01c4:
            int r1 = r1 << r25
            r7 = r7 | r1
            r1 = r27
            goto L_0x01ce
        L_0x01ca:
            r28 = r15
            r1 = r25
        L_0x01ce:
            int r15 = r1 + 1
            char r1 = r0.charAt(r1)
            r25 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x0200
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r15 = r25
            r25 = 13
        L_0x01e1:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            r29 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01fa
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r25
            r1 = r1 | r10
            int r25 = r25 + 13
            r15 = r27
            r10 = r29
            goto L_0x01e1
        L_0x01fa:
            int r10 = r15 << r25
            r1 = r1 | r10
            r15 = r27
            goto L_0x0204
        L_0x0200:
            r29 = r10
            r15 = r25
        L_0x0204:
            r10 = r1 & 255(0xff, float:3.57E-43)
            r25 = r11
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0211
            int r11 = r9 + 1
            r13[r9] = r22
            r9 = r11
        L_0x0211:
            r11 = 51
            r31 = r9
            if (r10 < r11) goto L_0x02b4
            int r11 = r15 + 1
            char r15 = r0.charAt(r15)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0240
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r33 = 13
        L_0x0226:
            int r34 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r9) goto L_0x023b
            r9 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r33
            r15 = r15 | r9
            int r33 = r33 + 13
            r11 = r34
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0226
        L_0x023b:
            int r9 = r11 << r33
            r15 = r15 | r9
            r11 = r34
        L_0x0240:
            int r9 = r10 + -51
            r33 = r11
            r11 = 9
            if (r9 == r11) goto L_0x0263
            r11 = 17
            if (r9 != r11) goto L_0x024d
            goto L_0x0263
        L_0x024d:
            r11 = 12
            if (r9 != r11) goto L_0x0270
            r9 = r4 & 1
            r11 = 1
            if (r9 != r11) goto L_0x0270
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
        L_0x0261:
            r14 = r11
            goto L_0x0270
        L_0x0263:
            int r9 = r22 / 3
            int r9 = r9 * 2
            r11 = 1
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
            goto L_0x0261
        L_0x0270:
            int r15 = r15 * 2
            r9 = r18[r15]
            boolean r11 = r9 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x027e
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
        L_0x027a:
            r11 = r6
            r34 = r7
            goto L_0x0287
        L_0x027e:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = o0(r3, r9)
            r18[r15] = r9
            goto L_0x027a
        L_0x0287:
            long r6 = r5.objectFieldOffset(r9)
            int r7 = (int) r6
            int r15 = r15 + 1
            r6 = r18[r15]
            boolean r9 = r6 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0298
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
        L_0x0296:
            r9 = r7
            goto L_0x02a1
        L_0x0298:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = o0(r3, r6)
            r18[r15] = r6
            goto L_0x0296
        L_0x02a1:
            long r6 = r5.objectFieldOffset(r6)
            int r7 = (int) r6
            r27 = r2
            r6 = r14
            r15 = r33
            r14 = 0
            r35 = r9
            r9 = r3
            r3 = r7
            r7 = r35
            goto L_0x03ab
        L_0x02b4:
            r11 = r6
            r34 = r7
            int r6 = r14 + 1
            r7 = r18[r14]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = o0(r3, r7)
            r9 = 9
            if (r10 == r9) goto L_0x02c9
            r9 = 17
            if (r10 != r9) goto L_0x02ce
        L_0x02c9:
            r27 = r2
            r2 = 1
            goto L_0x0337
        L_0x02ce:
            r9 = 27
            if (r10 == r9) goto L_0x02d6
            r9 = 49
            if (r10 != r9) goto L_0x02da
        L_0x02d6:
            r27 = r2
            r2 = 1
            goto L_0x032b
        L_0x02da:
            r9 = 12
            if (r10 == r9) goto L_0x0316
            r9 = 30
            if (r10 == r9) goto L_0x0316
            r9 = 44
            if (r10 != r9) goto L_0x02e7
            goto L_0x0316
        L_0x02e7:
            r9 = 50
            if (r10 != r9) goto L_0x0312
            int r9 = r23 + 1
            r13[r23] = r22
            int r23 = r22 / 3
            int r23 = r23 * 2
            int r27 = r14 + 2
            r6 = r18[r6]
            r12[r23] = r6
            r6 = r1 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x030b
            int r23 = r23 + 1
            int r6 = r14 + 3
            r14 = r18[r27]
            r12[r23] = r14
            r27 = r2
            r23 = r9
        L_0x0309:
            r9 = r3
            goto L_0x0343
        L_0x030b:
            r23 = r9
            r6 = r27
            r27 = r2
            goto L_0x0309
        L_0x0312:
            r27 = r2
            r2 = 1
            goto L_0x0309
        L_0x0316:
            r9 = r4 & 1
            r27 = r2
            r2 = 1
            if (r9 != r2) goto L_0x0309
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            int r14 = r14 + 2
            r6 = r18[r6]
            r12[r9] = r6
        L_0x0328:
            r9 = r3
            r6 = r14
            goto L_0x0343
        L_0x032b:
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            int r14 = r14 + 2
            r6 = r18[r6]
            r12[r9] = r6
            goto L_0x0328
        L_0x0337:
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r2
            java.lang.Class r14 = r7.getType()
            r12[r9] = r14
            goto L_0x0309
        L_0x0343:
            long r2 = r5.objectFieldOffset(r7)
            int r7 = (int) r2
            r2 = r4 & 1
            r3 = 1
            if (r2 != r3) goto L_0x0398
            r2 = 17
            if (r10 > r2) goto L_0x0398
            int r2 = r15 + 1
            char r14 = r0.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r15) goto L_0x0377
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x0360:
            int r20 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r15) goto L_0x0372
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r19
            r14 = r14 | r2
            int r19 = r19 + 13
            r2 = r20
            goto L_0x0360
        L_0x0372:
            int r2 = r2 << r19
            r14 = r14 | r2
            r2 = r20
        L_0x0377:
            int r19 = r8 * 2
            int r20 = r14 / 32
            int r19 = r19 + r20
            r3 = r18[r19]
            boolean r15 = r3 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x0387
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
        L_0x0385:
            r15 = r2
            goto L_0x0390
        L_0x0387:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.reflect.Field r3 = o0(r9, r3)
            r18[r19] = r3
            goto L_0x0385
        L_0x0390:
            long r2 = r5.objectFieldOffset(r3)
            int r3 = (int) r2
            int r14 = r14 % 32
            goto L_0x039d
        L_0x0398:
            r2 = 55296(0xd800, float:7.7486E-41)
            r3 = 0
            r14 = 0
        L_0x039d:
            r2 = 18
            if (r10 < r2) goto L_0x03ab
            r2 = 49
            if (r10 > r2) goto L_0x03ab
            int r2 = r24 + 1
            r13[r24] = r7
            r24 = r2
        L_0x03ab:
            int r2 = r22 + 1
            r11[r22] = r34
            int r30 = r22 + 2
            r32 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03ba
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03bb
        L_0x03ba:
            r0 = 0
        L_0x03bb:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03c2
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c3
        L_0x03c2:
            r1 = 0
        L_0x03c3:
            r0 = r0 | r1
            int r1 = r10 << 20
            r0 = r0 | r1
            r0 = r0 | r7
            r11[r2] = r0
            int r22 = r22 + 3
            int r0 = r14 << 20
            r0 = r0 | r3
            r11[r30] = r0
            r14 = r6
            r3 = r9
            r6 = r11
            r7 = r15
            r11 = r25
            r1 = r26
            r2 = r27
            r15 = r28
            r10 = r29
            r9 = r31
            r0 = r32
            goto L_0x0196
        L_0x03e5:
            r27 = r2
            r29 = r10
            r25 = r11
            r28 = r15
            r11 = r6
            androidx.datastore.preferences.protobuf.MessageSchema r0 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r9 = r36.b()
            r1 = 0
            r4 = r0
            r5 = r11
            r6 = r12
            r7 = r27
            r8 = r25
            r11 = r1
            r12 = r13
            r13 = r28
            r14 = r21
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.U(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int V(int i2) {
        return this.f7203a[i2];
    }

    private static long W(int i2) {
        return (long) (i2 & t);
    }

    private static <T> boolean X(T t2, long j2) {
        return ((Boolean) UnsafeUtil.O(t2, j2)).booleanValue();
    }

    private static <T> double Y(T t2, long j2) {
        return ((Double) UnsafeUtil.O(t2, j2)).doubleValue();
    }

    private static <T> float Z(T t2, long j2) {
        return ((Float) UnsafeUtil.O(t2, j2)).floatValue();
    }

    private static <T> int a0(T t2, long j2) {
        return ((Integer) UnsafeUtil.O(t2, j2)).intValue();
    }

    private static <T> long b0(T t2, long j2) {
        return ((Long) UnsafeUtil.O(t2, j2)).longValue();
    }

    private <K, V> int c0(T t2, byte[] bArr, int i2, int i3, int i4, long j2, ArrayDecoders.Registers registers) throws IOException {
        T t3 = t2;
        long j3 = j2;
        Unsafe unsafe = z;
        int i5 = i4;
        Object u2 = u(i4);
        Object object = unsafe.getObject(t2, j3);
        if (this.q.g(object)) {
            Object e2 = this.q.e(u2);
            this.q.a(e2, object);
            unsafe.putObject(t2, j3, e2);
            object = e2;
        }
        return m(bArr, i2, i3, this.q.c(u2), this.q.d(object), registers);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0067, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int d0(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = z
            int[] r7 = r0.f7203a
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0161;
                case 52: goto L_0x0156;
                case 53: goto L_0x014c;
                case 54: goto L_0x014c;
                case 55: goto L_0x0142;
                case 56: goto L_0x0130;
                case 57: goto L_0x011f;
                case 58: goto L_0x0108;
                case 59: goto L_0x00da;
                case 60: goto L_0x00b8;
                case 61: goto L_0x00af;
                case 62: goto L_0x0142;
                case 63: goto L_0x0080;
                case 64: goto L_0x011f;
                case 65: goto L_0x0130;
                case 66: goto L_0x006f;
                case 67: goto L_0x005b;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x016d
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x016d
            r2 = r2 & -8
            r7 = r2 | 4
            androidx.datastore.preferences.protobuf.Schema r2 = r0.v(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.n(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.f6978c
            if (r15 != 0) goto L_0x0051
        L_0x0050:
            goto L_0x006b
        L_0x0051:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.Internal.v(r15, r3)
            goto L_0x0050
        L_0x0056:
            r12.putInt(r1, r13, r8)
            goto L_0x016e
        L_0x005b:
            if (r5 != 0) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r3, r4, r11)
            long r3 = r11.f6977b
            long r3 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r3)
        L_0x0067:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x006b:
            r12.putObject(r1, r9, r3)
            goto L_0x0056
        L_0x006f:
            if (r5 != 0) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r3, r4, r11)
            int r3 = r11.f6976a
            int r3 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r3)
        L_0x007b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x006b
        L_0x0080:
            if (r5 != 0) goto L_0x016d
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r3, r4, r11)
            int r4 = r11.f6976a
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r0.t(r6)
            if (r5 == 0) goto L_0x00a2
            boolean r5 = r5.a(r4)
            if (r5 == 0) goto L_0x0095
            goto L_0x00a2
        L_0x0095:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = w(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.r(r2, r4)
            goto L_0x00ac
        L_0x00a2:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
        L_0x00ac:
            r2 = r3
            goto L_0x016e
        L_0x00af:
            if (r5 != r15) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r3, r4, r11)
            java.lang.Object r3 = r11.f6978c
            goto L_0x006b
        L_0x00b8:
            if (r5 != r15) goto L_0x016d
            androidx.datastore.preferences.protobuf.Schema r2 = r0.v(r6)
            r5 = r20
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00cf
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00d0
        L_0x00cf:
            r15 = 0
        L_0x00d0:
            java.lang.Object r3 = r11.f6978c
            if (r15 != 0) goto L_0x00d5
        L_0x00d4:
            goto L_0x006b
        L_0x00d5:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.Internal.v(r15, r3)
            goto L_0x00d4
        L_0x00da:
            if (r5 != r15) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r3, r4, r11)
            int r4 = r11.f6976a
            if (r4 != 0) goto L_0x00e7
            java.lang.String r3 = ""
            goto L_0x006b
        L_0x00e7:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00fb
            int r5 = r2 + r4
            boolean r5 = androidx.datastore.preferences.protobuf.Utf8.u(r3, r2, r5)
            if (r5 == 0) goto L_0x00f6
            goto L_0x00fb
        L_0x00f6:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.d()
            throw r1
        L_0x00fb:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = androidx.datastore.preferences.protobuf.Internal.f7166a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x0056
        L_0x0108:
            if (r5 != 0) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r3, r4, r11)
            long r3 = r11.f6977b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0118
            r15 = 1
            goto L_0x0119
        L_0x0118:
            r15 = 0
        L_0x0119:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x006b
        L_0x011f:
            if (r5 != r7) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0129:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0056
        L_0x0130:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            long r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L_0x013b:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
            goto L_0x0056
        L_0x0142:
            if (r5 != 0) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r3, r4, r11)
            int r3 = r11.f6976a
            goto L_0x007b
        L_0x014c:
            if (r5 != 0) goto L_0x016d
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r3, r4, r11)
            long r3 = r11.f6977b
            goto L_0x0067
        L_0x0156:
            if (r5 != r7) goto L_0x016d
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x0129
        L_0x0161:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            double r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x013b
        L_0x016d:
            r2 = r4
        L_0x016e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.d0(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        r0.putLong(r1, r2, r4);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0084, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r9.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        if (r6 == 0) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
        r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11);
        r1 = r11.f6976a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        r1 = r11.f6978c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        r9.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b9, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011c, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0122, code lost:
        if (r6 == 0) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c0, code lost:
        if (r0 != r15) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0200, code lost:
        if (r0 != r15) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x021d, code lost:
        if (r0 != r15) goto L_0x01c2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int f0(T r28, byte[] r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            sun.misc.Unsafe r9 = z
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0013:
            if (r0 >= r13) goto L_0x0231
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0025
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r11)
            int r3 = r11.f6976a
            r8 = r0
            r17 = r3
            goto L_0x0028
        L_0x0025:
            r17 = r0
            r8 = r3
        L_0x0028:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0036
            int r2 = r2 / 3
            int r0 = r15.i0(r7, r2)
        L_0x0034:
            r4 = r0
            goto L_0x003b
        L_0x0036:
            int r0 = r15.h0(r7)
            goto L_0x0034
        L_0x003b:
            if (r4 != r10) goto L_0x0048
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r25 = -1
            goto L_0x0220
        L_0x0048:
            int[] r0 = r15.f7203a
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = t0(r5)
            long r1 = W(r5)
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0150
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0144;
                case 1: goto L_0x0134;
                case 2: goto L_0x0125;
                case 3: goto L_0x0125;
                case 4: goto L_0x0120;
                case 5: goto L_0x010d;
                case 6: goto L_0x00ff;
                case 7: goto L_0x00e9;
                case 8: goto L_0x00d7;
                case 9: goto L_0x00bc;
                case 10: goto L_0x00ad;
                case 11: goto L_0x0120;
                case 12: goto L_0x00a2;
                case 13: goto L_0x00ff;
                case 14: goto L_0x010d;
                case 15: goto L_0x0088;
                case 16: goto L_0x006a;
                default: goto L_0x005f;
            }
        L_0x005f:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x0066:
            r25 = -1
            goto L_0x0203
        L_0x006a:
            if (r6 != 0) goto L_0x005f
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            r19 = r1
            long r0 = r11.f6977b
            long r21 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
        L_0x0080:
            r0.putLong(r1, r2, r4)
            r0 = r6
        L_0x0084:
            r1 = r7
            r2 = r10
        L_0x0086:
            r10 = -1
            goto L_0x0013
        L_0x0088:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009a
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.f6976a
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r1)
        L_0x0096:
            r9.putInt(r14, r2, r1)
            goto L_0x0084
        L_0x009a:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x0066
        L_0x00a2:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009a
        L_0x00a6:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.f6976a
            goto L_0x0096
        L_0x00ad:
            r2 = r1
            if (r6 != r10) goto L_0x005f
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r8, r11)
        L_0x00b4:
            java.lang.Object r1 = r11.f6978c
        L_0x00b6:
            r9.putObject(r14, r2, r1)
        L_0x00b9:
            r2 = r4
            r1 = r7
            goto L_0x0086
        L_0x00bc:
            r2 = r1
            if (r6 != r10) goto L_0x005f
            androidx.datastore.preferences.protobuf.Schema r0 = r15.v(r4)
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00d0
            java.lang.Object r1 = r11.f6978c
            goto L_0x00b6
        L_0x00d0:
            java.lang.Object r5 = r11.f6978c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.v(r1, r5)
            goto L_0x00b6
        L_0x00d7:
            r2 = r1
            if (r6 != r10) goto L_0x005f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00e4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r8, r11)
            goto L_0x00b4
        L_0x00e4:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r8, r11)
            goto L_0x00b4
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x005f
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r5 = r11.f6977b
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            r0 = 0
        L_0x00fa:
            androidx.datastore.preferences.protobuf.UnsafeUtil.X(r14, r2, r0)
            r0 = r1
            goto L_0x00b9
        L_0x00ff:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x005f
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x00b9
        L_0x010d:
            r2 = r1
            if (r6 != r0) goto L_0x005f
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
        L_0x011c:
            int r0 = r8 + 8
            goto L_0x0084
        L_0x0120:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009a
            goto L_0x00a6
        L_0x0125:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x009a
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r4 = r11.f6977b
            r0 = r9
            r1 = r28
            goto L_0x0080
        L_0x0134:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x009a
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.i0(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x0084
        L_0x0144:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x009a
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.g0(r14, r2, r0)
            goto L_0x011c
        L_0x0150:
            r0 = 27
            if (r3 != r0) goto L_0x018d
            if (r6 != r10) goto L_0x005f
            java.lang.Object r0 = r9.getObject(r14, r1)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r3 = r0.P2()
            if (r3 != 0) goto L_0x0174
            int r3 = r0.size()
            if (r3 != 0) goto L_0x016b
            r3 = 10
            goto L_0x016d
        L_0x016b:
            int r3 = r3 * 2
        L_0x016d:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.f(r3)
            r9.putObject(r14, r1, r0)
        L_0x0174:
            r5 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.v(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0086
        L_0x018d:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01d6
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r26 = r10
            r25 = -1
            r9 = r22
            r11 = r26
            r12 = r20
            r14 = r32
            int r0 = r0.g0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x01d4
        L_0x01c2:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            goto L_0x0086
        L_0x01d4:
            r2 = r0
            goto L_0x0220
        L_0x01d6:
            r20 = r1
            r26 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r25 = -1
            r0 = 50
            r9 = r26
            r7 = r30
            if (r9 != r0) goto L_0x0205
            if (r7 != r10) goto L_0x0203
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.c0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x01d4
            goto L_0x01c2
        L_0x0203:
            r2 = r15
            goto L_0x0220
        L_0x0205:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.d0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x01d4
            goto L_0x01c2
        L_0x0220:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = w(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
            goto L_0x01c2
        L_0x0231:
            r1 = r13
            if (r0 != r1) goto L_0x0235
            return r0
        L_0x0235:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.f0(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private int g0(T t2, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, ArrayDecoders.Registers registers) throws IOException {
        int i9;
        T t3 = t2;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i6;
        int i12 = i7;
        long j4 = j3;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = z;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t2, j4);
        if (!protobufList.P2()) {
            int size = protobufList.size();
            protobufList = protobufList.f(size == 0 ? 10 : size * 2);
            unsafe.putObject(t2, j4, protobufList);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i11 == 2) {
                    return ArrayDecoders.s(bArr, i10, protobufList, registers2);
                }
                if (i11 == 1) {
                    return ArrayDecoders.e(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i11 == 2) {
                    return ArrayDecoders.v(bArr, i10, protobufList, registers2);
                }
                if (i11 == 5) {
                    return ArrayDecoders.m(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i11 == 2) {
                    return ArrayDecoders.z(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.M(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i11 == 2) {
                    return ArrayDecoders.y(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.J(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i11 == 2) {
                    return ArrayDecoders.u(bArr, i10, protobufList, registers2);
                }
                if (i11 == 1) {
                    return ArrayDecoders.k(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i11 == 2) {
                    return ArrayDecoders.t(bArr, i10, protobufList, registers2);
                }
                if (i11 == 5) {
                    return ArrayDecoders.i(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i11 == 2) {
                    return ArrayDecoders.r(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.a(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 26:
                if (i11 == 2) {
                    int i13 = ((j2 & 536870912) > 0 ? 1 : ((j2 & 536870912) == 0 ? 0 : -1));
                    byte[] bArr3 = bArr;
                    int i14 = i2;
                    int i15 = i3;
                    Internal.ProtobufList protobufList2 = protobufList;
                    ArrayDecoders.Registers registers3 = registers;
                    return i13 == 0 ? ArrayDecoders.D(i4, bArr3, i14, i15, protobufList2, registers3) : ArrayDecoders.E(i4, bArr3, i14, i15, protobufList2, registers3);
                }
                break;
            case 27:
                if (i11 == 2) {
                    return ArrayDecoders.q(v(i12), i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 28:
                if (i11 == 2) {
                    return ArrayDecoders.c(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i11 == 2) {
                    i9 = ArrayDecoders.y(bArr, i10, protobufList, registers2);
                } else if (i11 == 0) {
                    i9 = ArrayDecoders.J(i4, bArr, i2, i3, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t3;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.e()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.C(i5, protobufList, t(i12), unknownFieldSetLite, this.o);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i9;
            case 33:
            case 47:
                if (i11 == 2) {
                    return ArrayDecoders.w(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.A(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i11 == 2) {
                    return ArrayDecoders.x(bArr, i10, protobufList, registers2);
                }
                if (i11 == 0) {
                    return ArrayDecoders.B(i4, bArr, i2, i3, protobufList, registers);
                }
                break;
            case 49:
                if (i11 == 3) {
                    return ArrayDecoders.o(v(i12), i4, bArr, i2, i3, protobufList, registers);
                }
                break;
        }
        return i10;
    }

    private int h0(int i2) {
        if (i2 < this.f7205c || i2 > this.f7206d) {
            return -1;
        }
        return r0(i2, 0);
    }

    private int i0(int i2, int i3) {
        if (i2 < this.f7205c || i2 > this.f7206d) {
            return -1;
        }
        return r0(i2, i3);
    }

    private int j0(int i2) {
        return this.f7203a[i2 + 2];
    }

    private boolean k(T t2, T t3, int i2) {
        return D(t2, i2) == D(t3, i2);
    }

    private <E> void k0(Object obj, long j2, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.I(this.f7216n.e(obj, j2), schema, extensionRegistryLite);
    }

    private static <T> boolean l(T t2, long j2) {
        return UnsafeUtil.u(t2, j2);
    }

    private <E> void l0(Object obj, int i2, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.O(this.f7216n.e(obj, W(i2)), schema, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [int, byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int m(byte[] r15, int r16, int r17, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r18, java.util.Map<K, V> r19, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r20) throws java.io.IOException {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r15, r0, r10)
            int r1 = r10.f6976a
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            K r1 = r9.f7194b
            V r2 = r9.f7196d
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r15, r1, r10)
            int r1 = r10.f6976a
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.f7195c
            int r1 = r1.b()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7195c
            V r0 = r9.f7196d
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.f6978c
            goto L_0x001d
        L_0x0057:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.f7193a
            int r1 = r1.b()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f7193a
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.f6978c
            goto L_0x001d
        L_0x006f:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
            throw r0
        L_0x0081:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.m(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private void m0(Object obj, int i2, Reader reader) throws IOException {
        long W;
        Object F;
        if (C(i2)) {
            W = W(i2);
            F = reader.Q();
        } else if (this.f7209g) {
            W = W(i2);
            F = reader.B();
        } else {
            W = W(i2);
            F = reader.F();
        }
        UnsafeUtil.q0(obj, W, F);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        r7.f6978c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
        r7.f6978c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r7.f6978c = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int n(byte[] r2, int r3, int r4, androidx.datastore.preferences.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r7) throws java.io.IOException {
        /*
            r1 = this;
            int[] r0 = androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.f7217a
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0081;
                case 3: goto L_0x0078;
                case 4: goto L_0x006f;
                case 5: goto L_0x006f;
                case 6: goto L_0x0062;
                case 7: goto L_0x0062;
                case 8: goto L_0x0055;
                case 9: goto L_0x004e;
                case 10: goto L_0x004e;
                case 11: goto L_0x004e;
                case 12: goto L_0x0047;
                case 13: goto L_0x0047;
                case 14: goto L_0x003a;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "unsupported field type."
            r2.<init>(r3)
            throw r2
        L_0x0013:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r2, r3, r7)
            goto L_0x009a
        L_0x0019:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
            long r3 = r7.f6977b
            long r3 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r3)
        L_0x0023:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0027:
            r7.f6978c = r3
            goto L_0x009a
        L_0x002b:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r2, r3, r7)
            int r3 = r7.f6976a
            int r3 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r3)
        L_0x0035:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0027
        L_0x003a:
            androidx.datastore.preferences.protobuf.Protobuf r5 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.Schema r5 = r5.i(r6)
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r5, r2, r3, r4, r7)
            goto L_0x009a
        L_0x0047:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
            long r3 = r7.f6977b
            goto L_0x0023
        L_0x004e:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r2, r3, r7)
            int r3 = r7.f6976a
            goto L_0x0035
        L_0x0055:
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x005d:
            r7.f6978c = r2
            int r2 = r3 + 4
            goto L_0x009a
        L_0x0062:
            long r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
        L_0x006a:
            r7.f6978c = r2
            int r2 = r3 + 8
            goto L_0x009a
        L_0x006f:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x005d
        L_0x0078:
            double r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            goto L_0x006a
        L_0x0081:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r2, r3, r7)
            goto L_0x009a
        L_0x0086:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
            long r3 = r7.f6977b
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            r3 = 1
            goto L_0x0095
        L_0x0094:
            r3 = 0
        L_0x0095:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0027
        L_0x009a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.n(byte[], int, int, androidx.datastore.preferences.protobuf.WireFormat$FieldType, java.lang.Class, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private void n0(Object obj, int i2, Reader reader) throws IOException {
        if (C(i2)) {
            reader.E(this.f7216n.e(obj, W(i2)));
        } else {
            reader.D(this.f7216n.e(obj, W(i2)));
        }
    }

    private static <T> double o(T t2, long j2) {
        return UnsafeUtil.D(t2, j2);
    }

    private static Field o0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private boolean p(T t2, T t3, int i2) {
        int u0 = u0(i2);
        long W = W(u0);
        switch (t0(u0)) {
            case 0:
                return k(t2, t3, i2) && Double.doubleToLongBits(UnsafeUtil.D(t2, W)) == Double.doubleToLongBits(UnsafeUtil.D(t3, W));
            case 1:
                return k(t2, t3, i2) && Float.floatToIntBits(UnsafeUtil.F(t2, W)) == Float.floatToIntBits(UnsafeUtil.F(t3, W));
            case 2:
                return k(t2, t3, i2) && UnsafeUtil.L(t2, W) == UnsafeUtil.L(t3, W);
            case 3:
                return k(t2, t3, i2) && UnsafeUtil.L(t2, W) == UnsafeUtil.L(t3, W);
            case 4:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 5:
                return k(t2, t3, i2) && UnsafeUtil.L(t2, W) == UnsafeUtil.L(t3, W);
            case 6:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 7:
                return k(t2, t3, i2) && UnsafeUtil.u(t2, W) == UnsafeUtil.u(t3, W);
            case 8:
                return k(t2, t3, i2) && SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            case 9:
                return k(t2, t3, i2) && SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            case 10:
                return k(t2, t3, i2) && SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            case 11:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 12:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 13:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 14:
                return k(t2, t3, i2) && UnsafeUtil.L(t2, W) == UnsafeUtil.L(t3, W);
            case 15:
                return k(t2, t3, i2) && UnsafeUtil.I(t2, W) == UnsafeUtil.I(t3, W);
            case 16:
                return k(t2, t3, i2) && UnsafeUtil.L(t2, W) == UnsafeUtil.L(t3, W);
            case 17:
                return k(t2, t3, i2) && SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                return SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return I(t2, t3, i2) && SchemaUtil.N(UnsafeUtil.O(t2, W), UnsafeUtil.O(t3, W));
            default:
                return true;
        }
    }

    private void p0(T t2, int i2) {
        if (!this.f7210h) {
            int j0 = j0(i2);
            long j2 = (long) (j0 & t);
            UnsafeUtil.l0(t2, j2, UnsafeUtil.I(t2, j2) | (1 << (j0 >>> 20)));
        }
    }

    private final <UT, UB> UB q(Object obj, int i2, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier t2;
        int V = V(i2);
        Object O = UnsafeUtil.O(obj, W(u0(i2)));
        if (O == null || (t2 = t(i2)) == null) {
            return ub;
        }
        return r(i2, V, this.q.d(O), t2, ub, unknownFieldSchema);
    }

    private void q0(T t2, int i2, int i3) {
        UnsafeUtil.l0(t2, (long) (j0(i3) & t), i2);
    }

    private final <K, V, UT, UB> UB r(int i2, int i3, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> c2 = this.q.c(u(i2));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (!enumVerifier.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.n();
                }
                ByteString.CodedBuilder P = ByteString.P(MapEntryLite.b(c2, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.l(P.b(), c2, next.getKey(), next.getValue());
                    unknownFieldSchema.d(ub, i3, P.a());
                    it2.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private int r0(int i2, int i3) {
        int length = (this.f7203a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int V = V(i5);
            if (i2 == V) {
                return i5;
            }
            if (i2 < V) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static <T> float s(T t2, long j2) {
        return UnsafeUtil.F(t2, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void s0(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, boolean r11, java.lang.Object[] r12) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.u()
            r1 = 0
            if (r0 == 0) goto L_0x0026
            androidx.datastore.preferences.protobuf.FieldType r11 = r8.y()
            int r11 = r11.f()
            int r11 = r11 + 51
            java.lang.reflect.Field r2 = r0.c()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.W(r2)
            int r3 = (int) r2
            java.lang.reflect.Field r0 = r0.a()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.W(r0)
            int r0 = (int) r4
        L_0x0023:
            r2 = r0
            r0 = 0
            goto L_0x0070
        L_0x0026:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.y()
            java.lang.reflect.Field r2 = r8.o()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.W(r2)
            int r3 = (int) r2
            int r2 = r0.f()
            if (r11 != 0) goto L_0x005b
            boolean r11 = r0.g()
            if (r11 != 0) goto L_0x005b
            boolean r11 = r0.h()
            if (r11 != 0) goto L_0x005b
            java.lang.reflect.Field r11 = r8.w()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.W(r11)
            int r0 = (int) r4
            int r11 = r8.x()
            int r11 = java.lang.Integer.numberOfTrailingZeros(r11)
            r7 = r0
            r0 = r11
            r11 = r2
            r2 = r7
            goto L_0x0070
        L_0x005b:
            java.lang.reflect.Field r11 = r8.m()
            if (r11 != 0) goto L_0x0065
            r11 = r2
            r0 = 0
            r2 = 0
            goto L_0x0070
        L_0x0065:
            java.lang.reflect.Field r11 = r8.m()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.W(r11)
            int r0 = (int) r4
            r11 = r2
            goto L_0x0023
        L_0x0070:
            int r4 = r8.p()
            r9[r10] = r4
            int r4 = r10 + 1
            boolean r5 = r8.z()
            if (r5 == 0) goto L_0x0081
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0082
        L_0x0081:
            r5 = 0
        L_0x0082:
            boolean r6 = r8.C()
            if (r6 == 0) goto L_0x008a
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x008a:
            r1 = r1 | r5
            int r11 = r11 << 20
            r11 = r11 | r1
            r11 = r11 | r3
            r9[r4] = r11
            int r11 = r10 + 2
            int r0 = r0 << 20
            r0 = r0 | r2
            r9[r11] = r0
            java.lang.Class r9 = r8.s()
            java.lang.Object r11 = r8.r()
            if (r11 == 0) goto L_0x00c2
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r11 = r8.r()
            r12[r10] = r11
            if (r9 == 0) goto L_0x00b3
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00df
        L_0x00b3:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.n()
            if (r9 == 0) goto L_0x00df
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.n()
            r12[r10] = r8
            goto L_0x00df
        L_0x00c2:
            if (r9 == 0) goto L_0x00cd
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00df
        L_0x00cd:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.n()
            if (r9 == 0) goto L_0x00df
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.n()
            r12[r10] = r8
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.s0(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    private Internal.EnumVerifier t(int i2) {
        return (Internal.EnumVerifier) this.f7204b[((i2 / 3) * 2) + 1];
    }

    private static int t0(int i2) {
        return (i2 & u) >>> 20;
    }

    private Object u(int i2) {
        return this.f7204b[(i2 / 3) * 2];
    }

    private int u0(int i2) {
        return this.f7203a[i2 + 1];
    }

    private Schema v(int i2) {
        int i3 = (i2 / 3) * 2;
        Schema schema = (Schema) this.f7204b[i3];
        if (schema != null) {
            return schema;
        }
        Schema i4 = Protobuf.a().i((Class) this.f7204b[i3 + 1]);
        this.f7204b[i3] = i4;
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v0(T r18, androidx.datastore.preferences.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f7208f
            if (r3 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r0.p
            androidx.datastore.preferences.protobuf.FieldSet r3 = r3.c(r1)
            boolean r5 = r3.C()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.H()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.f7203a
            int r6 = r6.length
            sun.misc.Unsafe r7 = z
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r6) goto L_0x049a
            int r12 = r0.u0(r10)
            int r13 = r0.V(r10)
            int r14 = t0(r12)
            boolean r15 = r0.f7210h
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.f7203a
            int r16 = r10 + 2
            r15 = r15[r16]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r15 & r16
            r16 = r5
            if (r8 == r9) goto L_0x0056
            long r4 = (long) r8
            int r11 = r7.getInt(r1, r4)
            r9 = r8
        L_0x0056:
            int r4 = r15 >>> 20
            r5 = 1
            int r4 = r5 << r4
            r5 = r16
            goto L_0x0063
        L_0x005e:
            r16 = r5
            r5 = r16
            r4 = 0
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r0.p
            int r8 = r8.a(r5)
            if (r8 > r13) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r0.p
            r8.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007f
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0063
        L_0x007f:
            r5 = 0
            goto L_0x0063
        L_0x0081:
            r15 = r5
            r8 = r6
            long r5 = W(r12)
            switch(r14) {
                case 0: goto L_0x0489;
                case 1: goto L_0x047d;
                case 2: goto L_0x0471;
                case 3: goto L_0x0465;
                case 4: goto L_0x0459;
                case 5: goto L_0x044d;
                case 6: goto L_0x0441;
                case 7: goto L_0x0435;
                case 8: goto L_0x0429;
                case 9: goto L_0x0418;
                case 10: goto L_0x0409;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ef;
                case 13: goto L_0x03e2;
                case 14: goto L_0x03d5;
                case 15: goto L_0x03c8;
                case 16: goto L_0x03bb;
                case 17: goto L_0x03aa;
                case 18: goto L_0x039a;
                case 19: goto L_0x038a;
                case 20: goto L_0x037a;
                case 21: goto L_0x036a;
                case 22: goto L_0x035a;
                case 23: goto L_0x034a;
                case 24: goto L_0x033a;
                case 25: goto L_0x032a;
                case 26: goto L_0x031b;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f9;
                case 29: goto L_0x02e9;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a9;
                case 34: goto L_0x0299;
                case 35: goto L_0x0289;
                case 36: goto L_0x0279;
                case 37: goto L_0x0269;
                case 38: goto L_0x0259;
                case 39: goto L_0x0249;
                case 40: goto L_0x0239;
                case 41: goto L_0x0229;
                case 42: goto L_0x0219;
                case 43: goto L_0x0209;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01e9;
                case 46: goto L_0x01d9;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01b9;
                case 49: goto L_0x01a6;
                case 50: goto L_0x019d;
                case 51: goto L_0x018e;
                case 52: goto L_0x017f;
                case 53: goto L_0x0170;
                case 54: goto L_0x0161;
                case 55: goto L_0x0152;
                case 56: goto L_0x0143;
                case 57: goto L_0x0134;
                case 58: goto L_0x0125;
                case 59: goto L_0x0116;
                case 60: goto L_0x0103;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00d7;
                case 64: goto L_0x00c9;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00ad;
                case 67: goto L_0x009f;
                case 68: goto L_0x008d;
                default: goto L_0x008a;
            }
        L_0x008a:
            r12 = 0
            goto L_0x0494
        L_0x008d:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.v(r10)
            r2.S(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = b0(r1, r5)
            r2.H(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.Q(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = b0(r1, r5)
            r2.A(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.u(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.L(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.b(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.z(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.v(r10)
            r2.C(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.z0(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = X(r1, r5)
            r2.t(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.d(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = b0(r1, r5)
            r2.i(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = a0(r1, r5)
            r2.w(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = b0(r1, r5)
            r2.p(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = b0(r1, r5)
            r2.s(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = Z(r1, r5)
            r2.I(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.J(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = Y(r1, r5)
            r2.e(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.y0(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.v(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.i0(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.v(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.q0(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.B0(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.V(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.v(r10)
            r2.S(r13, r4, r5)
            goto L_0x0494
        L_0x03bb:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.H(r13, r4)
            goto L_0x0494
        L_0x03c8:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.Q(r13, r4)
            goto L_0x0494
        L_0x03d5:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.A(r13, r4)
            goto L_0x0494
        L_0x03e2:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.u(r13, r4)
            goto L_0x0494
        L_0x03ef:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.L(r13, r4)
            goto L_0x0494
        L_0x03fc:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.b(r13, r4)
            goto L_0x0494
        L_0x0409:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.z(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.v(r10)
            r2.C(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.z0(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = l(r1, r5)
            r2.t(r13, r4)
            goto L_0x0494
        L_0x0441:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.d(r13, r4)
            goto L_0x0494
        L_0x044d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.i(r13, r4)
            goto L_0x0494
        L_0x0459:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.w(r13, r4)
            goto L_0x0494
        L_0x0465:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.p(r13, r4)
            goto L_0x0494
        L_0x0471:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.s(r13, r4)
            goto L_0x0494
        L_0x047d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            float r4 = s(r1, r5)
            r2.I(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = o(r1, r5)
            r2.e(r13, r4)
        L_0x0494:
            int r10 = r10 + 3
            r6 = r8
            r5 = r15
            goto L_0x002b
        L_0x049a:
            r16 = r5
        L_0x049c:
            if (r5 == 0) goto L_0x04b3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r4 = r0.p
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x049c
        L_0x04b1:
            r5 = 0
            goto L_0x049c
        L_0x04b3:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r3 = r0.o
            r0.A0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.v0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    static UnknownFieldSetLite w(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.e()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite p2 = UnknownFieldSetLite.p();
        generatedMessageLite.unknownFields = p2;
        return p2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r14.S(r7, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, W(r6)), v(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r14.H(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        r14.Q(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r14.A(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r14.u(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r14.L(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d9, code lost:
        r14.b(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e4, code lost:
        r14.z(r7, (androidx.datastore.preferences.protobuf.ByteString) androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, W(r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r14.C(r7, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, W(r6)), v(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0110, code lost:
        z0(r7, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, W(r6)), r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012b, code lost:
        r14.t(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013e, code lost:
        r14.d(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0151, code lost:
        r14.i(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0164, code lost:
        r14.w(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0177, code lost:
        r14.p(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018a, code lost:
        r14.s(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019d, code lost:
        r14.I(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b0, code lost:
        r14.e(r7, r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w0(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.f7208f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r12.p
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r13)
            boolean r2 = r0.C()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.H()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f7203a
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0023:
            if (r5 >= r3) goto L_0x052e
            int r6 = r12.u0(r5)
            int r7 = r12.V(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.p
            r8.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = t0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x051a;
                case 1: goto L_0x050a;
                case 2: goto L_0x04fa;
                case 3: goto L_0x04ea;
                case 4: goto L_0x04da;
                case 5: goto L_0x04ca;
                case 6: goto L_0x04ba;
                case 7: goto L_0x04aa;
                case 8: goto L_0x04a2;
                case 9: goto L_0x049a;
                case 10: goto L_0x0492;
                case 11: goto L_0x0482;
                case 12: goto L_0x0472;
                case 13: goto L_0x0462;
                case 14: goto L_0x0452;
                case 15: goto L_0x0442;
                case 16: goto L_0x0432;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x052a
        L_0x0055:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
        L_0x005b:
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.v(r5)
            r14.S(r7, r6, r8)
            goto L_0x052a
        L_0x006c:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = b0(r13, r8)
        L_0x007a:
            r14.H(r7, r8)
            goto L_0x052a
        L_0x007f:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x008d:
            r14.Q(r7, r6)
            goto L_0x052a
        L_0x0092:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = b0(r13, r8)
        L_0x00a0:
            r14.A(r7, r8)
            goto L_0x052a
        L_0x00a5:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x00b3:
            r14.u(r7, r6)
            goto L_0x052a
        L_0x00b8:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x00c6:
            r14.L(r7, r6)
            goto L_0x052a
        L_0x00cb:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x00d9:
            r14.b(r7, r6)
            goto L_0x052a
        L_0x00de:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
        L_0x00e4:
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.z(r7, r6)
            goto L_0x052a
        L_0x00f3:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
        L_0x00f9:
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.v(r5)
            r14.C(r7, r6, r8)
            goto L_0x052a
        L_0x010a:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
        L_0x0110:
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            r12.z0(r7, r6, r14)
            goto L_0x052a
        L_0x011d:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            boolean r6 = X(r13, r8)
        L_0x012b:
            r14.t(r7, r6)
            goto L_0x052a
        L_0x0130:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x013e:
            r14.d(r7, r6)
            goto L_0x052a
        L_0x0143:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = b0(r13, r8)
        L_0x0151:
            r14.i(r7, r8)
            goto L_0x052a
        L_0x0156:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = a0(r13, r8)
        L_0x0164:
            r14.w(r7, r6)
            goto L_0x052a
        L_0x0169:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = b0(r13, r8)
        L_0x0177:
            r14.p(r7, r8)
            goto L_0x052a
        L_0x017c:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = b0(r13, r8)
        L_0x018a:
            r14.s(r7, r8)
            goto L_0x052a
        L_0x018f:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            float r6 = Z(r13, r8)
        L_0x019d:
            r14.I(r7, r6)
            goto L_0x052a
        L_0x01a2:
            boolean r8 = r12.J(r13, r7, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            double r8 = Y(r13, r8)
        L_0x01b0:
            r14.e(r7, r8)
            goto L_0x052a
        L_0x01b5:
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            r12.y0(r14, r7, r6, r5)
            goto L_0x052a
        L_0x01c2:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.v(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.i0(r7, r6, r14, r8)
            goto L_0x052a
        L_0x01d9:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x01ec:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x01ff:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0212:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0225:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0238:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x024b:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r7, r6, r14, r9)
            goto L_0x052a
        L_0x025e:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0271:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0284:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x0297:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x02aa:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x02bd:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r7, r6, r14, r9)
            goto L_0x052a
        L_0x02d0:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r7, r6, r14, r9)
            goto L_0x052a
        L_0x02e3:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x02f6:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x0309:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x031c:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x032f:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x0342:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x0355:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r7, r6, r14)
            goto L_0x052a
        L_0x0368:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.v(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.q0(r7, r6, r14, r8)
            goto L_0x052a
        L_0x037f:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.B0(r7, r6, r14)
            goto L_0x052a
        L_0x0392:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r7, r6, r14, r4)
            goto L_0x052a
        L_0x03a5:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x03b8:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x03cb:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x03de:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x03f1:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x0404:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r7, r6, r14, r4)
            goto L_0x052a
        L_0x0417:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r7, r6, r14, r4)
            goto L_0x052a
        L_0x042a:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            goto L_0x005b
        L_0x0432:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = M(r13, r8)
            goto L_0x007a
        L_0x0442:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x008d
        L_0x0452:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = M(r13, r8)
            goto L_0x00a0
        L_0x0462:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x00b3
        L_0x0472:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x00c6
        L_0x0482:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x00d9
        L_0x0492:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            goto L_0x00e4
        L_0x049a:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            goto L_0x00f9
        L_0x04a2:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            goto L_0x0110
        L_0x04aa:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            boolean r6 = l(r13, r8)
            goto L_0x012b
        L_0x04ba:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x013e
        L_0x04ca:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = M(r13, r8)
            goto L_0x0151
        L_0x04da:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            int r6 = B(r13, r8)
            goto L_0x0164
        L_0x04ea:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = M(r13, r8)
            goto L_0x0177
        L_0x04fa:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            long r8 = M(r13, r8)
            goto L_0x018a
        L_0x050a:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            float r6 = s(r13, r8)
            goto L_0x019d
        L_0x051a:
            boolean r8 = r12.D(r13, r5)
            if (r8 == 0) goto L_0x052a
            long r8 = W(r6)
            double r8 = o(r13, r8)
            goto L_0x01b0
        L_0x052a:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x052e:
            if (r2 == 0) goto L_0x0544
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r12.p
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0542
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x052e
        L_0x0542:
            r2 = r1
            goto L_0x052e
        L_0x0544:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r12.o
            r12.A0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.w0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        r12.S(r5, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, W(r4)), v(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r12.H(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        r12.Q(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r12.A(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b9, code lost:
        r12.u(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cc, code lost:
        r12.L(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00df, code lost:
        r12.b(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ea, code lost:
        r12.z(r5, (androidx.datastore.preferences.protobuf.ByteString) androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, W(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ff, code lost:
        r12.C(r5, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, W(r4)), v(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0116, code lost:
        z0(r5, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, W(r4)), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0131, code lost:
        r12.t(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0144, code lost:
        r12.d(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0157, code lost:
        r12.i(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        r12.w(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017d, code lost:
        r12.p(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0190, code lost:
        r12.s(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a3, code lost:
        r12.I(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b6, code lost:
        r12.e(r5, r6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x0(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r10.o
            r10.A0(r0, r11, r12)
            boolean r0 = r10.f7208f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r10.p
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r11)
            boolean r2 = r0.C()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.r()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f7203a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x0534
            int r4 = r10.u0(r3)
            int r5 = r10.V(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.p
            r6.j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = t0(r4)
            r7 = 0
            r8 = 1
            switch(r6) {
                case 0: goto L_0x0520;
                case 1: goto L_0x0510;
                case 2: goto L_0x0500;
                case 3: goto L_0x04f0;
                case 4: goto L_0x04e0;
                case 5: goto L_0x04d0;
                case 6: goto L_0x04c0;
                case 7: goto L_0x04b0;
                case 8: goto L_0x04a8;
                case 9: goto L_0x04a0;
                case 10: goto L_0x0498;
                case 11: goto L_0x0488;
                case 12: goto L_0x0478;
                case 13: goto L_0x0468;
                case 14: goto L_0x0458;
                case 15: goto L_0x0448;
                case 16: goto L_0x0438;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0530
        L_0x005b:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
        L_0x0061:
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.v(r3)
            r12.S(r5, r4, r6)
            goto L_0x0530
        L_0x0072:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = b0(r11, r6)
        L_0x0080:
            r12.H(r5, r6)
            goto L_0x0530
        L_0x0085:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x0093:
            r12.Q(r5, r4)
            goto L_0x0530
        L_0x0098:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = b0(r11, r6)
        L_0x00a6:
            r12.A(r5, r6)
            goto L_0x0530
        L_0x00ab:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x00b9:
            r12.u(r5, r4)
            goto L_0x0530
        L_0x00be:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x00cc:
            r12.L(r5, r4)
            goto L_0x0530
        L_0x00d1:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x00df:
            r12.b(r5, r4)
            goto L_0x0530
        L_0x00e4:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
        L_0x00ea:
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.z(r5, r4)
            goto L_0x0530
        L_0x00f9:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
        L_0x00ff:
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.v(r3)
            r12.C(r5, r4, r6)
            goto L_0x0530
        L_0x0110:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
        L_0x0116:
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            r10.z0(r5, r4, r12)
            goto L_0x0530
        L_0x0123:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            boolean r4 = X(r11, r6)
        L_0x0131:
            r12.t(r5, r4)
            goto L_0x0530
        L_0x0136:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x0144:
            r12.d(r5, r4)
            goto L_0x0530
        L_0x0149:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = b0(r11, r6)
        L_0x0157:
            r12.i(r5, r6)
            goto L_0x0530
        L_0x015c:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = a0(r11, r6)
        L_0x016a:
            r12.w(r5, r4)
            goto L_0x0530
        L_0x016f:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = b0(r11, r6)
        L_0x017d:
            r12.p(r5, r6)
            goto L_0x0530
        L_0x0182:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = b0(r11, r6)
        L_0x0190:
            r12.s(r5, r6)
            goto L_0x0530
        L_0x0195:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            float r4 = Z(r11, r6)
        L_0x01a3:
            r12.I(r5, r4)
            goto L_0x0530
        L_0x01a8:
            boolean r6 = r10.J(r11, r5, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            double r6 = Y(r11, r6)
        L_0x01b6:
            r12.e(r5, r6)
            goto L_0x0530
        L_0x01bb:
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            r10.y0(r12, r5, r4, r3)
            goto L_0x0530
        L_0x01c8:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.v(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.i0(r5, r4, r12, r6)
            goto L_0x0530
        L_0x01df:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x01f2:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x0205:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x0218:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x022b:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x023e:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x0251:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r5, r4, r12, r8)
            goto L_0x0530
        L_0x0264:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x0277:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x028a:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x029d:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x02b0:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x02c3:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r5, r4, r12, r8)
            goto L_0x0530
        L_0x02d6:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r5, r4, r12, r8)
            goto L_0x0530
        L_0x02e9:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.y0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x02fc:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.w0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x030f:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.u0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x0322:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.s0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x0335:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.a0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x0348:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.D0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x035b:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.W(r5, r4, r12)
            goto L_0x0530
        L_0x036e:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.v(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.q0(r5, r4, r12, r6)
            goto L_0x0530
        L_0x0385:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.B0(r5, r4, r12)
            goto L_0x0530
        L_0x0398:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.U(r5, r4, r12, r7)
            goto L_0x0530
        L_0x03ab:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.c0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x03be:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.e0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x03d1:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.k0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x03e4:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.F0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x03f7:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.m0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x040a:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.g0(r5, r4, r12, r7)
            goto L_0x0530
        L_0x041d:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.Y(r5, r4, r12, r7)
            goto L_0x0530
        L_0x0430:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            goto L_0x0061
        L_0x0438:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = M(r11, r6)
            goto L_0x0080
        L_0x0448:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x0093
        L_0x0458:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = M(r11, r6)
            goto L_0x00a6
        L_0x0468:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x00b9
        L_0x0478:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x00cc
        L_0x0488:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x00df
        L_0x0498:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            goto L_0x00ea
        L_0x04a0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            goto L_0x00ff
        L_0x04a8:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            goto L_0x0116
        L_0x04b0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            boolean r4 = l(r11, r6)
            goto L_0x0131
        L_0x04c0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x0144
        L_0x04d0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = M(r11, r6)
            goto L_0x0157
        L_0x04e0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            int r4 = B(r11, r6)
            goto L_0x016a
        L_0x04f0:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = M(r11, r6)
            goto L_0x017d
        L_0x0500:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            long r6 = M(r11, r6)
            goto L_0x0190
        L_0x0510:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            float r4 = s(r11, r6)
            goto L_0x01a3
        L_0x0520:
            boolean r6 = r10.D(r11, r3)
            if (r6 == 0) goto L_0x0530
            long r6 = W(r4)
            double r6 = o(r11, r6)
            goto L_0x01b6
        L_0x0530:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x0534:
            if (r2 == 0) goto L_0x054b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r11 = r10.p
            r11.j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x0549
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x0534
        L_0x0549:
            r2 = r1
            goto L_0x0534
        L_0x054b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.x0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f1, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0202, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0213, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0224, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0235, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0247, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0259, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026b, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x027d, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x028f, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02a1, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0351, code lost:
        if ((r7 & r14) != 0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x036b, code lost:
        if ((r7 & r14) != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0371, code lost:
        if ((r7 & r14) != 0) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x038b, code lost:
        if ((r7 & r14) != 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0391, code lost:
        if ((r7 & r14) != 0) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03b3, code lost:
        if ((r7 & r14) != 0) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x040c, code lost:
        r5 = r5 + 3;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (J(r1, r9, r5) != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.t0(r9, (androidx.datastore.preferences.protobuf.MessageLite) r2.getObject(r1, r12), v(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.T0(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.R0(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        if (J(r1, r9, r5) != false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.P0(r9, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        if (J(r1, r9, r5) != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.N0(r9, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.k0(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cb, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y0(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        if (J(r1, r9, r5) != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d6, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, (androidx.datastore.preferences.protobuf.ByteString) r2.getObject(r1, r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        if (J(r1, r9, r5) != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r3 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r9, r2.getObject(r1, r12), v(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0116, code lost:
        if (J(r1, r9, r5) != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0118, code lost:
        r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.a0(r9, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01af, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b1, code lost:
        r2.putInt(r1, (long) r11, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b5, code lost:
        r4 = (androidx.datastore.preferences.protobuf.CodedOutputStream.X0(r9) + androidx.datastore.preferences.protobuf.CodedOutputStream.Z0(r3)) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cf, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e0, code lost:
        if (r0.f7211i != false) goto L_0x01b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int y(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = z
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.f7203a
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0411
            int r8 = r0.u0(r5)
            int r9 = r0.V(r5)
            int r10 = t0(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.f7203a
            int r14 = r5 + 2
            r11 = r11[r14]
            r12 = r12 & r11
            int r14 = r11 >>> 20
            int r14 = r13 << r14
            r15 = r14
            if (r12 == r4) goto L_0x0037
            long r13 = (long) r12
            int r7 = r2.getInt(r1, r13)
            r4 = r12
        L_0x0037:
            r14 = r15
            goto L_0x0058
        L_0x0039:
            boolean r11 = r0.f7211i
            if (r11 == 0) goto L_0x0056
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.f()
            if (r10 < r11) goto L_0x0056
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.f()
            if (r10 > r11) goto L_0x0056
            int[] r11 = r0.f7203a
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
        L_0x0054:
            r14 = 0
            goto L_0x0058
        L_0x0056:
            r11 = 0
            goto L_0x0054
        L_0x0058:
            long r12 = W(r8)
            r15 = r4
            r8 = 0
            r3 = 0
            switch(r10) {
                case 0: goto L_0x0400;
                case 1: goto L_0x03f6;
                case 2: goto L_0x03e8;
                case 3: goto L_0x03da;
                case 4: goto L_0x03cc;
                case 5: goto L_0x03c2;
                case 6: goto L_0x03b7;
                case 7: goto L_0x03b1;
                case 8: goto L_0x0395;
                case 9: goto L_0x038f;
                case 10: goto L_0x0389;
                case 11: goto L_0x037f;
                case 12: goto L_0x0375;
                case 13: goto L_0x036f;
                case 14: goto L_0x0369;
                case 15: goto L_0x035f;
                case 16: goto L_0x0355;
                case 17: goto L_0x034f;
                case 18: goto L_0x02bf;
                case 19: goto L_0x02cc;
                case 20: goto L_0x0342;
                case 21: goto L_0x0335;
                case 22: goto L_0x0328;
                case 23: goto L_0x02bf;
                case 24: goto L_0x02cc;
                case 25: goto L_0x031b;
                case 26: goto L_0x030f;
                case 27: goto L_0x02ff;
                case 28: goto L_0x02f3;
                case 29: goto L_0x02e6;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02cc;
                case 32: goto L_0x02bf;
                case 33: goto L_0x02b2;
                case 34: goto L_0x02a5;
                case 35: goto L_0x0293;
                case 36: goto L_0x0281;
                case 37: goto L_0x026f;
                case 38: goto L_0x025d;
                case 39: goto L_0x024b;
                case 40: goto L_0x0239;
                case 41: goto L_0x0227;
                case 42: goto L_0x0216;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f4;
                case 45: goto L_0x01e3;
                case 46: goto L_0x01d2;
                case 47: goto L_0x01c1;
                case 48: goto L_0x01a1;
                case 49: goto L_0x0191;
                case 50: goto L_0x0181;
                case 51: goto L_0x0173;
                case 52: goto L_0x0167;
                case 53: goto L_0x0157;
                case 54: goto L_0x0147;
                case 55: goto L_0x0137;
                case 56: goto L_0x012b;
                case 57: goto L_0x011f;
                case 58: goto L_0x0112;
                case 59: goto L_0x00f4;
                case 60: goto L_0x00e1;
                case 61: goto L_0x00d0;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00b2;
                case 64: goto L_0x00a5;
                case 65: goto L_0x009a;
                case 66: goto L_0x008b;
                case 67: goto L_0x007c;
                case 68: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0079
        L_0x0064:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
        L_0x006a:
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.v(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.t0(r9, r3, r4)
        L_0x0078:
            int r6 = r6 + r3
        L_0x0079:
            r10 = 0
            goto L_0x040c
        L_0x007c:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = b0(r1, r12)
        L_0x0086:
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.T0(r9, r3)
            goto L_0x0078
        L_0x008b:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = a0(r1, r12)
        L_0x0095:
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.R0(r9, r3)
            goto L_0x0078
        L_0x009a:
            boolean r8 = r0.J(r1, r9, r5)
            if (r8 == 0) goto L_0x0079
        L_0x00a0:
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.P0(r9, r3)
            goto L_0x0078
        L_0x00a5:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
        L_0x00ab:
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.N0(r9, r3)
        L_0x00b0:
            int r6 = r6 + r4
            goto L_0x0079
        L_0x00b2:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = a0(r1, r12)
        L_0x00bc:
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.k0(r9, r3)
            goto L_0x0078
        L_0x00c1:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = a0(r1, r12)
        L_0x00cb:
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y0(r9, r3)
            goto L_0x0078
        L_0x00d0:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
        L_0x00d6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, r3)
            goto L_0x0078
        L_0x00e1:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
        L_0x00e7:
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.v(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r9, r3, r4)
            goto L_0x0078
        L_0x00f4:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x010a
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, r3)
            goto L_0x0078
        L_0x010a:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.V0(r9, r3)
            goto L_0x0078
        L_0x0112:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
        L_0x0118:
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.a0(r9, r3)
            goto L_0x0078
        L_0x011f:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.m0(r9, r3)
            goto L_0x00b0
        L_0x012b:
            boolean r8 = r0.J(r1, r9, r5)
            if (r8 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o0(r9, r3)
            goto L_0x0078
        L_0x0137:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = a0(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.w0(r9, r3)
            goto L_0x0078
        L_0x0147:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = b0(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.a1(r9, r3)
            goto L_0x0078
        L_0x0157:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = b0(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.y0(r9, r3)
            goto L_0x0078
        L_0x0167:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q0(r9, r8)
            goto L_0x0078
        L_0x0173:
            boolean r3 = r0.J(r1, r9, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.i0(r9, r3)
            goto L_0x0078
        L_0x0181:
            androidx.datastore.preferences.protobuf.MapFieldSchema r3 = r0.q
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.u(r5)
            int r3 = r3.f(r9, r4, r8)
            goto L_0x0078
        L_0x0191:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.v(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r9, r3, r4)
            goto L_0x0078
        L_0x01a1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
        L_0x01b1:
            long r11 = (long) r11
            r2.putInt(r1, r11, r3)
        L_0x01b5:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.X0(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z0(r3)
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x00b0
        L_0x01c1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x01d2:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x01e3:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x01f4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0205:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0216:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0227:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0239:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x024b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x025d:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x026f:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0281:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x0293:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.f7211i
            if (r4 == 0) goto L_0x01b5
            goto L_0x01b1
        L_0x02a5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r9, r3, r4)
            goto L_0x0078
        L_0x02b2:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r9, r3, r4)
            goto L_0x0078
        L_0x02bf:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x0078
        L_0x02cc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x0078
        L_0x02d9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r9, r3, r4)
            goto L_0x0078
        L_0x02e6:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r9, r3, r4)
            goto L_0x0078
        L_0x02f3:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r9, r3)
            goto L_0x0078
        L_0x02ff:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.v(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r9, r3, r4)
            goto L_0x0078
        L_0x030f:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r9, r3)
            goto L_0x0078
        L_0x031b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r9, r3, r4)
            goto L_0x0078
        L_0x0328:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r9, r3, r4)
            goto L_0x0078
        L_0x0335:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.z(r9, r3, r4)
            goto L_0x0078
        L_0x0342:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r9, r3, r4)
            goto L_0x0078
        L_0x034f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            goto L_0x006a
        L_0x0355:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            long r3 = r2.getLong(r1, r12)
            goto L_0x0086
        L_0x035f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            goto L_0x0095
        L_0x0369:
            r10 = r7 & r14
            if (r10 == 0) goto L_0x0079
            goto L_0x00a0
        L_0x036f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            goto L_0x00ab
        L_0x0375:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            goto L_0x00bc
        L_0x037f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r12)
            goto L_0x00cb
        L_0x0389:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            goto L_0x00d6
        L_0x038f:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            goto L_0x00e7
        L_0x0395:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x03a9
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r9, r3)
            goto L_0x0078
        L_0x03a9:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.V0(r9, r3)
            goto L_0x0078
        L_0x03b1:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            goto L_0x0118
        L_0x03b7:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0079
            r10 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.m0(r9, r10)
        L_0x03c0:
            int r6 = r6 + r3
            goto L_0x040c
        L_0x03c2:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x040c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o0(r9, r3)
            goto L_0x03c0
        L_0x03cc:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x040c
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.w0(r9, r3)
            goto L_0x03c0
        L_0x03da:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x040c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.a1(r9, r3)
            goto L_0x03c0
        L_0x03e8:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x040c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.y0(r9, r3)
            goto L_0x03c0
        L_0x03f6:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x040c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q0(r9, r8)
            goto L_0x03c0
        L_0x0400:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x040c
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.i0(r9, r3)
            goto L_0x03c0
        L_0x040c:
            int r5 = r5 + 3
            r4 = r15
            goto L_0x000a
        L_0x0411:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.o
            int r2 = r0.A(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f7208f
            if (r2 == 0) goto L_0x0427
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.p
            androidx.datastore.preferences.protobuf.FieldSet r1 = r2.c(r1)
            int r1 = r1.z()
            int r6 = r6 + r1
        L_0x0427:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.y(java.lang.Object):int");
    }

    private <K, V> void y0(Writer writer, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            writer.P(i2, this.q.c(u(i3)), this.q.h(obj));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e4, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f5, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0206, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0218, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022a, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x023c, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x024e, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0260, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0272, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.t0(r8, (androidx.datastore.preferences.protobuf.MessageLite) androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9), v(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0360, code lost:
        if ((r6 instanceof androidx.datastore.preferences.protobuf.ByteString) != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03b0, code lost:
        r4 = r4 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.R0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.P0(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.N0(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.k0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r8, (androidx.datastore.preferences.protobuf.ByteString) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c2, code lost:
        r6 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r8, androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9), v(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        if ((r6 instanceof androidx.datastore.preferences.protobuf.ByteString) != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00de, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V0(r8, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.a0(r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f8, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.m0(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0104, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o0(r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0114, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.w0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0124, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.a1(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0134, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.y0(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0140, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q0(r8, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014c, code lost:
        r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.i0(r8, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0180, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0182, code lost:
        r2.putInt(r1, (long) r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0186, code lost:
        r6 = (androidx.datastore.preferences.protobuf.CodedOutputStream.X0(r8) + androidx.datastore.preferences.protobuf.CodedOutputStream.Z0(r7)) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a0, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b1, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01c2, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d3, code lost:
        if (r0.f7211i != false) goto L_0x0182;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int z(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = z
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0008:
            int[] r6 = r0.f7203a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x03b4
            int r6 = r15.u0(r4)
            int r7 = t0(r6)
            int r8 = r15.V(r4)
            long r9 = W(r6)
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.f()
            if (r7 < r6) goto L_0x0038
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.f()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f7203a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            r13 = 0
            r14 = 1
            r11 = 0
            switch(r7) {
                case 0: goto L_0x03a8;
                case 1: goto L_0x03a0;
                case 2: goto L_0x0394;
                case 3: goto L_0x0388;
                case 4: goto L_0x037c;
                case 5: goto L_0x0374;
                case 6: goto L_0x036c;
                case 7: goto L_0x0364;
                case 8: goto L_0x0354;
                case 9: goto L_0x034c;
                case 10: goto L_0x0344;
                case 11: goto L_0x0338;
                case 12: goto L_0x032c;
                case 13: goto L_0x0324;
                case 14: goto L_0x031c;
                case 15: goto L_0x0310;
                case 16: goto L_0x0304;
                case 17: goto L_0x02fc;
                case 18: goto L_0x028a;
                case 19: goto L_0x0294;
                case 20: goto L_0x02f2;
                case 21: goto L_0x02e8;
                case 22: goto L_0x02de;
                case 23: goto L_0x028a;
                case 24: goto L_0x0294;
                case 25: goto L_0x02d4;
                case 26: goto L_0x02ca;
                case 27: goto L_0x02bc;
                case 28: goto L_0x02b2;
                case 29: goto L_0x02a8;
                case 30: goto L_0x029e;
                case 31: goto L_0x0294;
                case 32: goto L_0x028a;
                case 33: goto L_0x0280;
                case 34: goto L_0x0276;
                case 35: goto L_0x0264;
                case 36: goto L_0x0252;
                case 37: goto L_0x0240;
                case 38: goto L_0x022e;
                case 39: goto L_0x021c;
                case 40: goto L_0x020a;
                case 41: goto L_0x01f8;
                case 42: goto L_0x01e7;
                case 43: goto L_0x01d6;
                case 44: goto L_0x01c5;
                case 45: goto L_0x01b4;
                case 46: goto L_0x01a3;
                case 47: goto L_0x0192;
                case 48: goto L_0x0172;
                case 49: goto L_0x0164;
                case 50: goto L_0x0154;
                case 51: goto L_0x0146;
                case 52: goto L_0x013a;
                case 53: goto L_0x012a;
                case 54: goto L_0x011a;
                case 55: goto L_0x010a;
                case 56: goto L_0x00fe;
                case 57: goto L_0x00f2;
                case 58: goto L_0x00e6;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ab;
                case 62: goto L_0x009c;
                case 63: goto L_0x008d;
                case 64: goto L_0x0082;
                case 65: goto L_0x0077;
                case 66: goto L_0x0068;
                case 67: goto L_0x0059;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x03b0
        L_0x0042:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x0048:
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
            androidx.datastore.preferences.protobuf.MessageLite r6 = (androidx.datastore.preferences.protobuf.MessageLite) r6
            androidx.datastore.preferences.protobuf.Schema r7 = r15.v(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.t0(r8, r6, r7)
        L_0x0056:
            int r5 = r5 + r6
            goto L_0x03b0
        L_0x0059:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = b0(r1, r9)
        L_0x0063:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T0(r8, r6)
            goto L_0x0056
        L_0x0068:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = a0(r1, r9)
        L_0x0072:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.R0(r8, r6)
            goto L_0x0056
        L_0x0077:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x007d:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.P0(r8, r11)
            goto L_0x0056
        L_0x0082:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x0088:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.N0(r8, r3)
            goto L_0x0056
        L_0x008d:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = a0(r1, r9)
        L_0x0097:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.k0(r8, r6)
            goto L_0x0056
        L_0x009c:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = a0(r1, r9)
        L_0x00a6:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y0(r8, r6)
            goto L_0x0056
        L_0x00ab:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x00b1:
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
        L_0x00b5:
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g0(r8, r6)
            goto L_0x0056
        L_0x00bc:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x00c2:
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.v(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r8, r6, r7)
            goto L_0x0056
        L_0x00cf:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x00de
        L_0x00dd:
            goto L_0x00b5
        L_0x00de:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V0(r8, r6)
            goto L_0x0056
        L_0x00e6:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x00ec:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.a0(r8, r14)
            goto L_0x0056
        L_0x00f2:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x00f8:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.m0(r8, r3)
            goto L_0x0056
        L_0x00fe:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x0104:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o0(r8, r11)
            goto L_0x0056
        L_0x010a:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = a0(r1, r9)
        L_0x0114:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.w0(r8, r6)
            goto L_0x0056
        L_0x011a:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = b0(r1, r9)
        L_0x0124:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.a1(r8, r6)
            goto L_0x0056
        L_0x012a:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = b0(r1, r9)
        L_0x0134:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.y0(r8, r6)
            goto L_0x0056
        L_0x013a:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x0140:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q0(r8, r13)
            goto L_0x0056
        L_0x0146:
            boolean r6 = r15.J(r1, r8, r4)
            if (r6 == 0) goto L_0x03b0
        L_0x014c:
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.i0(r8, r6)
            goto L_0x0056
        L_0x0154:
            androidx.datastore.preferences.protobuf.MapFieldSchema r6 = r0.q
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
            java.lang.Object r9 = r15.u(r4)
            int r6 = r6.f(r8, r7, r9)
            goto L_0x0056
        L_0x0164:
            java.util.List r6 = L(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.v(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r8, r6, r7)
            goto L_0x0056
        L_0x0172:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
        L_0x0182:
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0186:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.X0(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.Z0(r7)
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x0056
        L_0x0192:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01a3:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01b4:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01c5:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01d6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01e7:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x020a:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x021c:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x022e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x0240:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x0264:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x03b0
            boolean r9 = r0.f7211i
            if (r9 == 0) goto L_0x0186
            goto L_0x0182
        L_0x0276:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r8, r6, r3)
            goto L_0x0056
        L_0x0280:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r8, r6, r3)
            goto L_0x0056
        L_0x028a:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x0056
        L_0x0294:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x0056
        L_0x029e:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r8, r6, r3)
            goto L_0x0056
        L_0x02a8:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r8, r6, r3)
            goto L_0x0056
        L_0x02b2:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r8, r6)
            goto L_0x0056
        L_0x02bc:
            java.util.List r6 = L(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.v(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r8, r6, r7)
            goto L_0x0056
        L_0x02ca:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r8, r6)
            goto L_0x0056
        L_0x02d4:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r8, r6, r3)
            goto L_0x0056
        L_0x02de:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r8, r6, r3)
            goto L_0x0056
        L_0x02e8:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.z(r8, r6, r3)
            goto L_0x0056
        L_0x02f2:
            java.util.List r6 = L(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r8, r6, r3)
            goto L_0x0056
        L_0x02fc:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x0048
        L_0x0304:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.L(r1, r9)
            goto L_0x0063
        L_0x0310:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r1, r9)
            goto L_0x0072
        L_0x031c:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x007d
        L_0x0324:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x0088
        L_0x032c:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r1, r9)
            goto L_0x0097
        L_0x0338:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r1, r9)
            goto L_0x00a6
        L_0x0344:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x00b1
        L_0x034c:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x00c2
        L_0x0354:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x00de
            goto L_0x00dd
        L_0x0364:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x00ec
        L_0x036c:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x00f8
        L_0x0374:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x0104
        L_0x037c:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r1, r9)
            goto L_0x0114
        L_0x0388:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.L(r1, r9)
            goto L_0x0124
        L_0x0394:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.L(r1, r9)
            goto L_0x0134
        L_0x03a0:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x0140
        L_0x03a8:
            boolean r6 = r15.D(r1, r4)
            if (r6 == 0) goto L_0x03b0
            goto L_0x014c
        L_0x03b0:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x03b4:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.o
            int r1 = r15.A(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.z(java.lang.Object):int");
    }

    private void z0(int i2, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.o(i2, (String) obj);
        } else {
            writer.z(i2, (ByteString) obj);
        }
    }

    public void a(T t2, T t3) {
        t3.getClass();
        for (int i2 = 0; i2 < this.f7203a.length; i2 += 3) {
            R(t2, t3, i2);
        }
        if (!this.f7210h) {
            SchemaUtil.J(this.o, t2, t3);
            if (this.f7208f) {
                SchemaUtil.H(this.p, t2, t3);
            }
        }
    }

    public void b(T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        N(this.o, this.p, t2, reader, extensionRegistryLite);
    }

    public void c(T t2) {
        int i2;
        int i3 = this.f7213k;
        while (true) {
            i2 = this.f7214l;
            if (i3 >= i2) {
                break;
            }
            long W = W(u0(this.f7212j[i3]));
            Object O = UnsafeUtil.O(t2, W);
            if (O != null) {
                UnsafeUtil.q0(t2, W, this.q.b(O));
            }
            i3++;
        }
        int length = this.f7212j.length;
        while (i2 < length) {
            this.f7216n.c(t2, (long) this.f7212j[i2]);
            i2++;
        }
        this.o.j(t2);
        if (this.f7208f) {
            this.p.f(t2);
        }
    }

    public final boolean d(T t2) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f7213k; i5++) {
            int i6 = this.f7212j[i5];
            int V = V(i6);
            int u0 = u0(i6);
            if (!this.f7210h) {
                int i7 = this.f7203a[i6 + 2];
                int i8 = t & i7;
                i2 = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = z.getInt(t2, (long) i8);
                    i3 = i8;
                }
            } else {
                i2 = 0;
            }
            if (K(u0) && !E(t2, i6, i4, i2)) {
                return false;
            }
            int t0 = t0(u0);
            if (t0 != 9 && t0 != 17) {
                if (t0 != 27) {
                    if (t0 == 60 || t0 == 68) {
                        if (J(t2, V, i6) && !F(t2, u0, v(i6))) {
                            return false;
                        }
                    } else if (t0 != 49) {
                        if (t0 == 50 && !H(t2, u0, i6)) {
                            return false;
                        }
                    }
                }
                if (!G(t2, u0, i6)) {
                    return false;
                }
            } else if (E(t2, i6, i4, i2) && !F(t2, u0, v(i6))) {
                return false;
            }
        }
        return !this.f7208f || this.p.c(t2).E();
    }

    public void e(T t2, Writer writer) throws IOException {
        if (writer.j() == Writer.FieldOrder.DESCENDING) {
            x0(t2, writer);
        } else if (this.f7210h) {
            w0(t2, writer);
        } else {
            v0(t2, writer);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0286, code lost:
        r0 = r33;
        r22 = r6;
        r19 = r7;
        r20 = r8;
        r27 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0329, code lost:
        if (r0 != r15) goto L_0x032b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0345, code lost:
        r2 = r0;
        r8 = r25;
        r0 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0379, code lost:
        if (r0 != r15) goto L_0x032b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x039a, code lost:
        if (r0 != r15) goto L_0x032b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        r11 = r33;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e3, code lost:
        r12 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e5, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ff, code lost:
        r10.putLong(r29, r2, r4);
        r6 = r6 | r20;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010e, code lost:
        r11 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
        r10.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012a, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0199, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a6, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ca, code lost:
        r10.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0226, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e0(T r29, byte[] r30, int r31, int r32, int r33, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = z
            r16 = 0
            r0 = r31
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x03f2
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r9)
            int r3 = r9.f6976a
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0039
            int r2 = r2 / r8
            int r1 = r15.i0(r3, r2)
        L_0x0036:
            r2 = r1
            r1 = -1
            goto L_0x003e
        L_0x0039:
            int r1 = r15.h0(r3)
            goto L_0x0036
        L_0x003e:
            if (r2 != r1) goto L_0x004f
            r17 = r3
            r2 = r4
            r8 = r5
            r22 = r6
            r19 = r7
            r27 = r10
            r0 = r11
            r20 = 0
            goto L_0x039d
        L_0x004f:
            int[] r1 = r15.f7203a
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = t0(r1)
            long r11 = W(r1)
            r18 = r5
            r5 = 17
            r19 = r1
            if (r8 > r5) goto L_0x0294
            int[] r5 = r15.f7203a
            int r20 = r2 + 2
            r5 = r5[r20]
            int r20 = r5 >>> 20
            r1 = 1
            int r20 = r1 << r20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r22
            if (r5 == r7) goto L_0x0088
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0080:
            long r1 = (long) r5
            int r1 = r10.getInt(r14, r1)
            r6 = r1
            r7 = r5
            goto L_0x008b
        L_0x0088:
            r17 = r2
            r13 = -1
        L_0x008b:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x026f;
                case 1: goto L_0x0256;
                case 2: goto L_0x0240;
                case 3: goto L_0x0240;
                case 4: goto L_0x022a;
                case 5: goto L_0x0209;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01ce;
                case 8: goto L_0x01a9;
                case 9: goto L_0x016f;
                case 10: goto L_0x0159;
                case 11: goto L_0x022a;
                case 12: goto L_0x012d;
                case 13: goto L_0x01f0;
                case 14: goto L_0x0209;
                case 15: goto L_0x0112;
                case 16: goto L_0x00ea;
                case 17: goto L_0x009c;
                default: goto L_0x008f;
            }
        L_0x008f:
            r12 = r30
            r11 = r4
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            goto L_0x0286
        L_0x009c:
            r1 = 3
            if (r0 != r1) goto L_0x00dd
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            androidx.datastore.preferences.protobuf.Schema r0 = r15.v(r2)
            r1 = r30
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r32
            r4 = r5
            r13 = r18
            r5 = r34
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x00c4
            java.lang.Object r1 = r9.f6978c
        L_0x00c0:
            r10.putObject(r14, r11, r1)
            goto L_0x00cf
        L_0x00c4:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.f6978c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.v(r1, r2)
            goto L_0x00c0
        L_0x00cf:
            r6 = r6 | r20
            r12 = r30
        L_0x00d3:
            r11 = r33
            r2 = r8
            r3 = r13
            r1 = r17
        L_0x00d9:
            r13 = r32
            goto L_0x0017
        L_0x00dd:
            r8 = r17
            r13 = r18
            r17 = r3
        L_0x00e3:
            r12 = r30
        L_0x00e5:
            r11 = r4
            r18 = -1
            goto L_0x0286
        L_0x00ea:
            r8 = r17
            r13 = r18
            r17 = r3
            if (r0 != 0) goto L_0x00e3
            r2 = r11
            r12 = r30
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r0 = r9.f6977b
            long r4 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r0)
        L_0x00ff:
            r0 = r10
            r1 = r29
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r32
        L_0x010e:
            r11 = r33
            goto L_0x0017
        L_0x0112:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r30
            if (r0 != 0) goto L_0x00e5
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.f6976a
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r1)
        L_0x0127:
            r10.putInt(r14, r2, r1)
        L_0x012a:
            r6 = r6 | r20
            goto L_0x00d3
        L_0x012d:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r30
            if (r0 != 0) goto L_0x00e5
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.f6976a
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r15.t(r8)
            if (r4 == 0) goto L_0x0127
            boolean r4 = r4.a(r1)
            if (r4 == 0) goto L_0x014b
            goto L_0x0127
        L_0x014b:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = w(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.r(r13, r1)
            goto L_0x00d3
        L_0x0159:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r30
            if (r0 != r1) goto L_0x00e5
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r9)
            java.lang.Object r1 = r9.f6978c
            r10.putObject(r14, r2, r1)
            goto L_0x012a
        L_0x016f:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r30
            if (r0 != r1) goto L_0x01a2
            androidx.datastore.preferences.protobuf.Schema r0 = r15.v(r8)
            r11 = r32
            r18 = -1
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r4, r11, r9)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x018e
            java.lang.Object r1 = r9.f6978c
            goto L_0x01ca
        L_0x018e:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f6978c
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.v(r1, r4)
            goto L_0x01ca
        L_0x0199:
            r6 = r6 | r20
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x010e
        L_0x01a2:
            r11 = r32
            r18 = -1
        L_0x01a6:
            r11 = r4
            goto L_0x0286
        L_0x01a9:
            r8 = r17
            r13 = r18
            r1 = 2
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r32
            if (r0 != r1) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 != 0) goto L_0x01c4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r4, r9)
            goto L_0x01c8
        L_0x01c4:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r4, r9)
        L_0x01c8:
            java.lang.Object r1 = r9.f6978c
        L_0x01ca:
            r10.putObject(r14, r2, r1)
            goto L_0x0199
        L_0x01ce:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r32
            if (r0 != 0) goto L_0x01a6
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r4 = r9.f6977b
            r23 = 0
            int r1 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x01eb
            r1 = 1
            goto L_0x01ec
        L_0x01eb:
            r1 = 0
        L_0x01ec:
            androidx.datastore.preferences.protobuf.UnsafeUtil.X(r14, r2, r1)
            goto L_0x0199
        L_0x01f0:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r32
            if (r0 != r1) goto L_0x01a6
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            goto L_0x0199
        L_0x0209:
            r8 = r17
            r13 = r18
            r1 = 1
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r32
            if (r0 != r1) goto L_0x01a6
            long r21 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r4)
            r0 = r10
            r1 = r29
            r11 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0226:
            int r0 = r11 + 8
            goto L_0x012a
        L_0x022a:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r4
            if (r0 != 0) goto L_0x0286
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r11, r9)
            int r1 = r9.f6976a
            goto L_0x0127
        L_0x0240:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r4
            if (r0 != 0) goto L_0x0286
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r11, r9)
            long r4 = r9.f6977b
            goto L_0x00ff
        L_0x0256:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r4
            if (r0 != r1) goto L_0x0286
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.i0(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x012a
        L_0x026f:
            r8 = r17
            r13 = r18
            r1 = 1
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r30
            r11 = r4
            if (r0 != r1) goto L_0x0286
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.g0(r14, r2, r0)
            goto L_0x0226
        L_0x0286:
            r0 = r33
            r22 = r6
            r19 = r7
            r20 = r8
            r27 = r10
            r2 = r11
            r8 = r13
            goto L_0x039d
        L_0x0294:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r18
            r18 = -1
            r12 = r30
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x02f2
            r1 = 2
            if (r0 != r1) goto L_0x02e5
            java.lang.Object r0 = r10.getObject(r14, r2)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.P2()
            if (r1 != 0) goto L_0x02c4
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02bb
            r1 = 10
            goto L_0x02bd
        L_0x02bb:
            int r1 = r1 * 2
        L_0x02bd:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.f(r1)
            r10.putObject(r14, r2, r0)
        L_0x02c4:
            r8 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.v(r5)
            r1 = r13
            r2 = r30
            r3 = r11
            r4 = r32
            r20 = r5
            r5 = r8
            r22 = r6
            r6 = r34
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r11 = r33
            r3 = r13
            r1 = r17
            r2 = r20
            r6 = r22
            goto L_0x00d9
        L_0x02e5:
            r20 = r5
            r22 = r6
            r19 = r7
            r27 = r10
            r15 = r11
            r25 = r13
            goto L_0x037c
        L_0x02f2:
            r20 = r5
            r22 = r6
            r1 = 49
            if (r8 > r1) goto L_0x034c
            r1 = r19
            long r5 = (long) r1
            r4 = r0
            r0 = r28
            r1 = r29
            r23 = r2
            r2 = r30
            r3 = r11
            r31 = r4
            r4 = r32
            r25 = r5
            r5 = r13
            r6 = r17
            r19 = r7
            r7 = r31
            r18 = r8
            r8 = r20
            r27 = r10
            r9 = r25
            r15 = r11
            r11 = r18
            r25 = r13
            r12 = r23
            r14 = r34
            int r0 = r0.g0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0345
        L_0x032b:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r3 = r25
        L_0x0341:
            r10 = r27
            goto L_0x0017
        L_0x0345:
            r2 = r0
            r8 = r25
            r0 = r33
            goto L_0x039d
        L_0x034c:
            r31 = r0
            r23 = r2
            r18 = r8
            r27 = r10
            r15 = r11
            r25 = r13
            r1 = r19
            r19 = r7
            r0 = 50
            r9 = r18
            r7 = r31
            if (r9 != r0) goto L_0x0382
            r0 = 2
            if (r7 != r0) goto L_0x037c
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r23
            r8 = r34
            int r0 = r0.c0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0345
            goto L_0x032b
        L_0x037c:
            r0 = r33
            r2 = r15
            r8 = r25
            goto L_0x039d
        L_0x0382:
            r0 = r28
            r8 = r1
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r25
            r6 = r17
            r10 = r23
            r12 = r20
            r13 = r34
            int r0 = r0.d0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0345
            goto L_0x032b
        L_0x039d:
            if (r8 != r0) goto L_0x03ac
            if (r0 == 0) goto L_0x03ac
            r9 = r28
            r10 = r0
            r0 = r2
            r3 = r8
            r7 = r19
            r6 = r22
        L_0x03aa:
            r1 = -1
            goto L_0x03fb
        L_0x03ac:
            r9 = r28
            r10 = r0
            boolean r0 = r9.f7208f
            r11 = r34
            if (r0 == 0) goto L_0x03cf
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = r11.f6979d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.d()
            if (r0 == r1) goto L_0x03cf
            androidx.datastore.preferences.protobuf.MessageLite r5 = r9.f7207e
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.o
            r0 = r8
            r1 = r30
            r3 = r32
            r4 = r29
            r7 = r34
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x03de
        L_0x03cf:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = w(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
        L_0x03de:
            r14 = r29
            r12 = r30
            r13 = r32
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r11 = r10
            goto L_0x0341
        L_0x03f2:
            r22 = r6
            r19 = r7
            r27 = r10
            r10 = r11
            r9 = r15
            goto L_0x03aa
        L_0x03fb:
            if (r7 == r1) goto L_0x0406
            long r1 = (long) r7
            r4 = r29
            r5 = r27
            r5.putInt(r4, r1, r6)
            goto L_0x0408
        L_0x0406:
            r4 = r29
        L_0x0408:
            int r1 = r9.f7213k
            r2 = 0
        L_0x040b:
            int r5 = r9.f7214l
            if (r1 >= r5) goto L_0x041e
            int[] r5 = r9.f7212j
            r5 = r5[r1]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.o
            java.lang.Object r2 = r9.q(r4, r5, r2, r6)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r2
            int r1 = r1 + 1
            goto L_0x040b
        L_0x041e:
            if (r2 == 0) goto L_0x0425
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r1 = r9.o
            r1.o(r4, r2)
        L_0x0425:
            r1 = r32
            if (r10 != 0) goto L_0x0431
            if (r0 != r1) goto L_0x042c
            goto L_0x0435
        L_0x042c:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
            throw r0
        L_0x0431:
            if (r0 > r1) goto L_0x0436
            if (r3 != r10) goto L_0x0436
        L_0x0435:
            return r0
        L_0x0436:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.e0(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public boolean f(T t2, T t3) {
        int length = this.f7203a.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            if (!p(t2, t3, i2)) {
                return false;
            }
        }
        if (!this.o.g(t2).equals(this.o.g(t3))) {
            return false;
        }
        if (this.f7208f) {
            return this.p.c(t2).equals(this.p.c(t3));
        }
        return true;
    }

    public int g(T t2) {
        return this.f7210h ? z(t2) : y(t2);
    }

    public T h() {
        return this.f7215m.a(this.f7207e);
    }

    public void i(T t2, byte[] bArr, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        if (this.f7210h) {
            f0(t2, bArr, i2, i3, registers);
        } else {
            e0(t2, bArr, i2, i3, 0, registers);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r2 = r2 * 53;
        r3 = b0(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r3 = androidx.datastore.preferences.protobuf.Internal.s(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r2 = r2 * 53;
        r3 = a0(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        r2 = r2 * 53;
        r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        r3 = androidx.datastore.preferences.protobuf.Internal.k(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f0, code lost:
        if (r3 != null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010e, code lost:
        if (r3 != null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0126, code lost:
        r1 = r1 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r2 = r2 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f7203a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012a
            int r3 = r8.u0(r1)
            int r4 = r8.V(r1)
            long r5 = W(r3)
            int r3 = t0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011f;
                case 1: goto L_0x0118;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00fa;
                case 4: goto L_0x0102;
                case 5: goto L_0x00fa;
                case 6: goto L_0x0102;
                case 7: goto L_0x0111;
                case 8: goto L_0x0085;
                case 9: goto L_0x010a;
                case 10: goto L_0x0071;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x00fa;
                case 15: goto L_0x0102;
                case 16: goto L_0x00fa;
                case 17: goto L_0x00ec;
                case 18: goto L_0x0071;
                case 19: goto L_0x0071;
                case 20: goto L_0x0071;
                case 21: goto L_0x0071;
                case 22: goto L_0x0071;
                case 23: goto L_0x0071;
                case 24: goto L_0x0071;
                case 25: goto L_0x0071;
                case 26: goto L_0x0071;
                case 27: goto L_0x0071;
                case 28: goto L_0x0071;
                case 29: goto L_0x0071;
                case 30: goto L_0x0071;
                case 31: goto L_0x0071;
                case 32: goto L_0x0071;
                case 33: goto L_0x0071;
                case 34: goto L_0x0071;
                case 35: goto L_0x0071;
                case 36: goto L_0x0071;
                case 37: goto L_0x0071;
                case 38: goto L_0x0071;
                case 39: goto L_0x0071;
                case 40: goto L_0x0071;
                case 41: goto L_0x0071;
                case 42: goto L_0x0071;
                case 43: goto L_0x0071;
                case 44: goto L_0x0071;
                case 45: goto L_0x0071;
                case 46: goto L_0x0071;
                case 47: goto L_0x0071;
                case 48: goto L_0x0071;
                case 49: goto L_0x0071;
                case 50: goto L_0x0071;
                case 51: goto L_0x00da;
                case 52: goto L_0x00c8;
                case 53: goto L_0x00c0;
                case 54: goto L_0x00b8;
                case 55: goto L_0x00b1;
                case 56: goto L_0x00aa;
                case 57: goto L_0x00a3;
                case 58: goto L_0x0092;
                case 59: goto L_0x007f;
                case 60: goto L_0x0078;
                case 61: goto L_0x006b;
                case 62: goto L_0x0064;
                case 63: goto L_0x005d;
                case 64: goto L_0x0056;
                case 65: goto L_0x004f;
                case 66: goto L_0x0042;
                case 67: goto L_0x0031;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0126
        L_0x001e:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
        L_0x0024:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)
            int r2 = r2 * 53
        L_0x002a:
            int r3 = r3.hashCode()
        L_0x002e:
            int r2 = r2 + r3
            goto L_0x0126
        L_0x0031:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
        L_0x0037:
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
        L_0x003d:
            int r3 = androidx.datastore.preferences.protobuf.Internal.s(r3)
            goto L_0x002e
        L_0x0042:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
        L_0x0048:
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x002e
        L_0x004f:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0037
        L_0x0056:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0048
        L_0x005d:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0048
        L_0x0064:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0048
        L_0x006b:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
        L_0x0071:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)
            goto L_0x002a
        L_0x0078:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0024
        L_0x007f:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
        L_0x0085:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0092:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            int r2 = r2 * 53
            boolean r3 = X(r9, r5)
        L_0x009e:
            int r3 = androidx.datastore.preferences.protobuf.Internal.k(r3)
            goto L_0x002e
        L_0x00a3:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0048
        L_0x00aa:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0037
        L_0x00b1:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0048
        L_0x00b8:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0037
        L_0x00c0:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            goto L_0x0037
        L_0x00c8:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            int r2 = r2 * 53
            float r3 = Z(r9, r5)
        L_0x00d4:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x00da:
            boolean r3 = r8.J(r9, r4, r1)
            if (r3 == 0) goto L_0x0126
            int r2 = r2 * 53
            double r3 = Y(r9, r5)
        L_0x00e6:
            long r3 = java.lang.Double.doubleToLongBits(r3)
            goto L_0x003d
        L_0x00ec:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)
            if (r3 == 0) goto L_0x00f6
        L_0x00f2:
            int r7 = r3.hashCode()
        L_0x00f6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0126
        L_0x00fa:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.L(r9, r5)
            goto L_0x003d
        L_0x0102:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.I(r9, r5)
            goto L_0x002e
        L_0x010a:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.O(r9, r5)
            if (r3 == 0) goto L_0x00f6
            goto L_0x00f2
        L_0x0111:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            goto L_0x009e
        L_0x0118:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.F(r9, r5)
            goto L_0x00d4
        L_0x011f:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.D(r9, r5)
            goto L_0x00e6
        L_0x0126:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x012a:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r8.o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f7208f
            if (r0 == 0) goto L_0x0148
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r8.p
            androidx.datastore.preferences.protobuf.FieldSet r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0148:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.j(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    public int x() {
        return this.f7203a.length * 3;
    }
}
