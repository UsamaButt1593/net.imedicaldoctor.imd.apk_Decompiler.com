package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {
    private final FieldType X;
    private final Field X2;
    private final Class<?> Y;
    private final int Y2;
    private final int Z;
    private final boolean Z2;
    private final boolean a3;
    private final OneofInfo b3;
    private final Field c3;
    private final Class<?> d3;
    private final Object e3;
    private final Internal.EnumVerifier f3;
    private final Field s;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7125a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.datastore.preferences.protobuf.FieldType[] r0 = androidx.datastore.preferences.protobuf.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7125a = r0
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7125a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7125a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE_LIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7125a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP_LIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Field f7126a;

        /* renamed from: b  reason: collision with root package name */
        private FieldType f7127b;

        /* renamed from: c  reason: collision with root package name */
        private int f7128c;

        /* renamed from: d  reason: collision with root package name */
        private Field f7129d;

        /* renamed from: e  reason: collision with root package name */
        private int f7130e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f7131f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7132g;

        /* renamed from: h  reason: collision with root package name */
        private OneofInfo f7133h;

        /* renamed from: i  reason: collision with root package name */
        private Class<?> f7134i;

        /* renamed from: j  reason: collision with root package name */
        private Object f7135j;

        /* renamed from: k  reason: collision with root package name */
        private Internal.EnumVerifier f7136k;

        /* renamed from: l  reason: collision with root package name */
        private Field f7137l;

        private Builder() {
        }

        public FieldInfo a() {
            OneofInfo oneofInfo = this.f7133h;
            if (oneofInfo != null) {
                return FieldInfo.g(this.f7128c, this.f7127b, oneofInfo, this.f7134i, this.f7132g, this.f7136k);
            }
            Object obj = this.f7135j;
            if (obj != null) {
                return FieldInfo.f(this.f7126a, this.f7128c, obj, this.f7136k);
            }
            Field field = this.f7129d;
            if (field != null) {
                boolean z = this.f7131f;
                Field field2 = this.f7126a;
                int i2 = this.f7128c;
                FieldType fieldType = this.f7127b;
                int i3 = this.f7130e;
                boolean z2 = this.f7132g;
                Internal.EnumVerifier enumVerifier = this.f7136k;
                return z ? FieldInfo.k(field2, i2, fieldType, field, i3, z2, enumVerifier) : FieldInfo.j(field2, i2, fieldType, field, i3, z2, enumVerifier);
            }
            Internal.EnumVerifier enumVerifier2 = this.f7136k;
            if (enumVerifier2 != null) {
                Field field3 = this.f7137l;
                return field3 == null ? FieldInfo.e(this.f7126a, this.f7128c, this.f7127b, enumVerifier2) : FieldInfo.i(this.f7126a, this.f7128c, this.f7127b, enumVerifier2, field3);
            }
            Field field4 = this.f7137l;
            return field4 == null ? FieldInfo.c(this.f7126a, this.f7128c, this.f7127b, this.f7132g) : FieldInfo.h(this.f7126a, this.f7128c, this.f7127b, field4);
        }

        public Builder b(Field field) {
            this.f7137l = field;
            return this;
        }

        public Builder c(boolean z) {
            this.f7132g = z;
            return this;
        }

        public Builder d(Internal.EnumVerifier enumVerifier) {
            this.f7136k = enumVerifier;
            return this;
        }

        public Builder e(Field field) {
            if (this.f7133h == null) {
                this.f7126a = field;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder f(int i2) {
            this.f7128c = i2;
            return this;
        }

        public Builder g(Object obj) {
            this.f7135j = obj;
            return this;
        }

        public Builder h(OneofInfo oneofInfo, Class<?> cls) {
            if (this.f7126a == null && this.f7129d == null) {
                this.f7133h = oneofInfo;
                this.f7134i = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder i(Field field, int i2) {
            this.f7129d = (Field) Internal.e(field, "presenceField");
            this.f7130e = i2;
            return this;
        }

        public Builder j(boolean z) {
            this.f7131f = z;
            return this;
        }

        public Builder k(FieldType fieldType) {
            this.f7127b = fieldType;
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }
    }

    private FieldInfo(Field field, int i2, FieldType fieldType, Class<?> cls, Field field2, int i3, boolean z, boolean z2, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, Field field3) {
        this.s = field;
        this.X = fieldType;
        this.Y = cls;
        this.Z = i2;
        this.X2 = field2;
        this.Y2 = i3;
        this.Z2 = z;
        this.a3 = z2;
        this.b3 = oneofInfo;
        this.d3 = cls2;
        this.e3 = obj;
        this.f3 = enumVerifier;
        this.c3 = field3;
    }

    private static boolean A(int i2) {
        return i2 != 0 && (i2 & (i2 + -1)) == 0;
    }

    public static Builder D() {
        return new Builder((AnonymousClass1) null);
    }

    private static void a(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i2);
        }
    }

    public static FieldInfo c(Field field, int i2, FieldType fieldType, boolean z) {
        FieldType fieldType2 = fieldType;
        a(i2);
        Field field2 = field;
        Internal.e(field, "field");
        Internal.e(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i2, fieldType, (Class<?>) null, (Field) null, 0, false, z, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo e(Field field, int i2, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        a(i2);
        Internal.e(field, "field");
        return new FieldInfo(field, i2, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
    }

    public static FieldInfo f(Field field, int i2, Object obj, Internal.EnumVerifier enumVerifier) {
        Object obj2 = obj;
        Internal.e(obj2, "mapDefaultEntry");
        a(i2);
        Internal.e(field, "field");
        return new FieldInfo(field, i2, FieldType.MAP, (Class<?>) null, (Field) null, 0, false, true, (OneofInfo) null, (Class<?>) null, obj2, enumVerifier, (Field) null);
    }

    public static FieldInfo g(int i2, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z, Internal.EnumVerifier enumVerifier) {
        FieldType fieldType2 = fieldType;
        a(i2);
        Internal.e(fieldType2, "fieldType");
        Internal.e(oneofInfo, "oneof");
        Internal.e(cls, "oneofStoredType");
        if (fieldType.j()) {
            return new FieldInfo((Field) null, i2, fieldType, (Class<?>) null, (Field) null, 0, false, z, oneofInfo, cls, (Object) null, enumVerifier, (Field) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Oneof is only supported for scalar fields. Field ");
        int i3 = i2;
        sb.append(i2);
        sb.append(" is of type ");
        sb.append(fieldType2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static FieldInfo h(Field field, int i2, FieldType fieldType, Field field2) {
        FieldType fieldType2 = fieldType;
        a(i2);
        Field field3 = field;
        Internal.e(field, "field");
        Internal.e(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i2, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo i(Field field, int i2, FieldType fieldType, Internal.EnumVerifier enumVerifier, Field field2) {
        a(i2);
        Internal.e(field, "field");
        return new FieldInfo(field, i2, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier, field2);
    }

    public static FieldInfo j(Field field, int i2, FieldType fieldType, Field field2, int i3, boolean z, Internal.EnumVerifier enumVerifier) {
        Field field3 = field2;
        a(i2);
        Field field4 = field;
        Internal.e(field, "field");
        Internal.e(fieldType, "fieldType");
        Internal.e(field3, "presenceField");
        if (field3 == null || A(i3)) {
            int i4 = i3;
            return new FieldInfo(field, i2, fieldType, (Class<?>) null, field2, i3, false, z, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i3);
    }

    public static FieldInfo k(Field field, int i2, FieldType fieldType, Field field2, int i3, boolean z, Internal.EnumVerifier enumVerifier) {
        Field field3 = field2;
        a(i2);
        Field field4 = field;
        Internal.e(field, "field");
        Internal.e(fieldType, "fieldType");
        Internal.e(field3, "presenceField");
        if (field3 == null || A(i3)) {
            int i4 = i3;
            return new FieldInfo(field, i2, fieldType, (Class<?>) null, field2, i3, true, z, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i3);
    }

    public static FieldInfo l(Field field, int i2, FieldType fieldType, Class<?> cls) {
        a(i2);
        Internal.e(field, "field");
        FieldType fieldType2 = fieldType;
        Internal.e(fieldType2, "fieldType");
        Class<?> cls2 = cls;
        Internal.e(cls2, "messageClass");
        return new FieldInfo(field, i2, fieldType2, cls2, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
    }

    public boolean C() {
        return this.Z2;
    }

    /* renamed from: b */
    public int compareTo(FieldInfo fieldInfo) {
        return this.Z - fieldInfo.Z;
    }

    public Field m() {
        return this.c3;
    }

    public Internal.EnumVerifier n() {
        return this.f3;
    }

    public Field o() {
        return this.s;
    }

    public int p() {
        return this.Z;
    }

    public Class<?> q() {
        return this.Y;
    }

    public Object r() {
        return this.e3;
    }

    public Class<?> s() {
        int i2 = AnonymousClass1.f7125a[this.X.ordinal()];
        if (i2 == 1 || i2 == 2) {
            Field field = this.s;
            return field != null ? field.getType() : this.d3;
        } else if (i2 == 3 || i2 == 4) {
            return this.Y;
        } else {
            return null;
        }
    }

    public OneofInfo u() {
        return this.b3;
    }

    public Class<?> v() {
        return this.d3;
    }

    public Field w() {
        return this.X2;
    }

    public int x() {
        return this.Y2;
    }

    public FieldType y() {
        return this.X;
    }

    public boolean z() {
        return this.a3;
    }
}
