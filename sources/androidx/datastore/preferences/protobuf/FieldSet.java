package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final int f7139d = 16;

    /* renamed from: e  reason: collision with root package name */
    private static final FieldSet f7140e = new FieldSet(true);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SmallSortedMap<T, Object> f7141a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7142b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f7143c;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldSet$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7144a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7145b;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7145b = r0
                r1 = 1
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r2 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f7145b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f7145b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f7145b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r5 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f7145b     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f7145b     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f7145b     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f7145b     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = f7145b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                f7144a = r9
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r10 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f7144a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x00fd }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x0107 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x0111 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x011b }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x0125 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x012f }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f7144a     // Catch:{ NoSuchFieldError -> 0x0139 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldSet.AnonymousClass1.<clinit>():void");
        }
    }

    static final class Builder<T extends FieldDescriptorLite<T>> {

        /* renamed from: a  reason: collision with root package name */
        private SmallSortedMap<T, Object> f7146a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7147b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7148c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7149d;

        private Builder() {
            this(SmallSortedMap.t(16));
        }

        private void d() {
            if (!this.f7148c) {
                this.f7146a = FieldSet.l(this.f7146a, true);
                this.f7148c = true;
            }
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> e(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.l(fieldSet.f7141a, true));
            builder.f7147b = fieldSet.f7143c;
            return builder;
        }

        private void o(Map.Entry<T, Object> entry) {
            Object obj;
            SmallSortedMap<T, Object> smallSortedMap;
            Object g2;
            FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).p();
            }
            if (fieldDescriptorLite.M()) {
                Object g3 = g(fieldDescriptorLite);
                if (g3 == null) {
                    g3 = new ArrayList();
                }
                for (Object g4 : (List) value) {
                    ((List) g3).add(FieldSet.n(g4));
                }
                this.f7146a.put(fieldDescriptorLite, g3);
                return;
            }
            if (fieldDescriptorLite.U1() != WireFormat.JavaType.MESSAGE || (g2 = g(fieldDescriptorLite)) == null) {
                smallSortedMap = this.f7146a;
                obj = FieldSet.n(value);
            } else if (g2 instanceof MessageLite.Builder) {
                fieldDescriptorLite.d2((MessageLite.Builder) g2, (MessageLite) value);
                return;
            } else {
                obj = fieldDescriptorLite.d2(((MessageLite) g2).E(), (MessageLite) value).build();
                smallSortedMap = this.f7146a;
            }
            smallSortedMap.put(fieldDescriptorLite, obj);
        }

        private static Object p(Object obj) {
            return obj instanceof MessageLite.Builder ? ((MessageLite.Builder) obj).build() : obj;
        }

        private static <T extends FieldDescriptorLite<T>> Object q(T t, Object obj) {
            if (obj == null || t.U1() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t.M()) {
                return p(obj);
            }
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Object obj2 = list.get(i2);
                    Object p = p(obj2);
                    if (p != obj2) {
                        if (list == obj) {
                            list = new ArrayList(list);
                        }
                        list.set(i2, p);
                    }
                }
                return list;
            }
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
        }

        private static <T extends FieldDescriptorLite<T>> void r(SmallSortedMap<T, Object> smallSortedMap) {
            for (int i2 = 0; i2 < smallSortedMap.k(); i2++) {
                s(smallSortedMap.j(i2));
            }
            for (Map.Entry<T, Object> s : smallSortedMap.m()) {
                s(s);
            }
        }

        private static <T extends FieldDescriptorLite<T>> void s(Map.Entry<T, Object> entry) {
            entry.setValue(q((FieldDescriptorLite) entry.getKey(), entry.getValue()));
        }

        private static void v(WireFormat.FieldType fieldType, Object obj) {
            if (FieldSet.G(fieldType, obj)) {
                return;
            }
            if (fieldType.a() != WireFormat.JavaType.MESSAGE || !(obj instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }

        public void a(T t, Object obj) {
            List list;
            d();
            if (t.M()) {
                this.f7149d = this.f7149d || (obj instanceof MessageLite.Builder);
                v(t.V(), obj);
                Object g2 = g(t);
                if (g2 == null) {
                    list = new ArrayList();
                    this.f7146a.put(t, list);
                } else {
                    list = (List) g2;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public FieldSet<T> b() {
            if (this.f7146a.isEmpty()) {
                return FieldSet.s();
            }
            this.f7148c = false;
            SmallSortedMap<T, Object> smallSortedMap = this.f7146a;
            if (this.f7149d) {
                smallSortedMap = FieldSet.l(smallSortedMap, false);
                r(smallSortedMap);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMap, (AnonymousClass1) null);
            boolean unused = fieldSet.f7143c = this.f7147b;
            return fieldSet;
        }

        public void c(T t) {
            d();
            this.f7146a.remove(t);
            if (this.f7146a.isEmpty()) {
                this.f7147b = false;
            }
        }

        public Map<T, Object> f() {
            if (!this.f7147b) {
                return this.f7146a.p() ? this.f7146a : Collections.unmodifiableMap(this.f7146a);
            }
            SmallSortedMap a2 = FieldSet.l(this.f7146a, false);
            if (this.f7146a.p()) {
                a2.s();
            } else {
                r(a2);
            }
            return a2;
        }

        public Object g(T t) {
            return q(t, h(t));
        }

        /* access modifiers changed from: package-private */
        public Object h(T t) {
            Object obj = this.f7146a.get(t);
            return obj instanceof LazyField ? ((LazyField) obj).p() : obj;
        }

        public Object i(T t, int i2) {
            if (this.f7149d) {
                d();
            }
            return p(j(t, i2));
        }

        /* access modifiers changed from: package-private */
        public Object j(T t, int i2) {
            if (t.M()) {
                Object h2 = h(t);
                if (h2 != null) {
                    return ((List) h2).get(i2);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int k(T t) {
            if (t.M()) {
                Object g2 = g(t);
                if (g2 == null) {
                    return 0;
                }
                return ((List) g2).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public boolean l(T t) {
            if (!t.M()) {
                return this.f7146a.get(t) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public boolean m() {
            for (int i2 = 0; i2 < this.f7146a.k(); i2++) {
                if (!FieldSet.F(this.f7146a.j(i2))) {
                    return false;
                }
            }
            for (Map.Entry<T, Object> f2 : this.f7146a.m()) {
                if (!FieldSet.F(f2)) {
                    return false;
                }
            }
            return true;
        }

        public void n(FieldSet<T> fieldSet) {
            d();
            for (int i2 = 0; i2 < fieldSet.f7141a.k(); i2++) {
                o(fieldSet.f7141a.j(i2));
            }
            for (Map.Entry o : fieldSet.f7141a.m()) {
                o(o);
            }
        }

        public void t(T t, Object obj) {
            d();
            boolean z = false;
            if (!t.M()) {
                v(t.V(), obj);
            } else if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object next : arrayList) {
                    v(t.V(), next);
                    this.f7149d = this.f7149d || (next instanceof MessageLite.Builder);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            if (obj instanceof LazyField) {
                this.f7147b = true;
            }
            if (this.f7149d || (obj instanceof MessageLite.Builder)) {
                z = true;
            }
            this.f7149d = z;
            this.f7146a.put(t, obj);
        }

        public void u(T t, int i2, Object obj) {
            d();
            if (t.M()) {
                this.f7149d = this.f7149d || (obj instanceof MessageLite.Builder);
                Object g2 = g(t);
                if (g2 != null) {
                    v(t.V(), obj);
                    ((List) g2).set(i2, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.f7146a = smallSortedMap;
            this.f7148c = true;
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        boolean M();

        WireFormat.JavaType U1();

        WireFormat.FieldType V();

        boolean a2();

        Internal.EnumLiteMap<?> b1();

        int d();

        MessageLite.Builder d2(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.f7141a = SmallSortedMap.t(16);
    }

    static int A(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.b();
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean F(Map.Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.U1() == WireFormat.JavaType.MESSAGE) {
            boolean M = fieldDescriptorLite.M();
            Object value = entry.getValue();
            if (M) {
                for (MessageLite m2 : (List) value) {
                    if (!m2.m()) {
                        return false;
                    }
                }
            } else if (value instanceof MessageLite) {
                if (!((MessageLite) value).m()) {
                    return false;
                }
            } else if (value instanceof LazyField) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean G(WireFormat.FieldType fieldType, Object obj) {
        Internal.d(obj);
        switch (AnonymousClass1.f7144a[fieldType.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof ByteString) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof Internal.EnumLite);
            case 9:
                return (obj instanceof MessageLite) || (obj instanceof LazyField);
            default:
                return false;
        }
    }

    private void K(Map.Entry<T, Object> entry) {
        Object obj;
        SmallSortedMap<T, Object> smallSortedMap;
        Object u;
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).p();
        }
        if (fieldDescriptorLite.M()) {
            Object u2 = u(fieldDescriptorLite);
            if (u2 == null) {
                u2 = new ArrayList();
            }
            for (Object n2 : (List) value) {
                ((List) u2).add(n(n2));
            }
            this.f7141a.put(fieldDescriptorLite, u2);
            return;
        }
        if (fieldDescriptorLite.U1() != WireFormat.JavaType.MESSAGE || (u = u(fieldDescriptorLite)) == null) {
            smallSortedMap = this.f7141a;
            obj = n(value);
        } else {
            obj = fieldDescriptorLite.d2(((MessageLite) u).E(), (MessageLite) value).build();
            smallSortedMap = this.f7141a;
        }
        smallSortedMap.put(fieldDescriptorLite, obj);
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> L() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> M() {
        return new FieldSet<>();
    }

    public static Object N(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        return WireFormat.d(codedInputStream, fieldType, z ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE);
    }

    private void Q(WireFormat.FieldType fieldType, Object obj) {
        if (!G(fieldType, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    static void R(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i2, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.F1(i2, (MessageLite) obj);
            return;
        }
        codedOutputStream.g2(i2, A(fieldType, false));
        S(codedOutputStream, fieldType, obj);
    }

    static void S(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.f7145b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.A1(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.E1(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.K1(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.i2(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.J1(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.D1(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.C1(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.t1(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.H1((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.N1((MessageLite) obj);
                return;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.f2((String) obj);
                    return;
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.w1((byte[]) obj);
                    return;
                }
                break;
            case 13:
                codedOutputStream.h2(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.b2(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.c2(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.d2(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.e2(((Long) obj).longValue());
                return;
            case 18:
                codedOutputStream.B1(obj instanceof Internal.EnumLite ? ((Internal.EnumLite) obj).d() : ((Integer) obj).intValue());
                return;
            default:
                return;
        }
        codedOutputStream.z1((ByteString) obj);
    }

    public static void T(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType V = fieldDescriptorLite.V();
        int d2 = fieldDescriptorLite.d();
        if (fieldDescriptorLite.M()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.a2()) {
                codedOutputStream.g2(d2, 2);
                int i2 = 0;
                for (Object p : list) {
                    i2 += p(V, p);
                }
                codedOutputStream.Z1(i2);
                for (Object S : list) {
                    S(codedOutputStream, V, S);
                }
                return;
            }
            for (Object R : list) {
                R(codedOutputStream, V, d2, R);
            }
        } else if (obj instanceof LazyField) {
            R(codedOutputStream, V, d2, ((LazyField) obj).p());
        } else {
            R(codedOutputStream, V, d2, obj);
        }
    }

    private void V(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.U1() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.M() || fieldDescriptorLite.a2()) {
            T(fieldDescriptorLite, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).p();
        }
        codedOutputStream.P1(((FieldDescriptorLite) entry.getKey()).d(), (MessageLite) value);
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> l(SmallSortedMap<T, Object> smallSortedMap, boolean z) {
        SmallSortedMap<T, Object> t = SmallSortedMap.t(16);
        for (int i2 = 0; i2 < smallSortedMap.k(); i2++) {
            m(t, smallSortedMap.j(i2), z);
        }
        for (Map.Entry<T, Object> m2 : smallSortedMap.m()) {
            m(t, m2, z);
        }
        return t;
    }

    private static <T extends FieldDescriptorLite<T>> void m(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).p();
        } else if (z && (value instanceof List)) {
            map.put(fieldDescriptorLite, new ArrayList((List) value));
            return;
        }
        map.put(fieldDescriptorLite, value);
    }

    /* access modifiers changed from: private */
    public static Object n(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int o(WireFormat.FieldType fieldType, int i2, Object obj) {
        int X0 = CodedOutputStream.X0(i2);
        if (fieldType == WireFormat.FieldType.GROUP) {
            X0 *= 2;
        }
        return X0 + p(fieldType, obj);
    }

    static int p(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f7145b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.j0(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.r0(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z0(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.b1(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x0(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.p0(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.n0(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.b0(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u0((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.C0((LazyField) obj) : CodedOutputStream.H0((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.h0((ByteString) obj) : CodedOutputStream.W0((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.h0((ByteString) obj) : CodedOutputStream.d0((byte[]) obj);
            case 13:
                return CodedOutputStream.Z0(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.O0(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.Q0(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.S0(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.U0(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.l0(((Internal.EnumLite) obj).d()) : CodedOutputStream.l0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int q(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType V = fieldDescriptorLite.V();
        int d2 = fieldDescriptorLite.d();
        if (!fieldDescriptorLite.M()) {
            return o(V, d2, obj);
        }
        int i2 = 0;
        List<Object> list = (List) obj;
        if (fieldDescriptorLite.a2()) {
            for (Object p : list) {
                i2 += p(V, p);
            }
            return CodedOutputStream.X0(d2) + i2 + CodedOutputStream.L0(i2);
        }
        for (Object o : list) {
            i2 += o(V, d2, o);
        }
        return i2;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> s() {
        return f7140e;
    }

    private int w(Map.Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptorLite.U1() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.M() || fieldDescriptorLite.a2()) {
            return q(fieldDescriptorLite, value);
        }
        boolean z = value instanceof LazyField;
        int d2 = ((FieldDescriptorLite) entry.getKey()).d();
        return z ? CodedOutputStream.A0(d2, (LazyField) value) : CodedOutputStream.E0(d2, (MessageLite) value);
    }

    public boolean B(T t) {
        if (!t.M()) {
            return this.f7141a.get(t) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f7141a.isEmpty();
    }

    public boolean D() {
        return this.f7142b;
    }

    public boolean E() {
        for (int i2 = 0; i2 < this.f7141a.k(); i2++) {
            if (!F(this.f7141a.j(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> F : this.f7141a.m()) {
            if (!F(F)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> H() {
        return this.f7143c ? new LazyField.LazyIterator(this.f7141a.entrySet().iterator()) : this.f7141a.entrySet().iterator();
    }

    public void I() {
        if (!this.f7142b) {
            this.f7141a.s();
            this.f7142b = true;
        }
    }

    public void J(FieldSet<T> fieldSet) {
        for (int i2 = 0; i2 < fieldSet.f7141a.k(); i2++) {
            K(fieldSet.f7141a.j(i2));
        }
        for (Map.Entry<T, Object> K : fieldSet.f7141a.m()) {
            K(K);
        }
    }

    public void O(T t, Object obj) {
        if (!t.M()) {
            Q(t.V(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object Q : arrayList) {
                Q(t.V(), Q);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.f7143c = true;
        }
        this.f7141a.put(t, obj);
    }

    public void P(T t, int i2, Object obj) {
        if (t.M()) {
            Object u = u(t);
            if (u != null) {
                Q(t.V(), obj);
                ((List) u).set(i2, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void U(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.f7141a.k(); i2++) {
            V(this.f7141a.j(i2), codedOutputStream);
        }
        for (Map.Entry<T, Object> V : this.f7141a.m()) {
            V(V, codedOutputStream);
        }
    }

    public void W(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.f7141a.k(); i2++) {
            Map.Entry<T, Object> j2 = this.f7141a.j(i2);
            T((FieldDescriptorLite) j2.getKey(), j2.getValue(), codedOutputStream);
        }
        for (Map.Entry next : this.f7141a.m()) {
            T((FieldDescriptorLite) next.getKey(), next.getValue(), codedOutputStream);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.f7141a.equals(((FieldSet) obj).f7141a);
    }

    public void h(T t, Object obj) {
        List list;
        if (t.M()) {
            Q(t.V(), obj);
            Object u = u(t);
            if (u == null) {
                list = new ArrayList();
                this.f7141a.put(t, list);
            } else {
                list = (List) u;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public int hashCode() {
        return this.f7141a.hashCode();
    }

    public void i() {
        this.f7141a.clear();
        this.f7143c = false;
    }

    public void j(T t) {
        this.f7141a.remove(t);
        if (this.f7141a.isEmpty()) {
            this.f7143c = false;
        }
    }

    /* renamed from: k */
    public FieldSet<T> clone() {
        FieldSet<T> M = M();
        for (int i2 = 0; i2 < this.f7141a.k(); i2++) {
            Map.Entry<T, Object> j2 = this.f7141a.j(i2);
            M.O((FieldDescriptorLite) j2.getKey(), j2.getValue());
        }
        for (Map.Entry next : this.f7141a.m()) {
            M.O((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        M.f7143c = this.f7143c;
        return M;
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> r() {
        return this.f7143c ? new LazyField.LazyIterator(this.f7141a.h().iterator()) : this.f7141a.h().iterator();
    }

    public Map<T, Object> t() {
        if (!this.f7143c) {
            return this.f7141a.p() ? this.f7141a : Collections.unmodifiableMap(this.f7141a);
        }
        SmallSortedMap<T, Object> l2 = l(this.f7141a, false);
        if (this.f7141a.p()) {
            l2.s();
        }
        return l2;
    }

    public Object u(T t) {
        Object obj = this.f7141a.get(t);
        return obj instanceof LazyField ? ((LazyField) obj).p() : obj;
    }

    public int v() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7141a.k(); i3++) {
            i2 += w(this.f7141a.j(i3));
        }
        for (Map.Entry<T, Object> w : this.f7141a.m()) {
            i2 += w(w);
        }
        return i2;
    }

    public Object x(T t, int i2) {
        if (t.M()) {
            Object u = u(t);
            if (u != null) {
                return ((List) u).get(i2);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int y(T t) {
        if (t.M()) {
            Object u = u(t);
            if (u == null) {
                return 0;
            }
            return ((List) u).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int z() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7141a.k(); i3++) {
            Map.Entry<T, Object> j2 = this.f7141a.j(i3);
            i2 += q((FieldDescriptorLite) j2.getKey(), j2.getValue());
        }
        for (Map.Entry next : this.f7141a.m()) {
            i2 += q((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        return i2;
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.f7141a = smallSortedMap;
        I();
    }

    /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 r2) {
        this(smallSortedMap);
    }

    private FieldSet(boolean z) {
        this(SmallSortedMap.t(0));
        I();
    }
}
