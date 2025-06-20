package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* renamed from: androidx.datastore.preferences.protobuf.ExtensionSchemaLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7119a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7119a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f7119a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ExtensionSchemaLite.AnonymousClass1.<clinit>():void");
        }
    }

    ExtensionSchemaLite() {
    }

    /* access modifiers changed from: package-private */
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).d();
    }

    /* access modifiers changed from: package-private */
    public Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2) {
        return extensionRegistryLite.c(messageLite, i2);
    }

    /* access modifiers changed from: package-private */
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    /* access modifiers changed from: package-private */
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).M2();
    }

    /* access modifiers changed from: package-private */
    public boolean e(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    /* access modifiers changed from: package-private */
    public void f(Object obj) {
        c(obj).I();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0139, code lost:
        r4 = java.lang.Long.valueOf(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <UT, UB> UB g(androidx.datastore.preferences.protobuf.Reader r4, java.lang.Object r5, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r6, androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor> r7, UB r8, androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r9) throws java.io.IOException {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r5 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r5
            int r0 = r5.d()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r5.f7163d
            boolean r1 = r1.M()
            if (r1 == 0) goto L_0x00d2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r5.f7163d
            boolean r1 = r1.a2()
            if (r1 == 0) goto L_0x00d2
            int[] r6 = androidx.datastore.preferences.protobuf.ExtensionSchemaLite.AnonymousClass1.f7119a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r5.b()
            int r1 = r1.ordinal()
            r6 = r6[r1]
            switch(r6) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00a8;
                case 5: goto L_0x009f;
                case 6: goto L_0x0096;
                case 7: goto L_0x008d;
                case 8: goto L_0x0084;
                case 9: goto L_0x007b;
                case 10: goto L_0x0072;
                case 11: goto L_0x0069;
                case 12: goto L_0x0060;
                case 13: goto L_0x0056;
                case 14: goto L_0x0042;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Type cannot be packed: "
            r6.append(r7)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r5.f7163d
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r5 = r5.V()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        L_0x0042:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.u(r6)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r5.f7163d
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r4 = r4.b1()
            java.lang.Object r8 = androidx.datastore.preferences.protobuf.SchemaUtil.B(r0, r6, r4, r8, r9)
            goto L_0x00cb
        L_0x0056:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.h(r6)
            goto L_0x00cb
        L_0x0060:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.b(r6)
            goto L_0x00cb
        L_0x0069:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.s(r6)
            goto L_0x00cb
        L_0x0072:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.g(r6)
            goto L_0x00cb
        L_0x007b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.i(r6)
            goto L_0x00cb
        L_0x0084:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.A(r6)
            goto L_0x00cb
        L_0x008d:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.x(r6)
            goto L_0x00cb
        L_0x0096:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.R(r6)
            goto L_0x00cb
        L_0x009f:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.t(r6)
            goto L_0x00cb
        L_0x00a8:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.m(r6)
            goto L_0x00cb
        L_0x00b1:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.r(r6)
            goto L_0x00cb
        L_0x00ba:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.G(r6)
            goto L_0x00cb
        L_0x00c3:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4.N(r6)
        L_0x00cb:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r5.f7163d
            r7.O(r4, r6)
            goto L_0x01b7
        L_0x00d2:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r5.b()
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r2 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r2) goto L_0x00f5
            int r4 = r4.H()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r5.f7163d
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r6 = r6.b1()
            androidx.datastore.preferences.protobuf.Internal$EnumLite r6 = r6.a(r4)
            if (r6 != 0) goto L_0x00ef
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.SchemaUtil.Q(r0, r4, r8, r9)
            return r4
        L_0x00ef:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0185
        L_0x00f5:
            int[] r9 = androidx.datastore.preferences.protobuf.ExtensionSchemaLite.AnonymousClass1.f7119a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r5.b()
            int r0 = r0.ordinal()
            r9 = r9[r0]
            switch(r9) {
                case 1: goto L_0x017d;
                case 2: goto L_0x0174;
                case 3: goto L_0x016f;
                case 4: goto L_0x016a;
                case 5: goto L_0x0165;
                case 6: goto L_0x0160;
                case 7: goto L_0x015b;
                case 8: goto L_0x0152;
                case 9: goto L_0x014d;
                case 10: goto L_0x0148;
                case 11: goto L_0x0143;
                case 12: goto L_0x013e;
                case 13: goto L_0x0135;
                case 14: goto L_0x012d;
                case 15: goto L_0x0128;
                case 16: goto L_0x0123;
                case 17: goto L_0x0115;
                case 18: goto L_0x0107;
                default: goto L_0x0104;
            }
        L_0x0104:
            r4 = 0
            goto L_0x0185
        L_0x0107:
            androidx.datastore.preferences.protobuf.MessageLite r9 = r5.c()
            java.lang.Class r9 = r9.getClass()
            java.lang.Object r4 = r4.e(r9, r6)
            goto L_0x0185
        L_0x0115:
            androidx.datastore.preferences.protobuf.MessageLite r9 = r5.c()
            java.lang.Class r9 = r9.getClass()
            java.lang.Object r4 = r4.o(r9, r6)
            goto L_0x0185
        L_0x0123:
            java.lang.String r4 = r4.B()
            goto L_0x0185
        L_0x0128:
            androidx.datastore.preferences.protobuf.ByteString r4 = r4.F()
            goto L_0x0185
        L_0x012d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Shouldn't reach here."
            r4.<init>(r5)
            throw r4
        L_0x0135:
            long r0 = r4.z()
        L_0x0139:
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0185
        L_0x013e:
            int r4 = r4.y()
            goto L_0x00ef
        L_0x0143:
            long r0 = r4.l()
            goto L_0x0139
        L_0x0148:
            int r4 = r4.L()
            goto L_0x00ef
        L_0x014d:
            int r4 = r4.q()
            goto L_0x00ef
        L_0x0152:
            boolean r4 = r4.k()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0185
        L_0x015b:
            int r4 = r4.j()
            goto L_0x00ef
        L_0x0160:
            long r0 = r4.d()
            goto L_0x0139
        L_0x0165:
            int r4 = r4.H()
            goto L_0x00ef
        L_0x016a:
            long r0 = r4.c()
            goto L_0x0139
        L_0x016f:
            long r0 = r4.P()
            goto L_0x0139
        L_0x0174:
            float r4 = r4.readFloat()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            goto L_0x0185
        L_0x017d:
            double r0 = r4.readDouble()
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
        L_0x0185:
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x0191
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r5.f7163d
            r7.h(r5, r4)
            goto L_0x01b7
        L_0x0191:
            int[] r6 = androidx.datastore.preferences.protobuf.ExtensionSchemaLite.AnonymousClass1.f7119a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r5.b()
            int r9 = r9.ordinal()
            r6 = r6[r9]
            r9 = 17
            if (r6 == r9) goto L_0x01a6
            r9 = 18
            if (r6 == r9) goto L_0x01a6
            goto L_0x01b2
        L_0x01a6:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r5.f7163d
            java.lang.Object r6 = r7.u(r6)
            if (r6 == 0) goto L_0x01b2
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.Internal.v(r6, r4)
        L_0x01b2:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r5.f7163d
            r7.O(r5, r4)
        L_0x01b7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ExtensionSchemaLite.g(androidx.datastore.preferences.protobuf.Reader, java.lang.Object, androidx.datastore.preferences.protobuf.ExtensionRegistryLite, androidx.datastore.preferences.protobuf.FieldSet, java.lang.Object, androidx.datastore.preferences.protobuf.UnknownFieldSchema):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.O(generatedExtension.f7163d, reader.e(generatedExtension.c().getClass(), extensionRegistryLite));
    }

    /* access modifiers changed from: package-private */
    public void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite M1 = generatedExtension.c().b2().M1();
        BinaryReader U = BinaryReader.U(ByteBuffer.wrap(byteString.j0()), true);
        Protobuf.a().f(M1, U, extensionRegistryLite);
        fieldSet.O(generatedExtension.f7163d, M1);
        if (U.C() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor) entry.getKey();
        if (extensionDescriptor.M()) {
            switch (AnonymousClass1.f7119a[extensionDescriptor.V().ordinal()]) {
                case 1:
                    SchemaUtil.Y(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 2:
                    SchemaUtil.g0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 3:
                    SchemaUtil.m0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 4:
                    SchemaUtil.F0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 5:
                case 14:
                    SchemaUtil.k0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 6:
                    SchemaUtil.e0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 7:
                    SchemaUtil.c0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 8:
                    SchemaUtil.U(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 9:
                    SchemaUtil.D0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 10:
                    SchemaUtil.s0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 11:
                    SchemaUtil.u0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 12:
                    SchemaUtil.w0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 13:
                    SchemaUtil.y0(extensionDescriptor.d(), (List) entry.getValue(), writer, extensionDescriptor.a2());
                    return;
                case 15:
                    SchemaUtil.W(extensionDescriptor.d(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.B0(extensionDescriptor.d(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        SchemaUtil.i0(extensionDescriptor.d(), (List) entry.getValue(), writer, Protobuf.a().i(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        SchemaUtil.q0(extensionDescriptor.d(), (List) entry.getValue(), writer, Protobuf.a().i(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (AnonymousClass1.f7119a[extensionDescriptor.V().ordinal()]) {
                case 1:
                    writer.e(extensionDescriptor.d(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.I(extensionDescriptor.d(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.s(extensionDescriptor.d(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.p(extensionDescriptor.d(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                case 14:
                    writer.w(extensionDescriptor.d(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.i(extensionDescriptor.d(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.d(extensionDescriptor.d(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.t(extensionDescriptor.d(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.b(extensionDescriptor.d(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.u(extensionDescriptor.d(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.A(extensionDescriptor.d(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.Q(extensionDescriptor.d(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.H(extensionDescriptor.d(), ((Long) entry.getValue()).longValue());
                    return;
                case 15:
                    writer.z(extensionDescriptor.d(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.o(extensionDescriptor.d(), (String) entry.getValue());
                    return;
                case 17:
                    writer.S(extensionDescriptor.d(), entry.getValue(), Protobuf.a().i(entry.getValue().getClass()));
                    return;
                case 18:
                    writer.C(extensionDescriptor.d(), entry.getValue(), Protobuf.a().i(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Object obj, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions = fieldSet;
    }
}
